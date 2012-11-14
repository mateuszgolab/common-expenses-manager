package com.cem.client.view;

import com.cem.client.presenter.CommonExpensesManagerPresenter;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;


public class CommonExpensesManagerView extends Composite implements CommonExpensesManagerPresenter.Display
{
    
    private UserTable usersTable;

    public CommonExpensesManagerView()
    {
        DecoratorPanel contentTableDecorator = new DecoratorPanel();
        initWidget(contentTableDecorator);
        contentTableDecorator.setWidth("100%");
        contentTableDecorator.setWidth("18em");
        
        usersTable = new UserTable();
        
        contentTableDecorator.add(usersTable);

        
    }
    
}
