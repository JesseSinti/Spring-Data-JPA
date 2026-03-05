package com.example.festivalorganizer;


import com.example.festivalorganizer.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stages")
public class StageRestController {
    @Autowired
    private StageRepository stageRepo;

    @GetMapping
    public List<Stage> getAll() {
        return stageRepo.findAll();
    }

    @PostMapping
    public Stage create(@RequestBody Stage stage) {
        return stageRepo.save(stage);
    }

    @GetMapping("/{id}")
    public Stage getOne(@PathVariable Long id) {
        return stageRepo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Stage update(@PathVariable Long id, @RequestBody Stage details ) {
        Stage stage = stageRepo.findById(id).orElseThrow();
        stage.setName(details.getName());
        stage.setCapacity(details.getCapacity());
        return stageRepo.save(stage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        stageRepo.deleteById(id);
    }
}
