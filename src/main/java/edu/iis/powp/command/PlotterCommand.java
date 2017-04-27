package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

public interface PlotterCommand {
	
	public void execute(IPlotter plotter);
}
