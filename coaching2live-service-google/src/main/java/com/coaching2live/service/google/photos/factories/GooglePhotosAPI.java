package com.coaching2live.service.google.photos.factories;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.MemoryDataStoreFactory;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.auth.Credentials;
import com.google.auth.oauth2.UserCredentials;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.PhotosLibrarySettings;

public class GooglePhotosAPI {
	
	public static final JsonFactory JSON_FACTORY = new JacksonFactory();
	public static final int LOCAL_RECEIVER_PORT = 61984;
	
	/**
	 * 
	 * */
	public static PhotosLibraryClient createClient(List<String> selectedScopes) throws IOException, GeneralSecurityException {

		try {
			
			PhotosLibrarySettings settings =
	            PhotosLibrarySettings.newBuilder()
	                    .setCredentialsProvider(
	                            FixedCredentialsProvider.create(
	                                    getUserCredentials(selectedScopes)
	                            )).build();
		
			PhotosLibraryClient photosLibraryClient = PhotosLibraryClient.initialize(settings);
			return photosLibraryClient;
		} catch (ApiException e) {

			throw e;
		}
	}
	
	/**
	 * 
	 * */
	private static Credentials getUserCredentials(List<String> selectedScopes)
	        throws IOException, GeneralSecurityException {

		final String CLIENT_SECRET = "/client_secret_926451073515-mr47nv3cf3fo9ug37lfql3p0gm8th40b.apps.googleusercontent.com.json";

		try {

			InputStream in = PhotosLibraryClientFactory.class.getResourceAsStream(CLIENT_SECRET);
  	        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
			
			String clientId = clientSecrets.getDetails().getClientId();
			String clientSecret = clientSecrets.getDetails().getClientSecret();

			GoogleAuthorizationCodeFlow flow =
					new GoogleAuthorizationCodeFlow.Builder(
							GoogleNetHttpTransport.newTrustedTransport(),
							JacksonFactory.getDefaultInstance(),
							clientSecrets,
							selectedScopes)
					.setAccessType("offline")
					.setDataStoreFactory(new MemoryDataStoreFactory())
					.build();

			LocalServerReceiver receiver =
					new LocalServerReceiver.Builder().setPort(LOCAL_RECEIVER_PORT).build();

			Credential credential = null;
			try {
				
				credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
			} catch (Exception e) {

				throw new Exception(e);
			}

			return UserCredentials.newBuilder()
					.setClientId(clientId)
					.setClientSecret(clientSecret)
					.setRefreshToken(credential.getRefreshToken())
					.build();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}
}
