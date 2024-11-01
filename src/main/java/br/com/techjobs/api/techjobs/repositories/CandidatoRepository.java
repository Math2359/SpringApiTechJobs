package br.com.techjobs.api.techjobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.techjobs.api.techjobs.models.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    @Query(value = "SELECT * FROM Candidato WHERE Email=?",nativeQuery = true)
    public Candidato findByEmail(String email);
}
