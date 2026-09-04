package vista;

import controlador.LoginControlador;
import modelo.Login;

public class Main {

    public static void main(String[] args) {

        Login modelo = new Login();

        LoginVista vista = new LoginVista();

        LoginControlador controlador =
                new LoginControlador(modelo, vista);

        controlador.iniciar();
    }
}

    

