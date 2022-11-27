package com.DH.DigitalBooking.config.jwt;

import com.DH.DigitalBooking.services.UserDetailsServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
//HERENCIA= va a llegar a este filtro por cada una de las peticiones que se hagan al sistema desde cualquier parte
public class JwtTokenFilterConfig extends OncePerRequestFilter {
//LLEGA ACÁ ANTES DE LLEGAR A CUALQUIER CONTROLADOR

    //inyecto los provider (la configuracion para acceder a los metodos)
    @Autowired
    private JwtProviderConfig jwtProviderConfig;
    //inyectamos la capa de lógica para poder buscar un usuario y autenticarlo en el scope de springsecurity
    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    /**
     * Metodo que hace un filtrado de las solicitudes para que antes de que llegue al
     * recurso se valide si esta permitido o no el acceso a dicho recurso
     * */
    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = myToken(request);
        if (token != null && jwtProviderConfig.validateToken(token)) {
            /**
             * Inicia a revisar si el token tiene los permisos para ingresar a ese recurso
             * que estamos consumiendo, ver que tenga y cuente con los tiempos actualizados
             * de expiración y de integridad.
             * */
            String username = jwtProviderConfig.getUserNameFromToken(token);
            //si ese user es el que viene en ese jwt Va hace la busqueda (para obtener un usuario ppal
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            //la parte donde voy a ir a registrar el usuario
            UsernamePasswordAuthenticationToken authenticationToken =
                    //envio el userDetails mas las autoridades pertinentes
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            //voy a decirle a to do el contexto de springboot que modifique la autenticazion con esas credenciales
            // que llegaron y esa validacion que llego a partir de user details
            //match entre usuarios y autoridades
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        //si es correcto lo previo va a permitir hacer request response.
        // Este filtro permite seguir con el flujo
        filterChain.doFilter(request, response);
    }

    /**
     * Metodo de apoyo para obtener el token que se esta enviando desde el front
     * Se hace un reemplazo del Bearer por un vacio "", esto para tener solamente el
     * token como tal
     * */
    private String myToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            //REEMPLAZO EL Bearer (postman) por un string vacío para obtener SOLAMENTE el Token
            return header.replace("Bearer ", "");
        }
        return null;
    }
}
