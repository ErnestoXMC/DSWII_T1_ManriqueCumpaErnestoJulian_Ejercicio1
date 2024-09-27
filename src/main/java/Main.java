
public class Main {

	public static void main(String[] args) throws InterruptedException {
        //Creamos los 3 arreglos
        int[] glucosa1 = new int[10];
        int[] glucosa2 = new int[10];
        int[] glucosa3 = new int[10];

        //Instanciamos los hilos
        GlucosaThread hilo1 = new GlucosaThread(glucosa1, "1er Hilo");
        GlucosaThread hilo2 = new GlucosaThread(glucosa2, "2do Hilo");
        GlucosaThread hilo3 = new GlucosaThread(glucosa3, "3er Hilo");

        //Iniciamos los hilos
        Thread t1 = new Thread(hilo1);
        Thread t2 = new Thread(hilo2);
        Thread t3 = new Thread(hilo3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        //Juntamos los hilos
        int[] resultados = new int[30];
        System.arraycopy(glucosa1, 0, resultados, 0, 10);
        System.arraycopy(glucosa2, 0, resultados, 10, 10);
        System.arraycopy(glucosa3, 0, resultados, 20, 10);


        int normal = 0, prediabetes = 0, diabetes = 0;
        
        for (int nivel : resultados) {
            int clasificacion = Glucosa.clasificarGlucosa(nivel);
            
            if(clasificacion == 0){
            	normal++;
            }else if(clasificacion == 1){
            	prediabetes++;
            }else{
            	diabetes++;
            }
        }

        //Calculo de los porcentajes
        int total = resultados.length;
        double porcentajeNor = (normal * 100.0) / total;
        double porcentajePre = (prediabetes * 100.0) / total;
        double porcentajeDia = (diabetes * 100.0) / total;

        //Salida de resultados
        System.out.println("Clasificación de los resultados:");
        System.out.print(String.format("Normal: %.1f%%\n", porcentajeNor));
        System.out.print(String.format("Prediabetes: %.1f%%\n", porcentajePre));
        System.out.print(String.format("Diabetes: %.1f%%\n", porcentajeDia));
    }
}
