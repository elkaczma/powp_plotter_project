package edu.iis.powp.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.iis.client.plottermagic.AbstractPlotter;
import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.AbstractPlotterAdapter;
import edu.iis.powp.adapter.LinePlotterAdapter;
import edu.iis.powp.adapter.PlotterAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.appext.ApplicationWithDrawer;
import edu.iis.powp.events.predefine.SelectChangeVisibleOptionListener;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener.FigureScript;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.LineFactory;


public class TestPlotSoftPatterns
{
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
    /**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param context Application context.
	 */
	private static void setupPresetTests(Context context) {
	    SelectTestFigureOptionListener selectTestFigureOneOptionListener = new SelectTestFigureOptionListener(FigureScript._1);
	    SelectTestFigureOptionListener selectTestFigureTwoOptionListener = new SelectTestFigureOptionListener(FigureScript._2);
	    SelectTestFigureOptionListener selectTestFigureThreeOptionListener = new SelectTestFigureOptionListener(FigureScript._3);
		context.addTest("Figure Joe 1", selectTestFigureOneOptionListener);	 
		context.addTest("Figure Joe 2", selectTestFigureTwoOptionListener);
		context.addTest("Figure Jane", selectTestFigureThreeOptionListener);
	}

	/**
	 * Setup driver manager, and set default IPlotter for application.
	 * 
	 * @param context Application context.
	 */
	private static void setupDrivers(Context context) {
		IPlotter clientPlotter = new ClientPlotter();
		context.addDriver("Client Plotter", clientPlotter);
		Application.getComponent(DriverManager.class).setCurrentPlotter(clientPlotter);
		
		IPlotter plotter = new PlotterAdapter(ApplicationWithDrawer.getDrawPanelController());
		context.addDriver("Plotter Adapter", plotter);
		
		IPlotter linePlotter = new LinePlotterAdapter(ApplicationWithDrawer.getDrawPanelController(), LineFactory.getSpecialLine());
		context.addDriver("Line Plotter Adapter", linePlotter);
		
		AbstractPlotter abstractPlotter = new AbstractPlotterAdapter(0, 0, ApplicationWithDrawer.getDrawPanelController());
		context.addDriver("Abstract Plotter", abstractPlotter);

		context.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param context Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Context context) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
        context.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility", 
        		new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
        defaultDrawerWindow.setVisible(true);
	}
	
	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param context Application context.
	 */
	private static void setupLogger(Context context) {
		Application.addComponent(Logger.class);
		context.addComponentMenu(Logger.class, "Logger", 0);
		context.addComponentMenuElement(Logger.class, "Clear log", (ActionEvent e) -> context.flushLoggerOutput());
		context.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> LOGGER.setLevel(Level.FINE));
		context.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> LOGGER.setLevel(Level.INFO));
		context.addComponentMenuElement(Logger.class, "Warning level", (ActionEvent e) -> LOGGER.setLevel(Level.WARNING));
		context.addComponentMenuElement(Logger.class, "Severe level", (ActionEvent e) -> LOGGER.setLevel(Level.SEVERE));
		context.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> LOGGER.setLevel(Level.OFF));
	}
		
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ApplicationWithDrawer.configureApplication();
                Context context = Application.getComponent(Context.class);
                
                //setupDefaultDrawerVisibilityManagement(context);
                
            	setupDrivers(context);
            	setupPresetTests(context);
            	setupLogger(context);
            	
            	/*
            	3.2.5: Z adaptera klasy warto korzystac w celu przetestowania dzialania rzeczywistego rozwiazania, ktore jest niezwykle kosztowne
            	(np. uruchomienie plotera w tym projekcie); trzeba natomiast w przypadku istnienia niekompatybilnych interfejsow
            	wykorzystywanych w projekcie.
            	*/
            	
            	/*
            	3.3.3: Jesli mowiac o parametrach linii, mamy na mysli np. kolor czy grubosc, mozna utworzyc menu opcji wyboru koloru i grubosci,
            	klase tworzaca linie o wybranych parametrach (np. CustomLine dziedziczaca z AbstractLine), a pozniej dodawac do kontekstu adapter, ktorego
            	konstruktor przyjmuje jako drugi argument obiekt klasy CustomLine.
            	*/
            }

        });
    }

}
