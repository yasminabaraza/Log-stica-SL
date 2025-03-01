package principal;

import logistica.EmpresaLogistica;
import java.util.Scanner;

/**
 *
 * @author itrascastro
 */
public class Application {
    private final static Scanner DADES = new Scanner (System.in);

    private static EmpresaLogistica[] empresesLogistica = new EmpresaLogistica[10];
    private static int pEmpresesLogistica = 0; //Primera posició buida del vector empresesLogistica
    private static EmpresaLogistica empresaLogisticaActual = null;

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nMenú principal. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió d'empreses de logística");
            System.out.println("\n2. Gestió de flotes");
            System.out.println("\n3. Gestió de camions");
            System.out.println("\n4. Gestió de furgonetes");
            System.out.println("\n5. Gestió de motocicletes");
            System.out.println("\n");       

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuEmpresesLogistica();
                    break;
                case 2:
                    if (empresaLogisticaActual != null) {
                        menuFlotes();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'empresa logística al menú 1. Gestió d'empreses de logística.");
                    }
                    break;
                case 3:
                    if (empresaLogisticaActual != null) {
                        menuCamions();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'empresa logística al menú 1. Gestió d'empreses de logística.");
                    }
                    break;
                case 4:
                    if (empresaLogisticaActual != null) {
                        menuFurgonetes();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'empresa logística al menú 1. Gestió d'empreses de logística.");
                    }
                    break;
                case 5:
                    if (empresaLogisticaActual != null) {
                        menuMotocicletes();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'empresa logística al menú 1. Gestió d'empreses de logística.");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuEmpresesLogistica() {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nMenú d'empreses de logística. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llistar");
            System.out.println("\n");  

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    EmpresaLogistica novaEmpresaLogistica = EmpresaLogistica.addEmpresaLogistica();

                    indexSel = selectEmpresaLogistica(novaEmpresaLogistica);

                    if (indexSel == -1) {
                        empresesLogistica[pEmpresesLogistica] = novaEmpresaLogistica;
                        pEmpresesLogistica++;
                    } else {
                        System.out.println("\nL'empresa logística ja existeix");
                    }

                    break;
                case 2:
                    indexSel = selectEmpresaLogistica(null);

