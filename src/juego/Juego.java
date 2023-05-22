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
	private Asteroide[] arregloAsteroides;
	
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
		
		this.arregloAsteroides= new Asteroide[5];
		
		for(int i=0; i<arregloAsteroides.length; i++)//se creo el arreglo de asteroides
		{
			 arregloAsteroides[i]= new Asteroide(rand.nextInt(650),100,50,4);
			 
		}
		
		
		
		this.miAsteroide= new Asteroide(300,100,50,4);
		this.miAsteroide2= new Asteroide(370,100,50,4);

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
			
			
			
			for(int i=0; i<arregloAsteroides.length; i++) //el For de los asteroides
			{
				
				this.arregloAsteroides[i].dibujarse(this.entorno);
				
				if(this.arregloAsteroides[i].salirDerecha(this.entorno))//los asteroides salen hacia la direccion derecha si el x esta entre 0 y la mitad del ancho
				{
					this.arregloAsteroides[i].setAngulo(135);
				}
				
				if(this.arregloAsteroides[i].salirIzquierda(this.entorno))//los asteroides salen hacia la izquierda si el x esta entre la mitad y el ancho total del entorno
				{
					this.arregloAsteroides[i].setAngulo(315);
				}
				
				 /*this.arregloAsteroides[i].mover();*/
				 
				 if(this.arregloAsteroides[i].getY()>= this.entorno.alto())//si el Y de cada asteroide supera el alto reaparece arriba
				 {
					 this.arregloAsteroides[i].respawn(this.entorno);
				 }
				 
				 if (this.arregloAsteroides[i].getX()>= this.entorno.ancho())//si el asteroide choca con el borde del ancho se dirige hacia la izquierda
				 {
					 this.arregloAsteroides[i].choqueDerecha();
				 }
				 if (this.arregloAsteroides[i].getX()<=0)//si el asteroide choca con el borde 0 del ancho se dirige hacia la derecha
				 {
					 this.arregloAsteroides[i].choqueIzquierda();
				 }
				 
				
				 
				 
			}
			
			for(int i=1; i<arregloAsteroides.length; i++)//for para detectar un tipo de colision
			{
				int j=0;
				if (this.arregloAsteroides[j].getX()- this.arregloAsteroides[j].getRadio()< this.arregloAsteroides[i].getX())
				 {
					//falta hacerle modificaciones pero la idea es que si colisionan, estos se dirigen hacia la direccion contraria	
					this.arregloAsteroides[j].choqueIzquierda();
						 
					this.arregloAsteroides[i].choqueDerecha();
					
						}
				
				j++;
				
				
				
				 }
			
			
			for(int i=0; i<arregloAsteroides.length; i++)//hice un for aparte para que los asteroides siempre se esten moviendo
			{
				this.arregloAsteroides[i].mover();
			}
				 
			}
			
			
			
			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)
					&& this.miAstromega.getX() + this.miAstromega.getAncho() / 2 < this.entorno.ancho()) {
				this.miAstromega.moverDerecha();
			}
			
			if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
				&& this.miAstromega.getX() - this.miAstromega.getAncho() / 2 > 0) {
				this.miAstromega.moverIzquierda();
			}
	}
			
			/*if (choqueNaves() || choqueNaveAsteroide()) {
				this.perdido=true;
			}
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

	
	//esta parte de codigo la sigo viendo pero la idea es ordenar de menor a mayor los asteroides, todavia no funciona pero la dejo por las dudas
	/*private void ordenarAsteroide(Asteroide [] arregloAsteroides)
	{
		for(int i=0; i<arregloAsteroides.length-1;i++)
		{
			double menor=i;
			for(double j=i+1; j< arregloAsteroides.length; j++)
			{
				if(arregloAsteroides[j].getX()< arregloAsteroides[menor].getX())
				{
					menor=j;
				}
				swap( arregloAsteroides,arregloAsteroides[i].getX(),arregloAsteroides[menor].getX());
				
			}
		}
	}
	private void swap(Asteroide[] arregloAsteroides, int i, int j)
	{
		int aux= arregloAsteroides[i].getX();
		int auxi=arregloAsteroides[i].getX();
		int auxj=arregloAsteroides[j].getX();
		auxi= arregloAsteroides[j].getX();
		auxj= arregloAsteroides[aux].getX();
		
		
	}*/
	
	
	
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
