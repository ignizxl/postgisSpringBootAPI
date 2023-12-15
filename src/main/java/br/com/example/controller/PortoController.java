/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.repository.PortoRepository;
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
@OpenAPIDefinition(info = @Info(title = "Porto API", version = "1.0", description = "Dados dos portos"))
public class PortoController {
    @Autowired
    private PortoRepository repository;
    
    @Operation(summary = "Utiliza a sigla do estado para retornar todos os portos que há nele.")
    @GetMapping("/portos/estados/{siglaEstado}")
    public List<String> portosPorEstado(@PathVariable String siglaEstado) {
        var result = repository.portosPorEstado(siglaEstado);
        return result;
    }
    
    @Operation(summary = "Utiliza o nome da região para retornar a quantidade de portos na região informada.")
    @GetMapping("/portos/regiao/{regiao}")
    public List<String> qtdPortosRegiao(@PathVariable String regiao) {
        var result = repository.qtdPortosPorRegiao(regiao);
        return result;
    }
}