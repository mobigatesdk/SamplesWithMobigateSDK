package pl.spicymobile.basicintegration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.spicymobile.mobience.sdk.MobigateSDK

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trackEvent()
    }

    /**
     * In-App Events provide insight on what is happening in your app. It is recommended to take the time and define the events you would like to measure
     */
    private fun trackEvent() {
        MobigateSDK.get().trackEvent("Application started!")
    }

}
