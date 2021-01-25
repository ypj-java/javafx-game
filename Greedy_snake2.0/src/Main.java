import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.GameScene;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        GameScene gamePane = new GameScene(400, 30);
        Scene scene = new Scene(gamePane, 410, 480);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        EventHandler<ActionEvent> event = e -> {
            try {
                gamePane.move();
            } catch (NullPointerException ee){
                primaryStage.close();
            }
        };
        Timeline time = new Timeline(new KeyFrame(Duration.millis(500), event));
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();

        scene.setOnKeyPressed(e->{
            try {
                gamePane.move(e.getCode());
            } catch (NullPointerException ee){

                primaryStage.close();
            }
        });



    }


    public static void main(String[] args) {
        launch(args);
    }
}
