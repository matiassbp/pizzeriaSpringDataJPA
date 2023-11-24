package com.example.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
public class OrderEntity {

    // Identificador único de la orden (clave primaria)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    // Identificador del cliente asociado a la orden
    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    // Fecha y hora en que se realizó la orden, no puede ser nula
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;

    // Total del costo de la orden, no puede ser nulo
    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double total;

    // Método de pago utilizado para la orden, no puede ser nulo
    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String method;

    // Notas adicionales asociadas a la orden, longitud máxima de 200 caracteres
    @Column(name = "additional_notes", length = 200)
    private String additionalNotes;

    // Relación One-to-One con la entidad CustomerEntity
    @OneToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    private CustomerEntity customer;

    // Relación One-to-Many con la entidad OrderItemEntity
    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> items;
}
