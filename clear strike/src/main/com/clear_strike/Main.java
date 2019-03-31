package main.com.clear_strike;

import main.com.action.ActionConstants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* Input file generated randomly.
* Modify input.txt to check different results
* */

public class Main {
  private static final String FILE_NAME = "./clear strike/src/main/com/clear_strike/input.txt";

  public static void main(String[] args) {
    Game game = new Game();
    List<ActionConstants> allMoves;
    allMoves = populateList();
    for (ActionConstants currentAction : allMoves) {
      if (!game.playNextMove(currentAction)) {
        break;
      }
    }
    System.out.println(game.getWinner());
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
