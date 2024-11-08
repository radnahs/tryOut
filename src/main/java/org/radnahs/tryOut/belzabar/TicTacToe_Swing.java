/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: org.radnahs.tryOut.belzabar </p>
 * <p>File Name: TicTacToe.java</p>
 * <p>Create Date: Jan 7, 2016 </p>
 * <p>Create Time: 1:48:22 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.belzabar;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Tic-tac-toe (also known as Noughts and crosses or Xs and Os) is a paper-and-pencil game for two players, X and O, who take turns marking
 *  the spaces in a 3x3 grid. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the 
 *  game.
 *  Design an online version of this game with one human and one computer player. The player who starts is chosen randomly. Objective 
 *  of the program is to ensure that the computer always wins or draws (and never loses). 
 *  Define the algorithm and write pseudo-code for implementing your algorithm. A simple algorithm and pseudo code are provided 
 *  as an example. This algorithm does not guarantee a win for the computer. Your objective is to define an algorithm that guarantees 
 *  a win for the computer and provides better space and time complexity (big-O notation).

 Extra credits for:
 1. Providing the big-O space and time complexity of your algorithm.
 2. Writing a working program in XXX programming language.
 3. Writing elegant code with liberal commenting and use of constructs that are more readable.

 Sample Algorithm:
 1. Randomly select which player makes the first move.
 Repeat the following steps till the game is won by either player or there is a draw

 2. If it is the human player's move,
 Accept a move in any one of the empty slots. If the human's move results in winning for the human (three of a type in a row/column), 
 the human is declared winner (END)
 else
 // Computer has to move. Move to step 3.
 3. Scan each row and column to identify if there are two moves in a row/column from the computer player such that adding another move in 
 the third open slot in the row/column would lead to a win for the computer. If such a row is found, make the move and win the game (END); 
 Else,
 4. Scan each row and column to identify if there are two moves in a row/column from the human player such that adding another move in the 
 third open slot in the row/column would lead to a win for the human. If such a row is found, block the row to prevent the human player from winning; 
 Else,
 5. Make a move that creates a fork if possible; 
 Else,

 Note: A fork is a move that provides two possible winning moves in the next try, thereby guaranteeing a win since the other player can at best 
 block one of them). 
 An opportunity for a fork is detected by iterating through all rows/columns on the board. If a row/column contained only one of a player's move, 
 and nothing else, then iterate thorough all overlapping rows/columns (rows/columns that have a common cell between them) and try to find 
 one that contains exactly one of the same player�s move, and nothing else. if this is found and it�s not the position in which the two rows/columns 
 overlap, then you've found a fork. If a move is made at the position in which the two rows/columns overlap, a fork is created.

 6. Detect if the human player can create a fork in the next move. If yes, block this opportunity by making a move at the position that 
 could lead to a fork; 
 Else,
 7. If the center position is open, make a move there; 
 Else,
 8. If there�s a move from the human player in one of the corner and if the opposite corner is available, make a move in the opposite corner; 
 Else,
 9. Make a move in an empty corner, if one is available; 
 Else,
 10. Make a move in any available position.
 11. If all the positions are taken after the last move, the game has ended in a draw. (END)
 */

/**
 * @author Shantanu Sikdar
 * 
 */
public class TicTacToe_Swing extends JFrame {
	
	// Named-constants for the game board
	   public static final int ROWS = 3;  // ROWS by COLS cells
	   public static final int COLS = 3;
	 
	   // Named-constants of the various dimensions used for graphics drawing
	   public static final int CELL_SIZE = 100; // cell width and height (square)
	   public static final int CANVAS_WIDTH = CELL_SIZE * COLS;  // the drawing canvas
	   public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
	   public static final int GRID_WIDTH = 8;                   // Grid-line's width
	   public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2; // Grid-line's half-width
	   // Symbols (cross/nought) are displayed inside a cell, with padding from border
	   public static final int CELL_PADDING = CELL_SIZE / 6;
	   public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2; // width/height
	   public static final int SYMBOL_STROKE_WIDTH = 8; // pen's stroke width
	 
