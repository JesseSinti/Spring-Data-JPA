package com.example.festivalorganizer;

import com.example.festivalorganizer.repository.ArtistRepository;
import com.example.festivalorganizer.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class UniversalWebController {

    @Autowired
    private FestivalRepository festivalRepo;

    @Autowired
    private ArtistRepository artistRepo;

    @GetMapping
    public String homepage(Model model) {
        model.addAttribute("allFestivals", festivalRepo.findAll());
        model.addAttribute("allArtists", artistRepo.findAll());

        model.addAttribute("newFestival", new Festival());
        model.addAttribute("newArtist", new Artist());
        return "home_page";
    }

//    FestivalAdd
    @PostMapping("/addFestival")
    public String createFestival(@ModelAttribute("newFestival") Festival festival) {
        festivalRepo.save(festival);
        return "redirect:/home";
    }

//    Artist Add
    @PostMapping("/addArtist")
    public String createArtist(@ModelAttribute("newArtist") Artist artist) {
        artistRepo.save(artist);
        return "redirect:/home";
}

// Festival Search
    @GetMapping("/getFestival/{id}")
    public String getFestival(@PathVariable Long id, Model model) {
        Festival festival = festivalRepo.findById(id).orElseThrow();
        model.addAttribute("festival", festival);
        return "festivalDetails";
    }

//    Artist Search
    @GetMapping("/getArtist/{id}")
    public String getArtist(@PathVariable Long id, Model model) {
        Artist artist = artistRepo.findById(id).orElseThrow();
        model.addAttribute("artist", artist);
        return "artistDetails";
}

//  Festival Update
    @PutMapping("/updateFestival/{id}")
    public String updateFestival(@PathVariable Long id, @ModelAttribute("newFestival") Festival details) {
        Festival festival = festivalRepo.findById(id).orElseThrow();
        festival.setName(details.getName());
        festival.setLocation(details.getLocation());
        festivalRepo.save(festival);
        return "redirect:/home";
    }

//    Artist Update
    @PutMapping("/updateArtist/{id}")
    public String updateArtist(@PathVariable Long id, @ModelAttribute("newArtist") Artist details) {
        Artist artist = artistRepo.findById(id).orElseThrow();
        artist.setName(details.getName());
        artist.setGenre(details.getGenre());
        artistRepo.save(artist);
        return "redirect:/home";
    }

//    Festival Delete
    @GetMapping("/deleteFestival/{id}")
    public String deleteFestival(@PathVariable Long id) {
        festivalRepo.deleteById(id);
        return "redirect:/home";
    }

//    Artist Delete
    @GetMapping("/deleteArtist/{id}")
    public String deleteArtist(@PathVariable Long id) {
        artistRepo.deleteById(id);
        return "redirect:/home";
    }


}

