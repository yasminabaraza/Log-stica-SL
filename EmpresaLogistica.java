/*
 * Classe que defineix una empresa logística, que es defineix pel seu nom,
 * la seva ubicació i un array de flotes.
 */

package logistica;

import java.util.Scanner;

/**
 *
 * @author itrascastro
 */
public class EmpresaLogistica {
    private final static Scanner DADES = new Scanner(System.in);

    private String nom;
    private String ubicacio;
    private Flota[] flotes = new Flota[5];
    private int pFlotes = 0; //Primera posició buida de l'array de Flotes

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: EmpresaLogistica
     *
     * Paràmetres: valors per tots els atributs de la classe menys els arrays.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    
    public EmpresaLogistica(String nom, String ubicacio) {
        this.nom = nom;
        this.ubicacio = ubicacio;
    }

    /**
     * TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public Flota[] getFlotes() {
        return this.flotes;
    }

    public void setFlotes(Flota[] flotes) {
        this.flotes = flotes;
    }

    public int getpFlotes() {
        return pFlotes;
    }

    public void setpFlotes(int pFlotes) {
        this.pFlotes = pFlotes;
    }
    

    /**
     * TODO
     *
     * Nom del mètode: addEmpresaLogistica
     *
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova empresa logística.
     *   Les dades a demanar són les que necessita el constructor.
     * 
     * Retorn: Objecte EmpresaLogistica creat.
     */
    public static EmpresaLogistica addEmpresaLogistica() {
        String nom, ubicacio;

        System.out.println("\nNom de l'empresa logística:");
        nom = DADES.nextLine();
        System.out.println("\nUbicació de l'empresa logística:");
        ubicacio = DADES.nextLine();

        return new EmpresaLogistica(nom, ubicacio);
    }

    /**
     * TODO
     *
     * Nom del mètode: updateEmpresaLogistica
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de l'empresa logística i
     *   modificar els atributs corresponents d'aquesta empresa logística. 
     *   Els únics atributs que modificarem
     *   són els que hem inicialitzat en el constructor amb els paràmetres passats.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     * 
     * Retorn: cap
     */
    public void updateEmpresaLogistica() {
        System.out.println("\nNom de l'empresa logística: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nUbicació de l'empresa logística: " + ubicacio);
        System.out.println("\nEntra la nova ubicació:");
        ubicacio = DADES.nextLine();
    }

    /**
     * TODO
     *
     * Nom del mètode: costManteniment
     *  
     * Paràmetres: cap
     * 
     * Accions:
     * - Calcular cost de manteniment dels vehícles de l'empresa logística a partir dels costos de manteniment
     *   de totes les flotes de l'empresa logística.
     * 
     * Retorn: Cost de manteniment total de l'empresa logística (double).
     */
    public double costManteniment() {
        double costTotal = 0;

        for (int i = 0; i < pFlotes; i++) {
            costTotal += flotes[i].costManteniment();
        }

        return costTotal;
    }

    /**
     * TODO
     *
     * Nom del mètode: showEmpresaLogistica
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode per imprimir les dades de l'empresa logística actual i el cost del seu manteniment.
     * 
     * Retorn: cap
     */
    public void showEmpresaLogistica() {
        System.out.println("\nLes dades de l'empresa logística " + nom + " són: ");
        System.out.println("\nUbicació: " + ubicacio);
        System.out.println("\nCost de manteniment total: " + costManteniment() + " EUR");
    }

    /**
     * Flota
     * 
     * TODO
     *
     * Nom del mètode: addFlota
     *  
     * Paràmetres: cap
     * 
     * Accions:
     * - Afegeix una nova flota a l'array de flotes de l'empresa logística
     *   si aquesta no existeix. 
     *   Per afegir-la heu de fer servir el mètode de la classe Flota escaient
     *   i per comprovar la seva existència el mètode d'aquesta classe que ens
     *   ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de flotes si s'afegeix la flota. 
     * - Mostra el missatge "La flota ja existeix" si no s'ha afegit.
     * 
     * Retorn: cap
     */
    public void addFlota() {
        Flota novaFlota = Flota.addFlota();

        if (selectFlota(novaFlota.getNom()) == -1) {
            flotes[pFlotes] = novaFlota;
            pFlotes++;
        } else {
            System.out.println("\nLa flota ja existeix");
        }
    }

    /**
     *
     * Nom del mètode: selectFlota
     *
     * Paràmetres: cap
     * 
     * Accions:
     * - Seleciona una flota de l'array de flotes de l'empresa logística
     *   a partir del seu nom.
     * 
     * Retorn: La posició de la flota seleccionada o -1 si no existeix.
     */
    public int selectFlota(String nom) {
        if (nom == null) {
            System.out.println("\nNom de la flota:");
            nom = DADES.nextLine();
        }

        for (int i = 0; i < pFlotes; i++) {
            if (flotes[i].getNom().equals(nom)) {
                return i;
            }
        }

        return -1;
    }

    public void addCamioFlota() {

        int index = selectFlota(null);

        if (index != -1) {
            flotes[index].addCamio();
        } else {
            System.out.println("\nLa flota no existeix");
        }
    }

    public void updateCamioFlota() {
        int indexFlota = selectFlota(null);

        if (indexFlota != -1) {
            int indexCamio = flotes[indexFlota].selectCamio(null);

            if (indexCamio != -1) {
                flotes[indexFlota].getCamions()[indexCamio].updateCamio();
            } else {
                System.out.println("\nEl camió no existeix");
            }
        } else {
            System.out.println("\nLa flota no existeix");
        }
    }

    public void addFurgonetaFlota() {
        int index = selectFlota(null);

        if (index != -1) {
            flotes[index].addFurgoneta();
        } else {
            System.out.println("\nLa flota no existeix");
        }
    }

    public void updateFurgonetaFlota() {
        int indexFlota = selectFlota(null);

        if (indexFlota != -1) {
            int indexFurgoneta = flotes[indexFlota].selectFurgoneta(null);

            if (indexFurgoneta != -1) {
                flotes[indexFlota].getFurgonetes()[indexFurgoneta].updateFurgoneta();
            } else {
                System.out.println("\nLa furgoneta no existeix");
            }
        } else {
            System.out.println("\nLa flota no existeix");
        }
    }

    public void addMotocicletaFlota() {
        int index = selectFlota(null);

        if (index != -1) {
            flotes[index].addMotocicleta();
        } else {
            System.out.println("\nLa flota no existeix");
        }
    }

    public void updateMotocicletaFlota() {
        int indexFlota = selectFlota(null);

        if (indexFlota != -1) {
            int indexMotocicleta = flotes[indexFlota].selectMotocicleta(null);

            if (indexMotocicleta != -1) {
                flotes[indexFlota].getMotocicletes()[indexMotocicleta].updateMotocicleta();
            } else {
                System.out.println("\nLa motocicleta no existeix");
            }
        } else {
            System.out.println("\nLa flota no existeix");
        }
    }
}
