package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;

import controlador.Controlador;

public class VentanaFCFS extends JFrame
{

		private JButton [][] matrizBotones;
		
		int M = 0;
		int N = 0;
		
		private TextArea areaTabla;
		private TextArea areaOrden;
		
		private JPanel panelProcesos;
		private JPanel panelTablero;
		
		private JLabel labCantidadProcesos;
		
		private JButton btnEjecutar;
		
		private int cantidad;
		private int procesos[];
		private int tiempos[];

		// Metodo constructor de la GUI
		public VentanaFCFS(Controlador controlador)
		{
			labCantidadProcesos = new JLabel();
			Font font = new Font("Courier", Font.BOLD, 14);
			labCantidadProcesos.setFont(font);
			
			inicializarDatos();
			
			setTitle("FCFS");
			setSize(1600,540);
			setResizable(false);
			setLocationRelativeTo(null);
			
			this.getContentPane().setBackground(new Color(132,174,64));
			
			SpringLayout layout = new SpringLayout();
			setLayout(layout);

			panelProcesos = new JPanel();
			panelProcesos.setLayout(new GridLayout(M,1));
			
			panelTablero = new JPanel();
			panelTablero.setLayout(new GridLayout(M,N));
			
			matrizBotones = new JButton [M][N];
			inicializarBotones(controlador);
			cargarGrilla();
			inhabilitarTablero();
			
			btnEjecutar = new JButton("Ejecutar - FCFS");
			btnEjecutar.setActionCommand("Ejecutar - FCFS");
			btnEjecutar.addActionListener(controlador);
			btnEjecutar.setEnabled(true);
			
			areaTabla = new TextArea(); 
			
			areaOrden = new TextArea(); 	
			
			insertarDatosIniciales();
			
			add(areaTabla);
			add(areaOrden);
			add(panelProcesos);
			add(panelTablero);
			add(labCantidadProcesos);
			add(btnEjecutar);
			
			layout.putConstraint(SpringLayout.WEST, areaTabla, 20, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, areaTabla, 550, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, areaTabla, 20, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, areaTabla, 300, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, areaOrden, 590, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, areaOrden, 1120, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, areaOrden, 20, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, areaOrden, 300, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, panelProcesos, 20, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, panelProcesos, 120, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, panelProcesos, 320, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, panelProcesos, 490, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, panelTablero, 120, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, panelTablero, 1575, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, panelTablero, 320, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, panelTablero, 490, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, labCantidadProcesos, 1270, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, labCantidadProcesos, 1500, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, labCantidadProcesos, 70, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, labCantidadProcesos, 110, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, btnEjecutar, 1275, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, btnEjecutar, 1455, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, btnEjecutar, 200, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, btnEjecutar, 240, SpringLayout.NORTH, this);
			
			setVisible(true);
			
		}
		
		// Método que configura todos los datos iniciales del algoritmo al igual que configura la GUI
		public void inicializarDatos()
		{
			
			cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de procesos que desea ejecutar" + "\n" + "Minimo es un proceso y maximo 10"));
			
			if(cantidad < 1 || cantidad > 10)
			{
				JOptionPane.showMessageDialog(null, "Solo se aceptan mínimo 1 proceso y máximo 10 procesos");
			}
			else
			{
				
				labCantidadProcesos.setText("Cantidad de procesos: " + cantidad);
				
				M = cantidad;
				
				procesos = new int [cantidad];
				tiempos = new int [cantidad];
				
				for (int i = 0; i < procesos.length; i++) 
				{
					procesos[i] = (i + 1);
				}
				
				for (int i = 0; i < procesos.length; i++) 
				{
					tiempos[i] = (int) Math.floor(Math.random()*(12-1+1)+1);
				}

				
				for (int i = 0; i < tiempos.length; i++) 
				{
					N += tiempos[i];
				}
			}
			
		}
		
		public void insertarDatosIniciales()
		{
			
			areaTabla.setText(areaTabla.getText() + "Procesos " + " Tiempo de ejecución "); 
			
			for (int i = 0; i < cantidad; i++) 
			{
				areaTabla.setText(areaTabla.getText() + "\n" + " " + procesos[i] + "\t" + tiempos[i]);
			}
		}

		public void inicializarBotones(Controlador controlador)
		{
			
			for(int i = 0; i < M; i++)
			{
				for(int j = 0; j < N; j++)
				{
					matrizBotones[i][j] = new JButton();
					matrizBotones[i][j].setBackground(new Color(255,255,255));
				}
			}
		}
		
		public void inhabilitarTablero()
		{

			for(int i = 0; i < M; i++)
			{
				for(int j = 0; j < N; j++)
				{
					matrizBotones [i][j].setEnabled(false);
				}
			}
		}
		
		public void cargarGrilla()
		{

			for(int i = 0; i < M; i++)
			{
				for(int j = 0; j < N; j++)
				{
					panelTablero.add(matrizBotones[i][j]);
				}
			}
			
			for(int i = 0; i < M; i++)
			{
					JButton btnProceso = new JButton("Proceso " + (i+1));
					panelProcesos.add(btnProceso);
					btnProceso.setEnabled(false);
			}

			validate();
		}

		public JButton[][] getMatrizBotones() {
			return matrizBotones;
		}

		public void setMatrizBotones(JButton[][] matrizBotones) {
			this.matrizBotones = matrizBotones;
		}

		public int getM() {
			return M;
		}

		public void setM(int m) {
			M = m;
		}

		public int getN() {
			return N;
		}

		public void setN(int n) {
			N = n;
		}

		public JPanel getPanelTablero() {
			return panelTablero;
		}

		public void setPanelTablero(JPanel panelTablero) {
			this.panelTablero = panelTablero;
		}

		public void setBtnEjecutarLiebre(JButton btnEjecutarLiebre) {
			this.btnEjecutar = btnEjecutarLiebre;
		}

		public TextArea getAreaTabla() {
			return areaTabla;
		}

		public void setAreaTabla(TextArea areaTabla) {
			this.areaTabla = areaTabla;
		}

		public TextArea getAreaOrden() {
			return areaOrden;
		}

		public void setAreaOrden(TextArea areaOrden) {
			this.areaOrden = areaOrden;
		}

		public JLabel getLabCantidadProcesos() {
			return labCantidadProcesos;
		}

		public void setLabCantidadProcesos(JLabel labCantidadProcesos) {
			this.labCantidadProcesos = labCantidadProcesos;
		}

		public JButton getBtnEjecutar() {
			return btnEjecutar;
		}

		public void setBtnEjecutar(JButton btnEjecutar) {
			this.btnEjecutar = btnEjecutar;
		}

		public int[] getProcesos() {
			return procesos;
		}

		public void setProcesos(int[] procesos) {
			this.procesos = procesos;
		}

		public int[] getTiempos() {
			return tiempos;
		}

		public void setTiempos(int[] tiempos) {
			this.tiempos = tiempos;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
}
