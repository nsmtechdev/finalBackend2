package com.dh.catalog;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;
import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.annotation.Configuration;

import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class BaseAPI {

   /* protected static Configuration configuration;

    @BeforeAll
    public static void beforeAllTests() {
        configuration = ConfigurationManager.getConfiguration();

        baseURI = configuration.baseURI();
        basePath = configuration.basePath();
        port = configuration.port();

        // solve the problem with big decimal assertions
        config = newConfig().
                jsonConfig(jsonConfig().numberReturnType(NumberReturnType.BIG_DECIMAL)).
                sslConfig(new SSLConfig().allowAllHostnames());

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }
*/



}