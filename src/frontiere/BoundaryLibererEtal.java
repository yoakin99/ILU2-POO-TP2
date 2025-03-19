package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String[] donnee = controlLibererEtal.libererEtal(nomVendeur);
			if ("true".equals(donnee[0])) {
				System.out.println("Vous avez vendu " + donnee[4] + " sur " + donnee[3] + " " + donnee[2] + ".");
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée.");
			}
		}
	}

}
