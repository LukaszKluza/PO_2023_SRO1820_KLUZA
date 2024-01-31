package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class SimulationPresenter implements MapChangeListener {
    private static final int CELL_SIZE = 50;

    @FXML
    private Label moveLabel;
    @FXML
    private TextField textField;
    @FXML
    private GridPane mapGrid;

    public void setWorldMap(WorldMap worldMap) {
        worldMap.registerObserver(this);
    }
    private void drawMap(WorldMap worldMap){
        clearGrid();
        mapGrid.setGridLinesVisible(true);
        Boundary currentBounds = worldMap.getCurrentBounds();
        int cols = Math.abs(currentBounds.upperRight().getX()-currentBounds.lowerLeft().getX())+2;
        int rows = Math.abs(currentBounds.upperRight().getY()-currentBounds.lowerLeft().getY())+2;
        Vector2d currentPosition = new Vector2d(currentBounds.lowerLeft().getX(),currentBounds.upperRight().getY());
        addCells(cols, rows);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                Vector2d addVector = new Vector2d(i-1,-j+1);
                Optional<WorldElement> optionalElement = worldMap.objectAt(currentPosition.add(addVector));
                Label label = new Label();
                if (i == 0 || j == 0) {
                    setAxis(i, j, label, currentPosition.add(addVector));
                }
                else if(optionalElement.isPresent()){
                    try{
                        WorldElement element = optionalElement.get();
                        WorldElementBox elementBox = new WorldElementBox(element);

                        elementBox.addVBox(mapGrid,i,j);
                    }
                    catch (IllegalArgumentException e){
                        label.setText(worldMap.objectAt(currentPosition.add(addVector)).toString());
                        addLabel(label, i, j);
                    }
                }
                if(optionalElement.isEmpty()){
                    addLabel(label, i, j);
                }
            }
        }
    }

    private void addLabel(Label label, int i, int j) {
        GridPane.setHalignment(label, HPos.CENTER);
        mapGrid.add(label, i, j);
    }

    private static void setAxis(int i, int j, Label label, Vector2d currentPosition) {
        if(i == j){
            label.setText("y/x");
        } else if (i == 0) {
            label.setText(currentPosition.yToString());
        }else {
            label.setText(currentPosition.xToString());
        }
    }

    private void addCells(int cols, int rows) {
        for (int i = 0; i < cols; i++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_SIZE));
        }
        for (int i = 0; i < rows; i++) {
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_SIZE));
        }
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0));
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    private List<MoveDirection> getOptions(){
        //f b r l f f r r f f f f f f f f
        return OptionsParser.convertOptions(textField.getText().split("\\s+"));
    }

    private static int simulationID = 0;
    @FXML
    public void onSimulationStartClicked() {
        increaseID();
        System.out.println(simulationID);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/simulation.fxml"));
            BorderPane simulationWindow = loader.load();

            SimulationPresenter simulationPresenter = loader.getController();

            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
            WorldMap map = new GrassField(10, simulationID);
            simulationPresenter.setWorldMap(map);
//            map.registerObserver(simulationPresenter);
            Simulation simulation = new Simulation(positions, getOptions(), map);
            List<Simulation> simulations = List.of(simulation);

            SimulationEngine simulationEngine = new SimulationEngine(simulations);
            simulationEngine.runAsync();

            Stage stage = new Stage();
            stage.setTitle("Simulation " + map.getId());

            Scene scene = new Scene(simulationWindow);
            stage.setScene(scene);

            stage.show();
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private void increaseID() {
        synchronized (this){
            simulationID += 1;
        }
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            drawMap(worldMap);
            moveLabel.setText(message);
        });
    }
}
