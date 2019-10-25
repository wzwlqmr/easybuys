package com.mr.easybuy.wares.util.es;

import org.elasticsearch.client.RestClientBuilder;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientBuilderCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClient implements RestClientBuilderCustomizer {

    @Override
    public void customize(RestClientBuilder builder) {
        //builder
    }
}
