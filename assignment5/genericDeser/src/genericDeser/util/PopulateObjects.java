package genericDeser.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import genericDeser.fileOperations.FileProcessor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class PopulateObjects {
	private FileProcessor inputFile;
	private Map<String, Class> typeMap;
	private int totalObjects;

	public PopulateObjects() {
		typeMap = new HashMap<>();
		typeMap.put("int", int.class);
		typeMap.put("double", double.class);
		typeMap.put("string", String.class);
		typeMap.put("short", short.class);
		typeMap.put("float", float.class);
	}

	private void deserializeObject(List<String> serializedFormat) throws ClassNotFoundException {
		if (serializedFormat == null || serializedFormat.size() < 1)
			return;

		String className = serializedFormat.get(0);
		className = className.substring(className.indexOf(":") + 1);
		Class cls = Class.forName(className);
		Class[] signature = new Class[1];
		for (int i = 1; i < serializedFormat.size(); i++) {

		}

		// signature[0] = Integer.TYPE; // generalize
		// String methdName = "set" + "IntValue"; // generalize
		// Method meth = cls.getMethod(methodName, signature);
		// Object obj = cls.newInstance();
		// Object[] params = new Object[1];
		// params[0] = new Integer(17); // generalize
		// Object result = meth.invoke(obj, params);

	}

	public void deserObjects(FileProcessor inputFile_in) {
		inputFile = inputFile_in;
		List<String> serializedFormat = null;
		String inputString = null;
		try {
			inputString = inputFile.getLine();
			while (inputString != null) {
				if (inputString.contains("fqn")) {
					// the previous object
					deserializeObject(serializedFormat);
					serializedFormat = new ArrayList<>(10);
					serializedFormat.add(inputString);
				} else {
					serializedFormat.add(inputString);
				}
				inputString = inputFile.getLine();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("TOtal objects: " + totalObjects);
	}

	public int uniqueNumOfFirstObjects() {
		return 0;
	}

	public int totalNumOfFirstObjects() {
		return 0;
	}

	public int uniqueNumOfSecondObjects() {
		return 0;
	}

	public int totalNumOfSecondObjects() {
		return 0;
	}

	public int totalNumOfObjects() {
		return 0;
	}
}
