package com.snake.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import com.snake.game.SnakeGameApp;

public class PlatformSelector extends Stage {
    public PlatformSelector() {
        setTitle("Selecciona el tamaño de la plataforma");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label widthLabel = new Label("Ancho:");
        TextField widthField = new TextField("20");
        Label heightLabel = new Label("Alto:");
        TextField heightField = new TextField("20");
        Button startButton = new Button("Iniciar Juego");
        
        grid.add(widthLabel, 0, 0);
        grid.add(widthField, 1, 0);
        grid.add(heightLabel, 0, 1);
        grid.add(heightField, 1, 1);
        grid.add(startButton, 1, 2);
        
        startButton.setOnAction(e -> {
            try {
                int width = Integer.parseInt(widthField.getText());
                int height = Integer.parseInt(heightField.getText());
                // Inicia la aplicación del juego en una nueva ventana
                SnakeGameApp gameApp = new SnakeGameApp(width, height);
                gameApp.start(new Stage());
                close();
            } catch (NumberFormatException ex) {
                // Aquí se podría mostrar un mensaje de error
                System.err.println("Por favor ingresa números válidos.");
            }
        });
        
        Scene scene = new Scene(grid, 300, 200);
        setScene(scene);
    }
}
