import java.util.Scanner;

public class TicTacToe {
		//global variables
		static boolean firstRound = true;
		static char[] row0 = new char[28];
		static char[] row1 = new char[28];
		static char[] row2 = new char[28];
		static char currentPlayer = 'X';
		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean playing = true;
		
		while(playing) {
			System.out.println("Enter a row (0, 1, or 2) for player " + currentPlayer +": ");
			int rowInput = input.nextInt();
			System.out.println("Enter a column (0, 1, or 2) for player " + currentPlayer +": ");
			int colInput = input.nextInt();
			
			//generate board
			String starter = "-------------\n|   |   |   |";
			if(firstRound) {
				for(int i = 0; i < starter.length(); i++) {
					row0[i] = starter.charAt(i);
					row1[i] = starter.charAt(i);
					row2[i] = starter.charAt(i);
				}//end for
				firstRound = false;
			}//end if 
			
			boolean changePlayer = true;
			boolean validInput = true;
			
			//Mark board
			if(rowInput == 0) {
				validInput = markSpace(row0, colInput, changePlayer);
			}//end if rowInput = 0
			else if(rowInput == 1) {
				validInput = markSpace(row1, colInput, changePlayer);
			}//end if rowInput = 0
			else if(rowInput == 2) {
				validInput = markSpace(row2, colInput, changePlayer);
			}//end if rowInput = 0

			
			//print board
			printActual(row0, starter);
			printActual(row1, starter);
			printActual(row2, starter);
		
			System.out.println("-------------");
			
			//check game status
			if(checkGameCondition() == 'w') {
				playing = false;
				System.out.println(currentPlayer + " player won");
			}
			
			//switch players
			if(validInput) {
				switchPlayers();
			}
			
			
			
		}//end while loop

		
	}//end main
	
	
	
	public static char printBoard(int rowInput, int colInput) {
		//generate board
		String starter = "-------------\n|   |   |   |";
		if(firstRound) {
			for(int i = 0; i < starter.length(); i++) {
				row0[i] = starter.charAt(i);
				row1[i] = starter.charAt(i);
				row2[i] = starter.charAt(i);
			}//end for
			firstRound = false;
		}//end if 
		
		boolean changePlayer = true;
		boolean validInput = true;
		
		//Mark board
		if(rowInput == 0) {
			validInput = markSpace(row0, colInput, changePlayer);
		}//end if rowInput = 0
		else if(rowInput == 1) {
			validInput = markSpace(row1, colInput, changePlayer);
		}//end if rowInput = 0
		else if(rowInput == 2) {
			validInput = markSpace(row2, colInput, changePlayer);
		}//end if rowInput = 0

		
		//print board
		printActual(row0, starter);
		printActual(row1, starter);
		printActual(row2, starter);
	
		System.out.println("-------------");
		
		//switch players
		if(validInput) {
			switchPlayers();
		}
		
		
		return currentPlayer;
	}//end printBoard
	
	
	
	
	public static boolean markSpace(char row[], int colInput, boolean changePlayer) {
		changePlayer = true;
		if(colInput == 0 && row[16] == ' ') {
			row[16] = currentPlayer;
		}//end if
		else if(colInput == 1 && row[20] == ' ') {
			row[20] = currentPlayer;
		}//end if
		else if(colInput == 2 && row[24] == ' ') {
			row[24] = currentPlayer;
	}//end if
		else {
			System.out.println("Invalid input. Try again.");
			changePlayer = false;
		}
		return changePlayer;
	}//end markSpace
	
	
	public static void printActual(char row[], String starter) {
		for(int i = 0; i < starter.length(); i++) {
			System.out.print(row[i]);
		}//end for
		
		System.out.println("");
	}//end printActual
	
	
	public static void switchPlayers() {
		if(currentPlayer == 'X') {
			currentPlayer = '0';
		}//end if
		else{
			currentPlayer = 'X';
		}//end if
	}//end switchPlayers
	
	public static char checkGameCondition() {
		boolean diagonal = false;
		
		if(row0[16] == currentPlayer && row1[20] == currentPlayer && row2[24] == currentPlayer) {
			diagonal = true;
		}//end if
		
		if(row0[24] == currentPlayer && row1[20] == currentPlayer && row2[16] == currentPlayer) {
			diagonal = true;
		}//end if
		
		if(checkRow(row0) || checkRow(row1) || checkRow(row2) || checkColumn(16) || checkColumn(20) || checkColumn(24) || diagonal){
			return 'w';
		}
		return 'c';
	}//end checkGameCondition
	
	public static boolean checkRow(char row[]) {
		if(row[16] == currentPlayer && row[20] == currentPlayer && row[24] == currentPlayer) {
			return true;
		}//end if 
		return false;
	}//end checkRow
	
	public static boolean checkColumn(int i) {
		if(row0[i] == currentPlayer && row1[i] == currentPlayer && row2[i] == currentPlayer) {
			return true;
		}//end if 
		return false;	
	}//end checkColumn
	
}//end class
