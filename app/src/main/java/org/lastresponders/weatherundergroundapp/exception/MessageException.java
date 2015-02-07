package org.lastresponders.weatherundergroundapp.exception;

import org.json.JSONException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by stephenjan on 2/6/15.
 */
public class MessageException extends  Exception{
    public MessageException(String s) {
        super(s);
    }

    public MessageException(UnsupportedEncodingException e) {

    }


    public MessageException(JSONException e) {

    }
}
