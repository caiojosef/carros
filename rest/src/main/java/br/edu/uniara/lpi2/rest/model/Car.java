package br.edu.uniara.lpi2.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String renavam;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;

    public Car(String renavam, String placa, String marca, String modelo, int ano) {
        this.renavam = renavam;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
}
