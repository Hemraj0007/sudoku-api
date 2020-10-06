package disp;
public class Display_res
{
public static void display()
 {
 		int SIZE = 9;
 		int [][]board = new int[9][9];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(" " + board[i][j]);
			}
		
			System.out.println();
		}
		
		System.out.println();
	}
}