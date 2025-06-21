package br.com.techjobs.api.techjobs.models.dtos;

public class UserCredentials {
    private Long id;
    public Long getId() {
        return id;
    }
    public void setEmail(Long id) {
        this.id = id;
    }

    private String perfil;
    public String getperfil() {
        return perfil;
    }
    public void setperfil(String perfil) {
        this.perfil = perfil;
    }

    public UserCredentials(Long id, String perfil) {
        this.id = id;
        this.perfil = perfil;
    }
}
