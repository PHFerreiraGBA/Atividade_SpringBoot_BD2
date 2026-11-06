package br.com.example.repository;

import br.com.example.model.Ferrovia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FerroviaRepository extends JpaRepository<Ferrovia, Long> {

    // Consulta 2: Ferrovias próximas a um aeroporto específico (ST_DWithin)
    @Query(value = "SELECT f.* FROM ferrovias f " +
                   "WHERE ST_DWithin(" +
                   "  ST_Transform(f.geom, 3857), " +
                   "  (SELECT ST_Transform(a.geom, 3857) FROM aeroportos a WHERE a.gid = :aeroportoId), " +
                   "  :distanciaMetros" +
                   ")", nativeQuery = true)
    List<Ferrovia> findFerroviasProximasAoAeroporto(@Param("aeroportoId") Long aeroportoId, 
                                                   @Param("distanciaMetros") Double distanciaMetros);

    // Consulta 4: Ferrovias próximas a rodovias (ST_DWithin)
    @Query(value = "SELECT DISTINCT f.* FROM ferrovias f, rodovias r " +
                   "WHERE ST_DWithin(" +
                   "  ST_Transform(f.geom, 3857), " +
                   "  ST_Transform(r.geom, 3857), " +
                   "  :distanciaMetros" +
                   ")", nativeQuery = true)
    List<Ferrovia> findFerroviasProximasRodovias(@Param("distanciaMetros") Double distanciaMetros);
}