/*
 * Classe que defineix una motocicleta d'una flota. 
 * Es defineix pel seu codi, matrícula, quilometratge i la seva cilindrada en cc.
 */
package logistica;

import java.util.Scanner;

/**
 *
 * @author itrascastro
 */
public class Motocicleta {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private String matricula;
    private int quilometratge;
    private int cilindrada;

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Motocicleta
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public Motocicleta(String codi, String matricula, int quilometratge, int cilindrada) {
        this.codi = codi;
        this.matricula = matricula;
        this.quilometratge = quilometratge;
        this.cilindrada = cilindrada;
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

    public int getCilindrada() {
        return this.cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /*
     * TODO
     *
     * Nom del mètode: addMotocicleta
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar les dades per consola per crear una motocicleta. 
     *   Les dades a demanar són les que necessita
     *   el constructor.
     * 
     * Retorn: Objecte Motocicleta creat.
     */
    public static Motocicleta addMotocicleta() {
        System.out.println("\nCodi de la motocicleta: ");
        String codi = DADES.nextLine();

        System.out.println("\nMatrícula de la motocicleta: ");
        String matricula = DADES.nextLine();

        System.out.println("\nQuilometratge de la motocicleta: ");
        int quilometratge = Integer.parseInt(DADES.nextLine());

        System.out.println("\nCilindrada de la motocicleta: ");
        int cilindrada = Integer.parseInt(DADES.nextLine());

        return new Motocicleta(codi, matricula, quilometratge, cilindrada);
    }

    /*
     * TODO
     *
     * Nom del mètode: updateMotocicleta
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de la motocicleta i modificar els
     *   atributs corresponents d'aquesta motocicleta.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     *
     * Retorn: cap
     */
    public void updateMotocicleta() {
        System.out.println("\nCodi de la motocicleta: " + this.getCodi());
        System.out.println("Entra el nou valor codi:");
        codi = DADES.nextLine();

        System.out.println("\nMatrícula de la motocicleta: " + this.getMatricula());
        System.out.println("Entra el nou valor matrícula:");
        matricula = DADES.nextLine();
        
        System.out.println("\nQuilometratge de la motocicleta: " + this.getQuilometratge());
        System.out.println("Entra el nou valor quilometratge:");
        quilometratge = Integer.parseInt(DADES.nextLine());
        
        System.out.println("\nCilindrada de la motocicleta: " + this.getCilindrada());
        System.out.println("Entra el nou valor cilindrada:");
        cilindrada = Integer.parseInt(DADES.nextLine());
    }

    /*
     * TODO
     *
     * Nom del mètode: showMotocicleta
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades de la motocicleta actual i el cost del seu manteniment.
     * 
     * Retorn: cap    
     */
    public void showMotocicleta() {
        System.out.println("\nLes dades de la motocicleta amb codi " + this.getCodi() + " són:");
        System.out.println("\nMatrícula: " + this.getMatricula());
        System.out.println("\nQuilometratge: " + this.getQuilometratge());
        System.out.println("\nCilindrada: " + this.getCilindrada());
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
     * - Mètode que retornarà el cost del manteniment de la motocicleta actual.
     * - El cost del manteniment es calcula multiplican el quilometratge de la motocicleta per 0.05
     *   i sumant la cilindrada de la motocicleta multiplicada per 0.2.
     *
     * Retorn: Cost de manteniment de la motocicleta actual (double). 
     */
    public double costManteniment() {
        return (double) (this.getQuilometratge() * 0.05) + (this.getCilindrada() * 0.2);
    }
}
