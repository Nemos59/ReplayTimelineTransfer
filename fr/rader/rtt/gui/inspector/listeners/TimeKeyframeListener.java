package fr.rader.rtt.gui.inspector.listeners;

import fr.rader.rtt.gui.inspector.TimelineInspector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeKeyframeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedType = (String) ((JComboBox<String>) e.getSource()).getSelectedItem();

		TimelineInspector timelineInspector = TimelineInspector.getInstance();

		timelineInspector.replayTimestampField.setText(String.valueOf(timelineInspector.timePath.getKeyframes().get(Integer.parseInt(selectedType)).getTime()));
		timelineInspector.keyframeTimestampField.setText(String.valueOf(timelineInspector.timePath.getKeyframes().get(Integer.parseInt(selectedType)).getProperties().get("timestamp")));
	}
}
