
public class BattleshipGameBoard {
	private int[][] gameBoard;
	
	BattleshipGameBoard(){
		this.gameBoard = new int[5][5];
	}
	
	public String shot(int [] shotArray, BattleshipGameBoard gameBoardToShoot){
		int boardPosition = gameBoardToShoot.gameBoard[shotArray[0]][shotArray[1]];
		String response = "";
		switch (boardPosition) {
		case 0: 
			response = "missed";
			gameBoardToShoot.gameBoard[shotArray[0]][shotArray[1]] = -1;
			break;
		case 1:
			response = "Hit!";
			gameBoardToShoot.gameBoard[shotArray[0]][shotArray[1]] = 2;
			break;
		case -1: 
			response = "already shot there!";
			break;
		default: response = "I'm sorry that is not a reconizeable input";
		};
		return response;
	}
	
	public void placeShip(Battleship battleShip){
		int randomLat = (int) (Math.random() * 5);  
		int randomLong = (int) (Math.random() * 2);
		for (int i = 0; i <= battleShip.getSize(); i++){
			this.gameBoard[randomLat][(randomLong + i)] = 1;
		}
	}
	
	public int[][] printWithoutShips(){
		int[][] gameBoardWithoutShips = new int[5][5];
		// will give this to students
		for (int i = 0; i < this.gameBoard.length; i++){
			System.arraycopy(this.gameBoard[i], 0, gameBoardWithoutShips[i], gameBoardWithoutShips[i][0], gameBoardWithoutShips[i].length);
		}
		
		for (int i = 0; i < gameBoardWithoutShips.length; i++){
			for (int x = 0; x < gameBoardWithoutShips[i].length; x++){
				if (gameBoardWithoutShips[i][x] == 1){
					gameBoardWithoutShips[i][x] = 0;
				}
			}
		}
		return gameBoardWithoutShips;
	}
	
	public int[][] getBoard(){
		return this.gameBoard;
	}
	
	public boolean checkIfWinner(){
		boolean winner = true;
		for (int i = 0; i < this.gameBoard.length; i++){
			for (int x = 0; x < this.gameBoard[i].length; x++){
				if (this.gameBoard[i][x] == 1){
					winner = false;
				}
			}
		}
		return winner;
	}
	
	public static void printBoard(int[][] board){
	    for (int i = 0; i < board.length; i++){
	        for (int x = 0; x < board[i].length; x++){
	            System.out.print(String.format("%10s", board[i][x]));
	        }
	        System.out.println("");
	    }
	}
}