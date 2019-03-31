import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    PlayGame playGame = new PlayGame();
    List<ActionConstants> allMoves;
    allMoves = populateList();
    for (ActionConstants currentAction : allMoves) {
      if (!playGame.playNextMove(currentAction)) {
        break;
      }
    }
    System.out.println(playGame.getWinner());
  }

  private static List<ActionConstants> populateList() {
    List<ActionConstants> allMoves = new ArrayList<>();
    allMoves.add(ActionConstants.DEFUNCT_COIN);
    allMoves.add(ActionConstants.MULTIPLE_STRIKE);
    allMoves.add(ActionConstants.DEFUNCT_COIN);
    allMoves.add(ActionConstants.MULTIPLE_STRIKE);
    allMoves.add(ActionConstants.DEFUNCT_COIN);
    allMoves.add(ActionConstants.MULTIPLE_STRIKE);
    return allMoves;
  }
}
