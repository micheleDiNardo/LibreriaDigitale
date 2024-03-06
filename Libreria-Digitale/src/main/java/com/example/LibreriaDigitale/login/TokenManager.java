package com.example.LibreriaDigitale.login;

import java.time.LocalDateTime;
import java.util.Base64;

import com.example.LibreriaDigitale.models.Utente;

public class TokenManager {

    private static final String SECRET_KEY = "micheleDiNardoXXX";

    private TokenManager() {
    }

    public static String generatoreToken(Utente utente) {
        String token = utente.getCognome() + utente.getEmail() + LocalDateTime.now().toString();
        String tokenFirmato = firmaToken(token);

        return tokenFirmato;
    }

    private static String firmaToken(String token) {
        String tokenDaCriptare = token + SECRET_KEY;

        return Base64.getEncoder().encodeToString(tokenDaCriptare.getBytes());
    }

    public static boolean validatoreToken(String token) {
        String tokenDecodificato = new String(Base64.getDecoder().decode(token));
        String tokenDecodificatoSenzaFirma = tokenDecodificato.substring(0,
                tokenDecodificato.length() - SECRET_KEY.length());
        String tokenAspettativa = firmaToken(tokenDecodificatoSenzaFirma);

        return token.equals(tokenAspettativa);
    }

}
