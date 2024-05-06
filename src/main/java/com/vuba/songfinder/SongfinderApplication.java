package com.vuba.songfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SongfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongfinderApplication.class, args);
	}

}
