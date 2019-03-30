public class StrikerStrike extends Action {
    @Override
    public int getPoints(Board board) {
        return -1;
    }

    @Override
    public boolean isMoveValid(Board board) {
        return true;
    }
}
