package modelo;

import java.awt.Color;

import vista.VentanaSRTF;

// Shortest Remaining Time First (SRTF) 

class Process 
{ 
	int pid; // Nombre del proceso 
	int bt; // Tiempo de ejecución
	int art; // Tiempo de llegada

	public Process(int pid, int bt, int art) 
	{ 
		this.pid = pid; 
		this.bt = bt; 
		this.art = art; 
	} 
} 

public class SRTF 
{ 

	private VentanaSRTF ventanaSRTF;

	private Color [] colores;

	int b = 0;

	public SRTF(VentanaSRTF ventanaShortestRemainingTimeFirst, int cantidad, int procesos[], int tiempos[], int llegada[])
	{

		ventanaSRTF = ventanaShortestRemainingTimeFirst;

		Process proc[] = new Process[cantidad];
		int procesosA[] = procesos;
		int tiemposA[] = tiempos;
		int llegadaA[] = llegada;

		colores = new Color [cantidad];

		for (int i = 0; i < colores.length; i++) 
		{
			colores [i] = (new Color(((int) Math.floor(Math.random()*(255-1+1)+1)), ((int) Math.floor(Math.random()*(255-1+1)+1)), ((int) Math.floor(Math.random()*(255-1+1)+1))));
		}

		for (int i = 0; i < proc.length; i++) 
		{
			proc[i] = new Process(procesosA[i], tiemposA[i], llegadaA[i]);
		}

		findavgTime(proc, proc.length);
	}

	//Método para encontrar el tiempo de espera
	public void findWaitingTime(Process proc[], int n, 
			int wt[]) 
	{ 
		int rt[] = new int[n]; 

		for (int i = 0; i < n; i++) 
			rt[i] = proc[i].bt; 

		int complete = 0, t = 0, minm = Integer.MAX_VALUE; 
		int shortest = 0, finish_time; 
		boolean check = false; 

		// Se ejecuta mientras todos los procesos completan su ejecución
		while (complete != n) { 

			// Busca el proceso con el minimo tiempo de ejecución incluyendo los procesos que llegan en el instante de tiempo
			for (int j = 0; j < n; j++) 
			{ 
				if ((proc[j].art <= t) && 
						(rt[j] < minm) && rt[j] > 0) { 
					minm = rt[j]; 
					shortest = j; 
					check = true; 
				} 
			} 

			if (check == false) 
			{ 
				t++; 
				continue; 
			} 

			// Reduce el tiempo de ejecución un ms a la vez
			rt[shortest]--; 
			ventanaSRTF.getAreaOrden().setText(ventanaSRTF.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (shortest + 1) + " ejecuta un ms, le queda " + rt[shortest] + "ms de ejecución restantes");
			ventanaSRTF.getMatrizBotones()[shortest][b].setBackground(colores[shortest]);
			b++;

			minm = rt[shortest]; 
			if (minm == 0) 
				minm = Integer.MAX_VALUE; 

			// Si un proceso se ejecuta por completo actualiza la cantidad de procesos completos aumentandola en 1
			if (rt[shortest] == 0) { 
				ventanaSRTF.getAreaOrden().setText(ventanaSRTF.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (shortest + 1) + " acaba su ejecución");
				complete++; 
				check = false; 

				// Tiempo de finalización del proceso actual
				finish_time = t + 1; 

				// Calcula el tiempo de espera
				wt[shortest] = finish_time - 
						proc[shortest].bt - 
						proc[shortest].art; 

				if (wt[shortest] < 0) 
					wt[shortest] = 0; 
			} 
			t++; 
		} 
	} 

	// Método para encontrar el tiempo de retorno
	static void findTurnAroundTime(Process proc[], int n, 
			int wt[], int tat[]) 
	{ 
		// Se calcula el tiempo de retorno sumando el tiempo de ejecución con el tiempo de espera 
		for (int i = 0; i < n; i++) 
			tat[i] = proc[i].bt + wt[i]; 
	} 

	// Método para calcular los tiempos promedio (Tiempo de retorno promedio y tiempo de espera promedio)
	public void findavgTime(Process proc[], int n) 
	{ 
		int wt[] = new int[n], tat[] = new int[n]; 
		int total_wt = 0, total_tat = 0; 

		findWaitingTime(proc, n, wt); 

		findTurnAroundTime(proc, n, wt, tat); 

		// Calcula los tiempos promedio (Tiempo de retorno promedio y tiempo de espera promedio) y despliega los procesos con sus respectivos resultados despues de ejecutado el algoritmo
		ventanaSRTF.getAreaTabla().setText(ventanaSRTF.getAreaTabla().getText() + "\n\n" + "Procesos " + " Tiempo de ejecución " +  " Tiempo de llegada " + " Tiempo de espera " + " Tiempo de retorno"); 
		for (int i = 0; i < n; i++) 
		{ 
			total_wt = total_wt + wt[i]; 
			total_tat = total_tat + tat[i]; 
			ventanaSRTF.getAreaTabla().setText(ventanaSRTF.getAreaTabla().getText() + "\n" + " " + proc[i].pid + "\t" + proc[i].bt + "\t\t " + proc[i].art + "\t\t " + wt[i] + "\t\t" + tat[i]); 
		}

		// Despliega los tiempos promedio (Tiempo de retorno promedio y tiempo de espera promedio)	
		ventanaSRTF.getAreaTabla().setText(ventanaSRTF.getAreaTabla().getText() + "\n\n");
		ventanaSRTF.getAreaTabla().setText(ventanaSRTF.getAreaTabla().getText() + "Tiempo de espera promedio = " + (float)total_wt / (float)n); 
		ventanaSRTF.getAreaTabla().setText(ventanaSRTF.getAreaTabla().getText() + "\n"); 
		ventanaSRTF.getAreaTabla().setText(ventanaSRTF.getAreaTabla().getText() + "Tiempo de espera promedio = " + (float)total_tat / (float)n); 
	} 

} 
