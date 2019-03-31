public class MultiStrike extends Action {
  @Override
  public int getPoints(Board board) {
    return 2;
  }

  @Override
  public boolean isMoveValid(Board board) {
    if (board.getBlackCoin() >= 2) {
      return true;
    }
    return false;
  }

  @Override
  public void modifyBoard(Board board) {
    board.setBlackCoin(board.getBlackCoin() - 2);
  }
}
