package com.coaching2live.service.google.photos.suppliers;

import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.proto.Album;
import com.google.photos.library.v1.proto.ListSharedAlbumsRequest;
import com.google.photos.library.v1.proto.ListSharedAlbumsResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class ListSharedAlbumsSupplier implements AlbumsSupplier {
	
	private final PhotosLibraryClient client;
	private final ListSharedAlbumsRequest baseRequest;
	private Optional<ListSharedAlbumsRequest> request;
	
	public ListSharedAlbumsSupplier(PhotosLibraryClient client, ListSharedAlbumsRequest request) {

		this.client = client;
	    this.baseRequest = request;
	    this.request = Optional.of(this.baseRequest);
	}

	@Override
	public List<Album> get() {

	    if (!request.isPresent()) {
	    	
	      return Collections.emptyList();
	    }
	    
	    ListSharedAlbumsResponse response = client.listSharedAlbumsCallable().call(request.get());
	    if (response.getNextPageToken().isEmpty()) {
	
	      request = Optional.empty();
	    } else {
	    	
	      request = Optional.of(request.get().toBuilder().setPageToken(response.getNextPageToken()).build());
	    }
	
	    return response.getSharedAlbumsList();
	}

	@Override
	public void refresh() {

		this.request = Optional.of(this.baseRequest);
	}
}
