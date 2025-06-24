package br.com.mdsantos.gestao_cursos.modules.auth.useCases;

import br.com.mdsantos.gestao_cursos.exceptions.ValidationException;
import br.com.mdsantos.gestao_cursos.modules.auth.dto.CreateAuthRequestDto;
import br.com.mdsantos.gestao_cursos.modules.users.UserRepository;
import br.com.mdsantos.gestao_cursos.modules.users.entities.Email;
import br.com.mdsantos.gestao_cursos.modules.users.entities.RoleUser;
import br.com.mdsantos.gestao_cursos.modules.users.entities.UserEntity;
import br.com.mdsantos.gestao_cursos.utils.HashUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class CreateAuthUseCase {

    private final UserRepository userRepository;

    public CreateAuthUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String execute(CreateAuthRequestDto createAuthRequestDto) throws UsernameNotFoundException, ValidationException {
        //Verifica se email é valido
        Email userEmail = new Email(createAuthRequestDto.email());

        //Verifica se email existe
        Optional<UserEntity> user = userRepository.findByEmail(userEmail);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Invalid email or password");
        }

        if (!user.get().getRoleUser().equals(RoleUser.INSTRUCTOR)) {
            throw new UsernameNotFoundException("Invalid email or password");
        }

        //Verifica se senha esta correta
        if (!HashUtils.matches(createAuthRequestDto.password(), user.get().getPasswordHash())) {
            throw new UsernameNotFoundException("Invalid email or password");
        }

        SecretKey key = Keys.hmacShaKeyFor("mM'T_:FN48J5,\\D>.M+p1~0.`tj.\"mM'T_:FN48J5,\\\\D>.M+p1~0.`tj.".getBytes());
        var issuedAt = Instant.now();
        var expiresIn =issuedAt.plus(Duration.ofMinutes(3));
        return Jwts.builder()
                .setSubject(user.get().getEmail())
                .issuer("gestao_cursos")
                .issuedAt(Date.from(issuedAt))
                .expiration(Date.from(expiresIn))
                .signWith(key)
                .compact();
    }
}
