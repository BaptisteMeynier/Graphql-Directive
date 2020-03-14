package com.meynier.spring.graphql.graphql.directive;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetcherFactories;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;


public class UppercaseDirective implements SchemaDirectiveWiring {

    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> env) {
        GraphQLFieldDefinition field = env.getElement();
        DataFetcher dataFetcher = DataFetcherFactories.wrapDataFetcher(env.getFieldDataFetcher(),
                (dataFetchingEnvironment, value) -> value.toString().toUpperCase()
    );
        return field.transform( builder -> builder.name("uppercase").dataFetcher(dataFetcher) );
    }
}
