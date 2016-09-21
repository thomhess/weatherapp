
////////////////////////////////////
/// Assignment 1 - Documentation ///
////////////////////////////////////
Name: Thomas Hesselberg
Student number: 470599

/// Description ///The application I have made for this first assignment is a simple native Android app. In the first activity after start-up, the user is presented the current location, temperature, timestamp of the temperature and altitude at the users location. In addition to these elements, two buttons are available; “Map” and “Add to database”. The first one of these, the “Map”-button, directs the user to the second activity, which shows a world map, as well as the users location (fetched from the phones GPS). The other button, “Add to database”, adds the current info (name of the place, timestamp, latitude, longitude, altitude and temperature) to an SQLite-database. Temperature, timestamp and location name is received by using the OpenWeatherMap API. Altitude and maps are received by using the Google Maps API.The app does have some limitations/issues. The app will need a functioning GPS-connection to receive and display information. Without a connection, the information goes blank. Also, the loading time of the place, temperature and timestamp varies a lot, even though GPS-location has been found. It might vary from less than a second and up to a minute or two.

/// About the process ///I found this assignment really hard, maybe too hard. Coming from web development, only programming in JavaScript from before, coding this app was an enormous challenge. I’ve spent most of my spare time teaching myself Java trough YouTube-tutorials, trying to learn the syntax well enough to understand what to do. I’ve therefore mostly used code presented in those tutorials, but merged it together myself using the little I’ve learned these weeks. Check out my sources for the tutorials and other code I’ve used.For next year, I’d wish for this class and its assignments to be more “scalable” based on your current skill level, making it more manageable for the ones not too experienced with programming.

/// Use of stored data ///In this app, I’ve not used the stored data when restarting from shutdown, other than the location info presented from the SQLite-database if you’ve clicked “Add to database” earlier. This is partially because it wasn’t required for this assignment, and partially because I had a hard enough time doing the required stuff. Regardless of that, I still think that would be a great feature. A regular user doesn’t move a lot each day; he or she usually lives and works in the same city. Therefore, presenting the information from last time the user used the app before the current information loads, will at least give the user something to rest his/her eyes upon until the updated information displays. Still, this should be accompanied with a loading bar/wheel during the loading of information, signalizing something is happening. Without this feature, the user might think the information presented is the updated information, and will therefore be misinformed.In other apps, the use of stored data might be much more useful. The app may save progress and other info for the user, and retrieve it whenever needed, even after a shutdown. This is a feature useful for a game, notepad and everything in between, storing progress, scores, text or other information.

/// Native apps and web apps ///In this part of the documentation, I will discuss the difference between native apps and web apps. At first, I will present the technical difference that separates these two, and take a look at the pros and cons for each of them. Thereafter I will reference to the app I have developed, and discuss whether it could/should have been a web-app.The simplest description of the difference between these two types of apps is that one is installed on the phone and the other isn’t. The native app is developed for one particular mobile operative system, and is downloaded and installed on the device itself. It is therefore possible for developers to develop apps specifically for one platform, using a native coding language. These apps may then be published in an application store associated with the mobile platform, such as AppStore or Google Play Store.Web apps, on the other hand, are applications that’s only available trough the mobile devices’ web browser. In difference to the native apps, these wont have to be downloaded to the users device for them to be used, but is rather temporary downloadable in the same way as a web page. This type of app is developed using web-related coding languages, and is unfortunately not possible to publish in the applications store.One of the major advantages with the native app is the compatibility with the devices’ hardware and native features. The web app, on the other hand, has only limited access to the same features. Because of this integration with the system, the native app usually also perform faster on the device. It is also easier to price and sell, because it has full support from the app stores. The web apps are not available in these stores, and need both their own distribution channel and payment system. Therefore, they may also be more difficult to discover.Since the web app isn’t installed on the device, the user never has to update the app to get the newest features; it updates itself. Therefore, the developer never has to worry that the users are using different versions of the app, which may be the case for the native app.  Unlike the native apps, the same coding language is used for all devices in a web app, and it is therefore easier to develop for different devices, also the older ones. However, the developer never know what browser the user will be using, and have to develop for a broad variety. There are also no SDK-tools for building web apps.The app I have made is a native app, developed specifically for Android. One of the greatest advantages making a native app was the compatibility with the devices’ hardware and native features. Making this app native therefore meant easy access to the GPS and location data. Still, you are not required to make a native app to access all the hardware features, and geolocation is one of these examples. In all modern mobile web browsers, the users GPS-location is accessible. The other features of the app, such as weather data, location data and Google Maps, are also available through web. Therefore, this app could have been a web app instead of a native app.

