package br.com.techjobs.api.techjobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.techjobs.api.techjobs.models.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    public List<Candidato> findByEmailContainingIgnoreCase(String email);
}
