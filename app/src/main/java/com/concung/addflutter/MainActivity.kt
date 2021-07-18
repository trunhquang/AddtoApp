package com.concung.addflutter

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.flutter.FlutterInjector
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor


class MainActivity : AppCompatActivity() {
    var flutterEngine: FlutterEngine? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate a FlutterEngine.
        flutterEngine = FlutterEngine(this)


        // Configure an initial route.
        flutterEngine?.getNavigationChannel()?.setInitialRoute("your/route/here");

        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine?.dartExecutor?.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        val flutterLoader = FlutterInjector.instance().flutterLoader()

//        flutterEngine?.dartExecutor?.executeDartEntrypoint(
//            DartExecutor.DartEntrypoint(flutterLoader.findAppBundlePath(), "adasd")
//        )

        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)


        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(
                FlutterActivity
                    .withCachedEngine("my_engine_id")
                    .build(this)
            );





        }
//        View flutterView = Flutter.createView();

//        setSupportActionBar(findViewById(R.id.toolbar))
//
//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}