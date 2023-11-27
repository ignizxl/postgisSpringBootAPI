package br.com.example.controller;

import java.util.List;
import br.com.example.repository.MunicipioRepository;
import br.com.example.model.MunicipioVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Municípios API", version = "1.0", description = "Dados de Municípios"))
public class MunicipioController {
    
    @Autowired
    private MunicipioRepository repository;
     
    @GetMapping("/municipiosVizinhos/{nome}")
    public List<MunicipioVO> municipiosVizinhos(@PathVariable String nome){
        List<MunicipioVO> result = repository.listarMunicipiosVizinhos(nome);
        return result;
    }
   
    @GetMapping("/distanciaEntreMunicipios/{municipioA}/{municipioB}")
     public Double distanciaEntreMunicipios(@PathVariable String municipioA, @PathVariable String municipioB){
        double result = repository.distanciaEntreMunicipios(municipioA, municipioB);
        return result;
    }    
    
}