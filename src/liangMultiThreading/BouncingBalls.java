package liangMultiThreading;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBalls extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int BALL_SIZE = 20;
    private static final int NUM_BALLS = 10;

    private Circle[] balls = new Circle[NUM_BALLS];
    private double[] dx = new double[NUM_BALLS];
    private double[] dy = new double[NUM_BALLS];

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        for (int i = 0; i < NUM_BALLS; i++) {
            balls[i] = new Circle(Math.random() * (WIDTH - BALL_SIZE), Math.random() * (HEIGHT - BALL_SIZE), BALL_SIZE / 2);
            balls[i].setFill(Color.color(Math.random(), Math.random(), Math.random()));
            pane.getChildren().add(balls[i]);
            dx[i] = Math.random() * 2 - 1;
            dy[i] = Math.random() * 2 - 1;
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), e -> {
            for (int i = 0; i < NUM_BALLS; i++) {
                balls[i].setCenterX(balls[i].getCenterX() + dx[i]);
                balls[i].setCenterY(balls[i].getCenterY() + dy[i]);

                if (balls[i].getCenterX() < BALL_SIZE / 2 || balls[i].getCenterX() > WIDTH - BALL_SIZE / 2) {
                    dx[i] *= -1;
                }
                if (balls[i].getCenterY() < BALL_SIZE / 2 || balls[i].getCenterY() > HEIGHT - BALL_SIZE / 2) {
                    dy[i] *= -1;
                }

                for (int j = i + 1; j < NUM_BALLS; j++) {
                    double distance = Math.sqrt(Math.pow(balls[i].getCenterX() - balls[j].getCenterX(), 2) + Math.pow(balls[i].getCenterY() - balls[j].getCenterY(), 2));
                    if (distance < BALL_SIZE) {
                        double tempDx = dx[i];
                        double tempDy = dy[i];
                        dx[i] = dx[j];
                        dy[i] = dy[j];
                        dx[j] = tempDx;
                        dy[j] = tempDy;
                    }
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
