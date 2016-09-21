package com.androstock.myweatherapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Function {

	private static final String WeatherURL =
			"http://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&units=metric";

	private static final String WeatherAPI = "eada0ee894d73ea18b24a787a9d564ad";

	public interface AsyncResponse {

		void processFinish(String output1, String output2, String output3);
	}

	 public static class placeIdTask extends AsyncTask<String, Void, JSONObject> {

		public AsyncResponse delegate = null;//Call back interface

		 public placeIdTask(AsyncResponse asyncResponse) {
			 delegate = asyncResponse;//Assigning call back interface through constructor
		 }

		@Override
		protected JSONObject doInBackground(String... params) {

			JSONObject jsonWeather = null;
			try {
				jsonWeather = getWeatherJSON(params[0], params[1]);
			} catch (Exception e) {
				Log.d("Error", "Cannot process JSON results", e);
			}

			return jsonWeather;
		}

		@Override
		protected void onPostExecute(JSONObject json) {
			try {
			if(json != null){
				JSONObject main = json.getJSONObject("main");
				DateFormat df = DateFormat.getDateTimeInstance();


				String city = json.getString("name").toUpperCase(Locale.US) + ", " + json.getJSONObject("sys").getString("country");
				String temperature = String.format("%.1f", main.getDouble("temp"))+ "°C";
				String updatedOn = df.format(new Date(json.getLong("dt")*1000));

				delegate.processFinish(city, temperature, updatedOn);

			}
			} catch (JSONException e) {
				//Log.e(LOG_TAG, "Cannot process JSON results", e);
			}
		}
	}

	public static JSONObject getWeatherJSON(String lat, String lon){
		try {
			URL url = new URL(String.format(WeatherURL, lat, lon));
			HttpURLConnection connection =
					(HttpURLConnection)url.openConnection();

			connection.addRequestProperty("x-api-key", WeatherAPI);

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));

			StringBuffer json = new StringBuffer(1024);
			String tmp="";
			while((tmp=reader.readLine())!=null)
				json.append(tmp).append("\n");
			reader.close();

			JSONObject data = new JSONObject(json.toString());

			// This value will be 404 if the request was not
			// successful
			if(data.getInt("cod") != 200){
				return null;
			}

			return data;
		}catch(Exception e){
			return null;
		}
	}




}