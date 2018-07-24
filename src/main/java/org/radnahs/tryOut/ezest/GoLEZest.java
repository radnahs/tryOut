/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.ezest </p>
 * <p>File Name: GoLEZest.java</p>
 * <p>Create Date: Nov 18, 2015 </p>
 * <p>Create Time: 10:42:38 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ezest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @author Shantanu Sikdar
 */
public class GoLEZest {

	private static final Dimension defaultWindowSize = new Dimension(800, 600);
	private static final Dimension defaultMatrixSize = new Dimension(79, 49);
	private static final int blockSize = 10;

	public static void main(String[] args) {
		// Model
		GoLSet set = new GoLSet(defaultMatrixSize);
		// View
		GoLView view = new GoLView(defaultWindowSize, defaultMatrixSize, blockSize);
		// Controller
		Controller controller = new Controller(set, view);
		view.addListener(controller);
		view.setVisible(true);
	}
}

class GoLSet {
	private ArrayList<Point> point = new ArrayList<Point>(0);
	private Dimension golBoardSize;

	public GoLSet(Dimension matrixSize) {
		this.golBoardSize = matrixSize;
	}

	public int getSizeX() {
		return golBoardSize.width;
	}

	public int getSizeY() {
		return golBoardSize.height;
	}

	public ArrayList<Point> getMatrix() {
		return point;
	}

	public void setupMatrix(ArrayList<Point> matrix) {
		point = matrix;
	}

	public Point computePoint(boolean pointT0, boolean[][] pointBoard, int i, int j) {
		int surrounding = 0;
		if (pointBoard[0][0]) {
			surrounding++;
		}
		if (pointBoard[0][1]) {
			surrounding++;
		}
		if (pointBoard[0][2]) {
			surrounding++;
		}
		if (pointBoard[1][0]) {
			surrounding++;
		}
		if (pointBoard[1][2]) {
			surrounding++;
		}
		if (pointBoard[2][0]) {
			surrounding++;
		}
		if (pointBoard[2][1]) {
			surrounding++;
		}
		if (pointBoard[2][2]) {
			surrounding++;
		}
		if (pointT0) {
			if ((surrounding == 2) || (surrounding == 3)) {
				return new Point(i - 1, j - 1);
			}
		} else {
			if (surrounding == 3) {
				return new Point(i - 1, j - 1);
			}
		}
		return null;
	}

}

