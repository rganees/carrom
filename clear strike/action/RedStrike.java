public class RedStrike extends Action {
    @Override
    public int getPoints(Board board) {
        return 3;
    }

    @Override
    public boolean isMoveValid(Board board) {
        if (board.getRedCoin() == 1) {
            return true;
        }
        return false;
    }
    @Override
    public void modifyBoard(Board board) {
        board.setRedCoin(board.getRedCoin() - 1);
    }
}
