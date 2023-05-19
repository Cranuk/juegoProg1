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
	
	private boolean perdido;
	
	private Asteroide miAsteroide;
	private Asteroide miAsteroide2;
	
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
		/*this.destructores=new Destructor(rand.nextInt(650),100,50,50,2);
		this.miProyectil= new Proyectil(450,300,15,50,2);*/
		this.miAsteroide=new Asteroide(550,100,50,4);
		this.miAsteroide2= new Asteroide(5,100,50,4);
		

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
			
			/*this.miProyectil.dibujarse(this.entorno);
			this.destructores.dibujarse(this.entorno);*/
			this.miAsteroide.dibujarse2(this.entorno);
			this.miAsteroide2.dibujarse(this.entorno);
			
			
			
			if(salirDerecha()) //el asteroide se mueve hacia la derecha con un angulo de 135
			{
				
				this.miAsteroide.setAngulo(135);
				this.miAsteroide2.setAngulo(135);
				
				
				
				
			}
			if (salirIzquierda()) //el asteroide se mueve hacia la izquierda en un angulo de 315
			{
				this.miAsteroide.setAngulo(315);
				this.miAsteroide2.setAngulo(315);
				
				
				
			}
			
			this.miAsteroide.mover();
			this.miAsteroide2.mover();
			
			
			if (this.miAsteroide.getY()>= this.entorno.alto() ) //el asteroide reaparece si se pasa del alto del entorno
			{
				this.miAsteroide.respawn(this.entorno);
			}
			if(this.miAsteroide2.getY()>= this.entorno.alto())
			{
				this.miAsteroide2.respawn(this.entorno);
			}
			
			
			if(this.miAsteroide.getX()>= this.entorno.ancho() ) //cambia de angulo cuando el x del asteroide supera el ancho del entorno
			{
				this.miAsteroide.choqueDerecha();
			}
			
			if(this.miAsteroide2.getX()>= this.entorno.ancho())
			{
				this.miAsteroide2.choqueDerecha();
			}
			
			
			if(this.miAsteroide.getX() <= 0) //cambia de angulo cuando el x del asteroide es <=0
			{
				this.miAsteroide.choqueIzquierda();
			}
			
			if(this.miAsteroide2.getX()<= 0)
			{
				this.miAsteroide2.choqueIzquierda();
			}
			
			if(colisionDeAsteroides()) //por el momento solo pude hacer un choque xd
			{
				this.miAsteroide2.choqueDerecha();
				this.miAsteroide.choqueIzquierda();
			}
			
			
			
			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)
					&& this.miAstromega.getX() + this.miAstromega.getAncho() / 2 < this.entorno.ancho()) {
				this.miAstromega.moverDerecha();
			}
			
			if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
				&& this.miAstromega.getX() - this.miAstromega.getAncho() / 2 > 0) {
				this.miAstromega.moverIzquierda();
			}
			
			/*if (choqueNaves() || choqueNaveAsteroide()) {
				this.perdido=true;
			}*/
		}
		else {
			this.entorno.cambiarFont(Font.SANS_SERIF,100,Color.RED);
			this.entorno.escribirTexto("Perdiste", this.entorno.ancho()/2,this.entorno.alto()/2 );
		}
	}
	/*private boolean choqueNaves() {
		boolean superposicionY=this.destructores.getY()> this.miAstromega.getY()- this.miAstromega.getAlto()/2;
		boolean superposicionX=(this.miAstromega.getX()- this.miAstromega.getAncho()/2 < this.destructores.getX()) &&
				(this.miAstromega.getX()+this.miAstromega.getAncho()/2> this.destructores.getX());
		return superposicionY && superposicionX;
		*/

	private boolean choqueNaveAsteroide() {
		boolean superposicionY=this.miAsteroide.getY()> this.miAstromega.getY()- this.miAstromega.getAlto()/2;
		boolean superposicionX=(this.miAstromega.getX()- this.miAstromega.getAncho()/2 < this.miAsteroide.getX()) &&
				(this.miAstromega.getX()+this.miAstromega.getAncho()/2> this.miAsteroide.getX());
		return superposicionY && superposicionX;
	}
	private boolean salirDerecha() //da verdadero si el asteroide sale desde x=0 hasta la mitad del ancho del entorno
	{
		boolean xMitad= this.miAsteroide.getX()>=0 && this.miAsteroide.getX() <= this.entorno.ancho()/2;
		boolean y= this.miAsteroide.getY()== 100;
		return xMitad && y ;
	}
	private boolean salirIzquierda() //da verdadero si el asteroide sale desde la mitad del ancho hasta el fin del ancho del entorno
	{
		boolean xMitad= this.miAsteroide.getX()> this.entorno.ancho()/2 && this.miAsteroide.getX() <=650;
		boolean y= this.miAsteroide.getY() ==100;
		return xMitad &&y;
	}
	private boolean colisionDeAsteroides()
	{
		return this.miAsteroide.getX()- this.miAsteroide.getRadio()< this.miAsteroide2.getX();
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
