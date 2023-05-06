package com.recap.carrental.entities;

import com.recap.carrental.entities.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "plate_number", unique = true, nullable = false)
    private String plateNumber;

    @Column(name = "daily_price")
    private int dailyPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private State state;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(targetEntity = Model.class)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    private Model model;

    @ManyToOne(targetEntity = Color.class)
    @JoinColumn(name = "color_id", referencedColumnName = "id", nullable = false)
    private Color color;
}
