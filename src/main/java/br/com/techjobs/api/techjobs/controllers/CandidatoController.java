package br.com.techjobs.api.techjobs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.techjobs.api.techjobs.models.Candidato;
import br.com.techjobs.api.techjobs.repositories.CandidatoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Tag(name = "Candidato")
@RestController
@RequestMapping("candidato")
public class CandidatoController {
    @Autowired
    private CandidatoRepository _candidatoRepository;

    @Operation(summary = "Obter todos os candidatos", description = "Endpoint para obter todos os candidatos")
    @GetMapping()
    public List<Candidato> obterCandidatos() {
        return _candidatoRepository.findAll();
    }

    @Operation(summary = "Obter candidato", description = "Endpoint para obter um candidato pelo Id")
    @GetMapping("{id}")
    public Candidato obterCandidato(@PathVariable Long id) {
        return _candidatoRepository.findById(id).get();
    }

    @GetMapping("/candidato-email/{email}")
    public Candidato obterCandidatoPorEmail(@PathVariable String email) {
        return _candidatoRepository.findByEmail(email);
    }

    @Operation(summary = "Deletar candidato", description = "Endpoint para deletar um candidato")
    @DeleteMapping("{id}")
    public void deletarCandidatoPorId(@PathVariable Long id){
        Optional<Candidato> op = _candidatoRepository.findById(id);
		if(op.isPresent())
			_candidatoRepository.deleteById(id);
    }

    @Operation(summary = "Cadastrar candidato", description = "Endpoint para cadastrar um candidato")
    @PostMapping()
    public void inserirCandidato(@RequestBody Candidato candidato) {
        _candidatoRepository.save(candidato);
    }
    
    @Operation(summary = "Atualizar candidato", description = "Endpoint para atualizar um candidato")
    @PutMapping("{id}")
    public void atualizarCandidato(@PathVariable Long id, @RequestBody Candidato candidato) {
        Optional<Candidato> op = _candidatoRepository.findById(id);

        if (op.isPresent()) {
            Candidato atualizarCandidato = op.get();
            atualizarCandidato.setEmail(candidato.getEmail());
            atualizarCandidato.setNome(candidato.getNome());
            atualizarCandidato.setSenha(candidato.getSenha());
            _candidatoRepository.save(atualizarCandidato);
        }
    }
}
