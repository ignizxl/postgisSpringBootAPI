package br.com.example.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.vividsolutions.jts.geom.Geometry;

@Entity
@Table(name = "br_municipios_2020")
public class Municipio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "cd_mun")
    private String codigo;
    @Column(name = "nm_mun")
    private String nome;
    @Column(name = "sigla_uf")
    private String sigla;
    @Column(name = "area_km2")
    private double areaKm2;    
    @Column(name = "geom")
    private Geometry geometria;


    @Override
    public String toString() {
        return "Municipio{" + "gid=" + gid + ", codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + ", areaKm2=" + areaKm2 + ", geometria=" + geometria + '}';
    }  
}
