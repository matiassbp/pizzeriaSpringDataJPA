package com.example.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa un ítem de una orden en la base de datos.
 */
@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class) // Clase que representa la clave compuesta de la entidad
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

    // Componente de la clave compuesta: identificador único de la orden
    @Id
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    // Componente de la clave compuesta: identificador único del ítem en la orden
    @Id
    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    // Identificador único de la pizza asociada al ítem de la orden
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    // Cantidad del ítem en la orden (no puede ser nula, con precisión de 2 dígitos y 1 decimal)
    @Column(nullable = false, columnDefinition = "Decimal(2,1)")
    private Double quantity;

    // Precio del ítem en la orden (no puede ser nulo, con precisión de 5 dígitos y 2 decimales)
    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double price;

    // Relación Many-to-One con la entidad OrderEntity mediante la columna id_order
    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    private OrderEntity order;

    // Relación One-to-One con la entidad PizzaEntity mediante la columna id_pizza
    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
    private PizzaEntity pizza;
}
