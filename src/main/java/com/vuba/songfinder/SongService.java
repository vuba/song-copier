package com.vuba.songfinder;

import com.vuba.songfinder.configuration.ConfiguratorReader;
import com.vuba.songfinder.exceptions.SongNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SongService {

    private Logger logger = LoggerFactory.getLogger(SongService.class);
    private final ConfiguratorReader configuratorReader;
    private final SongFinderService songFinder;
    private final OutputDirectoryMaker outputDirectoryMaker;
    private final CopyService copyService;

    public SongService(ConfiguratorReader configuratorReader, SongFinderService songFinder, OutputDirectoryMaker outputDirectoryMaker, CopyService copyService) {
        this.configuratorReader = configuratorReader;
        this.songFinder = songFinder;
        this.outputDirectoryMaker = outputDirectoryMaker;
        this.copyService = copyService;
    }

    public void addSongToDirectory(String songName){
        var inputConfiguration = configuratorReader.readConfigSafely();
        try{
        var songFile = songFinder.findFileSafely(inputConfiguration.inputDirectory(), songName);
        outputDirectoryMaker.setUpOutputDirectory(inputConfiguration, songFile);
        copyService.copy(inputConfiguration, songFile);
        } catch (SongNotFoundException | IOException e){
            logger.error("Song with name "+e.getMessage()+" not found");
        }
    }
}
