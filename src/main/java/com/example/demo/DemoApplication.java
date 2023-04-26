package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.projection.IdentifiantInfo;
import com.example.demo.projection.IpadresseInfo;
import com.example.demo.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.*;
import org.json.*;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	private final IdentifiantRepository identifiantRepository;
	private final IpAdresseRepository ipAdresseRepository;
	private final SshRepository sshRepository;
	private final HttpRepository httpRepository;
	private final TelnetRepository telnetRepository;

	public DemoApplication(RepositoryRestConfiguration repositoryRestConfiguration, IdentifiantRepository identifiantRepository, IpAdresseRepository ipAdresseRepository, SshRepository sshRepository, HttpRepository httpRepository, TelnetRepository telnetRepository) {
		this.identifiantRepository = identifiantRepository;
		this.ipAdresseRepository = ipAdresseRepository;
		this.sshRepository = sshRepository;
		this.httpRepository = httpRepository;
		this.telnetRepository = telnetRepository;
		repositoryRestConfiguration.getProjectionConfiguration()
				.addProjection(IpadresseInfo.class)
				.addProjection(IdentifiantInfo.class);
	}

	public static void main(String[] args) throws Exception{

		SpringApplication.run(DemoApplication.class, args);
	}


	@Scheduled(cron = "0 */1 * ? * *")
	public void runEvey5Minutes() throws IOException {
		ipAdresseRepository.deleteAll();
		identifiantRepository.deleteAll();
		File file = new File("/Users/diouf/Documents/demo/src/main/resources/file.log");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		String password = null;
		String username = null;
		//Map<Integer, String> map = new HashMap<Integer, String>();
		List<FormType> tab = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			JSONObject json = new JSONObject(line);
			int src_port = json.getInt("dst_port");
			String src_host = json.getString("src_host");
			if (json.has("logdata")) {
				JSONObject logdata = json.getJSONObject("logdata");
				if (logdata.has("PASSWORD")) {
					password = logdata.getString("PASSWORD");
					username = logdata.getString("USERNAME");
				}
			}
			Ipadresse ipAdresse = new Ipadresse();
			Identifiant identifiant = new Identifiant();
			Ssh ssh = null;
			Http http = null;
			Telnet telnet = null;


			if (src_port==80){
				http = new Http();
				http.setName(src_host);
				http.setPort(src_port);
				http.setIdentifiant(null);
				http = httpRepository.save(http);

				identifiant.setLogin(username);
				identifiant.setPassword(password);
				identifiant.setIp(http);
				identifiant = identifiantRepository.save(identifiant);

				http.setIdentifiant(identifiant);
				httpRepository.save(http);
			}


			if (src_port==23){
				telnet = new Telnet();
				telnet.setName(src_host);
				telnet.setPort(src_port);
				telnet.setIdentifiant(null);
				telnet = telnetRepository.save(telnet);

				identifiant.setLogin(username);
				identifiant.setPassword(password);
				identifiant.setIp(telnet);
				identifiant = identifiantRepository.save(identifiant);

				telnet.setIdentifiant(identifiant);
				telnetRepository.save(telnet);
			}

			if (src_port==22){
				ssh = new Ssh();
				ssh.setName(src_host);
				ssh.setPort(src_port);
				ssh.setIdentifiant(null);
				ssh = sshRepository.save(ssh);

				identifiant.setLogin(username);
				identifiant.setPassword(password);
				identifiant.setIp(ssh);
				identifiant = identifiantRepository.save(identifiant);

				ssh.setIdentifiant(identifiant);
				sshRepository.save(ssh);
			}



			System.out.println("port : "+src_port+",  host: "+src_host+ ", username: "+username+ ", password :"+password);
			//tab.add((new FormType(src_port, src_host)));
		}
		//System.out.println(tab);
	}
}
