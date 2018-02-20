package annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import assertion.DaCompletare;
import assertion.Test;

public class TestAnnotation {

	public static void main(String[] args) throws SecurityException, ClassNotFoundException, NoSuchMethodException {
		Map<String, String> map = new HashMap<>();
		
		Method[] methods = Class.forName("assertion.Test").getMethods();
		for(Method m : methods) {
			DaCompletare dc = null;
			if((dc = m.getAnnotation(DaCompletare.class)) != null) {
				String descrizione = dc.descrizione();
				String assegnataA = dc.assegnataA();
				map.put(descrizione, assegnataA);
			}
		}
		
		Set<String> keys = map.keySet();
		for(String key: keys) {
			System.out.printf("Descrizione = %s; Assegnata a : %s\n", key, map.get(key));
		}
		
		Test t = new Test();
		
		Method m = Class.forName("assertion.Test").getMethod("chiamami");
		DaCompletare dac = m.getAnnotation(DaCompletare.class);
		System.out.printf("\n\n\nDescrizione = %s; Assegnata a : %s", dac.descrizione(), dac.assegnataA());
		
	}
}