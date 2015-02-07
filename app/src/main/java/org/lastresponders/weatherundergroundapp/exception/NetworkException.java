package org.lastresponders.weatherundergroundapp.exception;

import android.net.Network;

import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

/**
 * Created by stephenjan on 2/6/15.
 */
public class NetworkException extends Exception {

    public NetworkException(String s) {
        super(s);
    }

    public NetworkException(IOException e) {

    }

    public NetworkException(ClientProtocolException e) {

    }
}