/// Extending the app ///There is a lot of ways in which this app may be extended, and the question isn’t whether it can be extended, but rather which direction you want to choose. I will now present three possible directions:
// Fully functioning weather applicationYou might have one on your phone already, a full-scale app showing the weather forecast. Using additional API’s from OpenWeatherMap, it is possible to code an application able to show weather forecast up to 16 days in advance. Making such an app, you may include the same GPS-based functionality that was presented in my original application, presenting weather-information based on your current location. In addition, this extension of the app may be able to add information by searching for locations, using the Google Maps API. This extension will give the user a much greater overview of the weather to come./ Weather mapExtending on the map-feature in my application, and using OpenWeatherMap’s “Weather map layers”-API, you may make a really interesting application with various weather maps. On a map, you may change between the overlay showing clouds, precipitations, sea level pressure, wind speed, temperature and snow.
/ An app saving weather dataEver wondered what weather you experienced on a particular date? Me neither, but this extension of the app may solve that issue anyway. Using the SQLite-database from my application, and a broader selection of weather data, you may save the data from each day to the database. Limiting it to one save per day, after a while your phone will have the weather data from numerous days saved. Based on this database, you may let the user search the database, and figure out both the location and what weather he/she encountered that day.
/ Bonus ideaCombining the two first ideas, and a list of ski resorts (with their location), you may make an app specifically designed for skiers. Using the snow-map and forecast for the ski resorts, you may alert the user whenever there will be a great snowfall at one resort, so the skiers will be able to ski in fresh powder.

/// Sources ///
/ Native apps and web appsViswanathan, P. (2016) Native Apps vs. Web Apps – What is the Better Choice? [Online]. Available from: http://mobiledevices.about.com/od/additionalresources/a/Native-Apps-Vs-Web-Apps-Which-Is-The-Better-Choice.htm (Fetched: 11. september 2016). Viswanathan, P. (2015) The Pros and Cons of Native Apps and Mobile Web Apps [Online]. Available from: http://mobiledevices.about.com/od/additionalresources/qt/The-Pros-And-Cons-Of-Native-Apps-And-Mobile-Web-Apps.htm (Fetched: 11. september 2016). Caniuse.com. (2015) Geolocation [Online]. Available from: http://caniuse.com/#search=geolocation (Fetched: 11. september 2016). Mozilla Developer Network and individual contributors. (2015) Using geolocation [Online]. Available from: https://developer.mozilla.org/en-US/docs/Web/API/Geolocation/Using_geolocation (Fetched: 11. september 2016). / Tutorials and codeMaking a simple weather-app: http://androstock.com/tutorials/create-a-weather-app-on-android-android-studio.html OpenWeatherMap API documentation: http://openweathermap.org/currentMaking a SQLite-database (video 49-54): https://www.youtube.com/playlist?list=PL6gx4Cwl9DGBsvRxJJOzG4r4k_zLKrnxlRequesting location updates: https://developer.android.com/guide/topics/location/strategies.html#UpdatesRequesting location permissions:https://developer.android.com/training/permissions/requesting.htmlSending a double to a new activity:http://stackoverflow.com/questions/9588026/passing-a-double-value-through-to-a-different-class-in-android-java