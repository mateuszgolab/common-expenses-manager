package com.cem.client.presenter;

import com.cem.client.CommonExpensesManagerServiceAsync;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;


public class CommonExpensesManagerPresenter implements Presenter
{
    
    public interface Display
    {
        
        Widget asWidget();
    }
    
    private final CommonExpensesManagerServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final Display display;
    
    public CommonExpensesManagerPresenter(CommonExpensesManagerServiceAsync rpcService, HandlerManager eventBus,
            Display view)
    {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = view;
      }
    
    @Override
    public void go(HasWidgets container)
    {
        // TODO Auto-generated method stub
        
    }
}
