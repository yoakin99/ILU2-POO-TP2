package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nom) {
		return village.trouverHabitant(nom) != null;
	}

	public String[] vendeurProduit(String produit) {
		String[] liste = new String[(village.rechercherVendeursProduit(produit)).length];
		int i = 0;
		for (Gaulois gaulois : village.rechercherVendeursProduit(produit)) {
			liste[i] = gaulois.getNom();
		}
		return liste;
	}

	public int acheterProduit(String produit, int nbProduit, int rang) {
		Gaulois gaulois = (village.rechercherVendeursProduit(produit))[rang];
		Etal etal = village.rechercherEtal(gaulois);
		return etal.acheterProduit(nbProduit);
	}

}
