package genericDeser.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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
	private Map<String, Class<?>> typeMap;
	private Map<Class<?>, Class<?>> boxedType;
	private int totalObjects;
	private Map<First, Integer> mapFirst;
	private Map<Second, Integer> mapSecond;
	public PopulateObjects() {
		typeMap = new HashMap<>();
		typeMap.put("int", Integer.TYPE);
		typeMap.put("double", Double.TYPE);
		typeMap.put("String", String.class);
		typeMap.put("short", Short.TYPE);
		typeMap.put("float", Float.TYPE);
		typeMap.put("boolean", Boolean.TYPE);
		
		boxedType = new HashMap<>();
		boxedType.put(Integer.TYPE, Integer.class);
		boxedType.put(Double.TYPE, Double.class);
		boxedType.put(Short.TYPE, Short.class);
		boxedType.put(Float.TYPE, Float.class);
		boxedType.put(Boolean.TYPE, Boolean.class);
		
		mapFirst = new HashMap<>();
		mapSecond = new HashMap<>();
	}

	private void deserializeObject(List<String> serializedFormat) throws Exception {
		if (serializedFormat == null || serializedFormat.size() < 1)
			return;

		String type,var,value,methodName;
		Method method;
		Class<?> class2;
		Object params1 = null;
		String line = serializedFormat.get(0);
		String className = line.substring(line.indexOf(":") + 1);
		Class<?> cls = Class.forName(className);
		
		Class<?>[] signature = new Class[1];
		
		Object obj = cls.newInstance();
		
		for (int i = 1; i < serializedFormat.size(); i++) {
			line = serializedFormat.get(i);
			type = line.substring(line.indexOf("=")+1,line.indexOf(","));
			value = line.substring(line.lastIndexOf("=")+1);
			line = line.substring(line.indexOf("var"));
			var = line.substring(line.indexOf("=")+1,line.indexOf(","));
			//System.out.println("typ:\n" + type +"\nvar"+var+"  valu:"+value);
			
			signature[0] = typeMap.get(type);
			methodName = "set"+var;
			method = cls.getMethod(methodName, signature);
			
			//Object params1 = java.lang.reflect.Array.newInstance(typeMap.get(type), 1);
			//Object params1 = .newInstance(typeMap.get(type), 1);
			class2 = typeMap.get(type);
			if(boxedType.containsKey(class2)){
				class2 = boxedType.get(class2);
				Constructor<?> cons = class2.getConstructor(String.class);	
				params1 = cons.newInstance(value);
			}else{
				//string
				params1 = value;
			}
			method.invoke(obj, params1);
		}
		if(obj instanceof First){
			if(mapFirst.containsKey(obj)){
				System.out.println("matched");
				mapFirst.put((First) obj,mapFirst.get(obj)+1);
			}
			else{
				mapFirst.put((First) obj, 1);
			}
		}
		else if (obj instanceof Second){
			if(mapSecond.containsKey(obj)){
				System.out.println("matched");
				mapSecond.put((Second)obj, mapSecond.get(obj)+1);
			}
			else{
				mapSecond.put((Second)obj, 1);
			}
		}
		else{
			System.out.println("fucked up");
			System.exit(1);
		}
		
		//System.out.println(obj);
		totalObjects++;
		//System.exit(0);
		//signature[0] = Integer.TYPE; // generalize
		//String methodName = "set" + "IntValue"; // generalize
		//Method meth = cls.getMethod(methodName, signature);
		//Object obj = cls.newInstance();
		//Object[] params = new Integer[17];
		//params[0] = new Integer(17); // generalize
		//Object result = meth.invoke(obj, params);

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
			deserializeObject(serializedFormat);
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
		return mapFirst.size();
	}

	public int totalNumOfFirstObjects() {
		int total = 0;
		for(Integer i: mapFirst.values())
			total+=i;
		return total;
	}

	public int uniqueNumOfSecondObjects() {
		return mapSecond.size();
	}

	public int totalNumOfSecondObjects() {
		int total = 0;
		for(Integer i: mapSecond.values())
			total+=i;
		return total;
	}

	public int totalNumOfObjects() {
		return totalObjects;
	}
}
