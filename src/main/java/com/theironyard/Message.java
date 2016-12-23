package com.theironyard;

import java.util.ArrayList;

/**
 * Created by scofieldservices on 12/20/16.
 */
public class Message {
    int id;
    String message;

    public Message (int i, String m) {
        this.id = i;
        this.message = m;
    }
    public Message (String m) {
        this.message = m;
    }

    public Message(){

    }

}

