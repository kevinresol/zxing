package org.haxe.extension;


import android.app.Activity;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.util.Log;

import org.haxe.lime.HaxeObject;
import org.json.JSONObject;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


/* 
	You can use the Android Extension class in order to hook
	into the Android activity lifecycle. This is not required
	for standard Java code, this is designed for when you need
	deeper integration.
	
	You can access additional references from the Extension class,
	depending on your needs:
	
	- Extension.assetManager (android.content.res.AssetManager)
	- Extension.callbackHandler (android.os.Handler)
	- Extension.mainActivity (android.app.Activity)
	- Extension.mainContext (android.content.Context)
	- Extension.mainView (android.view.View)
	
	You can also make references to static or instance methods
	and properties on Java classes. These classes can be included 
	as single files using <java path="to/File.java" /> within your
	project, or use the full Android Library Project format (such
	as this example) in order to include your own AndroidManifest
	data, additional dependencies, etc.
	
	These are also optional, though this example shows a static
	function for performing a single task, like returning a value
	back to Haxe from Java.
*/
public class Zxing extends Extension {
	
	protected static final String EVENT_SUCCESS = "success";
	protected static final String EVENT_CANCELLED = "cancelled";
	protected static HaxeObject handler; // String->String->String->Void (type, contents, formatName)
	
	public static void init(HaxeObject handler) {
		Zxing.handler = handler;
	}

	public static void initiateScan () {
		Extension.mainActivity.runOnUiThread(new Runnable() {
			public void run() {
				IntentIntegrator integrator = new IntentIntegrator(Extension.mainActivity);
				integrator.addExtra("SCAN_WIDTH", 500);
		      	integrator.addExtra("SCAN_HEIGHT", 800);
		      	//integrator.addExtra("RESULT_DISPLAY_DURATION_MS", 3000L);
		      	integrator.addExtra("PROMPT_MESSAGE", "Custom prompt to scan a product");
		      	integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);
			}
		});
	}
	
	
	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
	public boolean onActivityResult (int requestCode, int resultCode, Intent intent) {
		
		IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanResult != null) {
		    if(handler != null)
		    {
		    	if(scanResult.getContents() != null)
		    		handler.call3("handle", EVENT_SUCCESS, scanResult.getContents(), scanResult.getFormatName());
		    	else
		    		handler.call3("handle", EVENT_CANCELLED, "", "");
		    }
		    
		}
		else {

		}
		return true;
		
	}
	
	
	/**
	 * Called when the activity is starting.
	 */
	public void onCreate (Bundle savedInstanceState) {
		
		
		
	}
	
	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	public void onDestroy () {
		
		
		
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	public void onPause () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	public void onRestart () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	public void onResume () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	public void onStart () {
		
		
		
	}
	
	
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	public void onStop () {
		
		
		
	}
	
	
}