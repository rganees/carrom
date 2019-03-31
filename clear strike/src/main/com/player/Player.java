package main.com.player;

import main.com.action.ActionConstants;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private int points;
  private List previousMoves;
  private int foulCounter;

  public Player(String name) {
    this.name = name;
    this.points = 0;
    this.previousMoves = new ArrayList();
    this.foulCounter = 0;
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

  public int getFoulCounter() {
    return foulCounter;
  }

  public void setFoulCounter(int foulCounter) {
    this.foulCounter = foulCounter;
  }
}
