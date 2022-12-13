package modelo;

import java.awt.Color;
import java.util.*;

import vista.VentanaSJF;

public class SJF {

	private VentanaSJF ventanaSJF;

	private Color [] colores;

	public SJF(VentanaSJF ventanaShortestJobFirst, int cantidad)
	{

		ventanaSJF = ventanaShortestJobFirst;

		colores = new Color [cantidad];

		for (int i = 0; i < colores.length; i++) 
		{
			colores [i] = (new Color(((int) Math.floor(Math.random()*(255-1+1)+1)), ((int) Math.floor(Math.random()*(255-1+1)+1)), ((int) Math.floor(Math.random()*(255-1+1)+1))));
		}
	}

	public void solveSJF(int procesos [], int cantidad, int tiempo []) {
		int b = 0;
		int BT[];
		int WT[];
		int TAT[];

		BT = new int[cantidad + 1];
		WT = new int[cantidad + 1];
		TAT = new int[cantidad + 1];

		for (int i = 0; i < cantidad; i++) {
			BT[i] = tiempo[i];
		}

		float AWT = 0;
		float ATAT = 0;

		for (int i = 0; i < cantidad; i++) {
			WT[i] = 0;
			TAT[i] = 0;
		}
		int temp;
		
		// Reorganiza los procesos
		ventanaSJF.getAreaOrden().setText(ventanaSJF.getAreaOrden().getText() + "\n" + "Se organizan los procesos de menor a mayor" +  "\n" + "Los procesos mas cortos quedan al inicio de la cola");
		for (int i = 0; i < cantidad; i++) {
			for (int j = 0; j < cantidad - 1; j++) {
				if (BT[j] > BT[j + 1]) {
					temp = BT[j];
					BT[j] = BT[j + 1];
					BT[j + 1] = temp;

					temp = procesos[j];
					procesos[j] = procesos[j+1];
					procesos[j+1] = temp;

					temp = WT[j];
					WT[j] = WT[j + 1];
					WT[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < cantidad; i++) {
			TAT[i] = BT[i] + WT[i];
			ventanaSJF.getAreaOrden().setText(ventanaSJF.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i + 1) + " entra en ejecución con " + BT[i] + "ms de ejecución restantes");
			for (int j = 0; j < BT[i]; j++) 
			{
				ventanaSJF.getMatrizBotones()[(procesos[i] - 1)][b].setBackground(colores[i]);
				b++;
			}
			ventanaSJF.getAreaOrden().setText(ventanaSJF.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i + 1) + " ejecuta todo su tiempo");
			ventanaSJF.getAreaOrden().setText(ventanaSJF.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i + 1) + " acaba su ejecución");
			WT[i + 1] = TAT[i];
		}

		// Despliega los procesos con sus respectivos resultados despues de ejecutado el algoritmo
		TAT[cantidad] = WT[cantidad] + BT[cantidad];
		ventanaSJF.getAreaTabla().setText(ventanaSJF.getAreaTabla().getText() + "\n\n" + "Procesos " + " Tiempo de ejecución " + " Tiempo de espera " + " Tiempo de retorno");
		for (int i = 0; i < cantidad; i++)
			ventanaSJF.getAreaTabla().setText(ventanaSJF.getAreaTabla().getText() + "\n " + procesos[i] + "\t\t" + BT[i] + "\t\t" + WT[i] + "\t\t" + TAT[i]);

		// Calcula los tiempos promedio (Tiempo de retorno promedio y tiempo de espera promedio)
		for (int j = 0; j < cantidad; j++)
			AWT += WT[j];
		for (int i = 0; i < cantidad; i++) 
		{
			ATAT += TAT[i];
		}

		AWT = AWT / cantidad;
		ATAT = ATAT / cantidad;

		// Despliega los tiempos promedio (Tiempo de retorno promedio y tiempo de espera promedio)	
		ventanaSJF.getAreaTabla().setText(ventanaSJF.getAreaTabla().getText() + "\n\n");
		ventanaSJF.getAreaTabla().setText(ventanaSJF.getAreaTabla().getText() + "Tiempo de retorno promedio = " + ATAT);
		ventanaSJF.getAreaTabla().setText(ventanaSJF.getAreaTabla().getText() + "\n"); 
		ventanaSJF.getAreaTabla().setText(ventanaSJF.getAreaTabla().getText() + "Tiempo de espera promedio = " + AWT);
	}
}