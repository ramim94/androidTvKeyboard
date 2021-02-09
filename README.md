# Android TV Keyboard

A basic helper library with a keyboard layout to be used on TV apps


## Download

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

       allprojects {
          repositories {
             maven { url 'https://jitpack.io' }
          }
       }

**Step 2.** Add the dependency

       dependencies {
               implementation 'com.github.ramim94:androidTvKeyboard:1.0.3'
       }


## Usage

Just put it in your activity/fragment xml like this:

    <com.ramim94.tvkeyboard.TvKeyboardView
      android:padding="5dp"
      android:id="@+id/keyboard"
      android:layout_width="wrap_content"
      android:layout_height="match_parent"
      />

Create a reference in your java/kotlin code and add the OnSearchButtonPressedListener

    keyboardView = findViewById(R.id.keyboard)
    keyboardView.addOnSearchButtonPressedListener(this)

Use to callback to get the string from keyboard input:

    override fun onSearchButtonPressed(queryString: String) {
        Log.d(TAG, "onSearchButtonPressed: $queryString")
        //process input text as you wish.
    }