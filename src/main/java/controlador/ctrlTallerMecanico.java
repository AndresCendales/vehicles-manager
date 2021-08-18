package controlador;

import classes.clsTallerMecanico;
import modelos.mdlTallerMecanico;

import java.util.ArrayList;

public class ctrlTallerMecanico {
    private modelos.mdlTallerMecanico mdlTallerMecanico;

    public ctrlTallerMecanico() {
        this.mdlTallerMecanico = new mdlTallerMecanico();
    }

    public boolean CrearTallerMecancio(clsTallerMecanico tallerMecanico) {
        try {
            boolean ok = this.mdlTallerMecanico.CrearTallerMecanico(tallerMecanico);
            return ok;
        } catch (Exception e) {
            return false;
        }
    }

    public clsTallerMecanico ConsultarTallerMecanico(int nit) {
        clsTallerMecanico tallerMecanico = null;
        try {
            tallerMecanico = this.mdlTallerMecanico.ConsultarTallerMecanico(nit);
            return tallerMecanico;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<clsTallerMecanico> ConsultarTallerMecanicos() {
        ArrayList<clsTallerMecanico> talleresMecanico = null;
        try {
            talleresMecanico = this.mdlTallerMecanico.ConsultarTalleresMecanico();
            return talleresMecanico;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean EditarTallerMecanico(clsTallerMecanico tallerMecanico) {
        try {
            boolean ok = this.mdlTallerMecanico.EditarTallerMecanico(tallerMecanico);
            return ok;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean EliminarTallerMecanico(int nit) {
        try {
            boolean ok = this.mdlTallerMecanico.EliminarTallerMecanico(nit);
            return ok ;
        } catch (Exception e) {
            return false;
        }
    }
}
