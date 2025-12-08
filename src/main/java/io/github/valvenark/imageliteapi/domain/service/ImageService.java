package io.github.valvenark.imageliteapi.domain.service;

import io.github.valvenark.imageliteapi.domain.entity.Image;
import io.github.valvenark.imageliteapi.domain.enums.ImageExtension;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    Image save(Image image);
    Optional<Image> getById(String id);
    List<Image> search(ImageExtension imageExtension, String query);
}