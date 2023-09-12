package br.com.autocarshop.autocarshop.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SedaId implements Serializable {

    @Column(name = "passageiros", nullable = false)
    private Integer passageiros;

    @Column(name = "codCar", nullable = false)
    private Integer codCar;

    public SedaId() {
    }

    public SedaId(Integer passageiros, Integer codCar) {
        this.passageiros = passageiros;
        this.codCar = codCar;
    }

    public SedaId(Integer idCarro) {
        this.codCar = idCarro;
    }

    public Integer getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(Integer passageiros) {
        this.passageiros = passageiros;
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
        SedaId sedaId = (SedaId) o;
        return Objects.equals(passageiros, sedaId.passageiros) && Objects.equals(codCar, sedaId.codCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passageiros, codCar);
    }
}
