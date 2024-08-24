# Pop Animation Library
The Pop Animation Library is an Android Studio library that allows developers to easily add dynamic pop-up animations to their applications. With this library, images can either fall from the top of the screen or pop up from the bottom, adding an engaging visual element to your app.

## Features
- **Customizable Animation Direction:** Choose whether images will fall from the top of the screen or rise from the bottom.
- **Adjustable Duration:** Set the minimum duration for each image's appearance, with an additional random value to create natural spacing between them.
- **Interval Control:** Specify the time interval between each image, giving you control over the pacing of the animation.
- **Image Size Customization:** Define the size of the images to fit your design needs.
- **Image Count:** Set the number of images to appear in the animation.
- **Animation Type:** Decide whether the images will have a rotation animation (ROTATE) or appear without rotation.

## Installation
To include the Pop Animation Library in your project, add the following configuration to your `build.gradle` file:  

### Step 1: Add Maven Repository

Add the following code to the `dependencyResolutionManagement` section in your project's `settings.gradle` file:

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add Dependency
Add the library dependency to your app module's build.gradle file:
``` gradle
dependencies {
    implementation 'com.github.Tal-Shavit:popanimationlibrary:Tag'
}
```
Replace `Tag` with the specific version or commit tag you want to use from the repository.

## Usage
 ``` java
// Initialize the library
private PopAnimationView popcornView;

// Set the image
popcornView.setImage(R.drawable.popcorn);
// Set the count of images
popcornView.setPopcornCount(an integer);
// Set the size of images
popcornView.setSize(an integer);
// Set the interval
popcornView.setInterval(intervalTxt);
// Set the duration
popcornView.setDuration(durationTxt);
// Set the direction
// top-to-bottom
popcornView.setAnimationDirection(AnimationDirection.FALL_FROM_TOP);
// bottom-to-top
 popcornView.setAnimationDirection(AnimationDirection.BOUNCE_FROM_BOTTOM);
// Set the type
// rotate
popcornView.setAnimationType(AnimationType.FALL_WITH_ROTATION);
// regular
 popcornView.setAnimationType(AnimationType.FALL_NO_ROTATION);

// Show the images 
popcornView.post(new Runnable() {
                    @Override
                    public void run() {
                        popcornView.startAnimation();
                    }
                });
```

## Demonstration Video
  
https://github.com/user-attachments/assets/2b25284a-5a7e-445e-9c70-a7b4f98ac6fc


