package org.radnahs.tryOut.ptc.GOL;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JPanel;

/**
 * Panel in which the grid is drawn. Implements Component Listener to update the
 * grid size according to the size of the view.
 * 
 * @author Martella Massimiliano
 *
 */
public class GameOfLifePanel extends JPanel implements ComponentListener {

	private Dimension d_gameBoardSize = null;
	private int blockSize;
	private ArrayList<Point> point = new ArrayList<Point>(0);

	/**
	 * The panel is constructed due to its size and to the size of the cell to
	 * be coloured
	 * 
	 * @param matrixSize
	 *            : dimension of grid
	 * @param blockSize
	 *            : dimension of cell
	 */
	public GameOfLifePanel(Dimension matrixSize, int blockSize) {
		d_gameBoardSize = matrixSize;
		this.blockSize = blockSize;

		addComponentListener(this);
	}

	/**
	 * Update the grid
	 * 
	 * @param result
	 */
	public void updateMatrix(ArrayList<Point> result) {
		this.point = result;
		repaint();
	}

	/**
	 * Update the cell on the grid
	 * 
	 * @param me
	 */
	public void addPoint(MouseEvent me) {
		/*
		 * Centre the point depending on how big the size of the point
		 */
		int x = me.getPoint().x / 10 - 1;
		int y = me.getPoint().y / 10 - 7;
		if ((x >= 0) && (x < d_gameBoardSize.width) && (y >= 0)
				&& (y < d_gameBoardSize.height)) {
			addPoint(x, y);
		}
	}

	/**
	 * Add point into the data structure "point" 
	 * 
	 * @param x
	 * @param y
	 */
	public void addPoint(int x, int y) {
		if (!point.contains(new Point(x, y)))
			point.add(new Point(x, y));
		repaint();
	}

	/** 
	 * @return ArrayList<Point> point;
	 */
	public ArrayList<Point> getMatrix() {
		return point;
	}

	/**
	 * Delete point on the grid
	 * 
	 * @param x
	 * @param y
	 */
	public void removePoint(int x, int y) {
		point.remove(new Point(x, y));
	}

	/**
	 * Delete point on the grid
	 * 
	 * @param me
	 */
	public void removePoint(MouseEvent me) {
		int x = me.getPoint().x / 10 - 1;
		int y = me.getPoint().y / 10 - 7;
		if (point.contains(new Point(x, y)))
			point.remove(new Point(x, y));
		repaint();
	}

	/**
	 * Draw the virgin grid
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		try {
			for (Point newPoint : point) {
				// Draw new point
				g.setColor(Color.blue);
				g.fillRect(blockSize + (blockSize * newPoint.x), blockSize
						+ (blockSize * newPoint.y), blockSize, blockSize);
			}
		} catch (ConcurrentModificationException cme) {
		}
		// Setup grid
		g.setColor(Color.BLACK);
		for (int i = 0; i <= d_gameBoardSize.width; i++) {
			g.drawLine(((i * blockSize) + blockSize), blockSize,
					(i * blockSize) + blockSize, blockSize
							+ (blockSize * d_gameBoardSize.height));
		}
		for (int i = 0; i <= d_gameBoardSize.height; i++) {
			g.drawLine(blockSize, ((i * blockSize) + blockSize), blockSize
					* (d_gameBoardSize.width + 1),
					((i * blockSize) + blockSize));
		}

	}

	/**
	 * Add in the grid the Gosper Glider Gun like a test
	 * {@link https://en.wikipedia.org/wiki/Gun_(cellular_automaton)}
	 */
	public void CannoneAliantiGosper() {
		// Bloc
		addPoint(22, 24);
		addPoint(22, 25);
		addPoint(23, 24);
		addPoint(23, 25);

		//
		addPoint(32, 24);
		addPoint(32, 25);
		addPoint(32, 26);
		addPoint(33, 23);
		addPoint(33, 27);
		addPoint(34, 22);
		addPoint(35, 22);
		addPoint(34, 28);
		addPoint(35, 28);
		addPoint(36, 25);
		addPoint(37, 23);
		addPoint(37, 27);
		addPoint(38, 24);
		addPoint(38, 25);
		addPoint(38, 26);
		addPoint(39, 25);

		//
		addPoint(42, 24);
		addPoint(42, 23);
		addPoint(42, 22);
		addPoint(43, 24);
		addPoint(43, 23);
		addPoint(43, 22);
		addPoint(44, 21);
		addPoint(44, 25);
		addPoint(46, 21);
		addPoint(46, 20);
		addPoint(46, 25);
		addPoint(46, 26);

		//
		addPoint(56, 22);
		addPoint(56, 23);
		addPoint(57, 22);
		addPoint(57, 23);
	}

	/**
	 * Update list of point on the grid when the grid is resized
	 */
	private void updateArraySize() {
		ArrayList<Point> removeList = new ArrayList<Point>(0);
		for (Point current : point) {
			if ((current.x > d_gameBoardSize.width - 1)
					|| (current.y > d_gameBoardSize.height - 1)) {
				removeList.add(current);
			}
		}
		if (!removeList.isEmpty()) {
			point.removeAll(removeList);
			repaint();
		}
	}

	/**
	 * Set the grid size according to the size view
	 */
	@Override
	public void componentResized(ComponentEvent e) {
		// Setup the game board size with proper boundries
		d_gameBoardSize = new Dimension(getWidth() / blockSize - 2, getHeight()
				/ blockSize - 2);
		updateArraySize();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

}
