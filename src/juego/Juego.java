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
	private boolean perdido;
	private Proyectil miProyectil;
	private Asteroide miAsteroide;
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		Random rand=new Random();
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		this.miAstromega= new Astromega(400, 550, 150, 40,2);
		
		this.destructores=new Destructor[4];
		this.destructores[0]= new Destructor(rand.nextInt(800),130,100,30,2);
		this.destructores[1]= new Destructor(rand.nextInt(710),60,100,30,2);
		this.destructores[2]= new Destructor(rand.nextInt(730),160,100,35,2);
		this.destructores[3]= new Destructor(rand.nextInt(600),140,100,45,2);
		
		this.miProyectil= new Proyectil(450,300,15,50,2);
		this.miAsteroide=new Asteroide(rand.nextInt(650),100,50,1);
		

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
			this.miProyectil.dibujarse(this.entorno);
			
			
			
			this.destructores[0].dibujarse(this.entorno);
			this.destructores[1].dibujarse(this.entorno);
			this.destructores[2].dibujarse(this.entorno);
			this.destructores[3].dibujarse(this.entorno);
			
			this.destructores[0].mover();
			this.destructores[1].mover();
			this.destructores[2].mover();
			this.destructores[3].mover();
			  
			
			
			this.miAsteroide.mover();
			this.miProyectil.mover();
			
			
			if(this.miAsteroide.getY() > this.entorno.alto()) {
				this.miAsteroide.setY(50);
			}
			if (this.destructores[1].getY()> this.entorno.alto() ) {
				this.destructores[1].setY(50);
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
