package br.com.autocarshop.autocarshop.model.entities;

import br.com.autocarshop.autocarshop.dtos.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Telefone")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "codTelefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codTelefone;
    @Column(length = 15, nullable = false)
    private String telefone;
    @Column(nullable = false)
    private Integer codCli;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codCli", insertable = false, updatable = false)
    private Cliente cliente;

    public Telefone(TelefoneDTO data) {
        this.codCli = data.codCli();
        this.telefone = data.telefone();
    }
}
