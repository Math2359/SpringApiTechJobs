package br.com.techjobs.api.techjobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.techjobs.api.techjobs.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query(value = "SELECT * FROM Empresa WHERE Email=?",nativeQuery = true)
    public Empresa findByEmail(String email);
    @Query(value = "SELECT * FROM Empresa WHERE Cnpj=?",nativeQuery = true)
    public Empresa findByCnpj(String cnpj);
}
