package main.com.action;

import main.com.board.Board;

public class StrikerStrike extends Action {
    @Override
    public int getPoints(Board board) {
        return -1;
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
