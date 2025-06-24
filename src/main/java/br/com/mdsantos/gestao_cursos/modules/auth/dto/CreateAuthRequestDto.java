package br.com.mdsantos.gestao_cursos.modules.auth.dto;

import br.com.mdsantos.gestao_cursos.modules.users.entities.Email;

public record CreateAuthRequestDto(
        String email,
        String password
) {
}
