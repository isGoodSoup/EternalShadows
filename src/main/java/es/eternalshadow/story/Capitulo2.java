package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.entity.Criatura;
import es.eternalshadow.enums.Ruta;
import es.eternalshadow.util.Codex;

public class Capitulo2 extends Capitulo {

	public Capitulo2() {
		super("Capitulo II", "El Sendero de los Condenados", 1);
		setLineas(lineas());
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader) {
		reader.readLine();
		mostrarLinea(reader);
		String[] menu = {"El pueblo abandonado", "La cueva oscura", "El templo"};
		Codex util = new Codex();
		int opcion = util.crearMenu(reader, menu, "Elige tu camino");
		do {
			switch(opcion) {
				case 1 -> { setRuta(Ruta.ALFA); leerDestino(reader, lineas1()); }
				case 2 -> { setRuta(Ruta.BETA); leerDestino(reader, lineas2()); }
				case 3 -> { setRuta(Ruta.OMEGA); leerDestino(reader, lineas3()); }
			}
		} while(opcion > 3);
		return criatura;
	}
	
	@Override
	public String[] lineas() {
		return new String[] {
				"Capítulo II — El Sendero de los Condenados",
				"Tu elección fue servida, tu destino será el que hayas formado.",
				"La sombra misteriosa se desplaza, dejándote paso a un mundo de horrores que no",
				"dejan descanso a las penurias de una sociedad ya caída.",
				"El suelo cruje bajo tus pies mientras avanzas por un sendero estrecho,", 
				"rodeado de árboles retorcidos que parecen susurrar tus secretos más íntimos.",
				"A tus pies el sendero se abre en tres caminos, cada uno a un destino diferente:",
				"un pueblo abandonado, una cueva oscura y un templo de un monje sin rostro.",
		};
	}
	
	private String[] lineas1() {
		return new String[] {
			"Las ruinas del pueblo se alzan como un recuerdo podrido del pasado.",
			"Las puertas cuelgan de sus bisagras, y el viento arrastra murmullos de quienes nunca se fueron.",
			"Caminas entre casas medio derruidas, algunas aún conservan rastros de vida:",
			"un juguete roto, un cuenco con ceniza seca.",
			"El silencio pesa. Algo se mueve detrás de una ventana sin cristal.",
			"Cuando empujas la puerta, el aire cambia.",
			"Dentro, un espejo cubierto de polvo refleja una figura que no está en la habitación.",
			"Te observas a ti mismo, pero con ojos que no reconoces.",
		};
	}
	
	private String[] lineas2() {
		return new String[] {
			"La boca de la cueva respira frío.",
			"Cada paso hacia dentro apaga el mundo exterior,",
			"y la oscuridad parece observarte desde dentro de sí misma.",
			"El suelo está húmedo, resbaladizo; las paredes laten con una humedad que parece viva.",
			"Un murmullo lejano se confunde con el eco de tu respiración.",
			"De pronto, una luz débil titila al fondo.",
			"No hay antorcha, solo una piedra que emite un resplandor verdoso, pulsando como un corazón.",
			"Al tocarla, escuchas una voz dentro de tu cabeza. No habla, recuerda.",
		};
	}
	
	private String[] lineas3() {
		return new String[] {
			"El templo emerge entre la niebla, inmóvil, ajeno al tiempo.",
			"En su entrada, estatuas sin rostro se inclinan, como si reconocieran tu llegada.",
			"La puerta se abre sola, y el aire huele a incienso y óxido.",
			"Las paredes están cubiertas de inscripciones que se reescriben ante tus ojos.",
			"Un altar se levanta en el centro, y sobre él, una máscara sin rasgos.",
			"La tocas, y el mundo se detiene.",
			"Una presencia antigua habla desde dentro de ti: ‘Toda fe nace del miedo. ¿Qué temes perder?'",
		};
	}
}
