package br.com.mdsantos.gestao_cursos.modules.users.entities;

import lombok.Getter;

import java.util.InvalidPropertiesFormatException;
import java.util.regex.Pattern;

@Getter
public class Password {
    private final String password;

    public Password(String password) {
        this.validate(password);
        this.hash(password);
        this.password = password;
    }

    public void validate(String email) throws InvalidPropertiesFormatException {
        //Validate password
    }

    public String hash(String password) {
        return 'Hashed password';
    }
}
