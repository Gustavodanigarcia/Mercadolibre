

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NullPointerException;
import java.sql.Driver;

import javax.swing.JOptionPane;

import javaRobot.AutoClick;



public class PublicarBuzos extends KeyAdapter {
	
	
	
	public static void main(String[] args) throws Exception{  //MetodoMain
		PublicarBuzos Crea = new PublicarBuzos();		
		
		Crea.PublicacionNueva();
		
	}
	
	
	public Robot robot;
	public AutoClick autoClick;
	public Runtime runtime;
	
	public Keyboard keyboard;
	
	File folder = new File("C:\\Users\\gustavo\\Desktop\\SUMAR");
	File[] lista = folder.listFiles();	
	
	
	
	
	public void PublicacionNueva() throws Exception {
		
		runtime = Runtime.getRuntime();
		keyboard = new Keyboard();
		
		
		try {	
			robot = new Robot();
		} catch (AWTException e) {	
			e.printStackTrace();	
		}
		ProductoBuzo();
	
	}

	

	public void ProductoBuzo() throws HeadlessException, IOException, Exception {

		int a = 0;
		
		AutoClick.CambiarPantalla(robot);
		
	
		
		
		//Publicar1(a,1); 
		 //robot.mouseMove(462, 245);
		
		//sin bloque robot.mouseMove(462, 160);
		//Publicar1(a,1);  
		
		boolean bloqueamarillo = true;
		boolean huboerror = false;
		int huboerrorConfirmado = 0;
		String[] ProductosSubidos = new String[lista.length];
		
		
		for(int i=0; i<lista.length;i++) {
		
		//DENTRO DE PUBLICACION
			
			if(huboerrorConfirmado == 1) {
			if(!BloqueAmarillo()) {
				bloqueamarillo = false;
				
			}
			else { 
				bloqueamarillo = true;
				
				
				}
                 }
			huboerror = false;

			Publicar1(a,1,bloqueamarillo); //Publicar producto
			NombreProducto(a,1,bloqueamarillo);  //nombre producto
			Pagina2y3(1);
			
			if(!errorML()) {
				arreglarError();
				huboerror = true;
				huboerrorConfirmado = 1;
				System.out.println("el archivo: "+ lista[i].getName() + " no se publico");
				i--;
			}else {
				lista[i].delete();
				ProductosSubidos[i] = lista[i].getName();
				System.out.println("el archivo: "+ lista[i].getName() + " se publico EXITOSAMENTE!!");
				subirTop();
				a = a + 1;
				
				
			}

		
			
			}
		
		
	
		
		
		
		}
		
		

		
	
	
	




