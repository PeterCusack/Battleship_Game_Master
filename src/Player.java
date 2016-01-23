public class Player {

	public static void main(String[] args) {
		Battleship myBattleShip = new Battleship(3);
		BattleshipGame game1 = new BattleshipGame(myBattleShip);
		game1.play();
	}

}
