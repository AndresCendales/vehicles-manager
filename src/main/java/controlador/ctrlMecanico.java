package controlador;

import classes.clsMecanico;
import modelos.mdlMecanico;

public class ctrlMecanico {

    private modelos.mdlMecanico mdlMecanico;

    public ctrlMecanico() {
        this.mdlMecanico = new mdlMecanico();
    }

    public boolean CrearMecanico(clsMecanico mecanico){
        try{
            this.mdlMecanico.CrearMecanico(mecanico);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public clsMecanico ConsultarMecanico(int identificacion){
        clsMecanico mecanico = null;
        try{
            this.mdlMecanico.ConsultarMecanico(identificacion);
            return mecanico;
        }catch (Exception e){
            return null;
        }
    }

    public boolean EditarMecanico(clsMecanico mecanico){
        try{
            this.mdlMecanico.EditarMecanico(mecanico);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean EliminarMecanico(int identificacion){
        try{
            this.mdlMecanico.EliminarMecanico(identificacion);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
