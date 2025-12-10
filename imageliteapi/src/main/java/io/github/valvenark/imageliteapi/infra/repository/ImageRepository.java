package io.github.valvenark.imageliteapi.infra.repository;

import io.github.valvenark.imageliteapi.domain.entity.Image;
import io.github.valvenark.imageliteapi.domain.enums.ImageExtension;
import io.github.valvenark.imageliteapi.infra.repository.specs.GenericSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.valvenark.imageliteapi.infra.repository.specs.GenericSpecs.conjunction;
import static io.github.valvenark.imageliteapi.infra.repository.specs.ImageSpecs.*;
import static org.springframework.data.jpa.domain.Specification.anyOf;
import static org.springframework.data.jpa.domain.Specification.where;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    /**
     *
     * @param extension
     * @param query
     * @return
     *
     * SELECT * FROM IMAGE WHERE 1 = 1 AND EXTENSION = 'PNG' AND (NAME LIKE '%query%' OR TAGS LIKE '%query%');
     *
     */

//    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {
//        //SELECT * FROM IMAGE WHERE 1 = 1
//        Specification<Image> conjunction = (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();
//        Specification<Image> spec = Specification.where( conjunction );
//
//        if(extension != null){
//            //AND EXTENSION = 'PNG'
//            Specification<Image> extensionEqual = (root, q, cb) -> cb.equal(root.get("extension"), extension);
//            spec = spec.and(extensionEqual);
//        }
//
//        if(StringUtils.hasText(query)){
//            //AND (NAME LIKE '%query%' OR TAGS LIKE '%query%')
//
//            Specification<Image> nameLike = (root, q, cb) -> cb.like(cb.upper(root.get("name")), "%" + query.toUpperCase() + "%");
//            Specification<Image> tagsLike = (root, q, cb) -> cb.like(cb.upper(root.get("tags")), "%" + query.toUpperCase() + "%");
//            Specification<Image> nameOrTagsLike = Specification.anyOf(nameLike, tagsLike);
//
//            spec = spec.and(nameOrTagsLike);
//        }
//        return findAll(spec);
//    }

    //REFATORAÇÃO

    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {
        Specification<Image> spec = where(conjunction());

        if(extension != null){
            spec = spec.and(extensionEqual(extension));
        }

        if(StringUtils.hasText(query)){
            spec = spec.and(anyOf(nameLike(query), tagsLike(query)));
        }
        return findAll(spec);
    }
}
