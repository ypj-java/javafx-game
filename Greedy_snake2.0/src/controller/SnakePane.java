package controller;

import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Snake;

import java.util.HashMap;

public class SnakePane extends GridPane {

    private final Snake snake;

    private final Rectangle[] rectangles;

    private final HashMap<KeyCode, KeyCode> keyMap = new HashMap<>();

    public SnakePane(double length, int size){
        snake = new Snake(size);
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setWidth(length);
        this.setHeight(length);
        rectangles = new Rectangle[size*size];
        for(int i = 0 ; i < rectangles.length ; i++){
            rectangles[i] = new Rectangle(length/size,length/size);
            rectangles[i].setFill(Color.WHITE);
            this.add(rectangles[i], i%size, i/size);
        }
        this.addKeyMap();
    }

    public void move(KeyCode e){
        if(keyMap.containsKey(e))
            e = keyMap.get(e);
        if(e.getName().length()==1)
            this.moveSnake(snake.snake(e.getName().charAt(0)));
    }

    public void move(){
        moveSnake(snake.snake());
    }

    public int getScore(){
        return snake.getSize()-4;
    }

    private void moveSnake(int[] snake){
        for(int i = 0 ; i < snake.length ; i++){
            if(snake[i] > 0)
                rectangles[i].setFill(Color.BLUE);
            if(snake[i] < 0)
                rectangles[i].setFill(Color.GREEN);
            if(snake[i] == 0)
                rectangles[i].setFill(Color.WHITE);
        }
        rectangles[this.snake.getPosition()].setFill(Color.RED);
    }

    private void addKeyMap(){
        keyMap.put(KeyCode.UP, KeyCode.W);
        keyMap.put(KeyCode.DOWN, KeyCode.S);
        keyMap.put(KeyCode.LEFT, KeyCode.A);
        keyMap.put(KeyCode.RIGHT, KeyCode.D);
    }

}
