package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.DriverManager;

public class SelectTestFigureOptionListener implements ActionListener
{
	public enum FigureScript {
		_1, _2;
	}
	
	private FigureScript figureScript;
	
	public SelectTestFigureOptionListener() {
		this.figureScript = FigureScript._1; // domyslny konstruktor wyswietli pierwsza figure
	}
	
	public SelectTestFigureOptionListener(FigureScript figureScript) {
		this.figureScript = figureScript;
	}
	
    @Override
    public void actionPerformed(ActionEvent e)
    {	
    	if (figureScript == FigureScript._1) {
    		FiguresJoe.figureScript1(Application.getComponent(DriverManager.class).getCurrentPlotter());
    	} else {
    		FiguresJoe.figureScript2(Application.getComponent(DriverManager.class).getCurrentPlotter());
    	}
    }
}
