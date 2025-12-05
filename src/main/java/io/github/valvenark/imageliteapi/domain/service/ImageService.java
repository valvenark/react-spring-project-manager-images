package io.github.valvenark.imageliteapi.domain.service;

import io.github.valvenark.imageliteapi.domain.entity.Image;

import java.util.Optional;
import java.util.UUID;

public interface ImageService {
    Image save(Image image);
    Optional<Image> getById(String id);
}
