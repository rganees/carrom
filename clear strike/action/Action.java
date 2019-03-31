public abstract class Action {
    public abstract int getPoints(Board board);
    public abstract boolean isMoveValid(Board board);
    public void modifyBoard(Board board) {

    }
    public int performAction(Board board) {
        if(isMoveValid(board)) {
            modifyBoard(board);
            return getPoints(board);
        }
        return 0;
    }

}
