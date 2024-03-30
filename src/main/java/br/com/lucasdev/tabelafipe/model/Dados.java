package br.com.lucasdev.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(
        @JsonAlias("modelos.codigo") String codigo,
        @JsonAlias("modelos.nome") String nome
) {
}
