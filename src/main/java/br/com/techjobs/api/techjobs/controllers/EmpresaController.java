package br.com.techjobs.api.techjobs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.techjobs.api.techjobs.models.AplicacaoVaga;
import br.com.techjobs.api.techjobs.models.Empresa;
import br.com.techjobs.api.techjobs.models.Vaga;
import br.com.techjobs.api.techjobs.models.dtos.DashInfoEmpresa;
import br.com.techjobs.api.techjobs.repositories.AplicacaoVagaRepository;
import br.com.techjobs.api.techjobs.repositories.EmpresaRepository;
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

@Tag(name = "Empresa")
@RestController
@RequestMapping("empresa")
public class EmpresaController {
    @Autowired
    private EmpresaRepository _empresaRepository;

    @Autowired
    private VagaRepository _vagaRepository;

    @Autowired
    private AplicacaoVagaRepository _aplicacaoVagaRepository;

    @Operation(summary = "Obter todas as empresas", description = "Endpoint para obter todas as empresas cadastradas")
    @GetMapping()
    public List<Empresa> obterEmpresas() {
        return _empresaRepository.findAll();
    }

    @Operation(summary = "Obter empresa pelo Id", description = "Endpoint para obter uma empresa pelo Id")
    @GetMapping("{id}")
    public Empresa obterEmpresa(@PathVariable Long id) {
        return _empresaRepository.findById(id).get();
    }

    @Operation(summary = "Obter empresas pelo E-mail", description = "Endpoint para obter empresas pelo E-mail")
    @GetMapping("email/{email}")
    public List<Empresa> obterEmpresaPorEmail(@PathVariable String email) {
        return _empresaRepository.findByEmailContainingIgnoreCase(email);
    }

    @Operation(summary = "Obter empresa pelo CNPJ exato", description = "Endpoint para obter uma empresa pelo CNPJ exato")
    @GetMapping("cnpj/{cnpj}")
    public Empresa obterEmpresaPorCnpj(@PathVariable String cnpj) {
        return _empresaRepository.findByCnpj(cnpj);
    }

    @Operation(summary = "Obter empresa pelo Nome", description = "Endpoint para obter empresas pelo nome")
    @GetMapping("nome/{nome}")
    public List<Empresa> obterEmpresaPorNome(@PathVariable String nome) {
        return _empresaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Operation(summary = "Deletar empresa", description = "Endpoint para deletar uma empresa pelo Id")
    @DeleteMapping("{id}")
    public void deletarEmpresaPorId(@PathVariable Long id){
        Optional<Empresa> op = _empresaRepository.findById(id);
        if (op.isPresent())
            _empresaRepository.deleteById(id);
    }

    @Operation(summary = "Cadastrar empresa", description = "Endpoint para cadastrar uma empresa")
    @PostMapping()
    public void inserirCandidato(@RequestBody Empresa empresa) {
        _empresaRepository.save(empresa);
    }
    
    @Operation(summary = "Atualizar empresa", description = "Endpoint para atualizar os dados de uma empresa")
    @PutMapping("{id}")
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

    @Operation(summary = "Recusar aplicação", description = "Enpoint para recusar uma aplicação")
    @PostMapping("aplicacao/recusar/{id}")
    public void recusarAplicacao(@PathVariable Long id) {
        Optional<AplicacaoVaga> op = _aplicacaoVagaRepository.findById(id);

        if (op.isPresent()) {
            AplicacaoVaga aplicacao = op.get();

            aplicacao.setSituacao("Recusado");

            _aplicacaoVagaRepository.save(aplicacao);
        }
    }

    @Operation(summary = "Aprovar aplicação", description = "Enpoint para aprovar uma aplicação")
    @PostMapping("aplicacao/aprovar/{id}")
    public void aprovarAplicacao(@PathVariable Long id) {
        Optional<AplicacaoVaga> op = _aplicacaoVagaRepository.findById(id);

        if (op.isPresent()) {
            AplicacaoVaga aplicacao = op.get();

            aplicacao.setSituacao("Aprovado");

            _aplicacaoVagaRepository.save(aplicacao);
        }
    }

    @Operation(summary = "Obter aplicações", description = "Enpoint para obter aplicações de uma vaga específica")
    @GetMapping("aplicacao/{idVaga}")
    public List<AplicacaoVaga> obterAplicacaoVagas(@PathVariable Long idVaga) {
        Optional<Vaga> op = _vagaRepository.findById(idVaga);
        
        if (op.isPresent()) {
            return _aplicacaoVagaRepository.findByVaga(op.get());
        }

        return new ArrayList<AplicacaoVaga>();
    }

    @Operation(summary = "Obter informações Dash", description = "Enpoint para obter informações da Dashboard da empresa")
    @GetMapping("dashboard-info/{id}")
    public DashInfoEmpresa dashboardInfo(@PathVariable Long id) throws Exception {
        List<Vaga> vagas = _vagaRepository.findByEmpresa(id);
        Optional<Empresa> op = _empresaRepository.findById(id);
        
        if (op.isPresent()) {
            Empresa empresa = op.get();
            Long vagasDisponiveis = (long)vagas.size();
            return new DashInfoEmpresa(empresa.getNome(), empresa.getEmail(), vagasDisponiveis, vagas);
        }

        throw new Exception("Empresa não encontrada");
    }
}
