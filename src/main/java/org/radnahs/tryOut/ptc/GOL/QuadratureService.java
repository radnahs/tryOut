package org.radnahs.tryOut.ptc.GOL;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Thread QuadratureService launches Master that returns the status of all cells
 * "live" or "dead" on the grid. Next, update the grid on the model
 * (GameOfLifeSet) and view (GameOfLifeView)
 * 
 * @author Martella Massimiliano
 *
 */
public class QuadratureService extends Thread {

	private GameOfLifeView view;
	private GameOfLifeSet set;
	private Flag stopFlag;
	boolean[][] pointBoardT0;

	/**
	 * Main thread to check the status of the algorithm Game of Life
	 * 
	 * @param set
	 * @param view
	 * @param stopFlag
	 * @param matrix
	 */
	public QuadratureService(GameOfLifeSet set, GameOfLifeView view,
			Flag stopFlag, ArrayList<Point> matrix) {
		this.view = view;
		this.set = set;
		this.stopFlag = stopFlag;
		pointBoardT0 = new boolean[3][3];
	}

	@Override
	public void run() {
		try {

			if (set.getMatrix().isEmpty()) {
				stopFlag.set();
				view.changeState("No point in Matrix!");
			}
			while (!stopFlag.isSet()) {
				Thread.sleep(50);
				int poolSize = Runtime.getRuntime().availableProcessors() + 1;

				/*
				 * I create master which calculates the state of the cells. the
				 * result of all cells counted is saved in Variable result
				 * (ArrayList <Point>) that it is passed to both the Model that
				 * the View to update the status of the structure Data and the
				 * grid display screen
				 */
				Master master = new Master(set, poolSize, stopFlag);
				ArrayList<Point> result = master.compute();
				set.setupMatrix(result);
				view.setUpdated(result);

				if (stopFlag.isSet()) {
					view.changeState("Interrupted. Cell live: " + result.size());
				} else
					view.changeState(String.valueOf(result.size()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
