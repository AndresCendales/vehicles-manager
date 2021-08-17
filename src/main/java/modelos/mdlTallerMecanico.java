package modelos;

import classes.clsTallerMecanico;

public class mdlTallerMecanico {
    public mdlTallerMecanico() {
    }


    public boolean CrearTallerMecanico(clsTallerMecanico Tallermecanico){
        try{
            // ToDo: Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean EditarTallerMecanico(clsTallerMecanico Tallermecanico){
        try{
            // ToDo: Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean EliminarTallerMecanico(int  nit){
        try{
            // ToDo: Conexión con la base de datos.
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public clsTallerMecanico ConsultarTallerMecanico(int nit){
        clsTallerMecanico tallerMecanico =null;
        try{
            // ToDo: Conexión con la base de datos.
            return tallerMecanico;
        }catch (Exception e){
            return null;
        }
    }
}
