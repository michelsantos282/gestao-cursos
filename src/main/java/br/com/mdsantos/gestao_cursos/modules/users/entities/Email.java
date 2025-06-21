package br.com.mdsantos.gestao_cursos.modules.users.entities;

import br.com.mdsantos.gestao_cursos.exceptions.ValidationException;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Getter
@NoArgsConstructor
@Embeddable
public class Email {
    private String email;

    public Email(String email) throws ValidationException {
        this.validate(email);
        this.email = email;
    }

    public void validate(String email) throws ValidationException {
        String EMAIL_PATTERN = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (!pattern.matcher(email).matches()) {
            throw new ValidationException("Invalid email format");
        }
    }
}
