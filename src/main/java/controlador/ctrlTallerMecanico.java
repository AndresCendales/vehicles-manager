package controlador;

import classes.clsTallerMecanico;
import modelos.mdlTallerMecanico;

public class ctrlTallerMecanico {
    private modelos.mdlTallerMecanico mdlTallerMecanico;

    public ctrlTallerMecanico() {
        this.mdlTallerMecanico = new mdlTallerMecanico();
    }

    public boolean CrearTallerMecancio(clsTallerMecanico tallerMecanico){
        try{
            this.mdlTallerMecanico.CrearTallerMecanico(tallerMecanico);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public clsTallerMecanico ConsultarTallerMecanico(int nit){
        clsTallerMecanico tallerMecanico = null;
        try{
            this.mdlTallerMecanico.ConsultarTallerMecanico(nit);
            return tallerMecanico;
        }catch (Exception e){
            return null;
        }
    }

    public boolean EditarTallerMecanico(clsTallerMecanico tallerMecanico){
        try{
            this.mdlTallerMecanico.EditarTallerMecanico(tallerMecanico);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean EliminarTallerMecanico(int nit){
        try{
            this.mdlTallerMecanico.EliminarTallerMecanico(nit);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
