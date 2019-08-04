
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

import javaRobot.AutoClick;



public class CrearPublicacionesMercadolibre {
	
	boolean bloqueamarillo = true;
	
	public static void main(String[] args) throws Exception{  //MetodoMain
		CrearPublicacionesMercadolibre Crea = new CrearPublicacionesMercadolibre();
	
			
		Crea.PublicacionNueva(lista,true);
			
	}
	
	
	public Robot robot;
	public AutoClick autoClick;
	public Runtime runtime;
	private long pesoAlgodon = 991264;
	
	public Keyboard keyboard;
	
	static File folder = new File("C:\\Users\\gustavo\\Desktop\\algodon"
			+ "");
	static File[] lista = folder.listFiles();	

	
	
	public void PublicacionNueva(File[] archivo, boolean algodon) throws Exception {
		
		runtime = Runtime.getRuntime();
		keyboard = new Keyboard();
		 boolean esAlgodon = algodon;
		int a = 0;
		int vel = 2;
		
		try {	
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();	
		}
		
		AutoClick.CambiarPantalla(robot);
	
		boolean huboerror;

		
		 for(int i=0; i<archivo.length/2; i++) {

			  huboerror = false;
			 Variantes(i,vel);
			ElegirProducto(a, esAlgodon, archivo, vel);	
			NombrePagina1(a, esAlgodon, archivo, vel);
			confirmarImagen();
			

			
			
			if(!errorImagen()) 
			{	
				arreglarError(vel);
				if(i>0) {
				i--;
				}
				System.out.println("el archivo: "+ archivo[a].getName() + " No se Cargo la IMAGEN");
				huboerror = true;
				Variantes(i, vel);
				ElegirProducto(a, esAlgodon, archivo, vel);	
				NombrePagina1(a, esAlgodon, archivo, vel);
				confirmarImagen();
			}
			
			ComisionFinal(1, vel);
	
			robot.delay(1500);		
			
			if(!errorML()) {
				arreglarError(vel);
				if(i>0 && !huboerror)
				i--;
				System.out.println("el archivo: "+ archivo[a].getName() + " No se publico, porque no detecto PRODUCTO");

				}
			else {
			
				System.out.println("el archivo: "+ archivo[a].getName() + " se publico EXITOSAMENTE!!");
				
				
				archivo[a].delete();
			
				archivo[a+1].delete();

				//subirTop();
				a = a + 2;		
			}
	
			  
		  }
 
		  
		}
		



public void ElegirProducto(int b, boolean esAlgodon, File[] archivo, int vel)throws Exception  {
	
	
	Pagina1(b,1,archivo, vel);
	
	
	
}





public String ImagenRemera(int b, File[]archivo) {
	
	return archivo[b].getName().substring(0, (archivo[b].getName().length() - 4));	
}

public String NombreRemera(int b, boolean esAlgodon, File[] archivo) {
	
	String Nombre = "Remera ".concat(archivo[b].getName().substring(0, (archivo[b].getName().length() - 7)));
	//"Remera ".concat(
	if(!esAlgodon)
	return Nombre;
	else
	return Nombre.concat(" algodon");

}
	

public void Pagina1(int b, int a, File[] archivo, int vel) {

	
	
	int e = 100 * vel;
	
	int c = 0;
	
	if(!bloqueamarillo)
		c = 2;
	
	

robot.mouseMove(1800, 200);
AutoClick.leftClick(robot);
AutoClick.Bajar(robot, 26-c);
robot.delay(e);

robot.delay(e);
robot.mouseMove(468,174);
robot.delay(e);
AutoClick.leftClick(robot);
robot.delay(e);
AutoClick.leftClick(robot);


if(b == 0) {
robot.delay(350 * vel);
direccion("algodon");
}

robot.delay(650 * vel);
keyboard.type(ImagenRemera(b,archivo));
robot.delay(300 * vel);
AutoClick.Enter(robot);


robot.delay(e);
robot.mouseMove(1800, 200);
robot.delay(e);
AutoClick.leftClick(robot);
robot.delay(e);
AutoClick.Bajar(robot, 24);

robot.mouseMove(465,174);
robot.delay(400 * vel);
AutoClick.leftClick(robot);
robot.delay(200 * vel);
AutoClick.leftClick(robot);


robot.delay(650 * vel);
keyboard.type(ImagenRemera((b+1),archivo));
robot.delay(250 * vel);

AutoClick.Enter(robot);

}

public void NombrePagina1(int b, boolean esAlgodon, File[] archivo, int vel) {
	

	int e = 300;
	int h = 500;
	robot.delay(e * vel);
	
	robot.mouseMove(600, 470);
	robot.delay(300 * vel);
	AutoClick.doubleleftClick(robot);
	AutoClick.leftClick(robot);
	robot.delay(300 * vel);	
		
	keyboard.type(NombreRemera(b, esAlgodon, archivo));
	
	

	robot.delay(200);

	autoClick.SeleccionarPalabra(robot, 1910, 700, 0, 400);
	
	
	robot.delay(h * (vel * 2));
}


public void ComisionFinal(int a, int vel) {
	

	//PRECIO ELABORACION: 
	int e = 100;
	
	robot.delay(600 * vel);

	robot.mouseMove(1800, 200);
	robot.delay(e);
	AutoClick.leftClick(robot);
	AutoClick.Bajar(robot, 15);
	robot.delay(e);
	robot.mouseMove(400, 910);
	robot.delay(e);
	AutoClick.leftClick(robot);
	

	//CLASSICA O PREMIUM
	robot.delay(1500*vel);
	robot.delay(800);
	robot.delay(800);

	
	robot.mouseMove(1000, 600);
	robot.delay(300 * vel);
	
	AutoClick.doubleleftClick(robot);
	robot.delay(100 * vel);
	robot.mouseMove(480, 750);
	robot.delay(200 * vel);
	AutoClick.leftClick(robot);
	
	
	//Confirmar Todo
	robot.delay(1500 * vel);
	robot.delay(400);
	
	robot.mouseMove(1000,750);
	robot.delay(1000);
	robot.delay(600);
	robot.delay(1000);
	AutoClick.leftClick(robot);
	robot.delay(1000*vel);
	robot.delay(900);
	
	
}

public void EsAlgodon() {
	
	robot.delay(1500);
	robot.mouseMove(1800, 200);
	AutoClick.doubleleftClick(robot);
	robot.delay(800);
	AutoClick.Bajar(robot, 80);
	robot.delay(800);
	robot.mouseMove(1800, 200);
	robot.delay(200);
	AutoClick.doubleleftClick(robot);
	
	AutoClick.Subir(robot, 3);

	 robot.delay(450);
		robot.mouseMove(540, 450);
		 robot.delay(450);
		AutoClick.leftClick(robot);
		AutoClick.doubleleftClick(robot);
		 robot.delay(450);
		keyboard.type("Algodon Peinado");
		
		subirTop();
}



public boolean errorML() throws HeadlessException, IOException, Exception {
	
	
	try {	
		robot = new Robot();
		
	} catch (AWTException e) {	
		e.printStackTrace();	
	}
	
	int e = 100;
	
	
	robot.mouseMove(700, 340);
	AutoClick.doubleleftClick(robot);
	robot.delay(500);
	AutoClick.Copiar(robot);
	robot.delay(200);
	
	
	robot.delay(200);
	AutoClick.Copiar(robot);
	robot.delay(200);
	
	robot.delay(200);
	boolean a;
	String data = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
	System.out.print("******LA COPIA ES: " + data);
	if(data.equalsIgnoreCase("producto") || data.equalsIgnoreCase("producto ") || data.equalsIgnoreCase(" producto"))
	a = true;
	else
		a = false;
	
	
	robot.delay(300);
	return a;
	
}

public boolean BloqueAmarillo() throws HeadlessException, UnsupportedFlavorException, IOException {

	robot.delay(800);
	robot.delay(800);
	robot.delay(1200);
	robot.mouseMove(1700, 450);
	AutoClick.leftClick(robot);
	
	robot.delay(1500);
	robot.mouseMove(700, 250);
	robot.delay(800);
	AutoClick.doubleleftClick(robot);
	robot.delay(1500);
	AutoClick.Copiar(robot);
	boolean a;
	String data = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
	
	if(data.equalsIgnoreCase("delito"))
		a = true;
		else
			a = false;
		return a;
}


public void subirTop() {
	
	
	
	try {	
		robot = new Robot();
		
	} catch (AWTException e) {	
		e.printStackTrace();	
	}
	
	robot.mouseMove(1910, 1000);
	robot.delay(100);
	AutoClick.SeleccionarPalabra(robot, 1910, 1000, 0, -900);
	
}





private void direccion(String ruta) {
	
	
	
	try {	
		robot = new Robot();
		keyboard = new Keyboard();
	} catch (AWTException e) {	
		e.printStackTrace();	
	}
	
	robot.delay(600);
	robot.mouseMove(100, 175);
	robot.delay(300);
	AutoClick.leftClick(robot);
	
	robot.mouseMove(450, 978);
	robot.delay(300);
	autoClick.leftClick(robot);
	robot.delay(300);
	keyboard.type(ruta);
	robot.delay(300);
	AutoClick.Enter(robot);
}


public void arreglarError(int vel)	{
	
	
	try {	
		robot = new Robot();
	} catch (AWTException e) {
		e.printStackTrace();	
	}
	
	robot.delay(500);
	robot.mouseMove(300, 15);
	robot.delay(450);
	AutoClick.leftClick(robot);
	
	robot.mouseMove(350, 50);
	robot.delay(800);
	AutoClick.leftClick(robot);	
	robot.delay(800);
	AutoClick.Copiar(robot);
	robot.delay(800);
	
	robot.mouseMove(1700, 400);
	robot.delay(600);
	AutoClick.leftClick(robot);
	robot.delay(800);
	robot.mouseMove(100, 15);
	AutoClick.leftClick(robot);
	robot.delay(800);
	robot.mouseMove(350, 50);
	AutoClick.leftClick(robot);	
	robot.delay(800);
	AutoClick.Pegar(robot);
	robot.delay(800);
	AutoClick.Enter(robot);
	robot.delay(1500);
	robot.delay(1500);
	robot.delay(800);
	
	
	robot.mouseMove(1520, 550);
	robot.delay(500);
	AutoClick.leftClick(robot);
	robot.delay(800);		
	robot.mouseMove(1480,690);
	robot.delay(800);
	AutoClick.leftClick(robot);
	robot.delay(1500);
	robot.delay(800);
	robot.delay(800);
	robot.mouseMove(1700, 400);
	robot.delay(600);
	AutoClick.leftClick(robot);
	robot.delay(800);
	robot.delay(1000 * vel);
	robot.delay(1000);
}



public boolean getBloqueamarillo(boolean bloqueamarillo) {
	
	return bloqueamarillo;
}

private void confirmarImagen() {
	
	try {	
		robot = new Robot();
		keyboard = new Keyboard();
	} catch (AWTException e) {	
		e.printStackTrace();	
	}
	
	robot.delay(300);
	robot.mouseMove(400, 920);
	robot.delay(500);
	AutoClick.leftClick(robot); //ConfirmarProductoPagina1

	robot.delay(800);
	robot.delay(1500);
}


private boolean errorImagen() throws HeadlessException, UnsupportedFlavorException, IOException {
	try {	
		robot = new Robot();
	} catch (AWTException e) {	
		e.printStackTrace();	
	}
	

	
	
	robot.mouseMove(478, 450);
	robot.delay(200);
	
	
	AutoClick.doubleleftClick(robot);
	AutoClick.Copiar(robot);
	
	
	boolean a;
	String data = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
	
	if(data.equalsIgnoreCase("agregar") || data.equalsIgnoreCase("agregar ")) {
		System.out.print("La imagen cargo perfectamente");
		return true;

	}
	else {
		System.out.print("La imagen No cargo");
		return false;
	
	}
}




public void precio(boolean esAlgodon) {
	

	try {	
		robot = new Robot();
		keyboard = new Keyboard();
	} catch (AWTException e) {	
		e.printStackTrace();	
	}
	
	robot.delay(300);
	robot.mouseMove(520, 310);
	robot.delay(900);
	AutoClick.doubleleftClick(robot);
	
	if(esAlgodon)
		keyboard.type("390");
	else
		keyboard.type("290");
	
}


public void Variantes(int i, int vel) {
	

	try {	
		robot = new Robot();
		keyboard = new Keyboard();
	} catch (AWTException e) {	
		e.printStackTrace();	
	}
	
	
	int e = 80 * vel;
	int EliminarX = 1480;
	int EliminarY = 435;
	
	//VARIANTE1
	
	
	robot.delay(300);
	
	robot.mouseMove(1480, 430);
	robot.delay(300);
	AutoClick.leftClick(robot);	
	robot.delay(100);
	
	
	//Subir a primera Variante
	
	robot.mouseMove(1700, 295);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	AutoClick.Subir(robot,40);	
	
	
	//Eliminar variantes restantes
	robot.delay(e);
	robot.mouseMove(1480, 430);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	AutoClick.leftClick(robot);	
	
	//Subir a primera Variante
		
		robot.mouseMove(1700, 300);
		robot.delay(e);
		AutoClick.leftClick(robot);
		robot.delay(e);
		AutoClick.Subir(robot,70);	
		
       //*xxL************EMPIEZAN LAS GRISES
	
	robot.delay(e);
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	AutoClick.Bajar(robot,16);	
	robot.delay(e);
	robot.mouseMove(1480, 430);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);

