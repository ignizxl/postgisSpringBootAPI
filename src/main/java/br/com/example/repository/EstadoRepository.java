/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Estado;
import br.com.example.model.EstadoView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author caian
 */
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    // Retorna a quantidade de aeroportos que há em um estado
    @Query(value = "SELECT ae.municipio FROM Aeroporto AS ae INNER JOIN Estado AS uf ON ae.uf = uf.cd_uf WHERE uf.sigla_uf LIKE :estado")
    public List<String> municipiosAeroporto(String estado);

    // Retorna todos os estados que possuem aeroportos internacionais.
    @Query(value = "SELECT DISTINCT estado.sigla_uf FROM Aeroporto AS aero INNER JOIN Estado estado ON aero.uf = estado.cd_uf  WHERE internacio = 0")
    public List<String> estadoAeroportoInternacionais();

    @Query(value = "SELECT nm_uf FROM Estado WHERE sigla_uf = :sigla")
    public String getNomeBySigla(String sigla);

    // Retorna todos os município  de um determinado estado.
    @Query(value = "SELECT nome FROM Municipio WHERE sigla_uf = :sigla")
    public List<String> municipiosEstado(String sigla);

    // Retorna os 10 aeroportos mais próximos de um estado.
    @Query(value = "SELECT aeropoto.municipio, distance(aeropoto.geom, estado.geom) AS distancia FROM Aeroporto AS aeropoto, Estado AS estado WHERE estado.sigla_uf = :sigla ORDER BY distancia ASC")
    public List<String> top10aeroportoProximos(String sigla);

    // Retorna os estados vizinhos 
    @Query(value = "SELECT new br.com.example.model.EstadoView( es2.sigla_uf,  es2.nm_uf) FROM Estado es1, Estado es2 WHERE (st_intersects(es1.geom, es2.geom) = 'TRUE') AND es1.sigla_uf = :sigla AND es2.sigla_uf <> :sigla")
    public List<EstadoView> estadosVizinhos(String sigla);
    
    // Query nativa: Retorna o maior municipio de um estado
    @Query(value = "SELECT nm_mun,(ST_Area(geom)) AS area FROM br_municipios_2020 WHERE sigla_uf = :sigla ORDER BY area DESC  LIMIT 1", nativeQuery = true)
    public List<String> maiorMunicipio(String sigla);

     // Query nativa: Retorna o tamanho (m2) de um estado pela sigla
    @Query(value = "select sigla_uf, SUM(st_area(geom)) AS tamanho FROM br_uf_2020 WHERE sigla_uf = :sigla GROUP BY sigla_uf", nativeQuery = true)
    public List<String> tamanhoEstado(String sigla);
}
