public enum ActionConstants {
  STRIKE(1),
  MULTIPLE_STRIKE(2),
  RED_STRIKE(3),
  STRIKER_STRIKE(4),
  DEFUNCT_COIN(5),
  MISSED_STRIKE(6);
  private Integer actionId;

  public Integer getActionId() {
    return actionId;
  }

  ActionConstants(Integer actionId) {
    this.actionId = actionId;
  }
}
