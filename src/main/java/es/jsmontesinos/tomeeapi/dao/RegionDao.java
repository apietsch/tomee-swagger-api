package es.jsmontesinos.tomeeapi.dao;

import java.util.List;

import es.jsmontesinos.tomeeapi.entities.Region;

public interface RegionDao {

	List<Region> findAll(String nameQuery, int first, int max);

	Region find(long regionId);

}
