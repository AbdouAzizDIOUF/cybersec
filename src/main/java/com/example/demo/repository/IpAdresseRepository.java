package com.example.demo.repository;

import com.example.demo.entities.Ipadresse;
import com.example.demo.projection.IpadresseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(excerptProjection= IpadresseInfo.class)
@Repository
public interface IpAdresseRepository extends JpaRepository<Ipadresse, Long> {
}
