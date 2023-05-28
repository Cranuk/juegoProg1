package juego;

import java.awt.Color;
<<<<<<< HEAD
import java.awt.Image;
=======
>>>>>>> master
import java.util.Random;

import entorno.Entorno;

public class Asteroide {
		private double x;
		private double y;
<<<<<<< HEAD
=======
		//se borro el radio
>>>>>>> master
		private int alto;
		private int ancho;
		private int velocidad;
		private double angulo;
		private int vida;
<<<<<<< HEAD
		private Image imagen;
		private int puntuacion;
		
		


=======
		
>>>>>>> master
		Asteroide(int x, int y, int ancho, int alto, int velocidad){
			this.x=x;
			this.y=y;
			this.ancho= ancho;
			this.alto= alto;
			this.velocidad=velocidad;
			this.angulo=entorno.Herramientas.grados(135);
			this.vida=3;
<<<<<<< HEAD
			this.imagen = entorno.Herramientas.cargarImagen("imagenes/asteroide.png");
			redimensionarImagen();
		}
		

		private void redimensionarImagen() {
			//ajusta la imgen a las medida que tiene en ancho y alto 
	        this.imagen = this.imagen.getScaledInstance(this.ancho, this.alto, Image.SCALE_SMOOTH);
	    }
		public void dibujarse(Entorno entorno) {
			//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.YELLOW);
		    
		    entorno.dibujarImagen(imagen, this.x, this.y, this.angulo);
			 
		}
		
		
		
=======
		}
		
		public void dibujarse(Entorno entorno) {
			 entorno.dibujarRectangulo(this.x,this.y,this.ancho,this.alto,0, Color.YELLOW);
		}
		
		
>>>>>>> master
		public void mover() {
			this.y=this.y + velocidad*Math.sin(angulo);
			this.x=this.x + velocidad*Math.cos(angulo);
		}
		
		
		public void respawn(Entorno entorno)
		{
<<<<<<< HEAD
			//quite el x en random porque sino me reaparece en otro lugar y me los interpone con otros asteroides
			this.x= getX();
=======
			Random rand= new Random();
			this.x= rand.nextInt(50, entorno.ancho()-50);
>>>>>>> master
			this.y= 100;
		}
		
		public boolean salirDerecha(Entorno entorno) //da verdadero si el asteroide sale desde x=0 hasta la mitad del ancho del entorno
		{
			boolean xMitad= this.x>=0 && this.x <= entorno.ancho()/2;
			boolean y= this.y== 100;
			return xMitad && y ;
		}
		
		public boolean salirIzquierda(Entorno entorno) //da verdadero si el asteroide sale desde la mitad del ancho hasta el fin del ancho del entorno
		{
			boolean xMitad= this.x> entorno.ancho()/2 && this.x <=650;
			boolean y= this.y ==100;
			return xMitad &&y;
		}
		
<<<<<<< HEAD
		
=======
		public void sumarAlX()
		{
			this.x+=70;
		}
>>>>>>> master
		public double getX() {
			return x;
		}
		
		public void setX(double x) {
			this.x = x;
		}
		
		public double getY() {
			return y;
		}
		
		
		public int getAlto() {
			return alto;
		}

		public void setAlto(int alto) {
			this.alto = alto;
		}

		public int getAncho() {
			return ancho;
		}

		public void setAncho(int ancho) {
			this.ancho = ancho;
		}

		public void setY(int y) {
			this.y = y;
		}
		public void setAngulo(double angulo)
		{
			this.angulo= entorno.Herramientas.grados(angulo);
		}
<<<<<<< HEAD
		
		public int getVida() {
			return vida;
		}



		public void setVida(int vida) {
			this.vida = vida;
		}
		
		public int getPuntuacion() {
			return puntuacion;
		}


		public void setPuntuacion(int puntuacion) {
			this.puntuacion = puntuacion;
		}
=======
>>>>>>> master
}
/*
 * for(int i=1; i<asteroides.length; i++)//for para detectar un tipo de colision
 * {
 * 
 * 
 * int j=0; if (this.asteroides[j].getX()- this.asteroides[j].<
 * this.asteroides[i].getX()) { //falta hacerle modificaciones pero la idea es
 * que si colisionan, estos se dirigen hacia la direccion contraria
 * this.asteroides[j].choqueIzquierda();
 * 
 * this.asteroides[i].choqueDerecha();
 * 
 * }
 * 
 * 
 * j++; }
 */