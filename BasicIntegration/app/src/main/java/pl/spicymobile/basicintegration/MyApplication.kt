package pl.spicymobile.basicintegration

import android.app.Application
import pl.spicymobile.mobience.sdk.DataCollector
import pl.spicymobile.mobience.sdk.MobigateSDK
import pl.spicymobile.mobience.sdk.SDK

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initMobigate()
    }

    private fun initMobigate() {
        //init builder with application context and key from business partner

        val mobigateSdk = MobigateSDK.Builder(
            applicationContext,
            "V0K6jhiIfem6CRWHYZ59Nmj3oFBBKbJsnSsWfR2JNq7ktblOUXwbJoBQTpWnw2uSwW76gpiu2kun50jweTY69B")
                //other custom builder methods
            //.setAppIdentifier(BuildConfig.APPLICATION_ID)
            //.setAppInstallationSource("any source")
            //.setEmail("email_example@gmail.com")
            //.setCustomUserID("JanKowalski")
            .build();

        //add custom collectors configuration if it's needed
        addCustomConfiguration(mobigateSdk)

        // Start library and that's all
        mobigateSdk.startService();
    }

    private fun addCustomConfiguration(sdk: SDK) {
        sdk.disableAllDataCollector();
        sdk.configureDataCollectors(
            true, intArrayOf(
                DataCollector.APPS_LIST
                , DataCollector.BLUETOOTH_COLLECTOR
                , DataCollector.BATTERY
                , DataCollector.WIFI_DATA_CONNECTION
            )
        )
    }
}