package es.eternalshadow.pojos;
import java.util.Random;

public class Dado21 {
    private Random random;
     
    public Dado21() {
        random = new Random();
    }
    
    public int lanzar() {
        return random.nextInt(21) + 1;
    }
    
  public static int Dado21() {
        Dado21 miDado = new Dado21();
        
        // Lanzar el dado varias veces
        for (int i = 0; i < 5; i++) {
            int resultado = miDado.lanzar();
            System.out.println("Lanzamiento " + (i + 1) + ": " + resultado);
        
		return resultado  ;
    }
		return 0;
    }
}
