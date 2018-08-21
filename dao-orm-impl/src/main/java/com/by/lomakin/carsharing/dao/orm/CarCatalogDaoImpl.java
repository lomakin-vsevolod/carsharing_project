package com.by.lomakin.carsharing.dao.orm;

import com.by.lomakin.carsharing.dao.api.ICarCatalogDao;
import com.by.lomakin.carsharing.dao.api.filter.CarCatalogFilter;
import com.by.lomakin.carsharing.dao.api.model.ICarCatalog;
import com.by.lomakin.carsharing.dao.orm.model.CarCatalog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CarCatalogDaoImpl extends AbstractDaoImpl<ICarCatalog, Integer> implements ICarCatalogDao {

	protected CarCatalogDaoImpl() {
		super(CarCatalog.class);
	}

	@Override
	public ICarCatalog createEntity() {
		return new CarCatalog();
	}

	@Override
	public long getCount(CarCatalogFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<CarCatalog> from = cq.from(CarCatalog.class);
		cq.select(cb.count(from));
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public List<ICarCatalog> find(CarCatalogFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<ICarCatalog> cq = cb.createQuery(ICarCatalog.class);
		final Root<CarCatalog> from = cq.from(CarCatalog.class);
		cq.select(from);

		final TypedQuery<ICarCatalog> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

}
