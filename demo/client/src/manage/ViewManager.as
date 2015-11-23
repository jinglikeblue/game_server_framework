package manage
{
	import flash.utils.Dictionary;
	
	import mx.core.IVisualElement;
	import mx.core.IVisualElementContainer;
	import mx.core.UIComponent;

	public class ViewManager
	{
		public function ViewManager()
		{
		}
		
		static public var root:IVisualElementContainer;
		
		static public function init(parent:IVisualElementContainer):void
		{
			root = parent;
		}
		
		static private var _views:Dictionary = new Dictionary();
		
		static public function showView(key:String, view:IVisualElement):void
		{
			root.addElement(view);
			_views[key] = view;			
		}
		
		static public function getView(key:String):IVisualElement
		{
			return _views[key];
		}
		
		static public function removeView(key:String):void
		{
			var view:IVisualElement = getView(key);
			if(null != view)
			{
				root.removeElement(view);
			}
		}
	}
}