import java.util.ArrayList;


public class SaveStateObject<Type> {
	
	Type val;
	ArrayList<Type> oldVals = new ArrayList<Type>();
	
	public SaveStateObject(Type val) {
		setVal(val);
	}

	public Type getVal() {
		return val;
	}

	public void setVal(Type val) {
		this.val = val;
	}
	
	public void saveVal() {
		oldVals.add(val);
	}
	
	public void setToOldVal(int saveIndex) {
		val =  oldVals.get(saveIndex);
	}
	
	public String toString() {
		return val.toString();
	}
	
	public boolean equals(Object val2) {
		try {
			if(getVal().equals(((SaveStateObject<Type>) val2).getVal()))
				return true;
			else
				return false;
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
