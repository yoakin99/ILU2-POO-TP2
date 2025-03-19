package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!(controlPrendreEtal.verifierIdentite(nomVendeur))) {
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut être un habitant de notre village pour commencer ici.");
		} else {
			System.out.println("Bonjour "+nomVendeur+" ,je vais regarder si je peux vous trouver un étal.");
			controlPrendreEtal.resteEtals();
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
