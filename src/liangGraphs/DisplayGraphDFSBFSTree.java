package liangGraphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DisplayGraphDFSBFSTree extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create graph (e.g., Figure 28.1 cities)
        String[] cities = {"Seattle", "San Francisco", "Los Angeles", "Denver",
                "Kansas City", "Chicago", "Boston", "New York", "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges = {
                {0, 1}, {0, 3}, {0, 5},
                {1, 0}, {1, 2}, {1, 3},
                {2, 1}, {2, 3}, {2, 4}, {2, 10},
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
                {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
                {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
                {6, 5}, {6, 7},
                {7, 4}, {7, 5}, {7, 6}, {7, 8},
                {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
                {9, 8}, {9, 11},
                {10, 2}, {10, 4}, {10, 8}, {10, 11},
                {11, 8}, {11, 9}, {11, 10}
        };

        // Coordinates (approximate positions for drawing)
        double[][] positions = {
                {75, 50}, {50, 210}, {75, 275}, {275, 175}, {400, 245}, {450, 100},
                {700, 80}, {675, 120}, {575, 295}, {600, 400}, {408, 325}, {450, 360}
        };

        // Build Displayable vertices
        java.util.List<Displayable2> vertices = new java.util.ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            vertices.add((Displayable2) new City2(cities[i], positions[i][0], positions[i][1]));
        }

        UnweightedGraph3<Displayable2> graph = new UnweightedGraph3<>(vertices, edges);
        GraphView2 view = new GraphView2((Graph<? extends Displayable2>) graph);

        TextField tfCity = new TextField();
        tfCity.setPromptText("Enter city name");
        Label lblMessage = new Label();

        Button btDFS = new Button("Show DFS Tree");
        Button btBFS = new Button("Show BFS Tree");

        HBox controls = new HBox(10, tfCity, btDFS, btBFS);
        controls.setStyle("-fx-padding: 10; -fx-alignment: center;");

        BorderPane pane = new BorderPane();
        pane.setCenter(view);
        pane.setBottom(new VBox(5, controls, lblMessage));

        btDFS.setOnAction(e -> {
            String city = tfCity.getText().trim();
            int index = getCityIndex(cities, city);
            if (index == -1) {
                lblMessage.setText("City not found!");
                view.setTree(null);
            } else {
                lblMessage.setText("DFS tree starting from " + city);
                view.setTree(graph.dfs(index));
            }
        });

        btBFS.setOnAction(e -> {
            String city = tfCity.getText().trim();
            int index = getCityIndex(cities, city);
            if (index == -1) {
                lblMessage.setText("City not found!");
                view.setTree(null);
            } else {
                lblMessage.setText("BFS tree starting from " + city);
                view.setTree(graph.bfs(index));
            }
        });

        Scene scene = new Scene(pane, 800, 500);
        primaryStage.setTitle("Display DFS/BFS Tree in Graph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int getCityIndex(String[] cities, String city) {
        for (int i = 0; i < cities.length; i++)
            if (cities[i].equalsIgnoreCase(city))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

