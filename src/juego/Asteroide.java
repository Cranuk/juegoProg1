package juego;
import java.awt.Image;
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
		
		/**
		 * Constructor de asteroide
		 * @param x
		 * @param y
		 * @param ancho
		 * @param alto
		 * @param velocidad
		 */
		Asteroide(int x, int y, int ancho, int alto, int velocidad){
			this.x=x;
			this.y=y;
			this.ancho= ancho;
			this.alto= alto;
			this.velocidad=velocidad;
			this.angulo=entorno.Herramientas.grados(135);
			this.vida=3;
			this.puntuacion = 100;
			this.imagen = entorno.Herramientas.cargarImagen("imagenes/asteroide.png");
			redimensionarImagen();
		}
		
		public void dibujarse(Entorno entorno) {
			// entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.YELLOW);
		    entorno.dibujarImagen(imagen, this.x, this.y, this.angulo);
		}
		
		/**
		 *ajusta la imgen a las medida que tiene en ancho y alto 
		 */
		private void redimensionarImagen() {
	        this.imagen = this.imagen.getScaledInstance(this.ancho, this.alto, Image.SCALE_SMOOTH);
	    }

		public void mover() {
			this.y=this.y + velocidad*Math.sin(angulo);
			this.x=this.x + velocidad*Math.cos(angulo);
		}
		
		/**
		 * Quite el x en random porque sino me reaparece en otro lugar y me los interpone con otros asteroides
		 * @param entorno
		 */
		public void respawn(Entorno entorno){
			this.x= getX();
			this.y= 100;
		}
		
		/**
		 * Da verdadero si el asteroide sale desde x=0 hasta la mitad del ancho del entorno
		 * @param entorno
		 * @return
		 */
		public boolean salirDerecha(Entorno entorno) {
			boolean xMitad = this.x>=0 && this.x <= entorno.ancho()/2;
			boolean y = this.y == 100;
			return xMitad && y ;
		}
		
		/**
		 * Da verdadero si el asteroide sale desde la mitad del ancho hasta el fin del ancho del entorno
		 * @param entorno
		 * @return
		 */
		public boolean salirIzquierda(Entorno entorno) {
			boolean xMitad= this.x> entorno.ancho()/2 && this.x <= entorno.ancho();
			boolean y = this.y == 100;
			return xMitad && y;
		}

		// Getters y Setters
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
