package sudoku;
import java.util.*;
public class Sudoku_Rules {

    // ...
	
	// we check if a possible number is already in a row
	private boolean isInRow(int row, int number) {
		for (int i = 0; i < SIZE; i++)
			if (board[row][i] == number)
				return true;
		
		return false;
	}
	
	// we check if a possible number is already in a column
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < SIZE; i++)
			if (board[i][col] == number)
				return true;
		
		return false;
	}
	
	// we check if a possible number is in its 3x3 box
	private boolean isInBox(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;
		
		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (board[i][j] == number)
					return true;
		
		return false;
	}
	
	// combined method to check if a number possible to a row,col position is ok
	private boolean isOk(int row, int col, int number) {
		return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
	}
	
    // ...
}
