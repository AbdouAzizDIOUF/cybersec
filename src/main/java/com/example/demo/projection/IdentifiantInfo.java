package com.example.demo.projection;


import com.example.demo.entities.Identifiant;
import com.example.demo.entities.Ipadresse;
import org.springframework.data.rest.core.config.Projection;

@Projection(types={Identifiant.class}, name="identifiant")
public interface IdentifiantInfo {

    String getLogin();

    String getPassword();

    Ipadresse getIp();
}