	//AGREGAR LOS TALLES EN BLANCO***********************************************
	
	robot.delay(400);
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(300);
	AutoClick.Subir(robot,26);		
	robot.delay(e);
	AutoClick.Bajar(robot,1);	
	
	

	robot.delay(e);
	robot.mouseMove(450, 736);  // + Agregar Talle XL +70
	robot.delay(e);
	AutoClick.leftClick(robot);
	
	
	
	robot.delay(e);
	robot.mouseMove(450, 806);  // + Agregar Talle L +70
	robot.delay(e);
	AutoClick.leftClick(robot);
	
	
	
	
	robot.delay(e);
	robot.mouseMove(450, 869);  // + Agregar Talle M +70
	robot.delay(e);
	AutoClick.leftClick(robot);
	


	robot.delay(e);
	robot.mouseMove(450, 932);  // + Agregar Talle S +70
	robot.delay(e);
	AutoClick.leftClick(robot);
	



	robot.delay(e);
	robot.mouseMove(450, 996);  // + Agregar Talle S +70
	robot.delay(e);
	AutoClick.leftClick(robot);

	
	//*************************PONER LOS TALLES S Al XXL EN BLANCO *********************************************
	 
	 
	robot.delay(e);
	
	robot.mouseMove(400, 691); 
	robot.delay(e);
	AutoClick.doubleleftClick(robot);
	
