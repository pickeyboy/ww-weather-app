package au.com.challenge.ww.weatherapp;

import android.os.Build;

/**
 * Common configuration for tests classes
 */
public interface TestConfig {
    /**
     * Android SDK version to run Robolectric tests under.
     * Robolectric currently supports only until Lollipop
     */
    int ANDROID_TEST_SDK_VERSION = Build.VERSION_CODES.LOLLIPOP;

    /**
     * Use the resources of our current flavour/build type to run the tests
     */
    String ANDROID_MERGED_RES_DIR = "../../../app/build/intermediates/res/merged/" + BuildConfig.FLAVOR + "/" + BuildConfig.BUILD_TYPE;

    /**
     * Location of the AndroidManifest to configure tests
     */
    String ANDROID_MANIFEST = "../app/src/main/AndroidManifest.xml";

}
