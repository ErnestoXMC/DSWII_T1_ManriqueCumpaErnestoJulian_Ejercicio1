import java.util.Arrays;
import java.util.Random;

public class GlucosaThread implements Runnable{
	private int[] glucosa;
    private String nombreH;

    public GlucosaThread(int[] glucosa, String nombreHilo) {
        this.glucosa = glucosa;
        this.nombreH = nombreHilo;
    }

    @Override
    public void run() {
    	
        Random random = new Random();
        // Generamos valores aleatorios
        for (int i = 0; i < glucosa.length; i++) {
            glucosa[i] = 70 + random.nextInt(100);
        }
        
        System.out.println(nombreH + " - niveles de glucosa: " + Arrays.toString(glucosa));
    }
}
