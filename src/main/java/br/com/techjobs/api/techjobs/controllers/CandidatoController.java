package br.com.techjobs.api.techjobs.controllers;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.techjobs.api.techjobs.models.AplicacaoVaga;
import br.com.techjobs.api.techjobs.models.Candidato;
import br.com.techjobs.api.techjobs.models.Vaga;
import br.com.techjobs.api.techjobs.models.dtos.DashInfoCandidato;
import br.com.techjobs.api.techjobs.repositories.AplicacaoVagaRepository;
import br.com.techjobs.api.techjobs.repositories.CandidatoRepository;
import br.com.techjobs.api.techjobs.repositories.VagaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Tag(name = "Candidato")
@RestController
@RequestMapping("candidato")
public class CandidatoController {
    @Autowired
    private CandidatoRepository _candidatoRepository;

    @Autowired
    private AplicacaoVagaRepository _aplicacaoVagaRepository;

    @Autowired
    private VagaRepository _vagaRepository;

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

    @Operation(summary = "Obter candidatos por E-mail", description = "Endpoint para obter candidatos por E-mail")
    @GetMapping("email/{email}")
    public List<Candidato> obterCandidatosPorEmail(@PathVariable String email) {
        return _candidatoRepository.findByEmailContainingIgnoreCase(email);
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

    @Operation(summary = "Aplicar vaga", description = "Endpoint para um candidato específico se candidatar a uma vaga")
    @PostMapping("aplicadas/{idCandidato}/{idVaga}")
    public void aplicarVaga(@PathVariable Long idCandidato, @PathVariable Long idVaga) throws Exception {
        Optional<Vaga> opVaga = _vagaRepository.findById(idVaga);
        Optional<Candidato> op = _candidatoRepository.findById(idCandidato);
        
        if (opVaga.isPresent() && op.isPresent()) {
            Vaga vaga = opVaga.get();
            Candidato candidato = op.get();

            AplicacaoVaga aplicacao = new AplicacaoVaga(vaga, candidato, "Aguardando");

            _aplicacaoVagaRepository.save(aplicacao);
        } else {
            throw new Exception("Vaga ou Candidato não existem!");
        }
    }

    @Operation(summary = "Obter vagas aplicadas", description = "Endpoint para obter vagas aplicadas de um determinado candidato")
    @GetMapping("aplicadas/{idCandidato}")
    public List<AplicacaoVaga> obterVagasAplicadas(@PathVariable Long idCandidato) throws Exception {
        Optional<Candidato> op = _candidatoRepository.findById(idCandidato);

        if (op.isPresent()) {
            return _aplicacaoVagaRepository.findByCandidato(op.get());
        }

        throw new Exception("Candidato não existe");
    }
    
    

    @Operation(summary = "Obter informações Dash", description = "Enpoint para obter informações da Dashboard do candidato")
    @GetMapping("dashboard-info/{id}")
    public DashInfoCandidato dashboardInfo(@PathVariable Long id) throws Exception {
        Long disponivel = _vagaRepository.count();
        Optional<Candidato> op = _candidatoRepository.findById(id);
        
        if (op.isPresent()) {
            Candidato candidato = op.get();
            Long aplicadas = (long)_aplicacaoVagaRepository.findByCandidato(candidato).size();
            return new DashInfoCandidato(candidato.getNome(), candidato.getEmail(), disponivel, aplicadas);
        }

        throw new Exception("Candidato não encontrado");
    }
}
