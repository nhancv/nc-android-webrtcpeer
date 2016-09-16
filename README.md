webrtcpeer-android
=================
This repository contains an Android library for creating WebRTC connections.

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.nhancv:ot-webrtcpeer-android:{master latest commit hash code}'
	}

Ex:
	compile 'com.github.nhancv:ot-webrtcpeer-android:add453c418'