package main.com.clear_strike;

import main.com.action.Action;
import main.com.action.ActionConstants;
import main.com.action.ActionFactory;
import main.com.board.Board;
import main.com.player.Player;

import java.util.List;

public class Game {

  protected int playerToMove;
  protected int noOfPlayers;
  Board board;
  Player player1;
  Player player2;
  ActionFactory actionFactory;

  public Game() {
    this.playerToMove = 0;
    this.noOfPlayers = 2;
    this.board = new Board(1, 9);
    this.player1 = new Player("Player 1");
    this.player2 = new Player("Player 2");
    actionFactory = new ActionFactory();
  }

  public boolean playNextMove(ActionConstants currentAction) {
    if (currentAction != null && !isGameOver()) {

      boolean isInvalidMove = false;
      Action action = actionFactory.getAction(currentAction);
      Player player = getPlayerToMove();
      if (player != null) {
        System.out.println(player.getName() + " " + currentAction);
        if (!checkAndPerformSpecialMove(player, currentAction)) {
          int getPointsForAction = action.performAction(board);
          if (getPointsForAction != Constant.INVALID_MOVE_POINTS) {
            player.setPoints(player.getPoints() + getPointsForAction);
          } else {
            isInvalidMove = true;
          }
        }
        performActionForValidMove(currentAction, isInvalidMove, player);
        return true;
      }
    }
    return false;
  }

  private void performActionForValidMove(
          ActionConstants currentAction, boolean isInvalidMove, Player player) {
    if (isInvalidMove) {
      System.out.println("Invalid Move. Please try again.");
    } else {
      player.setPreviousMoves(currentAction);
      playerToMove++;
      System.out.println(
          "Current Score: main.com.player.Player 1: " + player1.getPoints() + " main.com.player.Player 2: " + player2.getPoints());
      System.out.println(
          "Coins left: Red: " + board.getRedCoin() + " black: " + board.getBlackCoin() + "\n");
    }
  }

  private boolean checkAndPerformSpecialMove(Player player, ActionConstants action) {
    boolean returnFlag = false;
    if (isPossiblePointLoser(action)) {
      List previousMoves = player.getPreviousMoves();
      if (action.equals(ActionConstants.DEFUNCT_COIN)
          || action.equals(ActionConstants.STRIKER_STRIKE)) {
        player.setFoulCounter(player.getFoulCounter() + 1);
      }
      if (action.equals(ActionConstants.MISSED_STRIKE)) {
        returnFlag = true;
        if (areLastThreeMisses(previousMoves)) {
          player.setFoulCounter(player.getFoulCounter() + 1);
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

  public boolean isPossiblePointLoser(ActionConstants action) {
    return action.equals(ActionConstants.MISSED_STRIKE)
        || action.equals(ActionConstants.DEFUNCT_COIN)
        || action.equals(ActionConstants.STRIKER_STRIKE);
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
      default:
        return null;
    }
  }

  private boolean isGameOver() {
    return (haveTheCoinsExhausted() || hasAPlayerWon());
  }

  private boolean haveTheCoinsExhausted() {
    return board.getBlackCoin() == 0 && board.getRedCoin() == 0;
  }

  private boolean hasAPlayerWon() {
    return (Math.abs(player1.getPoints() - player2.getPoints())) >= 3
        && (player1.getPoints() >= 5 || player2.getPoints() >= 5);
  }

  public String getWinner() {
    if (player1.getPoints() - player2.getPoints() >= 3 && player1.getPoints() >= 5) {
      return player1.getName()
          + " Won the game. Final Score: "
          + player1.getPoints()
          + " - "
          + player2.getPoints();
    }
    if (player2.getPoints() - player1.getPoints() >= 3 && player2.getPoints() >= 5) {
      return player2.getName()
          + " Wins. Final Score: "
          + player1.getPoints()
          + " - "
          + player2.getPoints();
    }
    return "Draw. Final Score: " + player1.getPoints() + " - " + player2.getPoints();
  }
}
