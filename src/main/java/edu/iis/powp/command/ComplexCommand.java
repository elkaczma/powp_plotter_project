package edu.iis.powp.command;

import java.util.List;

import edu.iis.client.plottermagic.IPlotter;

public class ComplexCommand implements PlotterCommand {
	
	private List<PlotterCommand> commandsList;
	
	public ComplexCommand(List<PlotterCommand> commandsList) {
		super();
		this.commandsList = commandsList;
	}

	@Override
	public void execute(IPlotter plotter) {
		for (PlotterCommand command : this.commandsList) {
			command.execute(plotter);
		}
	}

}
