package com.acmerobotics.scouter;

import javafx.application.Application;
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
import java.util.List;

import static java.io.File.separator;


public class Main extends Application {

    ListView<Team> listView;
    Scene scene1, scene2;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Scouting App");

        //First Scene

        //Submit button(takes us to scene2)
        Button button1 = new Button("Submit");

        // ListView that shows all of the team names and numbers that are attending the competition
        listView = new ListView<>();
        // listView.getItems().addAll("SpectreBots : 596", "ART : 4345", "Solista : 4432", "The Knights of Ni : 5206", "RoboKnights : 5220", "Walbots : 7175", "Error 7391 Not Found : 7391", "ACME Robotics : 8367", "M : 8381", "RHS Robotix : 8625", "The Intersect : 8865", "Fireworks : 9014", "Hyperion : 9614", "ART : 10148", "ART : 10150", "Spaceballs : 10794", "Innov8rz : 11039", "Paragon : 11311", "Robust Robots : 11575", "Technnovators : 12573", "Fremont Hawk : 12628", "Kuriosity Robotics : 12635", "The Awesome Lady Argobot : 13035", "Nueva Team : 13050", "Robo Sapiens : 13180", "Quantum Stinger : 13380", " Bionic Vikings : 13988" );
        listView.setMaxWidth(500);
        listView.setPrefHeight(650);

        Team spectreBots = new Team("SpectreBots", 596);
        listView.getItems().add(spectreBots);
        Team art = new Team("ART", 4345);
        listView.getItems().add(art);
        Team solista = new Team("Solista", 4432);
        listView.getItems().add(solista);
        Team knightsOfNi = new Team("The Knights of Ni", 5206);
        listView.getItems().add(knightsOfNi);
        Team roboKnights = new Team("RoboKnights", 5220);
        listView.getItems().add(roboKnights);
        Team walbots = new Team("Walbots", 7175);
        listView.getItems().add(walbots);
        Team error = new Team("Error: 7391 Not Found", 7391);
        listView.getItems().add(error);
        Team acme = new Team("ACME Robotics", 8367);
        listView.getItems().add(acme);
        Team m = new Team("M", 8381);
        listView.getItems().add(m);
        Team rhs = new Team("RHS Robotix", 8625);
        listView.getItems().add(rhs);
        Team intersect = new Team("The Intersect", 8865);
        listView.getItems().add(intersect);
        Team fireworks = new Team("Fireworkds", 9014);
        listView.getItems().add(fireworks);
        Team hyperion = new Team("Hyperion", 9614);
        listView.getItems().add(hyperion);
        Team whiteHat = new Team("The White Hat Hackers", 9924);
        listView.getItems().add(whiteHat);
        Team art2 = new Team("ART", 10148);
        listView.getItems().add(art2);
        Team art3 = new Team("ART", 10150);
        listView.getItems().add(art3);
        Team spaceballs = new Team("Spaceballs", 10794);
        listView.getItems().add(spaceballs);
        Team innov8rz = new Team("Innov8rz", 11039);
        listView.getItems().add(innov8rz);
        Team paragon = new Team("Paragon", 11311);
        listView.getItems().add(paragon);
        Team robust = new Team("Robust Robots", 11575);
        listView.getItems().add(robust);
        Team technnovators = new Team("Technnovators", 12573);
        listView.getItems().add(technnovators);
        Team hawk = new Team("Fremont Hawks", 12628);
        listView.getItems().add(hawk);
        Team kuriosity = new Team("Kuriosity Robotics", 12635);
        listView.getItems().add(kuriosity);
        Team ladyArgobot = new Team("The Awesome Lady Argobot", 13035);
        listView.getItems().add(ladyArgobot);
        Team nueva = new Team("Nueva Team",13050);
        listView.getItems().add(nueva);
        Team roboSapiens = new Team("RoboSapiens", 13180);
        listView.getItems().add(roboSapiens);
        Team quantum = new Team("Quantum Stingers", 13380);
        listView.getItems().add(quantum);
        Team vikings = new Team("Bionic Vikings", 13988);
        listView.getItems().add(vikings);


        listView.setCellFactory(new Callback<ListView<Team>, ListCell<Team>>() {
            @Override
            public ListCell<Team> call(ListView<Team> param) {
                return new TeamCell();
            }
        });

        System.out.println(spectreBots.getName());

        //Scene builder for scene1
        VBox root1 = new VBox();
        root1.getChildren().addAll(listView, button1);
        scene1 = new Scene(root1, 1500, 700);
        primaryStage.setScene(scene1);
        primaryStage.show();

        // Second Scene

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(2);
        grid.setHgap(5);

