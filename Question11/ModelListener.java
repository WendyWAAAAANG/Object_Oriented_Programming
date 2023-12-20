
public interface ModelListener {

	//this interface will be implemented by views
	//and the model will use this interface to notify the views
	//that they need to update themselves.
	public abstract void update();
}
