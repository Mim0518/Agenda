/*
Guillermo Moreno Rivera 
17/February/2021
*/
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Agenda extends JFrame implements ActionListener {
    JComboBox personas = new JComboBox();
    JTextField nombre = new JTextField(20);
    JTextField apellidos = new JTextField(20);
    JTextField email = new JTextField(20);
    JTextField telefono = new JTextField(20);
    JPanel botonera = new JPanel();
    JPanel centro = new JPanel();
    JPanel encabezado = new JPanel();
    JButton btnVer = new JButton("Ver Datos");
    JButton btnGuardar = new JButton("Modificar Datos");
    JButton btnAnadir = new JButton("Añadir Persona");
    JButton btnQuitar = new JButton("Quitar Persona");
    JButton btnGuardarFich = new JButton("Guardar archivo");
    JButton btnBorrarCuadros = new JButton("Limpiar campos");
    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    file f = new file();
    int indice = 0;
    public Agenda() {
        btnVer.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnAnadir.addActionListener(this);
        btnQuitar.addActionListener(this);
        btnGuardarFich.addActionListener(this);
        btnBorrarCuadros.addActionListener(this);
        listaPersonas = f.obtenerDeArchivo();
        actualizarLista();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        encabezado.setLayout(new GridLayout(1, 1));
        encabezado.add(personas);
        centro.setLayout(new GridLayout(4, 2));
        centro.add(new JLabel("Nombre"));
        centro.add(nombre);
        centro.add(new JLabel("Apellidos"));
        centro.add(apellidos);
        centro.add(new JLabel("Correo electrónico"));
        centro.add(email);
        centro.add(new JLabel("Teléfono"));
        centro.add(telefono);
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
        setTitle("Agenda");
        setVisible(true);
    }

    public void actualizarLista(){
        personas.removeAllItems();
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona p = (Persona) (listaPersonas.get(i));
            personas.addItem(p.getNombre() + " " + p.getApellidos());
        }
    }
    
    public void limpiarCampos(){
        apellidos.setText("");
        email.setText("");
        nombre.setText("");
        telefono.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVer) {
            indice = f.buscaPersona(listaPersonas, personas);
            Persona p = (Persona) (listaPersonas.get(indice));
            nombre.setText(p.getNombre());
            apellidos.setText(p.getApellidos());
            email.setText(p.getDireccion());
            telefono.setText(p.getTelefono());
        }
        if (e.getSource() == btnBorrarCuadros) {
            limpiarCampos();
        }
        if (e.getSource() == btnAnadir) {
            Persona x = new Persona(nombre.getText(), apellidos.getText(), email.getText(),
                    telefono.getText());
            listaPersonas.add(x);
            actualizarLista();
            limpiarCampos();
        }
        if (e.getSource() == btnQuitar) {
            indice = f.buscaPersona(listaPersonas, personas);
            listaPersonas.remove(indice);
            actualizarLista();
            limpiarCampos();
        }
        if (e.getSource() == btnGuardar) {
            indice = f.buscaPersona(listaPersonas, personas);
            Persona x = (Persona) (listaPersonas.get(indice));
            x.setApellidos(apellidos.getText());
            x.setNombre(nombre.getText());
            x.setDireccion(email.getText());
            x.setTelefono(telefono.getText());
            actualizarLista();
            limpiarCampos();
        }
        if (e.getSource() == btnGuardarFich) {
            try {
                f.ponerEnArchivo(listaPersonas);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}