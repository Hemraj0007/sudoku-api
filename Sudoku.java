

public class Sudoku {
	
	
	
	private int[][] board;
	public static final int EMPTY = 0; // empty cell
	public static final int SIZE = 9; // size of Sudoku grids
	
	public Sudoku(int[][] board) {
		this.board = new int[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}
	
	//  a row
	private boolean isInRow(int row, int number) {
		for (int i = 0; i < SIZE; i++)
			if (board[row][i] == number)
				return true;
		
		return false;
	}
	
	//  column
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < SIZE; i++)
			if (board[i][col] == number)
				return true;
		
		return false;
	}
	
	//  3x3 box
	private boolean isInBox(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;
		
		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (board[i][j] == number)
					return true;
		
		return false;
	}
	
	//  row,col position is ok
	private boolean isOk(int row, int col, int number) {
		return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
	}
	
	//  a recursive BackTracking algorithm.
	
       public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
         for (int col = 0; col < SIZE; col++) {
          // for empty cell
          if (board[row][col] == EMPTY) {
            //  possible numbers
            for (int number = 1; number <= SIZE; number++) {
              if (isOk(row, col, number)) {
                //  constraints
                board[row][col] = number;

                if (solve()) { //backtracking recursively
                  return true;
                } else { // if not a solution, empty it
                  board[row][col] = EMPTY;
                }
             }
            }

            return false; // not solve yet
           }
          }
         }

         return true; // sud solved
	}
	
	public void display() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(" " + board[i][j]);
			}
		
			System.out.println();
		}
		
		System.out.println();
	}
	
	

}
class run{
	public static int[][] GRID_TO_SOLVE = {
			{9,0,0,1,0,0,0,0,5},
			{0,0,5,0,9,0,2,0,1},
			{8,0,0,0,4,0,0,0,0},
			{0,0,0,0,8,0,0,0,0},
			{0,0,0,7,0,0,0,0,0},
			{0,0,0,0,2,6,0,0,9},
			{2,0,0,3,0,0,0,0,6},
			{0,0,0,2,0,0,9,0,0},
			{0,0,1,9,0,4,5,7,0},
	};
public static void main(String[] args) {
		Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
		System.out.println("Sudoku grid to solve");
		sudoku.display();
		
		
		if (sudoku.solve()) {
			System.out.println("Sudoku Grid solved");
			sudoku.display();
		} else {
			System.out.println("Unsolvable");
		}
	}


}