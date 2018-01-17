package com.acmerobotics.scouter;

import javafx.scene.control.ListCell;

public class TeamCell extends ListCell<Team> {

    @Override
    public void updateItem(Team team, boolean empty) {
        super.updateItem(team, empty);

        if (team != null && !empty) {
            this.setText(team.getName() + " : " + team.getNumber());
        }
    }
}
