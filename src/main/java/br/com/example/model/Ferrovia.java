package br.com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.MultiLineString;

@Entity
@Table(name = "ferrovias")
@Getter
@Setter
public class Ferrovia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    private String nome;

    @Column(columnDefinition = "geometry(MultiLineString, 4326)")
    private MultiLineString geom;
}