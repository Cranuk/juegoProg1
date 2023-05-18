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
	private Astromega miAstromega;
	private Destructor[] destructores;
	private Asteroide miAsteroide;
	private boolean perdido;
	private Proyectil disparo;
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		Random rand=new Random();
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		this.disparo= null;
		this.miAstromega= new Astromega(400, 550, 150, 40,5);
		
		this.destructores=new Destructor[4];
		this.destructores[0]= new Destructor(rand.nextInt(800),130,100,30,2);
		this.destructores[1]= new Destructor(rand.nextInt(710),60,100,30,2);
		this.destructores[2]= new Destructor(rand.nextInt(730),160,100,35,2);
		this.destructores[3]= new Destructor(rand.nextInt(600),140,100,45,2);
		
		
		this.miAsteroide=new Asteroide(rand.nextInt(650),100,50,5);
	
		
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

		// ...
		
		
		if (!perdido) {
			
			this.miAstromega.dibujarse(this.entorno);
			this.miAsteroide.dibujarse(this.entorno);
			
			
			
			for (int i = 0; i < destructores.length; i++) {
				this.destructores[i].dibujarse(entorno);
				this.destructores[i].mover();
				if (this.destructores[i].getY()> this.entorno.alto() ) {
					this.destructores[i].setY(50);
				} 
			}
			
		
			if (this.miAsteroide.getX() >= this.entorno.ancho()) {
				this.miAsteroide.invertir();
			}
				this.miAsteroide.mover();

			// Hace que cuando toques la barra espaciadora, sale el proyectil
			if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO) && this.disparo==null) {
				this.disparo= this.miAstromega.disparar();
			}
			if (this.disparo!=null) {
				this.disparo.dibujarse(this.entorno);
				this.disparo.mover();
				if(this.disparo.getY()< 0) {
					this.disparo=null;
				}
			}
			
			
			
			if(this.miAsteroide.getY() > this.entorno.alto()) {
				this.miAsteroide.setY(50);
			}

			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)
					&& this.miAstromega.getX() + this.miAstromega.getAncho() / 2 < this.entorno.ancho()) {
				this.miAstromega.moverDerecha();
			}
				if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
					&& this.miAstromega.getX() - this.miAstromega.getAncho() / 2 > 0) {
				this.miAstromega.moverIzquierda();
			
				
			}
				if (choqueNaves() || choqueNaveAsteroide()) {
					this.perdido=true;
				}
		}
		else {
			this.entorno.cambiarFont(Font.SANS_SERIF,100,Color.RED);
			this.entorno.escribirTexto("Perdiste", this.entorno.ancho()/2,this.entorno.alto()/2 );
		}
	}
	private boolean choqueNaves() {
		boolean superposicionY=this.destructores[1].getY()> this.miAstromega.getY()- this.miAstromega.getAlto()/2;
		boolean superposicionX=(this.miAstromega.getX()- this.miAstromega.getAncho()/2 < this.destructores[1].getX()) &&
				(this.miAstromega.getX()+this.miAstromega.getAncho()/2> this.destructores[1].getX());
		return superposicionY && superposicionX;
}
	private boolean choqueNaveAsteroide() {
		boolean superposicionY=this.miAsteroide.getY()> this.miAstromega.getY()- this.miAstromega.getAlto()/2;
		boolean superposicionX=(this.miAstromega.getX()- this.miAstromega.getAncho()/2 < this.miAsteroide.getX()) &&
				(this.miAstromega.getX()+this.miAstromega.getAncho()/2> this.miAsteroide.getX());
		return superposicionY && superposicionX;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
