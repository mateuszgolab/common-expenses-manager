package com.cem.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CommonExpensesManager implements EntryPoint
{
    
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network " + "connection and try again.";
    
    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final CommonExpensesManagerServiceAsync greetingService = GWT.create(CommonExpensesManagerService.class);
    
    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad()
    {
        CommonExpensesManagerServiceAsync rpcService = GWT.create(CommonExpensesManagerService.class);
        HandlerManager eventBus = new HandlerManager(null);
        AppController appViewer = new AppController(rpcService, eventBus);
        appViewer.go(RootPanel.get());
    }
}
