package br.com.mdsantos.gestao_cursos.modules.users;

import br.com.mdsantos.gestao_cursos.exceptions.ValidationException;
import br.com.mdsantos.gestao_cursos.modules.users.dto.CreateUserRequestDto;
import br.com.mdsantos.gestao_cursos.modules.users.entities.UserEntity;
import br.com.mdsantos.gestao_cursos.modules.users.useCases.CreateUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateUserRequestDto userCreateDto) {
        try {
            UUID result = this.createUserUseCase.execute(userCreateDto);
            return ResponseEntity.ok(result);
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
