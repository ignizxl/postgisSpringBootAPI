/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Armazem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author joão igor
 */
public interface ArmazemRepository extends JpaRepository<Armazem, Integer>{
    
    
     // Retorna a quantidade de armazéns de todos os estados  
    @Query(value = "SELECT uf, count(*) AS qtd_armazens FROM Armazem GROUP BY uf")
    public List<String> qtdArmazemDosEstados();
    
    // Retorna a quantidade de armazéns de um estado
    @Query(value = "SELECT uf, count(*) AS qtd_armazens FROM Armazem WHERE uf LIKE :sigla GROUP BY uf ORDER BY uf")
    public List<String> qtdArmazemPorEstado(String sigla);   
    
    // Query nativa: Retorna o maior armazem de um estado
    @Query(value = "SELECT municipio,(ST_Area(geom)) AS area FROM armazens_2014 WHERE uf = :sigla ORDER BY area DESC  LIMIT 1", nativeQuery = true)
    public List<String> maiorArmazem(String sigla);
}


