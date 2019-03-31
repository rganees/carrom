package main.com.action;

import main.com.board.Board;

public class RedStrike extends Action {
    @Override
    public int getPoints(Board board) {
        return 3;
    }

    @Override
    public boolean isMoveValid(Board board) {
        return board.getRedCoin() == 1;
    }
    @Override
    public void modifyBoard(Board board) {
        board.setRedCoin(board.getRedCoin() - 1);
    }
}
