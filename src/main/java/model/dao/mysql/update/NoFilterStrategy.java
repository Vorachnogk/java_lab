package model.dao.mysql.update;

public class NoFilterStrategy implements Strategy {

    @Override
    public String getKey() {
        return "FIND_ALL_EXHIBITION";
    }
}
