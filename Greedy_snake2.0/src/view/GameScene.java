package view;

import controller.SnakePane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class GameScene extends BorderPane {

    private BorderPane gamePane;

    private SnakePane snakePane;

    private Text score;

    private Text help;

    private Button start;

    private double length;

    private int size;

    private boolean isStart;

    public GameScene(double length, int size){
        this.length = length;
        this.size = size;
        this.start = new Button();
        this.score = new Text("得分：0");
        this.snakePane = new SnakePane(length, size);
        this.help = new Text("点击开始游戏，↑ ↓ ← →或W A S D\n 开始移动");

        BorderPane.setMargin(start, new Insets(10,10,10,10));
        this.start.setText("开始");
        this.help.setFont(Font.font(25));
        this.isStart = false;
        BorderPane.setAlignment(start, Pos.CENTER);
        BorderPane.setAlignment(help, Pos.CENTER);
        this.setTop(start);
        this.setCenter(help);
        start.setOnMouseClicked(event -> {
            if(!isStart)
                this.start();
        });
    }

    public void move(KeyCode e){
        if(isStart){
            this.snakePane.move(e);
            this.score.setText("得分：" + this.snakePane.getScore());
        }
    }

    public void move(){
        if(isStart) {
            this.snakePane.move();
            this.score.setText("得分：" + this.snakePane.getScore());
        }
    }

    private void start(){
        this.start.setText("正在游戏");
        this.getChildren().clear();
        this.setTop(start);
        this.setCenter(score);
        this.setBottom(snakePane);
        this.isStart = true;
    }

}
