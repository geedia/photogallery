package com.dg.photogallery.photogallery.service;

import java.util.Date;
import java.util.List;

import com.dg.photogallery.photogallery.entity.Album;
import com.dg.photogallery.photogallery.entity.Image;



/**
 * Interface for services of images
 * @author Diana Gallego
 *
 */
public interface ImageService {

	public void saveImage(Image image);

	public List<Image> findAllImages();

	public Image findOne(Long id);

	public List<Image> findLikeByName(String name);

	public List<Image> findByCreateAt(Date date);

	public String deleteImage(Long id);
	
	public List<Image> findImagesByAlbum(Album album);

}
