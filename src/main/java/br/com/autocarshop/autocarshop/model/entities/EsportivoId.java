package br.com.autocarshop.autocarshop.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EsportivoId implements Serializable {

    @Column(name = "velocidade", nullable = false)
    private Double velocidade;

    @Column(name = "codCar", nullable = false)
    private Integer codCar;

    public EsportivoId() {
    }

    public EsportivoId(Double velocidade, Integer codCar) {
        this.velocidade = velocidade;
        this.codCar = codCar;
    }

    public EsportivoId(Integer idCarro) {
        this.codCar = idCarro;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public Integer getCodCar() {
        return codCar;
    }

    public void setCodCar(Integer codCar) {
        this.codCar = codCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EsportivoId that = (EsportivoId) o;
        return Objects.equals(velocidade, that.velocidade) && Objects.equals(codCar, that.codCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(velocidade, codCar);
    }
}
