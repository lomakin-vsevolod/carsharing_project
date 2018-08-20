package com.by.lomakin.carsharing.dao.api;

import com.by.lomakin.carsharing.dao.api.filter.UserDataFilter;
import com.by.lomakin.carsharing.dao.api.model.IUserData;

import java.util.List;

public interface IUserDataDao extends BaseDao<IUserData,Integer> {

    long getCount(UserDataFilter filter);

    List<IUserData> find(UserDataFilter filter);

    IUserData getByEmail(String email);

}
