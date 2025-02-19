package com.snake.game;

import com.snake.ui.PlatformSelector;

import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeGame extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage arg0) throws Exception {
		// Muestra la ventana para seleccionar el tamaño de la plataforma
        PlatformSelector selector = new PlatformSelector();
        selector.show();
	}

}
