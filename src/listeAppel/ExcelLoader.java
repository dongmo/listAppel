package listeAppel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLoader {

	/*
	 * Load Etudiant
	 */
	public static List<Etudiant> loadEtudiant(InputStream inputStream) throws IOException{
		Workbook wb = new XSSFWorkbook(inputStream);
		
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		Etudiant etudiant;
		
		//Positionnement du curseur à la premère ligne du fichier excel
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		
		//skip the first line content informations to get
		rowIterator.next();
		
		//Constitution de la liste des étudiants en parcourrant chaque ligne
		while (rowIterator.hasNext()) {
			etudiant = new Etudiant();
			Row row = (Row) rowIterator.next();
			etudiant = uploadEtudiantToRow(row);
			etudiants.add(etudiant);
		}
		return etudiants;
	}
	
	// Recuperation d'une ligne dans le fichier pour contituer un étudiant en java
	public static Etudiant uploadEtudiantToRow(Row row){
		
		Etudiant etudiant = new Etudiant();
		if(row == null) return null;
		Cell nom = row.getCell(0);
		Cell matiere = row.getCell(1);
		Cell filiere = row.getCell(2);
		
		if(nom != null) etudiant.setNom(nom.getStringCellValue());
		if(matiere != null) etudiant.setMatiere(matiere.getStringCellValue());
		if(filiere != null) etudiant.setFiliere(filiere.getStringCellValue());
		return etudiant;
		
	}
	
	/*
	 * Load Classe
	 */
	public static List<Classe> loadClasse(InputStream inputStream) throws IOException{
		Workbook wb = new XSSFWorkbook(inputStream);
		List<Classe> classes = new ArrayList<>();
		Classe classe;
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while(rowIterator.hasNext()){
			 classe = new Classe();
			 Row row = (Row) rowIterator.next();
			 classe = uploadClasseToRow(row);
			 classes.add(classe);
		}
		
		return classes;
	}
	
	public static Classe uploadClasseToRow(Row row){
		Classe classe = new Classe();
		
		if(row == null) return null;
		Cell libelle = row.getCell(0);
		
		if(libelle != null) classe.setLibelle(libelle.getStringCellValue());
		
		return classe;
	}
	
	/*
	 * Load Salle
	 */
	public static List<Salle> loadSalle(InputStream inputStream) throws IOException{
		Workbook wb = new XSSFWorkbook(inputStream);
		List<Salle> salles = new ArrayList<>();
		Salle salle;
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while(rowIterator.hasNext()){
			salle = new Salle();
			Row row = (Row)rowIterator.next();
			salle = uploadSalleToRow(row);
			salles.add(salle);
		}
		
		return salles;
	}

	public static Salle uploadSalleToRow(Row row){
		Salle salle = new Salle();
		
		if(row == null) return null;
		Cell libelle = row.getCell(0);
		Cell nbPlace = row.getCell(1);
		
		if(libelle != null) salle.setLibelle(libelle.getStringCellValue());
		if(nbPlace != null) salle.setNbPlace((int)nbPlace.getNumericCellValue());
		
		return salle;
	}
	
	/*
	 * Load Matiere
	 */
	public static List<Matiere> loadMatiere(InputStream inputStream) throws IOException{
		Workbook wb = new XSSFWorkbook(inputStream);
		List<Matiere> matieres = new ArrayList<>();
		Matiere matiere;
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while(rowIterator.hasNext()){
			matiere = new Matiere();
			Row row = (Row)rowIterator.next();
			matiere = uploadMatiereToRow(row);
			matieres.add(matiere);
		}
		
		return matieres;
	}

	public static Matiere uploadMatiereToRow(Row row){
		Matiere matiere = new Matiere();
		
		if(row == null) return null;
		Cell libelle = row.getCell(0);
		Cell nbPlace = row.getCell(1);
		
		if(libelle != null) matiere.setLibelle(libelle.getStringCellValue());
		
		return matiere;
	}
	
	/*
	 * Load Planning 
	 */
	public static Planning loadPlanning(InputStream inputStream) throws IOException{
		
		Planning planning = new Planning();
		Programme programme;
		List<Programme> programmes = new ArrayList<>();
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while(rowIterator.hasNext()){
			programme = new Programme();
			Row row = (Row)rowIterator.next();
			programme = uploadProgrammeToRow(row);
			programmes.add(programme);
		}
		planning.setProgrammes(programmes);
		return planning;
	}
	
	public static Programme uploadProgrammeToRow(Row row){
		Programme programme = new Programme();
		
		if(row == null) return null;
		Cell salle = row.getCell(0);
		Cell classe = row.getCell(1);
		Cell matiere = row.getCell(2);
		Cell effectif = row.getCell(3);
		
		if(salle != null) programme.setSalle(salle.getStringCellValue());
		if(classe != null) programme.setClasse(classe.getStringCellValue());
		if(matiere != null) programme.setMatiere(matiere.getStringCellValue());
		if(effectif != null) programme.setEffectif((int)effectif.getNumericCellValue());
		
		return programme;
	}
	
	/*
	 * Load ClasseMatiere
	 */
	public static List<ClasseMatiere> loadClassMatiere(InputStream inputStream) throws IOException{
		List<ClasseMatiere> classeMatieres = new ArrayList<>();
		ClasseMatiere classeMatiere;
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while(rowIterator.hasNext()){
			classeMatiere = new ClasseMatiere();
			Row row = (Row)rowIterator.next();
			classeMatiere = uploadClassMatiereToRow(row);
			classeMatieres.add(classeMatiere);
		}
		return classeMatieres;
	}
	
	public static ClasseMatiere uploadClassMatiereToRow(Row row){
		
		ClasseMatiere classeMatiere = new ClasseMatiere();
		
		if(row == null) return null;
		Cell classe = row.getCell(0);
		Cell matiere = row.getCell(1);
		if(classe != null) classeMatiere.setClasse(classe.getStringCellValue());
		if(matiere != null) classeMatiere.setMatiere(matiere.getStringCellValue());
		return classeMatiere;
	}
}
