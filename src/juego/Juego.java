package juego;

import java.awt.Color;

import java.awt.Font;
import java.util.Random;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Astromega miAstromega;
	private boolean perdido;
	private Proyectil disparo;
	private Ion ion;
	private Asteroide[] asteroides;
	private Destructor[] destructores;
	private int tiempo;
	private int vida;
	private int puntuacion;
	private int cantDestruidos;
	private fondo fondo;
	
	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo Mato, Palomeque y Sangueso- v1", 800, 600);

		//TODO: nuestros objetos y variables
		this.tiempo=0;
		perdido=false;
		this.miAstromega = new Astromega(400, 520, 60, 60, 4);
		this.disparo = null;
		this.ion = null;
		this.asteroides = new Asteroide[4];
		this.destructores = new Destructor[4];
		this.vida=1000;
		this.fondo = new fondo();
		Random rand= new Random();
		/*for (int i = 0; i < destructores.length; i++) {
			this.destructores[i] = new Destructor(rand.nextInt(this.entorno.ancho()-100),0,60,60,2);
		}*/
		crearAsteroides();
		crearDestructores();
		//this.musica= new PlayMusic();
		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		tiempo++;
		Random rand= new Random();
		
		
		// variable de tiempo
		//System.out.println(tiempo);
		if (!perdido && vida > 0) {
			this.fondo.dibujarse(this.entorno);
			this.entorno.cambiarFont(Font.MONOSPACED,20,Color.yellow);
			this.entorno.escribirTexto("Vidas: "+ this.vida, this.entorno.ancho()/2 - 50 ,this.entorno.alto()-10);
			this.entorno.escribirTexto("Puntaje: "+ this.puntuacion, this.entorno.ancho()/2 - 250,this.entorno.alto()-10);
			this.entorno.escribirTexto("Enemigos: "+ this.cantDestruidos, this.entorno.ancho()/2 + 100,this.entorno.alto()-10);

			/**************ASTROMEGA***************/
			this.miAstromega.dibujarse(this.entorno);
			if ((this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)|| this.entorno.estaPresionada(this.miAstromega.TECLA_D))
					&& this.miAstromega.getX() + this.miAstromega.getAncho() / 2 < this.entorno.ancho()) {
				this.miAstromega.moverDerecha();
			}

			if ((this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) ||  this.entorno.estaPresionada(this.miAstromega.TECLA_A))
					&& this.miAstromega.getX() - this.miAstromega.getAncho() / 2 > 0) {
				this.miAstromega.moverIzquierda();
			}

			// Hace que cuando toques la barra espaciadora, sale el proyectil
			if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO) && this.disparo == null) {
				this.disparo = this.miAstromega.disparar();
			}

			if (this.disparo != null) {
				this.disparo.dibujarse(this.entorno);
				this.disparo.disparoAstro();
				if (this.disparo.getY() < 0) {
					this.disparo = null;
				}
			}

			/**************ASTEROIDES***************/
			for (int i = 0; i < asteroides.length; i++) { // el For de los asteroides
				
				if (this.asteroides[i] != null ){
					this.asteroides[i].dibujarse(this.entorno);

					if (this.asteroides[i].salirDerecha(this.entorno))// los asteroides salen hacia la direccion derecha
						// si el x esta entre 0 y la mitad del ancho
					{
						this.asteroides[i].setAngulo(135);
					}

					if (this.asteroides[i].salirIzquierda(this.entorno))// los asteroides salen hacia la izquierda si el
						// x esta entre la mitad y el ancho total del													// entorno
					{
						this.asteroides[i].setAngulo(315);
					}

					this.asteroides[i].mover();

					if (this.asteroides[i].getY() >= this.entorno.alto())// si el Y de cada asteroide supera el alto
						// reaparece arriba
					{
						this.asteroides[i]=null;
						crearAsteroides();
					}

					if (this.asteroides[i].getX() >= this.entorno.ancho())// si el asteroide choca con el borde del
						// ancho se dirige hacia la izquierda
					{
						this.asteroides[i].setAngulo(315);
					}

					if (this.asteroides[i].getX() <= 0)// si el asteroide choca con el borde 0 del ancho se dirige hacia
						// la derecha
					{
						this.asteroides[i].setAngulo(135);
					}

					if(choqueAsteroideConAstro(asteroides[i], miAstromega)) {
						this.vida --;
						this.asteroides[i].respawn(this.entorno); //puse que haga respawn porque sino me daba errores si lo ponia en null
					}

					if (this.disparo != null && colisionDisparoAsteroide(this.asteroides[i], disparo)) {
						this.asteroides[i].setVida(this.asteroides[i].getVida()-1); //se le resta una vida al asteroide
						this.disparo= null;
					}

					if(this.asteroides[i].getVida() == 0){
						this.puntuacion += this.asteroides[i].getPuntuacion();
						this.cantDestruidos++;
						this.asteroides[i]= null;
						this.disparo = null;
					}
				}else {
					if(tiempo % 500 ==0){
						crearAsteroides();
					}
				}
			}

			/**************DESTRUCTOR***************/

			for (int i = 0 ; i < destructores.length;i++) {
				if (this.destructores[i] != null && tiempo >=800/2){ //los destructores salen mas tarde que los asteroides
					this.destructores[i].dibujarse(this.entorno);
					this.destructores[i].mover();
					
					//TODO: Se creo sectores para que los destructores esten en lugares predeterminados
					if (this.destructores[i].ubicarEn1(this.entorno)) {
						if(this.destructores[i].getX() <= 20) {
							this.destructores[i].setAngulo(45);
						}
						if (this.destructores[i].getX() >= 170) {
							this.destructores[i].setAngulo(315);
						}
					}

					if (this.destructores[i].ubicarEn2(this.entorno)) {
						if(this.destructores[i].getX() <= 220) {
							this.destructores[i].setAngulo(45);
						}
						if (this.destructores[i].getX() >= 370) {
							this.destructores[i].setAngulo(315);
						}
					}

					if (this.destructores[i].ubicarEn3(this.entorno)) {
						if(this.destructores[i].getX() <= 420) {
							this.destructores[i].setAngulo(45);
						}
						if (this.destructores[i].getX() >= 570) {
							this.destructores[i].setAngulo(315);
						}
					}

					if (this.destructores[i].ubicarEn4(this.entorno)) {
						if(this.destructores[i].getX() <= 620) {
							this.destructores[i].setAngulo(45);
						}
						if (this.destructores[i].getX() >= 770) {
							this.destructores[i].setAngulo(315);
						}
					}
					for(int j=0; j<asteroides.length;j++) {
						//NUEVO
						//si el destructor colisiona con el asteroide, este se va para arriba y lo "esquiva"
						if (this.asteroides[j]!= null && colisionAsteroideConDestructor(this.destructores[i],this.asteroides[j])) {
							this.destructores[i].setY(this.destructores[i].getY()-20);
						}
					}
					
					//NUEVO DISPARO IONES
					//se disparan los iones al mismo tiempo en que salen los destructores
					if(this.destructores[i] != null && tiempo>= 800/2) {
						if (this.ion == null) {
							this.ion = this.destructores[i].disparaion();
							
						}

						if (this.ion != null) {
							
							this.ion.dibujarse(this.entorno);
							this.ion.disparoDestruc();
							if ( colisionDisparoIonAstromega(this.miAstromega, this.ion)) {
								this.vida--;
								System.out.println(vida);
								this.ion= null;
								
							}

							if (this.ion!= null &&this.ion.getY() > this.entorno.alto()) {
								this.ion= null;
								
							}
							
						}
						
					}

					if (this.destructores[i].getY() >= this.entorno.alto()){
						
						this.destructores[i]= null;
						crearDestructores();
					}
					
				
					if(choqueDestructorConAstro(this.destructores[i], miAstromega)) {
						this.vida --;
						this.destructores[i].respawn(this.entorno);
					}

					if (this.disparo != null && colisionDisparoDestructor(this.destructores[i], disparo)) {
						this.puntuacion += this.destructores[i].getPuntuacion();
						this.cantDestruidos++;
						this.disparo = null;
						this.destructores[i] = null;
					}
				}else {
					if(tiempo % 500 == 0){
						crearDestructores();
					}
				}
				// NUEVO, si se alcanza la puntuacion establecida o si se destruyen todos los obstaculos y destructores
				// 		el juego se gana, se fuerza el perdido para que salga de las funciones asi no dibuja nada y solo
				//			aparece el cartel de que gano
				if(this.puntuacion >= 200 || (asteroidesNull()&& destructoresNull())) {
					perdido= true;
				}
				
			}
					
		}else{
			// cartel de que gano
			if(this.puntuacion>= 200  || (asteroidesNull()&& destructoresNull())) {
				this.entorno.cambiarFont(Font.SANS_SERIF,100,Color.green);
				this.entorno.escribirTexto("YOU WIN", this.entorno.ancho()/2 - 200,this.entorno.alto()/2);
				this.entorno.cambiarFont(Font.SANS_SERIF,50,Color.yellow);
				this.entorno.escribirTexto("Puntuacion: "+ this.puntuacion, this.entorno.ancho()/2 - 200, this.entorno.alto() - 100);
				this.entorno.escribirTexto("Enemigos: "+ this.cantDestruidos, this.entorno.ancho()/2 - 150, this.entorno.alto() - 50);
			}else {
			
			this.entorno.cambiarFont(Font.SANS_SERIF,100,Color.red);
			this.entorno.escribirTexto("GAME OVER", this.entorno.ancho()/2 - 300,this.entorno.alto()/2);
			this.entorno.cambiarFont(Font.SANS_SERIF,50,Color.yellow);
			this.entorno.escribirTexto("Puntuacion: "+ this.puntuacion, this.entorno.ancho()/2 - 200, this.entorno.alto() - 100);
			this.entorno.escribirTexto("Enemigos: "+ this.cantDestruidos, this.entorno.ancho()/2 - 150, this.entorno.alto() - 50);
		}
		}
		
		
		
	}// FIN DEL TICK
	/**************METODOS DEL JUEGO***************/
	private boolean asteroidesNull() {//comprueba si el arreglo de asteroides es todo null
		int contador=0;
		boolean salida= false;
		for (int i=0; i<asteroides.length;i++) {
			if(this.asteroides[i]==null) {
				contador++;
			}
		}
		if (contador== asteroides.length) {
			salida= true;
		}
		return salida;
	}
	
	private boolean destructoresNull() {// comprueba si el arreglo de destructores es todo null
		int contador=0;
		boolean salida= false;
		for (int i=0; i<destructores.length;i++) {
			if(this.asteroides[i]==null) {
				contador++;
			}
		}
		if (contador== destructores.length) {
			salida= true;
		}
		return salida;
	}
	
	private boolean colisionDisparoAsteroide(Asteroide asteroide, Proyectil disparo) {
		boolean superposY = asteroide.getY() > disparo.getY() - disparo.getAlto() / 2;
		boolean superposX = (disparo.getX() - disparo.getAncho() / 2 < asteroide.getX())
				&& (disparo.getX() + disparo.getAncho() / 2 > asteroide.getX());
		return superposY && superposX;
	}

	private boolean colisionDisparoIonAstromega(Astromega astromega, Ion ion) {
		boolean superposY = astromega.getY() > ion.getY() - ion.getAlto() / 2;
		boolean superposX = (ion.getX() - ion.getAncho() / 2 < astromega.getX())
				&& (ion.getX() + ion.getAncho() / 2 > astromega.getX());
		return superposY && superposX;
	}
	//detecta colision entre el ion del destructor y el astromega
	private boolean colisionDisparoDestructor(Destructor destructor, Proyectil disparo) {
		boolean superposY = destructor.getY() > disparo.getY() - disparo.getAlto() / 2;
		boolean superposX = (disparo.getX() - disparo.getAncho() / 2 < destructor.getX())
				&& (disparo.getX() + disparo.getAncho() / 2 > destructor.getX());
		return superposY && superposX;
	}

	private boolean choqueAsteroideConAstro(Asteroide asteroide, Astromega miAstromega) {
		boolean superposY = asteroide.getY() > miAstromega.getY() - miAstromega.getAlto() / 2;
		boolean superposX = (miAstromega.getX() - miAstromega.getAncho() / 2 < asteroide.getX())
				&& (miAstromega.getX() + miAstromega.getAncho() / 2 > asteroide.getX());
		return superposY && superposX;
	}

	private boolean choqueDestructorConAstro(Destructor destructor, Astromega miAstromega) {
		boolean superposY = destructor.getY() > miAstromega.getY() - miAstromega.getAlto() / 2;
		boolean superposX = (miAstromega.getX() - miAstromega.getAncho() / 2 < destructor.getX())
				&& (miAstromega.getX() + miAstromega.getAncho() / 2 > destructor.getX());
		return superposY && superposX;
	}


	private void crearAsteroides(){//sirve tanto para crear los 5 asteroides iniciales como para crear uno solo sin que se superpongan 
		Random rand = new Random();

		// Verifica si ya se generaron los 5 asteroides iniciales
		boolean asteroidesInicialesGenerados = true;
		for (int i = 0; i < asteroides.length; i++) {
			if (asteroides[i] == null) {
				asteroidesInicialesGenerados = false;
				break; //si encuentra un null, sale del for
			}
		}

		if (asteroidesInicialesGenerados) {
			int indice = -1;  // me indica que ningun valor es null en mi arreglo

			for (int i = 0; i < asteroides.length; i++) {
				if (asteroides[i] == null) {
					indice = i;
					break; //cuando encuentra un null, el indice vale i y se sale del for
				}
			}

			if (indice != -1) { //si indice tiene algun valor, busca las coordenadas adecuadas para crearse (que no se superponga)
				int asteroideX;
				int asteroideY = 100;
				boolean superposicion = false;
				int distanciaMinima = 100;

				do {
					asteroideX = rand.nextInt(entorno.ancho());
					superposicion = false;

					for (int j = 0; j < indice; j++) {
						if (asteroides[j] != null) {//se calcula la distancia entre dos puntos utilizando el teorema de pitagoras
							double distancia = Math.sqrt(Math.pow(asteroideX - asteroides[j].getX(), 2)
									+ Math.pow(asteroideY - asteroides[j].getY(), 2));

							if (distancia < distanciaMinima) {
								superposicion = true;
								break; //si la distancia es menor a la distancia minima establecida en un principio,se sale del for y pasa al while
							}
						}
					}
				} while (superposicion);

				asteroides[indice] = new Asteroide(asteroideX, asteroideY, 60, 50, 2);
				//con estas coordenadas generadas, me garantizo que el asteroide creado no se superponga con los demas
			}
		} else {
			// generar los 5 asteroides iniciales
			for (int i = 0; i < asteroides.length; i++) {
				if (asteroides[i] == null) {
					int newAsteroideX;
					int newAsteroideY = 100;
					boolean superpos = false;
					int distanciaMin = 100;

					do {
						newAsteroideX = rand.nextInt(entorno.ancho());
						superpos = false;

						for (int j = 0; j < i; j++) {
							if (asteroides[j] != null) {
								//teorema de pitagoras para calcular la distancia entre dos puntos
								double distancia = Math.sqrt(Math.pow(newAsteroideX - asteroides[j].getX(), 2)
										+ Math.pow(newAsteroideY - asteroides[j].getY(), 2));

								if (distancia < distanciaMin) {
									superpos = true;
									break; //sale del for cuando tiene las coordenadas adecuadas
								}
							}
						}
					} while (superpos);
					//va a crear cada asteroide con los valores obtenidos en newAsteroideX y newAsteroideY
					asteroides[i] = new Asteroide(newAsteroideX, newAsteroideY, 60, 50, 2);
				}
			}
		}
	}

	private void crearDestructores(){//sirve tanto para crear los 5 destructores iniciales como para crear uno solo sin que se superpongan 
		Random rand = new Random();

		// Verifica si ya se generaron los destructores iniciales
		boolean destructoresInicialesGenerados = true;
		for (int i = 0; i < destructores.length; i++) {
			if (destructores[i] == null) {
				destructoresInicialesGenerados = false;
				break; //si encuentra un null, sale del for
			}
		}

		if (destructoresInicialesGenerados) {
			int indice = -1;  // me indica que ningun valor es null en mi arreglo

			for (int i = 0; i < destructores.length; i++) {
				if (destructores[i] == null) {
					indice = i;
					break; //cuando encuentra un null, el indice vale i y se sale del for
				}
			}

			if (indice != -1) { //si indice tiene algun valor, busca las coordenadas adecuadas para crearse (que no se superponga)
				int destructorX;
				int destructorY = 100;
				boolean superposicion = false;
				int distanciaMinima = 160;

				do {
					destructorX = rand.nextInt(entorno.ancho());
					superposicion = false;

					for (int j = 0; j < indice; j++) {
						if (destructores[j] != null) {//se calcula la distancia entre dos puntos utilizando el teorema de pitagoras
							double distancia = Math.sqrt(Math.pow(destructorX - destructores[j].getX(), 2)
									+ Math.pow(destructorY - destructores[j].getY(), 2));

							if (distancia < distanciaMinima) {
								superposicion = true;
								break; //si la distancia es menor a la distancia minima establecida en un principio,se sale del for y pasa al while
							}
						}
					}
				} while (superposicion);

				destructores[indice] = new Destructor(destructorX, destructorY, 60, 50, 1);
				//con estas coordenadas generadas, me garantizo que el asteroide creado no se superponga con los demas
			}
		} else {
			// generar los destructores iniciales
			for (int i = 0; i < destructores.length; i++) {
				if (destructores[i] == null) {
					int newDestructorX;
					int newDestructorY = 100;
					boolean superpos = false;
					int distanciaMin = 160;

					do {
						newDestructorX = rand.nextInt(entorno.ancho());
						superpos = false;

						for (int j = 0; j < i; j++) {
							if (destructores[j] != null) {
								//teorema de pitagoras para calcular la distancia entre dos puntos
								double distancia = Math.sqrt(Math.pow(newDestructorX - destructores[j].getX(), 2)
										+ Math.pow(newDestructorY - destructores[j].getY(), 2));

								if (distancia < distanciaMin) {
									superpos = true;
									break; //sale del for cuando tiene las coordenadas adecuadas
								}
							}
						}
					} while (superpos);
					//va a crear cada destructor con los valores obtenidos en newDestructorX y newDestructorY
					destructores[i] = new Destructor(newDestructorX, newDestructorY, 60, 50, 1);
				}
			}
		}
	}

	
	// se reutiliza el bloque para calcular la distancia con pitagoras, si no se respeta la distancia minima da verdadero
	private boolean colisionAsteroideConDestructor(Destructor destructor, Asteroide asteroide) {
		boolean salida=false;
		int distanciaMinima=50;
		double distancia = Math.sqrt(Math.pow(destructor.getX()- asteroide.getX(), 2)
                    + Math.pow(destructor.getY() - asteroide.getY(), 2));
			if(distancia < distanciaMinima) {
				salida= true;
			}
		return salida;
	}
	
	private boolean colisionEntreDestructores(Destructor destructor1, Destructor destructor2) {
		boolean salida=false;
		int distanciaMinima=70;
		double distancia = Math.sqrt(Math.pow(destructor1.getX()- destructor2.getX(), 2)
                    + Math.pow(destructor1.getY() - destructor2.getY(), 2));
			if(distancia < distanciaMinima) {
				salida= true;
			}
		return salida;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
