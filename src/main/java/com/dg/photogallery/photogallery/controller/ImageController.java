package com.dg.photogallery.photogallery.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dg.photogallery.photogallery.entity.Album;
import com.dg.photogallery.photogallery.entity.Image;
import com.dg.photogallery.photogallery.service.AlbumService;
import com.dg.photogallery.photogallery.service.ImageService;

@RestController
@RequestMapping("/images")
/**
 * Class for RESTController of the APP
 * @author Diana Gallego
 *
 */
public class ImageController {

	/*
	 * Service for Images
	 */
	@Autowired
	private ImageService imageService;

	
	/*
	 * Service for Albums
	 */
	@Autowired
	private AlbumService albumService;

	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping("/{album}")
	/**
	 * Method for save an Image
	 * @param album
	 * @param fileF
	 */
	public void saveImage(@PathVariable("album") String album, @RequestParam("file") MultipartFile fileF) {
		Image image = new Image();
		Album al = new Album();
		al.setId(new Long(album));

		try {
			if (fileF != null) {
				image.setSize(fileF.getSize());
				image.setName(fileF.getOriginalFilename());
				image.setType(fileF.getContentType());
				image.setContent(fileF.getBytes());
				image.setAlbum(al);
				imageService.saveImage(image);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	/**
	 * method for find a image by id
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/{id}")
	public Image findImageById(@PathVariable Long id) {
		return imageService.findOne(id);
	}

	/**
	 * method for find a image by name
	 * 
	 * @param name
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/name/{name}")
	public List<Image> findImageByName(@PathVariable("name") String name) {
		return imageService.findLikeByName(name);
	}

	/**
	 * method for find a image by date
	 * 
	 * @param date
	 * @return
	 */
	@GetMapping("/date/{date}")
	public List<Image> findImageByDate(@PathVariable Date date) {
		return imageService.findByCreateAt(date);
	}

	/**
	 * Method for list all images
	 * 
	 * @param id
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/view/all")
	public List<Image> viewAllImage() {
		List<Image> images = this.imageService.findAllImages();
		return images;
	}

	/**
	 * Method for delete image(s)
	 * @param selected
	 */
	@CrossOrigin(origins = "http://localhost:8081")
	@DeleteMapping("/{selected}")
	public void deleteImage(@PathVariable("selected") String id) {
		System.out.println(id.toString());
		if (id != null && !id.isEmpty()) {

			String[] img = id.split(",");
			for (String i : img) {
				Long image = new Long(i);
				imageService.deleteImage(image);
			}
		}
	}

	/**
	 * Method for save an album
	 * 
	 * @param album
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping("/album")
	public void saveAlbum(@RequestBody Album album) {
		albumService.saveAlbum(album);
	}

	/**
	 * Method for List all albums
	 * 
	 * @param album
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/album")
	public List<Album> listAlbum() {
		return albumService.findAllAlbums();
	}
	
	/**
	 * Method for delete an album
	 * This method delete all album's images
	 * @param album
	 * @return
	 */

	@CrossOrigin(origins = "http://localhost:8081")
	@DeleteMapping("/album/{selected}")
	public void deleteAlbum(@PathVariable("selected") String id) {
		System.out.println(id.toString());
		Album albumO = new Album();
		List<Image> imagenes;

		if (id != null && !id.isEmpty()) {
			String[] alb = id.split(",");
			for (String i : alb) {
				Long album = new Long(i);
				albumO.setId(album);
				imagenes = imageService.findImagesByAlbum(albumO);
				if (imagenes != null && imagenes.size() > 0) {
					for (Image img : imagenes) {
						imageService.deleteImage(img.getId());
					}
				}
				albumService.deleteAlbum(album);
			}
		}
	}

}
