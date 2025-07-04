package com.hhautomator;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class MainApplication extends Application {
    private static ConfigurableApplicationContext context;
    private static String[] savedArgs;

    @Override
    public void init() throws Exception {
        context = new SpringApplicationBuilder(MainApplication.class)
            .headless(false)
            .run(savedArgs);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HH.ru Automator");
        // Здесь будет инициализация JavaFX
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }

    public static void main(String[] args) {
        savedArgs = args;
        Application.launch(MainApplication.class, args);
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}