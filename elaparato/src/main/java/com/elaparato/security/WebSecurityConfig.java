package com.elaparato.security;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    public static final String ADMIN = "administrador";
    public static final String REPOSITOR = "repositor";
    public static final String VENDEDOR = "vendedor";
    private final JwtAuthConverter jwtAuthConverter;

    /*public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthConverter = new JwtAuthenticationConverter();
        jwtAuthConverter.setJwtGrantedAuthoritiesConverter(new JwtAuthConverter());

        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.GET, "/productos/**").hasAnyRole(ADMIN, REPOSITOR)
                .requestMatchers(HttpMethod.GET, "/ventas/**").hasAnyRole(ADMIN, VENDEDOR)
                .anyRequest().authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwt -> jwt
                        .jwtAuthenticationConverter(jwtAuthConverter))
                );
        return http.build();
    }*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/productos/**").hasAnyRole(ADMIN, REPOSITOR)
                .requestMatchers(HttpMethod.GET, "/ventas/**").hasAnyRole(ADMIN, VENDEDOR)
                .requestMatchers(HttpMethod.POST, "/ventas/**").hasAnyRole(ADMIN, VENDEDOR)
                .requestMatchers(HttpMethod.POST, "/productos/**").hasAnyRole(ADMIN, REPOSITOR)
                .requestMatchers(HttpMethod.PUT, "/productos/**").hasAnyRole(ADMIN, REPOSITOR)
                .requestMatchers(HttpMethod.PUT, "/ventas/**").hasAnyRole(ADMIN, VENDEDOR)
                .requestMatchers(HttpMethod.DELETE, "/productos/**").hasAnyRole(ADMIN, REPOSITOR)
                .requestMatchers(HttpMethod.DELETE, "/ventas/**").hasAnyRole(ADMIN, VENDEDOR)
                .anyRequest().authenticated();
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthConverter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

}

