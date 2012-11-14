package com.cem.client.view;


import java.util.List;

import com.cem.shared.model.CEMUser;
import com.extjs.gxt.ui.client.data.BaseModel;


@SuppressWarnings("serial")
public class UserTableModel extends BaseModel
{
    
    public UserTableModel(List<CEMUser> users)
    {
        for(CEMUser user : users)
        {
            set(user.getName(), user.getGoogleUserName());
        }
    }

}
