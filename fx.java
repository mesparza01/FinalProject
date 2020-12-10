import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
 
public class fx extends Application {
 
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Fibonacci Function, recursive and iterative");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("iteration 10", 2709900),
                new PieChart.Data("recursion 10", 180800),
                new PieChart.Data("iteration 20", 2136400),
                new PieChart.Data("recursion 20", 1293500),
                new PieChart.Data("iteration 30", 2557800),
                new PieChart.Data("recursion 30", 6043200));
 
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Fibonacci Function, recursive and iterative");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}