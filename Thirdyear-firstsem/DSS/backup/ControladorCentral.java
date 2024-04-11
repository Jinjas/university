import java.io.IOException;
import java.io.NotSerializableException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Collection;

public class ControladorCentral{

    private Menu menu;
    private OficinaLN oficina;
    private ControladorMecanico cM;
    private ControladorUtilizador cU;
    
    public ControladorCentral(){
        this.menu = new Menu();
        this.oficina = new OficinaLN();
        this.cM = new ControladorMecanico( this);
        this.cU = new ControladorUtilizador(this);
    }

    public void correrPrograma(){

        while(true){
            int opcaoEscolhida = -1;
            do{
                try {
                    opcaoEscolhida = menu.MenuInicial();
                }catch (InputMismatchException e) {
                    System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (opcaoEscolhida < 0 || opcaoEscolhida > 2);
            
            switch(opcaoEscolhida){

                case 1:
                    String emailU = menu.MenuLoginUtilizador();
                    String matricula = menu.PedirMatricula();
                   // if(vintage.existeContaU(emailI) == false) menu.avisos(1);
                   // else 
                   cU.run(emailU);
                break;
                case 2:
                System.out.println("aqui");
                    int idM = menu.MenuLoginMecanico();
                    cM.run(idM);
                    //if(vintage.existeContaU(emailR) == false) menu.avisos(2);
                    //else{
                    //    System.out.println("Foi resgistado com sucesso\n");
                    //    correrPrograma();
                    //    cU.run(vintage, emailR);
                    //}
                break;
                case 0:

                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                    break;
                default: 
                    break;
            }
        }
    }
}

