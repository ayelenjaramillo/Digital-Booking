package com.DH.DigitalBooking.config.security;
import com.DH.DigitalBooking.config.jwt.JwtEntryPointConfig;
import com.DH.DigitalBooking.config.jwt.JwtTokenFilterConfig;
import com.DH.DigitalBooking.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

//entidad de configuracion
@Configuration
//activacion de temas de seguridad
@EnableWebSecurity
//activacion de metodos permitidos dentro del ecosistema global de seguridad
@EnableGlobalMethodSecurity(prePostEnabled = true) /* extendes WebSecurityConfigurerAdapter DEPRECADO*/
public class SecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtEntryPointConfig jwtEntryPointConfig;

    /**
     * Registro de propiedades a implementar
     */
    @Bean
    public JwtTokenFilterConfig jwtTokenFilter() {
        return new JwtTokenFilterConfig();
    }
    @Primary
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean("authenticationManager")
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Registro de los endpoints, definiendo quien tiene acceso a cada uno de ellos, esto con el fin de darle
     * seguridad a nuestra aplicación
     */

    @Primary
    @Bean
    protected HttpSecurity configure(HttpSecurity http) throws Exception {
        //EN EL VIDEO RETORNA NULO
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/**", "/api/v1/user/**").permitAll()

                .antMatchers(HttpMethod.GET, "/api/v1/city/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/product/**").permitAll()

                .antMatchers(HttpMethod.GET, "/api/v1/image/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/policy/**").permitAll()
                 .antMatchers(HttpMethod.GET, "/api/v1/feature/").permitAll()

                .antMatchers(HttpMethod.POST, "/api/v1/product/").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/city/").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/image/").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/policy/").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/feature/").permitAll()

                .antMatchers(HttpMethod.PUT, "/api/v1/product/**", "/api/v1/category/**", "/api/v1/city/**", "/api/v1/feature/**", "/api/v1/policy/**", "/api/v1/product-feature/**", "/api/v1/role/**", "/api/v1/user/**").hasAnyRole("ADMIN")

                .antMatchers(HttpMethod.DELETE, "/api/v1/product/**", "/api/v1/category/**", "/api/v1/city/**", "/api/v1/feature/**", "/api/v1/policy/**", "/api/v1/product-feature/**", "/api/v1/role/**", "/api/v1/user/**").hasAnyRole("ADMIN")


                .antMatchers(HttpMethod.GET, "/api/v1/role/**", "/api/v1/user/**").hasAnyRole("ADMIN")


                //.antMatchers(HttpMethod.POST, "/api/v1/city/country").hasAnyRole("USER")
//                .antMatchers(HttpMethod.PUT, "/api/v1/product/**", "/api/v1/category/**"
//                        , "/api/v1/city/**", "/api/v1/feature/**", "/api/v1/policy/**", "/api/v1/product-feature/**"
//                        , "/api/v1/role/**", "/api/v1/user/**").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/v1/product/**", "/api/v1/category/**"
//                        , "/api/v1/city/**", "/api/v1/feature/**", "/api/v1/policy/**", "/api/v1/product-feature/**"
//                        , "/api/v1/role/**", "/api/v1/user/**").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/api/v1/role/**", "/api/v1/user/**").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/api/v1/booking/**", "/api/v1/favorite/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/v1/booking/**", "/api/v1/favorite/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/v1/booking/**", "/api/v1/favorite/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.GET, "/api/v1/booking/**", "/api/v1/favorite/**").hasAnyRole("USER", "ADMIN")
                //.anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPointConfig)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http;
    }

    /**
     * Se registran los cors origin para que el ecosistema permita el libre consumo de los endpoints desde
     * el front
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        //ACA SE VALIDA EL ORIGEN
        config.setAllowedOriginPatterns(Arrays.asList("*")); //acá se valida el origen u origenes que llegan, puede ser una url, una ip, etc
        //config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "*"));

        //OPTIONS SE DEJA (front envia 2, positivo segundo envio para los otros metodos)
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); //OPTIONS SE DEJA POR FRONT
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

        //INSTANCIAR LA CONFIGURACION Y EXPONERLA
        UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
        cors.registerCorsConfiguration("/**", config);
        return cors;
    }

    /**
     * Registro los filtros configurados anteriormente para que sea un filter implementado por sprinb
     * de esta manera uso e implemento el registro y apertura de los cors
     */
    //ANTES SE HACIA UN OVERRIDE
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
