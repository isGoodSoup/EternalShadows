package es.eternalshadow.util;

import java.util.Scanner;

public class Utilidades {
	private static Scanner scan = new Scanner(System.in);
	
	public int toScanInteger(String s) {
		System.out.println(s);
		return scan.nextInt();
	}
	
	public String toScan() {
		return scan.nextLine();
	}
	
	public String toScan(String s) {
		System.out.println(s);
		return scan.nextLine();
	}
	
	public void toGetString(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.print(" " + s + " ");
		
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public int crearMenu(String[] menu, String s) {
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + 1 + ") " + menu[i]);
		}
		int num = toScanInteger(s);
		return num;
	}
	
	public void print(String s) {
		System.out.println(s);
	}
	
	public String[] lineas() {
		return new String[] {
			"Cuando la última luz se extinga, los nombres de los vivos serán olvidados…",
			"Solo quedará la sombra eterna.",
			"El viento gime sobre las ruinas.",
			"El cielo, teñido de un gris enfermizo, apenas deja pasar los últimos resplandores de un sol moribundo.",
			"Noxterra ha sido llamada muchas cosas a lo largo de los siglos:",
			"cuna de héroes, tumba de dioses, prisión de los condenados.",
			"Ahora no es más que un suspiro al borde del olvido.",
			"Los pueblos han caído uno tras otro, devorados por el silencio.",
			"Las ciudades ya no tienen nombres, solo ecos que murmuran en lenguas muertas.",
			"Y entre esas ruinas… algo se mueve.",
			"Tú."
		};
	}
}
