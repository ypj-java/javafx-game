package view;

import controller.SnakePane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        SnakePane snakePane = new SnakePane(400, 30);
        Scene scene = new Scene(snakePane, 410, 410);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        EventHandler<ActionEvent> event = e -> {
            try {
                snakePane.move();
            } catch (NullPointerException ee){
                primaryStage.close();
            }
        };
        Timeline time = new Timeline(new KeyFrame(Duration.millis(1000), event));
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();

        scene.setOnKeyPressed(e->{
            try {
                snakePane.move(e.getCode());
            } catch (NullPointerException ee){
                primaryStage.close();
            }
        });



    }


    public static void main(String[] args) {
        launch(args);
    }
}
