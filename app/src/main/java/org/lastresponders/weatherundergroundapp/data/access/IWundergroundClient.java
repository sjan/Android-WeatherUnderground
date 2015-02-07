package org.lastresponders.weatherundergroundapp.data.access;

import org.lastresponders.weatherundergroundapp.exception.MessageException;
import org.lastresponders.weatherundergroundapp.exception.NetworkException;

/**
 * Created by stephenjan on 2/6/15.
 */
public interface IWundergroundClient {
    String conditions(String s) throws MessageException, NetworkException;

    String hourly(String s)throws MessageException, NetworkException;

    String day(String s)throws MessageException, NetworkException;;
}
