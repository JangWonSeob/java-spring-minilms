package ko.co.dongyang.study.minilms.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {

    public static boolean notEquals(String plaintext, String hashed) {
        return !equals(plaintext, hashed);
    }

    private static boolean equals(String plaintext, String hashed) {
        if (plaintext == null || plaintext.length() < 1) {
            return false;
        }

        if (hashed == null || hashed.length() < 1) {
            return false;
        }
        return BCrypt.checkpw(plaintext, hashed);
    }

    public static String hashPassword(String plaintext) {

        if (plaintext == null || plaintext.length() < 1) {
            return "";
        }

        return BCrypt.hashpw(plaintext, BCrypt.gensalt());
    }

}
