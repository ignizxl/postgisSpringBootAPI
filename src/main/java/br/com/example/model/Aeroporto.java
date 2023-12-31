/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author joão igor
 */
@Entity
@Table(name = "aeroportos_2014")
public class Aeroporto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;

    @Column(name = "uf")
    private String uf;
    
    @Column(name = "municipio")
    private String municipio;
    
    @Column(name = "geom")
    private Geometry geom;
    
    
    @Column(name = "nm_regiao")
    private Geometry nm_regiao;

}
