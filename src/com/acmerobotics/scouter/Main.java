package com.acmerobotics.scouter;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
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
    private List<CheckBox> gotJewelCheckBoxes = new ArrayList<>();
    private List<CheckBox> parkedCheckBoxes = new ArrayList<>();
    private List<TextField> autoGlyphsField = new ArrayList<>();
    private List<CheckBox> keyCheckBoxes = new ArrayList<>();
    private List<TextField> teleGlyphsField = new ArrayList<>();
    private List<TextField> numberofRowsField = new ArrayList<>();
    private List<TextField> numberofColunmsField = new ArrayList<>();
    private List<CheckBox> cipherCheckBoxes = new ArrayList<>();
    private List<RadioButton> notPlacedRadioButtons = new ArrayList<>();
    private List<RadioButton> zone1RadioButtons = new ArrayList<>();
    private List<RadioButton> zone2RadioButtons = new ArrayList<>();
    private List<RadioButton> zone3RadioButtons = new ArrayList<>();
    private List<CheckBox> relicUprightCheckBoxes = new ArrayList<>();
    private List<CheckBox> onBalancingStoneCheckBoxes = new ArrayList<>();
    private ToggleGroup rankingMatch1;
    private List<RadioButton> rankMatch1 = new ArrayList<>();
    private ToggleGroup rankingMatch2;
    private List<RadioButton> rankMatch2 = new ArrayList<>();
    private ToggleGroup rankingMatch3;
    private List<RadioButton> rankMatch3 = new ArrayList<>();
    private ToggleGroup rankingMatch4;
    private List<RadioButton> rankMatch4 = new ArrayList<>();
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

        // Additional components and Labels for matches


        int row1 = 3;
        int row2 = 3;
        int row3 = 3;
        int row4 = 3;
        for (int i = 0; i < 5; i++) {
            CheckBox jewelBox = new CheckBox("Got Jewel");
            GridPane.setRowIndex(jewelBox, row1++);
            GridPane.setColumnIndex(jewelBox, 0);
            grid.getChildren().add(jewelBox);
            gotJewelCheckBoxes.add(jewelBox);
            CheckBox parkedBox = new CheckBox("Parked");
            GridPane.setRowIndex(parkedBox, row1++);
            GridPane.setColumnIndex(parkedBox, 0);
            grid.getChildren().add(parkedBox);
            parkedCheckBoxes.add(parkedBox);
            TextField autoGlyphField = new TextField();
            autoGlyphField.setMaxWidth(50);
            GridPane.setRowIndex(autoGlyphField, row1++);
            GridPane.setColumnIndex(autoGlyphField, 0);
            grid.getChildren().add(autoGlyphField);
            autoGlyphsField.add(autoGlyphField);
            CheckBox keyBox = new CheckBox("Cryptobox Key");
            GridPane.setRowIndex(keyBox, row1++);
            GridPane.setColumnIndex(keyBox, 0);
            grid.getChildren().add(keyBox);
            keyCheckBoxes.add(keyBox);
            TextField teleGlyphField = new TextField();
            teleGlyphField.setMaxWidth(50);
            GridPane.setRowIndex(teleGlyphField, row2++);
            GridPane.setColumnIndex(teleGlyphField, 3);
            grid.getChildren().add(teleGlyphField);
            teleGlyphsField.add(teleGlyphField);
            TextField numberofRows = new TextField();
            numberofRows.setMaxWidth(50);
            GridPane.setRowIndex(numberofRows, row2++);
            GridPane.setColumnIndex(numberofRows, 3);
            grid.getChildren().add(numberofRows);
            numberofRowsField.add(numberofRows);
            TextField numberofColumns = new TextField();
            numberofColumns.setMaxWidth(50);
            GridPane.setRowIndex(numberofColumns, row2++);
            GridPane.setColumnIndex(numberofColumns, 3);
            grid.getChildren().add(numberofColumns);
            numberofColunmsField.add(numberofColumns);
            CheckBox cipherBox = new CheckBox("Cipher");
            GridPane.setRowIndex(cipherBox, row2++);
            GridPane.setColumnIndex(cipherBox, 3);
            grid.getChildren().add(cipherBox);
            cipherCheckBoxes.add(cipherBox);
            ToggleGroup relicToggleGroup = new ToggleGroup();
            RadioButton notplacedButton = new RadioButton("Not Placed");
            notplacedButton.setToggleGroup(relicToggleGroup);
            GridPane.setRowIndex(notplacedButton, row3++);
            GridPane.setColumnIndex(notplacedButton, 5);
            grid.getChildren().add(notplacedButton);
            notPlacedRadioButtons.add(notplacedButton);
            RadioButton zone1Button = new RadioButton("Zone 1");
            zone1Button.setToggleGroup(relicToggleGroup);
            GridPane.setRowIndex(zone1Button, row3++);
            GridPane.setColumnIndex(zone1Button, 5);
            grid.getChildren().add(zone1Button);
            zone1RadioButtons.add(zone1Button);
            RadioButton zone2Button = new RadioButton("Zone 2");
            zone2Button.setToggleGroup(relicToggleGroup);
            GridPane.setRowIndex(zone2Button, row3++);
            GridPane.setColumnIndex(zone2Button, 5);
            grid.getChildren().add(zone2Button);
            zone2RadioButtons.add(zone2Button);
            RadioButton zone3Button = new RadioButton("Zone 3");
            zone3Button.setToggleGroup(relicToggleGroup);
            GridPane.setRowIndex(zone3Button, row3++);
            GridPane.setColumnIndex(zone3Button, 5);
            grid.getChildren().add(zone3Button);
            zone3RadioButtons.add(zone3Button);
            CheckBox relicUprightBox = new CheckBox("Relic Upright");
            GridPane.setRowIndex(relicUprightBox, row4++);
            GridPane.setColumnIndex(relicUprightBox, 6);
            grid.getChildren().add(relicUprightBox);
            relicUprightCheckBoxes.add(relicUprightBox);
            CheckBox onStoneBox = new CheckBox("Balancing On Stone");
            GridPane.setRowIndex(onStoneBox, row4++);
            GridPane.setColumnIndex(onStoneBox, 6);
            grid.getChildren().add(onStoneBox);
            onBalancingStoneCheckBoxes.add(onStoneBox);


        }



        Label autoLabel = new Label("Autonomous:");
        autoLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(autoLabel, 2);
        GridPane.setColumnIndex(autoLabel, 0);
        Label teleLabel = new Label("TeleOp:");
        teleLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL,15));
        GridPane.setRowIndex(teleLabel,2);
        GridPane.setColumnIndex(teleLabel,3);
        Label endLabel = new Label("End Game:");
        endLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setRowIndex(endLabel,2);
        GridPane.setColumnIndex(endLabel, 5);
        grid.getChildren().addAll(autoLabel, teleLabel, endLabel);

        // RadioButtons for Rankings

        rankingMatch1 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch1 = new RadioButton(Integer.toString(i + 1));
            buttonMatch1.setToggleGroup(rankingMatch1);
            GridPane.setRowIndex(buttonMatch1, 4);
            GridPane.setColumnIndex(buttonMatch1, i + 7);
            grid.getChildren().add(buttonMatch1);
            rankMatch1.add(buttonMatch1);
        }

        rankingMatch2 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch2 = new RadioButton(Integer.toString(i + 1));
            buttonMatch2.setToggleGroup(rankingMatch2);
            GridPane.setRowIndex(buttonMatch2, 7);
            GridPane.setColumnIndex(buttonMatch2, i + 7);
            grid.getChildren().add(buttonMatch2);
            rankMatch2.add(buttonMatch2);
        }

        rankingMatch3 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch3 = new RadioButton(Integer.toString(i + 1));
            buttonMatch3.setToggleGroup(rankingMatch3);
            GridPane.setRowIndex(buttonMatch3, 10);
            GridPane.setColumnIndex(buttonMatch3, i + 7);
            grid.getChildren().add(buttonMatch3);
            rankMatch3.add(buttonMatch3);
        }

        rankingMatch4 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch4 = new RadioButton(Integer.toString(i + 1));
            buttonMatch4.setToggleGroup(rankingMatch4);
            GridPane.setRowIndex(buttonMatch4, 13);
            GridPane.setColumnIndex(buttonMatch4, i + 7);
            grid.getChildren().add(buttonMatch4);
            rankMatch4.add(buttonMatch4);
        }

        rankingMatch5 = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            RadioButton buttonMatch5 = new RadioButton(Integer.toString(i + 1));
            buttonMatch5.setToggleGroup(rankingMatch5);
            GridPane.setRowIndex(buttonMatch5, 16);
            GridPane.setColumnIndex(buttonMatch5, i + 7);
            grid.getChildren().add(buttonMatch5);
            rankMatch5.add(buttonMatch5);
        }



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
                for (int i = 0; i < 5; i++) {
                    MatchData match = selectedTeam.getMatchDataList().get(i);
                    CheckBox jewelBox = gotJewelCheckBoxes.get(i);
                    jewelBox.setSelected(match.getJewel());
                    CheckBox parkedBox = parkedCheckBoxes.get(i);
                    parkedBox.setSelected(match.getParked());
                    TextField autoGlyphBox = autoGlyphsField.get(i);
                    autoGlyphBox.setText(match.getAutoGlyphsInBox());
                    CheckBox keyBox = keyCheckBoxes.get(i);
                    keyBox.setSelected(match.getKey());
                    TextField teleGlyphField = teleGlyphsField.get(i);
                    teleGlyphField.setText(match.getTeleGlyphsInBox());
                    TextField rowsField = numberofRowsField.get(i);
                    rowsField.setText(match.getRows());
                    TextField colunmsField = numberofColunmsField.get(i);
                    colunmsField.setText(match.getColunms());
                    CheckBox cipherBox = cipherCheckBoxes.get(i);
                    cipherBox.setSelected(match.getCipher());
                    RadioButton notPlacedButton = notPlacedRadioButtons.get(i);
                    notPlacedButton.setSelected(match.getNotPlaced());
                    RadioButton zone1Button = zone1RadioButtons.get(i);
                    zone1Button.setSelected(match.getZone1());
                    RadioButton zone2Button = zone2RadioButtons.get(i);
                    zone2Button.setSelected(match.getZone2());
                    RadioButton zone3Button = zone3RadioButtons.get(i);
                    zone3Button.setSelected(match.getZone3());
                    CheckBox relicUprightBox = relicUprightCheckBoxes.get(i);
                    relicUprightBox.setSelected(match.getRelicUp());
                    CheckBox onStoneBox = onBalancingStoneCheckBoxes.get(i);
                    onStoneBox.setSelected(match.getOnStone());
                }


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

