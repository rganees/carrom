public class MissedStrike extends Action {
    @Override
    public int getPoints(Board board) {
        return 0;
    }

    @Override
    public boolean isMoveValid(Board board) {
        return true;
    }

    @Override
    public void modifyBoard(Board board) {
        //DO NOTHING
    }
}
