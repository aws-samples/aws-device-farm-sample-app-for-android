# Device Farm Sample App for Android

This is a sample native Android app that contains most of the stock Android components and elements. Example [Appium](), [Calabash](), and [Espresso]() tests have been written for this app. 

Please use this app and example test suites as a reference for your own Device Farm tests.

#### Notes

This project uses [Butterknife](http://jakewharton.github.io/butterknife/) in order to create Android views and view listeners through annotations.

## Getting Started
In order to run this app within Device Farm you can either use the [preassembled APK]() or [open](https://github.com/dogriffiths/HeadFirstAndroid/wiki/How-to-open-a-project-in-Android-Studio) and [build](https://developer.android.com/training/basics/firstapp/index.html) the APK yourself from source.

## Strategies for Testing Specific Scenarios

|Component |Android Implementation| Espresso | Calabash | Appium |
|----------|----------------------|----------|----------|--------|
|Alerts: [Toasts](http://developer.android.com/guide/topics/ui/notifiers/toasts.html) and [Dialogs](http://developer.android.com/guide/topics/ui/dialogs.html)   | [source code]()              |[source code]()|[source code]()|[source code]()
|Fixtures|[source code]()|[source code]()|[source code]()|[source code]()
|Static Page: [TextView](http://developer.android.com/reference/android/widget/TextView.html)|[source code]()|[source code]()|[source code]()|[source code]()
|Login Page|[source code]()|[source code]()|[source code]()|[source code]()
|Nested Views: [Back and Up Navigation](http://developer.android.com/design/patterns/navigation.html)|[source code]()|[source code]()|[source code]()|[source code]()
|[Web Views](http://developer.android.com/reference/android/webkit/WebView.html)| <ul><li>[Hybrid Web Views]()</li><li>[Web View]()</li></ul>|<ul><li>[Hybrid Web Views]()</li><li>[Web View]()</li></ul>|<ul><li>[Hybrid Web Views]()</li><li>[Web View]()</li></ul>|<ul><li>[Hybrid Web Views]()</li><li>[Web View]()</li></ul>


## Strategies for Native Features

|Feature |Android Implementation| Espresso| Calabash | Appium |
|--------|----------------------|---------|----------|--------|
|[Camera](http://developer.android.com/guide/topics/media/camera.html)  |[source code]() |[source code]() |[source code]() |[source code]()|
|[Image Collection Grid](http://developer.android.com/guide/topics/ui/layout/gridview.html)|[source code]()|[source code]()|[source code]()|[source code]()|
|[Scroll View](http://developer.android.com/reference/android/widget/ScrollView.html)|[source code]()|[source code]()|[source code]()|[source code]()|
|Out of View Content|[source code]()|[source code]()|[source code]()|[source code]()|
|[Video](http://developer.android.com/reference/android/media/MediaPlayer.html)|[source code]()|[source code]()|[source code]()|[source code]()|


## Strategies for Testing Inputs

|Component |Android Implementation| Espresso| Calabash | Appium |
|--------------|---------|----------|--------|--|
|[Checkbox](http://developer.android.com/reference/android/widget/CheckBox.html)|[source code]()|[source code]()|[source code]()|[source code]()
|[DatePicker](http://developer.android.com/reference/android/widget/DatePicker.html)|[source code]()|[source code]()|[source code]()|[source code]()
|[EditText](http://developer.android.com/reference/android/widget/EditText.html)|[source code]()|[source code]()|[source code]()|[source code]()
|[Gestures Input](http://developer.android.com/training/gestures/index.html)|[source code]()|[source code]()|[source code]()|[source code]()
|[Pull to Refresh](https://developer.android.com/reference/android/support/v4/widget/SwipeRefreshLayout.html)|[source code]()|[source code]()|[source code]()|[source code]()
|[Radio Buttons](http://developer.android.com/guide/topics/ui/controls/radiobutton.html)|[source code]()|[source code]()|[source code]()|[source code]()
|[TimePicker](http://developer.android.com/reference/android/widget/TimePicker.html)|[source code]()|[source code]()|[source code]()|[source code]()
|[Toggle Button](http://developer.android.com/guide/topics/ui/controls/togglebutton.html)|[source code]()|[source code]()|[source code]()|[source code]()

## Strategies for Automated Navigation
|Component |Android Implementation| Espresso| Calabash | Appium |
|--------------|---------|----------|--------|----|
|[Navigation Drawer](https://developer.android.com/training/implementing-navigation/nav-drawer.html)|[source code]()|[source code]()|[source code]()|[source code]()|
|[ViewPager](http://developer.android.com/reference/android/support/v4/view/ViewPager.html)|[source code]()|[source code]()|[source code]()|[source code]()|


## Android Tips and Tricks
- Android Devices come in many different screen sizes. Make sure to properly layout your views within your Android XML file. Follow [this guide](http://developer.android.com/guide/practices/screens_support.html) in order to learn more about writting code to support different screen sizes. Here is an [example](#) in the Android code where there are different defined values depending on the screen-size. This automatically resized elements within the layouts so that views completely fill all types of screens sizes. **Remember if a element/view isn't completely on the screen during testing it cannot be verified.**


# Espresso

## Setting Up and Running Espresso Tests

#### **First read [this guide](https://developer.android.com/training/testing/ui-testing/espresso-testing.html).**

### Configuring Android Studio to run Espresso Locally
You must set a custom Instrumentation run configuration to run your Espresso tests locally. You need to set the instrumentation runner to "**android.support.test.runner.AndroidJUnitRunner**"

<img src="https://improvement-ninjas.amazon.com/s3files/s3get.cgi/espresso-android-studio-set-up.gif" width="1200">

### Building the App and Test APK (to use with Device Farm)
You will need two APKs: the app apk and the Espresso (Instrumentation) test apk.

#### Step 0: Go to your project directory
Open your terminal/command prompt and change your directory to your project folder.

#### Step 1: Build the project
**OSX/Linux**

Enter the following command inside the terminal prompt to build the project and test apks:  
```
./gradlew cC
```

***Windows***

Enter the following command inside the command prompt to build the project and test apks:  
```
gradlew.bat cC
```

#### Step 2: Find the APKS
<img src="https://improvement-ninjas.amazon.com/s3files/s3get.cgi/find-apk.gif" width="400">

The app APK is called **app-debug.apk** and the test apk is **app-debug-androidTest-unaligned.apk**

Follow the [Device Farm Directions for Instrumentation](http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-instrumentation.html) in order to upload the APKs into the console and perform a test.


# Strategies for Espresso

## Waiting for Elements
Use [Idling Resources](https://code.google.com/p/android-test-kit/wiki/EspressoSamples#Using_registerIdlingResource_to_synchronize_with_custom_resource) in order to wait for elements within Espresso.

Examples of custom Idling Resources used within the Espresso tests:

<ul><li><a href="">VideoPlayerIdlingResource</a></li><li><a href ="">ViewPagerIdlingResource</a></li><li><a href="">WebViewIdlingResource</a></li></ul>

## Custom Matchers
Use [custom matchers](https://code.google.com/p/android-test-kit/wiki/EspressoSamples#Matching_data_using_onData_and_a_custom_ViewMatcher) in order to match your views to custom elements within your tests. 

Examples of custom Matchers used within the Espresso tests: [RegularExpressionMatcher]()

## Tips
- If you are receiving threading errors make sure to run the test code in the UI thread. Use the [UiThreadTest annotation](http://developer.android.com/reference/android/support/test/annotation/UiThreadTest.html). Due to security concerns tests that run on threads outside of the UI thread cannot communicate with the UI. 
- Your app's package name must match your app's applicationId that is defined in your gradle file. If the two names do not match tests may not run. 


