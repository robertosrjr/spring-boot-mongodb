package com.coaching2live.service.google.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coaching2live.service.google.photos.MyPhotosLibraryClient;
import com.coaching2live.service.google.service.PhotosServices;

@Service
public class GoogleBusiness implements PhotosServices {
	
	@Autowired
	private MyPhotosLibraryClient photosLibraryClient;

	@Override
	public void createAlbum() {

		try {

			this.photosLibraryClient.initialize();
			this.photosLibraryClient.createAlbum();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
