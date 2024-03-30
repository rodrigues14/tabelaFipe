package br.com.lucasdev.tabelafipe.principal;

import br.com.lucasdev.tabelafipe.model.*;
import br.com.lucasdev.tabelafipe.service.ConsumoApi;
import br.com.lucasdev.tabelafipe.service.ConverteDados;

import java.util.*;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversorDeDados = new ConverteDados();
    private final String ENDERECO_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        System.out.println("====Opções====");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.println("3 - Caminhão");
        System.out.println("Escolha uma das opções para a consulta de valores");

        var opcao = scanner.nextLine();
        if (opcao.equals("1")) {
            opcao = "carros";
        } else if (opcao.equals("2")) {
            opcao = "motos";
        } else if (opcao.equals("3")) {
            opcao = "caminhoes";
        } else {
            System.out.println("Opção invalida.");
            return;
        }

        String json = consumoApi.obterDados(ENDERECO_BASE + opcao + "/marcas");
        List<Dados> dadosMarca = List.of(conversorDeDados.obterDados(json, Dados[].class));
        dadosMarca.stream()
                .sorted(Comparator.comparing(e -> Integer.parseInt(e.codigo())))
                .forEach(d -> System.out.println("Cód: " + d.codigo() + "  Descrição: " + d.nome()));

        System.out.println("Informe o código da marca para consulta: ");
        var codigoMarca = scanner.nextLine();
        json = consumoApi.obterDados(ENDERECO_BASE + opcao + "/marcas/" + codigoMarca + "/modelos");
        DadosModelo dadosModelo = conversorDeDados.obterDados(json, DadosModelo.class);
        dadosModelo.modelos().forEach(e -> System.out.println("Cód: " + e.codigo() + "  Descrição: " + e.nome()));


        System.out.println("Digite um trecho do nome do veiculo para consulta: ");
        var trechoDigitado = scanner.nextLine();
        dadosModelo.modelos().stream()
                .filter(e -> e.nome().toUpperCase().contains(trechoDigitado.toUpperCase()))
                .forEach(e -> System.out.println("Cód: " + e.codigo() + "  Descrição: " + e.nome()));


        System.out.println("Digite o código do modelo para consultar valores");
        var codigoModelo = scanner.nextLine();
        json = consumoApi.obterDados(ENDERECO_BASE + opcao + "/marcas/" +
                codigoMarca + "/modelos/" + codigoModelo + "/anos");
        List<Dados> dadosAno = List.of(conversorDeDados.obterDados(json, Dados[].class));

        List<DadosVeiculo> listaVeiculos = new ArrayList<>();
        for (int i = 0; i < dadosAno.size(); i++) {
            json = consumoApi.obterDados(ENDERECO_BASE + opcao + "/marcas/" +
                    codigoMarca + "/modelos/" + codigoModelo + "/anos/" + dadosAno.get(i).codigo());
            DadosVeiculo dadosVeiculo = conversorDeDados.obterDados(json, DadosVeiculo.class);
            listaVeiculos.add(dadosVeiculo);
        }
        listaVeiculos.forEach(System.out::println);
    }
}
