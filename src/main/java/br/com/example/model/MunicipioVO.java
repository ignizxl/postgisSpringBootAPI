/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.vividsolutions.jts.geom.Geometry;



/**
 *
 * @author caian
 */
@Data
@AllArgsConstructor
public class MunicipioVO implements Serializable{
    private String codigo;
    private String nome;
    private Geometry geometria;
}
