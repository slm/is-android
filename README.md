is-android
===================


Simple android checks

----------

![Screenshot:]
(https://raw.githubusercontent.com/slmyldz/is-android/master/screenshots/Screenshot_20151225-143423.png)

----------
Install:

Step 1. Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.slmyldz:is-android:v1.0'
	}
```
----------
Usage:

You can add  ```android:name="is.IsApplication"``` on AndroidManifest into application tags

or

You can create a class that extends Application and call under the onCreate method that ```Is.init(this);```



