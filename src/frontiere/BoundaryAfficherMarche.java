package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] donnee = controlAfficherMarche.donnerInfosMarche();
		if (donnee.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		} else {
			System.out.println(nomAcheteur + ", vous trouverez au marché.");
			for (int i = 0; i < donnee.length / 3; i += 3) {
				System.out.println("- " + donnee[i] + " qui vend " + donnee[i + 1] + " " + donnee[i + 2] + ".\n");
			}
		}
	}
}
