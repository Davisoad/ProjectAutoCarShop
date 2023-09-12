package br.com.autocarshop.autocarshop.model.entities;

import br.com.autocarshop.autocarshop.dtos.AlugaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Aluga")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "codAlu")
public class Aluga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codAlu;
    @Column(nullable = false)
    private LocalDate dateIni;
    @Column(nullable = false)
    private LocalDate dateFin;
    @Column(nullable = false)
    private Integer codCar;
    @Column(nullable = false)
    private Integer codCli;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codCar", insertable = false, updatable = false)
    private Carro carro;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codCli", insertable = false, updatable = false)
    private Cliente cliente;

    public Aluga(AlugaDTO data) {
        this.codCar = data.codCar();
        this.codCli = data.codCli();
        this.dateFin = data.dateFin();
        this.dateIni = data.dateIni();
    }
}
