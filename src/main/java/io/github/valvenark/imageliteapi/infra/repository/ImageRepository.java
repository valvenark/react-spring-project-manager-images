package io.github.valvenark.imageliteapi.infra.repository;

import io.github.valvenark.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
