package modelo;

import java.awt.Color;

// Java program for implementation of FCFS 
// scheduling 

import java.text.ParseException;

import vista.VentanaFCFS;

public class FCFS { 
	
	private VentanaFCFS ventanaFCFS;
	
	private Color [] colores;
	
	public FCFS(VentanaFCFS ventanaFirstComeFirstServed, int cantidad)
	{
	
		ventanaFCFS = ventanaFirstComeFirstServed;
		
		colores = new Color [cantidad];
		
		for (int i = 0; i < colores.length; i++) 
		{
			colores [i] = (new Color(((int) Math.floor(Math.random()*(255-1+1)+1)), ((int) Math.floor(Math.random()*(255-1+1)+1)), ((int) Math.floor(Math.random()*(255-1+1)+1))));
		}
	}

	//Método para encontrar el tiempo de espera
	public void findWaitingTime(int processes[], int n, 
			int bt[], int wt[]) { 
		// waiting time for first process is 0 
		wt[0] = 0; 

		// calculating waiting time 
		for (int i = 1; i < n; i++) { 
			wt[i] = bt[i - 1] + wt[i - 1]; 
		} 
	} 

	//Método para encontrar el tiempo de retorno 
	public void findTurnAroundTime(int processes[], int n, 
			int bt[], int wt[], int tat[]) { 
		int b = 0;

		// Se calcula el tiempo de retorno sumando el tiempo de ejecución con el tiempo de espera 
		for (int i = 0; i < n; i++) 
		{ 
			tat[i] = bt[i] + wt[i]; 
			ventanaFCFS.getAreaOrden().setText(ventanaFCFS.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i + 1) + " entra en ejecución con " + bt[i] + "ms de ejecución restantes");
			for (int j = 0; j < bt[i]; j++) 
			{
				ventanaFCFS.getMatrizBotones()[i][b].setBackground(colores[i]);
				b++;
			}
			ventanaFCFS.getAreaOrden().setText(ventanaFCFS.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i + 1) + " ejecuta todo su tiempo");
			ventanaFCFS.getAreaOrden().setText(ventanaFCFS.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i + 1) + " acaba su ejecución");
		} 
	} 

	// Método para calcular los tiempos promedio (Tiempo de retorno promedio y tiempo de espera promedio)
	public void findavgTime(int processes[], int n, int bt[]) { 
		int wt[] = new int[n], tat[] = new int[n]; 
		int total_wt = 0, total_tat = 0; 

		findWaitingTime(processes, n, bt, wt); 

		findTurnAroundTime(processes, n, bt, wt, tat); 

		// Despliega los procesos con sus respectivos resultados despues de ejecutado el algoritmo 
		ventanaFCFS.getAreaTabla().setText(ventanaFCFS.getAreaTabla().getText() + "\n\n" + "Procesos " + " Tiempo de ejecución " + " Tiempo de espera " + " Tiempo de retorno"); 

		for (int i = 0; i < n; i++) { 
			total_wt = total_wt + wt[i]; 
			total_tat = total_tat + tat[i]; 
			ventanaFCFS.getAreaTabla().setText(ventanaFCFS.getAreaTabla().getText() + "\n" + " " + (i+1) + "\t\t" + bt[i] +"\t\t " + wt[i] +"\t\t" + tat[i]); 

		} 
		float s = (float)total_wt /(float) n; 
		int t = total_tat / n; 
		
		// Despliega los tiempos promedio (Tiempo de retorno promedio y tiempo de espera promedio)	
		ventanaFCFS.getAreaTabla().setText(ventanaFCFS.getAreaTabla().getText() + "\n\n");
		ventanaFCFS.getAreaTabla().setText(ventanaFCFS.getAreaTabla().getText() + "Tiempo de espera promedio = " + Float.toString(s)); 
		ventanaFCFS.getAreaTabla().setText(ventanaFCFS.getAreaTabla().getText() + "\n"); 
		ventanaFCFS.getAreaTabla().setText(ventanaFCFS.getAreaTabla().getText() +"Tiempo de retorno promedio = " + Float.toString(t)); 
	} 

} 

