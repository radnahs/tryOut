/**
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: org.radnahs.tryOut.belzabar </p>
 * <p>File Name: TicTacToe.java</p>
 * <p>Create Date: Jan 8, 2016 </p>
 * <p>Create Time: 6:46:45 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.belzabar;

import java.util.Scanner;
import static org.radnahs.tryOut.belzabar.TTTConstants.*;
/**
 * @author Shantanu Sikdar
 */

enum TTTConstants {  
	EMPTY(0),	X(1),	O(2),	
	ROWS(3),	COLS(3),	
	PLAYING(0), 	TIED(1), 	X_WON(2),	O_WON(3)/*,
	ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9)*/;
	
	private final int constantValue;
	TTTConstants(int value) {
		this.constantValue = value;
	}
	
	public int tttValue() { return constantValue; }
}

class TTTGridImpl{
		
	public void printGrid(int[][] board) {
		int cellId=1;
		for (int row = 0; row < ROWS.tttValue(); ++row) {
			for (int col = 0; col < COLS.tttValue(); ++col) {
				printCell(board[row][col],cellId++); 
				if (col !=  COLS.tttValue() - 1) {
					System.out.print("|"); 
				}
			}
			System.out.println();
			if (row != ROWS.tttValue() - 1) {
				System.out.println("----------------------"); 
			}
		}
		System.out.println();
	}
	
	private void printCell(int content,int cellId) {		
		if(content==EMPTY.tttValue()){
			System.out.print("   "+ cellId+ "   ");
		}else if(content==O.tttValue()){
			System.out.print("   "+ "O"+ "   ");
		}else if(content==X.tttValue()){		
			System.out.print("   "+ "X"+ "   ");
		}		
	}
}

public class TicTacToe {

	public static int[][] tttGrid = new int[ROWS.tttValue()][COLS.tttValue()]; 
	public static int currentState, currentPlayer, currentRow, currentCol; 
	
	public static Scanner in = new Scanner(System.in); 

	public static void initTTTGrid() {
		for (int row = 0; row < ROWS.tttValue(); ++row) {
			for (int col = 0; col < COLS.tttValue(); ++col) {
				tttGrid[row][col] = EMPTY.tttValue(); 
			}
		}
		currentState = PLAYING.tttValue(); 
		currentPlayer = X.tttValue() ; 
	}

	public static void playerTurn(int theSeed) {
		boolean validInput = false; 
		do {
			int position;
			if (theSeed == X.tttValue()) {
				System.out.print("Player 'X', enter the position Number ");
				//System.out.println("seed = "+theSeed);
				position = in.nextInt();
			} else {
				//System.out.print("Player 'O', enter the position Number ");
				System.out.print("Computer as 'O', enter the position Number ");
				//System.out.println("seed = "+theSeed);
				position = in.nextInt();
			}
		 	int[] intArr = moveInterpreter(position);
		 	int row = intArr[0]; 
		 	int col = intArr[1];
			/*if (row >= 0 && row < ROWS.tttValue() && col >= 0 && col < COLS.tttValue() && tttGrid[row][col] == EMPTY.tttValue()) {
				currentRow = row;
				currentCol = col;
				tttGrid[currentRow][currentCol] = theSeed; 
				validInput = true; 
			}*/if(isValidInput(row,col,theSeed)){
				validInput = true;
			}else {
				System.out.println("This move for position (" + intArr[2] + ") is not valid. Try again...");
			}
		} while (!validInput); 
	}
	
	private static int[] moveInterpreter(int position ){		
		//int position = in.nextInt();
		int[] intArr=new int[3];
		if(position==1){
			intArr[0]=0;intArr[1]=0;intArr[2]=position;
		}else if(position==2){
			intArr[0]=0;intArr[1]=1;intArr[2]=position;
		}else if(position==3){
			intArr[0]=0;intArr[1]=2;intArr[2]=position;
		}else if(position==4){
			intArr[0]=1;intArr[1]=0;intArr[2]=position;
		}else if(position==5){
			intArr[0]=1;intArr[1]=1;intArr[2]=position;
		}else if(position==6){
			intArr[0]=1;intArr[1]=2;intArr[2]=position;
		}else if(position==7){
			intArr[0]=2;intArr[1]=0;intArr[2]=position;
		}else if(position==8){
			intArr[0]=2;intArr[1]=1;intArr[2]=position;
		}else if(position==9){
			intArr[0]=2;intArr[1]=2;intArr[2]=position;
		}else{
			intArr[0]=100;intArr[1]=100;intArr[2]=position;
		}
		return intArr;
	}
	
	private static boolean isValidInput(int row,int col,int theSeed){
		boolean validInput = false;
		if (row >= 0 && row < ROWS.tttValue() && col >= 0 && col < COLS.tttValue() && tttGrid[row][col] == EMPTY.tttValue()) {
			currentRow = row;
			currentCol = col;
			tttGrid[currentRow][currentCol] = theSeed; 
			validInput = true; 
		} 
		return validInput;
	}
	
	/*void winningPattern(){
		1,2,3
		4,5,6
		7,8,9
		1,4,7
		2,5,8
		3,6,9
		1,5,9
		3,5,6
	}
*/	
	public static void updateGame(int theSeed, int currentRow, int currentCol) {
		if (isWinner(theSeed, currentRow, currentCol)) { 
			currentState = (theSeed ==X.tttValue()) ? X_WON.tttValue() : O_WON.tttValue() ;
		} else if (isTied()) { 
			currentState = TIED.tttValue();
		}		
	}

	public static boolean isTied() {
		for (int row = 0; row < ROWS.tttValue(); ++row) {
			for (int col = 0; col < COLS.tttValue(); ++col) {
				if (tttGrid[row][col] == EMPTY.tttValue()) {
					return false; 
				}
			}
		}
		return true; 
	}

	public static boolean isWinner(int theSeed, int currentRow, int currentCol) {
		return (tttGrid[currentRow][0] == theSeed && tttGrid[currentRow][1] == theSeed	&& tttGrid[currentRow][2] == theSeed
				|| tttGrid[0][currentCol] == theSeed && tttGrid[1][currentCol] == theSeed && tttGrid[2][currentCol] == theSeed
				|| currentRow == currentCol && tttGrid[0][0] == theSeed	&& tttGrid[1][1] == theSeed	&& tttGrid[2][2] == theSeed 
				|| currentRow + currentCol == 2	&& tttGrid[0][2] == theSeed	&& tttGrid[1][1] == theSeed	&& tttGrid[2][0] == theSeed);
	}
	
	public static void main(String[] args) {
		TTTGridImpl tttGrd  = new TTTGridImpl();
		tttGrd.printGrid(tttGrid);
		initTTTGrid();
		do {
			playerTurn(currentPlayer); 
			updateGame(currentPlayer, currentRow, currentCol); 
			tttGrd.printGrid(tttGrid);
			if (currentState == X_WON.tttValue() ) {
				System.out.println("Cross won! Bye!");
			} else if (currentState == O_WON.tttValue()) {
				System.out.println("Naught won! Bye!");
			} else if (currentState == TIED.tttValue()) {
				System.out.println("It's a Draw! Bye!");
			}
			currentPlayer = (currentPlayer == X.tttValue()) ? O.tttValue() : X.tttValue();
		} while (currentState == PLAYING.tttValue() ); 
	}

}

