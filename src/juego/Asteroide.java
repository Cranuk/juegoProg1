package juego;

import java.awt.Color;

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
			this.x= this.x + velocidad * Math.cos(angulo);
			this.y= this.y + velocidad * Math.sin(angulo);	
		}
		public void invertir() {
			this.angulo=entorno.Herramientas.grados(315);

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
		public void setY(int y) {
			this.y = y;
		}
}