	public void Publicar1(int a,int velocidad, boolean c) {

	int b = velocidad;
	int bloc = 0;
	
	if(c == false) {
		bloc = 85;
		}	
	

	robot.delay(1500/b);
	
	
	robot.delay(800);
	robot.mouseMove(1800, 200);
	AutoClick.leftClick(robot);
	robot.delay(100/b);
	AutoClick.Bajar(robot, 24);
	robot.delay(1200/b);
	
	
	robot.mouseMove(462,(245-bloc));
	AutoClick.leftClick(robot);
	robot.delay(250/b);
	AutoClick.leftClick(robot);
	robot.delay(900/b);
	robot.delay(1500/b);
	String cadena = lista[a].getName().substring(0, (lista[a].getName().length() - 4));
	robot.delay(800/b);
	
	keyboard.type(cadena);
	robot.delay(400/b);
	AutoClick.Enter(robot);

	}
	
	
	public void NombreProducto(int a, int velocidad, boolean bloqueamarillo) {
		
		int b = velocidad;
		int bloc = 0;
		
		robot.delay(900/b);
		
		
		if(!bloqueamarillo) {
		bloc = 85;
		}
		
		robot.mouseMove(600, (650-bloc));	
		robot.delay(500);
		AutoClick.leftClick(robot);
		AutoClick.doubleleftClick(robot);
		robot.delay(400);
		
		String cadena2 = "Buzo canguro ".concat(lista[a].getName().substring(0, (lista[a].getName().length() - 4)));
		String cadena3 = lista[a].getName().substring(0, (lista[a].getName().length() - 4));	
		robot.delay(800);
		if(lista[a].length()<990000)
		keyboard.type(cadena2);
		else
		keyboard.type(cadena2);
		
		robot.delay(600);
		robot.mouseMove(1800, 200);
		robot.delay(600);
		AutoClick.leftClick(robot);
		robot.delay(50);
		AutoClick.leftClick(robot);
		AutoClick.leftClick(robot);
		robot.delay(50);
		AutoClick.leftClick(robot);
		robot.delay(1000/b);
		AutoClick.Bajar(robot, 20);
			
		
		robot.delay(800/b);
		robot.mouseMove(400, 920);
		robot.delay(500);
		AutoClick.leftClick(robot);
	}
	
	
	public void Pagina2y3(int velocidad) {
		
		
		int b = velocidad;
		
		//PRECIO ELABORACION: 
		
		robot.delay(900);
		robot.delay(1500/b);
		robot.delay(800);
		robot.mouseMove(1800, 200);
		robot.delay(200);
		AutoClick.leftClick(robot);
		AutoClick.Bajar(robot, 15);
		robot.delay(300);
		robot.mouseMove(400, 910);
		robot.delay(400);
		AutoClick.leftClick(robot);
		

		//CLASSICA O PREMIUM
		robot.delay(1000/b);
		robot.delay(800);
		robot.delay(900);
		robot.delay(900);
		
		
		robot.mouseMove(1000, 600);
		robot.delay(1000/b);
		robot.delay(500);
		AutoClick.doubleleftClick(robot);

		robot.delay(400);
		robot.mouseMove(480, 750);
		robot.delay(1000);

		AutoClick.leftClick(robot);
		
		
		//Confirmar Todo
		robot.delay(1500/b);
		robot.delay(800);
		robot.delay(1500);
		robot.mouseMove(1000,750);
		robot.delay(1000);
		robot.delay(500);
		robot.delay(900);
		AutoClick.leftClick(robot);
		robot.delay(1500/b);
	
		robot.delay(1000);
		
		
	}
	
	
	





	public void keyPressed(KeyEvent event) {
		 
		  char ch = event.getKeyChar();
		 
		  if (ch == '5') {
		 
			  System.exit(1);
		 
		  }
	 }

	
	
	
		public boolean errorML() throws HeadlessException, IOException, Exception {
			
			robot.delay(1500);
			robot.delay(900);
			robot.mouseMove(1700, 600);
			robot.delay(1000);
			AutoClick.leftClick(robot);
			AutoClick.Bajar(robot, 50);
			robot.delay(1000);
			robot.mouseMove(590, 760);	
			AutoClick.doubleleftClick(robot);
			robot.delay(900);
			AutoClick.Copiar(robot);
			robot.delay(900);
			
			boolean a;
			String data = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
			
			if(data.equalsIgnoreCase("producto"))
			a = true;
			else
				a = false;
			
			return a;
			
	}
		
		public boolean BloqueAmarillo() throws HeadlessException, UnsupportedFlavorException, IOException {
		
			robot.delay(800);
			robot.delay(1500);
			robot.delay(800);
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
			robot.mouseMove(1700, 300);
			robot.delay(800);
			AutoClick.leftClick(robot);
			robot.delay(800);
			autoClick.Subir(robot, 50);
			robot.delay(800);
			
		}
		
		
		public void arreglarError()	{
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
			autoClick.Pegar(robot);
			robot.delay(800);
			AutoClick.Enter(robot);
			robot.delay(1500);
			robot.delay(1500);
			robot.delay(800);
			
			
			robot.mouseMove(1520, 640);
			robot.delay(500);
			autoClick.leftClick(robot);
			robot.delay(800);		
			robot.mouseMove(1480,780);
			robot.delay(800);
			autoClick.leftClick(robot);
		}





	














}

class EventodeTeclado3 implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int codigo = e.getKeyCode();
		if(codigo == KeyEvent.VK_ESCAPE) {
			System.out.println("se termino");
			System.exit(0);
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
				
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

