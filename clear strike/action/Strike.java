public class Strike extends Action {
    @Override
    public int getPoints(Board board) {
        return 1;
    }

    @Override
    public boolean isMoveValid(Board board) {
        if(board.getBlackCoin() >= 1) {
            return true;
        }
        return false;
    }

}
