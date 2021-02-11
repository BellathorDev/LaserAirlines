package cl.duoc.LaserAirlines.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Matias
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override 
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception{
        
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN","USERTUR","USERPRE")
                .and()
                .withUser("usertur")
                .password("{noop}123")
                .roles("USERTUR")
                .and()
                .withUser("userpre")
                .password("{noop}123")
                .roles("USERPRE")                
                ;
    }
    
    @Override
    protected void configure(HttpSecurity http)
            throws Exception{
        http.authorizeRequests()
                .antMatchers("/serviciospremium")
                .hasAnyRole("ADMIN","USERPRE")
                .antMatchers("/serviciosturismos")
                .hasAnyRole("ADMIN","USERTUR")
                .antMatchers("/")
                .hasAnyRole("USERPRE","USERTUR","ADMIN")
                .and()
                .formLogin()
                    .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403")
                
                ;
                
    }
    
}
