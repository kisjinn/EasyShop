package dev.sakshi.easyshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    The authorizeHttpRequests method configures the authorization rules.
//    The .requestMatchers("/search/**").permitAll() line allows all requests to /search/ without authentication.
//    The csrf(csrf -> csrf.disable()) line disables CSRF protection.
//    The cors(Customizer.withDefaults()) method enables CORS with default settings.
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/products").hasAuthority("admin")
                                .requestMatchers("/search/**").permitAll()  // Allow all requests to /search/ without authentication
                                .requestMatchers("/fakeproducts/{id}").permitAll()
                                .requestMatchers("/products/{id}").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwtConfigurer -> {
                            jwtConfigurer.jwtAuthenticationConverter(new CustomJwtAuthenticationConverter());
                        })
                )
                .formLogin(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable());
//                .cors(Customizer.withDefaults());

        return http.build();
    }

//    The CorsConfigurationSource bean defines the CORS configuration.
//    The CorsConfiguration object is used to set allowed origins, methods, and headers.
//    The UrlBasedCorsConfigurationSource object is used to register the CORS configuration for all endpoints (/**).
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("*"));  // Allow all origins
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(List.of("*"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}








//package dev.sakshi.easyshop.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
//            throws Exception {
//        http
//
//                .authorizeHttpRequests((authorize) ->
//                         authorize.requestMatchers("/products").hasAuthority("admin").anyRequest().authenticated()
//                ).oauth2ResourceServer((oauth2) -> oauth2.jwt(jwtConfigurer -> {
//                    //custom jwt converter which will convert roles from userservice to scope's value
//                    jwtConfigurer.jwtAuthenticationConverter(new CustomJwtAuthenticationConverter());
//                }))
//                 .formLogin(Customizer.withDefaults())
//                .csrf().disable().cors().disable();
//
//        // Form login handles the redirect to the login page from the
//        // authorization server filter chain
//
////
//
//        return http.build();
//    }
//}
