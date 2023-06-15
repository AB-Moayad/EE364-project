import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//area's parts to creates the final shape of haram
public class MyApp extends Application {
    private ImageView area1View;
    private ImageView area2View;
    private ImageView area3View;
    private ImageView area4View;
    private ImageView area5View;
    private ImageView area6View;
    private ImageView area7View;
    private ImageView area8View;
    private ImageView area9View;
    private ImageView area10View;
    private ImageView pathway1View;
    private ImageView pathway2View;
    private ImageView pathway3View;
    private ImageView pathway4View;
    private ImageView pathway5View;
    private ImageView pathway6View;
    private ImageView pathway7View;
    private ImageView pathway8View;
    private ImageView pathway9View;
    private ImageView pathway10View;
    private ImageView pathway11View;
    private ImageView pathway12View;
    private ImageView pathway13View;
    private ImageView massa1View;
    private ImageView massa2View;
    private ImageView sahanView;
    private Label timeElapsedLabelValue;
    private Haram haram;

    public MyApp() {
        haram = new Haram();
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the SplitPane
        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.VERTICAL);
        splitPane.setDividerPositions(0); // Set the initial divider position

        // Create the first section with an AnchorPane and StackPane
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setMinHeight(540);
        anchorPane1.setMinWidth(720);

        StackPane stackPane = new StackPane();
        stackPane.minHeightProperty().bind(anchorPane1.heightProperty());
        stackPane.minWidthProperty().bind(anchorPane1.widthProperty());

        Image haramBody = new Image("images/haram.png");
        ImageView haramBodyView = new ImageView(haramBody);
        haramBodyView.setPreserveRatio(true);
        haramBodyView.fitHeightProperty().bind(stackPane.heightProperty());

        Image area1 = new Image("images/area1.png");
        this.area1View = new ImageView(area1);
        area1View.setPreserveRatio(true);
        area1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image area2 = new Image("images/area2.png");
        this.area2View = new ImageView(area2);
        area2View.setPreserveRatio(true);
        area2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image area3 = new Image("images/area3.png");
        this.area3View = new ImageView(area3);
        area3View.setPreserveRatio(true);
        area3View.fitHeightProperty().bind(stackPane.heightProperty());

        Image area4 = new Image("images/area4.png");
        this.area4View = new ImageView(area4);
        area4View.setPreserveRatio(true);
        area4View.fitHeightProperty().bind(stackPane.heightProperty());

        Image area5 = new Image("images/area5.png");
        this.area5View = new ImageView(area5);
        area5View.setPreserveRatio(true);
        area5View.fitHeightProperty().bind(stackPane.heightProperty());

        Image area6 = new Image("images/area6.png");
        this.area6View = new ImageView(area6);
        area6View.setPreserveRatio(true);
        area6View.fitHeightProperty().bind(stackPane.heightProperty());

        Image area7 = new Image("images/area7.png");
        this.area7View = new ImageView(area7);
        area7View.setPreserveRatio(true);
        area7View.fitHeightProperty().bind(stackPane.heightProperty());

        Image area8 = new Image("images/area8.png");
        this.area8View = new ImageView(area8);
        area8View.setPreserveRatio(true);
        area8View.fitHeightProperty().bind(stackPane.heightProperty());

        Image area9 = new Image("images/area9.png");
        this.area9View = new ImageView(area9);
        area9View.setPreserveRatio(true);
        area9View.fitHeightProperty().bind(stackPane.heightProperty());

