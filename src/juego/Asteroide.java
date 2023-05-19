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
		public void dibujarse2(Entorno entorno)
		{
			entorno.dibujarCirculo(this.x, this.y, this.radio, Color.pink);
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