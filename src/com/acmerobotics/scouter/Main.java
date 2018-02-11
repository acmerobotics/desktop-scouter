package com.acmerobotics.scouter;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.io.File.separator;


public class Main extends Application {

    private TableView<Team> table = new TableView<>();
    private Scene scene1, scene2;
    private TextField teamNameField;
    private TextField teamNumberField;
    private TextArea textAreaMatch1One;
    private TextArea textAreaMatch1Two;
    private TextArea textAreaMatch1Three;
    private ToggleGroup rankingMatch1;
    private List<RadioButton> rankMatch1 = new ArrayList<>();
    private TextArea textAreaMatch2One;
    private TextArea textAreaMatch2Two;
    private TextArea textAreaMatch2Three;
    private ToggleGroup rankingMatch2;
    private List<RadioButton> rankMatch2 = new ArrayList<>();
    private TextArea textAreaMatch3One;
    private TextArea textAreaMatch3Two;
    private TextArea textAreaMatch3Three;
    private ToggleGroup rankingMatch3;
    private List<RadioButton> rankMatch3 = new ArrayList<>();
    private TextArea textAreaMatch4One;
    private TextArea textAreaMatch4Two;
    private TextArea textAreaMatch4Three;
    private ToggleGroup rankingMatch4;
    private List<RadioButton> rankMatch4 = new ArrayList<>();
    private TextArea textAreaMatch5One;
    private TextArea textAreaMatch5Two;
    private TextArea textAreaMatch5Three;
    private ToggleGroup rankingMatch5;
    private List<RadioButton> rankMatch5 = new ArrayList<>();





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Scouting App");

        //First Scene

        //Submit button(takes us to scene2)
        Button button1 = new Button("Submit");
        button1.setDisable(true);

