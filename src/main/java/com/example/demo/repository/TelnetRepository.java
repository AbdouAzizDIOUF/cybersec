package com.example.demo.repository;

import com.example.demo.entities.Http;
import com.example.demo.entities.Telnet;
import com.example.demo.projection.IpadresseInfo;
import com.example.demo.projection.TelnetInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(excerptProjection= TelnetInfo.class)
@Repository
public interface TelnetRepository extends JpaRepository<Telnet, Long> {
}
