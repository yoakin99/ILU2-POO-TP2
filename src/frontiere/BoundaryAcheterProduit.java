package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur
					+ " mais il faut être un habitant de notre villagepour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] nomGaulois = controlAcheterProduit.vendeurProduit(produit);
			if (nomGaulois.length == 0) {
				System.out.println("Désolé personne vend ce produit au marché !\n");

			} else {
				System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?\n");
				for (int i = 0; i < nomGaulois.length; i++) {
					System.out.println((i + 1) + "-" + nomGaulois[i] + "\n");
				}
				int nbVendeur = Clavier.entrerEntier("");
				nbVendeur--;
				System.out
						.println(nomAcheteur + " se déplace jusqu'à l'étal de vendeur " + nomGaulois[nbVendeur] + "\n");
				int nbProduit = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int nbRestant = controlAcheterProduit.acheterProduit(produit, nbProduit, nbVendeur);

				if (nbRestant == 0) {
					System.out.println(nomAcheteur + "veut acheter " + nbProduit + " " + produit
							+ ", malheureseument il n'y en a plus !");
				} else if (nbRestant < nbProduit) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheuresement "
							+ nomGaulois[nbVendeur] + " n'en a plus que " + nbRestant + ". " + nomAcheteur
							+ " achète tout le stock de " + nomGaulois[nbVendeur] + ".\n");
				} else {
					System.out.println(nomAcheteur + " achète " + nbProduit + " " + produit + " à "
							+ nomGaulois[nbVendeur] + ".\n");
				}

			}
		}
	}

}
