package com.stacja.stacja.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "plant")
@Data
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Status status;

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
    private List<PlantDisease> diseases;

}
