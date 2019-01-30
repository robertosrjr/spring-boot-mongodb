package com.coaching2live.service.google.photos;

import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.proto.MediaItem;
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.library.v1.proto.SearchMediaItemsResponse;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Supplier;

public final class SearchMediaItemSupplier implements Supplier<Iterable<MediaItem>> {
  private final PhotosLibraryClient client;
  private SearchMediaItemsRequest baseRequest;
  private Optional<SearchMediaItemsRequest> request;

  public SearchMediaItemSupplier(PhotosLibraryClient client, SearchMediaItemsRequest request) {
    this.client = client;
    this.baseRequest = request;
    this.request = Optional.of(request);
  }

  public void refresh() {
    this.request = Optional.of(this.baseRequest);
  }

  public void setBaseRequest(SearchMediaItemsRequest request) {
    this.baseRequest = request;
  }

  @Override
  public Iterable<MediaItem> get() {
    if (!request.isPresent()) {
      return Collections.emptyList();
    }
    SearchMediaItemsResponse response = client.searchMediaItemsCallable().call(request.get());
    if (response.getNextPageToken().isEmpty()) {
      request = Optional.empty();
    } else {
      request =
          Optional.of(request.get().toBuilder().setPageToken(response.getNextPageToken()).build());
    }
    return response.getMediaItemsList();
  }
}
