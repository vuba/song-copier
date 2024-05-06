package com.vuba.songfinder;

import com.vuba.songfinder.exceptions.SongNotFoundException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class SongFinderService {

    public File findFileSafely(String inputDirectiry, String songName) throws SongNotFoundException{
        try{
            return findFile(inputDirectiry,songName);
        } catch (NoSuchElementException e){
            throw new SongNotFoundException(songName);
        }

    }

    private File findFile(String inputDirectiry, String songName) {
        File rootDirectory = new File(inputDirectiry);
        List<File> subdirectories =
                Arrays.stream(Objects.requireNonNull(rootDirectory.listFiles()))
                        .filter(File::isDirectory)
                        .toList();
        File[] matchingFiles = rootDirectory.listFiles(
                new FilenameFilter()
                {
                    public boolean accept(File dir, String name)
                    {
                        return name.contains(songName);
                    }
                });

        if(matchingFiles.length>0) {
            return matchingFiles[0];
        }
        return subdirectories
                .stream()
                .map(subdirectory -> findFile(subdirectory.getAbsolutePath(), songName))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow();
    }
}
