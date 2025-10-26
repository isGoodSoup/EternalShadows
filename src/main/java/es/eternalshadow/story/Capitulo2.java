package es.eternalshadow.story;

import org.jline.reader.LineReader;

import es.eternalshadow.entity.Criatura;

public class Capitulo2 extends Capitulo {

	public Capitulo2() {
		super("Capitulo II", "El Sendero de los Condenados", 1);
		setLineas(lineas());
	}

	@Override
	public Criatura ejecutar(Criatura criatura, LineReader reader) {
		mostrarLinea(reader);
		return criatura;
	}

	@Override
	public String[] lineas() {
		return new String[] {
				"Capítulo II — El Sendero de los Condenados",
				"Tu elección fue servida, tu destino será el que hayas formado.",
				"La sombra misteriosa se desplaza, dejándote paso a un mundo de horrores que no ",
				"dejan descanso a las penurias de una sociedad ya caída.",
				"El suelo cruje bajo tus pies mientras avanzas por un sendero estrecho,", 
				"rodeado de árboles retorcidos que parecen susurrar tus secretos más íntimos.",
				"El aire es pesado, cargado con el aroma de ceniza y recuerdos olvidados.",
				"A lo lejos, un destello rojo ilumina la niebla: ¿una señal de vida… o una trampa mortal?",
				"Tu instinto te empuja hacia adelante, pero cada paso que das parece multiplicar los susurros",
				"convirtiéndose en lamentos que atraviesan tu mente.",
				"No hay caminos seguros aquí. Cada bifurcación parece igual, cada sombra parece observarte.",
				"Pero solo tú, puedes encontrar tu camino...",
				"Y, sin embargo, algo dentro de ti —una chispa de memoria,",
				"un vestigio de tu humanidad— te obliga a continuar.",
				"De pronto, sientes un roce gélido en tu hombro.",
		};
	}
}
