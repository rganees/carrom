public class DefunctCoin extends Action{

    @Override
    public int getPoints(Board board) {
        return -2;
    }

    @Override
    public boolean isMoveValid(Board board) {
        return board.getBlackCoin() > 0;
    }

    @Override
    public void modifyBoard(Board board) {
        board.setBlackCoin(board.getBlackCoin() - 1);
    }
}
