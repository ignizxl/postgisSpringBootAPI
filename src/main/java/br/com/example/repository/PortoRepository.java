/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Porto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author igor
 */
public interface PortoRepository extends JpaRepository<Porto, Integer> {
    
    
    @Query(value = "SELECT porto.nm_regiao, estado.nm_uf, porto.municipio FROM Porto porto "
            + "INNER JOIN Estado estado ON st_DWithin(geography(estado.geom), geography(porto.geom), 20000) = true\n "
            + "WHERE estado.sigla_uf = :uf ORDER BY estado.nm_uf, porto.municipio")
    public List<String> portosPorEstado(String uf);


    @Query(value = "SELECT count(*), estado.nm_regiao FROM Porto porto\n"
            + "INNER JOIN Estado estado ON  st_DWithin(geography(estado.geom), geography(porto.geom), 20000) = true\n"
            + "WHERE LOWER(estado.nm_regiao) LIKE LOWER(:regiao)\n"
            + "GROUP BY estado.nm_regiao")
    public List<String> qtdPortosPorRegiao(String regiao);
    
}
