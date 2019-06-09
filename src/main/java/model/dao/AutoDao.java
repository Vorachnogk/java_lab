package model.dao;

import model.entity.Auto;

import java.util.List;

public interface AutoDao extends GenericDao<Auto> {
    List<Auto> getSearchAuto(int idUser);
}
