package com.by.lomakin.carsharing.dao.orm.model;

import com.by.lomakin.carsharing.dao.api.model.IBaseEntity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements IBaseEntity {

	@Column(name="date_create",updatable = false)
	private Date dateCreate;

	@Column(name="date_update")
	private Date dateUpdate;

	@Override
	public Date getDateCreate() {
		return dateCreate;
	}

	@Override
	public void setDateCreate(final Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	@Override
	public Date getDateUpdate() {
		return dateUpdate;
	}

	@Override
	public void setDateUpdate(final Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

}
