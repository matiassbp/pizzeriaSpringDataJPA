package com.example.pizzeria.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId implements Serializable {

    // Identificador de la orden
    private Integer idOrder;

    // Identificador del ítem
    private Integer idItem;

    /**
     * Compara este objeto OrderItemId con otro objeto para verificar la igualdad.
     *
     * @param o Objeto a comparar con esta instancia de OrderItemId
     * @return true si los objetos son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        // Comprueba si los objetos son idénticos en memoria
        if (this == o) return true;

        // Comprueba si el objeto es una instancia de OrderItemId
        if (!(o instanceof OrderItemId that)) return false;

        // Compara los valores de idOrder e idItem para determinar la igualdad
        return Objects.equals(idOrder, that.idOrder) && Objects.equals(idItem, that.idItem);
    }

    /**
     * Genera un código hash único basado en los valores de idOrder e idItem.
     *
     * @return Código hash generado
     */
    @Override
    public int hashCode() {
        // Utiliza Objects.hash para generar un código hash combinando los valores de idOrder e idItem
        return Objects.hash(idOrder, idItem);
    }
}
