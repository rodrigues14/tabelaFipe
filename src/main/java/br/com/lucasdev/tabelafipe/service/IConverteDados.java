package br.com.lucasdev.tabelafipe.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
