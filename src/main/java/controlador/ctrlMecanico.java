package controlador;

import classes.clsMecanico;
import modelos.mdlMecanico;

import java.util.ArrayList;

public class ctrlMecanico {

    private modelos.mdlMecanico mdlMecanico;

    public ctrlMecanico() {
        this.mdlMecanico = new mdlMecanico();
    }

    public boolean CrearMecanico(clsMecanico mecanico) {
        try {
            this.mdlMecanico.CrearMecanico(mecanico);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public clsMecanico ConsultarMecanico(int identificacion) {
        clsMecanico mecanico = null;
        try {
            mecanico = this.mdlMecanico.ConsultarMecanico(identificacion);
            return mecanico;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<clsMecanico> ConsultarMecanicos() {
        ArrayList<clsMecanico> mecanicos = new ArrayList<>();
        try {
            mecanicos = this.mdlMecanico.ConsultarMecanicos();
            return mecanicos;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean EditarMecanico(clsMecanico mecanico) {
        try {
            this.mdlMecanico.EditarMecanico(mecanico);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean EliminarMecanico(int identificacion) {
        try {
            boolean ok = this.mdlMecanico.EliminarMecanico(identificacion);
            return ok;
        } catch (Exception e) {
            return false;
        }
    }
}
