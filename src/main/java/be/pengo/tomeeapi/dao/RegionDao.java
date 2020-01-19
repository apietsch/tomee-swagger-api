package be.pengo.tomeeapi.dao;

import java.util.List;

import be.pengo.tomeeapi.entities.Region;

public interface RegionDao {

	List<Region> findAll(String nameQuery, int first, int max);

	Region find(long regionId);

}
