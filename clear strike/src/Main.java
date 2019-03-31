import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private static final String FILE_NAME = "./clear strike/src/input.txt";

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
    String content;
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
      while ((content = br.readLine()) != null) {
        allMoves.add(getAction(Integer.parseInt(content)));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    /*allMoves.add(ActionConstants.DEFUNCT_COIN);
    allMoves.add(ActionConstants.MULTIPLE_STRIKE);
    allMoves.add(ActionConstants.DEFUNCT_COIN);
    allMoves.add(ActionConstants.MULTIPLE_STRIKE);
    allMoves.add(ActionConstants.DEFUNCT_COIN);
    allMoves.add(ActionConstants.MULTIPLE_STRIKE);*/
    return allMoves;
  }

  private static ActionConstants getAction(Integer action) {
    for (ActionConstants ac : ActionConstants.values()) {
      if (action.equals(ac.getActionId())) {
        return ac;
      }
    }
    return null;
  }
}
