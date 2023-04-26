package com.example.demo.repository;

import com.example.demo.entities.Ipadresse;
import com.example.demo.entities.Ssh;
import com.example.demo.projection.IpadresseInfo;
import com.example.demo.projection.SshInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(excerptProjection= SshInfo.class)
@Repository
public interface SshRepository extends JpaRepository<Ssh, Long> {
}
