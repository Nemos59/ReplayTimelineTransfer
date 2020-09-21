package fr.rader.rtt.gui.inspector.listeners;

import fr.rader.rtt.gui.inspector.TimelineInspector;
import fr.rader.rtt.timeline.Keyframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranslateTimelineListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		TimelineInspector timelineInspector = TimelineInspector.getInstance();

		double diffX = Double.parseDouble(timelineInspector.newXField.getText()) - Double.parseDouble(timelineInspector.oldXField.getText());
		double diffY = Double.parseDouble(timelineInspector.newYField.getText()) - Double.parseDouble(timelineInspector.oldYField.getText());
		double diffZ = Double.parseDouble(timelineInspector.newZField.getText()) - Double.parseDouble(timelineInspector.oldZField.getText());

		for(Keyframe keyframe : timelineInspector.positionPath.getKeyframes()) {
			double[] position = (double[]) keyframe.getProperties().get("camera:position");

			position[0] += diffX;
			position[1] += diffY;
			position[2] += diffZ;
		}

		timelineInspector.xField.setText(String.valueOf(Double.parseDouble(timelineInspector.xField.getText()) + diffX));
		timelineInspector.yField.setText(String.valueOf(Double.parseDouble(timelineInspector.yField.getText()) + diffY));
		timelineInspector.zField.setText(String.valueOf(Double.parseDouble(timelineInspector.zField.getText()) + diffZ));
	}
}