        Image area10 = new Image("images/area10.png");
        this.area10View = new ImageView(area10);
        area10View.setPreserveRatio(true);
        area10View.fitHeightProperty().bind(stackPane.heightProperty());
        
        
        Image pathway1 = new Image("images/outerPathway1B.png");
        this.pathway1View = new ImageView(pathway1);
        pathway1View.setPreserveRatio(true);
        pathway1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway2 = new Image("images/outerPathway2B.png");
        this.pathway2View = new ImageView(pathway2);
        pathway2View.setPreserveRatio(true);
        pathway2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway3 = new Image("images/outerPathway3B.png");
        this.pathway3View = new ImageView(pathway3);
        pathway3View.setPreserveRatio(true);
        pathway3View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway4 = new Image("images/outerPathway4B.png");
        this.pathway4View = new ImageView(pathway4);
        pathway4View.setPreserveRatio(true);
        pathway4View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway5 = new Image("images/outerPathway5B.png");
        this.pathway5View = new ImageView(pathway5);
        pathway5View.setPreserveRatio(true);
        pathway5View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway6 = new Image("images/outerPathway6B.png");
        this.pathway6View = new ImageView(pathway6);
        pathway6View.setPreserveRatio(true);
        pathway6View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway7 = new Image("images/innerPathway7B.png");
        this.pathway7View = new ImageView(pathway7);
        pathway7View.setPreserveRatio(true);
        pathway7View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway8 = new Image("images/innerPathway8B.png");
        this.pathway8View = new ImageView(pathway8);
        pathway8View.setPreserveRatio(true);
        pathway8View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway9 = new Image("images/innerPathway9B.png");
        this.pathway9View = new ImageView(pathway9);
        pathway9View.setPreserveRatio(true);
        pathway9View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway10 = new Image("images/innerPathway10B.png");
        this.pathway10View = new ImageView(pathway10);
        pathway10View.setPreserveRatio(true);
        pathway10View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway11 = new Image("images/innerPathway11B.png");
        this.pathway11View = new ImageView(pathway11);
        pathway11View.setPreserveRatio(true);
        pathway11View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway12 = new Image("images/innerPathway12B.png");
        this.pathway12View = new ImageView(pathway12);
        pathway12View.setPreserveRatio(true);
        pathway12View.fitHeightProperty().bind(stackPane.heightProperty());

        Image pathway13 = new Image("images/innerPathway13B.png");
        this.pathway13View = new ImageView(pathway13);
        pathway13View.setPreserveRatio(true);
        pathway13View.fitHeightProperty().bind(stackPane.heightProperty());

        Image massa0 = new Image("images/massa0B.png");
        ImageView massa0View = new ImageView(massa0);
        massa0View.setPreserveRatio(true);
        massa0View.fitHeightProperty().bind(stackPane.heightProperty());

        Image massa1 = new Image("images/massa1B.png");
        this.massa1View = new ImageView(massa1);
        massa1View.setPreserveRatio(true);
        massa1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image massa2 = new Image("images/massa2B.png");
        this.massa2View = new ImageView(massa2);
        massa2View.setPreserveRatio(true);
        massa2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image sahan = new Image("images/wholeSahan.png");
        this.sahanView = new ImageView(sahan);
        sahanView.setPreserveRatio(true);
        sahanView.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer7_1 = new Image("images/organizer71.png");
        ImageView organizer7_1View = new ImageView(organizer7_1);
        organizer7_1View.setPreserveRatio(true);
        organizer7_1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer7_2 = new Image("images/organizer72.png");
        ImageView organizer7_2View = new ImageView(organizer7_2);
        organizer7_2View.setPreserveRatio(true);
        organizer7_2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer8_1 = new Image("images/organizer81.png");
        ImageView organizer8_1View = new ImageView(organizer8_1);
        organizer8_1View.setPreserveRatio(true);
        organizer8_1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer8_2 = new Image("images/organizer82.png");
        ImageView organizer8_2View = new ImageView(organizer8_2);
        organizer8_2View.setPreserveRatio(true);
        organizer8_2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer9_1 = new Image("images/organizer91.png");
        ImageView organizer9_1View = new ImageView(organizer9_1);
        organizer9_1View.setPreserveRatio(true);
        organizer9_1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer9_2 = new Image("images/organizer92.png");
        ImageView organizer9_2View = new ImageView(organizer9_2);
        organizer9_2View.setPreserveRatio(true);
        organizer9_2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer10_1 = new Image("images/organizer101.png");
        ImageView organizer10_1View = new ImageView(organizer10_1);
        organizer10_1View.setPreserveRatio(true);
        organizer10_1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer10_2 = new Image("images/organizer102.png");
        ImageView organizer10_2View = new ImageView(organizer10_2);
        organizer10_2View.setPreserveRatio(true);
        organizer10_2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer11_1 = new Image("images/organizer111.png");
        ImageView organizer11_1View = new ImageView(organizer11_1);
        organizer11_1View.setPreserveRatio(true);
        organizer11_1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer11_2 = new Image("images/organizer112.png");
        ImageView organizer11_2View = new ImageView(organizer11_2);
        organizer11_2View.setPreserveRatio(true);
        organizer11_2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer12_1 = new Image("images/organizer121.png");
        ImageView organizer12_1View = new ImageView(organizer12_1);
        organizer12_1View.setPreserveRatio(true);
        organizer12_1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer12_2 = new Image("images/organizer122.png");
        ImageView organizer12_2View = new ImageView(organizer12_2);
        organizer12_2View.setPreserveRatio(true);
        organizer12_2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer13_1 = new Image("images/organizer131.png");
        ImageView organizer13_1View = new ImageView(organizer13_1);
        organizer13_1View.setPreserveRatio(true);
        organizer13_1View.fitHeightProperty().bind(stackPane.heightProperty());

