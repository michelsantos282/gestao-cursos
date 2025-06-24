package br.com.mdsantos.gestao_cursos.modules.auth;

import br.com.mdsantos.gestao_cursos.modules.auth.dto.CreateAuthRequestDto;
import br.com.mdsantos.gestao_cursos.modules.auth.useCases.CreateAuthUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CreateAuthUseCase createAuthUseCase;

    public AuthController(CreateAuthUseCase createAuthUseCase) {
        this.createAuthUseCase = createAuthUseCase;
    }

    @PostMapping("/instructor")
    public ResponseEntity<?> authInstructor(@RequestBody CreateAuthRequestDto createAuthRequestDto) {
        try {
            String token = this.createAuthUseCase.execute(createAuthRequestDto);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
