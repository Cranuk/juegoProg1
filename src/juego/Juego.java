package juego;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// TODO: nuestros objetos para el juego
	private boolean perdido;
	private Astromega miAstromega;
	private Destructor miDestructor;
	private Asteroide miAsteroide;

	// Variables y métodos propios de cada grupo
	private boolean choqueNaves() {
		boolean superposicionY=this.miDestructor.getY() > this.miAstromega.getY()- this.miAstromega.getAlto()/2;
		boolean superposicionX=(this.miAstromega.getX() - this.miAstromega.getAncho()/2 < this.miDestructor.getX()) &&
				(this.miAstromega.getX()+this.miAstromega.getAncho()/2> this.miDestructor.getX());
		return superposicionY && superposicionX;
	}

	private boolean choqueNaveAsteroide() {
		boolean superposicionY=this.miAsteroide.getY()> this.miAstromega.getY()- this.miAstromega.getAlto()/2;
		boolean superposicionX=(this.miAstromega.getX()- this.miAstromega.getAncho()/2 < this.miAsteroide.getX()) &&
				(this.miAstromega.getX()+this.miAstromega.getAncho()/2> this.miAsteroide.getX());
		return superposicionY && superposicionX;
	}

	/****************************************************************************/
	/****************************************************************************/
	/****************************************************************************/
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Lost Galaxian - Version Mato-Sangueso-Palomeque", 800, 600);

		// Inicializar lo que haga falta para el juego
		Random rand=new Random(); // NOTE: valor random para la coordenada X de los objetos a posicionar en el entorno
		this.miAstromega = new Astromega(400, 550, 80, 40,4);
		this.miDestructor = new Destructor(rand.nextInt(this.entorno.ancho()-100),50,50,30,5);
		this.miAsteroide = new Asteroide(rand.nextInt(this.entorno.ancho()-100),50,50,2);
		//TODO: arrays de objetos

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		if (!perdido) {
			this.miAstromega.dibujarse(this.entorno);
			this.miDestructor.dibujarse(this.entorno);
			this.miDestructor.mover();
			this.miDestructor.cambiarADer();
			
			//TODO: Acciones de DESTRUCTOR
			if (this.miDestructor.getY() > this.entorno.alto() ) {
				this.miDestructor.respawn(this.entorno);
			}
			
			if (this.miDestructor.getX() - (this.miDestructor.getAncho()/2) <= 0) {
			    this.miDestructor.cambiarADer();
			}

			if (this.miDestructor.getX() - (this.miDestructor.getAncho()/2) >= this.entorno.ancho()) {
			    this.miDestructor.cambiarAIzq();
			}


			
			//TODO: Acciones de ASTROMEGA
			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)
					&& this.miAstromega.getX() + this.miAstromega.getAncho() / 2 < this.entorno.ancho()) {
					this.miAstromega.moverDerecha();
			}
			
			if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
				&& this.miAstromega.getX() - this.miAstromega.getAncho() / 2 > 0) {
				this.miAstromega.moverIzquierda();
			}
			
			//TODO: Colision con la nave(usuario) contra otros objetos(destructores y asteroides)
			if (choqueNaves() || choqueNaveAsteroide()) {
				this.perdido=true;
			}
		}
		else {
			this.entorno.cambiarFont(Font.SANS_SERIF,100,Color.RED);
			this.entorno.escribirTexto("Perdiste", this.entorno.ancho()/2,this.entorno.alto()/2 );
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
