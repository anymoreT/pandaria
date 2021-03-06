package com.github.jakimli.pandaria.hooks;

import com.github.jakimli.pandaria.MockServer;
import com.google.common.collect.ImmutableMap;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.dreamhead.moco.Moco.by;
import static com.github.dreamhead.moco.Moco.json;
import static com.github.dreamhead.moco.Moco.uri;
import static com.google.common.collect.ImmutableList.of;

public class JsonSchemaMockHooks {

    @Autowired
    MockServer server;

    @Before("@verify_json_schema")
    public void jsonForJsonSchema() {
        server.server()
                .get(by(uri("/products/1")))
                .response(json(new ImmutableMap.Builder<>()
                        .put("productId", 1)
                        .put("productName", "A green door")
                        .put("price", 12.50)
                        .put("tags", of("home", "green"))
                        .build()));

        server.start();
    }
}
