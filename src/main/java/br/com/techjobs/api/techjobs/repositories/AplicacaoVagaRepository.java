package br.com.techjobs.api.techjobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.techjobs.api.techjobs.models.AplicacaoVaga;
import br.com.techjobs.api.techjobs.models.Candidato;

import java.util.List;


@Repository
public interface AplicacaoVagaRepository extends JpaRepository<AplicacaoVaga, Long> {
    public List<AplicacaoVaga> findByCandidato(Candidato candidato);
}