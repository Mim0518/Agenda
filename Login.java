import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.*;
import java.math.*;

public class Login extends JFrame implements ActionListener {
    Font font = new Font("Verdana", Font.PLAIN, 14);


    JPanel panel;
    JLabel usuarioL, contraseniaL, mensaje;
    JTextField usuarioC;
    JPasswordField contraseniaC;
    JButton Ingreso, Cancelar;

    public Login() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 25,25));
        setSize(300, 300);
        setResizable(false);
        
        usuarioL = new JLabel();
        usuarioL.setText("Usuario: ");
        usuarioL.setFont(font);
        usuarioC = new JTextField();
        usuarioC.setFont(font);
        contraseniaL = new JLabel();
        contraseniaL.setFont(font);
        contraseniaL.setText("Contraseña: ");
        contraseniaC = new JPasswordField();
        Ingreso = new JButton("Entrar");
        Ingreso.setBackground(new Color(25, 118, 210));
        Ingreso.setFont(font);
        Ingreso.setForeground(Color.WHITE);
        Ingreso.setBorderPainted(false);
        panel = new JPanel(new GridLayout(6, 1));
        panel.add(usuarioL);
        panel.add(usuarioC);
        panel.add(contraseniaL);
        panel.add(contraseniaC);
        mensaje = new JLabel();
        panel.add(mensaje);
        panel.add(Ingreso);
        panel.setPreferredSize(new Dimension(200, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ingreso.addActionListener(this);
        add(panel);
        setTitle("Autenticación");

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String usuario = usuarioC.getText();
        String contraseña = contraseniaC.getText();
        if (usuario.trim().equals("admin") && contraseña.trim().equals("admin")) {
            JOptionPane.showMessageDialog(null, "Bienvenido, " + usuario, "Credenciales correctas", JOptionPane.INFORMATION_MESSAGE);
            Agenda a = new Agenda();
            super.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error, credenciales inválidas", "Credenciales inválidas", JOptionPane.ERROR_MESSAGE);
            
        }

    }

    

}