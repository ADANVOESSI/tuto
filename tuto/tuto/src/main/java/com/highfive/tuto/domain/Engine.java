package com.highfive.tuto.domain;

import com.highfive.tuto.domain.enums.EngineType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "engine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Engine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EngineType type;

}
