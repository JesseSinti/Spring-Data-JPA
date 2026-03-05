package com.example.festivalorganizer;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

//    connects to the ManyToOne in stage.java using the variable name
    @OneToMany(mappedBy = "festival", cascade = CascadeType.ALL)
    private List<Stage> stages;

    @ManyToMany
    @JoinTable(
            name = "festival_artists",
            joinColumns = @JoinColumn(name = "festival_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> artists = new HashSet<>();
}
