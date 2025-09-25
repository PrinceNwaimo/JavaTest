package liangCollections;

import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleBall extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int DELAY = 10;

    private List<Ball> balls = new ArrayList<>();
    private Pane pane;
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        pane = new Pane();
        pane.setOnMouseClicked(e -> removeLargestBall());

        timeline = new Timeline(new KeyFrame(Duration.millis(DELAY), e -> moveBalls()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Multiple Balls");
        primaryStage.show();

        addBall();
    }

    private void addBall() {
        Ball ball = new Ball();
        balls.add(ball);
        pane.getChildren().add(ball.getCircle());
    }

    private void removeLargestBall() {
        if (balls.isEmpty()) {
            return;
        }

        Ball largestBall = balls.stream()
                .max((b1, b2) -> Double.compare(b1.getRadius(), b2.getRadius()))
                .orElse(null);

        balls.remove(largestBall);
        pane.getChildren().remove(largestBall.getCircle());
    }

    private void moveBalls() {
        for (Ball ball : balls) {
            ball.move();
        }
    }

    private class Ball {
        private Circle circle;
        private double x;
        private double y;
        private double dx;
        private double dy;
        private double radius;

        public Ball() {
            Random random = new Random();
            x = random.nextDouble() * (WIDTH - 40) + 20;
            y = random.nextDouble() * (HEIGHT - 40) + 20;
            dx = random.nextDouble() * 5 - 2.5;
            dy = random.nextDouble() * 5 - 2.5;
            radius = random.nextDouble() * 18 + 2;
            circle = new Circle(x, y, radius);
            circle.setFill(Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble()));
        }

        public Circle getCircle() {
            return circle;
        }

        public double getRadius() {
            return radius;
        }

        public void move() {
            x += dx;
            y += dy;
            if (x - radius < 0 || x + radius > WIDTH) {
                dx *= -1;
            }
            if (y - radius < 0 || y + radius > HEIGHT) {
                dy *= -1;
            }
            circle.setCenterX(x);
            circle.setCenterY(y);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
