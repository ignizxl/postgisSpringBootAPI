/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.EstadoView;
import br.com.example.repository.EstadoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joão igor
 */
@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Estados API", version = "1.0", description = "Dados de Estados"))
public class EstadoController {

    @Autowired
    private EstadoRepository repository;


    @Operation(summary = "Retorna o nome das cidades de um estado que possui aeroportos localizado pela sigla")    
    @GetMapping("/estado/aeroporto/{estadoSigla}")
    public List<String> qtdAeroportoPorEstado(@PathVariable String estadoSigla) {
        var result = repository.municipiosAeroporto(estadoSigla);
        return result;
    }
    
    @Operation(summary = "Retorna todos os estados com aeroportos internacionais")    
    @GetMapping("/estado/aeroporto/internacionais")
    public List<String> estadosComAeroportosInternacionais() {
        var result = repository.estadoAeroportoInternacionais();
        return result;
    }
    
    
    @Operation(summary = "Retorna os 10 aeroportos mais próximos de um estado localizado pela sigla.")    
    @GetMapping("/estado/aeroporto/proximos/{estadoSigla}")
    public List<String> top10aeroportoMaisProximos(@PathVariable String estadoSigla) {
        var result = repository.top10aeroportoProximos(estadoSigla).subList(0, 10);
        return result;
    }

    @Operation(summary = "Retorna os municipios de um estado localizado pela sigla.")    
    @GetMapping("/estado/municipio/{estadoSigla}")
    public List<String> todosMunicipiosDeUmEstado(@PathVariable String estadoSigla) {
        var result = repository.municipiosEstado(estadoSigla);
        return result;
    }
    
    @Operation(summary = "Retorna os estados vizinhos de um estado localizado pela sigla")
    @GetMapping("/estado/vizinhos/{estadoSigla}")
    public List<EstadoView> estadosVizinhos(@PathVariable String estadoSigla) {
        var result = repository.estadosVizinhos(estadoSigla);
        return result;
    }
    
    @Operation(summary = "Retorna o maior municipo de um estado")
    @GetMapping("/estado/municipio/maior/{estadoSigla}")
    public List<String> maiorMunicipio(@PathVariable String estadoSigla) {
        var result = repository.maiorMunicipio(estadoSigla);
        return result;
    }
    
    @Operation(summary = "Retorna o tamanho do estado buscando pela sigla")
    @GetMapping("/estado/municipio/tamanho/{estadoSigla}")
    public List<String> tamanhoEstado(@PathVariable String estadoSigla) {
        var result = repository.tamanhoEstado(estadoSigla);
        return result;
    }
  
}
