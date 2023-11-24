package com.example.pizzeria.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad que representa una orden de pizza en la base de datos.
 */
@Entity
@Table(name = "pizza_order")
public class OrderEntity {

    // Identificador único de la orden
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    // Identificador único del cliente asociado a la orden
    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    // Fecha y hora de la orden (no puede ser nula)
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;

    // Total de la orden (no puede ser nulo, con precisión de 6 dígitos y 2 decimales)
    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double total;

    // Método de pago utilizado en la orden (no puede ser nulo, se representa como un carácter)
    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String method;

    // Notas adicionales asociadas a la orden (longitud máxima de 200 caracteres)
    @Column(name = "additional_notes", length = 200)
    private String additionalNotes;

    // Relación One-to-One con la entidad CustomerEntity mediante la columna id_customer
    @OneToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    private CustomerEntity customer;

    // Relación One-to-Many con la entidad OrderItemEntity mediante la propiedad mappedBy
    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> items;
}
