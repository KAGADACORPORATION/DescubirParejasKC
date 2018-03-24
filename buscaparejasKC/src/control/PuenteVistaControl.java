package control;

import vista.PanelInicio;
import vista.VistaPrincipal;

public class PuenteVistaControl extends VistaPrincipal{
	private ListenerInicio listenerinicio;
	
	public PuenteVistaControl() {
		super();
		this.listenerinicio = new ListenerInicio(this.panelInicio,this.panelPrincipal);
		this.panelInicio.getBtnJugar().addActionListener(listenerinicio);
	}

}
