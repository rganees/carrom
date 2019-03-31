package main.com.action;

import java.util.HashMap;
import java.util.Map;


public class ActionFactory {

    private Map actionMap;

    public ActionFactory() {
        populateMap();
    }

    private void populateMap() {
        actionMap = new HashMap();
        actionMap.put(ActionConstants.STRIKE, new Strike());
        actionMap.put(ActionConstants.MULTIPLE_STRIKE, new MultiStrike());
        actionMap.put(ActionConstants.RED_STRIKE, new RedStrike());
        actionMap.put(ActionConstants.STRIKER_STRIKE, new StrikerStrike());
        actionMap.put(ActionConstants.DEFUNCT_COIN, new DefunctCoin());
        actionMap.put(ActionConstants.MISSED_STRIKE, new MissedStrike());
    }

    public Action getAction(ActionConstants action) {
        return (Action) actionMap.get(action);
    }

}
