package com.vuba.songfinder.exceptions;

public class SongNotFoundException extends Exception{
    public SongNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
