import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.boot.starter.autoconfigure.SwaggerUiWebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("unused")
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer  {

   
	@Bean
    public Docket api() {
    	  Docket docket = new Docket(DocumentationType.SWAGGER_2)
                  .select().apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                  .paths((PathSelectors.regex("/.*"))).build();
          return docket;
    }
}
