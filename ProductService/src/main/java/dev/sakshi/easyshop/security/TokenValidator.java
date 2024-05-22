package dev.sakshi.easyshop.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TokenValidator {
    private RestTemplateBuilder restTemplateBuilder;
    TokenValidator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder=restTemplateBuilder;
    }
    //calling userService to validate token
    //if token is invalide then return Optional<Empty>
    //Otherwise return Op[tional which contain all of the data

    /**
     * Calls user service to validate the token.
     * If token is not valid, optional is empty.
     * Else optional contains all of the data in payload
     * @param token
     * @return
     */
    public Optional<JWTObj> validateToken(String token) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        return Optional.empty();
    }
}
