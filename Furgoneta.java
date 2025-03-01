/*
 * Classe que defineix una furgoneta d'una flota. 
 * Es defineix pel seu codi, matrícula, quilometratge i la seva capacitat de càrrega en metres cúbics.
 */
package logistica;

import java.util.Scanner;

/**
 *
 * @author itrascastro
 */
public class Furgoneta {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private String matricula;
    private int quilometratge;
    private double volumCarrega;

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Furgoneta          
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public Furgoneta(String codi, String matricula, int quilometratge, double volumCarrega) {
        this.codi = codi;
        this.matricula = matricula;
        this.quilometratge = quilometratge;
        this.volumCarrega = volumCarrega;
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

    public double getVolumCarrega() {
        return this.volumCarrega;
    }

    public void setVolumCarrega(double volumCarrega) {
        this.volumCarrega = volumCarrega;
    }

    /*
     * TODO
     *
     * Nom del mètode: addFurgoneta
     *
     * Paràmetres: cap
    
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova furgoneta. Les dades a
     *   demanar són les que necessita el constructor.
     *
     * Retorn: Objecte Furgoneta creat.
     */
    public static Furgoneta addFurgoneta() {
        System.out.println("\nCodi de la furgoneta: ");
        String codi = DADES.nextLine();

        System.out.println("\nMatrícula de la furgoneta: ");
        String matricula = DADES.nextLine();
        
        System.out.println("\nQuilometratge de la furgoneta: ");
        int quilometratge = Integer.parseInt(DADES.nextLine());
        
        System.out.println("\nVolum de càrrega de la furgoneta: ");
        double volumCarrega = Double.parseDouble(DADES.nextLine());

        return new Furgoneta(codi, matricula, quilometratge, volumCarrega);
    }

    /*
     * TODO
     *
     * Nom del mètode: updateFurgoneta
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de la furgoneta i modificar els
     *   atributs corresponents d'aquesta furgoneta.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     *
     * Retorn: cap
     */
    public void updateFurgoneta() {
        System.out.println("\nCodi de la furgoneta: " + this.getCodi());
        System.out.println("Entra el nou valor del codi: ");
        codi = DADES.nextLine();

        System.out.println("\nMatrícula de la furgoneta: " + this.getMatricula());
        System.out.println("Entra el nou valor de la matrícula:");
        matricula = DADES.nextLine();
        
        System.out.println("\nQuilometratge de la furgoneta: " + this.getQuilometratge());
        System.out.println("\nEntra el nou valor del quilometratge:");
        quilometratge = Integer.parseInt(DADES.nextLine());
        
        System.out.println("\nVolum de càrrega de la furgoneta: " + this.getVolumCarrega());
        System.out.println("Entra el nou valor del volum de càrrega:");
        volumCarrega = Double.parseDouble(DADES.nextLine());
    }

    /*
     * TODO
     *
     * Nom del mètode: showFurgoneta
     * 
     * Accions:
     * - Mètode per imprimir les dades de la furgoneta i el seu cost de manteniment.
     *
     * Retorn: cap
     */
    public void showFurgoneta() {
        System.out.println("\nLes dades de la furgoneta amb codi " + this.getCodi() + " són: ");
        System.out.println("\nMatrícula: " + this.getMatricula());
        System.out.println("\nQuilometratge: " + this.getQuilometratge());
        System.out.println("\nVolum de càrrega: " + this.getVolumCarrega());
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
     * - Mètode que retornarà el cost de manteniment de la furgoneta. El cost de manteniment
     *   es calcula multiplican el kilometratge de la furgoneta per 0.2 i sumant el volum de
     *   carrega de la furgoneta multiplicat per 50.
     *
     * Retorn: cost de manteniment de la furgoneta actual (double).
     */
    public double costManteniment(){
        return (this.getQuilometratge() * 0.1) + (this.getVolumCarrega() * 50);
    }
}
