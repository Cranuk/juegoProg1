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
	private Asteroide[] asteroides;
	private int tiempo;
	private int vida;

	// Variables y métodos propios de cada grupo
	// ...

	Juego() {
		Random rand = new Random();
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo Mato, Palomeque y Sangueso- v1", 800, 600);

		// Inicializar lo que haga falta para el juego
		// ...
		this.tiempo=0;
		this.miAstromega = new Astromega(400, 550, 150, 40, 2);
		/*
		 * this.destructores=new Destructor(rand.nextInt(650),100,50,50,2);
		 * this.miProyectil= new Proyectil(450,300,15,50,2);
		 */
		this.disparo = null;
		this.asteroides = new Asteroide[5];

		for (int i = 0; i < asteroides.length; i++)// se creo el arreglo de asteroides
		{
			asteroides[i] = new Asteroide(rand.nextInt(this.entorno.ancho()), 100, 50, 40, 2);

		}
		perdido=false;
		this.vida=3;	
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
		// Procesamiento de un instante de tiempo
		// ...
		tiempo++;
		
		Random rand= new Random();
		
		if (!perdido ) {
		
			if(vida==0)
			{
				perdido=true;
			}
			this.miAstromega.dibujarse(this.entorno);
			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)
					&& this.miAstromega.getX() + this.miAstromega.getAncho() / 2 < this.entorno.ancho()) {
				this.miAstromega.moverDerecha();
			}

			if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
					&& this.miAstromega.getX() - this.miAstromega.getAncho() / 2 > 0) {
				this.miAstromega.moverIzquierda();
			}

			/*
			 * this.miProyectil.dibujarse(this.entorno);
			 * this.destructores.dibujarse(this.entorno);
			 */
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

			for (int i = 0; i < asteroides.length; i++) // el For de los asteroides
			{
				
				if (this.asteroides[i] != null) {
					this.asteroides[i].dibujarse(this.entorno);
				}

				if (this.asteroides[i]!=null &&this.asteroides[i].salirDerecha(this.entorno))// los asteroides salen hacia la direccion derecha
																		// si el x esta entre 0 y la mitad del ancho
				{
						this.asteroides[i].setAngulo(135);
				}

				if (this.asteroides[i]!=null&& this.asteroides[i].salirIzquierda(this.entorno))// los asteroides salen hacia la izquierda si el
																		// x esta entre la mitad y el ancho total del													// entorno
					{
						this.asteroides[i].setAngulo(315);
					}

				if(this.asteroides[i]!=null)
				{
					this.asteroides[i].mover();
				}

				if (this.asteroides[i]!=null && this.asteroides[i].getY() >= this.entorno.alto())// si el Y de cada asteroide supera el alto
																			// reaparece arriba
					{
						this.asteroides[i].respawn(this.entorno);
					}

				if (this.asteroides[i]!=null && this.asteroides[i].getX() >= this.entorno.ancho())// si el asteroide choca con el borde del
																			// ancho se dirige hacia la izquierda
					{
						this.asteroides[i].setAngulo(315);
					}
				if (this.asteroides[i]!=null &&this.asteroides[i].getX() <= 0)// si el asteroide choca con el borde 0 del ancho se dirige hacia
														// la derecha
					{
						this.asteroides[i].setAngulo(135);
					}
				
				

			}


			

		
		for (int i = 0; i < asteroides.length; i++) {//disparo a asteroide
			if (this.asteroides[i] != null && this.disparo != null && colisionDisparoAsteroide(this.asteroides[i], disparo)) {
				this.asteroides[i] = null;
				this.disparo= null;
			}
		}
	
		for(int i=0; i<asteroides.length;i++)
		{
			if(tiempo>=1000/2 && this.asteroides[i]== null)
			{
				this.asteroides[i]= new Asteroide(rand.nextInt(650),100,50,40,2);
				tiempo=0;
			}
		}
		
		for(int i=0; i< asteroides.length; i++)
		{
			if( this.asteroides[i]!= null && choqueAsteroideConAstro(asteroides[i], miAstromega))
				this.vida --;
		}
	}
		
			
	
	else{
			this.entorno.cambiarFont(Font.SANS_SERIF,100,Color.green);
			this.entorno.escribirTexto("GAME OVER", this.entorno.ancho()/2,this.entorno.alto()/2);
		}
}
	

		

	
	

	private boolean colisionDisparoAsteroide(Asteroide asteroide, Proyectil disparo) {
		boolean superposY = asteroide.getY() > disparo.getY() - disparo.getAlto() / 2;
		boolean superposX = (disparo.getX() - disparo.getAncho() / 2 < asteroide.getX())
				&& (disparo.getX() + disparo.getAncho() / 2 > asteroide.getX());
		return superposY && superposX;
	}
	private boolean choqueAsteroideConAstro(Asteroide asteroide, Astromega miAstromega) {
		boolean superposY = asteroide.getY() > miAstromega.getY() - miAstromega.getAlto() / 2;
		boolean superposX = (miAstromega.getX() - miAstromega.getAncho() / 2 < asteroide.getX())
				&& (miAstromega.getX() + miAstromega.getAncho() / 2 > asteroide.getX());
		return superposY && superposX;
	}
	
	private boolean superposicionAsteroides(Asteroide aste1, Asteroide aste2)
	{
		boolean superposY= aste1.getY()> aste2.getY()-aste2.getAlto()/2;
		boolean superposX= (aste2.getX()- aste2.getAncho()/2< aste1.getX())
				&& (aste2.getX()+ aste2.getAncho()/2> aste1.getX());
		return superposY && superposX;
	}

	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
