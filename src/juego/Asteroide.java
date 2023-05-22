package juego;

import java.awt.Color;
import java.util.Random;

import entorno.Entorno;

public class Asteroide {
		private double x;
		private double y;
		private int radio;
		private int velocidad;
		private double angulo;
		
		Asteroide(int x, int y, int radio, int velocidad){
			this.x=x;
			this.y=y;
			this.radio=radio;
			this.velocidad=velocidad;
			this.angulo=entorno.Herramientas.grados(135);
		}
		
		public void dibujarse(Entorno entorno) {
			 entorno.dibujarCirculo(this.x, this.y, this.radio, Color.white);
		}
		
		
		public void mover() {
			this.y=this.y + velocidad*Math.sin(angulo);
			this.x=this.x + velocidad*Math.cos(angulo);
		}
		
		public void choqueDerecha() { //cambia de angulo cuando choca con la pared derecha
			this.angulo=entorno.Herramientas.grados(315);
		}
		
		public void choqueIzquierda() //cambia de angulo cuando choca con la parde izquierda
		{
			this.angulo= entorno.Herramientas.grados(135);
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
		
		public double getX() {
			return x;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public double getY() {
			return y;
		}
		public double getRadio()
		{
			return radio;
		}
		public void setY(int y) {
			this.y = y;
		}
		public void setAngulo(double angulo)
		{
			this.angulo= entorno.Herramientas.grados(angulo);
		}
}