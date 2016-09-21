package com.androstock.myweatherapp;

/**
 * Created by thomhess on 19.09.16.
 */
public class WeatherData {

    private int _id;
    private String _location;
    private String _updatedOn;
    private String _latitude;
    private String _longitude;
    private String _altitude;
    private String _temperature;

    public WeatherData(){

    }

    public WeatherData(String location, String updatedOn, String latitude, String longitude, String altitude, String temperature) {
        this._location = location;
        this._updatedOn = updatedOn;
        this._latitude = latitude;
        this._longitude = longitude;
        this._altitude = altitude;
        this._temperature = temperature;
    }

    //Setters
    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    public void set_updatedOn(String _updatedOn) {
        this._updatedOn = _updatedOn;
    }

    public void set_latitude(String _latitude) {
        this._latitude = _latitude;
    }

    public void set_longitude(String _longitude) {
        this._longitude = _longitude;
    }

    public void set_altitude(String _altitude) {
        this._altitude = _altitude;
    }

    public void set_temperature(String _temperature) {
        this._temperature = _temperature;
    }


    //Getters
    public int get_id() {
        return _id;
    }

    public String get_location() {
        return _location;
    }

    public String get_updatedOn() {
        return _updatedOn;
    }

    public String get_latitude() {
        return _latitude;
    }

    public String get_longitude() {
        return _longitude;
    }

    public String get_altitude() {
        return _altitude;
    }

    public String get_temperature() {
        return _temperature;
    }


}