        Image organizer13_2 = new Image("images/organizer132.png");
        ImageView organizer13_2View = new ImageView(organizer13_2);
        organizer13_2View.setPreserveRatio(true);
        organizer13_2View.fitHeightProperty().bind(stackPane.heightProperty());

        Image colorLegend = new Image("images/legend.png");
        ImageView colorLegendView = new ImageView(colorLegend);
        colorLegendView.setPreserveRatio(true);
        colorLegendView.fitHeightProperty().bind(stackPane.heightProperty());

        stackPane.getChildren().addAll(area1View, area2View, area3View, area4View, area5View, area6View, area7View,
                area8View,
                area9View, area10View, pathway1View, pathway2View, pathway3View, pathway4View, pathway5View,
                pathway6View, pathway7View,
                pathway8View, pathway9View, pathway10View, pathway11View, pathway12View, pathway13View, massa0View,
                massa1View, massa2View, sahanView, haramBodyView,
                organizer7_1View, organizer7_2View, organizer8_1View, organizer8_2View, organizer9_1View,
                organizer9_2View, organizer10_1View, organizer10_2View,
                organizer11_1View, organizer11_2View, organizer12_1View, organizer12_2View, organizer13_1View,
                organizer13_2View, colorLegendView);

        

        // Add the StackPane to the AnchorPane
        AnchorPane.setTopAnchor(stackPane, 0.0);
        AnchorPane.setBottomAnchor(stackPane, 0.0);
        AnchorPane.setLeftAnchor(stackPane, 0.0);
        AnchorPane.setRightAnchor(stackPane, 0.0);
        anchorPane1.getChildren().add(stackPane);

        // Create the second section with an AnchorPane, labels, text field, slider, and
        // button
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setMaxHeight(180);
        anchorPane2.setMinHeight(180);
        Label numOfVisitorsLabel = new Label("Number of Visitors");
        numOfVisitorsLabel.setFont(new Font(16));
        TextField numOfVisitorsField = new TextField();
        numOfVisitorsField.setText("1");

        Label speedLabel = new Label("Speed");
        speedLabel.setFont(new Font(16));
        TextField speedField = new TextField();
        speedField.setText("0");

        Button runButton = new Button("Run Simulation");
        runButton.setStyle("-fx-font-size: " + 16 + ";");

        Button stopButton = new Button("Stop Simulation");
        stopButton.setStyle("-fx-font-size: " + 16 + ";");

        Line verticalLine = new Line(0, 0, 0, 150);
        verticalLine.setOpacity(0.4);

        Label timeElapsedLabel = new Label("Time Elapsed:");
        timeElapsedLabel.setFont(new Font(16));
        timeElapsedLabelValue = new Label("00:00");
        timeElapsedLabelValue.setFont(new Font(16));

        // Add the components to the AnchorPane
        anchorPane2.getChildren().addAll(numOfVisitorsLabel, numOfVisitorsField, speedLabel, speedField, runButton,
                stopButton,
                verticalLine, timeElapsedLabel, timeElapsedLabelValue);

        // Set the positions of the components within the AnchorPane
        AnchorPane.setTopAnchor(numOfVisitorsLabel, 10.0);
        AnchorPane.setLeftAnchor(numOfVisitorsLabel, 20.0);
        AnchorPane.setTopAnchor(numOfVisitorsField, 40.0);
        AnchorPane.setLeftAnchor(numOfVisitorsField, 20.0);
        AnchorPane.setTopAnchor(speedLabel, 80.0);
        AnchorPane.setLeftAnchor(speedLabel, 20.0);
        AnchorPane.setTopAnchor(speedField, 110.0);
        AnchorPane.setLeftAnchor(speedField, 20.0);
        AnchorPane.setTopAnchor(runButton, 50.0);
        AnchorPane.setLeftAnchor(runButton, 200.0);
        AnchorPane.setTopAnchor(stopButton, 100.0);
        AnchorPane.setLeftAnchor(stopButton, 200.0);

