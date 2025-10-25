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
			"Tú.",
			"Despiertas sobre tierra fría, húmeda, cubierta de ceniza.",
			"No recuerdas tu nombre, ni cómo llegaste aquí.",
			"Solo sientes el peso del aire, espeso como la culpa, y el murmullo de algo lejano que te llama,",
			"como si tu alma misma estuviera siendo arrastrada hacia un destino inevitable.",
			"Ante ti, un grabado antiguo tallado en piedra resplandece débilmente.",
			"Sus símbolos arcanos giran, formando tres figuras envueltas en sombras.",
			"Cada una extiende una mano, invitándote a elegir.",
		};
	}
}
