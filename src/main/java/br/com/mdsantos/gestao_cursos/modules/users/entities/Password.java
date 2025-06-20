package br.com.mdsantos.gestao_cursos.modules.users.entities;

import br.com.mdsantos.gestao_cursos.exceptions.ValidationException;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Password {
    private final String password;
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 16;
    private static final Pattern UPPER_CASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWER_CASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[0-9]");

    public Password(String password) throws ValidationException {
        this.validate(password);
        this.hash(password);
        this.password = password;
    }

    public void validate(String password) throws ValidationException {
        if (password.length() < MIN_LENGTH ||
            password.length() > MAX_LENGTH ||
            !UPPER_CASE_PATTERN.matcher(password).find() ||
            !LOWER_CASE_PATTERN.matcher(password).find() ||
            !DIGIT_PATTERN.matcher(password).find()
        ) {
            throw new ValidationException("Password doesn't fill the criteria");
        }
    }

    public String hash(String password) {
        return password;
    }
}
