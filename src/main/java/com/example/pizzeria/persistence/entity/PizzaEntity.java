package com.example.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa una pizza en la base de datos.
 */
@Entity
@Table(name = "pizza")
@Getter
@Setter
@NoArgsConstructor
public class PizzaEntity {

    // Identificador único de la pizza
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    // Nombre de la pizza (no puede ser nulo, longitud máxima de 30 caracteres y debe ser único)
    @Column(nullable = false, length = 30, unique = true)
    private String name;

    // Descripción de la pizza (no puede ser nula, longitud máxima de 150 caracteres)
    @Column(nullable = false, length = 150)
    private String description;

    // Precio de la pizza (no puede ser nulo, con precisión de 5 dígitos y 2 decimales)
    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double price;

    // Indica si la pizza es vegetariana (puede ser nulo)
    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;

    // Indica si la pizza es vegana (puede ser nulo)
    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;

    // Indica si la pizza está disponible (no puede ser nulo)
    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;

}
