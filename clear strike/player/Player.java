import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int points;
    private List previousMoves;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.previousMoves = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List getPreviousMoves() {
        return previousMoves;
    }

    public void setPreviousMoves(ActionConstants previousMoves) {
        this.previousMoves.add(previousMoves);
    }
}
