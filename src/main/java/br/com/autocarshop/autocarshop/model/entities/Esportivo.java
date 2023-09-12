package br.com.autocarshop.autocarshop.model.entities;

import br.com.autocarshop.autocarshop.dtos.EsportivoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Esportivo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "esportivoId")
public class Esportivo {

    @EmbeddedId
    private EsportivoId esportivoId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codCar", insertable = false, updatable = false)
    private Carro carro;

    public Esportivo(EsportivoDTO data) {
        this.esportivoId.setVelocidade(data.velocidade());
    }
}
