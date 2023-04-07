package com.highfive.tuto.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model")
    private Model model;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "carengine", joinColumns = @JoinColumn( name = "car" ), inverseJoinColumns = @JoinColumn(name = "engine"))
    private Set<Engine> engines = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "CarFeature", joinColumns = @JoinColumn( name = "car" ), inverseJoinColumns = @JoinColumn(name = "feature"))
    private Set<Feature> features = new HashSet<>();

}
