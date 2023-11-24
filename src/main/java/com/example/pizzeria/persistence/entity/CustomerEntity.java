package com.example.pizzeria.persistence.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa un cliente en la base de datos.
 */
@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {

    // Identificador único del cliente (clave primaria)
    @Id
    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    // Nombre del cliente (no puede ser nulo, longitud máxima de 60 caracteres)
    @Column(nullable = false, length = 60)
    private String name;

    // Dirección del cliente (longitud máxima de 100 caracteres)
    @Column(length = 100)
    private String address;

    // Correo electrónico del cliente (no puede ser nulo, único, longitud máxima de 50 caracteres)
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    // Número de teléfono del cliente (longitud máxima de 20 caracteres)
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
}
