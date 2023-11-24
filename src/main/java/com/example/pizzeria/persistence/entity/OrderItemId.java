package com.example.pizzeria.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa la clave compuesta de la entidad OrderItemEntity en la base de datos.
 * Implementa la interfaz Serializable para permitir la serialización.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId implements Serializable {

    // Identificador único de la orden a la que pertenece el ítem
    private Integer idOrder;

    // Identificador único del ítem en la orden
    private Integer idItem;

    /**
     * Compara si dos objetos OrderItemId son iguales.
     *
     * @param o Objeto a comparar con la instancia actual.
     * @return true si son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemId that)) return false;
        return Objects.equals(idOrder, that.idOrder) && Objects.equals(idItem, that.idItem);
    }

    /**
     * Genera un valor hash basado en los atributos de la instancia.
     *
     * @return Valor hash de la instancia.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idItem);
    }
}
