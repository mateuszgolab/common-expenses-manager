package com.cem.client;

import com.cem.client.presenter.CommonExpensesManagerPresenter;
import com.cem.client.presenter.Presenter;
import com.cem.client.view.CommonExpensesManagerView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;





public class AppController implements Presenter, ValueChangeHandler<String>
{
    
    private HasWidgets container;
    private HandlerManager eventBus;
    private CommonExpensesManagerServiceAsync rpcService;
    
    public AppController(CommonExpensesManagerServiceAsync rpcService, HandlerManager eventBus)
    {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        bind();
    }
    
    
    private void bind()
    {

    }


    @Override
    public void go(HasWidgets container)
    {
        this.container = container;

        if ("".equals(History.getToken()))
        {
            History.newItem("list");
        }
        else
        {
            History.fireCurrentHistoryState();
        }
    }
    
    
    @Override
    public void onValueChange(ValueChangeEvent<String> event)
    {
        String token = event.getValue();
        
        if (token != null)
        {
            Presenter presenter = null;
            
            if ("table".equals(token))
            {
                presenter = new CommonExpensesManagerPresenter(rpcService, eventBus, new CommonExpensesManagerView());
            }
            
            if (presenter != null)
            {
                presenter.go(container);
            }
        }
    }
}
