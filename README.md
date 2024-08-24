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
// Initialize the CustomPopup with the context
CustomPopup customPopup = new CustomPopup(context);

// Inflate the custom layout
LayoutInflater inflater = LayoutInflater.from(context);
View customView = inflater.inflate(R.layout.custom_content, null);

// Set the custom view to the pop-up
customPopup.setCustomView(customView);

// Set only the width
customPopup.changeWidth(1000);
// Set only the height
customPopup.changeHeight(1500);
// Set both width and height
customPopup.setPopUpSize(1000, 1500);
// Set solid color background
customPopup.setBackgroundOneColor(R.color.orange);
// Set gradient background - insert two colors and style
customPopup.setGradientBackgroundColor(R.color.lightOrange, R.color.lightBlue, GradientDrawable.Orientation.BOTTOM_TOP);
// Set the corner radius
customPopup.setCornerRadius(90);
// Set the color and width of border
customPopup.setBorder(R.color.black, 4);

// Show the pop-up with position and custom animation
customPopup.show(customView, "center", "scale");
// Or simply show the pop-up in the center without animation
customPopup.show(customView);
```

In this example, customView contains the layout that the developer using the library has prepared. They can then apply the various customization functions to it as needed. For gradient backgrounds, use GradientDrawable.Orientation to specify the direction of the gradient. Use the provided gravity and animation options to position and animate the pop-up.

  
https://github.com/user-attachments/assets/2b25284a-5a7e-445e-9c70-a7b4f98ac6fc


