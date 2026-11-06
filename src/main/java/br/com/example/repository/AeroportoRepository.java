package br.com.example.repository;

import br.com.example.model.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
}