        //Back Button
        Button button2 = new Button("Back");
        button2.setOnAction(e -> primaryStage.setScene(scene1));
        GridPane.setRowIndex(button2, 0);
        GridPane.setColumnIndex(button2, 0);
        grid.getChildren().add(button2);

        //Checkboxes

        //auto
        CheckBox ch1 = new CheckBox("Jewel Removel");
        GridPane.setRowIndex(ch1, 2);
        GridPane.setColumnIndex(ch1, 0);

        CheckBox ch2 = new CheckBox("Glyph in Cryptobox");
        GridPane.setRowIndex(ch2, 3);
        GridPane.setColumnIndex(ch2, 0);

        CheckBox ch3 = new CheckBox("Cryptobox Key");
        GridPane.setRowIndex(ch3, 4);
        GridPane.setColumnIndex(ch3, 0);

        CheckBox ch4 = new CheckBox("Robot Parked in Safe Zone");
        GridPane.setRowIndex(ch4, 5);
        GridPane.setColumnIndex(ch4, 0);

        //tele
        CheckBox ch5 = new CheckBox("Glyphs:");
        GridPane.setRowIndex(ch5, 2);
        GridPane.setColumnIndex(ch5, 30);

        CheckBox ch6 = new CheckBox("Rows:");
        GridPane.setRowIndex(ch6, 3);
        GridPane.setColumnIndex(ch6,30);

        CheckBox ch7 = new CheckBox("Columns:");
        GridPane.setRowIndex(ch7, 4);
        GridPane.setColumnIndex(ch7, 30);

        CheckBox ch8 = new CheckBox("Cipher");
        GridPane.setRowIndex(ch8, 5);
        GridPane.setColumnIndex(ch8, 30);


        //end
        CheckBox ch9 = new CheckBox("Scoring in End Zone");
        GridPane.setRowIndex(ch9, 2);
        GridPane.setColumnIndex(ch9, 60);

        CheckBox ch10 = new CheckBox("Zone 1");
        GridPane.setRowIndex(ch10, 3);
        GridPane.setColumnIndex(ch10, 60);

        CheckBox ch11 = new CheckBox("Zone 2");
        GridPane.setRowIndex(ch11, 4);
        GridPane.setColumnIndex(ch11,60);

        CheckBox ch12 = new CheckBox("Zone 3");
        GridPane.setRowIndex(ch12, 5);
        GridPane.setColumnIndex(ch12, 60);

        CheckBox ch13 = new CheckBox("Steve Upright");
        GridPane.setRowIndex(ch13, 6);
        GridPane.setColumnIndex(ch13, 60);

        CheckBox ch14 = new CheckBox("Finishing on Balancing Stone");
        GridPane.setRowIndex(ch14, 7);
        GridPane.setColumnIndex(ch14,60);


        grid.getChildren().addAll(ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8 , ch9, ch10, ch11, ch12, ch13, ch14);

        //Text for the checkboxes
        Text autonomous = new Text("Autonomous");
        autonomous.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(autonomous, 1);
        GridPane.setColumnIndex(autonomous, 0);

        Text teleop = new Text("TeleOp");
        teleop.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(teleop, 1);
        GridPane.setColumnIndex(teleop, 30);

        Text endgame = new Text("End Game");
        endgame.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(endgame, 1);
        GridPane.setColumnIndex(endgame, 60);

        grid.getChildren().addAll(autonomous, teleop, endgame);

        // TextFields to write in reliability
        TextField reliabilityTextField = new TextField();
        reliabilityTextField.setPrefHeight(10);
        reliabilityTextField.setMaxWidth(80);
        GridPane.setRowIndex(reliabilityTextField, 7);
        GridPane.setColumnIndex(reliabilityTextField, 0);

        Label reliability = new Label("Reliability of All:");
        GridPane.setRowIndex(reliability, 6);
        GridPane.setColumnIndex(reliability, 0);

        TextField reliabilityTextField2 = new TextField();
        reliabilityTextField2.setPrefHeight(10);
        reliabilityTextField2.setMaxWidth(80);
        GridPane.setRowIndex(reliabilityTextField2, 7);
        GridPane.setColumnIndex(reliabilityTextField2, 30);

        Label reliability2 = new Label(" Scoring Reliability:");
        GridPane.setRowIndex(reliability2, 6);
        GridPane.setColumnIndex(reliability2, 30);

        TextField reliabilityTextField3 = new TextField();
        reliabilityTextField3.setPrefHeight(10);
        reliabilityTextField3.setMaxWidth(80);
        GridPane.setRowIndex(reliabilityTextField3, 9);
        GridPane.setColumnIndex(reliabilityTextField3,60);

