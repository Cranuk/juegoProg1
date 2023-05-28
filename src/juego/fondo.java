package juego;

import java.awt.Image;

import entorno.Entorno;

public class fondo {
	private Image fondo;
	
	void Fondo() {
        this.fondo = entorno.Herramientas.cargarImagen("imagenes/asteroide.png");
       
    }

}
