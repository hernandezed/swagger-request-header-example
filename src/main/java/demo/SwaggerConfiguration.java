package demo;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import com.wordnik.swagger.model.AuthorizationType;
import com.wordnik.swagger.model.BasicAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger
public class SwaggerConfiguration {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(springSwaggerConfig)
                .apiInfo(apiInfo())
                .authorizationTypes(authorizationTypes())
                .includePatterns("/demo/.*")
                .swaggerGroup("api");
    }

    /**
     * API Info as it appears on the swagger-ui page
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API",
                "API description",
                "https://link.to/terms/",
                "dev@api.company.com",
                "License",
                "https://link.to/license.html"
        );
    }

    private List<AuthorizationType> authorizationTypes() {
        final List<AuthorizationType> authorizationTypes = new ArrayList<>();
        authorizationTypes.add(new BasicAuth());
        return authorizationTypes;
    }
}

