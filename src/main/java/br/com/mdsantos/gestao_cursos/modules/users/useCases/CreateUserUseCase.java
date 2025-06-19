package br.com.mdsantos.gestao_cursos.modules.users.useCases;

import br.com.mdsantos.gestao_cursos.modules.users.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    public void execute(UserEntity user) {
        if (user.getName() == null || user.getEmail() == null ||  user.getPassword() == null || user.getRoleUser() == null) {
            throw new RuntimeException("Fill required fields");
        }
    }
}
