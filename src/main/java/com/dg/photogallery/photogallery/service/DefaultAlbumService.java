package com.dg.photogallery.photogallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.photogallery.photogallery.entity.Album;
import com.dg.photogallery.photogallery.entity.Image;
import com.dg.photogallery.photogallery.repository.AlbumRepository;


/**
 * Class that implements the service AlbumService
 * @author Diana Gallego
 *
 */
@Service
public class DefaultAlbumService implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Override
	public void saveAlbum(Album album) {
		albumRepository.save(album);
	}

	@Override
	public String deleteAlbum(Long id) {
		albumRepository.deleteById(id);
		return null;
	}

	@Override
	public List<Album> findAllAlbums() {
		return (List<Album>) albumRepository.findAll();
	}

	@Override
	public String addImagesAlbum(List<Image> images) {
		// TODO Auto-generated method stub
		return null;
	}

}
