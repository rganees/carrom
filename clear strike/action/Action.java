public abstract class Action {
    public abstract int getPoints(Board board);
    public abstract boolean isMoveValid(Board board);
    public abstract void modifyBoard(Board board);
    public int performAction(Board board) {
        if(isMoveValid(board)) {
            modifyBoard(board);
            return getPoints(board);
        }
        return Constant.INVALID_MOVE_POINTS;
    }

}
