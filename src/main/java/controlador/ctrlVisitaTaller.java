package controlador;

import classes.clsMecanico;
import modelos.mdlAutomovil;
import modelos.mdlAvion;
import modelos.mdlVehiculo;
import modelos.mdlVisitaTaller;

public class ctrlVisitaTaller {
    private modelos.mdlVisitaTaller mdlVisitaTaller;

    public ctrlVisitaTaller() {
        this.mdlVisitaTaller = new mdlVisitaTaller();
    }

    public boolean CrearVisita(String impronta, int nit) {
        try {
            boolean ok = this.mdlVisitaTaller.CrearVisita(impronta,nit);
            return ok;
        } catch (Exception e) {
            return false;
        }
    }
}
