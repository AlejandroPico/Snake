package com.snake.game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.snake.logic.GameEngine;
import com.snake.ui.GameWindow;
import com.snake.input.InputHandler;

public class SnakeGameApp {
    private int gridWidth;
    private int gridHeight;
    
    public SnakeGameApp(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }
    
    public void start(Stage stage) {
        // Crear la lógica del juego y la ventana de dibujo
        GameEngine engine = new GameEngine(gridWidth, gridHeight);
        GameWindow gameWindow = new GameWindow(engine);
        InputHandler inputHandler = new InputHandler(engine);
        
        Scene scene = new Scene(gameWindow, gridWidth * GameWindow.TILE_SIZE, gridHeight * GameWindow.TILE_SIZE);
        scene.setOnKeyPressed(inputHandler::handleKeyPress);
        
        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.show();
        
        // Bucle principal del juego usando AnimationTimer
        new AnimationTimer() {
            long lastTick = 0;
            final long tickInterval = 200_000_000; // 200ms por tick

            @Override
            public void handle(long now) {
                if (lastTick == 0) {
                    lastTick = now;
                    engine.update();
                    gameWindow.draw();
                    return;
                }
                if (now - lastTick > tickInterval) {
                    lastTick = now;
                    engine.update();
                    gameWindow.draw();
                }
            }
        }.start();
    }
}
