package br.com.mdsantos.gestao_cursos.modules.users.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UserEntity {
    private UUID id;
    private String name;
    private Email email;
    private RoleUser roleUser;
    private Password password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
