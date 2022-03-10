package main;

import DAO.DAO;
import views.*;

public class MainApp {

    public static void main(String[] args) {
        new LoginView();
    	//Pelicula p = new Pelicula("a", "a", 1, 1, "a", "a", 1.0, "a", "a", "a", "a", "q");
       //new DatosView(p);
        
        
        DAO.getActor("tt2005151");
        
        
    }

}