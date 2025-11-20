package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    private  List<Observer> listObservers = new ArrayList<>();
    private List<ICours> listeCours = new ArrayList<>();


    public void attach(Observer o) {
        listObservers.add(o);
    }


    public void detach(Observer o) {
        listObservers.remove(o);
    }


    public void notifyObservers(String message) {
        for (Observer o : listObservers) {
            o.update(message);
        }
    }

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        // TODO: C'est ici qu'il faudrait notifier les étudiants (Observer pattern)
        notifyObservers("Nouveau cours ajouté : " + cours.getDescription());
    }

    public void modifierCours(ICours cours, String message) {
        // Logique de modification...
        System.out.println("Cours modifié : " + message);
        // TODO: Notifier les observateurs ici aussi
        notifyObservers(message);
    }

    public void setChangement(String string) {
        // TODO Auto-generated method stub
        notifyObservers(string);
       // throw new UnsupportedOperationException("Unimplemented method 'setChangement'");
    }
}