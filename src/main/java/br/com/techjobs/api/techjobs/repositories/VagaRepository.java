package br.com.techjobs.api.techjobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.techjobs.api.techjobs.models.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    @Query(value = "SELECT * FROM Vaga WHERE id_empresa=?",nativeQuery = true)
    public List<Vaga> findByEmpresa(Long id);
    @Query(value = "SELECT * FROM Vaga WHERE (?1 IS NULL OR LOWER(Cargo) LIKE ?1) AND (?2 IS NULL OR LOWER(Nivel) LIKE ?2) AND (?3 IS NULL OR LOWER(Modelo) LIKE ?3) AND (?4 IS NULL OR LOWER(Cep) LIKE ?4)", nativeQuery = true)
    public List<Vaga> findDiferente(String cargo, String nivel, String modelo, String cep);    
}
