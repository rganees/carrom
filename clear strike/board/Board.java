public class Board {
  private int redCoin;
  private int blackCoin;

  public Board(int redCoin, int blackCoin) {
    this.redCoin = redCoin;
    this.blackCoin = blackCoin;
  }

  public int getRedCoin() {
    return redCoin;
  }

  public void setRedCoin(int redCoin) {
    this.redCoin = redCoin;
  }

  public int getBlackCoin() {
    return blackCoin;
  }

  public void setBlackCoin(int blackCoin) {
    this.blackCoin = blackCoin;
  }
}