        AnchorPane.setTopAnchor(verticalLine, 10.0);
        AnchorPane.setLeftAnchor(verticalLine, 370.0);

        AnchorPane.setTopAnchor(timeElapsedLabel, 10.0);
        AnchorPane.setLeftAnchor(timeElapsedLabel, 400.0);

        AnchorPane.setTopAnchor(timeElapsedLabelValue, 10.0);
        AnchorPane.setLeftAnchor(timeElapsedLabelValue, 500.0);

        // Add the AnchorPanes to the SplitPane
        splitPane.getItems().addAll(anchorPane1, anchorPane2);

        // Control the UI
        runButton.setOnAction(event -> {
            String[] args = { numOfVisitorsField.getText(), speedField.getText() };
            haram.main(args, this);

            // consider making speed a slider with options (fastest, 2x, normal)
        });

        stopButton.setOnAction(event -> {
            haram.terminate();

            // // consider making speed a slider with options (fastest, 2x, normal)
        });

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(splitPane, 1080, 720);
        primaryStage.setMinHeight(720);
        primaryStage.setMinWidth(1080);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Haram Simulation");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public ImageView Area1() {
        return area1View;
    }

    public ImageView Area2() {
        return area2View;
    }

    public ImageView Area3() {
        return area3View;
    }

    public ImageView Area4() {
        return area4View;
    }

    public ImageView Area5() {
        return area5View;
    }

    public ImageView Area6() {
        return area6View;
    }

    public ImageView Area7() {
        return area7View;
    }

    public ImageView Area8() {
        return area8View;
    }

    public ImageView Area9() {
        return area9View;
    }

    public ImageView Area10() {
        return area10View;
    }

    public ImageView pathwayView1() {
        return pathway1View;
    }

    public ImageView pathwayView2() {
        return pathway2View;
    }

    public ImageView pathwayView3() {
        return pathway3View;
    }

    public ImageView pathwayView4() {
        return pathway4View;
    }

    public ImageView pathwayView5() {
        return pathway5View;
    }

    public ImageView pathwayView6() {
        return pathway6View;
    }

    public ImageView pathwayView7() {
        return pathway7View;
    }

    public ImageView pathwayView8() {
        return pathway8View;
    }

    public ImageView pathwayView9() {
        return pathway9View;
    }

    public ImageView pathwayView10() {
        return pathway10View;
    }

    public ImageView pathwayView11() {
        return pathway11View;
    }

    public ImageView pathwayView12() {
        return pathway12View;
    }

    public ImageView pathwayView13() {
        return pathway13View;
    }

    public void setTimeElapsedLabelValue(String time) {
        this.timeElapsedLabelValue.setText(time);
    }

    public ArrayList<ImageView> getPrayLocationsViews() {
        ArrayList<ImageView> prayLocationViews = new ArrayList<>();
        ImageView[] prayLocationViewsArray = { area1View, area2View, area3View, area4View, area5View, area6View,
                area7View, area8View, area9View, area10View };
        prayLocationViews.addAll(Arrays.asList(prayLocationViewsArray));
        return prayLocationViews;
    }

    public ArrayList<ImageView> getPathwaysViews() {
        ArrayList<ImageView> pathwayViews = new ArrayList<>();
        ImageView[] pathwayViewsArray = { pathway1View, pathway2View, pathway3View, pathway4View, pathway5View,
                pathway6View,
                pathway7View, pathway8View, pathway9View, pathway10View, pathway11View, pathway12View, pathway13View };
        pathwayViews.addAll(Arrays.asList(pathwayViewsArray));
        return pathwayViews;
    }

    public ArrayList<ImageView> getMasaaViews() {
        ArrayList<ImageView> masaaViews = new ArrayList<>();
        ImageView[] masaaViewsArray = { massa1View, massa2View };
        masaaViews.addAll(Arrays.asList(masaaViewsArray));
        return masaaViews;
    }

    public ImageView getSahanView() {
        return sahanView;
    }

}