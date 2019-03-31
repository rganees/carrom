package main.com.action;

import main.com.board.Board;

public class MultiStrike extends Action {
  @Override
  public int getPoints(Board board) {
    return 2;
  }

  @Override
  public boolean isMoveValid(Board board) {
    return board.getBlackCoin() >= 2;
  }

  @Override
  public void modifyBoard(Board board) {
    board.setBlackCoin(board.getBlackCoin() - 2);
  }
}
