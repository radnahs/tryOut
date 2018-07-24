package org.radnahs.tryOut.ptc.GOL;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * GameOfLifeView is the View of the project. Implements: - ActionListener
 * (Listeners) - MouseMotionListener (mouse button pressed, drawing on the grid)
 * - MouseListener (when pressing, drawing a point on the grid)
 * 
 * @author Martella Massimiliano
 *
 */
public class GameOfLifeView extends JFrame implements ActionListener,
		MouseMotionListener, MouseListener {

	private ArrayList<InputListener> listeners;
	private GameOfLifePanel setPanel;
	private JButton startButton;
	private JButton stopButton;
	private JTextField state;

	public GameOfLifeView(Dimension windowsSize, Dimension matrixSize,
			int blockSize) {
		super("Game Of Life Viewer Small Grid");
		setSize(windowsSize);

		// Centre the window in the middle of the screen
		setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);

		listeners = new ArrayList<InputListener>();

		startButton = new JButton("start");
		stopButton = new JButton("stop");

		// When start the program, the Button "stop" is not enabled
		stopButton.setEnabled(false);

		JPanel controlPanel = new JPanel();

		controlPanel.add(startButton);
		controlPanel.add(stopButton);

		setPanel = new GameOfLifePanel(matrixSize, blockSize);
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

		// Add in the grid the Gosper Glider Gun like a test
		setPanel.CannoneAliantiGosper();

		cp.add(BorderLayout.CENTER, setPanel);
		cp.add(BorderLayout.SOUTH, infoPanel);
		setContentPane(cp);

		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	/**
	 * Through the method invokeLater is passed to EventDispatchThread the task
	 * of updating the screen grid
	 * 
	 * @param result
	 *            : list of point to update
	 */
	public void setUpdated(final ArrayList<Point> result) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setPanel.updateMatrix(result);
			}
		});
	}

	/**
	 * Through the method invokeLater is passed to EventDispatchThread the task
	 * of updating the screen video
	 * 
	 * @param s
	 *            : string to be printed in the TextBox of view
	 */
	public void changeState(final String s) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				state.setText(s);
			}
		});
	}

	/**
	 * Sets the listeners
	 * 
	 * @param l
	 */
	public void addListener(InputListener l) {
		listeners.add(l);
	}

	/**
	 * Whenever the mouse is moved while pressing the button sinisto, it draws a
	 * point on the grid
	 */
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

	/**
	 * Notified to the controller, passing the grill, leaving the algorithm
	 * 
	 */
	private void notifyStarted() {
		for (InputListener l : listeners) {
			l.started(setPanel.getMatrix());
		}
	}

	/**
	 * Notified to the controller to stop
	 */
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

	/**
	 * On release of left mouse button drawing a point on the grid
	 */
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
