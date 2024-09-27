
public class Glucosa {
	
	 public static int clasificarGlucosa(int nivel) {
	        if (nivel <= 99) {
	            return 0; // Persona Normal
	        } else if (nivel <= 125) {
	            return 1; // Persona con Prediabetes
	        } else {
	            return 2; // Persona con Diabetes
	        }
	    }

}
