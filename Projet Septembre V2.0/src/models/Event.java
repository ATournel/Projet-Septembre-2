package models;

public class Event {

	int id_evenement;
	int id_createur;
	String nom;
	String categorie;
	String lieu;
	String dateDebutEvenement;
	String dateFinEvenement;
	String heureDebutEvenement;
	String heurefinEvenement;
	String description;
	int age_mini;
	int capacite;
	String pseudoCreateur;

	public String getPseudoCreateur() {
		return pseudoCreateur;
	}

	public void setPseudoCreateur(String pseudoCreateur) {
		this.pseudoCreateur = pseudoCreateur;
	}

	public int getId_evenement() {
		return id_evenement;
	}

	public void setId_evenement(int id_evenement) {
		this.id_evenement = id_evenement;
	}

	public int getId_createur() {
		return id_createur;
	}

	public void setId_createur(int id_createur) {
		this.id_createur = id_createur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDateDebutEvenement() {
		return dateDebutEvenement;
	}

	public void setDateDebutEvenement(String dateDebutEvenement) {
		this.dateDebutEvenement = dateDebutEvenement;
	}

	public String getDateFinEvenement() {
		return dateFinEvenement;
	}

	public void setDateFinEvenement(String dateFinEvenement) {
		this.dateFinEvenement = dateFinEvenement;
	}

	public String getHeureDebutEvenement() {
		return heureDebutEvenement;
	}

	public void setHeureDebutEvenement(String heureDebutEvenement) {
		this.heureDebutEvenement = heureDebutEvenement;
	}

	public String getHeurefinEvenement() {
		return heurefinEvenement;
	}

	public void setHeurefinEvenement(String heurefinEvenement) {
		this.heurefinEvenement = heurefinEvenement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAge_mini() {
		return age_mini;
	}

	public void setAge_mini(int age_mini) {
		this.age_mini = age_mini;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

}