	robot.delay(e);
	keyboard.type("XXl");
	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	
	

	robot.delay(e);
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	AutoClick.Subir(robot,30);	
	robot.delay(e);
	AutoClick.Bajar(robot,1);	
	
	
	robot.delay(250);
	
	robot.mouseMove(450, 758); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("XL");
	robot.delay(e);
	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	
	
	
	
	
	
	
	
	robot.mouseMove(600, 758);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);
	
	
	
	
	robot.mouseMove(450, 825); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("L");
	robot.delay(e);
	robot.mouseMove(600, 825);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);

	
	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	
	
	
	robot.mouseMove(450, 892); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("M");
	robot.delay(e);
	robot.mouseMove(600, 892);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);
	
	
	
	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	
	
	
	robot.mouseMove(450, 959); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("S");
	robot.delay(e);
	robot.mouseMove(600, 959);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);
	
	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	
	
	robot.mouseMove(450, 1026); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("XS");
	robot.delay(e);
	robot.mouseMove(600, 1026);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);

	
	robot.delay(150);
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	AutoClick.Subir(robot,20);	 	
	robot.delay(e);
	AutoClick.Bajar(robot,25);	
	

	//AGREGAR TALLES AL GRIS///////////////////////////////
	
	robot.delay(e);
	robot.mouseMove(450, 740);

	
	robot.delay(e);
	robot.mouseMove(450, 740);  // + Agregar Talle XL +70
	robot.delay(e);
	AutoClick.leftClick(robot);
	
	
	
	robot.delay(e);
	robot.mouseMove(450, 810);  // + Agregar Talle L +70
	robot.delay(e);
	AutoClick.leftClick(robot);
	
	
	
	
	robot.delay(e);
	robot.mouseMove(450, 873);  // + Agregar Talle M +70
	robot.delay(e);
	AutoClick.leftClick(robot);
	


	robot.delay(e);
	robot.mouseMove(450, 936);  // + Agregar Talle S +70
	robot.delay(e);
	AutoClick.leftClick(robot);
	



	robot.delay(e);
	robot.mouseMove(450, 1000);  // + Agregar Talle XS +70
	robot.delay(e);
	AutoClick.leftClick(robot);
	
	
	
	//*************************PONER LOS TALLES S Al XXL EN GRIS *********************************************
	 
	 
		robot.delay(e);
		
		robot.mouseMove(400, 691); 
		robot.delay(e);
		AutoClick.doubleleftClick(robot);
		
		robot.delay(e);
		keyboard.type("XXl");
		
		robot.mouseMove(1700, 300);
		robot.delay(e);
		AutoClick.leftClick(robot);
		robot.delay(e);
		
		
		robot.delay(e);
		robot.mouseMove(1700, 300);
		robot.delay(e);
		AutoClick.leftClick(robot);
		robot.delay(e);
		AutoClick.Subir(robot,10);	
		
		
		
	 
	robot.delay(e);
	
	robot.mouseMove(450, 758); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("XL");
	robot.delay(e);

	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	
	

	
	robot.mouseMove(600, 758);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);
	
	
	
	
	
	robot.delay(e);
	robot.mouseMove(450, 825); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("L");
	robot.delay(e);
	robot.mouseMove(600, 825);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);
	
	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	
	
	
	robot.mouseMove(450, 892); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("M");
	robot.delay(e);
	robot.mouseMove(600, 892);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);
	
	
	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	
	
	
	robot.mouseMove(450, 959); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("S");
	robot.delay(e);
	robot.mouseMove(600, 959);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);
	
	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	
	
	
	robot.mouseMove(450, 1026); 
	robot.delay(e);
	AutoClick.leftClick(robot);
	keyboard.type("XS");
	robot.delay(e);
	robot.mouseMove(600, 1026);
	robot.delay(e);
	AutoClick.leftClick(robot);	
	robot.delay(e);
	keyboard.type("99");
	robot.delay(e);
	
	robot.mouseMove(1700, 300);
	robot.delay(e);
	AutoClick.leftClick(robot);
	robot.delay(e);
	

	AutoClick.Subir(robot, 35);
	
}




public void pruebas() {
	
	try {	
		robot = new Robot();
		keyboard = new Keyboard();
	} catch (AWTException e) {	
		e.printStackTrace();	
	}
	
	
	robot.mouseMove(1520, 550);
}



}
