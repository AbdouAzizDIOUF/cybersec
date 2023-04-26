package com.example.demo.projection;


import com.example.demo.entities.Identifiant;
import com.example.demo.entities.Ipadresse;
import com.example.demo.entities.Ssh;
import org.springframework.data.rest.core.config.Projection;

@Projection(types={Ssh.class}, name="sshProjection")
public interface SshInfo {

   // Long getId();

    String getName();

    int getPort();

    Identifiant getIdentifiant();

}
