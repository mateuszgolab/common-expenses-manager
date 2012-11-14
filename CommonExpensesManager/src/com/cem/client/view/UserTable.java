package com.cem.client.view;

import java.util.ArrayList;
import java.util.List;

import com.cem.shared.model.CEMUser;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.i18n.client.DateTimeFormat;


public class UserTable extends LayoutContainer
{
    
    private ColumnModel columnModel;
    private ContentPanel contentPanel;
    private Grid<UserTableModel> grid;
    private ListStore<UserTableModel> store;
    private UserTableModel selected;
    private GridCellRenderer<UserTableModel> buttonRenderer;
    
    public UserTable()
    {
        store = new ListStore<UserTableModel>();
        
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
        ColumnConfig column = new ColumnConfig();
        
        column = new ColumnConfig();
        column.setId("name");
        column.setHeader("Name");
        column.setWidth(150);
        configs.add(column);
        
        column = new ColumnConfig();
        column.setId("min");
        column.setHeader("Min");
        column.setWidth(75);
        configs.add(column);
        
        column = new ColumnConfig();
        column.setId("max");
        column.setHeader("Max");
        column.setWidth(75);
        configs.add(column);
        
        column = new ColumnConfig();
        column.setId("step");
        column.setHeader("Step");
        column.setWidth(75);
        configs.add(column);
        
        column = new ColumnConfig();
        column.setId("date");
        column.setHeader("Saved");
        column.setDateTimeFormat(DateTimeFormat.getFormat("HH:mm:ss   dd.MM.yyyy"));
        column.setWidth(175);
        configs.add(column);
        
        column = new ColumnConfig();
        column.setId("equations");
        column.setHeader("Equations");
        column.setRenderer(buttonRenderer);
        column.setWidth(150);
        configs.add(column);
        
        columnModel = new ColumnModel(configs);
        
        grid = new Grid<UserTableModel>(store, columnModel);
        grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        grid.getSelectionModel().addListener(Events.SelectionChange,
                new Listener<SelectionChangedEvent<UserTableModel>>()
                {
                    
                    @Override
                    public void handleEvent(SelectionChangedEvent<UserTableModel> be)
                    {
                        if (be.getSelection().size() > 0)
                        {
                            selected = be.getSelection().get(0);
                            
                        }
                        else
                        {
                            selected = null;
                        }
                    }
                });
        grid.getView().setAutoFill(true);
        contentPanel = new ContentPanel();
        contentPanel.add(grid);
        contentPanel.setHeading("System of equations");
        contentPanel.setFrame(true);
        contentPanel.setLayout(new FitLayout());
        contentPanel.setSize(600, 400);
        
        add(contentPanel);
    }
    
    // @Override
    // protected void onRender(Element parent, int index)
    // {
    // super.onRender(parent, index);
    // setLayout(new FlowLayout(10));
    // getAriaSupport().setPresentation(true);
    //
    //
    // }
    
    public List<String> getSelectedEquations()
    {
        return selected.get("equations");
    }
    
    public String getRangeProperty(String property)
    {
        return selected.get(property).toString();
    }
    
    public String getSelectedName()
    {
        return selected.get("name");
    }
    
    public void setData(List<CEMUser> data)
    {
        if (columnModel != null)
        {
            store = new ListStore<UserTableModel>();
            store.add(new UserTableModel(data));
            grid.reconfigure(store, columnModel);
        }
    }
    
    public void clearSelection()
    {
        if (grid != null)
            grid.getSelectionModel().deselectAll();
    }
    
    public void removeSelectedSystem()
    {
        if (selected != null)
            store.remove(selected);
    }

}