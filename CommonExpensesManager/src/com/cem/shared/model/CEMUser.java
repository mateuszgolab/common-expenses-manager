package com.cem.shared.model;

import com.google.appengine.api.users.User;


public class CEMUser
{
    
    private User googleUser;
    private double balance;
    private String name;
    
    public String getName()
    {
        return name;
    }
    
    public String getGoogleUserName()
    {
        return googleUser.getNickname();
    }
    
    public double getBalance()
    {
        return balance;
    }

}
