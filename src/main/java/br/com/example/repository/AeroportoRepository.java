/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Aeroporto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author igor
 */
public interface AeroportoRepository  extends JpaRepository<Aeroporto, Integer>{
    
    @Query(value = "SELECT aeroporto.nm_regiao, estado.nm_uf, aeroporto.municipio FROM Aeroporto aeroporto "
            + "INNER JOIN Estado estado ON st_DWithin(geography(estado.geom), geography(aeroporto.geom), 20000) = true\n "
            + "WHERE estado.sigla_uf = :uf ORDER BY estado.nm_uf, aeroporto.municipio")
    public List<String> aeroportosPorEstado(String uf);


    @Query(value = "SELECT count(*), estado.nm_regiao FROM Aeroporto aeroporto\n"
            + "INNER JOIN Estado estado ON  st_DWithin(geography(estado.geom), geography(aeroporto.geom), 20000) = true\n"
            + "WHERE LOWER(estado.nm_regiao) LIKE LOWER(:regiao)\n"
            + "GROUP BY estado.nm_regiao")
    public List<String> qtdAeroportosPorRegiao(String regiao);
}
