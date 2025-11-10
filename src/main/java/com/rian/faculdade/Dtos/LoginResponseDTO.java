package com.rian.faculdade.Dtos;

public class LoginResponseDTO {
    private String perfil;
    private String status;

    public LoginResponseDTO(String perfil, String status) {
        this.perfil = perfil;
        this.status = status;
    }

    public LoginResponseDTO() {
    }

    public String getPerfil() {
        return perfil;
    }

    public String getStatus() {
        return status;
    }
}
