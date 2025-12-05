package es.eternalshadow.story;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jline.reader.LineReader;

import es.eternalshadow.main.Panel;
import es.eternalshadow.motor.Combate;
import es.eternalshadow.motor.Escena;
import es.eternalshadow.motor.MotorHistoria;
import es.eternalshadow.motor.Opcion;
import es.eternalshadow.pojos.Criatura;
import es.eternalshadow.util.Codex;

public class HistoriaPrincipal extends Historia {
	private Panel panel;
	private Codex util = new Codex(panel);
	
	public HistoriaPrincipal(String titulo, Panel panel) {
	    super(titulo);
	    this.panel = panel;
	}

	@Override
	public Criatura iniciar(Criatura criatura, LineReader reader, Codex util) {
		for (Capitulo capitulo : getCapitulos()) {
			List<String> lineas = new ArrayList<>();
			try {
				lineas = util.toLeerArchivo("./docs/mq/capitulo" + capitulo.getNumero() + ".txt");
			} catch (IOException e) {
				Codex.printException(e);
			}
			for(String linea : lineas) {
				System.out.println(linea);
				reader.readLine();
			}
		}
		util.tirarDados();
		return criatura;
	}
	
	public Capitulo nuevoCapitulo(String titulo, int numero) {
		Capitulo c = new Capitulo(titulo, numero, panel);
		getCapitulos().add(c);
		return c;
	}
	
// 	(TODO) Esto hay que cambiarlo
	public MotorHistoria crearHistoria(Usuario user, Criatura lobo) {
        Map<String, Escena> mapa = new HashMap<>();
        // ESCENA 1
        mapa.put(" El Consejo del Alba ha convocado a sus elegidos", new Escena(
        		" **EL DESPERTAR DEL ELEGIDO**\n\n" +
        		        "El alba desgarra la noche con sus dedos luminosos, filtrándose por la rendija \\n\" +\r\n"
        		        + "\"como un susurro dorado que te arranca del sueño con la urgencia de un presentimiento.\\n\" +\r\n"
        		        + "\"Despiertas con el corazón encogido, sabiendo que este amanecer trae \\n\" +\r\n"
        		        + "\"un eco diferente grabado en su luz.\"Los primeros rayos del sol se filtran por la rendija de tu ventana mientras despiertas con un sobresalto.\n" +
        		        "\"El aire de Varyon carga hoy con un peso desconocido. Los pájaros han enmudecido \\n\" +\r\n"
        		        + "\"y las flores, marchitas antes de tiempo, inclinan sus pétalos como en un lento y silencioso lamento.\"" +
        		        "Recuerdas el sueño: una voz ancestral te llamaba desde las ruinas del Templo del Alba.\n" +
        		        "En tu mesita de noche, encuentras una carta sellada con el emblema del Consejo del Alba.",
        		        List.of(
        		        	    new Opcion("🔍 Examinar la carta con detenimiento", "carta_detalle", 
        		        	              () -> { 
        		        	                  System.out.println("\nEncuentras un mensaje oculto entre líneas..."); 
        		        	                  user.addPocion(new Pocion(25));
        		        	              }),
        		        	    
        		        	    new Opcion("🚪 Salir rápidamente hacia la aldea", "aldea", null),
        		        	    
        		        	    new Opcion("🏠 Buscar más pistas en la habitación", "busqueda_habitacion", 
        		        	              () -> {
        		        	                  System.out.println("\nEncuentras un diario antiguo bajo la cama...");
        		        	                  user.aumentarMoral(3);
        		        	              }),
        		        	    
        		        	    new Opcion("⏳ Esperar y observar desde la ventana", "observar_ventana",
        		        	              () -> {
        		        	                  System.out.println("\nVes sombras moviéndose inusualemente en el pueblo...");
        		        	                  user.addArtefacto("Lente de Claridad");
        		        	              }),
        		        	    
        		        	    new Opcion("📖 Rezar a los antiguos dioses", "oracion", 
        		        	              () -> {
        		        	                  System.out.println("\nSientes una calma momentánea...");
        		        	                  user.aumentarMoral(5);
        		        	              })
        		        	)
        ));
     // ESCENA 2 - EL MERCADO Y EL MERCADER GARANTIZADO
        mapa.put("mercado", new Escena(
            "🏮 **EL MERCADO DE LOS SUSURROS**\n\n" +
            "El mercado bulle con una energía nerviosa. Comerciantes de rostros sombríos \n" +
            "venden artefactos que parecen contener ecos del pasado. Entre el gentío, \n" +
            "reconoces inmediatamente al Mercader Garantizado - un hombre anciano cuya \n" +
            "tienda emite un tenue resplandor azul.\n\n" +
            "'Sé que buscas respuestas,' dice con una sonrisa que no llega a sus ojos. \n" +
            "'Tengo tres objetos que podrían interesarte. Pero el precio... el precio \n" +
            "siempre es una tirada del destino.'\n\n" +
            "Extiende tres objetos sobre su mostrador:",
            List.of(
                new Opcion("🔮 [D21] Comprar la Brújula de los Ecos (15+ oro)", "comprar_brujula", 
                          () -> comprarObjetoMercader(user, "Brújula de los Ecos", 15)),
                
                new Opcion("⚔️ ["
                		+ "D21] Comprar la Daga de Luna Plateada (12+ oro)", "comprar_daga", 
                          () -> comprarObjetoMercader(user, "Daga de Luna Plateada", 12)),
                
                new Opcion("🛡️ [D21] Comprar el Manto de Sombras (18+ oro)", "comprar_manto", 
                          () -> comprarObjetoMercader(user, "Manto de Sombras", 18)),
                
                new Opcion("💬 Regatear los precios primero", "regatear", 
                          () -> {
                              System.out.println("\nEl mercader sonríe: 'El destino no se regatea, solo se acepta.'");
                              user.aumentarMoral(2);
                          }),
                
                new Opcion("🚶‍♂️ Rechazar y explorar otros puestos", "otros_puestos", null)
            )
        ));
        mapa.put("regatear", new Escena(
        	    "🤝 **EL ARTE DEL REGATEO**\n\n" +
        	    "El Mercader Garantizado arquea una ceja: 'Intentas negociar con el destino? \n" +
        	    "Interesante... Te daré una oportunidad. Responde mi acertijo y \n" +
        	    "tal vez considere ajustar mis precios.'\n\n" +
        	    "'Camino sin piernas, hablo sin boca, \n" +
        	    "doy la hora sin ser reloj. ¿Qué soy?'",
        	    List.of(
        	        new Opcion("💧 Un río", "acertijo_correcto", 
        	                  () -> {
        	                      System.out.println("\n'¡Correcto! Tu sabiduría merece recompensa.'");
        	                      System.out.println("Todos los precios se reducen 5 de oro permanentemente.");
        	                      // Aquí podriamos agregar un modificador de precios
        	                  }),
        	        
        	        new Opcion("🌪️ El viento", "acertijo_incorrecto", null),
        	        
        	        new Opcion("⏳ El tiempo", "acertijo_incorrecto", null),
        	        
        	        new Opcion("🔙 Volver a los objetos", "mercado", null)
        	    )
        	));
        // ESCENA DE COMBATE
        mapa.put("combateLobo", new Escena(
            "¡Un lobo salvaje aparece!",
            List.of(
                new Opcion("Luchar", "postCombate", () -> Combate.luchar(user, lobo))
            )
        ));
        // ESCENA POST COMBATE
        mapa.put("postCombate", new Escena  (
            "Has sobrevivido. El camino continúa.",
            List.of(
                new Opcion("Fin del capítulo", null, null)
            )
        ));
        return new MotorHistoria(mapa, "inicio");
    }
}
