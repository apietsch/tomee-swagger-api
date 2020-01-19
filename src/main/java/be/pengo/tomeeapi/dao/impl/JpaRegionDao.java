package be.pengo.tomeeapi.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import be.pengo.tomeeapi.dao.RegionDao;
import be.pengo.tomeeapi.entities.Region;

@Default
@Stateless
public class JpaRegionDao implements RegionDao {

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> findAll(String nameQuery, int first, int max) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Region> cq = cb.createQuery(Region.class);
		Root<Region> from = cq.from(Region.class);
		CriteriaQuery<Region> select = cq.select(from);

		if (nameQuery != null){
			Expression<String> path_name = from.get("name");
			select.where(cb.like(cb.lower(path_name), nameQuery + "%"));
		}

		select.orderBy(cb.asc(from.get("id")));

		Query query = em.createQuery(cq);
        query.setFirstResult(first);
		query.setMaxResults(max);
        return (List<Region>) query.getResultList();
	}

	@Override
	public Region find(long regionId) {
		return em.find(Region.class, regionId);
	}

}
