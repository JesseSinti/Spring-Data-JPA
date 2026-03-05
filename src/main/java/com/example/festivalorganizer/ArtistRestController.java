package com.example.festivalorganizer;

import com.example.festivalorganizer.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/artist")
public class ArtistRestController {
    @Autowired
    private ArtistRepository artistRepo;

    @GetMapping
    public List<Artist> getAll() {
        return artistRepo.findAll();
    }
    @PostMapping
    public Artist create(@RequestBody Artist artist) {
        return artistRepo.save(artist);
    }

    @GetMapping("/{id}")
    public Artist getOne(@PathVariable Long id) {
        return artistRepo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Artist update(@PathVariable Long id, @RequestBody Artist details) {
        Artist artist = artistRepo.findById(id).orElseThrow();
        artist.setName(details.getName());
        artist.setGenre(details.getGenre());
        return artistRepo.save(artist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        artistRepo.deleteById(id);
    }

}
