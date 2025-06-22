package br.com.mdsantos.gestao_cursos.modules.courses.dto;

import br.com.mdsantos.gestao_cursos.modules.users.entities.RoleUser;

public record CreateCourseRequestDto(
        String title,
        String description
) {
}
