package br.com.techjobs.api.techjobs.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techjobs.api.techjobs.models.Candidato;
import br.com.techjobs.api.techjobs.models.Empresa;
import br.com.techjobs.api.techjobs.models.dtos.LoginDTO;
import br.com.techjobs.api.techjobs.repositories.CandidatoRepository;
import br.com.techjobs.api.techjobs.repositories.EmpresaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Tag(name = "Login")
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private CandidatoRepository _candidatoRepository;

    @Autowired
    private EmpresaRepository _empresaRepository;
    
    @Operation(summary = "Logar candidato", description = "Endpoint para logar um candidato")
    @GetMapping("candidato")
    public String loginCandidato(LoginDTO login) {
        Optional<Candidato> op = _candidatoRepository.findByEmailIgnoreCase(login.getEmail());

        if (op.isPresent()) {
            Candidato candidato = op.get();

            if (candidato.getSenha().equals(login.getSenha())) {
                return "Login feito com sucesso!";
            }

            return "Senha incorreta!";
        }

        return "Candidato não encontrado!";
    }

    @Operation(summary = "Logar empresa", description = "Endpoint para logar uma empresa")
    @GetMapping("empresa")
    public String loginEmpresa(LoginDTO login) {
        Optional<Empresa> op = _empresaRepository.findByEmailIgnoreCase(login.getEmail());

        if (op.isPresent()) {
            Empresa empresa = op.get();

            if (empresa.getSenha().equals(login.getSenha())) {
                return "Login feito com sucesso!";
            }

            return "Senha incorreta!";
        }

        return "Candidato não encontrado!";
    }
}