	   // Use an enumeration (inner class) to represent the various states of the game
	   public enum GameState {
	      PLAYING, DRAW, CROSS_WON, NOUGHT_WON
	   }
	   private GameState currentState;  // the current game state
	 
	   // Use an enumeration (inner class) to represent the seeds and cell contents
	   public enum Seed {
	      EMPTY, CROSS, NOUGHT
	   }
	   private Seed currentPlayer;  // the current player
	 
	   private Seed[][] board   ; // Game board of ROWS-by-COLS cells
	   private DrawCanvas canvas; // Drawing canvas (JPanel) for the game board
	   private JLabel statusBar;  // Status Bar
	 
	   /** Constructor to setup the game and the GUI components */
	   public TicTacToe_Swing() {
	      canvas = new DrawCanvas();  // Construct a drawing canvas (a JPanel)
	      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
	 
	      // The canvas (JPanel) fires a MouseEvent upon mouse-click
	      canvas.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {  // mouse-clicked handler
	            int mouseX = e.getX();
	            int mouseY = e.getY();
	            // Get the row and column clicked
	            int rowSelected = mouseY / CELL_SIZE;
	            int colSelected = mouseX / CELL_SIZE;
	 
	            if (currentState == GameState.PLAYING) {
	               if (rowSelected >= 0 && rowSelected < ROWS && colSelected >= 0
	                     && colSelected < COLS && board[rowSelected][colSelected] == Seed.EMPTY) {
	                  board[rowSelected][colSelected] = currentPlayer; // Make a move
	                  updateGame(currentPlayer, rowSelected, colSelected); // update state
	                  // Switch player
	                  currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
	               }
	            } else {       // game over
	               initGame(); // restart the game
	            }
	            // Refresh the drawing canvas
	            repaint();  // Call-back paintComponent().
	         }
	      });
	 
	      // Setup the status bar (JLabel) to display status message
	      statusBar = new JLabel("  ");
	      statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
	      statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
	 
	      Container cp = getContentPane();
	      cp.setLayout(new BorderLayout());
	      cp.add(canvas, BorderLayout.CENTER);
	      cp.add(statusBar, BorderLayout.PAGE_END); // same as SOUTH
	 
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();  // pack all the components in this JFrame
	      setTitle("Tic Tac Toe");
	      setVisible(true);  // show this JFrame
	 
	      board = new Seed[ROWS][COLS]; // allocate array
	      initGame(); // initialize the game board contents and game variables
	   }
	 
	   /** Initialize the game-board contents and the status */
	   public void initGame() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            board[row][col] = Seed.EMPTY; // all cells empty
	         }
	      }
	      currentState = GameState.PLAYING; // ready to play
	      currentPlayer = Seed.CROSS;       // cross plays first
	   }
	 
	   /** Update the currentState after the player with "theSeed" has placed on
	       (rowSelected, colSelected). */
	   public void updateGame(Seed theSeed, int rowSelected, int colSelected) {
	      if (hasWon(theSeed, rowSelected, colSelected)) {  // check for win
	         currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
	      } else if (isDraw()) {  // check for draw
	         currentState = GameState.DRAW;
	      }
	      // Otherwise, no change to current state (still GameState.PLAYING).
	   }
	 
	   /** Return true if it is a draw (i.e., no more empty cell) */
	   public boolean isDraw() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            if (board[row][col] == Seed.EMPTY) {
	               return false; // an empty cell found, not draw, exit
	            }
	         }
	      }
	      return true;  // no more empty cell, it's a draw
	   }
	 
	   /** Return true if the player with "theSeed" has won after placing at
	       (rowSelected, colSelected) */
	   public boolean hasWon(Seed theSeed, int rowSelected, int colSelected) {
	      return (board[rowSelected][0] == theSeed  // 3-in-the-row
	            && board[rowSelected][1] == theSeed
	            && board[rowSelected][2] == theSeed
	       || board[0][colSelected] == theSeed      // 3-in-the-column
	            && board[1][colSelected] == theSeed
	            && board[2][colSelected] == theSeed
	       || rowSelected == colSelected            // 3-in-the-diagonal
	            && board[0][0] == theSeed
	            && board[1][1] == theSeed
	            && board[2][2] == theSeed
	       || rowSelected + colSelected == 2  // 3-in-the-opposite-diagonal
	            && board[0][2] == theSeed
	            && board[1][1] == theSeed
	            && board[2][0] == theSeed);
	   }
	 
	   /**
	    *  Inner class DrawCanvas (extends JPanel) used for custom graphics drawing.
	    */
	   class DrawCanvas extends JPanel {
	      @Override
	      public void paintComponent(Graphics g) {  // invoke via repaint()
	         super.paintComponent(g);    // fill background
	         setBackground(Color.WHITE); // set its background color
	 
	         // Draw the grid-lines
	         g.setColor(Color.LIGHT_GRAY);
	         for (int row = 1; row < ROWS; ++row) {
	            g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDHT_HALF,
	                  CANVAS_WIDTH-1, GRID_WIDTH, GRID_WIDTH, GRID_WIDTH);
	         }
	         for (int col = 1; col < COLS; ++col) {
	            g.fillRoundRect(CELL_SIZE * col - GRID_WIDHT_HALF, 0,
	                  GRID_WIDTH, CANVAS_HEIGHT-1, GRID_WIDTH, GRID_WIDTH);
	         }
	 
	         // Draw the Seeds of all the cells if they are not empty
	         // Use Graphics2D which allows us to set the pen's stroke
	         Graphics2D g2d = (Graphics2D)g;
	         g2d.setStroke(new BasicStroke(SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND,
	               BasicStroke.JOIN_ROUND));  // Graphics2D only
	         for (int row = 0; row < ROWS; ++row) {
	            for (int col = 0; col < COLS; ++col) {
	               int x1 = col * CELL_SIZE + CELL_PADDING;
	               int y1 = row * CELL_SIZE + CELL_PADDING;
	               if (board[row][col] == Seed.CROSS) {
	                  g2d.setColor(Color.RED);
	                  int x2 = (col + 1) * CELL_SIZE - CELL_PADDING;
	                  int y2 = (row + 1) * CELL_SIZE - CELL_PADDING;
	                  g2d.drawLine(x1, y1, x2, y2);
	                  g2d.drawLine(x2, y1, x1, y2);
	               } else if (board[row][col] == Seed.NOUGHT) {
	                  g2d.setColor(Color.BLUE);
	                  g2d.drawOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
	               }
	            }
	         }
	 
	         // Print status-bar message
	         if (currentState == GameState.PLAYING) {
	            statusBar.setForeground(Color.BLACK);
	            if (currentPlayer == Seed.CROSS) {
	               statusBar.setText("X's Turn");
	            } else {
	               statusBar.setText("O's Turn");
	            }
	         } else if (currentState == GameState.DRAW) {
	            statusBar.setForeground(Color.RED);
	            statusBar.setText("It's a Draw! Click to play again.");
	         } else if (currentState == GameState.CROSS_WON) {
	            statusBar.setForeground(Color.RED);
	            statusBar.setText("'X' Won! Click to play again.");
	         } else if (currentState == GameState.NOUGHT_WON) {
	            statusBar.setForeground(Color.RED);
	            statusBar.setText("'O' Won! Click to play again.");
	         }
	      }
	   }
	 
	   /** The entry main() method */
	   public static void main(String[] args) {
	      // Run GUI codes in the Event-Dispatching thread for thread safety
	      SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            new TicTacToe_Swing(); // Let the constructor do the job
	         }
	      });
	   }

}