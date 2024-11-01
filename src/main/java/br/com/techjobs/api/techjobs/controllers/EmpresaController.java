package br.com.techjobs.api.techjobs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.techjobs.api.techjobs.models.Empresa;
import br.com.techjobs.api.techjobs.repositories.EmpresaRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmpresaController {
    @Autowired
    private EmpresaRepository _empresaRepository;

    @GetMapping("empresa")
    public List<Empresa> obterEmpresas() {
        return _empresaRepository.findAll();
    }

    @GetMapping("empresa/{id}")
    public Empresa obterEmpresa(@PathVariable Long id) {
        return _empresaRepository.findById(id).get();
    }

    @GetMapping("empresa-email/{email}")
    public Empresa obterEmpresaPorEmail(@PathVariable String email) {
        return _empresaRepository.findByEmail(email);
    }

    @GetMapping("empresa-cnpj/{cnpj}")
    public Empresa obterEmpresaPorCnpj(@PathVariable String cnpj) {
        return _empresaRepository.findByCnpj(cnpj);
    }

    @DeleteMapping("empresa/{id}")
    public void deletarEmpresaPorId(@PathVariable Long id){
        Optional<Empresa> op = _empresaRepository.findById(id);
        if (op.isPresent())
            _empresaRepository.deleteById(id);
    }

    @PostMapping("empresa")
    public void inserirCandidato(@RequestBody Empresa empresa) {
        _empresaRepository.save(empresa);
    }
    
    @PutMapping("empresa/{id}")
    public void atualizarCandidato(@PathVariable Long id, @RequestBody Empresa empresa) {
        Optional<Empresa> op = _empresaRepository.findById(id);

        if (op.isPresent()) {
            Empresa atualizarEmpresa = op.get();
            atualizarEmpresa.setEmail(empresa.getEmail());
            atualizarEmpresa.setNome(empresa.getNome());
            atualizarEmpresa.setSenha(empresa.getSenha());
            atualizarEmpresa.setCnpj(empresa.getCnpj());
            _empresaRepository.save(atualizarEmpresa);
        }
    }
}
