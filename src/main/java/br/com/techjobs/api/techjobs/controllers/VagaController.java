package br.com.techjobs.api.techjobs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.techjobs.api.techjobs.models.Vaga;
import br.com.techjobs.api.techjobs.repositories.VagaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("vaga")
public class VagaController {
    @Autowired
    private VagaRepository _vagaRepository;

    @Operation(summary = "Obter vaga", description = "Endpoint para obter uma vaga pelo Id")
    @GetMapping("{id}")
    public Vaga obterVaga(@PathVariable Long id) {
        return _vagaRepository.findById(id).get();
    }

    @Operation(summary = "Obter vagas por empresa", description = "Endpoint para obter todas as vagas de uma empresa")
    @GetMapping("empresa/{id}")
    public List<Vaga> obterVagasPorEmpresa(@PathVariable Long id) {
        return _vagaRepository.findByEmpresa(id);
    }

    @PostMapping("vaga")
    public void inserirCandidato(@RequestBody Vaga vaga) {
        _vagaRepository.save(vaga);
    }
    
    @Operation(summary = "Deletar vaga", description = "Endpoint para deletar uma vaga pelo Id")
    @DeleteMapping("{id}")
    public void deletarVaga(@PathVariable Long id) {
        Optional<Vaga> op = _vagaRepository.findById(id);
        if (op.isPresent())
            _vagaRepository.deleteById(id);
    }

    @Operation(summary = "Atualizar vaga", description = "Endpoint para atualizar uma vaga")
    @PutMapping("{id}")
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
