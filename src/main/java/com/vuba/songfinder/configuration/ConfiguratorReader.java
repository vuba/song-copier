package com.vuba.songfinder.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class ConfiguratorReader {

    @Value("${configuration.file.name}")
    public String configurationFilename;

    //read configuration from config.json file
    public InputConfiguration readConfigSafely(){
        try{
            return  readConfig();
        } catch (Exception e){
            throw new RuntimeException("Cannot start without configuration files");
        }
    }

    private InputConfiguration readConfig() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        //parametrize this to read from app.yaml
        File file = new File(classLoader.getResource("config.json").getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        var inputConfiguration = objectMapper.readValue(file, InputConfiguration.class);
        return inputConfiguration;
    }
}

