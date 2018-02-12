package com.acmerobotics.scouter;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private StringProperty nameProperty = new SimpleStringProperty();
    private IntegerProperty numberProperty = new SimpleIntegerProperty();
    private DoubleProperty averageRankProperty = new SimpleDoubleProperty(3.0);
    private List<MatchData> matchDataList = new ArrayList<>();
    private int match1Rank = 3;
    private int match2Rank = 3;
    private int match3Rank = 3;
    private int match4Rank = 3;
    private int match5Rank = 3;



    public Team(String name, int number) {
        this.nameProperty.setValue(name);
        this.numberProperty.setValue(number);

        for (int i = 0;i < 5; i++) {
            matchDataList.add(new MatchData());
        }
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

    public List<MatchData> getMatchDataList() {
        return matchDataList;
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


