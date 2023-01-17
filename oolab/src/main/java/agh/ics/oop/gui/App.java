package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import javafx.stage.Stage;



import java.io.FileNotFoundException;
import java.io.File;

public class App extends Application {
    private GridPane gridPane;
    private AbstractWorldMap map;
    private int width;
    private int height;
    private SimulationEngine engine;
    @Override
    public void init() throws Exception {
        this.width = 60;
        this.height = 60;
        this.gridPane = new GridPane();
        String[] args = getParameters().getRaw().toArray(new String[0]);
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(3, 2), new Vector2d(3, 4)};
            this.engine = new SimulationEngine(directions, map, positions, this);
            //engine.run();

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button startButton = new Button("play");
        TextField textField = new TextField();
        HBox hBox = new HBox(textField, startButton);

        startButton.setOnAction(event ->{
            String[] arg = textField.getText().split(" ");
            MoveDirection[] directions = OptionsParser.parse(arg);
            if (directions.length != 0) {
                engine.setMoves(directions);

            }
            Thread thread = new Thread(this.engine);
            thread.start();
        });
        prepareGrid();
        VBox window = new VBox(gridPane, hBox);
        Scene scene = new Scene(window, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Kermit");
        primaryStage.show();
    }

    public void refresh() {
        Platform.runLater(() ->{
            gridPane.getChildren().clear();
            gridPane.setGridLinesVisible(false);
            gridPane.getColumnConstraints().clear();
            gridPane.getRowConstraints().clear();

            try {
                prepareGrid();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        });
    }

    public void prepareGrid() throws FileNotFoundException {
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getChildren().clear();

        Vector2d lowerLeft = map.mapBoundary.getLowerLeft();
        Vector2d upperRight = map.mapBoundary.getUpperRight();
        gridPane.setGridLinesVisible(true);
        //System.out.println(lowerLeft);
        //System.out.println(upperRight);
        Label label = new Label("y/x");
        GridPane.setHalignment(label, HPos.CENTER);
        gridPane.add(label, 0, 0);
        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));

        //Image image = new ImageIcon(Objects.requireNonNull(getClass().getResource("agh/ics/oop/gui/grass.png"))).getImage();
        //gridPane.add(new ImageView(String.valueOf(image)), 1,0);
        for (int i = 1, j = lowerLeft.getX(); i <= upperRight.getX() - lowerLeft.getX() + 1; i++, j++) {
            label = new Label(Integer.toString(j));
            gridPane.add(label, i, 0);
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = 1, j = upperRight.getY(); i <= upperRight.getY() - lowerLeft.getY() + 1; i++, j--) {
            label = new Label(Integer.toString(j));
            gridPane.add(label, 0, i);
            gridPane.getRowConstraints().add(new RowConstraints(height));
            GridPane.setHalignment(label, HPos.CENTER);
        }


        for (int i = lowerLeft.getX(), x = 1; i <= upperRight.getX(); i++, x++) {
            for (int j = upperRight.getY(), y = 1; j >= lowerLeft.getY(); j--, y++) {
                Vector2d position = new Vector2d(i, j);
                if (map.isOccupied(position)) {
                    AbstractWorldMapElement element = (AbstractWorldMapElement) map.objectAt(position);

                    GuiElementBox guiElementBox = new GuiElementBox(element);
                    VBox vBox = guiElementBox.getVBox();

//                    if (element instanceof Animal) {
//                        label = new Label(element.toString());
//                    } else if (element instanceof Grass) {
//                        label = new Label(element.toString());
//                    } else {
//                        label = new Label("?");
//                    }
                    gridPane.add(vBox, x, y);
                    //gridPane.getColumnConstraints().add(new ColumnConstraints(width));
                    //gridPane.getRowConstraints().add(new RowConstraints(height));
                    GridPane.setHalignment(vBox, HPos.CENTER);
                }
            }
        }
    }
}

