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

		// Intialiser la liste des classes
		List<Classe> classes = ApplicationInit.initialiseClasse();

		//Initialiser la liste des Matieres
		List<Matiere> matieres = ApplicationInit.initialiseMatiere();

		//Initialiser la liste des étudiants
		List<Etudiant> etudiants = ApplicationInit.initialisationListEtudiant();

		//Initialiser les Salles
		List<Salle> salles = ApplicationInit.initialiseSalle();

		//Initialiser le planning
		Planning planning = ApplicationInit.initialisePlanning();

		List<ClasseMatiere> classeMatieres = ApplicationInit.initialiseClasseMatiere();

		//		/*
		//		 * Initialiser la liste des Salles
		//		 */
		//		List<Salle> listSalles = ApplicationInit.initialiseSalle();
		//		List<Etudiant> etudiants = new ArrayList<>();
		//		
		/*
		 * Traitements des données entrées et retourne une liste d'appel par salle
		 */
		List<ListAppel> listAppels = faireListeAppel(etudiants, planning, classeMatieres);

		/*
		 * Formatage de l'affichage des données
		 */
		String format = "%-5d %20s %10s\n";
		String formats = "%-5s %20s %10s\n";


		List<ListAppel> finalLisaAppel = new ArrayList<>();
		
//		int k = 0;
//		for(Iterator<ListAppel> it1 = listAppels.iterator();it1.hasNext(); ){
//			ListAppel listAppel = it1.next();
//			ListAppel appel = new ListAppel();
//			List<Etudiant> etudiants2 = new ArrayList<>();
//			for(Iterator<ListAppel> it2 = listAppels.iterator();it2.hasNext(); ){
//				ListAppel listAppel2 = it2.next();
//				if(listAppels.get(i).getLibelleSalle().equals(listAppels.get(j).getLibelleSalle())){
//					etudiants2.addAll(listAppels.get(j).getEtudiants());
//				}
//			}
//			appel.setEtudiants(etudiants2);
//			appel.setLibelleSalle(listAppels.get(i).getLibelleSalle());
//			finalLisaAppel.add(appel);
//		}
		List<Programme> programmes = planning.getProgrammes();
		for(Iterator<Programme> itp = programmes.iterator();itp.hasNext();){
			Programme programme = itp.next();
			ListAppel appel = new ListAppel();
			List<Etudiant> etudiants2 = new ArrayList<>();
			for(Iterator<ListAppel> itl = listAppels.iterator();itl.hasNext();){
				ListAppel listAppel = itl.next();
				if(listAppel.getLibelleSalle().equals(programme.getSalle())){
					etudiants2.addAll(listAppel.getEtudiants());
					itl.remove();
				}
			}
			if(!etudiants2.isEmpty()){
				appel.setEtudiants(etudiants2);
				appel.setLibelleSalle(programme.getSalle());
				finalLisaAppel.add(appel);	
			}
			
		}

		for(ListAppel listAppel : finalLisaAppel){
			System.out.println("\nEtudiants de la Salle :"+listAppel.getLibelleSalle()+"\n");
			System.out.format(formats,"Places|","Noms et prenoms|","Matières");
			System.out.println("------------------------------------------");
			etudiants = listAppel.getEtudiants();
			int i=0;
			for(Etudiant etudiant : etudiants){
				System.out.format(format,++i,etudiant.getNom(),etudiant.getMatiere());
			}
		}	
	}

	public static List<ListAppel> faireListeAppel(List<Etudiant> etudiants, Planning planning,List<ClasseMatiere> classeMatieres){
		List<ListAppel> listAppels = new ArrayList<ListAppel>();
		List<Etudiant> etudiants2 = new ArrayList<>();
		List<ListAppel> finalListAppels = new ArrayList<ListAppel>();
		ListAppel finalAppel = null; 
		ListAppel listAppel = null;
		List<Programme> programmes = planning.getProgrammes();
		//List<Etudiant> etudiantsToSave = new ArrayList<>();

		for(Programme programme : programmes){
			String salle = programme.getSalle();
			String matiere = programme.getMatiere();

			ClasseForMatiere classeForMatiere = Utils.generateListClassByMatiere(matiere, classeMatieres);
			List<String> classes = classeForMatiere.getClasses();
			for(Iterator<String> itc = classes.iterator();itc.hasNext();){
				int i = 0;
				String classe = itc.next();
				List<Etudiant> etudiantsToSave = new ArrayList<>();
				for(Iterator<Etudiant> it = etudiants.iterator();it.hasNext();){
					listAppel =  new ListAppel();
					Etudiant etudiant = it.next();
					if(etudiant.getMatiere().equals(matiere) && etudiant.getFiliere().equals(classe)){
						etudiantsToSave.add(etudiant);
						i++;
						it.remove();
						if(i == programme.getEffectif()){
							listAppel.setEtudiants(etudiantsToSave);
							listAppel.setLibelleSalle(salle);
							itc.remove();
							break;
						}
					}
				}
				if(listAppel.getLibelleSalle() != null){
					listAppels.add(listAppel);	
				}
			}
			
//			for(Iterator<ListAppel> ita = listAppels.iterator();ita.hasNext();){
//				ListAppel appel = ita.next();
//				if(appel.getLibelleSalle().equals(programme.getSalle())){
//					finalAppel = new ListAppel();
//					etudiants2.addAll(appel.getEtudiants());
//					
//					ita.remove();
//				}
//			}
//			finalAppel.setLibelleSalle(programme.getSalle());
//			finalAppel.setEtudiants(etudiants2);
//			finalListAppels.add(finalAppel);
		}
		return listAppels;

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
