package data_structures;

import java.util.ArrayList;
import java.util.HashMap;

public class StringBufferOfMine {
	ArrayList<String> stringBuffer;
	HashMap<Integer, String> stringBufferHashMap;
	Boolean isHash;
	int counter;

	StringBufferOfMine() {
		stringBuffer = new ArrayList<String>();
		isHash = false;
		counter = 0;
	}

	StringBufferOfMine(Boolean isHashMap) {
		isHash = true;
		if (isHash)
			stringBufferHashMap = new HashMap<Integer, String>();
	}

	public void append(String entry) {
		if (!isHash)
			stringBuffer.add(entry);
		else {
			stringBufferHashMap.put(counter++, entry);
		}
	}

	public String get(int index) {
		if (!isHash)
			return stringBuffer.get(index);
		else
			return stringBufferHashMap.get(index);
	}

}
