package juego;

import java.awt.Color;
<<<<<<< HEAD
import java.util.Random;
=======
>>>>>>> master

import entorno.Entorno;

public class Asteroide {
<<<<<<< HEAD
		private double x;
		private double y;
		//se borro el radio
		private int alto;
		private int ancho;
		private int velocidad;
		private double angulo;
		private int vida;
		
		Asteroide(int x, int y, int ancho, int alto, int velocidad){
			this.x=x;
			this.y=y;
			this.ancho= ancho;
			this.alto= alto;
			this.velocidad=velocidad;
			this.angulo=entorno.Herramientas.grados(135);
			this.vida=3;
		}
		
		public void dibujarse(Entorno entorno) {
			 entorno.dibujarRectangulo(this.x,this.y,this.ancho,this.alto,0, Color.YELLOW);
		}
		
		
		public void mover() {
			this.y=this.y + velocidad*Math.sin(angulo);
			this.x=this.x + velocidad*Math.cos(angulo);
		}
		
		
		public void respawn(Entorno entorno)
		{
			Random rand= new Random();
			this.x= rand.nextInt(50, entorno.ancho()-50);
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
		
		public void sumarAlX()
		{
			this.x+=70;
		}
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
=======
		private int x;
		private int y;
		private int radio;
		private int velocidad;
		
		Asteroide(int x, int y, int radio, int velocidad){
			this.x=x;
			this.y=y;
			this.radio=radio;
			this.velocidad=velocidad;
		}
		public void dibujarse(Entorno entorno) {
			entorno.dibujarCirculo(this.x, this.y, this.radio, Color.white);
	}
		public void mover() {
			this.y+= velocidad;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
}
>>>>>>> master
