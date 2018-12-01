package com.dg.photogallery.photogallery.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dg.photogallery.photogallery.entity.Album;
import com.dg.photogallery.photogallery.entity.Image;

/**
 * interface that extends from CrudRepository for operations in the BD with entity Image
 * @author Diana Gallego
 *
 */
@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
	
	public List<Image> findLikeByName(String name);
	public List<Image> findByCreateAt(Date date);
	public List<Image> findByAlbum(Album album);
	

}
