package org.lastresponders.weatherundergroundapp.data.access;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.lastresponders.weatherundergroundapp.exception.MessageException;
import org.lastresponders.weatherundergroundapp.exception.NetworkException;


import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by stephenjan on 2/5/15.
 */
public class WundergroundClient implements IWundergroundClient {
    public WundergroundClient() {

    }
    int DEFAULT_TIMEOUT = 1000;
    String apiKey = "5bc2d3c5be382a28";
    String URL = "http://api.wunderground.com/";

    public WundergroundClient(int DEFAULT_TIMEOUT, String apiKey, String URL) {
        this.DEFAULT_TIMEOUT = DEFAULT_TIMEOUT;
        this.apiKey = apiKey;
        this.URL = URL;
    }

    public String conditions(String zipcode) throws MessageException, NetworkException{
        Log.d("WundergroundClient", "zipcode:" + zipcode );
        String ret = null;
        StringBuilder queryUrl = null;
        InputStream is = null;
        BufferedReader reader = null;
        try {
            queryUrl = new StringBuilder(URL + "api/" + apiKey + "/conditions/q/" +zipcode+".json");
            if (zipcode == null) {
                throw new MessageException("Null input");
            }

            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, DEFAULT_TIMEOUT);
            DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);

            String rawQuery = queryUrl.toString();
            Log.d("WundergroundClient", "rawQuery " + rawQuery);
            HttpGet httpGet = new HttpGet(rawQuery);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int code = httpResponse.getStatusLine().getStatusCode(); //check http code

            if(badCode(code) ) {
                throw new NetworkException("http status code " + code);
            }

            HttpEntity httpEntity = httpResponse.getEntity();

            is = httpEntity.getContent();
            reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line );
            }

            ret = sb.toString();
            Log.d("WundergroundClient", "rawResponse " + ret);

        } catch (UnsupportedEncodingException e) { //call never went out, encoding error
            throw new MessageException(e);
        } catch (ClientProtocolException e) { //error somwhere in http
            throw new NetworkException(e);
        } catch (IOException e) { //network error, try again
            throw new NetworkException(e);
        } finally {
            closeStream(reader);
            closeStream(is);
        }
        return ret;
    }





    public String  hourly(String zipcode) throws MessageException, NetworkException{
        Log.d("WundergroundClient", "zipcode:" + zipcode );
        String ret = null;
        StringBuilder queryUrl = null;
        InputStream is = null;
        BufferedReader reader = null;
        try {
            queryUrl = new StringBuilder(URL + "api/" + apiKey + "/hourly/q/" +zipcode+".json");
            if (zipcode == null) {
                throw new MessageException("Null input");
            }

            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, DEFAULT_TIMEOUT);
            DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);

            String rawQuery = queryUrl.toString();
            Log.d("WundergroundClient", "rawQuery " + rawQuery);
            HttpGet httpGet = new HttpGet(rawQuery);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int code = httpResponse.getStatusLine().getStatusCode(); //check http code

            if(badCode(code) ) {
                throw new NetworkException("http status code " + code);
            }

            HttpEntity httpEntity = httpResponse.getEntity();

            is = httpEntity.getContent();
            reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line );
            }

            ret = sb.toString();
            Log.d("WundergroundClient", "rawResponse " + ret);

        } catch (UnsupportedEncodingException e) { //call never went out, encoding error
            throw new MessageException(e);
        } catch (ClientProtocolException e) { //error somwhere in http
            throw new NetworkException(e);
        } catch (IOException e) { //network error, try again
            throw new NetworkException(e);
        } finally {
            closeStream(reader);
            closeStream(is);
        }
        return ret;
    }


    public String day(String zipcode) throws MessageException, NetworkException{
        Log.d("WundergroundClient", "zipcode:" + zipcode );
        String ret = null;
        StringBuilder queryUrl = null;
        InputStream is = null;
        BufferedReader reader = null;
        try {
            queryUrl = new StringBuilder(URL + "api/" + apiKey + "/forecast/q/" +zipcode+".json");
            if (zipcode == null) {
                throw new MessageException("Null input");
            }

            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, DEFAULT_TIMEOUT);
            DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);

            String rawQuery = queryUrl.toString();
            Log.d("WundergroundClient", "rawQuery " + rawQuery);
            HttpGet httpGet = new HttpGet(rawQuery);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int code = httpResponse.getStatusLine().getStatusCode(); //check http code

            if(badCode(code) ) {
                throw new NetworkException("http status code " + code);
            }

            HttpEntity httpEntity = httpResponse.getEntity();

            is = httpEntity.getContent();
            reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line );
            }

            ret = sb.toString();
            Log.d("WundergroundClient", "rawResponse " + ret);

        } catch (UnsupportedEncodingException e) { //call never went out, encoding error
            throw new MessageException(e);
        } catch (ClientProtocolException e) { //error somwhere in http
            throw new NetworkException(e);
        } catch (IOException e) { //network error, try again
            throw new NetworkException(e);
        } finally {
            closeStream(reader);
            closeStream(is);
        }
        return ret;
    }


    private boolean badCode(int code) {
        if(code == HttpStatus.SC_OK ||
                code == HttpStatus.SC_ACCEPTED  ||
                code == HttpStatus.SC_NO_CONTENT) {

            return false;
        }

        return false;
    }

    private void closeStream(Closeable s){
        try{
            if(s!=null)s.close();
        }catch(IOException e){
            e.printStackTrace();
            Log.e("WundergroundClient", "error closing stream", e);
        }
    }
}
