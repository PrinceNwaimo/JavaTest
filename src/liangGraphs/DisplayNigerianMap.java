package liangGraphs;
import javafx.application.Application;
import javafx.scene.Scene;
 import javafx.stage.Stage;

public class DisplayNigerianMap extends Application{
    @Override // Override the start method in the Application class
 public void start(Stage primaryStage) {
        City[] vertices = {new City("Lagos",75,50),
                new City("Port-harcourt", 50,210),
                new City("Kano",75,275),new City("Kaduna",275,175),
                new City("Aba",400,245),
                new City("Abuja",450,100), new City("Awka",700,80),
                new City("Onitsha",675,120),new City("Abakiliki",575,295),
                new City("Owerri",600,400), new City("Enugu", 408,325),
                new City("Umuahia",450, 360),
                new City("Uyo",320,85)};
         // Edge array for graph in Figure 28.1
         int[][] edges = {
                        {0, 1}, {0,3}, {0,5}, {1,0}, {1,2}, {1,3},
                        {2, 1}, {2,3}, {2,4}, {2,10},
                        {3, 0}, {3,1}, {3,2}, {3,4}, {3,5},
                        {4, 2}, {4,3}, {4,5}, {4,7}, {4,8}, {4,10},
                        {5, 0}, {5,3}, {5,4}, {5,6}, {5,7},
                        {6, 5}, {6,7}, {7,4}, {7,5}, {7,6}, {7,8},
                        {8, 4}, {8,7}, {8,9}, {8,10}, {8,11},
                        {9, 8}, {9,11}, {10,2}, {10,4}, {10,8}, {10,11},
                        {11, 8}, {11,9}, {11,10}
                      };
         Graph<City> graph = new UnweightedGraph<>(vertices, edges);
        // Create a scene and place it in the stage
              Scene scene = new Scene(new GraphView(graph), 750,450);
              primaryStage.setTitle("DisplayNigerianMap"); // Set the stage title
              primaryStage.setScene(scene); // Place the scene in the stage
              primaryStage.show(); // Display the stage
            }

 static class City implements Displayable {
 private int x, y;
private String name;
 City(String name, int x, int y) {
             this.name = name;
             this.x = x;
             this.y = y;
                  }
@Override
public int getX() {
             return x;
                  }

@Override
public int getY() {
             return y;
                  }
@Override
 public String getName() {
             return name;
                  }
     }
}
