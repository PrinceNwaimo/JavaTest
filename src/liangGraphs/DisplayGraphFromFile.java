package liangGraphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class DisplayGraphFromFile extends Application {

    @Override
    public void start(Stage stage) {
        try {
            TextInputDialog dialog = new TextInputDialog("graph.txt");
            dialog.setHeaderText("Enter the graph filename:");
            String filename = dialog.showAndWait().orElse("graph.txt");

            File file = new File(filename);
            if (!file.exists()) {
                showError("File not found: " + filename);
                return;
            }

            Graph3 graph = readGraph(file);

            GraphView3 view = new GraphView3(graph);
            Scene scene = new Scene(view, 400, 300);
            stage.setScene(scene);
            stage.setTitle("Graph Display from File");
            stage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
            showError("Error reading file: " + ex.getMessage());
        }
    }

    private Graph3 readGraph(File file) throws Exception {
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();

        Graph3 graph = new Graph3();

        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            Graph3.Vertex vertex = new Graph3.Vertex(id, x, y);
            graph.addVertex(vertex);

            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] edges = line.split(" ");
                for (String e : edges) {
                    int v = Integer.parseInt(e);
                    graph.addEdge(id, v);
                }
            }
        }

        scanner.close();
        return graph;
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
