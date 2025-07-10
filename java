package com.example.musicplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class MusicPlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicPlayerApplication.class, args);
    }

    // Track model as static nested class
    static class Track {
        private String title;
        private String artist;
        private String src;

        public Track() {}

        public Track(String title, String artist, String src) {
            this.title = title;
            this.artist = artist;
            this.src = src;
        }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getArtist() { return artist; }
        public void setArtist(String artist) { this.artist = artist; }

        public String getSrc() { return src; }
        public void setSrc(String src) { this.src = src; }
    }

    // API endpoint serving the playlist
    @GetMapping("/api/tracks")
    public List<Track> getTracks() {
        return List.of(
            new Track("Acoustic Breeze", "Benjamin Tissot", "/music/acousticbreeze.mp3"),
            new Track("Sunny", "Benjamin Tissot", "/music/sunny.mp3"),
            new Track("Creative Minds", "Benjamin Tissot", "/music/creativeminds.mp3")
        );
    }
}
