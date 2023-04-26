package com.example.demo.projection;


import com.example.demo.entities.Http;
import com.example.demo.entities.Identifiant;
import com.example.demo.entities.Ssh;
import org.springframework.data.rest.core.config.Projection;

@Projection(types={Http.class}, name="httpProjection")
public interface HttpInfo {

   // Long getId();

    String getName();

    int getPort();

    Identifiant getIdentifiant();

}
