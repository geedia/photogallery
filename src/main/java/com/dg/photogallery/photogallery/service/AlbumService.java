package com.dg.photogallery.photogallery.service;

import java.util.List;

import com.dg.photogallery.photogallery.entity.Album;
import com.dg.photogallery.photogallery.entity.Image;
/**
 * Interface for Service to Album Entity
 * @author Diana Gallego
 *
 */
public interface AlbumService {
	
	public void saveAlbum(Album album);
	
	public String deleteAlbum(Long id);
	
	public List<Album> findAllAlbums();
	
	public String addImagesAlbum(List<Image> images);
	

}
