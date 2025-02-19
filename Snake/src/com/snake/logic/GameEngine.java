package com.snake.logic;

import java.util.Random;

public class GameEngine {
    private int gridWidth;
    private int gridHeight;
    private Snake snake;
    private Food food;
    private Random random;
    private boolean gameOver;
    
    public GameEngine(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        snake = new Snake(gridWidth / 2, gridHeight / 2);
        random = new Random();
        spawnFood();
    }
    
    public void update() {
        if (gameOver) return;
        
        snake.move();
        Position head = snake.getHead();
        
        // Comprobar colisión con la pared
        if (head.getX() < 0 || head.getX() >= gridWidth || head.getY() < 0 || head.getY() >= gridHeight) {
            gameOver = true;
            System.out.println("¡Game Over! Colisión con la pared.");
        }
        
        // Comprobar colisión con sí misma
        if (snake.checkSelfCollision()) {
            gameOver = true;
            System.out.println("¡Game Over! La serpiente se chocó consigo misma.");
        }
        
        // Comprobar si se ha comido la comida
        if (head.equals(food.getPosition())) {
            snake.grow();
            spawnFood();
        }
    }
    
    private void spawnFood() {
        int x, y;
        do {
            x = random.nextInt(gridWidth);
            y = random.nextInt(gridHeight);
        } while (snake.getBody().contains(new Position(x, y)));
        food = new Food(x, y);
    }
    
    public Snake getSnake() {
        return snake;
    }
    
    public Food getFood() {
        return food;
    }
    
    public int getGridWidth() {
        return gridWidth;
    }
    
    public int getGridHeight() {
        return gridHeight;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public void setDirection(Direction direction) {
        snake.setDirection(direction);
    }
}
