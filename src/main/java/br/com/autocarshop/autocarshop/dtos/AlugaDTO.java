package br.com.autocarshop.autocarshop.dtos;

import java.time.LocalDate;

public record AlugaDTO(Integer codCar, Integer codCli, LocalDate dateFin, LocalDate dateIni) {
}