                    if (indexSel >= 0) {
                        empresaLogisticaActual = empresesLogistica[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquesta empresa");
                    }
                    break;
                case 3:
                    indexSel = selectEmpresaLogistica(null);

                    if (indexSel >= 0) {
                        empresesLogistica[indexSel].updateEmpresaLogistica();
                    } else {
                        System.out.println("\nNo existeix aquesta empresa");
                    }
                    break;
                case 4:
                    for (int i = 0; i < pEmpresesLogistica; i++) {
                        empresesLogistica[i].showEmpresaLogistica();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     * TODO
     * 
     * Nom del mètode: menuFlotes
     *     
     * Heu de desenvolupar el menuFlotes amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut empresaLogisticaActual no és null.
     * 
     * Opció 0. Sortir          --> Surt del menú i retorna al menú principal.
     * Opció 1. Alta            --> Crea una Flota de l'empresa logística actual. Noteu que EmpresaLogistica sap crear Flotes.        
     * Opció 2. Modificar       --> Permet modificar una Flota de l'empresa logística actual.
     * (per comprovar l'existència d'una flota tenim un mètode en la classe EmpresaLogistica que ens ajuda).
     * Opció 3. Llista Flotes   --> Imprimeix les dades de les flotes de l'empresa logística actual.
     * 
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida.
     *
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions.
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge.
     * "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter.
     */
    public static void menuFlotes() {
        int opcio;

        do {
            System.out.println("\nMenú de flotes. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");
            System.out.println("\n");  

            opcio = Integer.parseInt(DADES.nextLine());
            
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    empresaLogisticaActual.addFlota();
                    break;
                case 2:
                    int indexSel = empresaLogisticaActual.selectFlota(null);

                    if (indexSel >= 0) {
                        empresaLogisticaActual.getFlotes()[indexSel].updateFlota();
                    } else {
                        System.out.println("\nNo existeix aquest Flota");
                    }
                    break;
                case 3:
                    for (int i = 0; i < empresaLogisticaActual.getpFlotes(); i++) {
                        empresaLogisticaActual.getFlotes()[i].showFlota();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     * TODO
     * 
     * Nom del mètode: menuCamions
     *     
     * Heu de desenvolupar el menuCamions amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut empresaLogisticaActual no és null
     * 
     * Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     * Opció 1. Alta -->         Crea Camió de l'Empresa Logística actual afegint-lo a una Flota. 
     *                           Penseu que EmpresaLogistica sap afegir Camió a una Flota seleccionada.       
     * Opció 2. Modificar -->    Permet modificar Camió de l'Empresa Logística actual. Penseu que tots els 
     *                           Camions d'una Empresa Logística pertanyen a una Flota d'aquesta Empresa Logística i que 
     *                           EmpresaLogistica sap modificar Camió que pertany a una de les seves Flotes.
     * Opció 3. Llista Camions --> Imprimeix les dades de tots els Camions de l'Empresa Logística actual.
     *  
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     *
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */
    public static void menuCamions() {
        int opcio;

        do {
            System.out.println("\nMenú de camions. Selecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");
            System.out.println("\n");  

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    empresaLogisticaActual.addCamioFlota();
                    break;
                case 2:
                    empresaLogisticaActual.updateCamioFlota();
                    break;
                case 3:
                    for (int i = 0; i < empresaLogisticaActual.getpFlotes(); i++) {

                        for (int j = 0; j < empresaLogisticaActual.getFlotes()[i].getpCamions(); j++) {

                            empresaLogisticaActual.getFlotes()[i].getCamions()[j].showCamio();

                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }


    /*
     * TODO
     * 
     * Nom del mètode: menuFurgonetes
     *    
     * Heu de desenvolupar el menuFurgonetes amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut empresaLogisticaActual no és null
     * 
     * Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     * Opció 1. Alta -->         Crea una Furgoneta de l'Empresa Logística actual afegint-la a una Flota. 
     *                           Penseu que EmpresaLogistica sap afegir una Furgoneta a una Flota seleccionada.       
     * Opció 2. Modificar -->    Permet modificar una Furgoneta de l'Empresa Logística actual. Penseu que totes les 
     *                           Furgonetes d'una Empresa Logística pertanyen a una Flota d'aquesta Empresa Logística i que 
     *                           EmpresaLogistica sap modificar una Furgoneta que pertany a una de les seves Flotes.
     * Opció 3. Llista Furgonetes --> Imprimeix les dades de tots/es Furgonetes de l'Empresa Logística actual.
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     * 
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */
    public static void menuFurgonetes() {
        int opcio;

        do {
            System.out.println("\nMenú de furgonetes. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");
            System.out.println("\n");  

            opcio = Integer.parseInt(DADES.nextLine());
            
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    empresaLogisticaActual.addFurgonetaFlota();
                    break;
                case 2:
                    empresaLogisticaActual.updateFurgonetaFlota();
                    break;
                case 3:
                    for (int i = 0; i < empresaLogisticaActual.getpFlotes(); i++) {

                        for (int j = 0; j < empresaLogisticaActual.getFlotes()[i].getpFurgonetes(); j++) {

                            empresaLogisticaActual.getFlotes()[i].getFurgonetes()[j].showFurgoneta();

                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     * TODO
     * 
     * Nom del mètode: menuMotocicletes
     *     
     * Heu de desenvolupar el menuMotocicletes amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut empresaLogisticaActual no és null
     * 
     * Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     * Opció 1. Alta -->         Crea una Motocicleta de l'Empresa Logística actual afegint-la a una Flota. 
     *                           Penseu que EmpresaLogistica sap afegir una Motocicleta a una Flota seleccionada.       
     * Opció 2. Modificar -->    Permet modificar una Motocicleta de l'Empresa Logística actual. Penseu que totes les 
     *                           Motocicletes d'una Empresa Logística pertanyen a una Flota d'aquesta Empresa Logística i que 
     *                           EmpresaLogistica sap modificar una Motocicleta que pertany a una de les seves Flotes.
     * Opció 3. Llista Motocicletes --> Imprimeix les dades de totes les Motocicletes de l'Empresa Logística actual.
     * 
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     * 
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */
    public static void menuMotocicletes() {
        int opcio;

        do {
            System.out.println("\nMenú de motocicletes. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");
            System.out.println("\n");  

            opcio = Integer.parseInt(DADES.nextLine());
            
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    empresaLogisticaActual.addMotocicletaFlota();
                    break;
                case 2:
                    empresaLogisticaActual.updateMotocicletaFlota();
                    break;
                case 3:
                    for (int i = 0; i < empresaLogisticaActual.getpFlotes(); i++) {

                        for (int j = 0; j < empresaLogisticaActual.getFlotes()[i].getpMotocicletes(); j++) {

                            empresaLogisticaActual.getFlotes()[i].getMotocicletes()[j].showMotocicleta();

                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static Integer selectEmpresaLogistica(EmpresaLogistica EmpresaLogistica) {
        String nom;

        if (EmpresaLogistica == null) {
            System.out.println("\nNom de l'empresa de logística:");
            nom = DADES.nextLine();
        } else {
            nom = EmpresaLogistica.getNom();
        }

        for (int i = 0; i < pEmpresesLogistica; i++) {
            if (empresesLogistica[i].getNom().equals(nom)) {
                return i;
            }
        }

        return -1;
    }
}
