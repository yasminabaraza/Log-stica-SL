/**
 * Classe que defineix una flota. Es defineix pel seu nom,
 * el nom de l’àrea d’operació, un array de camions,
 * un array de furgonetes i un array de motocicletes.
 */

package logistica;

import java.util.Scanner;

/**
 *
 * @author itrascastro
 */
public class Flota {
    private final static Scanner DADES = new Scanner(System.in);

    private String nom;
    private String areaOperacio;

    private Camio[] camions = new Camio[100];
    private int pCamions = 0; //Primera posició buida de l'array de camions
    private Furgoneta[] furgonetes = new Furgoneta[100];
    private int pFurgonetes = 0; //Primera posició buida de l'array de furgonetes
    private Motocicleta[] motocicletes = new Motocicleta[100];
    private int pMotocicletes = 0; //Primera posició buida de l'array de motocicletes

    /**
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Flota
     *
     * Paràmetres: valors per tots els atributs de la classe, menys els arrays
     *
     * Accions:
     * - Assignar als atributs els valors passats com a paràmetres.
     */
    public Flota(String nom, String areaOperacio) {
        this.nom = nom;
        this.areaOperacio = areaOperacio;
    }

    /**
     * TODO Heu d'implementar tots els mètodes accessors possibles.
     */

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAreaOperacio() {
        return this.areaOperacio;
    }

    public void setAreaOperacio(String areaOperacio) {
        this.areaOperacio = areaOperacio;
    }

    public Camio[] getCamions() {
        return this.camions;
    }

    public void setCamions(Camio[] camions) {
        this.camions = camions;
    }

    public Furgoneta[] getFurgonetes() {
        return this.furgonetes;
    }

    public void setFurgonetes(Furgoneta[] furgonetes) {
        this.furgonetes = furgonetes;
    }

    public Motocicleta[] getMotocicletes() {
        return this.motocicletes;
    }

    public void setMotocicletes(Motocicleta[] motocicletes) {
        this.motocicletes = motocicletes;
    }

    public int getpCamions() {
        return this.pCamions;
    }

    public void setpCamions(int pCamions) {
        this.pCamions = pCamions;
    }
    
    public int getpFurgonetes() {
        return this.pFurgonetes;
    }

    public void setpFurgonetes(int pFurgonetes) {
        this.pFurgonetes = pFurgonetes;
    }
    
    public int getpMotocicletes() {
        return this.pMotocicletes;
    }

    public void setpMotocicletes(int pMotocicletes) {
        this.pMotocicletes = pMotocicletes;
    }

    /**
     * TODO
     *
     * Nom del mètode: addFlota
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova flota.
     *   Les dades a demanar són les que necessita el constructor.
     *
     * Retorn: Objecte Flota creat.
     */
    public static Flota addFlota() {
        String nom, areaOperacio;

        System.out.println("\nNom de la flota: ");
        nom = DADES.nextLine();
        System.out.println("\nÀrea d'operació de la flota: ");
        areaOperacio = DADES.nextLine();

        return new Flota(nom, areaOperacio);
    }

    /*
     * TODO
     *
     * Nom del mètode: updateFlota
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de la flota i
     *   modificar els atributs corresponents d'aquesta flota. Els únics
     *   atributs que modificarem són els que hem inicialitzat en el constructor
     *   amb els paràmetres passats.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     *
     * Retorn: cap
     */
    public void updateFlota() {
        System.out.println("\nNom de la flota: " + this.getNom());
        System.out.println("\nEntra el nou nom de la flota:");
        this.nom = DADES.nextLine();
        System.out.println("\nÀrea d'operació de la flota : " + this.getAreaOperacio());
        System.out.println("\nEntra la nova àrea d'peració:");
        this.areaOperacio = DADES.nextLine();
    }

    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Calcular el cost de manteniment de la Flota a partir dels costos
     *   de manteniment dels vehícles de la Flota.
     *
     * Retorn: cost de manteniment total de la flota.
     */
    public double costManteniment() {
        
        double costTotal = 0;

        for (int i = 0; i < pCamions; i++) {
            costTotal += camions[i].costManteniment();
        }

        for (int i = 0; i < pFurgonetes; i++) {
            costTotal += furgonetes[i].costManteniment();
        }

        for (int i = 0; i < pMotocicletes; i++) {
            costTotal += motocicletes[i].costManteniment();
        }

        return costTotal;

    }
    
    /*
     * TODO
     *
     * Nom del mètode: showFlota
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades de la flota actual i el seu cost de manteniment.
     *
     * Retorn: cap
     */
    public void showFlota() {
        System.out.println("\nLes dades de la flota " + this.nom + " són: ");
        System.out.println("\nÀrea d'operació: " + this.getAreaOperacio());
        System.out.println("\nCost de manteniment: " + this.costManteniment() + " EUR");
    }
    
