package br.com.techjobs.api.techjobs.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techjobs.api.techjobs.models.Candidato;
import br.com.techjobs.api.techjobs.models.Empresa;
import br.com.techjobs.api.techjobs.models.dtos.LoginDTO;
import br.com.techjobs.api.techjobs.models.dtos.UserCredentials;
import br.com.techjobs.api.techjobs.repositories.CandidatoRepository;
import br.com.techjobs.api.techjobs.repositories.EmpresaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Login")
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private CandidatoRepository _candidatoRepository;

    @Autowired
    private EmpresaRepository _empresaRepository;
    
    @Operation(summary = "Logar usuário", description = "Endpoint para logar um usuário, candidato ou empresa")
    @PostMapping()
    public UserCredentials login(@RequestBody LoginDTO login) throws Exception {
        Optional<Candidato> op = _candidatoRepository.findByEmailIgnoreCase(login.getEmail());

        if (op.isPresent()) {
            Candidato candidato = op.get();

            if (candidato.getSenha().equals(login.getSenha())) {
                return new UserCredentials(candidato.getId(), "Candidato");
            }
        }

        Optional<Empresa> opEmpresa = _empresaRepository.findByEmailIgnoreCase(login.getEmail());

        if (opEmpresa.isPresent()) {
            Empresa empresa = opEmpresa.get();

            if (empresa.getSenha().equals(login.getSenha())) {
                return new UserCredentials(empresa.getId(), "Empresa");
            }
        }

        throw new Exception("Usuário ou senha incorretos");
    }
}
