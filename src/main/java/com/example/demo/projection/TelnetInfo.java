package com.example.demo.projection;


import com.example.demo.entities.Identifiant;
import com.example.demo.entities.Ssh;
import com.example.demo.entities.Telnet;
import org.springframework.data.rest.core.config.Projection;

@Projection(types={Telnet.class}, name="TelnetProjection")
public interface TelnetInfo {

   // Long getId();

    String getName();

    int getPort();

    Identifiant getIdentifiant();

}
