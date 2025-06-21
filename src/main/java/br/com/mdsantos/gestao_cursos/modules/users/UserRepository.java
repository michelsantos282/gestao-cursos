package br.com.mdsantos.gestao_cursos.modules.users;

import br.com.mdsantos.gestao_cursos.modules.users.entities.Email;
import br.com.mdsantos.gestao_cursos.modules.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    public Optional<UserEntity> findByEmail(Email email);
}
