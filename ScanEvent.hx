
package ;

import openfl.events.Event;

class ScanEvent extends Event
{
	public static var SUCCESS:String = "success";
	public static var CANCELLED:String = "cancelled";

	public var contents:String;
	public var formatName:String;

	public function new(type:String, contents:String, formatName:String, bubbles:Bool = false, cancelable:Bool = false) 
	{
		super(type, bubbles, cancelable);
		this.contents = contents;
		this.formatName = formatName;	
	}
	
	
	override public function clone():ScanEvent 
	{
		var event = new ScanEvent(type, contents, formatName, bubbles, cancelable);
		//event.eventPhase = eventPhase;
		event.target = target;
		event.currentTarget = currentTarget;
		return event;
	}
}