import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class ControladorMecanico {
    private Menu menu;
   // private Vintage vintage;
    private ControladorCentral controladorCentral;

    public ControladorMecanico(ControladorCentral controladorCentral){
     //   this.vintage = vintage;
        this.menu = new Menu();
        this.controladorCentral = controladorCentral;
    }
    
    public void run(/*Vintage vintage,*/ int id){
        int servico = -1;
        Set<Integer> listaServicos = new HashSet<>();
        while(true){
            int opcaoEscolhida = -1;
            do{
                try {
                    opcaoEscolhida = menu.MenuMecanico();
                }catch (InputMismatchException e) {
                    System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (opcaoEscolhida < 0 || opcaoEscolhida > 3);
            
            
            switch(opcaoEscolhida){
                case 1: //Quero consultar serviço a realizar
                break;
                case 2: //Quero marcar serviço como realizado
                 
                break;
                case 3: //Check-UP
                    int opcao = -1;
                    String matricula = menu.PedirMatricula();
                    //Verificar se carro existe
                    while(true){
                        do{
                            try {
                                opcao = menu.MenuMecanicoCheckUP();
                            }catch (InputMismatchException e) {
                                System.out.println("\n!!!!Digite um número inteiro válido!!!!\n");
                            }catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (opcao < 0 || opcao > 2);

                        if(opcao == 1){
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
                        }else if (opcao == 2){
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
                        }
                        if(opcao == 0){
                            break;
                        }
                        System.out.println("Lista de serviços: " + listaServicos);
                    }
                break;
                case 0:
                    System.out.println("\nTerminada a sessão");
                    System.exit(0);
                break;

            }
        }
    }
}
