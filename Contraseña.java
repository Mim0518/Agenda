import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class Contraseña extends JFrame implements ActionListener{
    JTextField contra = new JTextField(20);
    JTextField user = new JTextField(20);
    JLabel es = new JLabel("Ingrese sus credenciales");
    JPanel estado = new JPanel();
    JPanel principal = new JPanel();
    JPanel botones = new JPanel();
    JButton ingreso = new JButton("Ingresar");
    JButton salir = new JButton("Salir");
    boolean exito = false;
    public void pedir(){
        estado.add(es); 
        principal.setLayout(new GridLayout(1,4));
        principal.add(new JLabel("Nombre de Usuario: "));
        principal.add(user);
        principal.add(new JLabel("Contraseña: "));
        principal.add(contra);
        botones.setLayout(new GridLayout(1,2));
        botones.add(ingreso);
        botones.add(salir);
        getContentPane().add(estado, BorderLayout.NORTH);
        getContentPane().add(principal, BorderLayout.CENTER);
        getContentPane().add(botones, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setVisible(true);
    }
    public Contraseña(){
        while(!exito){
            pedir();
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ingreso){
            if(user.getText() == "Moreno" && contra.getText()=="19290933"){
                JOptionPane.showMessageDialog(null, "Ingreso exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
                exito = true;
            }else{
                JOptionPane.showMessageDialog(null, "Revise sus credenciales", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                exito = false;
            }
        }
    }
}

