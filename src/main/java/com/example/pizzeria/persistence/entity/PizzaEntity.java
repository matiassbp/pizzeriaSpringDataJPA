package com.example.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizza")
@Getter
@Setter
@NoArgsConstructor
public class PizzaEntity {

    // Identificador único de la pizza (clave primaria)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    // Nombre de la pizza, no puede ser nulo y debe ser único
    @Column(nullable = false, length = 30, unique = true)
    private String name;

    // Descripción de la pizza, no puede ser nula
    @Column(nullable = false, length = 150)
    private String description;

    // Precio de la pizza, no puede ser nulo
    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double price;

    // Indica si la pizza es vegetariana (puede ser nulo)
    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;

    // Indica si la pizza es vegana (puede ser nulo)
    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;

    // Indica si la pizza está disponible, no puede ser nulo
    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;
}
