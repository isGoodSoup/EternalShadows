package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.util.Codex;

public class Capitulo1 extends Capitulo {

	public Capitulo1() {
		super("Capitulo I", "Los Ecos de Noxterra", 1);
		setLineas(lineas());
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader) {
		reader.readLine();
        mostrarLinea(reader);
        Codex util = new Codex();
        criatura = util.crearPersonaje(reader);
        return criatura;
	}

	@Override
	public String[] lineas() {
		return new String[] {
				"Capítulo I — Los Ecos de Noxterra",
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
				"Ante ti, un grabado antiguo tallado en piedra resplandece débilmente.",
				"Sus símbolos arcanos giran, formando tres figuras envueltas en sombras.",
				"Cada una extiende una mano, invitándote a elegir."
		};
	}
}
