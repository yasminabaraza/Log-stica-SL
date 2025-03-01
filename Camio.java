/*
 * Classe que defineix un camió d'una flota. 
 * Es defineixen pel seu codi, matrícula, quilometratge i la seva capacitat de remolc en tones.
 */
package logistica;

import java.util.Scanner;

/**
 *
 * @author itrascastro
 */
public class Camio {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private String matricula;
    private int quilometratge;
    private double capacitatRemolc;

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Camio
     * 
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
     public Camio(String codi, String matricula, int quilometratge, double capacitatRemolc) {
        this.codi = codi;
        this.matricula = matricula;
        this.quilometratge = quilometratge;
        this.capacitatRemolc = capacitatRemolc;
    }


    /*
     * TODO Heu d'implementar tots els mètodes accessors possibles.  
     */
    
    public String getCodi() {
        return this.codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getQuilometratge() {
        return this.quilometratge;
    }

    public void setQuilometratge(int quilometratge) {
        this.quilometratge = quilometratge;
    }

    public double getCapacitatRemolc() {
        return this.capacitatRemolc;
    }

    public void setcapacitatRemolc(double capacitatRemolc) {
        this.capacitatRemolc = capacitatRemolc;
    }
   
    /*
    * TODO
    *
    * Nom del mètode: addCamio
    *
    * Accions:
    * - Demanar a l'usuari les dades per consola per crear un nou 
    *   Camio. Les dades a demanar són les que necessita 
    *   el constructor.
    *
    * Retorn: Objecte Camio creat.
    */
    public static Camio addCamio() {
        String codi, matricula;
        int quilometratge;
        double capacitatRemolc;

        System.out.println("\nCodi del camió: ");
        codi = DADES.nextLine(); 

        System.out.println("\nMatrícula del camió: ");
        matricula = DADES.nextLine();
        
        System.out.println("\nQuilometratge del camió: ");
        quilometratge = Integer.parseInt(DADES.nextLine());
        
        System.out.println("\nCapacitat de remolc del camió: ");
        capacitatRemolc = Double.parseDouble(DADES.nextLine());

        return new Camio(codi, matricula, quilometratge, capacitatRemolc);
    }

    /*
     * TODO
     *
     * Nom del mètode: updateCamio
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades del camió actual i
     *   modificar els atributs corresponents d'aquest camió.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     * 
     * Retorn: cap
     */
    public void updateCamio() {
        System.out.println("\nCodi del camió: " + this.getCodi());
        System.out.println("\nEntra el nou valor del codi: ");
        codi = DADES.nextLine();

        System.out.println("\nMatrícula del camió: " + this.getMatricula());
        System.out.println("\nEntra el nou valor de la matrícula: ");
        matricula = DADES.nextLine();
        
        System.out.println("\nQuilometratge del camió: " + this.getQuilometratge());
        System.out.println("\nEntra nou valor del quilometratge: ");
        quilometratge = Integer.parseInt(DADES.nextLine());

        System.out.println("\nCapacitat remolc del camió: " + this.getCapacitatRemolc());
        System.out.println("\nEntra nou valor de la capacitat de remolc: ");
        capacitatRemolc = Double.parseDouble(DADES.nextLine());
    }
    
    /*
     * TODO
     *
     * Nom del mètode: showCamio
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode per mostrar les dades del camió actual i el seu cost de manteniment.
     * 
     * Retorn: cap
     */
    public void showCamio() {
        System.out.println("\nLes dades del camió amb codi " + this.getCodi() + " són: ");
        System.out.println("\nMatrícula: " + this.getMatricula());
        System.out.println("\nQuilometratge: " + this.getQuilometratge());
        System.out.print("\nCapacitat de remolc: " + this.getCapacitatRemolc());
        System.out.println("\nCost de manteniment: " + this.costManteniment() + " EUR");
    }

    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode que calcula el cost de manteniment del Camio actual
     *   a partir del seu quilometratge i la seva capacitat de remolc.
     *   El cost de manteniment per quilòmetre és de 0.2 € i per cada
     *   tonelada de capacitat de remolc és de 100 €.
     * 
     * Retorn: cost de manteniment del camió actual (double).
     */
    public double costManteniment() {
        return (this.getQuilometratge() * 0.2) + (this.getCapacitatRemolc() * 100);
    }
}