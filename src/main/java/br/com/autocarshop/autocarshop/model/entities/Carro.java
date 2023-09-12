package br.com.autocarshop.autocarshop.model.entities;

import br.com.autocarshop.autocarshop.dtos.CarroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Carro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "codCar")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCar;
    @Column(length = 8, nullable = false)
    private String placa;
    @Column(length = 15, nullable = false)
    private String cor;
    @Column(length = 20, nullable = false)
    private String modelo;
    @Column(nullable = false)
    private Integer ano;
    @Column(nullable = false)
    private Double diaria;
    @OneToMany(mappedBy = "carro")
    @JsonIgnore
    private List<Aluga> alugas;
    @OneToMany(mappedBy = "carro")
    @JsonIgnore
    private List<Esportivo> esportivos;
    @OneToMany(mappedBy = "carro")
    @JsonIgnore
    private List<Seda> sedas;

    public Carro(CarroDTO data) {
        this.ano = data.ano();
        this.cor = data.cor();
        this.diaria = data.diaria();
        this.modelo = data.modelo();
        this.placa = data.placa();
    }
}
