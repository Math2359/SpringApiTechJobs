package br.com.techjobs.api.techjobs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.techjobs.api.techjobs.models.Vaga;
import br.com.techjobs.api.techjobs.repositories.VagaRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class VagaController {
    @Autowired
    private VagaRepository _vagaRepository;

    @GetMapping("vaga")
    public List<Vaga> obterVagas() {
        return _vagaRepository.findAll();
    }

    @GetMapping("vaga/{id}")
    public Vaga obterVaga(@PathVariable Long id) {
        return _vagaRepository.findById(id).get();
    }

    @GetMapping("vaga-empresa/{id}")
    public List<Vaga> obterVagasPorEmpresa(@PathVariable Long id) {
        return _vagaRepository.findByEmpresa(id);
    }

    @PostMapping("vaga")
    public void inserirCandidato(@RequestBody Vaga vaga) {
        _vagaRepository.save(vaga);
    }
    
    @DeleteMapping("vaga/{id}")
    public void deletarVaga(@PathVariable Long id) {
        Optional<Vaga> op = _vagaRepository.findById(id);
        if (op.isPresent())
            _vagaRepository.deleteById(id);
    }

    @PutMapping("vaga/{id}")
    public void atualizarVaga(@PathVariable Long id, @RequestBody Vaga vaga) {
        Optional<Vaga> op = _vagaRepository.findById(id);
        if (op.isPresent()){
            Vaga atualizarVaga = op.get();
            atualizarVaga.setCargo(vaga.getCargo());
            atualizarVaga.setCep(vaga.getCep());
            atualizarVaga.setDescricao(vaga.getDescricao());
            atualizarVaga.setEmpresa(vaga.getEmpresa());
            atualizarVaga.setModelo(vaga.getModelo());
            atualizarVaga.setNumero(vaga.getNumero());
            atualizarVaga.setSalario(vaga.getSalario());
            atualizarVaga.setNivel(vaga.getNivel());
            _vagaRepository.save(atualizarVaga);
        }
    }
}
