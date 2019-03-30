public class MultiStrike extends Action {
    @Override
    public int getPoints(Board board) {
        return 2;
    }

    @Override
    public boolean isMoveValid(Board board) {
        return false;
    }

    @Override
    public void modifyBoard(Board board) {

    }
}
