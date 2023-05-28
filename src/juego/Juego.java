package juego;
import java.awt.Color;

import java.awt.Font;

import java.util.Random;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	private Entorno entorno;

	//TODO: nuestros objetos
	private Astromega astromega;
	private Proyectil shootMega;
	private Proyectil shootDest;
	private Asteroide[] asteroides;
	private Destructor[] destructores;

	//TODO: nuestras variables
	private int vidaAstro;
	private boolean perdido;
	private int tiempo;
	private int puntuacion;
	private int cantEnemigos;

	Juego() {
		Random rand = new Random(); // variable que contiene el objeto random para usarlo para ubicar a los objetos de modo aleatorio
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo Mato, Palomeque y Sangueso- v1", 800, 600);

		// Inicializando nuestro elementos para iniciar el juego
		this.astromega = new Astromega(400, 550, 50, 50, 4);
		this.vidaAstro = 3;
		this.tiempo = 0;
		this.shootMega = null; //proyectil de Astromega
		this.shootDest = null; //proyectil de destructores
		perdido = false;

		// Array de objetos
		this.asteroides = new Asteroide[5];
		this.destructores = new Destructor[4];

		for (int i = 0; i < destructores.length; i++){
			destructores[i] = new Destructor(rand.nextInt(this.entorno.ancho()), 100, 50, 40, 1);
		}

		for (int i = 0; i < asteroides.length; i++){ // se creo el arreglo de asteroides
			asteroides[i] = new Asteroide(rand.nextInt(this.entorno.ancho()), 100, 50, 40, 1);
		}

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
		// Acumulador para tener un control en el tiempo de tick
		tiempo++;
		
		// Valor random
		Random rand= new Random();

		if (!perdido && vidaAstro > 0) {
			this.entorno.cambiarFont(Font.SANS_SERIF, 20,Color.green);
			this.entorno.escribirTexto("Puntuacion: " +  this.puntuacion, this.entorno.ancho()/2 - 250 ,this.entorno.alto()-5);
			this.entorno.escribirTexto("Vidas: " +  this.vidaAstro, this.entorno.ancho()/2 - 50 ,this.entorno.alto()-5);
			this.entorno.escribirTexto("Enemigos: " +  this.cantEnemigos, this.entorno.ancho()/2 + 100 ,this.entorno.alto()-5);
			/*************************************************************************/
			/**************************ASTROMEGA*************************************/
			/***********************************************************************/
			this.astromega.dibujarse(this.entorno);
			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && this.astromega.getX() + this.astromega.getAncho() / 2 < this.entorno.ancho()) {
				this.astromega.moverDerecha();
			}

			if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.astromega.getX() - this.astromega.getAncho() / 2 > 0) {
				this.astromega.moverIzquierda();
			}

			// Hace que cuando toques la barra espaciadora, sale el proyectil
			if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO) && this.shootMega == null) {
				this.shootMega = this.astromega.disparar();
			}
			
			if (this.shootMega != null) {
				this.shootMega.dibujarse(this.entorno);
				this.shootMega.disparoAstro();
				if (this.shootMega.getY() < 0) {
					this.shootMega = null;
				}
			}
			
			/*************************************************************************/
			/**************************DESTRUCTOR************************************/
			/***********************************************************************/
			for (int i=0 ; i< destructores.length;i++) {
				if (this.destructores[i] != null){ // TODO: acciones que hace destructor si el objeto no es NULL
					this.destructores[i].dibujarse(this.entorno);
					this.destructores[i].mover();
					
					//TODO: Se creo sectores para que los destructores esten en lugares predeterminados
					if (this.destructores[i].ubicarEn1(this.entorno)) {
						if(this.destructores[i].getX() <= 20) {
							this.destructores[i].setAngulo(45);
						}
						if (this.destructores[i].getX() >= 199) {
							this.destructores[i].setAngulo(315);
						}
					}
					
					if (this.destructores[i].ubicarEn2(this.entorno)) {
						if(this.destructores[i].getX() <= 220) {
							this.destructores[i].setAngulo(45);
						}
						if (this.destructores[i].getX() >= 399) {
							this.destructores[i].setAngulo(315);
						}
					}
					
					if (this.destructores[i].ubicarEn3(this.entorno)) {
						if(this.destructores[i].getX() <= 420) {
							this.destructores[i].setAngulo(45);
						}
						if (this.destructores[i].getX() >= 599) {
							this.destructores[i].setAngulo(315);
						}
					}
					
					if (this.destructores[i].ubicarEn4(this.entorno)) {
						if(this.destructores[i].getX() <= 620) {
							this.destructores[i].setAngulo(45);
						}
						if (this.destructores[i].getX() >= 799) {
							this.destructores[i].setAngulo(315);
						}
					}
					
					if (this.destructores[i].getY() >= this.entorno.alto()){ //TODO: El destructor reinicia su posicion si no tuvo interaccion con demas objetos 
						this.destructores[i].respawn(this.entorno);
					}
					
					//TODO: disparo automatico de los destructores
					if (tiempo % 100 == 0 && this.shootDest == null) { //FIXME: El destructor dispara si no ejecuto un disparo aun, corregir
						this.shootDest = this.destructores[i].disparar();
					}
					
					if (this.shootDest != null) {
						this.shootDest.dibujarse(this.entorno);
						this.shootDest.disparoDest(); 
						if (this.shootDest.getY() > this.entorno.alto()) { 
							this.shootDest = null; 
						} 
					}
					
					if(choqueDestructorConAstro(destructores[i], astromega)) {
						this.destructores[i] = null;
						this.vidaAstro --;
					}
					
					if (this.shootMega != null && colisionDisparoDestructores(this.destructores[i], shootMega)) {
						this.puntuacion += this.destructores[i].getPuntuacion();
						this.cantEnemigos++;
						this.destructores[i] = null;
						this.shootMega = null;
					}
				}
				
				for(int x = 0; x< destructores.length;x++){ // bucle que hace aparecer nuevos objetos para que no este vacia de enemigos
					if(tiempo >= 500/2 && this.destructores[x]== null){
						this.destructores[x]= new Destructor(rand.nextInt(this.entorno.ancho()), 100, 50, 40, 1);
						tiempo = 0;
					}
				}
				
			}
			
			/**************************************************************************/
			/**************************ASTEROIDES*************************************/
			/************************************************************************/
			for (int i = 0; i < asteroides.length; i++) // el For de los asteroides
			{

				if (this.asteroides[i] != null) {
					this.asteroides[i].dibujarse(this.entorno);
				}

				if (this.asteroides[i]!=null &&this.asteroides[i].salirDerecha(this.entorno)){ // los asteroides salen hacia la direccion derecha si el x esta entre 0 y la mitad del ancho
					this.asteroides[i].setAngulo(135);
				}

				if (this.asteroides[i]!=null&& this.asteroides[i].salirIzquierda(this.entorno)){ // los asteroides salen hacia la izquierda si el x esta entre la mitad y el ancho total del entorno
					this.asteroides[i].setAngulo(315);
				}

				if(this.asteroides[i]!=null){
					this.asteroides[i].mover();
				}

				if (this.asteroides[i]!=null && this.asteroides[i].getY() >= this.entorno.alto()){ // si el Y de cada asteroide supera el alto reaparece arriba
					this.asteroides[i].respawn(this.entorno);
				}

				if (this.asteroides[i]!=null && this.asteroides[i].getX() >= this.entorno.ancho()){ // si el asteroide choca con el de la derecha se dirige hacia la izquierda
					this.asteroides[i].setAngulo(315);
				}
				
				if (this.asteroides[i]!=null && this.asteroides[i].getX() <= 0){ // si el asteroide choca con el borde de la izquierda se dirige hacia la derecha
					this.asteroides[i].setAngulo(135);
				}
			}

			for (int i = 0; i < asteroides.length; i++) {// disparo a asteroide
				if (this.asteroides[i] != null && this.shootMega != null && colisionDisparoAsteroide(this.asteroides[i], shootMega)) {
					this.asteroides[i] = null;
					this.shootMega= null;
				}
			}

			for(int i = 0; i< asteroides.length;i++){
				if(tiempo >= 1000/2 && this.asteroides[i]== null){
					this.asteroides[i]= new Asteroide(rand.nextInt(650),100,50,40,2);
					tiempo=0;
				}
			}

			for(int i=0; i < asteroides.length; i++){
				if( this.asteroides[i] != null && choqueAsteroideConAstro(asteroides[i], astromega)) {
					this.asteroides[i] = null;
					this.vidaAstro --;
				}
			}
		}else{
			this.entorno.cambiarFont(Font.SANS_SERIF,100,Color.green);
			this.entorno.escribirTexto("GAME OVER", 100,this.entorno.alto()/2);
		}
	}

	/*********************************************************************************/
	/**************************METODOS DEL JUEGO*************************************/
	/*******************************************************************************/

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
	
	private boolean colisionDisparoAsteroide(Asteroide asteroide, Proyectil disparo) {
		boolean superposY = asteroide.getY() > disparo.getY() - disparo.getAlto() / 2;
		boolean superposX = (disparo.getX() - disparo.getAncho() / 2 < asteroide.getX())
				&& (disparo.getX() + disparo.getAncho() / 2 > asteroide.getX());
		return superposY && superposX;
	}

	private boolean superposicionAsteroides(Asteroide aste1, Asteroide aste2){
		boolean superposY= aste1.getY()> aste2.getY()-aste2.getAlto()/2;
		boolean superposX= (aste2.getX()- aste2.getAncho()/2< aste1.getX())
				&& (aste2.getX()+ aste2.getAncho()/2> aste1.getX());
		return superposY && superposX;
	}
	
	private boolean colisionDisparoDestructores(Destructor destructor, Proyectil disparo) {
		boolean superposY = destructor.getY() > disparo.getY() - disparo.getAlto() / 2;
		boolean superposX = (disparo.getX() - disparo.getAncho() / 2 < destructor.getX())
				&& (disparo.getX() + disparo.getAncho() / 2 > destructor.getX());
		return superposY && superposX;
	}


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
