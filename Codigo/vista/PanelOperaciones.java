package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controlador.Controlador;

public class PanelOperaciones extends JPanel
{
	
	private JLabel labTitulo;
	private JLabel labUniversidad;
	private JLabel labPrograma;
	private JLabel labCurso;
	private JLabel labLaura;
	private JLabel labMoises;
	private JLabel labMauricio;
	
	private JButton btnRoundRobin;
	private JButton btnFCFS;
	private JButton btnSJF;
	private JButton btnSRTF;
	
	private Controlador controlador;
	
	public PanelOperaciones(Controlador controlador)
	{
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		this.setBackground(new Color(132,174,64));
		Font fontTitulo = new Font("Courier", Font.BOLD, 34);
		
		this.setBackground(new Color(132,174,64));
		Font font = new Font("Courier", Font.BOLD, 14);
		
		labTitulo = new JLabel("Planificador de CPU");
		labTitulo.setFont(fontTitulo);
		
		labUniversidad = new JLabel("Universidad el Bosque");
		labUniversidad.setFont(font);
		labPrograma = new JLabel("Ingeniería de Sistemas");
		labPrograma.setFont(font);
		labCurso = new JLabel("Sistemas operativos");
		labCurso.setFont(font);
		labLaura = new JLabel("Laura Virginia Peña Cabrera");
		labLaura.setFont(font);
		labMauricio = new JLabel("David Mauricio Valoyes Porras");
		labMauricio.setFont(font);
		labMoises = new JLabel("Moises Daniel Salcedo Ramos");
		labMoises.setFont(font);
		
		btnRoundRobin = new JButton("Round Robin");
		btnRoundRobin.setActionCommand("Round Robin");
		btnRoundRobin.addActionListener(controlador);
		
		btnFCFS = new JButton("FCFS");
		btnFCFS.setActionCommand("FCFS");
		btnFCFS.addActionListener(controlador);
		
		btnSJF = new JButton("SJF");
		btnSJF.setActionCommand("SJF");
		btnSJF.addActionListener(controlador);
		
		btnSRTF = new JButton("SRTF");
		btnSRTF.setActionCommand("SRTF");
		btnSRTF.addActionListener(controlador);
		
		add(labTitulo);
		add(labUniversidad);
		add(labPrograma);
		add(labCurso);
		add(labLaura);
		add(labMauricio);
		add(labMoises);
		add(btnRoundRobin);
		add(btnFCFS);
		add(btnSJF);
		add(btnSRTF);
		
		layout.putConstraint(SpringLayout.WEST, labTitulo, 190, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labTitulo, 730, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labTitulo, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labTitulo, 100, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labUniversidad, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labUniversidad, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labUniversidad, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labUniversidad, 170, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labPrograma, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labPrograma, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labPrograma, 180, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labPrograma, 200, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labCurso, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labCurso, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labCurso, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labCurso, 230, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labLaura, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labLaura, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labLaura, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labLaura, 330, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labMauricio, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labMauricio, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labMauricio, 340, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labMauricio, 360, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labMoises, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labMoises, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labMoises, 370, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labMoises, 390, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnRoundRobin, 430, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnRoundRobin, 670, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnRoundRobin, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnRoundRobin, 190, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnFCFS, 430, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnFCFS, 670, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnFCFS, 220, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnFCFS, 260, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnSJF, 430, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnSJF, 670, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnSJF, 290, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnSJF, 330, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnSRTF, 430, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnSRTF, 670, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnSRTF, 360, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnSRTF, 400, SpringLayout.NORTH, this);

	}

	public Controlador getControlador() 
	{
		return controlador;
	}

	public void setControlador(Controlador controlador) 
	{
		this.controlador = controlador;
	}
}