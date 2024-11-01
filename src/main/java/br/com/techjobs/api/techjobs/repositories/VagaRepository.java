package br.com.techjobs.api.techjobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.techjobs.api.techjobs.models.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    @Query(value = "SELECT * FROM Vaga WHERE id_empresa=?",nativeQuery = true)
    public List<Vaga> findByEmpresa(Long id);
    
}
