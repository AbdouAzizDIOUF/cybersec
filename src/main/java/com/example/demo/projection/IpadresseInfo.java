package com.example.demo.projection;


import com.example.demo.entities.Identifiant;
import com.example.demo.entities.Ipadresse;
import org.springframework.data.rest.core.config.Projection;

@Projection(types={Ipadresse.class}, name="ipProjection")
public interface IpadresseInfo {

   // Long getId();

    String getName();

    int getPort();

    Identifiant getIdentifiant();

}
