/*
Guillermo Moreno Rivera 
Luis Fernando Chavez Jimenez
17/February/2021
*/
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Agenda extends JFrame implements ActionListener {
    Font font = new Font("Verdana", Font.PLAIN, 14);
    JPanel mainP = new JPanel(new BorderLayout());
    JComboBox personas = new JComboBox();
    JTextField nombre = new JTextField(20);
    JTextField apellidos = new JTextField(20);
    JTextField email = new JTextField(20);
    JTextField telefono = new JTextField(20);
    JTextField fecha = new JTextField(20);
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
        setLayout(new FlowLayout(FlowLayout.CENTER, 10 , 10));
        setResizable(false);

        btnVer = setDisenoBtn(btnVer);
        btnVer.addActionListener(this);
        btnGuardar = setDisenoBtn(btnGuardar);
        btnGuardar.addActionListener(this);
        btnAnadir = setDisenoBtn(btnAnadir);
        btnAnadir.addActionListener(this);
        btnQuitar = setDisenoBtn(btnQuitar);
        btnQuitar.addActionListener(this);
        btnGuardarFich = setDisenoBtn(btnGuardarFich);
        btnGuardarFich.addActionListener(this);
        btnBorrarCuadros = setDisenoBtn(btnBorrarCuadros);
        btnBorrarCuadros.addActionListener(this);
        listaPersonas = f.obtenerDeArchivo();
        actualizarLista();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 380);
        encabezado.setLayout(new GridLayout(2, 1));
        JLabel JLa[] = {new JLabel ("Usarios"),
                        new JLabel ("Nombre"),
                        new JLabel("Apellidos"), 
                        new JLabel("Correo electrónico"), 
                        new JLabel("Teléfono"),
                        new JLabel("Fecha de nacimiento")};
        for (int i = 0; i < JLa.length; i++) {
            JLa[i].setFont(font);
        }
        encabezado.add(JLa[0]);
        encabezado.add(personas);
        centro.setLayout(new GridLayout(5, 2, 0 , 5));
        centro.add(JLa[1]);
        centro.add(nombre);
        centro.add(JLa[2]);
        centro.add(apellidos);
        centro.add(JLa[3]);
        centro.add(email);
        centro.add(JLa[4]);
        centro.add(telefono);
        centro.add(JLa[5]);
        centro.add(fecha);
        nombre.setFont(font);
        apellidos.setFont(font);
        email.setFont(font);
        telefono.setFont(font);
        fecha.setFont(font);

        botonera.setLayout(new GridLayout(2, 3, 5, 5));
        botonera.add(btnVer);
        botonera.add(btnGuardar);
        botonera.add(btnAnadir);
        botonera.add(btnQuitar);
        botonera.add(btnGuardarFich);
        botonera.add(btnBorrarCuadros);
        
        mainP.add(encabezado, BorderLayout.NORTH);
        mainP.add(centro, BorderLayout.CENTER);
        mainP.add(botonera, BorderLayout.SOUTH);

        getContentPane().add(mainP);
        mainP.setPreferredSize(new Dimension(500, 300));
        setTitle("Agenda");
        setVisible(true);
    }
    public JButton setDisenoBtn(JButton a){
        JButton b = a;
        b.setBackground(new Color(25, 118, 210));
        b.setFont(font);
        b.setForeground(Color.WHITE);
        b.setBorderPainted(false);
        return b;
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
        fecha.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVer) {
            indice = f.buscaPersona(listaPersonas, personas);
            Persona p = (Persona) (listaPersonas.get(indice));
            nombre.setText(p.getNombre());
            apellidos.setText(p.getApellidos());
            email.setText(p.getDireccion());
            telefono.setText(p.getTelefono());
            fecha.setText(p.getFecha());
        }
        if (e.getSource() == btnBorrarCuadros) {
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Datos limpios", "Agenta - Limpiar", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == btnAnadir) {
            Persona x = new Persona(nombre.getText(), apellidos.getText(), email.getText(),
                    telefono.getText(), fecha.getText());
            listaPersonas.add(x);
            actualizarLista();
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Usuario " + nombre.getText() + "añadido", "Agenda - Añadir", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == btnQuitar) {
            indice = f.buscaPersona(listaPersonas, personas);
            listaPersonas.remove(indice);
            actualizarLista();
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Usuario eliminado", "Agenda - Borrar", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == btnGuardar) {
            indice = f.buscaPersona(listaPersonas, personas);
            Persona x = (Persona) (listaPersonas.get(indice));
            x.setApellidos(apellidos.getText());
            x.setNombre(nombre.getText());
            x.setDireccion(email.getText());
            x.setTelefono(telefono.getText());
            x.setFecha(fecha.getText());
            actualizarLista();
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Usuario actual modificado", "Agenta - Guardar", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == btnGuardarFich) {
            try {
                f.ponerEnArchivo(listaPersonas);
                JOptionPane.showMessageDialog(null, "Archivo guardado o creado ", "Archivo Guardado", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}