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

public class Login extends JFrame implements ActionListener {
    JPanel panel;
    JLabel usuarioL, contraseñaL, mensaje;
    JTextField usuarioC;
    JPasswordField contraseñaC;
    JButton Ingreso, Cancelar;

    public Login() {
        setResizable(false);
        usuarioL = new JLabel();
        usuarioL.setText("Usuario: ");
        usuarioC = new JTextField();
        contraseñaL = new JLabel();
        contraseñaL.setText("Contraseña: ");
        contraseñaC = new JPasswordField();
        Ingreso = new JButton("Entrar");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(usuarioL);
        panel.add(usuarioC);
        panel.add(contraseñaL);
        panel.add(contraseñaC);
        mensaje = new JLabel();
        panel.add(mensaje);
        panel.add(Ingreso);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ingreso.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Autenticación");
        setSize(300, 100);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String usuario = usuarioC.getText();
        String contraseña = contraseñaC.getText();
        if (usuario.trim().equals("admin") && contraseña.trim().equals("admin")) {
            mensaje.setText("Bienvenido, " + usuario);
            Agenda a = new Agenda();
        } else {
            mensaje.setText("Credenciales inválidas");
        }

    }

}