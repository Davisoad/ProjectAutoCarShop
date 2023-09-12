package br.com.autocarshop.autocarshop.model.entities;

import br.com.autocarshop.autocarshop.dtos.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "codCli")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCli;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 11, nullable = false)
    private String cnh;
    @Column(length = 100, nullable = false)
    private String endereco;
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Telefone> telefones;
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Aluga> alugas;

    public Cliente(ClienteDTO data) {
        this.cnh = data.cnh();
        this.endereco = data.endereco();
        this.nome = data.nome();
    }
}
