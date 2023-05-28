package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.Entorno;

public class Asteroide {
		private double x;
		private double y;
		private int alto;
		private int ancho;
		private int velocidad;
		private double angulo;
		private int vida;
		private Image imagen;
		private int puntuacion;
		
		


		Asteroide(int x, int y, int ancho, int alto, int velocidad){
			this.x=x;
			this.y=y;
			this.ancho= ancho;
			this.alto= alto;
			this.velocidad=velocidad;
			this.angulo=entorno.Herramientas.grados(135);
			this.vida=3;
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
		
		
		
		public void mover() {
			this.y=this.y + velocidad*Math.sin(angulo);
			this.x=this.x + velocidad*Math.cos(angulo);
		}
		
		
		public void respawn(Entorno entorno)
		{
			//quite el x en random porque sino me reaparece en otro lugar y me los interpone con otros asteroides
			this.x= getX();
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
}
