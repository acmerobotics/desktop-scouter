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

import static java.io.File.separator;


public class Main extends Application {

    private ListView<Team> listView;
    private Scene scene1, scene2;
    private TextField teamNameField;
    private TextField teamNumberField;
    private TextArea textAreaMatch1One;
    private TextArea textAreaMatch1Two;
    private TextArea textAreaMatch1Three;
    private CheckBox rankMatch1One;
    private CheckBox rankMatch1Two;
    private CheckBox rankMatch1Three;
    private CheckBox rankMatch1Four;
    private CheckBox rankMatch1Five;
    private TextArea textAreaMatch2One;
    private TextArea textAreaMatch2Two;
    private TextArea textAreaMatch2Three;
    private CheckBox rankMatch2One;
    private CheckBox rankMatch2Two;
    private CheckBox rankMatch2Three;
    private CheckBox rankMatch2Four;
    private CheckBox rankMatch2Five;
    private TextArea textAreaMatch3One;
    private TextArea textAreaMatch3Two;
    private TextArea textAreaMatch3Three;
    private CheckBox rankMatch3One;
    private CheckBox rankMatch3Two;
    private CheckBox rankMatch3Three;
    private CheckBox rankMatch3Four;
    private CheckBox rankMatch3Five;
    private TextArea textAreaMatch4One;
    private TextArea textAreaMatch4Two;
    private TextArea textAreaMatch4Three;
    private CheckBox rankMatch4One;
    private CheckBox rankMatch4Two;
    private CheckBox rankMatch4Three;
    private CheckBox rankMatch4Four;
    private CheckBox rankMatch4Five;
    private TextArea textAreaMatch5One;
    private TextArea textAreaMatch5Two;
    private TextArea textAreaMatch5Three;
    private CheckBox rankMatch5One;
    private CheckBox rankMatch5Two;
    private CheckBox rankMatch5Three;
    private CheckBox rankMatch5Four;
    private CheckBox rankMatch5Five;





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

        // ListView that shows all of the team names and numbers that are attending the competition

        listView = new ListView<>();
        listView.setMaxWidth(500);
        listView.setPrefHeight(650);


