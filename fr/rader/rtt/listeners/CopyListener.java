package fr.rader.rtt.listeners;

import fr.rader.rtt.Interface;
import fr.rader.rtt.Main;
import fr.rader.rtt.timeline.Timeline;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CopyListener implements ActionListener {

	private Interface theInterface;

	@Override
	public void actionPerformed(ActionEvent e) {
		theInterface = Interface.getInstance();

		if(e.getSource().equals(theInterface.copyRight)) {
			if(Main.getInstance().getLeftFile() == null) return;

			copyToList(theInterface.leftList.getSelectedValuesList(), true);
		} else {
			if(Main.getInstance().getRightFile() == null) return;

			copyToList(theInterface.rightList.getSelectedValuesList(), false);
		}
	}

	private void copyToList(List<String> selectedTimelines, boolean copyToRight) {
		for(String name : selectedTimelines) {
			if(copyToRight) {
				if(theInterface.rightTimelineList != null && !theInterface.rightTimelineList.containsKey(name)) {
					theInterface.rightTimelineList.put(name, theInterface.leftTimelineList.get(name));
				} else if(theInterface.rightTimelineList != null) {
					String newTimelineName = JOptionPane.showInputDialog(null, "\"" + Main.getInstance().getRightFile().getName() + "\" already contains a timeline named \"" + name + "\"\nEnter a new name or press cancel to cancel");

					if(newTimelineName != null) {
						while(theInterface.leftTimelineList.containsKey(newTimelineName)) {
							newTimelineName = JOptionPane.showInputDialog(null, "Enter a new name for \"" + name + "\" or press cancel to cancel");
							if(name == null) return;
						}

						theInterface.rightTimelineList.put(newTimelineName, theInterface.leftTimelineList.get(name));
					}
				}
			} else {
				if(theInterface.leftTimelineList != null && !theInterface.leftTimelineList.containsKey(name)) {
					theInterface.leftTimelineList.put(name, theInterface.rightTimelineList.get(name));
				} else if(theInterface.leftTimelineList != null) {
					String newTimelineName = JOptionPane.showInputDialog(null, "\"" + Main.getInstance().getLeftFile().getName() + "\" already contains a timeline named \"" + name + "\"\nEnter a new name or press cancel to cancel");

					if(newTimelineName != null) {
						while(theInterface.rightTimelineList.containsKey(newTimelineName)) {
							newTimelineName = JOptionPane.showInputDialog(null, "Enter a new name for \"" + name + "\" or press cancel to cancel");
							if(name == null) return;
						}

						theInterface.leftTimelineList.put(newTimelineName, theInterface.rightTimelineList.get(name));
					}
				}
			}
		}

		theInterface.updateNames();
	}
}
