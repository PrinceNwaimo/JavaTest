package liangCollections;

import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class BouncingBall extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_RADIUS = 10;
    private static final int DELAY = 10;

    private List<Ball> balls = new ArrayList<>();
    private Pane pane;
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        pane = new Pane();
        pane.setOnMousePressed(e -> {
            for (Ball ball : balls) {
                if (ball.contains(e.getX(), e.getY())) {
                    balls.remove(ball);
                    pane.getChildren().remove(ball.getCircle());
                    break;
                }
            }
        });

        timeline = new Timeline(new KeyFrame(Duration.millis(DELAY), e -> moveBalls()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bouncing Balls");
        primaryStage.show();
    }

    private void moveBalls() {
        for (Ball ball : balls) {
            ball.move();
        }
        checkCollisions();
    }

    private void checkCollisions() {
        for (int i = balls.size() - 1; i >= 0; i--) {
            Ball ball1 = balls.get(i);
            for (int j = i - 1; j >= 0; j--) {
                Ball ball2 = balls.get(j);
                if (ball1.collidesWith(ball2)) {
                    ball2.setRadius(ball1.getRadius() + ball2.getRadius());
                    balls.remove(ball1);
                    pane.getChildren().remove(ball1.getCircle());
                    return;
                }
            }
        }
    }

    public void addBall() {
        Ball ball = new Ball();
        balls.add(ball);
        pane.getChildren().add(ball.getCircle());
    }

    public void suspendAnimation() {
        timeline.pause();
    }

    public void resumeAnimation() {
        timeline.play();
    }

    private class Ball {
        private Circle circle;
        private double x;
        private double y;
        private double dx;
        private double dy;
        private double radius;

        public Ball() {
            x = Math.random() * (WIDTH - 2 * BALL_RADIUS) + BALL_RADIUS;
            y = Math.random() * (HEIGHT - 2 * BALL_RADIUS) + BALL_RADIUS;
            dx = Math.random() * 5 - 2.5;
            dy = Math.random() * 5 - 2.5;
            radius = BALL_RADIUS;
            circle = new Circle(x, y, radius);
            circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        }

        public Circle getCircle() {
            return circle;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
            circle.setRadius(radius);
        }

        public boolean contains(double x, double y) {
            return Math.hypot(this.x - x, this.y - y) <= radius;
        }

        public boolean collidesWith(Ball other) {
            return Math.hypot(x - other.x, y - other.y) <= radius + other.radius;
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