    /**
     * Camio
     *
     * TODO
     *
     * Nom del mètode: addCamio
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix un nou camió a l'array de camions
     *   de la flota actual si aquest/a no existeix.
     *   Per afegir-lo heu de fer servir el mètode de la classe Camio
     *   escaient i per comprovar la seva existència el mètode d'aquesta classe
     *   que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de camions si s'afegeix.
     * - Mostra el missatge "El camió ja existeix" si
     *   no s'ha afegit.
     *
     * Retorn: cap
     */
    public void addCamio() {
        Camio nouCamio = Camio.addCamio();

        if (selectCamio(nouCamio.getCodi()) == -1) {
            camions[pCamions] = nouCamio;
            pCamions++;
        } else {
            System.out.println("\nEl camió ja existeix");
        }
    }

    /**
     *
     * Nom del mètode: selectCamio
     *
     * Paràmetres: codi del camió
     *
     * Accions:
     * - Mètode que selecciona un camió de l'array de camions de la flota actual
     *   a partir del seu codi.
     *
     * Retorn: posició del camió seleccionat a l'array de camions de la flota actual.
     * Si el camió no existeix retorna -1.
     */
    public int selectCamio(String codi) {
        if (codi == null) {
            System.out.println("\nCodi del camió:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pCamions; i++) {
            if (camions[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Furgoneta
     *
     * TODO
     *
     * Nom del mètode: addFurgoneta
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix una nova furgoneta a l'array de furgonetes
     *   de la flota actual si aquesta no existeix.
     *   Per afegir-la heu de fer servir el mètode de la classe Furgoneta
     *   escaient i per comprovar la seva existència el mètode d'aquesta classe
     *   que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de furgonetes si s'afegeix.
     * - Mostra el missatge "La furgoneta ja existeix" si
     *   no s'ha afegit.
     *
     * Retorn: cap
     */
    public void addFurgoneta() {
        Furgoneta novaFurgoneta = Furgoneta.addFurgoneta();

        if (selectFurgoneta(novaFurgoneta.getCodi()) == -1) {
            furgonetes[pFurgonetes] = novaFurgoneta;
            pFurgonetes++;
        } else {
            System.out.println("\nLa furgoneta ja existeix");
        }
    }
    
    
    /**
     *
     * Nom del mètode: selectFurgoneta
     *      
     * Paràmetres: codi de la furgoneta
     *
     * Accions:
     * - Mètode que selecciona una furgoneta de l'array de furgonetes de la flota actual
     *   a partir del seu codi.
     *
     * Retorn: posició de la furgoneta seleccionada a l'array de furgonetes de la flota actual.
     * Si la furgoneta no existeix retorna -1.
     */    
    public int selectFurgoneta(String codi) {
        if (codi == null) {
            System.out.println("\nCodi de la furgoneta:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pFurgonetes; i++) {
            if (furgonetes[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
    
    /**
     * Motocicleta
     *
     * TODO
     *
     * Nom del mètode: addMotocicleta
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix una nova motocicleta a l'array de motocicletes
     *   de la flota actual si aquesta no existeix.
     *   Per afegir-la heu de fer servir el mètode de la classe Motocicleta
     *   escaient i per comprovar la seva existència el mètode d'aquesta classe
     *   que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de motocicletes si s'afegeix.
     * - Mostra el missatge "La motocicleta ja existeix" si
     *   no s'ha afegit.
     *
     * Retorn: cap
     */
    public void addMotocicleta() {
        Motocicleta novaMotocicleta = Motocicleta.addMotocicleta();

        if (selectMotocicleta(novaMotocicleta.getCodi()) == -1) {
            motocicletes[pMotocicletes] = novaMotocicleta;
            pMotocicletes++;
        } else {
            System.out.println("\nLa motocicleta ja existeix");
        }
    }

    /**
     *
     * Nom del mètode: selectMotocicleta
     * 
     * Paràmetres: codi de la motocicleta
     *
     * Accions:
     * - Mètode que selecciona una motocicleta de l'array de furgonetes de la flota actual
     *   a partir del seu codi.
     *
     * Retorn: posició de la motocicleta seleccionada a l'array de motocicletes de la flota actual.
     * Si la furgoneta no existeix retorna -1.
     */      
    
    public int selectMotocicleta(String codi) {
        if (codi == null) {
            System.out.println("\nCodi de la motocicleta:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pMotocicletes; i++) {
            if (motocicletes[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
}