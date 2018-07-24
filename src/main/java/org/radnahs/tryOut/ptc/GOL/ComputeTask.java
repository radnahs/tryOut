package org.radnahs.tryOut.ptc.GOL;

import java.awt.Point;
import java.util.concurrent.Callable;

/**
 * The class implements Callable<Point>: it calculates:
 * - point at time T0
 * - point at time T1
 * 
 * @author Martella Massimiliano
 *
 */
public class ComputeTask implements Callable<Point> {

	private GameOfLifeSet result;
	boolean pointT0;
	boolean[][] pointBoard;
	int i, j;
	private Flag stopFlag;

	/**
	 * Constructor
	 * @param set : model of algorithm
	 * @param gameBoardT0 : point at instantly T0
	 * @param pointBoard : neighbours point instantly T0
	 * @param i : x coordinate of the new point
	 * @param j : j coordinate of the new point
	 * @param stopFlag : monitor
	 */
	public ComputeTask(GameOfLifeSet set, boolean gameBoardT0,
			boolean[][] pointBoard, int i, int j, Flag stopFlag) {
		this.pointBoard = pointBoard;
		this.pointT0 = gameBoardT0;
		this.i = i;
		this.j = j;
		this.result = set;
		this.stopFlag = stopFlag;
	}

	private void log(String msg) {
		synchronized (System.out) {
			System.out.println(msg);
		}
	}

	/*
	 * Return status instantly point T1
	 * */
	@Override
	public Point call() {
		Point pointT1 = null;
		try {
			pointT1 = result.computePoint(pointT0, pointBoard, i, j);
			if (stopFlag.isSet()) {
				// log("task interrupted");
			} else {
				// log("task completed");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return pointT1;
	}

}
