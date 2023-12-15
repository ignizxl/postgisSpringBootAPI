/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.repository.ArmazemRepository;
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
@OpenAPIDefinition(info = @Info(title = "Armazem API", version = "1.0", description = "Dados de Armazem"))
public class ArmazemController {

    @Autowired
    private ArmazemRepository repository;

    @Operation(summary = "Retorna a quantidade de armazéns de cada estado")
    @GetMapping("/armazem/armazens")
    public List<String> qtdEstados() {
        var result = repository.qtdArmazemDosEstados();
        return result;
    }
    
    @Operation(summary = "Retorna a quantidade de armazéns de um estado")
    @GetMapping("/armazem/{estadoSigla}")
    public List<String> qtdEstado(@PathVariable String estadoSigla) {
        var result = repository.qtdArmazemPorEstado(estadoSigla);
        return result;
    }
    
    @Operation(summary = "Retorna o municipio com o maior armazem de um estado")
    @GetMapping("/armazem/maior/{estadoSigla}")
    public List<String> maiorArmazemEstado(@PathVariable String estadoSigla) {
        var result = repository.maiorArmazem(estadoSigla);
        return result;
    }
    
}
