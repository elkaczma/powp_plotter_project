package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.AbstractPlotter;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

public class AbstractPlotterAdapter extends AbstractPlotter {
	
	private DrawPanelController drawPanelController;
	
	public AbstractPlotterAdapter(int x, int y, DrawPanelController drawPanelController) {
		super(x, y);
		this.drawPanelController = drawPanelController;
	}

	@Override
	public void drawTo(int x, int y) 
	{
		ILine line = LineFactory.getBasicLine();
    	line.setStartCoordinates(super.getX(), super.getY());
        line.setEndCoordinates(x, y);
        
        drawPanelController.drawLine(line);
        setPosition(x, y);
	}
	
	@Override
    public String toString()
    {
        return "Abstract Plotter Adapter";
    }

}
