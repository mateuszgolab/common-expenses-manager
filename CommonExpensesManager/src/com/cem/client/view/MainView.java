package com.cem.client.view;

import com.cem.client.presenter.CommonExpensesManagerPresenter;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;


public class MainView extends Composite implements CommonExpensesManagerPresenter.Display
{
    
    private UserTable usersTable;

    public MainView()
    {
        DecoratorPanel contentTableDecorator = new DecoratorPanel();
        initWidget(contentTableDecorator);
        contentTableDecorator.setWidth("100%");
        contentTableDecorator.setWidth("18em");
        
        
        FlexTable contentTable = new FlexTable();
        contentTable.setWidth("100%");
        contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListContainer");
        contentTable.getCellFormatter().setWidth(0, 0, "100%");
        contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0, DockPanel.ALIGN_TOP);


        FlexTable contactsTable = new FlexTable();
        contactsTable.setCellSpacing(0);
        contactsTable.setCellPadding(0);
        contactsTable.setWidth("100%");
        contactsTable.addStyleName("contacts-ListContents");
        contactsTable.getColumnFormatter().setWidth(0, "15px");
        contentTable.setWidget(1, 0, contactsTable);
        
        contentTableDecorator.add(contentTable);
        
        // usersTable = new UserTable();
        // contentTableDecorator.add(usersTable);

        
    }
    
}
