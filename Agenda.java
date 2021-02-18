/*
Guillermo Moreno Rivera y Luis Fernando Chávez Jiménez
17/February/2021
*/
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Agenda extends JFrame implements ActionListener{
    JComboBox personas = new JComboBox();
    JTextField txtNombre = new JTextField(20);
    JTextField txtApellidos = new JTextField(20);
    JTextField txtEmail = new JTextField(20);
    JTextField txtTelefono = new JTextField(20);
    JPanel botonera = new JPanel();
    JPanel centro = new JPanel();
    JPanel encabezado = new JPanel();
    JButton btnVer = new JButton ("Ver Datos");
    JButton btnGuardar = new JButton ("Modificar Datos");
    JButton btnAnadir = new JButton ("Añadir Persona");
    JButton btnQuitar = new JButton ("Quitar Persona");
    JButton btnGuardarFich = new JButton ("Guardar Fichero");
    JButton btnBorrarCuadros = new JButton ("Borrar Cuadros");
    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    file f = new file();
    int indice = 0;
    public void agregarALista(Persona p){
        listaPersonas.add(p);
    }
    public Agenda(){
        btnVer.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnAnadir.addActionListener(this);
        btnQuitar.addActionListener(this);
        btnGuardarFich.addActionListener(this);
        btnBorrarCuadros.addActionListener(this);
        listaPersonas = f.obtenerDeArchivo();
        for (int i = 0; i < listaPersonas.size(); i++){
            Persona p = (Persona)(listaPersonas.get(i));
            personas.addItem(p.getNombre() + " " + p.getApellidos());
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        encabezado.setLayout(new GridLayout(1, 1));
        encabezado.add(personas);
        centro.setLayout(new GridLayout(4, 2));
        centro.add(new JLabel("Nombre"));
        centro.add(txtNombre);
        centro.add(new JLabel("Apellidos"));
        centro.add(txtApellidos);
        centro.add(new JLabel("Correo electrónico"));
        centro.add(txtEmail);
        centro.add(new JLabel("Teléfono"));
        centro.add(txtTelefono);
        botonera.setLayout(new GridLayout(2, 3));
        botonera.add(btnVer);
        botonera.add(btnGuardar);
        botonera.add(btnAnadir);
        botonera.add(btnQuitar);
        botonera.add(btnGuardarFich);
        botonera.add(btnBorrarCuadros);
        getContentPane().add(encabezado, BorderLayout.NORTH);
        getContentPane().add(centro, BorderLayout.CENTER);
        getContentPane().add(botonera, BorderLayout.SOUTH);
        setVisible(true);
    }   
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnVer){
            indice = f.buscaPersona(listaPersonas, personas);
            Persona p = (Persona)(listaPersonas.get(indice));
            txtNombre.setText(p.getNombre());
            txtApellidos.setText(p.getApellidos());
            txtEmail.setText(p.getDireccion());
            txtTelefono.setText(p.getTelefono());
        }
        
    }
}