package br.com.mdsantos.gestao_cursos.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//I Don't know if create a util classe is the best way
@Component
public class HashUtils {
    private static PasswordEncoder passwordEncoder;

    public HashUtils(PasswordEncoder passwordEncoder) {
        HashUtils.passwordEncoder = passwordEncoder;
    }

    public static String encode(String raw) {
        return passwordEncoder.encode(raw);
    }

    public static boolean matches(String raw, String hash) {
        return passwordEncoder.matches(raw, hash);
    }

}
