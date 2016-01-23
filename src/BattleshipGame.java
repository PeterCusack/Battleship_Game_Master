import java.util.Scanner;

public class BattleshipGame {
	// Stretch goals 
	// 1. make variable game board size
	// 2. make nice print method for game board
	// 3. make multiplier, change AI into actual player sounds hard but should be fairly easy
	// 4. enable players to choose where their ship is placed.
	
	private Battleship playerBattleship, aiBattleShip;
	private BattleshipGameBoard aiGameBoard, playerGameBoard;
	private boolean gameLive;
	private String gameWinner;
	Scanner scan = new Scanner(System.in);

	public BattleshipGame(Battleship playerBattleShip) {
		this.playerBattleship = playerBattleShip;
		this.aiBattleShip = new Battleship(3);
		this.playerGameBoard = new BattleshipGameBoard();
		this.aiGameBoard = new BattleshipGameBoard();
		this.gameLive = true;
		this.gameWinner = "";
		this.placeShips(this.playerBattleship);
	}
	
	public void placeShips(Battleship battleship){
		this.aiGameBoard.placeShip(this.aiBattleShip);
		this.playerGameBoard.placeShip(this.playerBattleship);
	}
	
	public void play(){
		while (gameLive){
			int [] usershot = this.getUserShot();
			System.out.println("You " + this.playerGameBoard.shot(usershot, this.aiGameBoard) + " Here are your shots so far");
			this.printOponentsBoard();
			int [] aiShot = this.generateAIShot();
			System.out.println("The ai " + this.aiGameBoard.shot(aiShot, this.playerGameBoard) + " Here is your game board");
			BattleshipGameBoard.printBoard(this.playerGameBoard.getBoard());
			if (!(this.checkForWinner()))
				System.out.println("Game Over! The winner is " + gameWinner);
		}
	}
	
	public void printOponentsBoard(){
		BattleshipGameBoard.printBoard(this.aiGameBoard.printWithoutShips());
	}
	
	public int[] getUserShot(){
		System.out.println("Please enter the longitude of your shot between 0-4");
		int longitude = scan.nextInt();
		System.out.println("Thank you, now please enter the latitude of your shot between 0-4");
		int latitude = scan.nextInt();
		int[] userShotArray = {longitude, latitude};
		return userShotArray;
	}
	
	public Boolean checkForWinner(){
		if (this.playerGameBoard.checkIfWinner()){
			this.gameLive = false;
			this.gameWinner = "Human Player";
		} else if (this.aiGameBoard.checkIfWinner()){
			this.gameLive = false;
			this.gameWinner = "AI";
		}
		return this.gameLive;
	}
	
	public int[] generateAIShot(){
		int [] aiShotArray = {(int)(Math.random() * 5), (int)(Math.random() * 5)};
		return aiShotArray;
	}
	
}
