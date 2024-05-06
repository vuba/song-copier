package com.vuba.songfinder;

import com.vuba.songfinder.configuration.InputConfiguration;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

@Service
public class OutputDirectoryMaker {

    public static final String EMPTY_STRING = "";

    public void setUpOutputDirectory(InputConfiguration inputConfiguration, File songFile){
        var inputDirectory = inputConfiguration.inputDirectory();
        var absoluteFilePath = songFile.getAbsolutePath();
        var filePathFromRootInputDirectory = absoluteFilePath.replace(
                inputDirectory, EMPTY_STRING
        );
        var indexOfLastSlash = filePathFromRootInputDirectory.lastIndexOf(inputConfiguration.platformSlash());
        var filePathWithoutSongName = filePathFromRootInputDirectory.substring(0, indexOfLastSlash);
        makeDirectoriesIfNeeded(inputConfiguration.outputDirectory()+filePathWithoutSongName);
    }

    private void makeDirectoriesIfNeeded(String path){
        try {
            File file = new File(path);
            if (!file.exists()) {
                var result =  file.mkdirs();
                if(result){
                    System.out.println("directories for path "+path);
                }
            }
        } catch (SecurityException e ){
            System.out.println("error while making directories");
        }
    }
}
