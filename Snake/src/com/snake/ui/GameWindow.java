package com.snake.ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import com.snake.logic.GameEngine;
import com.snake.logic.Position;

public class GameWindow extends StackPane {
    public static final int TILE_SIZE = 25;
    private Canvas canvas;
    private GraphicsContext gc;
    private GameEngine engine;
    
    public GameWindow(GameEngine engine) {
        this.engine = engine;
        int width = engine.getGridWidth() * TILE_SIZE;
        int height = engine.getGridHeight() * TILE_SIZE;
        canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
        getChildren().add(canvas);
    }
    
    public void draw() {
        // Limpiar el canvas
        gc.setFill(Color.web("#202020"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Dibujar la comida
        Position foodPos = engine.getFood().getPosition();
        gc.setFill(Color.RED);
        gc.fillOval(foodPos.getX() * TILE_SIZE, foodPos.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        
        // Dibujar la serpiente
        gc.setFill(Color.LIMEGREEN);
        engine.getSnake().getBody().forEach(pos -> {
            gc.fillRect(pos.getX() * TILE_SIZE, pos.getY() * TILE_SIZE, TILE_SIZE - 1, TILE_SIZE - 1);
        });
    }
}
