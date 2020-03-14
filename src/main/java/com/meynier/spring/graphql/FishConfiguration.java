package com.meynier.spring.graphql;

import com.meynier.spring.graphql.graphql.directive.UppercaseDirective;
import graphql.kickstart.tools.boot.SchemaDirective;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FishConfiguration {

    @Bean
    public SchemaDirective uppercaseDirective(){
        return new SchemaDirective("uppercase",new UppercaseDirective());
    }
}
