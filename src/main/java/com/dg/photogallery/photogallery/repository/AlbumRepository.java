package com.dg.photogallery.photogallery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dg.photogallery.photogallery.entity.Album;

/**
 * Interface for access to BD - Entity Album
 * @author Diana Gallego
 *
 */
@Repository
public interface AlbumRepository extends CrudRepository<Album, Long>{
	
	

}
