
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NullPointerException;
import java.sql.Driver;

import javax.swing.JOptionPane;


public class CrearPublicacionesMercadolibre {
	
	
	
	public static void main(String[] args) throws Exception{  //MetodoMain
		CrearPublicacionesMercadolibre Crea = new CrearPublicacionesMercadolibre();
		
		
		Crea.PublicacionNueva();
		
	}
	
	
	public Robot robot;
	public AutoClick autoClick;
	public Runtime runtime;
	
	public Keyboard keyboard;
	
	File folder = new File("C:\\Users\\gustavo\\Desktop\\SUMA");
	File[] lista = folder.listFiles();	
	
	
	
	
	public void PublicacionNueva() throws Exception {
		
		runtime = Runtime.getRuntime();
		keyboard = new Keyboard();
		int a = 0;
		
		try {	
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();	
		}
		
		AutoClick.CambiarPantalla(robot);
		 
		  for(int i=0; i<lista.length/2; i++) {
		  
		
			  
		ElegirProducto(a,5);	
		 a=a+2;	
		 robot.delay(1500);
		 robot.delay(1500);
	
		
		
		}
		
		 
		
	}
	
	
	

	


public void ElegirProducto(int b, int baja)throws Exception  {

	
	
	robot.delay(1500);
	robot.mouseMove(1800, 200);
	AutoClick.leftClick(robot);
	AutoClick.Bajar(robot, 26);
	robot.delay(800);
	
	robot.mouseMove(465,104
			);
	AutoClick.leftClick(robot);
	AutoClick.leftClick(robot);
	robot.delay(1500);
	robot.delay(500);
	String cadena = lista[b].getName().substring(0, (lista[b].getName().length() - 4));	
	String cadenaFinal = "Remera ".concat(lista[b].getName().substring(0, (lista[b].getName().length() - 7)));	
	keyboard.type(cadena);
	robot.delay(1500);
	robot.delay(950);
	AutoClick.Enter(robot);
	
	robot.mouseMove(465, 1000);
	robot.delay(950);
	autoClick.leftClick(robot);
	AutoClick.leftClick(robot);
	robot.delay(950);
	robot.delay(1500);
	String cadena2 = lista[b+1].getName().substring(0, (lista[b].getName().length() - 4));	
	keyboard.type(cadena2);
	robot.delay(500);
	robot.delay(1500);
	AutoClick.Enter(robot);
	robot.delay(1500);
	robot.delay(800);
	robot.delay(1500);
	robot.mouseMove(1800, 200);
	AutoClick.doubleleftClick(robot);
	robot.delay(800);
	AutoClick.Bajar(robot, 50);
	robot.delay(800);
	robot.mouseMove(1800, 200);
	robot.delay(200);
	AutoClick.doubleleftClick(robot);
	
	AutoClick.Subir(robot, 6);
	
	
	robot.mouseMove(600,140);
		robot.delay(200);
		autoClick.doubleleftClick(robot);
		autoClick.leftClick(robot);
		robot.delay(600);	

	
	keyboard.type(cadenaFinal);
	
	robot.delay(800);
	
	robot.mouseMove(1800, 1020);
	robot.delay(800);
	AutoClick.leftClick(robot);
	robot.delay(300);
	AutoClick.Bajar(robot, 15);
	robot.delay(1000);
	
	robot.delay(800);
	robot.mouseMove(400, 920);
	robot.delay(500);
	AutoClick.leftClick(robot);
	
	//PRECIO ELABORACION: 
	
	robot.delay(900);
	robot.delay(1500);
	robot.delay(800);
	robot.mouseMove(1800, 200);
	robot.delay(200);
	AutoClick.leftClick(robot);
	AutoClick.Bajar(robot, 15);
	robot.delay(300);
	robot.mouseMove(400, 910);
	robot.delay(300);
	AutoClick.leftClick(robot);
	

	//CLASSICA O PREMIUM
	robot.delay(1500);
	robot.delay(800);
	robot.delay(900);
	robot.delay(900);
	
	
	robot.mouseMove(1000, 600);
	robot.delay(500);
	AutoClick.doubleleftClick(robot);
	
	robot.delay(1000);
	robot.delay(800);
	robot.mouseMove(480, 750);
	robot.delay(1000);
	AutoClick.leftClick(robot);
	
	
	//Confirmar Todo
	robot.delay(1500);
	robot.delay(800);
	robot.delay(1500);
	robot.mouseMove(1000,750);
	robot.delay(1000);
	robot.delay(500);
	AutoClick.leftClick(robot);
	
	robot.delay(1500);
	robot.delay(1000);
	
	
	
	/*
	//PRECIO ELABORACION: 
	robot.delay(900);
	robot.delay(1500);
	robot.delay(800);
	robot.mouseMove(1800, 200);
	robot.delay(200);
	AutoClick.leftClick(robot);
	AutoClick.Bajar(robot, 15);
	robot.delay(1000);
	robot.mouseMove(400, 915);
	robot.delay(1000);
	AutoClick.leftClick(robot);
	
	
	
	
	//CLASSICA O PREMIUM
	robot.delay(1500);
	robot.delay(800);
	robot.delay(900);
	robot.delay(900);
	
	
	robot.mouseMove(1000, 600);
	robot.delay(500);
	AutoClick.doubleleftClick(robot);
	
	robot.delay(1000);
	robot.delay(800);
	robot.mouseMove(480, 750);
	robot.delay(1000);
	AutoClick.leftClick(robot);
	
	
	//Confirmar Todo
	robot.delay(1500);
	robot.delay(800);
	robot.delay(1500);
	robot.mouseMove(1000,750);
	robot.delay(1000);
	robot.delay(500);
	AutoClick.leftClick(robot);
	
	*/
	
	
	
	
}
	
public void ElegirProductoGris(int b, int baja)throws Exception  {

	
	robot.delay(400);
	AutoClick.Bajar(robot, baja);
	robot.mouseMove(465, 946);
	robot.mouseMove(465, 947);
	robot.delay(450);
	AutoClick.leftClick(robot);
	robot.delay(150);
	AutoClick.leftClick(robot);
	robot.delay(450);
	String cadena2 = lista[b+1].getName().substring(0, (lista[b].getName().length() - 4));	
	
	keyboard.type(cadena2); //NombreRemeraBlanca
	robot.delay(450);
	AutoClick.Enter(robot);

}


public void EscribirNombre(int b) {
	
	robot.delay(300);
	robot.mouseMove(600, 115);
	String cadena2 = lista[b+1].getName().substring(0, (lista[b].getName().length() - 6));		
	AutoClick.doubleleftClick(robot);
	AutoClick.leftClick(robot);
	robot.delay(300);
	keyboard.type(cadena2);
	robot.delay(6000);
	robot.mouseMove(430, 1020);
	robot.delay(300);
	AutoClick.leftClick(robot);
	robot.delay(300);
	
}

	
	


public void Comision() {
	
	robot.delay(3800);
	robot.mouseMove(900, 500);
	robot.delay(200);
	AutoClick.leftClick(robot);
	robot.delay(200);
	robot.mouseMove(415, 750);
	robot.delay(200);
	AutoClick.leftClick(robot);
	
	
}

public void PublicarSimilar() {
	
	robot.delay(3800);
	robot.mouseMove(1000, 750);
	robot.delay(200);
	AutoClick.leftClick(robot);
	
	
}
















}
