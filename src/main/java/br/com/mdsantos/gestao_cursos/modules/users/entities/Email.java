package br.com.mdsantos.gestao_cursos.modules.users.entities;

import lombok.Getter;

import java.util.InvalidPropertiesFormatException;
import java.util.regex.Pattern;

@Getter
public class Email {
    private final String email;

    public Email(String email) throws InvalidPropertiesFormatException {
        this.validate(email);
        this.email = email;
    }

    public void validate(String email) throws InvalidPropertiesFormatException {
        String EMAIL_PATTERN = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (!pattern.matcher(email).matches()) {
            throw new RuntimeException("Invalid email format");
        }
    }
}
