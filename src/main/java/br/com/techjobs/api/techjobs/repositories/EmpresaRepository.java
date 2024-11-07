package br.com.techjobs.api.techjobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.techjobs.api.techjobs.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    public List<Empresa> findByEmailContainingIgnoreCase(String email);
    public Empresa findByCnpj(String cnpj);
}
