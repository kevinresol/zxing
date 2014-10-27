package;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#end

#if (android && openfl)
import openfl.utils.JNI;
#end


class Zxing {
	
	
	public static function sampleMethod (inputValue:Int):Int {
		
		#if (android && openfl)
		
		var resultJNI = zxing_sample_method_jni(inputValue);
		var resultNative = zxing_sample_method(inputValue);
		
		if (resultJNI != resultNative) {
			
			throw "Fuzzy math!";
			
		}
		
		return resultNative;
		
		#else
		
		return zxing_sample_method(inputValue);
		
		#end
		
	}
	
	
	private static var zxing_sample_method = Lib.load ("zxing", "zxing_sample_method", 1);
	
	#if (android && openfl)
	private static var zxing_sample_method_jni = JNI.createStaticMethod ("org.haxe.extension.Zxing", "sampleMethod", "(I)I");
	#end
	
	
}