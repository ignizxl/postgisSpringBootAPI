package br.com.example.controller;

import br.com.example.repository.FerroviaRepository;
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
@OpenAPIDefinition(info = @Info(title = "Ferrovia API", version = "1.0", description = "Dados das Ferrovias"))
public class FerroviaController {
    @Autowired
    private FerroviaRepository repository;
    
    @Operation(summary = "Utiliza o nome da ferrovia para retornar os estados pelo qual a ferrovia passa.")
    @GetMapping("/ferrovia/estados/{nomeFerrovia}")
    public List<String> estadosPercurso(@PathVariable String nomeFerrovia) {
        var result = repository.estadoPercurso(nomeFerrovia);
        return result;
    }
}
