package br.com.autocarshop.autocarshop.model.entities;

import br.com.autocarshop.autocarshop.dtos.SedaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Seda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "sedaId")
public class Seda {

    @EmbeddedId
    private SedaId sedaId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codCar", insertable = false, updatable = false)
    private Carro carro;

    public Seda(SedaDTO data) {
        this.sedaId.setPassageiros(data.passageiros());
    }
}
