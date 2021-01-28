package com.adverbase.demo.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Util
{
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "123456789";


    public String generateAdverNumber(int length)
    {
        return generateRandomString(length);
    }

    private String generateRandomString(int length)
    {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i<length; i++)
        {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }
}
