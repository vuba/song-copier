package com.vuba.songfinder;

import com.vuba.songfinder.configuration.InputConfiguration;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class CopyService {

    public void copy(InputConfiguration inputConfiguration, File file) throws IOException {
        var outputDirectory = inputConfiguration.outputDirectory();
        var inputDirectory = inputConfiguration.inputDirectory();
        var existingFileAbsolutePath = file.getAbsolutePath();
        var absolutePathOfNewFile = existingFileAbsolutePath.replace(inputDirectory, outputDirectory);

        Path newFile = Paths.get(absolutePathOfNewFile);
        Path existingFile = Paths.get(existingFileAbsolutePath);
        Files.copy(existingFile, newFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
