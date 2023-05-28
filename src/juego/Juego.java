package juego;
<<<<<<< HEAD
import java.awt.Color;
=======
<<<<<<< HEAD

import java.awt.Color;
import java.awt.Image;
=======
import java.awt.Color;
>>>>>>> master

import java.awt.Font;

import java.util.Random;
>>>>>>> master

import java.awt.Font;

import java.util.Random;
import entorno.Entorno;
<<<<<<< HEAD

import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
=======
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
<<<<<<< HEAD
>>>>>>> master
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Astromega miAstromega;
	private boolean perdido;
	private Proyectil disparo;
	private Asteroide[] asteroides;
<<<<<<< HEAD
	private Destructor[] destructores;
	private Ion iones;
	private int tiempo;
	private int vida;
	private int tiempoiones;

	 //Imagenes
=======
	private Destructor miDestructor;
	private int tiempo;
	private int vida;
>>>>>>> master
	

	// Variables y métodos propios de cada grupo
	// ...

	Juego() {
<<<<<<< HEAD
		
		Random rand = new Random();
		// Inicializa el objeto entorno
		
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo Mato, Palomeque y Sangueso- v1", 800, 600);
		
		
		// Inicializar lo que haga falta para el juego
		// ...
		this.tiempo=0;
		this.tiempoiones=0;
		this.miAstromega=new Astromega(this.entorno.ancho()/2,500,2,10,5);
		
		/*
		 * this.destructores=new Destructor(rand.nextInt(650),100,50,50,2);
		 * this.miProyectil= new Proyectil(450,300,15,50,2);
		 */
		this.disparo = null; // disparo de Astromega
		this.iones= null; //disparo de destructores
		this.asteroides = new Asteroide[5];
		this.destructores= new Destructor[2];
	
		
		
		for (int i=0; i<destructores.length; i++)
		{
			destructores[i]= new Destructor(rand.nextInt(this.entorno.ancho()),100,50,40,2);
		}

		for (int i = 0; i < asteroides.length; i++)// se creo el arreglo de asteroides
		{
			asteroides[i] = new Asteroide(rand.nextInt(this.entorno.ancho()), 100, 50, 40, 2);

		}
		perdido=false;
		this.vida=3;	
		
		// Inicia el juego!
		this.entorno.iniciar();

=======
		Random rand = new Random();
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo Mato, Palomeque y Sangueso- v1", 800, 600);

		// Inicializar lo que haga falta para el juego
		// ...
		this.tiempo=0;
		this.miAstromega = new Astromega(400, 550, 150, 40, 3);
		
		this.disparo = null;
		this.asteroides = new Asteroide[5];
		crearAsteroides(); 
		
=======
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
>>>>>>> master

		this.miDestructor = new Destructor(rand.nextInt(this.entorno.ancho()-100),50,50,30,4);
		perdido=false;
		this.vida=3;
		
		// Inicia el juego!
		this.entorno.iniciar();
<<<<<<< HEAD

=======
>>>>>>> master
>>>>>>> master
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
<<<<<<< HEAD
		// Procesamiento de un instante de tiempo
		// ...
		tiempo++;
		tiempoiones++;
		Random rand= new Random();
		
		if (!perdido ) {
	
=======
<<<<<<< HEAD
		// Procesamiento de un instante de tiempo
		// ...
		
		tiempo++;
		
		Random rand= new Random();
		
		if (!perdido ) {
		
>>>>>>> master
			if(vida==0)
			{
				perdido=true;
			}
			this.miAstromega.dibujarse(this.entorno);
<<<<<<< HEAD
			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)
=======
			this.miDestructor.dibujarse(this.entorno);
			this.miDestructor.mover(this.entorno);
			if ((this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)|| this.entorno.estaPresionada(this.miAstromega.TECLA_D))
>>>>>>> master
					&& this.miAstromega.getX() + this.miAstromega.getAncho() / 2 < this.entorno.ancho()) {
				this.miAstromega.moverDerecha();
			}

<<<<<<< HEAD
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
			for (int i=0 ; i< destructores.length;i++)
			{
				if (this.destructores[i]!= null){
					this.destructores[i].dibujarse(this.entorno);
					//this.destructores[i].mover();					
				}
			}
			for(int i =0 ; i <destructores.length; i++)
			{
				if (tiempoiones % 100 ==0 && this.iones == null  && destructores[i]!= null) {
					this.iones=this.destructores[i].disparaion();
					
				}
				if (this.iones != null) {
					this.iones.dibujarse(this.entorno);
					this.iones.disparoDestruc();
					if (this.iones.getY()<0) {
						this.iones=null;
					}	
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
		for (int i=0; i< destructores.length; i++) { // disparo a destructores
			if (this.destructores[i]!=null && this.disparo!=null && colisionDisparoDestructores(this.destructores[i], disparo)) {
				this.destructores[i]=null;
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
=======
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

			//TODO: Asteroides
			
			
			
			for (int i = 0; i < asteroides.length; i++) // el For de los asteroides
			{
			
				if (this.asteroides[i] != null )
				{
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
						this.asteroides[i].respawn(this.entorno);
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
					
		
					if(this.asteroides[i].getVida()==0)
					{
						this.asteroides[i]= null;
					}
					

				}
				
				else {
					
					if(tiempo>=1000/2)
					{
						crearAsteroides();
						tiempo=0;
					}
					
				}
	

			}

		
		
		
	
		//TODO: Acciones de DESTRUCTOR
		if (this.miDestructor.getY() > this.entorno.alto() ) {
			this.miDestructor.respawn(this.entorno);
		}
		
		if (this.miDestructor.getX() - (this.miDestructor.getAncho()/2) <= 0) {
		    this.miDestructor.mover(this.entorno);
		}

		if (this.miDestructor.getX() - (this.miDestructor.getAncho()/2) >= this.entorno.ancho()) {
		    this.miDestructor.cambiarAngulo();
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
=======
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

>>>>>>> master
>>>>>>> master
	private boolean choqueAsteroideConAstro(Asteroide asteroide, Astromega miAstromega) {
		boolean superposY = asteroide.getY() > miAstromega.getY() - miAstromega.getAlto() / 2;
		boolean superposX = (miAstromega.getX() - miAstromega.getAncho() / 2 < asteroide.getX())
				&& (miAstromega.getX() + miAstromega.getAncho() / 2 > asteroide.getX());
		return superposY && superposX;
	}
	
<<<<<<< HEAD
	private boolean superposicionAsteroides(Asteroide aste1, Asteroide aste2)
	{
=======
<<<<<<< HEAD
	
	private void crearAsteroides()//sirve tanto para crear los 5 asteroides iniciales como para crear uno solo sin que se superpongan 
	{
		Random rand = new Random();

    // Verifica si ya se generaron los 5 asteroides iniciales
    boolean asteroidesInicialesGenerados = true;
    for (int i = 0; i < 5; i++) {
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

            asteroides[indice] = new Asteroide(asteroideX, asteroideY, 50, 30, 3);
            //con estas coordenadas generadas, me garantizo que el asteroide creado no se superponga con los demas
        }
    } else {
        // generar los 5 asteroides iniciales
        for (int i = 0; i < 5; i++) {
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

	
=======
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
>>>>>>> master
		boolean superposY= aste1.getY()> aste2.getY()-aste2.getAlto()/2;
		boolean superposX= (aste2.getX()- aste2.getAncho()/2< aste1.getX())
				&& (aste2.getX()+ aste2.getAncho()/2> aste1.getX());
		return superposY && superposX;
	}
<<<<<<< HEAD
=======
	
>>>>>>> master
	private boolean colisionDisparoDestructores(Destructor destructor, Proyectil disparo) {
		boolean superposY = destructor.getY() > disparo.getY() - disparo.getAlto() / 2;
		boolean superposX = (disparo.getX() - disparo.getAncho() / 2 < destructor.getX())
				&& (disparo.getX() + disparo.getAncho() / 2 > destructor.getX());
		return superposY && superposX;
	}
<<<<<<< HEAD
	
=======

>>>>>>> master
>>>>>>> master

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
