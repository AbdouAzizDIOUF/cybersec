package com.example.demo.repository;

import com.example.demo.entities.Http;
import com.example.demo.entities.Ssh;
import com.example.demo.projection.HttpInfo;
import com.example.demo.projection.IpadresseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(excerptProjection= HttpInfo.class)
@Repository
public interface HttpRepository extends JpaRepository<Http, Long> {
}
