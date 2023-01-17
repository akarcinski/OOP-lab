package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    private Image image;
    private ImageView imageView;
    private Label label;
    private final int SIZE = 40;
    private VBox verticalBox;

    public GuiElementBox(AbstractWorldMapElement abstractWorldMapElement) throws FileNotFoundException {
        try {
            image = new Image(new FileInputStream(abstractWorldMapElement.getImagePath()));
            imageView = new ImageView(image);
            imageView.setFitWidth(SIZE + 10);
            imageView.setFitHeight(SIZE);

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        if (abstractWorldMapElement instanceof Grass) {
            label = new Label("Grass");
        }
        else {
            label = new Label(abstractWorldMapElement.getPosition().toString());
        }

        verticalBox = new VBox();
        verticalBox.getChildren().addAll(imageView, label);
        verticalBox.setAlignment(Pos.CENTER);
    }
    public VBox getVBox(){
        return verticalBox;
    }
}
