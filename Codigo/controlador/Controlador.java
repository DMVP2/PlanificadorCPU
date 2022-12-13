package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.FCFS;
import modelo.RoundRobin;
import modelo.SJF;
import modelo.SRTF;
import vista.VentanaFCFS;
import vista.VentanaPrincipal;
import vista.VentanaRoundRobin;
import vista.VentanaSJF;
import vista.VentanaSRTF;

public class Controlador implements ActionListener
{

	private VentanaPrincipal v;
	
	private VentanaRoundRobin ventanaRR;
	private RoundRobin modeloRR;
	
	private VentanaFCFS ventanaFCFS;
	private FCFS modeloFCFS;
	
	private VentanaSJF ventanaSJF;
	private SJF modeloSJF;
	
	private VentanaSRTF ventanaSRTF;
	private SRTF modeloSRTF;
	
	public Controlador()
	{
		v = new VentanaPrincipal(this);
	}
	
	// Método que ejecuta Round Robin
	public void ejecutarRoundRobin()
	{
		int cantidad = ventanaRR.getCantidad();
		modeloRR = new RoundRobin(ventanaRR, cantidad);
		int procesos[] = ventanaRR.getProcesos();
		int tiempos[] = ventanaRR.getTiempos();
		int quantum = ventanaRR.getQuantum();		
		modeloRR.findavgTime(procesos, cantidad, tiempos, quantum);
		ventanaRR.getBtnEjecutar().setEnabled(false);
		
	}
	
	// Método que ejecuta FCFS
	public void ejecutarFCFS()
	{
		int cantidad = ventanaFCFS.getCantidad();
		modeloFCFS = new FCFS(ventanaFCFS, cantidad);
		int procesos[] = ventanaFCFS.getProcesos();
		int tiempos[] = ventanaFCFS.getTiempos();
		modeloFCFS.findavgTime(procesos, cantidad, tiempos);
		ventanaFCFS.getBtnEjecutar().setEnabled(false);
	}
	
	// Método que ejecuta SJF
	public void ejecutarSJF()
	{
		int cantidad = ventanaSJF.getCantidad();
		modeloSJF = new SJF(ventanaSJF, cantidad);
		int procesos[] = ventanaSJF.getProcesos();
		int tiempos[] = ventanaSJF.getTiempos();
		modeloSJF.solveSJF(procesos, cantidad, tiempos);
		ventanaSJF.getBtnEjecutar().setEnabled(false);
	}
	
	// Método que ejecuta SRTF
	public void ejecutarSRTF()
	{
		int cantidad = ventanaSRTF.getCantidad();
		int procesos[] = ventanaSRTF.getProcesos();
		int tiempos[] = ventanaSRTF.getTiempos();
		int llegada[] = ventanaSRTF.getLlegada();
		modeloSRTF = new SRTF(ventanaSRTF, cantidad, procesos, tiempos, llegada);
		ventanaSRTF.getBtnEjecutar().setEnabled(false);
	}
	
	// Método que recibe los eventos producidos por parte del usuario a través de la GUI
	public void actionPerformed(ActionEvent evento) 
	{

		String comando = evento.getActionCommand();

		if(comando.equals("Round Robin"))
		{
			try 
			{
				ventanaRR = new VentanaRoundRobin(this);
				
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		
		if(comando.equals("Ejecutar - Round Robin"))
		{
			try 
			{
				ejecutarRoundRobin();
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("FCFS"))
		{
			try 
			{
				ventanaFCFS = new VentanaFCFS(this);
				
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Ejecutar - FCFS"))
		{
			try 
			{
				ejecutarFCFS();
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("SJF"))
		{
			try 
			{
				ventanaSJF = new VentanaSJF(this);
				
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Ejecutar - SJF"))
		{
			try 
			{
				ejecutarSJF();
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("SRTF"))
		{
			try 
			{
				ventanaSRTF = new VentanaSRTF(this);
				
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
		if(comando.equals("Ejecutar - SRTF"))
		{
			try 
			{
				ejecutarSRTF();
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos correctamente");
			}
		}
	}

	public VentanaRoundRobin getVentanaRR() 
	{
		return ventanaRR;
	}

	public void setVentanaRR(VentanaRoundRobin ventanaRR) 
	{
		this.ventanaRR = ventanaRR;
	}
}
