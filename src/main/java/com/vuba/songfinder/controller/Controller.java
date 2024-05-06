package com.vuba.songfinder.controller;

import com.vuba.songfinder.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);
    private final SongService songService;

    public Controller(SongService songService) {
        this.songService = songService;
    }

    @PostMapping(value = "/song")
    public void findSongAndAddToCopyDirectory(@RequestBody InputSongName inputSongName){
        logger.info("helloWorld-start");
        songService.addSongToDirectory(inputSongName.name());
        logger.info("helloWorld-end");
    }
}
