package com.example.demo.repository;

import com.example.demo.entities.Identifiant;
import com.example.demo.projection.IdentifiantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(excerptProjection= IdentifiantInfo.class)
@Repository
public interface IdentifiantRepository extends JpaRepository<Identifiant, Long> {
}
