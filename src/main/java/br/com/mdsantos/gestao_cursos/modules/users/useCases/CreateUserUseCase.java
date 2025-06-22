package br.com.mdsantos.gestao_cursos.modules.users.useCases;

import br.com.mdsantos.gestao_cursos.exceptions.ValidationException;
import br.com.mdsantos.gestao_cursos.modules.users.UserRepository;
import br.com.mdsantos.gestao_cursos.modules.users.dto.CreateUserRequestDto;
import br.com.mdsantos.gestao_cursos.modules.users.entities.Email;
import br.com.mdsantos.gestao_cursos.modules.users.entities.Password;
import br.com.mdsantos.gestao_cursos.modules.users.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID execute(CreateUserRequestDto user) throws ValidationException {
        if (user.name() == null || user.email() == null ||  user.password() == null || user.roleUser() == null) {
            throw new ValidationException("Fill required fields");
        }
        //Idk if it's the right way to do that
        Email userEmail = new Email(user.email());

        Optional<UserEntity> userExists = userRepository.findByEmail(userEmail);

        if (userExists.isPresent()) {
            throw new ValidationException("Email already exists");
        }

        //Idk if it's the right way to do that
        Password userPassword = new Password(user.password());

        UserEntity userEntity = UserEntity.builder()
                .email(userEmail)
                .password(userPassword)
                .name(user.name())
                .roleUser(user.roleUser()).build();

        return userRepository.save(userEntity).getId();
    }
}
