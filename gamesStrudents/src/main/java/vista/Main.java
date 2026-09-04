package vista;

import controlador.LoginControlador;
import modelo.Login;

public class Main {

    public static void main(String[] args) {

        // Crear modelo
        Login modelo = new Login();

        // Crear vista
        LoginVista vista = new LoginVista();

        // Crear controlador
        LoginControlador controlador = new LoginControlador(modelo, vista);

        // Iniciar aplicación
        controlador.iniciar();
    }
}
    
    
    

