package modelos;

import classes.clsMecanico;

public class mdlMecanico {
    public mdlMecanico() {
    }


    public boolean CrearMecanico(clsMecanico mecanico){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean EditarMecanico(clsMecanico mecanico){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean EliminarMecanico(int  identificacion){
        try{
            //Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public clsMecanico ConsultarMecanico(int identificacion){
        clsMecanico mecanico =null;
        try{
            //Conexión con la base de datos.
            return mecanico;
        }catch (Exception e){
            return null;
        }
    }
}
