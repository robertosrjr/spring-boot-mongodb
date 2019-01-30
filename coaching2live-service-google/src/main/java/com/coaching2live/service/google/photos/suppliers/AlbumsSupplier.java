package com.coaching2live.service.google.photos.suppliers;

import java.util.List;
import java.util.function.Supplier;

import com.google.photos.library.v1.proto.Album;

public interface AlbumsSupplier extends Supplier<List<Album>> {
  void refresh();
}