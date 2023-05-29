package juego;

import java.awt.Image;
import entorno.Entorno;

public class fondo {
	private Image fondo;
	
	fondo() {
        this.fondo = entorno.Herramientas.cargarImagen("imagenes/fondo.png");
    }
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(this.fondo, entorno.ancho(), entorno.alto(),0);
	}

}
