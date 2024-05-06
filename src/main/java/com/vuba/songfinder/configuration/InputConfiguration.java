package com.vuba.songfinder.configuration;

public record InputConfiguration(
        String inputDirectory,
        String outputDirectory,
        String platformSlash
) {
}
