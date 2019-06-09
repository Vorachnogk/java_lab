package model.dao.mysql.update;

import java.util.HashMap;
import java.util.Map;



public class Update {
    private Strategy strategy;

    private Map<Integer, Strategy> strategyMap = new HashMap<>();

    {
        strategyMap.put(0, new NoFilterStrategy());
//        strategyMap.put(1, new HallFilterStrategy());
//        strategyMap.put(2, new CategoryFilterStrategy());
//        strategyMap.put(3, new HallCatFilterStrategy());
    }

    public void setStrategy(int idUser) {
        this.strategy = strategyMap.get(getState(idUser));
    }

    private int getState(int idUser) {
        int state = 0;
        if(idUser !=0) {
            state = state+1;
        }

        return state;
    }

    public String execute() {
        return strategy.getKey();
    }





}
