package org.radnahs.tryOut.ptc.GOL;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The problem is divided into Tasks, as many as the points on the grid. Each
 * point is calculated, according to his neighbours, whether to live or die
 * 
 * @author Martella Massimiliano
 *
 */
public class Master extends Thread {

	private ExecutorService executor;
	boolean[][] gameBoard;
	boolean[][] pointBoardT0;
	GameOfLifeSet set;
	Flag stopFlag;

	/**
	 * 
	 * @param set
	 *            : model algorithm
	 * @param poolSize
	 *            : number of Thread
	 * @param stopFlag
	 *            : monitor start and stop
	 */
	public Master(GameOfLifeSet set, int poolSize, Flag stopFlag) {
		this.executor = Executors.newFixedThreadPool(poolSize);
		// this.executor = Executors.newCachedThreadPool();
		this.set = set;
		this.stopFlag = stopFlag;
	}

	/**
	 * The function returns the list of the living cells of the game
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public ArrayList<Point> compute() throws InterruptedException {

		ArrayList<Future<Point>> pointT1 = new ArrayList<Future<Point>>();
		gameBoard = new boolean[set.getSizeX() + 1][set.getSizeY() + 1];
		for (Point current : set.getMatrix()) {
			if (current != null)
				gameBoard[current.x + 1][current.y + 1] = true;
		}
		for (int i = 1; i < gameBoard.length - 1; i++) {
			for (int j = 1; j < gameBoard[0].length - 1; j++) {
				try {
					pointBoardT0 = new boolean[3][3];
					// load points near instant T0
					pointBoardT0[0][0] = gameBoard[i - 1][j - 1];
					pointBoardT0[0][1] = gameBoard[i - 1][j];
					pointBoardT0[0][2] = gameBoard[i - 1][j + 1];
					pointBoardT0[1][0] = gameBoard[i][j - 1];
					// pointBoard[1][1] (me)
					pointBoardT0[1][2] = gameBoard[i][j + 1];
					pointBoardT0[2][0] = gameBoard[i + 1][j - 1];
					pointBoardT0[2][1] = gameBoard[i + 1][j];
					pointBoardT0[2][2] = gameBoard[i + 1][j + 1];

					/*
					 * If the point is evaluated "false" (white grid) then it is
					 * useless to create the res object type Future <Point> as
					 * it will always be "false" and the grid does not change.
					 */
					int check = 0;
					for (boolean state[] : pointBoardT0) {
						for (boolean b : state) {
							if (b)
								check++;
						}
					}

					if (check != 0) {
						/*
						 * I create the object of res futures; that is a
						 * "promise" of Point ("live" or. "Dead")
						 */
						Future<Point> res = executor.submit(new ComputeTask(
								set, gameBoard[i][j], pointBoardT0, i, j,
								stopFlag));
						// The result I insert it in the list point T1 (at time
						// T1)
						pointT1.add(res);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		ArrayList<Point> point = new ArrayList<Point>();
		for (Future<Point> future : pointT1) {
			try {
				if (future.get() != null)
					point.add(future.get());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		/*
		 * Once you have all the points, I run the shutdown of the executor and
		 * give back the list of official points
		 */
		executor.shutdown();
		return point;
	}
}
