package com.highfive.tuto.domain;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "name")
@Getter
@Setter
@NoArgsConstructor

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "price")
    private BigDecimal name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model")
    private Model model;

    public Car(BigDecimal name){
        this.name = name;
    }
}
