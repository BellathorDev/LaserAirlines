
package cl.duoc.LaserAirlines.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Matias
 */

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
        registro.addViewController("/errores/404").setViewName("/errores/404");
        registro.addViewController("/serviciospremium");
        registro.addViewController("/serviciosturismos");
    }
    
}
