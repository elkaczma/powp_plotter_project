package edu.iis.powp.factories;

import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.command.CommandDrawLineToPosition;
import edu.iis.powp.command.CommandSetPosition;
import edu.iis.powp.command.ComplexCommand;
import edu.iis.powp.command.PlotterCommand;

public class FigureFactory {
	
	public static ComplexCommand drawRectangle(int startX, int startY, int width, int height) {
		
		List<PlotterCommand> commandsList = new ArrayList<>();
		commandsList.add(new CommandSetPosition(startX, startY));
		commandsList.add(new CommandDrawLineToPosition(startX+width, startY));
		commandsList.add(new CommandDrawLineToPosition(startX+width, startY+height));
		commandsList.add(new CommandDrawLineToPosition(startX, startY+height));
		commandsList.add(new CommandDrawLineToPosition(startX, startY));
		
		return new ComplexCommand(commandsList);
	}
	
public static ComplexCommand drawFigureJoe1(int startX, int startY, int side) {
		
		List<PlotterCommand> commandsList = new ArrayList<>();
		commandsList.add(new CommandSetPosition(startX, startY));
		commandsList.add(new CommandDrawLineToPosition(startX+side, startY));
		commandsList.add(new CommandDrawLineToPosition(startX+side, startY+side));
		commandsList.add(new CommandDrawLineToPosition(startX, startY+side));
		commandsList.add(new CommandDrawLineToPosition(startX, startY));
		commandsList.add(new CommandDrawLineToPosition(startX+side, startY+side));
		commandsList.add(new CommandSetPosition(startX+side, startY));
		commandsList.add(new CommandDrawLineToPosition(startX, startY+side));
		
		return new ComplexCommand(commandsList);
	}
	
}
