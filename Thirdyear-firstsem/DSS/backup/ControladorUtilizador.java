import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;

public class ControladorUtilizador {
    private Menu menu;
   // private Vintage vintage;
    private ControladorCentral controladorCentral;

    public ControladorUtilizador(ControladorCentral controladorCentral){
     //   this.vintage = vintage;
        this.menu = new Menu();
        this.controladorCentral = controladorCentral;
    }
    
    public void run(/*Vintage vintage,*/ String email){
        int servico = -1;
        Set<Integer> listaServicos = new HashSet<>();

        while(true){
            int opcaoEscolhida = -1;
            do{
                try {
                    opcaoEscolhida = menu.MenuUtilizadorServicos();
                }catch (InputMismatchException e) {
                    System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (opcaoEscolhida < 0 || opcaoEscolhida > 2);
            
            switch(opcaoEscolhida){
                case 1:
                while (true) {
                    try {
                        servico = menu.MenuServicosUniversais();
                    }catch (InputMismatchException e) {
                        System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    while (opcaoEscolhida < 0 || opcaoEscolhida > 9); 

                    if(servico == 0){
                        break;
                    }
                    if(servico != -1){
                        listaServicos.add(servico);
                    }
                }

                break;
                case 2:
                //CÓDIGO PARA VERIFICAR O TIPO DE VEICULO E ESCOLHER O MENU
                // VALOR DO i = 0 SE FOR NORMAL i = 1 SE FOR HIBRIDO
                while (true) {
                    try {
                        servico = menu.MenuServicosEspecificosCombustaoDiesel(1);
                    }catch (InputMismatchException e) {
                        System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    while (opcaoEscolhida < 0 || opcaoEscolhida > 11);     
                    if(servico == 0){
                        break;
                    }
                    if(servico != -1){
                        listaServicos.add(servico);
                    }
                }
                    /*while (true) {
                        do{
                        try {
                            servicoUniversal = menu.MenuServicosEspecificosCombustaoDiesel(0);
                        }catch (InputMismatchException e) {
                            System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                        }catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        }while (opcaoEscolhida < 0 || opcaoEscolhida > 9);     
                        if(servico == 0){
                            break;
                        }
                        if(servico != -1){
                            listaServicos.add(servico);
                        }
                    } */
                    System.out.println("Lista de serviços: " + listaServicos);
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;

            }
        }
    }
}
