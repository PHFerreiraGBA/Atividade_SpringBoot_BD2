package br.com.example.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.locationtech.jts.geom.Geometry;

@Data
@Entity
@Table(name = "cidades_gemeas_2014")
public class CidadeGemea implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "municdv")
    private String codigo;
    @Column(name = "municipio")
    private String nome;
    @Column(name = "nome_uf")
    private String estado;
    @Column(name = "geom")
    private Geometry geometria;
}
