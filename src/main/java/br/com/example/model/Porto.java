/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model;

import com.vividsolutions.jts.geom.Geometry;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "portos_2014")
public class Porto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;

    @Column(name = "nm_regiao")
    private String nm_regiao;

    @Column(name = "nm_uf")
    private String nm_uf;

    @Column(name = "municipio")
    private String municipio;
    
    @Column(name = "uf")
    private String uf;
    
    @Column(name = "geom")
    private Geometry geom;

}
