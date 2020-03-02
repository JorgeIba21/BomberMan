package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Jugador extends Rectangle {
	Color color;
	public static int VEL = 25;
	public Jugador() {
		super(Jugando.dimensionBloques, Jugando.dimensionBloques, 50, 50);
		color = Color.blue;
	}

	public void actualizar(int direccion, List<Mapa> BloquesMapa) {
		direccionJugador(direccion);
		chocarConPared();
		// chocarConBloquesMapa(BloquesMapa);
		;
	}

	public void direccionJugador(int direccion) {
		if (direccion == Jugando.IZQUIERDA)
			x -= VEL;

		if (direccion == Jugando.DERECHA)
			x += VEL;

		if (direccion == Jugando.ARRIBA)
			y -= VEL;

		if (direccion == Jugando.ABAJO)
			y += VEL;
	}

	public void chocarConPared() {
		/*
		if (x <= Jugando.dimensionBloques)
			x = Jugando.dimensionBloques;
		if (x >= (Jugando.longitudImagenX - width-Jugando.dimensionBloques))
			x = Jugando.longitudImagenX - width-Jugando.dimensionBloques;
		if (y <= Jugando.dimensionBloques)
			y = Jugando.dimensionBloques;
		if (y >= (Jugando.longitudImagenY - width-Jugando.dimensionBloques))
			y = Jugando.longitudImagenY - width-Jugando.dimensionBloques;*/
		
	}

	public void chocarConBloquesMapa(List<Mapa> BloquesMapa, List<Mapa> LadrillosMapa, int direccion) { // esto hay que arreglarlo que no funciona

		/*for(int i=0;i<BloquesMapa.size();i++) {
			if (x <= BloquesMapa.get(i).x)
				x = BloquesMapa.get(i).x;
			if (x >= (BloquesMapa.get(i).x + Jugando.dimensionBloques))
				x = BloquesMapa.get(i).x + Jugando.dimensionBloques;
			if (y <= BloquesMapa.get(i).y)
				y = BloquesMapa.get(i).y;
			if (y >= (BloquesMapa.get(i).y + Jugando.dimensionBloques))
				y = BloquesMapa.get(i).y + Jugando.dimensionBloques;

		}*/
		
		for (int i=0; i<BloquesMapa.size(); i++) {
			if(this.intersects(BloquesMapa.get(i))) {
				switch (direccion){
				case Jugando.ARRIBA:
					y += 25;
					break;
				case Jugando.ABAJO:
					y -= 25;
					break;
				case Jugando.IZQUIERDA:
					x += 25;
					break;
				case Jugando.DERECHA:
					x -= 25;
				}
			}
				
		}
		
		for (int j=0; j<LadrillosMapa.size(); j++) {
			if(this.intersects(LadrillosMapa.get(j))) {
				switch (direccion){
				case Jugando.ARRIBA:
					y += 25;
					break;
				case Jugando.ABAJO:
					y -= 25;
					break;
				case Jugando.IZQUIERDA:
					x += 25;
					break;
				case Jugando.DERECHA:
					x -= 25;
				}
			}
		}
		
		
	}

	public void chocarConLadrillosMapa() {

	}


	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}