        // TableView that shows all of the team names and numbers that are attending the competition
        TableColumn nameColumn = new TableColumn("Name");
        TableColumn numberColumn = new TableColumn("Number");
        TableColumn<Team, Double> averageRankColunm = new TableColumn<>("Average Rank");
        table.getColumns().addAll(nameColumn, numberColumn, averageRankColunm);

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Team,String>("name")
        );

        numberColumn.setCellValueFactory(
                new PropertyValueFactory<Team,String>("number")
        );

        averageRankColunm.setCellValueFactory(
                new PropertyValueFactory<>("averageRank")
        );

        table.setMaxWidth(500);
        table.setPrefHeight(650);


        final ObservableList<Team> teamList = FXCollections.observableArrayList();
        Team techSupport = new Team("Tech Support", 5214);
        teamList.add(techSupport);
        Team topDogs = new Team("Top Dogs", 6357);
        teamList.add(topDogs);
        Team einstienEagles = new Team("Einstien Eagles", 6949);
        teamList.add(einstienEagles);
        Team acme = new Team("ACME Robotics", 8367);
        teamList.add(acme);
        Team faze = new Team("FaZe Robotics", 10320);
        teamList.add(faze);
        Team wolverines = new Team("Wolverines", 11182);
        teamList.add(wolverines);
        Team teravoltz = new Team("Teravoltz", 11475);
        teamList.add(teravoltz);
        Team mad = new Team("MaD Robotics", 11548);
        teamList.add(mad);
        Team quarry = new Team("Quarry Lane Cougars", 11920);
        teamList.add(quarry);
        Team bracket = new Team("Bracket Sources", 13215);
        teamList.add(bracket);
        Team deja = new Team("Deja Vu", 13216);
        teamList.add(deja);
        Team orca = new Team("Orca Ninjas", 13218);
        teamList.add(orca);
        Team architechs = new Team("The Architechs", 13220);
        teamList.add(architechs);
        Team gophor = new Team("Gophor Robotics", 13221);
        teamList.add(gophor);
        Team cyberscots = new Team("Cyberscots", 13228);
        teamList.add(cyberscots);
        Team beta = new Team("Beta Wolves", 14053);
        teamList.add(beta);

        table.setItems(teamList);


        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Team>() {
            @Override
            public void changed(ObservableValue<? extends Team> observable, Team oldValue, Team newValue) {
                if (table.isPressed()){
                    button1.setDisable(false);
                }
            }
        });


        //Scene builder for scene1
        VBox root1 = new VBox();
        root1.getChildren().addAll(table, button1);
        scene1 = new Scene(root1, 1500, 700);
        primaryStage.setScene(scene1);
        primaryStage.show();

        // Second Scene

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        //Back Button
        Button button2 = new Button("Back");
        button2.setOnAction(e -> {
            Team selectedTeam = table.getSelectionModel().getSelectedItem();
            if (selectedTeam != null) {
                selectedTeam.setName(teamNameField.getText());
                selectedTeam.setNumber(Integer.parseInt(teamNumberField.getText()));
                selectedTeam.setMatch1Auto(textAreaMatch1One.getText());
                selectedTeam.setMatch1Tele(textAreaMatch1Two.getText());
                selectedTeam.setMatch1End(textAreaMatch1Three.getText());
                selectedTeam.setMatch2Auto(textAreaMatch2One.getText());
                selectedTeam.setMatch2Tele(textAreaMatch2Two.getText());
                selectedTeam.setMatch2End(textAreaMatch2Three.getText());
                selectedTeam.setMatch3Auto(textAreaMatch3One.getText());
                selectedTeam.setMatch3Tele(textAreaMatch3Two.getText());
                selectedTeam.setMatch3End(textAreaMatch3Three.getText());
                selectedTeam.setMatch4Auto(textAreaMatch4One.getText());
                selectedTeam.setMatch4Tele(textAreaMatch4Two.getText());
                selectedTeam.setMatch4End(textAreaMatch4Three.getText());
                selectedTeam.setMatch5Auto(textAreaMatch5One.getText());
                selectedTeam.setMatch5Tele(textAreaMatch5Two.getText());
                selectedTeam.setMatch5End(textAreaMatch5Three.getText());
                int index1 = rankMatch1.indexOf(rankingMatch1.getSelectedToggle());
                selectedTeam.setMatch1Rank(index1+1);
                int index2 = rankMatch2.indexOf(rankingMatch2.getSelectedToggle());
                selectedTeam.setMatch2Rank(index2+1);
                int index3 = rankMatch3.indexOf(rankingMatch3.getSelectedToggle());
                selectedTeam.setMatch3Rank(index3+1);
                int index4 = rankMatch4.indexOf(rankingMatch4.getSelectedToggle());
                selectedTeam.setMatch4Rank(index4+1);
                int index5 = rankMatch5.indexOf(rankingMatch5.getSelectedToggle());
                selectedTeam.setMatch5Rank(index5+1);
                selectedTeam.recalculateAverageRank();
                table.refresh();
            }

            primaryStage.setScene(scene1);

        }

        );
        GridPane.setRowIndex(button2, 0);
        GridPane.setColumnIndex(button2, 0);
        grid.getChildren().add(button2);


        //TextFields and Labels for team names and numbers
        teamNameField = new TextField();
        teamNameField.setPrefHeight(10);
        teamNameField.setMaxWidth(200);
        GridPane.setRowIndex(teamNameField, 0);
        GridPane.setColumnIndex(teamNameField, 11);

        Label teamName = new Label("Team Name:");
        GridPane.setRowIndex(teamName, 0);
        GridPane.setColumnIndex(teamName, 10);


        teamNumberField = new TextField();
        teamNumberField.setPrefHeight(10);
        teamNumberField.setMaxWidth(200);
        GridPane.setRowIndex(teamNumberField, 0);
        GridPane.setColumnIndex(teamNumberField, 13);


        Label teamNumber = new Label("Team Number:");
        GridPane.setRowIndex(teamNumber, 0);
        GridPane.setColumnIndex(teamNumber, 12);

        grid.getChildren().addAll(teamNameField, teamNumberField,teamName, teamNumber);

        //TextAreas and Labels for matches
        textAreaMatch1One = new TextArea();
        textAreaMatch1One.setMaxWidth(200);
        textAreaMatch1One.setPrefHeight(80);
        textAreaMatch1Two = new TextArea();
        textAreaMatch1Two.setMaxWidth(200);
        textAreaMatch1Two.setPrefHeight(80);
        textAreaMatch1Three = new TextArea();
        textAreaMatch1Three.setMaxWidth(200);
        textAreaMatch1Three.setPrefHeight(80);

        GridPane.setRowIndex(textAreaMatch1One, 4);
        GridPane.setColumnIndex(textAreaMatch1One, 0);
        GridPane.setRowIndex(textAreaMatch1Two,4);
        GridPane.setColumnIndex(textAreaMatch1Two, 1);
        GridPane.setRowIndex(textAreaMatch1Three, 4);
        GridPane.setColumnIndex(textAreaMatch1Three, 2);

        Label autoLabel1= new Label("Autonomous:");
        autoLabel1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(autoLabel1, 3);
        GridPane.setColumnIndex(autoLabel1, 0);
        Label teleLabel1 = new Label("TeleOp:");
        teleLabel1.setFont(Font.font("Tahoma", FontWeight.NORMAL,15));
        GridPane.setRowIndex(teleLabel1,3);
        GridPane.setColumnIndex(teleLabel1,1);
        Label endLabel1 = new Label("End Game:");
        endLabel1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(endLabel1,3);
        GridPane.setColumnIndex(endLabel1, 2);


        Label ml1 = new Label("Match 1");
        GridPane.setRowIndex(ml1, 2);
        GridPane.setColumnIndex(ml1, 0);

        Label autoLabel2= new Label("Autonomous:");
        autoLabel2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(autoLabel2, 6);
        GridPane.setColumnIndex(autoLabel2, 0);
        Label teleLabel2 = new Label("TeleOp:");
        teleLabel2.setFont(Font.font("Tahoma", FontWeight.NORMAL,15));
        GridPane.setRowIndex(teleLabel2,6);
        GridPane.setColumnIndex(teleLabel2,1);
        Label endLabel2 = new Label("End Game:");
        endLabel2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(endLabel2,6);
        GridPane.setColumnIndex(endLabel2, 2);

        textAreaMatch2One = new TextArea();
        textAreaMatch2One.setPrefHeight(80);
        textAreaMatch2One.setMaxWidth(200);
        GridPane.setRowIndex(textAreaMatch2One, 7);
        GridPane.setColumnIndex(textAreaMatch2One, 0);
        textAreaMatch2Two = new TextArea();
        textAreaMatch2Two.setPrefHeight(80);
        textAreaMatch2Two.setMaxWidth(200);
        GridPane.setRowIndex(textAreaMatch2Two, 7);
        GridPane.setColumnIndex(textAreaMatch2Two, 1);
        textAreaMatch2Three = new TextArea();
        textAreaMatch2Three.setPrefHeight(80);
        textAreaMatch2Three.setMaxWidth(200);
        GridPane.setRowIndex(textAreaMatch2Three, 7);
        GridPane.setColumnIndex(textAreaMatch2Three, 2);

        Label ml2 = new Label("Match 2");
        GridPane.setRowIndex(ml2, 5);
        GridPane.setColumnIndex(ml2, 0);


       Label autoLabel3= new Label("Autonomous:");
        autoLabel3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(autoLabel3, 9);
        GridPane.setColumnIndex(autoLabel3, 0);
        Label teleLabel3 = new Label("TeleOp:");
        teleLabel3.setFont(Font.font("Tahoma", FontWeight.NORMAL,15));
        GridPane.setRowIndex(teleLabel3,9);
        GridPane.setColumnIndex(teleLabel3,1);
        Label endLabel3 = new Label("End Game:");
        endLabel3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(endLabel3,9);
        GridPane.setColumnIndex(endLabel3, 2);


        textAreaMatch3One = new TextArea();
        textAreaMatch3One.setPrefHeight(80);
        textAreaMatch3One.setMaxWidth(200);
        textAreaMatch3Two = new TextArea();
        textAreaMatch3Two.setPrefHeight(80);
        textAreaMatch3Two.setMaxWidth(200);
        textAreaMatch3Three = new TextArea();
        textAreaMatch3Three.setPrefHeight(80);
        textAreaMatch3Three.setMaxWidth(200);

        GridPane.setRowIndex(textAreaMatch3One,10);
        GridPane.setColumnIndex(textAreaMatch3One, 0);
        GridPane.setRowIndex(textAreaMatch3Two, 10);
        GridPane.setColumnIndex(textAreaMatch3Two,1);
        GridPane.setRowIndex(textAreaMatch3Three, 10);
        GridPane.setColumnIndex(textAreaMatch3Three, 2);

        Label ml3 = new Label("Match 3");
        GridPane.setRowIndex(ml3, 8);
        GridPane.setColumnIndex(ml3, 0);

        textAreaMatch4One = new TextArea();
        textAreaMatch4One.setPrefHeight(80);
        textAreaMatch4One.setMaxWidth(200);
        textAreaMatch4Two = new TextArea();
        textAreaMatch4Two.setPrefHeight(80);
        textAreaMatch4Two.setMaxWidth(200);
        textAreaMatch4Three = new TextArea();
        textAreaMatch4Three.setPrefHeight(80);
        textAreaMatch4Three.setMaxWidth(200);

        GridPane.setRowIndex(textAreaMatch4One, 13);
        GridPane.setColumnIndex(textAreaMatch4One, 0);
        GridPane.setRowIndex(textAreaMatch4Two,13);
        GridPane.setColumnIndex(textAreaMatch4Two,1);
        GridPane.setRowIndex(textAreaMatch4Three,13);
        GridPane.setColumnIndex(textAreaMatch4Three, 2);

        Label autoLabel4 = new Label("Autonomous:");
        autoLabel4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(autoLabel4, 12);
        GridPane.setColumnIndex(autoLabel4, 0);
        Label teleLabel4 = new Label("TeleOp:");
        teleLabel4.setFont(Font.font("Tahoma", FontWeight.NORMAL,15));
        GridPane.setRowIndex(teleLabel4,12);
        GridPane.setColumnIndex(teleLabel4,1);
        Label endLabel4 = new Label("End Game:");
        endLabel4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(endLabel4,12);
        GridPane.setColumnIndex(endLabel4, 2);

        Label ml4 = new Label("Match 4");
        GridPane.setRowIndex(ml4, 11);
        GridPane.setColumnIndex(ml4, 0);


        textAreaMatch5One = new TextArea();
        textAreaMatch5One.setPrefHeight(80);
        textAreaMatch5One.setMaxWidth(200);
        textAreaMatch5Two = new TextArea();
        textAreaMatch5Two.setPrefHeight(80);
        textAreaMatch5Two.setMaxWidth(200);
        textAreaMatch5Three = new TextArea();
        textAreaMatch5Three.setPrefHeight(80);
        textAreaMatch5Three.setMaxWidth(200);

        GridPane.setRowIndex(textAreaMatch5One, 16);
        GridPane.setColumnIndex(textAreaMatch5One, 0);
        GridPane.setRowIndex(textAreaMatch5Two,16);
        GridPane.setColumnIndex(textAreaMatch5Two, 1);
        GridPane.setRowIndex(textAreaMatch5Three, 16);
        GridPane.setColumnIndex(textAreaMatch5Three, 2);

        Label autoLabel5 = new Label("Autonomous:");
        autoLabel5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(autoLabel5, 15);
        GridPane.setColumnIndex(autoLabel5, 0);
        Label teleLabel5 = new Label("TeleOp:");
        teleLabel5.setFont(Font.font("Tahoma", FontWeight.NORMAL,15));
        GridPane.setRowIndex(teleLabel5,15);
        GridPane.setColumnIndex(teleLabel5,1);
        Label endLabel5 = new Label("End Game:");
        endLabel5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(endLabel5,15);
        GridPane.setColumnIndex(endLabel5, 2);


        Label ml5 = new Label("Match 5");
        GridPane.setRowIndex(ml5, 14);
        GridPane.setColumnIndex(ml5, 0);

        // RadioButtons for Rankings

        rankingMatch1 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch1 = new RadioButton(Integer.toString(i + 1));
            buttonMatch1.setToggleGroup(rankingMatch1);
            GridPane.setRowIndex(buttonMatch1, 4);
            GridPane.setColumnIndex(buttonMatch1, i + 3);
            grid.getChildren().add(buttonMatch1);
            rankMatch1.add(buttonMatch1);
        }

        rankingMatch2 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch2 = new RadioButton(Integer.toString(i + 1));
            buttonMatch2.setToggleGroup(rankingMatch2);
            GridPane.setRowIndex(buttonMatch2, 7);
            GridPane.setColumnIndex(buttonMatch2, i + 3);
            grid.getChildren().add(buttonMatch2);
            rankMatch2.add(buttonMatch2);
        }

        rankingMatch3 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch3 = new RadioButton(Integer.toString(i + 1));
            buttonMatch3.setToggleGroup(rankingMatch3);
            GridPane.setRowIndex(buttonMatch3, 10);
            GridPane.setColumnIndex(buttonMatch3, i + 3);
            grid.getChildren().add(buttonMatch3);
            rankMatch3.add(buttonMatch3);
        }

        rankingMatch4 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch4 = new RadioButton(Integer.toString(i + 1));
            buttonMatch4.setToggleGroup(rankingMatch4);
            GridPane.setRowIndex(buttonMatch4, 13);
            GridPane.setColumnIndex(buttonMatch4, i + 3);
            grid.getChildren().add(buttonMatch4);
            rankMatch4.add(buttonMatch4);
        }

        rankingMatch5 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch5 = new RadioButton(Integer.toString(i + 1));
            buttonMatch5.setToggleGroup(rankingMatch5);
            GridPane.setRowIndex(buttonMatch5, 16);
            GridPane.setColumnIndex(buttonMatch5, i + 3);
            grid.getChildren().add(buttonMatch5);
            rankMatch5.add(buttonMatch5);
        }

        grid.getChildren().addAll(autoLabel1, teleLabel1, endLabel1, autoLabel2, teleLabel2, endLabel2, autoLabel3, teleLabel3, endLabel3, autoLabel4, teleLabel4, endLabel4, autoLabel5, teleLabel5, endLabel5, textAreaMatch1One, textAreaMatch1Two, textAreaMatch1Three, textAreaMatch2One, textAreaMatch2Two, textAreaMatch2Three, textAreaMatch3One, textAreaMatch3Two, textAreaMatch3Three, textAreaMatch4One,textAreaMatch4Two, textAreaMatch4Three, textAreaMatch5One, textAreaMatch5Two, textAreaMatch5Three, ml1, ml2, ml3, ml4, ml5);


        //Scene Builder for scene2
        VBox root2 = new VBox();
        root2.getChildren().addAll(grid);
        scene2 = new Scene(root2, 1500, 700);

        //button that takes us to scene2
        button1.setOnAction(e -> {
            Team selectedTeam = table.getSelectionModel().getSelectedItem();
            if( selectedTeam != null) {
                teamNameField.setText(selectedTeam.getName());
                teamNumberField.setText(String.valueOf(selectedTeam.getNumber()));
                textAreaMatch1One.setText(selectedTeam.getMatch1Auto());
                textAreaMatch1Two.setText(selectedTeam.getMatch1Tele());
                textAreaMatch1Three.setText(selectedTeam.getMatch1End());
                textAreaMatch2One.setText(selectedTeam.getMatch2Auto());
                textAreaMatch2Two.setText(selectedTeam.getMatch2Tele());
                textAreaMatch2Three.setText(selectedTeam.getMatch2End());
                textAreaMatch3One.setText(selectedTeam.getMatch3Auto());
                textAreaMatch3Two.setText(selectedTeam.getMatch3Tele());
                textAreaMatch3Three.setText(selectedTeam.getMatch3End());
                textAreaMatch4One.setText(selectedTeam.getMatch4Auto());
                textAreaMatch4Two.setText(selectedTeam.getMatch4Tele());
                textAreaMatch4Three.setText(selectedTeam.getMatch4End());
                textAreaMatch5One.setText(selectedTeam.getMatch5Auto());
                textAreaMatch5Two.setText(selectedTeam.getMatch5Tele());
                textAreaMatch5Three.setText(selectedTeam.getMatch5End());
                RadioButton match1Button = rankMatch1.get(selectedTeam.getMatch1Rank()-1);
                match1Button.setSelected(true);
                RadioButton match2Button = rankMatch2.get(selectedTeam.getMatch2Rank()-1);
                match2Button.setSelected(true);
                RadioButton match3Button = rankMatch3.get(selectedTeam.getMatch3Rank()-1);
                match3Button.setSelected(true);
                RadioButton match4Button = rankMatch4.get(selectedTeam.getMatch4Rank()-1);
                match4Button.setSelected(true);
                RadioButton match5Button = rankMatch5.get(selectedTeam.getMatch5Rank()-1);
                match5Button.setSelected(true);
            }
            primaryStage.setScene(scene2);
        });





    }
}

