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
@Table(name = "pontos_fronteira_2014")
public class CidadeFronteira implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "municdv")
    private String codigo;
    @Column(name = "municipio")
    private String nome;
    @Column(name = "nome_uf")
    private String estado;
    @Column(name = "nome_regia")
    private String regiao;
    @Column(name = "administra")
    private String administrador;
    @Column(name = "geom")
    private Geometry geometria;
}
