import java.util.Scanner;

public class Battleship {
	
	public static boolean verifyPosition(int [][] board, int posX, int posY) {
		if (board [posX] [posY] == 1) {
			return true;
		}else {
			return false;
		} 
	}
	
	public static int countShips(int [][] board) {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
			
			}
		}
		return 0;
	}
	
	public static void Map(int [][] board) {
		System.out.println("0 7 2 4 4 4 5 0 4 8");
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (board[x][y] == 1 || board[x][y] == 0) {
					System.out.print("0"+" ");
				}else {
					System.out.print("X"+" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [][] board = new int [10] [10];
		String user;
		int shotPosX, shotPosY, qtdShips;
		int shotsCounter = 0;
		boolean answer;
		try (Scanner s = new Scanner(System.in)) {
			for (int x = 0; x < board.length; x++) {
				for (int y = 0; y < board.length; y++) {
					board[x][y] = 0;
				}
			}
			board[0][7] = 1;
			board[2][4] = 1;
			board[4][4] = 1;
			board[5][0] = 1;
			board[4][8] = 1;
			
			System.out.println("What will be your nickname: ");
			user = s.nextLine();
			while(user.length() < 5) {
				System.out.println("Error. Don't have more than 5 characters");
				user = s.nextLine();
			}
			do {
				System.out.println("Digit X coordinate: ");
				shotPosX = s.nextInt();
				
				System.out.println("Digit Y coordinate: ");
				shotPosY = s.nextInt();
				
				answer = verifyPosition(board, shotPosX, shotPosY);
				
				if (answer == true) {
					System.out.println("Congrats! You hit the ship!");
				}else {
					System.out.println("Pewww! You don't hit the ship!");
				}
				board[shotPosX][shotPosY] = -1;
				Map(board);
				qtdShips = countShips(board);
				System.out.println("Have " + qtdShips + " ships to be destroyed");
				shotsCounter++;
			}while(qtdShips > 0);
		}
		
		System.out.println("Congratulations, " + user + " you hit all ships with " + shotsCounter + " cannon balls");
	}
}
