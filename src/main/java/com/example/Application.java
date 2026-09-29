
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        Logger log = LoggerFactory.getLogger(Application.class);
        log.info("Java app started");
    }

    // Endpoint original: no afecta a los tests.
    @GetMapping("/")
    public String getStatus() {
        return "OK";
    }

    // Nuevo endpoint: muestra la versión.
    @GetMapping("/version")
    public String getVersion() {
        String version = System.getenv("APP_VERSION");

        if (version == null) {
            version = "desconocida";
        }

        return "Aplicacion Java - Version: " + version;
    }
}