class GoLView extends JFrame implements ActionListener, MouseMotionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<InputListener> listeners;
	private GoLPanel setPanel;
	private JButton startButton;
	private JButton stopButton;
	private JTextField state;

	public GoLView(Dimension windowsSize, Dimension matrixSize, int blockSize) {
		super("GoL Viewer Small Grid");
		setSize(windowsSize);

		// Centre the window in the middle of the screen
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);

		listeners = new ArrayList<InputListener>();

		startButton = new JButton("start");
		stopButton = new JButton("stop");

		stopButton.setEnabled(false);

		JPanel controlPanel = new JPanel();

		controlPanel.add(startButton);
		controlPanel.add(stopButton);

		setPanel = new GoLPanel(matrixSize, blockSize);
		setPanel.setSize(matrixSize);

		addMouseMotionListener(this);
		addMouseListener(this);

		JPanel infoPanel = new JPanel();
		state = new JTextField(20);
		state.setText("Ready...");
		state.setEditable(false);
		infoPanel.add(new JLabel("State"));
		infoPanel.add(state);
		JPanel cp = new JPanel();
		LayoutManager layout = new BorderLayout();
		cp.setLayout(layout);
		cp.add(BorderLayout.NORTH, controlPanel);

		setPanel.gosperGun();

		cp.add(BorderLayout.CENTER, setPanel);
		cp.add(BorderLayout.SOUTH, infoPanel);
		setContentPane(cp);

		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void setUpdated(final ArrayList<Point> result) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setPanel.updateMatrix(result);
			}
		});
	}

	public void changeState(final String s) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				state.setText(s);
			}
		});
	}

	public void addListener(InputListener l) {
		listeners.add(l);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		setPanel.addPoint(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		if (cmd.equals("start")) {
			notifyStarted();
			startButton.setEnabled(false);
			stopButton.setEnabled(true);
		} else if (cmd.equals("stop")) {
			notifyStopped();
			startButton.setEnabled(true);
			stopButton.setEnabled(false);
		}
	}

	private void notifyStarted() {
		for (InputListener l : listeners) {
			l.started(setPanel.getMatrix());
		}
	}

	private void notifyStopped() {
		for (InputListener l : listeners) {
			l.stopped();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e))
			setPanel.addPoint(e);
		if (SwingUtilities.isRightMouseButton(e))
			setPanel.removePoint(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}

interface InputListener {
	void started(ArrayList<Point> matrix);

	void stopped();
}

class Controller implements InputListener {

	private GoLView view;
	private GoLSet set;
	private Flag stopFlag;

	public Controller(GoLSet set, GoLView view) {
		this.set = set;
		this.view = view;
	}

	@Override
	public void started(ArrayList<Point> matrix) {
		set.setupMatrix(matrix);
		stopFlag = new Flag();
		new QuadratureService(set, view, stopFlag, matrix).start();

	}

	@Override
	public void stopped() {
		stopFlag.set();
	}
}

class QuadratureService extends Thread {

	private GoLView view;
	private GoLSet set;
	private Flag stopFlag;
	boolean[][] pointBoardT0;

	public QuadratureService(GoLSet set, GoLView view, Flag stopFlag, ArrayList<Point> matrix) {
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

class Flag {

	private boolean isSet;

	public Flag() {
		isSet = false;
	}

	public synchronized void set() {
		isSet = true;
	}

	public synchronized boolean isSet() {
		return isSet;
	}

	public synchronized void reset() {
		isSet = false;
	}
}

class Master extends Thread {

	private ExecutorService executor;
	boolean[][] golBoard;
	boolean[][] pointBoardT0;
	GoLSet set;
	Flag stopFlag;

	public Master(GoLSet set, int poolSize, Flag stopFlag) {
		this.executor = Executors.newFixedThreadPool(poolSize);
		this.set = set;
		this.stopFlag = stopFlag;
	}

	public ArrayList<Point> compute() throws InterruptedException {

		ArrayList<Future<Point>> pointT1 = new ArrayList<Future<Point>>();
		golBoard = new boolean[set.getSizeX() + 1][set.getSizeY() + 1];
		for (Point current : set.getMatrix()) {
			if (current != null)
				golBoard[current.x + 1][current.y + 1] = true;
		}
		for (int i = 1; i < golBoard.length - 1; i++) {
			for (int j = 1; j < golBoard[0].length - 1; j++) {
				try {
					pointBoardT0 = new boolean[3][3];
					// load points near instant T0
					pointBoardT0[0][0] = golBoard[i - 1][j - 1];
					pointBoardT0[0][1] = golBoard[i - 1][j];
					pointBoardT0[0][2] = golBoard[i - 1][j + 1];
					pointBoardT0[1][0] = golBoard[i][j - 1];
					pointBoardT0[1][2] = golBoard[i][j + 1];
					pointBoardT0[2][0] = golBoard[i + 1][j - 1];
					pointBoardT0[2][1] = golBoard[i + 1][j];
					pointBoardT0[2][2] = golBoard[i + 1][j + 1];

					int check = 0;
					for (boolean state[] : pointBoardT0) {
						for (boolean b : state) {
							if (b)
								check++;
						}
					}

					if (check != 0) {
						Future<Point> res = executor
								.submit(new ComputeTask(set, golBoard[i][j], pointBoardT0, i, j, stopFlag));
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

		executor.shutdown();
		return point;
	}
}

class GoLPanel extends JPanel implements ComponentListener {

	private static final long serialVersionUID = 1L;
	private Dimension golBoardSize = null;
	private int blockSize;
	private ArrayList<Point> point = new ArrayList<Point>(0);

	public GoLPanel(Dimension matrixSize, int blockSize) {
		golBoardSize = matrixSize;
		this.blockSize = blockSize;

		addComponentListener(this);
	}

	public void updateMatrix(ArrayList<Point> result) {
		this.point = result;
		repaint();
	}

	public void addPoint(MouseEvent me) {
		int x = me.getPoint().x / 10 - 1;
		int y = me.getPoint().y / 10 - 7;
		if ((x >= 0) && (x < golBoardSize.width) && (y >= 0) && (y < golBoardSize.height)) {
			addPoint(x, y);
		}
	}

	public void addPoint(int x, int y) {
		if (!point.contains(new Point(x, y)))
			point.add(new Point(x, y));
		repaint();
	}

	public ArrayList<Point> getMatrix() {
		return point;
	}

	public void removePoint(int x, int y) {
		point.remove(new Point(x, y));
	}

	public void removePoint(MouseEvent me) {
		int x = me.getPoint().x / 10 - 1;
		int y = me.getPoint().y / 10 - 7;
		if (point.contains(new Point(x, y)))
			point.remove(new Point(x, y));
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		try {
			for (Point newPoint : point) {
				// Draw new point
				g.setColor(Color.blue);
				g.fillRect(blockSize + (blockSize * newPoint.x), blockSize + (blockSize * newPoint.y), blockSize,
						blockSize);
			}
		} catch (ConcurrentModificationException cme) {
		}
		// Setup grid
		g.setColor(Color.BLACK);
		for (int i = 0; i <= golBoardSize.width; i++) {
			g.drawLine(((i * blockSize) + blockSize), blockSize, (i * blockSize) + blockSize,
					blockSize + (blockSize * golBoardSize.height));
		}
		for (int i = 0; i <= golBoardSize.height; i++) {
			g.drawLine(blockSize, ((i * blockSize) + blockSize), blockSize * (golBoardSize.width + 1),
					((i * blockSize) + blockSize));
		}

	}

	public void gosperGun() {
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

	private void updateArraySize() {
		ArrayList<Point> removeList = new ArrayList<Point>(0);
		for (Point current : point) {
			if ((current.x > golBoardSize.width - 1) || (current.y > golBoardSize.height - 1)) {
				removeList.add(current);
			}
		}
		if (!removeList.isEmpty()) {
			point.removeAll(removeList);
			repaint();
		}
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// Setup the gol board size with proper boundries
		golBoardSize = new Dimension(getWidth() / blockSize - 2, getHeight() / blockSize - 2);
		updateArraySize();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
	}

	@Override
	public void componentShown(ComponentEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent e) {
	}

}

class ComputeTask implements Callable<Point> {

	private GoLSet result;
	boolean pointT0;
	boolean[][] pointBoard;
	int i, j;
	private Flag stopFlag;

	public ComputeTask(GoLSet set, boolean golBoardT0, boolean[][] pointBoard, int i, int j, Flag stopFlag) {
		this.pointBoard = pointBoard;
		this.pointT0 = golBoardT0;
		this.i = i;
		this.j = j;
		this.result = set;
		this.stopFlag = stopFlag;
	}

	/*private void log(String msg) {
		synchronized (System.out) {
			System.out.println(msg);
		}
	}*/

	@Override
	public Point call() {
		Point pointT1 = null;
		try {
			pointT1 = result.computePoint(pointT0, pointBoard, i, j);
			if (stopFlag.isSet()) {
			} /*
				 * else { }
				 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return pointT1;
	}

}
