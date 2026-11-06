package br.com.example.repository;

import br.com.example.model.Rodovia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RodoviaRepository extends JpaRepository<Rodovia, Long> {

    // Consulta 1: Rodovias próximas a um aeroporto específico (ST_DWithin)
    @Query(value = "SELECT r.* FROM rodovias r " +
                   "WHERE ST_DWithin(" +
                   "  ST_Transform(r.geom, 3857), " +
                   "  (SELECT ST_Transform(a.geom, 3857) FROM aeroportos a WHERE a.gid = :aeroportoId), " +
                   "  :distanciaMetros" +
                   ")", nativeQuery = true)
    List<Rodovia> findRodoviasProximasAoAeroporto(@Param("aeroportoId") Long aeroportoId, 
                                                 @Param("distanciaMetros") Double distanciaMetros);

    // Consulta 3: Rodovias que cruzam ferrovias (ST_Intersects)
    @Query(value = "SELECT DISTINCT r.* FROM rodovias r, ferrovias f " +
                   "WHERE ST_Intersects(r.geom, f.geom)", nativeQuery = true)
    List<Rodovia> findRodoviasQueCruzamFerrovias();

    // Consulta 5: Rodovia mais próxima de um aeroporto específico (ST_Distance)
    @Query(value = "SELECT r.* FROM rodovias r " +
                   "ORDER BY ST_Distance(" +
                   "  ST_Transform(r.geom, 3857), " +
                   "  (SELECT ST_Transform(a.geom, 3857) FROM aeroportos a WHERE a.gid = :aeroportoId)" +
                   ") ASC " +
                   "LIMIT 1", nativeQuery = true)
    Rodovia findRodoviaMaisProximaAoAeroporto(@Param("aeroportoId") Long aeroportoId);
}