        Team techSupport = new Team("Tech Support", 5214);
        listView.getItems().add(techSupport);
        Team topDogs = new Team("Top Dogs", 6357);
        listView.getItems().add(topDogs);
        Team einstienEagles = new Team("Einstien Eagles", 6949);
        listView.getItems().add(einstienEagles);
        Team acme = new Team("ACME Robotics", 8367);
        listView.getItems().add(acme);
        Team faze = new Team("FaZe Robotics", 10320);
        listView.getItems().add(faze);
        Team wolverines = new Team("Wolverines", 11182);
        listView.getItems().add(wolverines);
        Team teravoltz = new Team("Teravoltz", 11475);
        listView.getItems().add(teravoltz);
        Team mad = new Team("MaD Robotics", 11548);
        listView.getItems().add(mad);
        Team quarry = new Team("Quarry Lane Cougars", 11920);
        listView.getItems().add(quarry);
        Team bracket = new Team("Bracket Sources", 13215);
        listView.getItems().add(bracket);
        Team deja = new Team("Deja Vu", 13216);
        listView.getItems().add(deja);
        Team orca = new Team("Orca Ninjas", 13218);
        listView.getItems().add(orca);
        Team architechs = new Team("The Architechs", 13220);
        listView.getItems().add(architechs);
        Team gophor = new Team("Gophor Robotics", 13221);
        listView.getItems().add(gophor);
        Team cyberscots = new Team("Cyberscots", 13228);
        listView.getItems().add(cyberscots);
        Team beta = new Team("Beta Wolves", 14053);
        listView.getItems().add(beta);


        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Team>() {
            @Override
            public void changed(ObservableValue<? extends Team> observable, Team oldValue, Team newValue) {
                if (listView.isPressed()){
                    button1.setDisable(false);
                }
            }
        });

        listView.setCellFactory(new Callback<ListView<Team>, ListCell<Team>>() {
            @Override
            public ListCell<Team> call(ListView<Team> param) {
                return new TeamCell();
            }
        });

        //Scene builder for scene1
        VBox root1 = new VBox();
        root1.getChildren().addAll(listView, button1);
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
            Team selectedTeam = listView.getSelectionModel().getSelectedItem();
            if (selectedTeam != null) {
                selectedTeam.setName(teamNameField.getText());
                selectedTeam.setNumber(Integer.parseInt(teamNumberField.getText()));
                selectedTeam.setMatch1one(textAreaMatch1One.getText());
                selectedTeam.setMatch1two(textAreaMatch1Two.getText());
                selectedTeam.setMatch1three(textAreaMatch1Three.getText());
                selectedTeam.setMatch2one(textAreaMatch2One.getText());
                selectedTeam.setMatch2two(textAreaMatch2Two.getText());
                selectedTeam.setMatch2three(textAreaMatch2Three.getText());
                selectedTeam.setMatch3one(textAreaMatch3One.getText());
                selectedTeam.setMatch3two(textAreaMatch3Two.getText());
                selectedTeam.setMatch3three(textAreaMatch3Three.getText());
                selectedTeam.setMatch4one(textAreaMatch4One.getText());
                selectedTeam.setMatch4two(textAreaMatch4Two.getText());
                selectedTeam.setMatch4three(textAreaMatch4Three.getText());
                selectedTeam.setMatch5one(textAreaMatch5One.getText());
                selectedTeam.setMatch5two(textAreaMatch5Two.getText());
                selectedTeam.setMatch5three(textAreaMatch5Three.getText());
                selectedTeam.setRank1One(rankMatch1One.isSelected());
                selectedTeam.setRank1Two(rankMatch1Two.isSelected());
                selectedTeam.setRank1Three(rankMatch1Three.isSelected());
                selectedTeam.setRank1Four(rankMatch1Four.isSelected());
                selectedTeam.setRank1Five(rankMatch1Five.isSelected());
                selectedTeam.setRank2One(rankMatch2One.isSelected());
                selectedTeam.setRank2Two(rankMatch2Two.isSelected());
                selectedTeam.setRank2Three(rankMatch2Three.isSelected());
                selectedTeam.setRank2Four(rankMatch2Four.isSelected());
                selectedTeam.setRank2Five(rankMatch2Five.isSelected());
                selectedTeam.setRank3One(rankMatch3One.isSelected());
                selectedTeam.setRank3Two(rankMatch3Two.isSelected());
                selectedTeam.setRank3Three(rankMatch3Three.isSelected());
                selectedTeam.setRank3Four(rankMatch3Four.isSelected());
                selectedTeam.setRank3Five(rankMatch3Five.isSelected());
                selectedTeam.setRank4One(rankMatch4One.isSelected());
                selectedTeam.setRank4Two(rankMatch4Two.isSelected());
                selectedTeam.setRank4Three(rankMatch4Three.isSelected());
                selectedTeam.setRank4Four(rankMatch4Four.isSelected());
                selectedTeam.setRank4Five(rankMatch4Five.isSelected());
                selectedTeam.setRank5One(rankMatch5One.isSelected());
                selectedTeam.setRank5Two(rankMatch5Two.isSelected());
                selectedTeam.setRank5Three(rankMatch5Three.isSelected());
                selectedTeam.setRank5Four(rankMatch5Four.isSelected());
                selectedTeam.setRank5Five(rankMatch5Five.isSelected());

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

        // CheckBoxes for Rankings

        rankMatch1One = new CheckBox("1");
        GridPane.setRowIndex(rankMatch1One, 4);
        GridPane.setColumnIndex(rankMatch1One,3);

        rankMatch1Two = new CheckBox("2");
        GridPane.setRowIndex(rankMatch1Two, 4);
        GridPane.setColumnIndex(rankMatch1Two, 4);

        rankMatch1Three = new CheckBox("3");
        GridPane.setRowIndex(rankMatch1Three, 4);
        GridPane.setColumnIndex(rankMatch1Three, 5);

        rankMatch1Four = new CheckBox("4");
        GridPane.setRowIndex(rankMatch1Four, 4);
        GridPane.setColumnIndex(rankMatch1Four, 6);

        rankMatch1Five = new CheckBox("5");
        GridPane.setRowIndex(rankMatch1Five, 4);
        GridPane.setColumnIndex(rankMatch1Five, 7);

        rankMatch2One = new CheckBox("1");
        GridPane.setRowIndex(rankMatch2One, 7);
        GridPane.setColumnIndex(rankMatch2One, 3);

        rankMatch2Two = new CheckBox("2");
        GridPane.setRowIndex(rankMatch2Two, 7);
        GridPane.setColumnIndex(rankMatch2Two, 4);

        rankMatch2Three = new CheckBox("3");
        GridPane.setRowIndex(rankMatch2Three, 7);
        GridPane.setColumnIndex(rankMatch2Three, 5);

        rankMatch2Four = new CheckBox("4");
        GridPane.setRowIndex(rankMatch2Four, 7);
        GridPane.setColumnIndex(rankMatch2Four, 6);

        rankMatch2Five = new CheckBox("5");
        GridPane.setRowIndex(rankMatch2Five, 7);
        GridPane.setColumnIndex(rankMatch2Five, 7);

        rankMatch3One = new CheckBox("1");
        GridPane.setRowIndex(rankMatch3One, 10);
        GridPane.setColumnIndex(rankMatch3One, 3);

        rankMatch3Two = new CheckBox("2");
        GridPane.setRowIndex(rankMatch3Two, 10);
        GridPane.setColumnIndex(rankMatch3Two, 4);

        rankMatch3Three = new CheckBox("3");
        GridPane.setRowIndex(rankMatch3Three, 10);
        GridPane.setColumnIndex(rankMatch3Three, 5);

        rankMatch3Four = new CheckBox("4");
        GridPane.setRowIndex(rankMatch3Four, 10);
        GridPane.setColumnIndex(rankMatch3Four, 6);

        rankMatch3Five = new CheckBox("5");
        GridPane.setRowIndex(rankMatch3Five, 10);
        GridPane.setColumnIndex(rankMatch3Five, 7);

        rankMatch4One = new CheckBox("1");
        GridPane.setRowIndex(rankMatch4One, 13);
        GridPane.setColumnIndex(rankMatch4One, 3);

        rankMatch4Two = new CheckBox("2");
        GridPane.setRowIndex(rankMatch4Two, 13);
        GridPane.setColumnIndex(rankMatch4Two, 4);

        rankMatch4Three = new CheckBox("3");
        GridPane.setRowIndex(rankMatch4Three,13);
        GridPane.setColumnIndex(rankMatch4Three, 5);

        rankMatch4Four = new CheckBox("4");
        GridPane.setRowIndex(rankMatch4Four, 13);
        GridPane.setColumnIndex(rankMatch4Four, 6);

        rankMatch4Five = new CheckBox("5");
        GridPane.setRowIndex(rankMatch4Five, 13);
        GridPane.setColumnIndex(rankMatch4Five, 7);

        rankMatch5One = new CheckBox("1");
        GridPane.setRowIndex(rankMatch5One, 16);
        GridPane.setColumnIndex(rankMatch5One, 3);

        rankMatch5Two = new CheckBox("2");
        GridPane.setRowIndex(rankMatch5Two, 16);
        GridPane.setColumnIndex(rankMatch5Two, 4);

        rankMatch5Three = new CheckBox("3");
        GridPane.setRowIndex(rankMatch5Three, 16);
        GridPane.setColumnIndex(rankMatch5Three, 5);

        rankMatch5Four = new CheckBox("4");
        GridPane.setRowIndex(rankMatch5Four, 16);
        GridPane.setColumnIndex(rankMatch5Four, 6);

        rankMatch5Five = new CheckBox("5");
        GridPane.setRowIndex(rankMatch5Five, 16);
        GridPane.setColumnIndex(rankMatch5Five, 7);

        grid.getChildren().addAll(rankMatch1One, rankMatch1Two, rankMatch1Three, rankMatch1Four, rankMatch1Five, rankMatch2One,rankMatch2Two, rankMatch2Three, rankMatch2Four, rankMatch2Five, rankMatch3One, rankMatch3Two, rankMatch3Three, rankMatch3Four, rankMatch3Five, rankMatch4One, rankMatch4Two, rankMatch4Three, rankMatch4Four, rankMatch4Five, rankMatch5One, rankMatch5Two, rankMatch5Three, rankMatch5Four, rankMatch5Five, autoLabel1, teleLabel1, endLabel1, autoLabel2, teleLabel2, endLabel2, autoLabel3, teleLabel3, endLabel3, autoLabel4, teleLabel4, endLabel4, autoLabel5, teleLabel5, endLabel5, textAreaMatch1One, textAreaMatch1Two, textAreaMatch1Three, textAreaMatch2One, textAreaMatch2Two, textAreaMatch2Three, textAreaMatch3One, textAreaMatch3Two, textAreaMatch3Three, textAreaMatch4One,textAreaMatch4Two, textAreaMatch4Three, textAreaMatch5One, textAreaMatch5Two, textAreaMatch5Three, ml1, ml2, ml3, ml4, ml5);


        //Scene Builder for scene2
        VBox root2 = new VBox();
        root2.getChildren().addAll(grid);
        scene2 = new Scene(root2, 1500, 700);

        //button that takes us to scene2
        button1.setOnAction(e -> {
            Team selectedTeam = listView.getSelectionModel().getSelectedItem();
            if( selectedTeam != null) {
                teamNameField.setText(selectedTeam.getName());
                teamNumberField.setText(String.valueOf(selectedTeam.getNumber()));
                textAreaMatch1One.setText(selectedTeam.getMatch1one());
                textAreaMatch1Two.setText(selectedTeam.getMatch1two());
                textAreaMatch1Three.setText(selectedTeam.getMatch1three());
                textAreaMatch2One.setText(selectedTeam.getMatch2one());
                textAreaMatch2Two.setText(selectedTeam.getMatch2two());
                textAreaMatch2Three.setText(selectedTeam.getMatch2three());
                textAreaMatch3One.setText(selectedTeam.getMatch3one());
                textAreaMatch3Two.setText(selectedTeam.getMatch3two());
                textAreaMatch3Three.setText(selectedTeam.getMatch3three());
                textAreaMatch4One.setText(selectedTeam.getMatch4one());
                textAreaMatch4Two.setText(selectedTeam.getMatch4two());
                textAreaMatch4Three.setText(selectedTeam.getMatch4three());
                textAreaMatch5One.setText(selectedTeam.getMatch5one());
                textAreaMatch5Two.setText(selectedTeam.getMatch5two());
                textAreaMatch5Three.setText(selectedTeam.getMatch5three());
                rankMatch1One.setSelected(selectedTeam.getRank1One());
                rankMatch1Two.setSelected(selectedTeam.getRank1Two());
                rankMatch1Three.setSelected(selectedTeam.getRank1Three());
                rankMatch1Four.setSelected(selectedTeam.getRank1Four());
                rankMatch1Five.setSelected(selectedTeam.getRank1Five());
                rankMatch2One.setSelected(selectedTeam.getRank2One());
                rankMatch2Two.setSelected(selectedTeam.getRank2Two());
                rankMatch2Three.setSelected(selectedTeam.getRank2Three());
                rankMatch2Four.setSelected(selectedTeam.getRank2Four());
                rankMatch2Five.setSelected(selectedTeam.getRank2Five());
                rankMatch3One.setSelected(selectedTeam.getRank3One());
                rankMatch3Two.setSelected(selectedTeam.getRank3Two());
                rankMatch3Three.setSelected(selectedTeam.getRank3Three());
                rankMatch3Four.setSelected(selectedTeam.getRank3Four());
                rankMatch3Five.setSelected(selectedTeam.getRank3Five());
                rankMatch4One.setSelected(selectedTeam.getRank4One());
                rankMatch4Two.setSelected(selectedTeam.getRank4Two());
                rankMatch4Three.setSelected(selectedTeam.getRank4Three());
                rankMatch4Four.setSelected(selectedTeam.getRank4Four());
                rankMatch4Five.setSelected(selectedTeam.getRank4Five());
                rankMatch5One.setSelected(selectedTeam.getRank5One());
                rankMatch5Two.setSelected(selectedTeam.getRank5Two());
                rankMatch5Three.setSelected(selectedTeam.getRank5Three());
                rankMatch5Four.setSelected(selectedTeam.getRank5Four());
                rankMatch5Five.setSelected(selectedTeam.getRank5Five());
            }
            primaryStage.setScene(scene2);
        });





    }
}

