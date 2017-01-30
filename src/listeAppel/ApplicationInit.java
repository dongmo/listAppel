package listeAppel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationInit {

	/*
	 * Recuperer les données concernant la classe Etudiant dans fichier excel situé dans le dossier files du projet.
	 */
	public static List<Etudiant> initialisationListEtudiant() throws IOException{
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		String excelFilePath = "./files/etudiants.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        etudiants = ExcelLoader.loadEtudiant(inputStream);
        return etudiants;
	}
	
	
	/*
	 * Recuperer les données concernant la classe Salle dans fichier excel situé dans le dossier files du projet.
	 */
	public static List<Salle> initialiseSalle() throws IOException{
		List<Salle> salles= new ArrayList<Salle>();
		String excelFilePath = "./files/salle.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        salles = ExcelLoader.loadSalle(inputStream);
		return salles;
	}
	
	/*
	 * Recuperer les données concernant la classe Classe dans fichier excel situé dans le dossier files du projet.
	 */
	public static List<Classe> initialiseClasse() throws IOException{
		List<Classe> classes= new ArrayList<Classe>();
		String excelFilePath = "./files/classe.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        classes = ExcelLoader.loadClasse(inputStream);
		return classes;
	}
	
	/*
	 * Recuperer les données concernant la classe Matiere dans fichier excel situé dans le dossier files du projet.
	 */
	public static List<Matiere> initialiseMatiere() throws IOException{
		List<Matiere> matieres= new ArrayList<Matiere>();
		String excelFilePath = "./files/matiere.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        matieres = ExcelLoader.loadMatiere(inputStream);
		return matieres;
	}
	
	/*
	 * Recuperer les données concernant la classe Planning dans fichier excel situé dans le dossier files du projet.
	 */
	public static Planning initialisePlanning() throws IOException{
		Planning planning = new Planning();
		String excelFilePath = "./files/planning.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        planning = ExcelLoader.loadPlanning(inputStream);
		return planning;
	}
	
	/*
	 * Recuperer les données concernant la classe Planning dans fichier excel situé dans le dossier files du projet.
	 */
	public static List<ClasseMatiere> initialiseClasseMatiere() throws IOException{
		List<ClasseMatiere> classeMatieres = new ArrayList<>();
		String excelFilePath = "./files/classematiere.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        classeMatieres = ExcelLoader.loadClassMatiere(inputStream);
		return classeMatieres;
	}
}
