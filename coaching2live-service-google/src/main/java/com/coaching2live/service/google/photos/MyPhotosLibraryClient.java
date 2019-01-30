package com.coaching2live.service.google.photos;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coaching2live.service.google.photos.factories.GooglePhotosAPI;
import com.google.common.collect.ImmutableList;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.proto.Album;

@Service
public class MyPhotosLibraryClient {
	
	private static final List<String> REQUIRED_SCOPES =
		      ImmutableList.of(
		          "https://www.googleapis.com/auth/photoslibrary.readonly",
		          "https://www.googleapis.com/auth/photoslibrary.appendonly");
	
	private static final String CREDENTIALS_PATH = "/client_secret_926451073515-mr47nv3cf3fo9ug37lfql3p0gm8th40b.apps.googleusercontent.com.json";

	private PhotosLibraryClient client;

	public void initialize() {

		try {
			
			client = GooglePhotosAPI.createClient(REQUIRED_SCOPES);
			//client = PhotosLibraryClientFactory.createClient(CREDENTIALS_PATH, REQUIRED_SCOPES);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * */
	public void createAlbum() {

		try {

			 Album createdAlbum = this.client.createAlbum("Album 01");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
