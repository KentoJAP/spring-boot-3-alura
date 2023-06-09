package med.voll.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperarToken(request);

        var subject = tokenService.getSubject(tokenJWT);
        System.out.println(subject);

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {

        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null) {
            throw new RuntimeException("Token JWT não enviado no cabeçalho Authorization.");
        }
        //OBS: O replace só foi comentado pq o Boomerang não envia o prefixo por padrão
        //isso estava fazendo com q o token enviado não fosse igual ao capturado
        return authorizationHeader;//.replace("Bearer ", "");
    }
}
