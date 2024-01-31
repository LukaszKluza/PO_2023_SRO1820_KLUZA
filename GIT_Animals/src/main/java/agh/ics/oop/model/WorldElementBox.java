package agh.ics.oop.model;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class WorldElementBox extends VBox {
    private final VBox VBox;

    public WorldElementBox(WorldElement worldElement) {
        Image image = worldElement.toImage();
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(34);
        imageView.setFitHeight(34);

        Label positionLabel = new Label(worldElement.title());
        positionLabel.setStyle("-fx-font-size: 8px;");
        positionLabel.setStyle("-fx-padding: 0px;");



        this.VBox = new VBox();
        VBox.getChildren().addAll(imageView, positionLabel);
        VBox.setAlignment(Pos.CENTER);
    }

    public void addVBox(GridPane gridPane, int i, int j){
        GridPane.setHalignment(VBox, HPos.CENTER);
        gridPane.add(VBox,i,j);
    }
}
