package main.com.action;

import main.com.board.Board;

public class Strike extends Action {
    @Override
    public int getPoints(Board board) {
        return 1;
    }

    @Override
    public boolean isMoveValid(Board board) {
        return board.getBlackCoin() >= 1;
    }

    @Override
    public void modifyBoard(Board board) {
        board.setBlackCoin(board.getBlackCoin() - 1);
    }

}
