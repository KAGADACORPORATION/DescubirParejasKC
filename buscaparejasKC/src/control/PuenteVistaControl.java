package control;

import vista.VistaPrincipal;

public class PuenteVistaControl extends VistaPrincipal{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListenerInicio listenerinicio;
	
	public PuenteVistaControl() {
		super();
		this.listenerinicio = new ListenerInicio(this.panelInicio,this.panelPrincipal);
		this.panelInicio.getBtnJugar().addActionListener(listenerinicio);
	}

}
