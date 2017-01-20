package listeAppel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * Initialiser la liste des étudiants
		 */
		String format = "%-5d %20s %10s %10s\n";
		int i = 0;
		List<Etudiant> etudiants = ApplicationInit.initialisationListEtudiant();
		for(Etudiant etudiant : etudiants){
			System.out.format(format,++i,etudiant.getNom(),etudiant.getMatiere(),etudiant.getFiliere());
			

		}
		
//		/*
//		 * Initialiser la liste des Salles
//		 */
//		List<Salle> listSalles = ApplicationInit.initialiseSalle();
//		List<Etudiant> etudiants = new ArrayList<>();
//		
//		/*
//		 * Traitements des données entrées et retourne une liste d'appel par salle
//		 */
//		List<ListAppel> listAppels = makeListeAppel(listEtudiants, listSalles);
//		
//		/*
//		 * Formatage de l'affichage des données
//		 */
//		String format = "%-5d %20s %10s\n";
//		String formats = "%-5s %20s %10s\n";
//		
//		
//
//		for(ListAppel listAppel : listAppels){
//			System.out.println("\nEtudiants de la Salle :"+listAppel.getLibelleSalle()+"\n");
//			System.out.format(formats,"Places|","Noms et prenoms|","Matières");
//			System.out.println("------------------------------------------");
//			etudiants = listAppel.getEtudiants();
//			int i=0;
//			for(Etudiant etudiant : etudiants){
//				System.out.format(format,++i,etudiant.getNom(),etudiant.getMatiere());
//				
//
//			}
//		}
	}


	public static List<ListAppel> makeListeAppel(List<List<Etudiant>> listEtudiants,List<Salle> listSalles){
		List<ListAppel> listAppels = new ArrayList<ListAppel>();
		List<Etudiant> tmps = new ArrayList<Etudiant>();
		List<Etudiant> tmpSubs = new ArrayList<Etudiant>();
		int nbEtudiant,nbOfListEtudiant;
		ListAppel listAppel;

		for(List<Etudiant> etudiants : listEtudiants){
			if(!tmpSubs.isEmpty()){
				etudiants.addAll(etudiants);
			}
			
			if(!tmps.isEmpty()){
				etudiants.addAll(tmps);
			}
			for(Salle salle : listSalles){
				nbEtudiant = etudiants.size();
				nbOfListEtudiant = listEtudiants.size();
				if(nbEtudiant == salle.getNbPlace()){
					listAppel = new ListAppel(salle.getLibelle(),etudiants);
					listAppels.add(listAppel);
					listEtudiants = listEtudiants.subList(listEtudiants.indexOf(etudiants), listEtudiants.size());
					listSalles = listSalles.subList(listSalles.indexOf(salle)+1, listSalles.size());
					break;
				}else if(nbEtudiant < salle.getNbPlace()){
					tmpSubs = new LinkedList<>(etudiants.subList(salle.getNbPlace()-nbEtudiant, etudiants.size()));
					etudiants.addAll(listEtudiants.get(listEtudiants.indexOf(etudiants)+1).subList(0, salle.getNbPlace()-nbEtudiant));
					listAppel = new ListAppel(salle.getLibelle(),etudiants);
					listAppels.add(listAppel);
					//listEtudiants = listEtudiants.subList(listEtudiants.indexOf(etudiants.subList(salle.getNbPlace()-nbEtudiant+1, etudiants.size())), listEtudiants.size());
					int index = listEtudiants.indexOf(etudiants)+1;
					listEtudiants = listEtudiants.subList(listEtudiants.indexOf(etudiants)+1, listEtudiants.size());
					
					listSalles = listSalles.subList(listSalles.indexOf(salle)+1, listSalles.size());
					break;
				}else{
					listAppel = new ListAppel(salle.getLibelle(), etudiants.subList(0, salle.getNbPlace()));
					listAppels.add(listAppel);
					tmps = new LinkedList<>(etudiants.subList(salle.getNbPlace()+1, etudiants.size()));
					listEtudiants = listEtudiants.subList(listEtudiants.indexOf(etudiants), listEtudiants.size());
					listSalles = listSalles.subList(listSalles.indexOf(salle)+1, listSalles.size());
					break;
				}
			}
			
			
		}
		return listAppels;
	}

//	public static List<ListAppel> makeListeAppel(List<List<Etudiant>> listEtudiants,List<Salle> listSalles){
//		List<ListAppel> listAppels = new ArrayList<ListAppel>();
//		List<Etudiant> tmps = new ArrayList<Etudiant>();
//		int nbEtudiant,nbPlace,i=1,j=0,nbOfListEtudiant;
//		ListAppel listAppel;
//
//		ListIterator<List<Etudiant>> listIteratorEtudiants = listEtudiants.listIterator();
//		ListIterator<Salle> listIteratorSalles = listSalles.listIterator();
//
//		while(listIteratorEtudiants.hasNext()){
//			List<Etudiant> etudiants = listIteratorEtudiants.next();
//			while(listIteratorSalles.hasNext()){
//				Salle salle = listIteratorSalles.next(); 
//
//				nbEtudiant = etudiants.size();
//				nbOfListEtudiant = listEtudiants.size();
//				if(nbEtudiant <= salle.getNbPlace()){
//					listAppel = new ListAppel(salle.getLibelle(),etudiants);
//					listAppels.add(listAppel);
//
//					ListIterator<Etudiant> iteratorEtud = etudiants.listIterator();
//					iteratorEtud.next();
//					iteratorEtud.remove();
//					listIteratorSalles.remove();
//
//					break;
//				}else{
//					listAppel = new ListAppel(salle.getLibelle(), etudiants.subList(0, salle.getNbPlace()-1));
//					listAppels.add(listAppel);
//					tmps = etudiants.subList(salle.getNbPlace(), etudiants.size());
//					ListIterator<Etudiant> iteratorEtud = etudiants.listIterator();
//					iteratorEtud.next();
//					iteratorEtud.remove();
//					listIteratorSalles.remove();
//
//					//listIteratorEtudiants.next().addAll(tmps);
//					//listEtudiants.get(i).addAll(tmps);
//
//					listIteratorEtudiants.add(tmps);
//
//					break;
//				}
//			}
//			i++;
//
//		}
//		return listAppels;
//	}
}
