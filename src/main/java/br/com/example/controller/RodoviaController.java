package br.com.example.controller;

import br.com.example.repository.RodoviaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joão igor
 */
@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Rodovia API", version = "1.0", description = "Dados das rodovias"))
public class RodoviaController {
    @Autowired
    private RodoviaRepository repository;
    
    @Operation(summary = "Utiliza o nome da rodovia para retornar os estados pelo qual a ferrovia passa.")
    @GetMapping("/rodovia/estados/{nomeFerrovia}")
    public List<String> estadosPercurso(@PathVariable String nomeRodovia) {
        var result = repository.estadoPercurso(nomeRodovia);
        return result;
    }
    
    @Operation(summary = "Utiliza a sigla do estado para retornar todas suas rodovias.")
    @GetMapping("/rodovia/{estadoSigla}")
    public List<String> rodoviasPorEstado(@PathVariable String estadoSigla) {
        var result = repository.rodoviasPorEstado(estadoSigla);
        return result;
    }
    
}
