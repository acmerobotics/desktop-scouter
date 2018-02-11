package com.acmerobotics.scouter;


import javafx.beans.property.*;

public class Team {

    private StringProperty nameProperty = new SimpleStringProperty();
    private IntegerProperty numberProperty = new SimpleIntegerProperty();
    private DoubleProperty averageRankProperty = new SimpleDoubleProperty(3.0);
    private StringProperty match1AutoProperty = new SimpleStringProperty();
    private StringProperty match1TeleProperty = new SimpleStringProperty();
    private StringProperty match1EndProperty = new SimpleStringProperty();
    private StringProperty match2AutoProperty = new SimpleStringProperty();
    private StringProperty match2TeleProperty = new SimpleStringProperty();
    private StringProperty match2EndProperty = new SimpleStringProperty();
    private StringProperty match3AutoProperty = new SimpleStringProperty();
    private StringProperty match3TeleProperty = new SimpleStringProperty();
    private StringProperty match3EndProperty = new SimpleStringProperty();
    private StringProperty match4AutoProperty = new SimpleStringProperty();
    private StringProperty match4TeleProperty = new SimpleStringProperty();
    private StringProperty match4EndProperty = new SimpleStringProperty();
    private StringProperty match5AutoProperty = new SimpleStringProperty();
    private StringProperty match5TeleProperty = new SimpleStringProperty();
    private StringProperty match5EndProperty = new SimpleStringProperty();
    private int match1Rank = 3;
    private int match2Rank = 3;
    private int match3Rank = 3;
    private int match4Rank = 3;
    private int match5Rank = 3;



    public Team(String name, int number) {
        this.nameProperty.setValue(name);
        this.numberProperty.setValue(number);

    }

    public String getName() {
        return nameProperty.getValue();
    }

    public int getNumber() {
        return numberProperty.getValue();
    }

    public void setName(String newName) {
        nameProperty.setValue(newName);

    }

    public void setNumber(int newNumber) {
        numberProperty.setValue(newNumber);
    }

    public String getMatch1Auto() {
        return match1AutoProperty.getValue();
    }

    public void setMatch1Auto(String match1Auto) {
        this.match1AutoProperty.setValue(match1Auto);
    }

    public String getMatch1Tele() {
        return match1TeleProperty.getValue();
    }

    public void setMatch1Tele(String match1Tele) {
        this.match1TeleProperty.setValue(match1Tele);
    }

    public String getMatch1End() {
        return match1EndProperty.getValue();
    }

    public void setMatch1End(String match1End) {
        this.match1EndProperty.setValue(match1End);
    }

    public String getMatch2Auto() {
        return match2AutoProperty.getValue();
    }

    public void setMatch2Auto(String match2Auto) {
        this.match2AutoProperty.setValue(match2Auto);
    }

    public String getMatch2Tele() {
        return match2TeleProperty.getValue();
    }

    public void setMatch2Tele(String match2Tele) {
        this.match2TeleProperty.setValue(match2Tele);
    }

    public String getMatch2End() {
        return match2EndProperty.getValue();
    }

    public void setMatch2End(String match2End) {
        this.match2EndProperty.setValue(match2End);

    }

    public String getMatch3Auto() {
        return match3AutoProperty.getValue();
    }

    public void setMatch3Auto(String match3Auto) {
        this.match3AutoProperty.setValue(match3Auto);
    }

    public String getMatch3Tele() {
        return match3TeleProperty.getValue();
    }

    public void setMatch3Tele(String match3Tele) {
        this.match3TeleProperty.setValue(match3Tele);
    }

    public String getMatch3End() {
        return match3EndProperty.getValue();
    }

    public void setMatch3End(String match3End) {
        this.match3EndProperty.setValue(match3End);
    }

    public String getMatch4Auto() {
        return match4AutoProperty.getValue();
    }

    public void setMatch4Auto(String match4Auto) {
        this.match4AutoProperty.setValue(match4Auto);
    }

    public String getMatch4Tele() {
        return match4TeleProperty.getValue();
    }

    public void setMatch4Tele(String match4Tele) {
        this.match4TeleProperty.setValue(match4Tele);
    }

    public String getMatch4End() {
        return match4EndProperty.getValue();
    }

    public void setMatch4End(String match4End) {
        this.match4EndProperty.setValue(match4End);
    }

    public String getMatch5Auto() {
        return match5AutoProperty.getValue();
    }

    public void setMatch5Auto(String match5Auto) {
        this.match5AutoProperty.setValue(match5Auto);
    }

    public String getMatch5Tele() {
        return match5TeleProperty.getValue();
    }

    public void setMatch5Tele(String match5Tele) {
        this.match5TeleProperty.setValue(match5Tele);
    }

    public String getMatch5End() {
        return match5EndProperty.getValue();
    }

    public void setMatch5End(String match5End) {
        this.match5EndProperty.setValue(match5End);
    }

    public int getMatch1Rank() {
        return match1Rank;
    }

    public void setMatch1Rank(int match1Rank) {
        this.match1Rank = match1Rank;
    }

    public int getMatch2Rank() {
        return match2Rank;
    }

    public void setMatch2Rank(int match2Rank){
        this.match2Rank = match2Rank;
    }

    public int getMatch3Rank() {
        return match3Rank;
    }

    public void setMatch3Rank(int match3Rank) {
        this.match3Rank = match3Rank;
    }

    public int getMatch4Rank() {
        return match4Rank;
    }

    public void setMatch4Rank(int match4Rank) {
        this.match4Rank = match4Rank;
    }

    public int getMatch5Rank() {
        return match5Rank;
    }

    public void setMatch5Rank(int match5Rank) {
        this.match5Rank = match5Rank;
    }

    public void recalculateAverageRank() {
        int sum = match1Rank + match2Rank + match3Rank + match4Rank + match5Rank;
        this.averageRankProperty.setValue(sum/5.0);

    }

    public double getAverageRank() {
        return averageRankProperty.getValue();

    }

}


