package com.eleonoralion.server;

import java.io.Serializable;

public class Message implements Serializable {

    private String sms;

    public Message(String sms){
        this.sms = sms;
    }

    public String getSms() {
        return sms;
    }
}
