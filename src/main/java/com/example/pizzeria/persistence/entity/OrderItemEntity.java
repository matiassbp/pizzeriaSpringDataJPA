package com.example.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

    // Identificador de la orden
    @Id
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    // Identificador del ítem
    @Id
    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    // Identificador de la pizza
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    // Cantidad del ítem en la orden
    @Column(nullable = false, columnDefinition = "Decimal(2,1)")
    private Double quantity;

    // Precio del ítem en la orden
    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double price;

    // Relación Many-to-One con la entidad OrderEntity
    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    private OrderEntity order;

    // Relación One-to-One con la entidad PizzaEntity
    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
    private PizzaEntity pizza;
}