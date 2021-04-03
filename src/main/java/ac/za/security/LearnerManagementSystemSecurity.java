package ac.za.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class LearnerManagementSystemSecurity extends  WebSecurityConfigurerAdapter{

    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Autowired
    public UserDetailsService userDetailsService;

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    };

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//}

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(encoder().encode("password"))
                .roles(USER_ROLE)
                .and()
                .withUser("admin")
                .password(encoder().encode("admin"))
                .roles(USER_ROLE, ADMIN_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

      http
                .cors()
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
              .antMatchers(HttpMethod.OPTIONS,"/basicauth").permitAll()
              .antMatchers(HttpMethod.GET,"/api/**").hasAnyRole(USER_ROLE,ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/api/**").hasRole(ADMIN_ROLE)
              .antMatchers(HttpMethod.PUT, "/api/**").hasRole(ADMIN_ROLE)
              .antMatchers(HttpMethod.DELETE,"/api/**").hasRole(ADMIN_ROLE)
                .and()
                .csrf().disable()
                .formLogin().disable();

    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(Arrays.asList("Authorization"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return  source;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
