import java.util.List;

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

  public boolean playNextMove(ActionConstants currentAction) {
    if (currentAction != null || !isGameOver()) {
      ActionFactory actionFactory = new ActionFactory();
      Action action = actionFactory.getAction(currentAction);
      Player player = getPlayerToMove();
      if (!checkAndPerformSpecialMove(player, currentAction)) {
        player.setPoints(player.getPoints() + action.performAction(board));
      }
      player.setPreviousMoves(currentAction);
      playerToMove++;
      return true;
    }
    return false;
  }

  private boolean checkAndPerformSpecialMove(Player player, ActionConstants action) {
    boolean returnFlag = false;
    if (action.equals(ActionConstants.MISSED_STRIKE)
        || action.equals(ActionConstants.DEFUNCT_COIN)) {
      List previousMoves = player.getPreviousMoves();
      if (action.equals(ActionConstants.DEFUNCT_COIN)) {
        player.setFoulCounter(player.getFoulCounter() + 1);
      }
      if (action.equals(ActionConstants.MISSED_STRIKE)) {
        player.setFoulCounter(player.getFoulCounter() + 1);
        returnFlag = true;
        if (areLastThreeMisses(previousMoves)) {
          player.setPoints(player.getPoints() - 1);
        }
      }

      if (player.getFoulCounter() == 3) {
        player.setPoints(player.getPoints() - 1);
        player.setFoulCounter(0);
      }
    }

    return returnFlag;
  }


  private boolean areLastThreeMisses(List previousMoves) {
    int count = 0;
    for (int i = previousMoves.size() - 1; i > 0; i--) {

      if (previousMoves.get(i).equals(ActionConstants.MISSED_STRIKE)) {
        count++;
        if (count == 3) {
          return true;
        }
      } else {
        break;
      }
    }
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

  private boolean isGameOver() {
    return (haveTheCoinsExhausted() || hasAPlayerWon());
  }

  private boolean haveTheCoinsExhausted() {
    return board.getBlackCoin() == 0 && board.getRedCoin() == 0;
  }

  private boolean hasAPlayerWon() {
    return (Math.abs(player1.getPoints() - player2.getPoints())) >= 3
        && (player1.getPoints() >= 5 || player2.getPoints() > 5);
  }

  public String getWinner() {
    if (player1.getPoints() - player2.getPoints() >= 3 && player1.getPoints() > 5) {
      return player1.getName()
          + " Won the game. Final Score: "
          + player1.getPoints()
          + "-"
          + player2.getPoints();
    }
    if (player2.getPoints() - player1.getPoints() >= 3 && player2.getPoints() > 5) {
      return player2.getName()
          + " Wins. Final Score: "
          + player1.getPoints()
          + "-"
          + player2.getPoints();
    }
    return "Draw. Final Score: " + player1.getPoints() + "-" + player2.getPoints();
  }
}
