package com.by.lomakin.carsharing.dao.api;

import com.by.lomakin.carsharing.dao.api.filter.CarFilter;
import com.by.lomakin.carsharing.dao.api.model.ICar;

import java.util.List;
import java.util.Map;

public interface ICarDao extends BaseDao<ICar, Integer> {

    List<ICar> find(CarFilter filter);

    long getCount(CarFilter filter);

    //ICar getFullInfo(Integer id);

    //Map<Integer, String> getPictureLink(Integer id);

}
