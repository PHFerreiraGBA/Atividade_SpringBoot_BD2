/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.CidadeFronteira;
import br.com.example.model.CidadeGemea;
import br.com.example.model.Municipio;
import br.com.example.model.MunicipioVO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author caian
 */
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

    @Query(value = "select new br.com.example.model.MunicipioVO(m.codigo, m.nome) from Municipio m where m.sigla = :uf order by m.nome asc")
    List<MunicipioVO> listarMunicipiosPorUf(String uf);

    @Query(value = "select new br.com.example.model.MunicipioVO(mb.codigo, mb.nome) from Municipio ma, Municipio mb where touches(ma.geometria, mb.geometria) = true and ma.nome = :nome")
    List<MunicipioVO> listarMunicipiosVizinhos(String nome);

    @Query(value = "select new br.com.example.model.MunicipioVO(cf.codigo, cf.nome) from CidadeFronteira cf where cf.regiao = :regiao order by cf.nome asc")
    List<MunicipioVO> listarCidadesFronteiraPorRegiao(String regiao);

    @Query(value = "select new br.com.example.model.MunicipioVO(cf.codigo, cf.nome) from CidadeFronteira cf where cf.estado = :estado order by cf.nome asc")
    List<MunicipioVO> listarCidadesFronteiraPorEstado(String estado);

    @Query(value = "select new br.com.example.model.MunicipioVO(cg.codigo, cg.nome) from CidadeGemea cg where cg.estado = :estado order by cg.nome asc")
    List<MunicipioVO> listarCidadesGemeasPorEstado(String estado);

    @Query(value = "select distance(geography(ma.geometria), geography(mb.geometria)) / 1000 from Municipio ma, Municipio mb where ma.nome = :municipioA and mb.nome = :municipioB")
    Double distanciaEntreMunicipios(String municipioA, String municipioB);

    @Query(value = "select new br.com.example.model.MunicipioVO(m.codigo, m.nome) from Municipio m order by m.areaKm2 desc limit :k")
    List<MunicipioVO> topKMaioresMunicipiosPorKM2(int k);
}
