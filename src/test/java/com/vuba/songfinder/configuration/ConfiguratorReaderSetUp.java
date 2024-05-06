package com.vuba.songfinder.configuration;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ConfiguratorReaderSetUp {

    private static final String INPUT_DIRECTORY = "inputDirectory";
    private static final String OUTPUT_DIRECTORY = "outputDirectory";
    private static final String PLATFORM_SLASH = "platformSlash";

    final static InputConfiguration expectedConfiguration(){
        return new InputConfiguration(INPUT_DIRECTORY, OUTPUT_DIRECTORY, PLATFORM_SLASH);
    }
}