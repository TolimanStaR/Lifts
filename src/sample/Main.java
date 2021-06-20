package sample;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        int width = 1000, height = 525;
        Group root = new Group();
        Scene scene1 = new Scene(root, width, height, Color.LIGHTBLUE);
        Stage stage = new Stage();
        int[][] state = new int[100][100];
        Handler handler = new Handler(state);
        handler.start();
        stage.setTitle("Minecraft v0.0.1");
//        scene1.setFill(Color.CORAL);

        Text title = new Text("MINECRAFT");
        title.setX(325);
        title.setY(50);
        title.setFont(Font.font("Verdana", 50));
        title.setFill(Color.DARKGRAY);

        Text matrix = new Text();
        matrix.setFont(Font.font("Verdana", 15));
        matrix.setX(200);
        matrix.setY(200);

        Rectangle grass = new Rectangle();
        grass.setFill(Color.GREEN);
        grass.setX(0);
        grass.setY(450);
        grass.setWidth(1000);
        grass.setHeight(75);

        Rectangle sun = new Rectangle();
        sun.setFill(Color.YELLOW);
        sun.setX(650);
        sun.setY(30);
        sun.setWidth(60);
        sun.setHeight(60);

        Rectangle cloud = new Rectangle();
        cloud.setFill(Color.WHITE);
        cloud.setX(350);
        cloud.setY(20);
        cloud.setWidth(120);
        cloud.setHeight(30);

        Rectangle cloud1 = new Rectangle();
        cloud1.setFill(Color.WHITE);
        cloud1.setX(850);
        cloud1.setY(50);
        cloud1.setWidth(140);
        cloud1.setHeight(27);

        Rectangle cloud2 = new Rectangle();
        cloud2.setFill(Color.WHITE);
        cloud2.setX(520);
        cloud2.setY(80);
        cloud2.setWidth(100);
        cloud2.setHeight(30);

        Rectangle house = new Rectangle();
        house.setFill(Color.LIGHTGREY);
        house.setX(200);
        house.setY(100);
        house.setWidth(200);
        house.setHeight(350);

        root.getChildren().add(house);
        root.getChildren().add(cloud);
        root.getChildren().add(cloud1);
        root.getChildren().add(cloud2);
        root.getChildren().add(sun);
//        root.getChildren().add(matrix);
//        root.getChildren().add(title);
        root.getChildren().add(grass);

        AtomicInteger frame_counter = new AtomicInteger();

        Rectangle[][] lifts = new Rectangle[5][5];
        int[] x = {220, 240, 260, 280, 300};

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                lifts[i][j] = new Rectangle();
                lifts[i][j].setX(220 + i * 20);
                lifts[i][j].setY(240 + j * 40);
                lifts[i][j].setFill(Color.LIGHTGREY);
                lifts[i][j].setHeight(30);
                lifts[i][j].setWidth(10);
                root.getChildren().add(lifts[i][j]);
            }
//            lifts[i] = new Rectangle();
//            lifts[i].setX(x[i]);
//            lifts[i].setY(400);
//            lifts[i].setFill(Color.CYAN);
//            lifts[i].setHeight(30);
//            lifts[i].setWidth(10);
//            root.getChildren().add(lifts[i]);
        }
        int[][] prev = new int[100][100];
        int[] floor = {1, 1, 1, 1, 1};
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            frame_counter.incrementAndGet();
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < 5; ++i) {

                for (int f = 0; f < 4; ++f) {
                    if (state[i][f] == 1) {
                        lifts[4 - f][4 - i].setFill(Color.BLACK);
                    } else {
                        lifts[4 - f][4 - i].setFill(Color.LIGHTGREY);
                    }
                }

//                    lifts[i].setY(lifts[i].getY() + 40);

            }
            for (int i = 0; i < 5; ++i) {
                System.arraycopy(state[i], 0, prev[i], 0, 5);
            }
            matrix.setText(s.toString());

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


        stage.setScene(scene1);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
