package modelo;

import java.awt.Color;

import vista.VentanaRoundRobin;

public class RoundRobin 
{ 
	
	private VentanaRoundRobin ventanaRR;
	
	private Color [] colores;
	
	public RoundRobin(VentanaRoundRobin ventanaRoundRobin, int cantidad)
	{
		ventanaRR = ventanaRoundRobin;
		
		colores = new Color [cantidad];
		
		for (int i = 0; i < colores.length; i++) 
		{
			colores [i] = (new Color(((int) Math.floor(Math.random()*(255-1+1)+1)), ((int) Math.floor(Math.random()*(255-1+1)+1)), ((int) Math.floor(Math.random()*(255-1+1)+1))));
		}
	}
	
	//Método para encontrar el tiempo de espera
	public void findWaitingTime(int processes[], int n, 
			int bt[], int wt[], int quantum) 
{ 
	int b = 0;

	int rem_bt[] = new int[n]; 
	for (int i = 0 ; i < n ; i++) 
		rem_bt[i] = bt[i]; 

	int t = 0; // Current time 

	// Se ejecuta mientras todos los procesos completan su ejecución
	while(true) 
	{ 
		boolean done = true; 

		for (int i = 0 ; i < n; i++) 
		{ 
			
			// Se ejecuta si el tiempo restante del proceso actual es mayor a 0
			if (rem_bt[i] > 0) 
			{ 
				done = false;

				// Se ejecuta si el tiempo del proceso actual es igual a un quantum
				if (rem_bt[i] > quantum) 
				{ 

					// Incrementa el tiempo transcurrido en un quantum
					t += quantum; 

					// Reduce el tiempo restante de ejecucion en un quantum
					ventanaRR.getAreaOrden().setText(ventanaRR.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i+1) + " entra en ejecución con " + rem_bt[i] + "ms de ejecución restantes");
					rem_bt[i] -= quantum;
					
					for (int j = 0; j < quantum; j++) 
					{
						ventanaRR.getMatrizBotones()[i][b].setBackground(colores[i]);
						b++;
					}

					ventanaRR.getAreaOrden().setText(ventanaRR.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i + 1) + " ejecuta un quantum, le queda " + rem_bt[i] + "ms de ejecución restantes");
					
				} 

				// Se ejecuta si el tiempo restante del proceso es menor o igual a un quantum
				else
				{ 

					// Incrementa el tiempo transcurrido en el tiempo de ejecución restante
					t = t + rem_bt[i]; 

					wt[i] = t - bt[i]; 
					ventanaRR.getAreaOrden().setText(ventanaRR.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i+1) + " entra en ejecución " + rem_bt[i] + "ms restantes de ejecución ");
					ventanaRR.getAreaOrden().setText(ventanaRR.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i + 1) + " ejecuto sus " + rem_bt[i] + "ms de ejecución restantes");
					for (int j = 0; j < rem_bt[i]; j++) 
					{
						ventanaRR.getMatrizBotones()[i][b].setBackground(colores[i]);
						b++;
					}
					// El proceso se termina de ejecutar
					rem_bt[i] = 0;
					ventanaRR.getAreaOrden().setText(ventanaRR.getAreaOrden().getText() + "\n" + "El proceso " + "P" + (i+1) + " termino su ejecución");
				} 
			} 
		} 

		if (done == true) 
		break; 
	} 
} 

//Método para encontrar el tiempo de retorno
public void findTurnAroundTime(int processes[], int n, 
						int bt[], int wt[], int tat[]) 
{ 

	// Se calcula el tiempo de retorno sumando el tiempo de ejecución con el tiempo de espera 
	for (int i = 0; i < n ; i++) 
		tat[i] = bt[i] + wt[i]; 
} 

// Método para calcular los tiempos promedio (Tiempo de retorno promedio y tiempo de espera promedio)
public void findavgTime(int processes[], int n, int bt[], 
									int quantum) 
{ 
	int wt[] = new int[n], tat[] = new int[n]; 
	int total_wt = 0, total_tat = 0; 

	findWaitingTime(processes, n, bt, wt, quantum); 

	findTurnAroundTime(processes, n, bt, wt, tat); 

	// Despliega los procesos con sus respectivos resultados despues de ejecutado el algoritmo
	ventanaRR.getAreaTabla().setText(ventanaRR.getAreaTabla().getText() + "\n\n" + "Procesos " + " Tiempo de ejecución " + " Tiempo de espera " + " Tiempo de retorno"); 

	for (int i=0; i<n; i++) 
	{ 
		total_wt = total_wt + wt[i]; 
		total_tat = total_tat + tat[i]; 
		ventanaRR.getAreaTabla().setText(ventanaRR.getAreaTabla().getText() + "\n" + " " + (i+1) + "\t\t" + bt[i] +"\t\t " + wt[i] +"\t\t" + tat[i]); 
	} 
	
	// Despliega los tiempos promedio (Tiempo de retorno promedio y tiempo de espera promedio)	
	ventanaRR.getAreaTabla().setText(ventanaRR.getAreaTabla().getText() + "\n\n");
	ventanaRR.getAreaTabla().setText(ventanaRR.getAreaTabla().getText() + "\n" + "Tiempo de espera promedio = " + (float)total_wt / (float)n); 
	ventanaRR.getAreaTabla().setText(ventanaRR.getAreaTabla().getText() + "\n" + "Tiempo de retorno promedio = " + (float)total_tat / (float)n); 
} 

} 