        Label reliability3 = new Label("Reliability of All:");
        GridPane.setRowIndex(reliability3, 8);
        GridPane.setColumnIndex(reliability3, 60);

        grid.getChildren().addAll(reliabilityTextField, reliabilityTextField2, reliabilityTextField3, reliability, reliability2, reliability3);

        //TextFields and Labels for team names and numbers
        TextField teamNameField = new TextField();
        teamNameField.setPrefHeight(10);
        teamNameField.setMaxWidth(100);
        GridPane.setRowIndex(teamNameField, 0);
        GridPane.setColumnIndex(teamNameField, 20);

        Label teamName = new Label("Team Name:");
        GridPane.setRowIndex(teamName, 0);
        GridPane.setColumnIndex(teamName, 5);


        TextField teamNumberField = new TextField();
        teamNumberField.setPrefHeight(10);
        teamNumberField.setMaxWidth(100);
        GridPane.setRowIndex(teamNumberField, 0);
        GridPane.setColumnIndex(teamNumberField, 35);


        Label teamNumber = new Label("Team Number:");
        GridPane.setRowIndex(teamNumber, 0);
        GridPane.setColumnIndex(teamNumber, 30);

        grid.getChildren().addAll(teamNameField, teamNumberField,teamName, teamNumber);

        //TextAreas and Label for matches
        Label matches = new Label("Matches:");
        GridPane.setRowIndex(matches, 10);
        GridPane.setColumnIndex(matches, 0);

        TextArea match1 = new TextArea();
        match1.setText("Autonomous:\nTeleOP:\nEnd Game:\n");
        match1.setMaxWidth(200);
        match1.setPrefHeight(300);
        GridPane.setRowIndex(match1, 13);
        GridPane.setColumnIndex(match1, 0);

        Label ml1 = new Label("Match 1");
        GridPane.setRowIndex(ml1, 12);
        GridPane.setColumnIndex(ml1, 0);


        TextArea match2 = new TextArea();
        match2.setText("Autonomous:\nTeleOP:\nEnd Game:\n");
        match2.setPrefHeight(300);
        match2.setMaxWidth(200);
        GridPane.setRowIndex(match2, 13);
        GridPane.setColumnIndex(match2, 30);

        Label ml2 = new Label("Match 2");
        GridPane.setRowIndex(ml2, 12);
        GridPane.setColumnIndex(ml2, 30);


        TextArea match3 = new TextArea();
        match3.setText("Autonomous:\nTeleOP:\nEnd Game:\n");
        match3.setPrefHeight(300);
        match3.setMaxWidth(200);
        GridPane.setRowIndex(match3,16);
        GridPane.setColumnIndex(match3, 0);

        Label ml3 = new Label("Match 3");
        GridPane.setRowIndex(ml3, 15);
        GridPane.setColumnIndex(ml3, 0);

        TextArea match4 = new TextArea();
        match4.setText("Autonomous:\nTeleOP:\nEnd Game:\n");
        match4.setPrefHeight(300);
        match4.setMaxWidth(200);
        GridPane.setRowIndex(match4, 16);
        GridPane.setColumnIndex(match4, 30);

        Label ml4 = new Label("Match 4");
        GridPane.setRowIndex(ml4, 15);
        GridPane.setColumnIndex(ml4, 30);

        TextArea match5 = new TextArea();
        match5.setText("Autonomous:\nTeleOp:\nEnd Game:\n");
        match5.setPrefHeight(300);
        match5.setMaxWidth(200);
        GridPane.setRowIndex(match5, 19);
        GridPane.setColumnIndex(match5, 30);

        Label ml5 = new Label("Match 5");
        GridPane.setRowIndex(ml5, 18);
        GridPane.setColumnIndex(ml5, 30);

        grid.getChildren().addAll(matches, match1, match2, match3, match4, match5, ml1, ml2, ml3, ml4, ml5);


        //Scene Builder for scene2
        VBox root2 = new VBox();
        root2.getChildren().addAll(grid);
        //teamName, teamNameField, teamNumber, teamNumberField, autonomous, ch1, ch2, ch3, ch4, reliability, reliabilityTextField, teleop, ch5, ch6, ch7, ch8, reliability2, reliabilityTextField2, endgame, ch9, ch10, ch11, ch12, ch13, ch14, reliability3, reliabilityTextField3, ml1, match1, ml2, match2, ml3, match3, ml4, match4, ml5, match5);
        scene2 = new Scene(root2, 1500, 700);

        //button that takes us to scene1
        button1.setOnAction(e -> primaryStage.setScene(scene2));





    }
}

