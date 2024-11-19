package br.com.techjobs.api.techjobs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.techjobs.api.techjobs.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    public List<Empresa> findByEmailContainingIgnoreCase(String email);
    public Empresa findByCnpj(String cnpj);
    public List<Empresa> findByNomeContainingIgnoreCase(String nome);
    public Optional<Empresa> findByEmailIgnoreCase(String email);
}
