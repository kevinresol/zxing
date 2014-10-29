package;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#end

#if (android && openfl)
import openfl.events.Event;
import openfl.events.EventDispatcher;
import openfl.utils.JNI;
#end


class Zxing extends EventDispatcher {
	
	public function new()
	{
		super();
		zxing_init({handle:handle});
	}
	
	public function initiateScan():Void 
	{
		
		#if (android && openfl)
		
		zxing_initiate_scan();
		
		#else
		
		//return zxing_sample_method(inputValue);
		
		#end
		
	}

	private function handle(type:String, contents:String, formatName:String):Void
	{
		dispatchEvent(new ScanEvent(type, contents, formatName));
	}
	
	
	//private static var zxing_sample_method = Lib.load ("zxing", "zxing_sample_method", 1);
	
	#if (android && openfl)
	private static var zxing_initiate_scan = JNI.createStaticMethod ("org.haxe.extension.Zxing", "initiateScan", "()V");
	private static var zxing_init = JNI.createStaticMethod ("org.haxe.extension.Zxing", "init", "(Lorg/haxe/lime/HaxeObject;)V");
	#end
	
	
}
