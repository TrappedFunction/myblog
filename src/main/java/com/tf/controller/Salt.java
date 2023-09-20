package com.tf.controller;

import java.security.SecureRandom;
import org.apache.commons.codec.binary.Hex;

public class Salt {
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Hex.encodeHexString(salt);
    }
}
