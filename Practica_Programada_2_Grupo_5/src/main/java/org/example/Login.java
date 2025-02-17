package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame { //2- heredar desde Jframe
    private JPanel MainPanel;
    private JTextField UsuarioTxt;
    private JPasswordField PasswordTxt;
    private JLabel UsuarioLbl;
    private JLabel PasswordLbl;
    private JButton LoginBtn;
    private JButton LimpiarBtn;
    private boolean autenticado = false;

    //1- constructor inicializa la clase
    public Login(){
        //Los siguientes metodos vienen de Jframe, no hay que incializar, son heredados

        setContentPane(MainPanel); //Main panel del Java Swing, contenedor
        setTitle("Login"); //Nombre de la Ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //cierre la ventana mediante alguna funcionalidad
        setSize(400,400); //Tamaño de la ventana
        setVisible(true); //ventana activa o inactiva

        //PRIMER EVENTO click en login botton (con usuario y contraseña)
        LoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aca va_todo lo que se ejecuta a la hora del click
                String user = UsuarioTxt.getText();
                String password = PasswordTxt.getText();

                //Validacion del login
                if(user.equals("finanzas1")&& password.equals("1234")){
                    JOptionPane.showMessageDialog(null,"Ingreso Correcto, Bienvenido!");
                    autenticado = true;
                    //cerramos la ventana del menu
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Verifique sus Credenciales");
                    autenticado = false;
                }
            }
        });

        //SEGUNDO EVENTO limpiar campos de usuario y contraseña (dejarlos en blanco)
        LimpiarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioTxt.setText("");
                PasswordTxt.setText("");
            }
        });

    }
    // Método_para obtener el estado de autenticación
    public boolean esAutenticado() {
        return autenticado;
    }
}


