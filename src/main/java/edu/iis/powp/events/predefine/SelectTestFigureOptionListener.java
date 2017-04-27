package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.client.plottermagic.AbstractPlotter;
import edu.iis.client.plottermagic.preset.FiguresJane;
import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.ComplexCommand;
import edu.iis.powp.factories.FigureFactory;

public class SelectTestFigureOptionListener implements ActionListener
{
	public enum FigureScript {
		_1, _2, _3, _4, _5;
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
    	} else if (figureScript == FigureScript._2) {
    		FiguresJoe.figureScript2(Application.getComponent(DriverManager.class).getCurrentPlotter());
    	} else if (figureScript == FigureScript._3) {
    		FiguresJane.figureScript((AbstractPlotter) Application.getComponent(DriverManager.class).getCurrentPlotter());
    	} else if (figureScript == FigureScript._4) {
    		ComplexCommand command = FigureFactory.drawRectangle(50, 50, 200, 100);
    		command.execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
    	} else {
    		ComplexCommand command = FigureFactory.drawFigureJoe1(-120, -120, 240);
    		command.execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
    	}
    }
}
