package com.by.lomakin.carsharing.dao.api.model;

import java.util.Date;

public interface IBaseEntity {

	Date getDateCreate();

	void setDateCreate(Date dateCreate);

	Date getDateUpdate();

	void setDateUpdate(Date dateUpdate);

}
