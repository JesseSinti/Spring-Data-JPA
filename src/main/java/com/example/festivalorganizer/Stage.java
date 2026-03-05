package com.example.festivalorganizer;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;

//    links to the parent Festival
    @ManyToOne
    @JoinColumn(name = "festival_id")
    private Festival festival;

}
