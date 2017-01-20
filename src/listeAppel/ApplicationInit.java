package listeAppel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApplicationInit {

	public static List<Etudiant> initialisationListEtudiant() throws IOException{
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		String excelFilePath = "./files/etudiants.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        etudiants = loadEtudiant(inputStream);
        return etudiants;
	}
	
	public static List<Etudiant> loadEtudiant(InputStream inputStream) throws IOException{
		Workbook wb = new XSSFWorkbook(inputStream);
		
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		Etudiant etudiant;
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();//skip the first line
		
		while (rowIterator.hasNext()) {
			etudiant = new Etudiant();
			Row row = (Row) rowIterator.next();
			etudiant = uploadEtudiantToRow(row);
			etudiants.add(etudiant);
		}
		return etudiants;
	}
	
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
	

	public static List<Salle> initialiseSalle(){
		List<Salle> listSalles= new ArrayList<Salle>();
		Salle salle1 = new Salle("S1",20);
		listSalles.add(salle1);
		Salle salle2 = new Salle("S2",30);
		listSalles.add(salle2);
		Salle salle3 = new Salle("S3",15);
		listSalles.add(salle3);
		Salle salle4 = new Salle("S4",15);
		listSalles.add(salle4);
		Salle salle5 = new Salle("S5",20);
		listSalles.add(salle5);
//		Salle salle6 = new Salle("S6",20);
//		listSalles.add(salle6);
		return listSalles;
	}
}
