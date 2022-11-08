package ru.rtu_mirea.apipractice5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.core.env.Environment;

public class PortConfig implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Autowired
    private Environment environment;

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        if (environment.getProperty("PORT") != null) {
            factory.setPort(Integer.parseInt(environment.getProperty("PORT")));
        } else {
            factory.setPort(8080);
        }
    }
}
