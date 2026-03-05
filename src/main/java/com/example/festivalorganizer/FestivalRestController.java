package com.example.festivalorganizer;

import com.example.festivalorganizer.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/festivals")
public class FestivalRestController {
    @Autowired
    private FestivalRepository festivalRepo;

    @GetMapping
    public List<Festival> getAll() {
        return festivalRepo.findAll();
    }
    @PostMapping
    public Festival create(@RequestBody Festival festival) {
        return festivalRepo.save(festival);
    }

    @GetMapping("/{id}")
    public Festival getOne(@PathVariable Long id) {
        return festivalRepo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Festival update(@PathVariable Long id, @RequestBody Festival details) {
        Festival festival = festivalRepo.findById(id).orElseThrow();
        festival.setName(details.getName());
        festival.setLocation(details.getLocation());
        return festivalRepo.save(festival);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        festivalRepo.deleteById(id);
    }

}
