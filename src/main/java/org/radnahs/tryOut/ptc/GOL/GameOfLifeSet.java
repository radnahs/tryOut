package org.radnahs.tryOut.ptc.GOL;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Model of the system. It is implemented the algorithm to calculate whether the
 * point should live or die
 * 
 * @author Martella Massimiliano
 *
 */
public class GameOfLifeSet {

	private ArrayList<Point> point = new ArrayList<Point>(0);
	private Dimension d_gameBoardSize;

	/**
	 * The class implements the algorithm to calculate whether, given a grid
	 * point, it should live or die depending on its neighbouring points
	 * 
	 * @param matrixSize
	 */
	public GameOfLifeSet(Dimension matrixSize) {
		this.d_gameBoardSize = matrixSize;
	}

	public int getSizeX() {
		return d_gameBoardSize.width;
	}

	public int getSizeY() {
		return d_gameBoardSize.height;
	}

	public ArrayList<Point> getMatrix() {
		return point;
	}

	public void setupMatrix(ArrayList<Point> matrix) {
		point = matrix;
	}

	/**
	 * Depending on the points neighbouring the point point T0, T1 instantly
	 * becomes "live" or "dead".
	 * 
	 * @param pointT0
	 *            : point to be evaluated
	 * @param pointBoard
	 *            : neighbouring points
	 * @param i
	 *            : x coordinate of the point that has to live
	 * @param j
	 *            : y coordinate of the point that has to live
	 * @return
	 */
	public Point computePoint(boolean pointT0, boolean[][] pointBoard, int i,
			int j) {
		int surrounding = 0;
		if (pointBoard[0][0])
			surrounding++;
		if (pointBoard[0][1])
			surrounding++;
		if (pointBoard[0][2])
			surrounding++;
		if (pointBoard[1][0])
			surrounding++;
		// pointBoard[1][1]
		if (pointBoard[1][2])
			surrounding++;
		if (pointBoard[2][0])
			surrounding++;
		if (pointBoard[2][1])
			surrounding++;
		if (pointBoard[2][2])
			surrounding++;

		if (pointT0) {
			// A cell m [i, j] that in state s (t) is live and has
			// two or three neighbouring cells live,
			// in state s (t + 1) remains live ("survives")

			if ((surrounding == 2) || (surrounding == 3))
				return new Point(i - 1, j - 1);
		} else {
			// A cell m [i, j] that in state s (t) is dead and has
			// Three neighbouring cells live,
			// In state s (t + 1) become live
			if (surrounding == 3)
				return new Point(i - 1, j - 1);
		}
		/**
		 * 1) a cell m [i, j] that in state s (t) is live and has zero or more a
		 * neighbouring cell live (and other dead), in state s (t + 1) becomes
		 * Dead ("die of loneliness")
		 *
		 * 2) a cell m [i, j] that in state s (t) is live and has four or more
		 * neighbouring cells live in the state s (t + 1) becomes dead ("dies
		 * over-population ")
		 */
		return null;
	}
}
