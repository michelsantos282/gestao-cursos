package br.com.mdsantos.gestao_cursos.modules.users.dto;

import br.com.mdsantos.gestao_cursos.modules.users.entities.RoleUser;

public record CreateUserRequestDto(
        String name,
        String email,
        String password,
        RoleUser roleUser
) {
}
