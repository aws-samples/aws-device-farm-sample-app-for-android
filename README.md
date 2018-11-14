# AWS Device Farm Sample App for Android
This is a sample native Android app that contains many of the stock Android components and elements, along with example [Appium](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app), [Calabash](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app), and [Espresso](https://github.com/awslabs/aws-device-farm-sample-app-for-android#strategies-for-espresso) tests. You can use the app and example tests as a reference for your own AWS Device Farm test scripts.

#### Notes
This project uses [Butterknife](http://jakewharton.github.io/butterknife/) in order to create Android views and view listeners through annotations.

## Getting Started
In order to run this app on Device Farm, you will first need to create a local copy of this repository, [open](https://github.com/dogriffiths/HeadFirstAndroid/wiki/How-to-open-a-project-in-Android-Studio) the project, and then [build](https://developer.android.com/training/basics/firstapp/index.html) the APK from the source.

## Examples for Testing Specific Scenarios
|Component |App Implementation| Espresso | Calabash | Appium |
|----------|----------------------|----------|----------|--------|
|Alerts: [Toasts](http://developer.android.com/guide/topics/ui/notifiers/toasts.html) and [Dialogs](http://developer.android.com/guide/topics/ui/dialogs.html)   | [source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/NotificationsFragment.java)              |[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/AlertPageTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/alert_page.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/AlertPageTest.java)
|Fixtures|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/FixturesFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/FixturesTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/fixtures_page.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/FixturesTest.java)
|Static Page: [TextView](http://developer.android.com/reference/android/widget/TextView.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/res/layout/fragment_homepage.xml)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/HomePageTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/homepage.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/HomePageTest.java)
|Login Page|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/LoginFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/LoginPageTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/login_page.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/LoginTest.java)
|Nested Views: [Back and Up Navigation](http://developer.android.com/design/patterns/navigation.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/NestedFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/NestedViewTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/nested_views_page.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/NestedViewsTest.java)
|[Web Views](http://developer.android.com/reference/android/webkit/WebView.html)| <ul><li>[Hybrid Web Views](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/LocalWebView.java)</li><li>[Web View](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/WebViewFragment.java)</li></ul>|<ul><li>[Hybrid Web Views](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/LocalWebViewTest.java)</li><li>[Web View](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/WebViewTests.java)</li></ul>|<ul><li>[Hybrid Web Views](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/hybrid_web_view.rb)</li><li>[Web View](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/webview_page.rb)</li></ul>|<ul><li>[Web View](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/WebViewTest.java)</li></ul>
| An Expected Crash|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/crashFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/CrashPageTest.java)| Not implemented|Not implemented

## Examples for Native Features
|Feature |Android Implementation| Espresso| Calabash | Appium |
|--------|----------------------|---------|----------|--------|
|[Camera](http://developer.android.com/guide/topics/media/camera.html)  |[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Native/Native_CameraFragment.java) |[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Native/CameraPreviewTest.java) |[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/native_components.rb) |[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/CameraTest.java)|
|[Image Collection Grid](http://developer.android.com/guide/topics/ui/layout/gridview.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Native/Native_ImageGalleryFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Native/ImageCollectionTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/native_components.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/ImageGalleryTest.java)|
|[Scroll View](http://developer.android.com/reference/android/widget/ScrollView.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/res/layout/native_content_scrolling.xml)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Native/ScrollingContentTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/native_components.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/ScrollViewTest.java)|
|Out of View Content|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/res/layout/native_out_of_view_scrolling.xml)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Native/OutOfContentScrollingTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/native_components.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/OutOfViewTest.java)|
|[Video](http://developer.android.com/reference/android/media/MediaPlayer.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Native/Native_MediaPlayer.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Native/VideoTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/native_components.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Native/MediaPlayerTest.java)|

## Examples for Inputs
|Component |Android Implementation| Espresso | Calabash | Appium |
|----------|----------------------|----------|----------|--------|
|[Checkbox](http://developer.android.com/reference/android/widget/CheckBox.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_CheckBoxFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/CheckBoxTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/CheckboxTest.java)|
|[DatePicker](http://developer.android.com/reference/android/widget/DatePicker.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_DatePickerFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/DatePickerTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|Not implemented (not directly supported by Appium)|
|[EditText](http://developer.android.com/reference/android/widget/EditText.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/res/layout/input_textfield.xml)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/EditTextTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/EditText.java)|
|[Gestures Input](http://developer.android.com/training/gestures/index.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_GestureFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/GesturesTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/GesturesTest.java)|
|[Pull to Refresh](https://developer.android.com/reference/android/support/v4/widget/SwipeRefreshLayout.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_RefreshButtonFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/PullToRefreshTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/PullToRefreshTest.java)|
|[Radio Buttons](http://developer.android.com/guide/topics/ui/controls/radiobutton.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_RadioButtonFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/RadioButtonTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/RadioButtonTest.java)|
|[TimePicker](http://developer.android.com/reference/android/widget/TimePicker.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_TimePickerFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/TimePickerTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|Not implemented (not directly supported by Appium)|
|[Toggle Button](http://developer.android.com/guide/topics/ui/controls/togglebutton.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_Toggle_ButtonFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/ToggleButtonTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/ToggleButtonTest.java)|
|[Spinner Input](http://developer.android.com/guide/topics/ui/controls/spinner.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_SpinnerFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/SpinnerInputTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/Inputs/SpinnerTest.java)|
|[Buttons](http://developer.android.com/reference/android/widget/Button.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/Tabs/Inputs/Input_SubmitButtonFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/Categories/Inputs/SubmitButtonTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/input_controls.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Pages/AlertPage.java)|

## Examples for Navigation
|Component|Android Implementation|Espresso|Calabash|Appium|
|----------|----------------------|----------|----------|--------|
|[Navigation Drawer](https://developer.android.com/training/implementing-navigation/nav-drawer.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/NavigationDrawerFragment.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/BaseADFTest.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/navigation_steps.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Pages/NavigationPage.java)|
|[ViewPager](http://developer.android.com/reference/android/support/v4/view/ViewPager.html)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/main/java/com/amazonaws/devicefarm/android/referenceapp/Fragments/TabFragmentContainer.java)|[source code](https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/ViewPagerTestBase.java)|[source code](https://github.com/awslabs/aws-device-farm-calabash-tests-for-sample-app/blob/master/features/step_definitions/steps/navigation_steps.rb)|[source code](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Pages/TabViewPage.java)|

## Android Tips and Tricks
- Android Devices come in many different screen sizes. Make sure to properly layout your views within your Android XML file. Follow [this guide](http://developer.android.com/guide/practices/screens_support.html) in order to learn more about writing code to support different screen sizes. Here is an [example](https://github.com/awslabs/aws-device-farm-sample-app-for-android/tree/master/app/src/main/res) in the Android code where there are different defined values depending on the screen-size. This automatically resizes elements within the layouts so that views adapt to all screens sizes. **Remember if an element/view isn't completely on the screen during testing it cannot be verified.**

# Espresso
## Setting Up and Running Espresso Tests
#### **If you're just getting started, first read [this guide](https://developer.android.com/training/testing/ui-testing/espresso-testing.html).**
### Configuring Android Studio to Run Espresso Locally
You must set a custom Instrumentation run configuration to run your Espresso tests locally. You need to set the instrumentation runner to "**android.support.test.runner.AndroidJUnitRunner**"

<img src="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/readme_images/espresso-android-studio-set-up.gif" width="1200">

### Building the App and Test APK to Run on Device Farm
You will need two APKs: the app apk and the Espresso (Instrumentation) test apk.

#### Step 1: Go to your project directory
Open your terminal/command prompt and change your directory to your project folder.

#### Step 2: Build the project
***Linux and OSX***

Enter the following command inside the terminal prompt to build the project and test apks:  
```
./gradlew cC
```

***Windows***

Enter the following command inside the command prompt to build the project and test apks:  
```
gradlew.bat cC
```

#### Step 3: Find the APKS
<img src="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/readme_images/find-apk.gif" width="400">

The app APK is called **app-debug.apk** and the test apk is **app-debug-androidTest-unaligned.apk**.

Follow the [Device Farm Directions for Instrumentation](http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-instrumentation.html) in order to upload the APKs into the console and perform a test.

# Strategies for Espresso
## Waiting for Elements
Use [Idling Resources](https://code.google.com/p/android-test-kit/wiki/EspressoSamples#Using_registerIdlingResource_to_synchronize_with_custom_resource) in order to wait for elements within Espresso.

Examples of custom Idling Resources used within the Espresso tests:
<ul><li><a href="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/IdlingResources/VideoPlayerIdlingResource.java">VideoPlayerIdlingResource</a></li><li><a href ="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/IdlingResources/ViewPagerIdlingResource.java">ViewPagerIdlingResource</a></li><li><a href="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/IdlingResources/WebViewIdlingResource.java">WebViewIdlingResource</a></li></ul>

## Custom Matchers
Use [custom matchers](https://code.google.com/p/android-test-kit/wiki/EspressoSamples#Matching_data_using_onData_and_a_custom_ViewMatcher) in order to match your views to custom elements within your tests.

Examples of custom Matchers used within the Espresso tests:
<ul><li><a href="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/RegularExpressionMatcher.java">RegularExpressionMatcher</a></li></ul>

## Tips
- If you see threading errors make sure to run the test code in the UI thread. Use the [UiThreadTest annotation](http://developer.android.com/reference/android/support/test/annotation/UiThreadTest.html). Due to security concerns tests that run on threads outside of the UI thread cannot communicate with the UI.
- Your app's package name must match your app's applicationId that is defined in your gradle file. If the two names do not match tests will not run.

## Using Espresso Recorder

#### Pre-Requisites

1. Android Studio 2.3.2 or above
2. Android Emulator downloaded or a physical Android device.

#### Steps:

1. Download the AWS Device Farm Android sample app from GitHub.
2. Open the project in Android Studio.
3. We will generate Instrumentation tests using Espresso Recorder.
   * Select Run —> Record Espresso Test —> Select Deployment target as Android emulator or a real physical device </br>
   * Click Ok. This will open up the emulator where gradle will launch the app in the emulator. In addition it will open up a "Record your Test" window. </br>
4. We will record a test for alert functionality within the app.
   * On the app running on emulator click on Menu button —> Alerts. You will notice that the recorder window records the UI interactions as shown below. </br>
   
     <img src="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/readme_images/recorder-ui-interactions.png" width=375 height=500/>
     
   * We will add an assertion to check for the presence of "Alert" button on the page. In the "Record your Test" window click on "Add Assertion". This will expand the Recorder window with a snapshot of the app running in the emulator as shown below. </br>
   
     <img src="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/readme_images/assertion-view.png" width=600 height=500 />
     
   * Select "Alert" button in the recorder window. This will auto populate the id of Alert button in the edit assertion section as shown below. Keep the assertion selection to default "exists" and click on Save Assertion. </br>
     <img src="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/readme_images/recorder-save-assertion.png" width=600 height=500 />
     
   * After you click on Ok in the recorder window it will ask for a test class name under which your recorded test will be stored. Enter MyAlertTest. This will generate the test code and save it under MyAlertTest.java which you can view in the project explorer.
5. Now we want to run the recorded tests locally. To do this we first want a configuration that will run Android Instrumented Tests.
   * Go to Run —> Edit Configurations.
   * Click on '+' sign on the left hand top corner and select "Android Instrumented Tests" as shown below. </br>
   
     <img src="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/readme_images/edit-configuration.png" width=625 height=500 />
     
   * Name the configuration as "MyTestConfig". For the Class we provide the name of the class "MyAlertTest" under which we saved our tests. A completed configuration will look like below. Click Ok to save the configuration. </br>
   
     <img src="https://github.com/awslabs/aws-device-farm-sample-app-for-android/blob/master/readme_images/completed-configuration.png" width=625 height=500 />
  
6. Run the tests by selecting "MyTestConfig" as the configuration and clicking on play. This will invoke the emulator and run your tests.
7. We now want to build the app and tests apks so that you can run them on AWS Device Farm on multiple devices in parallel.
   * Open your terminal/command prompt and change your directory to your project folder.
   * Set JAVA_HOME to Java home on your machine.
   * For Mac/Linux run the following command inside the terminal prompt to build the project and test apks. This will run all the tests under the project on a connected device. Make sure you have at least one or emulator device connected.
  ```
  ./gradlew cC
  ```
   * For Windows run the following command inside the terminal prompt to build the project and test apks. This will run all the tests under the project on a connected device. Make sure you have at least one or emulator device connected.
  ```
  gradlew.bat cC
  ```
   * The app and test apks will now be present under <br/>
   aws-device-farm-sample-app-for-android/app/build/outputs/apk
8.  We can upload the app and test apks to AWS Device Farm as Instrumentation tests and run them against hundreds of devices in parallel. The pre-built app and tests can be found [here](https://s3.console.aws.amazon.com/s3/buckets/prebuiltappsreinvent2017/).
