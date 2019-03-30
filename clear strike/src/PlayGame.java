public class PlayGame {

  protected int playerToMove;
  protected int noOfPlayers;
  Board board;
  Player player1;
  Player player2;

  public PlayGame() {
    this.playerToMove = 0;
    this.noOfPlayers = 2;
    this.board = new Board(1, 8);
    this.player1 = new Player("Player 1");
    this.player2 = new Player("Player 2");
  }

  public void playGame() {
    while (isGameOn()) {
      ActionFactory actionFactory = new ActionFactory();
      Action action = actionFactory.getAction(ActionConstants.STRIKE);
      Player player = getPlayerToMove();
      if (checkAndPerformSpecialMove(player, ActionConstants.STRIKE))
        player.setPoints(player.getPoints() + action.performAction(board));
      player.setPreviousMoves(ActionConstants.STRIKE);
    }
  }

  private boolean checkAndPerformSpecialMove(Player player, ActionConstants action) {
    if (action.compareTo(ActionConstants.MISSED_STRIKE) == 0
        || action.compareTo(ActionConstants.DEFUNCT_COIN) == 0) {}

    return false;
  }

  private Player getPlayerToMove() {
    switch (playerToMove % noOfPlayers) {
      case 0:
        return player1;
      case 1:
        return player2;
    }
    return null;
  }

  private boolean isGameOn() {
    return !(board.getBlackCoin() > 0
        || board.getRedCoin() > 0
        || (Math.abs(player1.getPoints() - player2.getPoints())) > 3);
  }
}
