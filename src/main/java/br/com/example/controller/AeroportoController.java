/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.repository.AeroportoRepository;
import br.com.example.repository.PortoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author igor
 */

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Aeroporto API", version = "1.0", description = "Dados de Aeroporto"))
public class AeroportoController {
    
    private AeroportoRepository repository;

    @Operation(summary = "Utiliza a sigla do estado para retornar todos os aeroportos que há nele.")
    @GetMapping("/aeroportos/estados/{siglaEstado}")
    public List<String> portosPorEstado(@PathVariable String siglaEstado) {
        var result = repository.aeroportosPorEstado(siglaEstado);
        return result;
    }
    
    @Operation(summary = "Utiliza o nome da região para retornar a quantidade de aeroportos na região informada.")
    @GetMapping("/aeroportos/regiao/{regiao}")
    public List<String> qtdPortosRegiao(@PathVariable String regiao) {
        var result = repository.qtdAeroportosPorRegiao(regiao);
        return result;
    }
    
}
