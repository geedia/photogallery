package com.dg.photogallery.photogallery.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dg.photogallery.photogallery.entity.Album;
import com.dg.photogallery.photogallery.entity.Image;
import com.dg.photogallery.photogallery.repository.ImageRepository;

/**
 * Class that implements the service ImageService
 * @author Diana Gallego
 *
 */
@Service
public class DefaultImageService implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Override
	@Transactional
	public void saveImage(Image image) {
		imageRepository.save(image);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Image> findAllImages() {
		// TODO Auto-generated method stub
		return (List<Image>) imageRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Image findOne(Long id) {
		// TODO Auto-generated method stub
		return imageRepository.findById(id).orElse(null);
	}

	@Override
	public List<Image> findByCreateAt(Date date) {
		// TODO Auto-generated method stub
		return imageRepository.findByCreateAt(date);
	}

	@Override
	@Transactional
	public String deleteImage(Long id) {
		imageRepository.deleteById(id);
		return "";
	}

	@Override
	@Transactional(readOnly = true)
	public List<Image> findLikeByName(String name) {
		// TODO Auto-generated method stub
		return imageRepository.findLikeByName(name);
	}

	@Override
	public List<Image> findImagesByAlbum(Album album) {
		// TODO Auto-generated method stub
		return imageRepository.findByAlbum(album);
	}


}
