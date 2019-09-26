# workshopValencia

## Install things needed for the workshop

This is a list of things you need to install to follow along during the workshop.

### install node
`brew install node` on mac, check this link for other OS's https://nodejs.org/en/download/

### install appium
`npm install -g appium`

### install appium-doctor
`npm install appium-doctor -g` 

### install appium desktop
* https://github.com/appium/appium-desktop/releases

### install JDK 8
* https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html


Alternative: https://adoptopenjdk.net/releases.html

### install android SDK
* https://developer.android.com/studio#downloads

After installing android studio you need to open it and follow the instructions to install the android sdk.

If you need an emulator to run your tests, create one https://developer.android.com/studio/run/managing-avds#createavd


### set all variables needed

This is how my variables look on macOS
``` 
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home
export ANDROID_HOME=/Users/josepita/Library/Android/sdk
export PATH=$ANDROID_HOME:$JAVA_HOME:$JAVA_HOME/bin:/usr/local/bin:$PATH
``` 

For windows try this https://www.dev2qa.com/how-to-setup-appium-test-environment-for-windows/


### [MACOS ONLY] install xcode
* open App Store and search for `Xcode`, install it.

### [MACOS ONLY] Install carthage
* `brew install carthage`

### [MACOS ONLY] Install applesimutils
``` 
brew tap wix/brew
brew install applesimutils
``` 
### using appium-doctor, make sure everything is prepared to run appium
`appium-doctor` 


![success](https://i.imgur.com/MzyhLfE.jpg)
### troubleshooting issues
* http://appium.io/docs/en/writing-running-appium/other/troubleshooting/

### Download Jenkins
Download the LTS version of jenkins for your platform
https://jenkins.io/download/
