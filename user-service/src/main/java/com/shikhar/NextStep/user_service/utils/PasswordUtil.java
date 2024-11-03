package com.shikhar.NextStep.user_service.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    // hash the password using bcrypt
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    // check if password if matched the hashed password
    public static boolean checkPassword(String hashedPassword, String providedPassword) {
        return BCrypt.checkpw(providedPassword, hashedPassword);
    }
}
