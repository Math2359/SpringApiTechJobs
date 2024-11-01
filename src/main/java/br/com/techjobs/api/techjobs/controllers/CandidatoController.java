package br.com.techjobs.api.techjobs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.techjobs.api.techjobs.models.Candidato;
import br.com.techjobs.api.techjobs.repositories.CandidatoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CandidatoController {
    @Autowired
    private CandidatoRepository _candidatoRepository;

    @GetMapping("/candidato")
    public List<Candidato> obterCandidatos() {
        return _candidatoRepository.findAll();
    }

    @GetMapping("/candidato/{id}")
    public Candidato obterCandidato(@PathVariable Long id) {
        return _candidatoRepository.findById(id).get();
    }

    @GetMapping("/candidato-email/{email}")
    public Candidato obterCandidatoPorEmail(@PathVariable String email) {
        return _candidatoRepository.findByEmail(email);
    }

    @DeleteMapping("/candidato/{id}")
    public void deletarCandidatoPorId(@PathVariable Long id){
        Optional<Candidato> op = _candidatoRepository.findById(id);
		if(op.isPresent())
			_candidatoRepository.deleteById(id);
    }

    @PostMapping("/candidato")
    public void inserirCandidato(@RequestBody Candidato candidato) {
        _candidatoRepository.save(candidato);
    }
    
    @PutMapping("/candidato/{id}")
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
