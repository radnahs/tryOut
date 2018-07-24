package org.radnahs.tryOut.ptc.GOL;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Interface InputListener
 * @author Martella Massimiliano
 *
 */
public interface InputListener {
	/**
	 * Start algorithm Game of Life
	 * @param matrix : matrix of alive cells
	 */
	void started(ArrayList<Point> matrix);
	
	/**
	 * Stop dell'algoritmo
	 */
	void stopped();
}
