package edu.towson.cis.cosc442.project1.monopoly.gui;


import javax.swing.JButton;
import java.io.Serializable;

public class PlayerPanelProduct2 implements Serializable {
	private JButton btnEndTurn;

	public JButton getBtnEndTurn() {
		return btnEndTurn;
	}

	public void setBtnEndTurn(JButton btnEndTurn) {
		this.btnEndTurn = btnEndTurn;
	}

	public boolean isEndTurnButtonEnabled() {
		return btnEndTurn.isEnabled();
	}

	public void setEndTurnEnabled(boolean enabled) {
		btnEndTurn.setEnabled(enabled);
	}
}