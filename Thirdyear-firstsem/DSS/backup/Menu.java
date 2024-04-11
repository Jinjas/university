import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public  int MenuInicial() throws IllegalArgumentException{
        StringBuilder str = new StringBuilder("          Seja bem vindo a Oficina\n\n");
        
        str.append("1 -> Iniciar sessão como Utilizador\n");
        str.append("2 -> Iniciar sessão como Mecânico\n");
        str.append("0 -> Sair\n\n");
        str.append("Selecione um número para prosseguir: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        int opcaoEscolhida = input.nextInt();
        if (opcaoEscolhida < 0 || opcaoEscolhida > 2) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 2!!!\n");
        }
        return opcaoEscolhida;
    }

     public int scannerInt(String message, Scanner s) {
        try {
            System.out.print(message);
            return s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n!!!Entrada inválida. Por favor, insira um valor inteiro!!!\n");
            s.nextLine();
            return scannerInt(message, s);
        }
    }
    
    public double scannerDouble(String message, Scanner s) {
        try {
            System.out.print(message);
            return s.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("\n!!!Entrada inválida. Por favor, insira um valor inteiro ou double!!!\n");
            s.nextLine(); 
            return scannerDouble(message, s); 
        }
    }

    public boolean scannerBoolean(String message, Scanner s) {
        try {
            System.out.print(message);
            return s.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("\n!!!Entrada inválida. Por favor, insira 'true' ou 'false'!!!");
            s.nextLine();
            return scannerBoolean(message, s); 
        }
    }
    
    public String scannerString(String message, Scanner s) {
        System.out.print(message);
        return s.nextLine();
    }

    public String MenuLoginUtilizador(){
        StringBuilder sb = new StringBuilder("\n\n\n------------INICIAR SESSAO---------\n\n");
        sb.append("Insira os seus dados.\n\n");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        String email = scannerString("Endereço de e-mail: ", scanner);
        return email;
    }

    public int MenuLoginMecanico(){
        StringBuilder sb = new StringBuilder("\n\n\n------------INICIAR SESSAO---------\n\n");
        sb.append("Insira os seus dados.\n\n");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        int id = scannerInt("Identificardor Privado: ", scanner);
        return id;
    }

    public  int MenuUtilizador() throws IllegalArgumentException{
        StringBuilder str = new StringBuilder("          Seja bem vindo á Oficina\n\n");
        
        str.append("1 -> Quero um pack simples\n");
        str.append("2 -> Quero requisitar serviço/s para os meu veículo\n");
        str.append("0 -> Sair\n\n");
        str.append("Selecione um número para prosseguir: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        int opcaoEscolhida = input.nextInt();
        if (opcaoEscolhida < 0 || opcaoEscolhida > 2) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 2!!!\n");
        }
        return opcaoEscolhida;
    }

    public  int MenuUtilizadorServicos() throws IllegalArgumentException{
        StringBuilder str = new StringBuilder("\n\n\n-----------MENU UTILIZADOR-----------\n\n");
        
        str.append("1 -> Quero serviços universais\n");
        str.append("2 -> Quero serviços especificos para o meu veículo\n");
        str.append("0 -> Sair\n\n");
        str.append("Selecione um número para prosseguir: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        int opcaoEscolhida = input.nextInt();
        if (opcaoEscolhida < 0 || opcaoEscolhida > 2) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 2!!!\n");
        }
        return opcaoEscolhida;
    }

    public  int MenuMecanicoCheckUP() throws IllegalArgumentException{
        StringBuilder str = new StringBuilder("\n\n\n-----------MENU UTILIZADOR-----------\n\n");
        
        str.append("1 -> Quero adicionar serviços universais ao veículo\n");
        str.append("2 -> Quero serviços especificos para ao veículo\n");
        str.append("0 -> Voltar atrás\n\n");
        str.append("Selecione um número para prosseguir: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        int opcaoEscolhida = input.nextInt();
        if (opcaoEscolhida < 0 || opcaoEscolhida > 2) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 2!!!\n");
        }
        return opcaoEscolhida;
    }

     public  int MenuMecanico() throws IllegalArgumentException{
        StringBuilder str = new StringBuilder("\n\n\n-----------MENU MECÂNICO-----------\n\n");
        
        str.append("1 -> Quero consultar serviço a realizar\n");
        str.append("2 -> Quero marcar um serviço como realizado\n");
        str.append("3 -> Quero realizar um Check-Up\n");
        str.append("0 -> Sair\n\n");
        str.append("Selecione um número para prosseguir: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        int opcaoEscolhida = input.nextInt();
        if (opcaoEscolhida < 0 || opcaoEscolhida > 3) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 3!!!\n");
        }
        return opcaoEscolhida;
    }


    public void avisos(int a){
        StringBuilder sb = new StringBuilder();
        if (a==1) sb.append("!!!Email Inválido!!!").append("\n");
        if (a==3) sb.append("!!!Identificador Inválido!!!").append("\n");
        sb.append("\nPressione no enter...");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public String PedirMatricula(){
        StringBuilder sb = new StringBuilder("\n\n\n------------INFORMAÇÕES---------\n\n");
        sb.append("Insira a matricula do carro que vai ser tratado.\n\n");
        System.out.print(sb.toString());
        Scanner scanner = new Scanner(System.in);
        String matricula = scannerString("Matrícula: ", scanner);
        return matricula;
    }

    public int MenuServicosUniversais() throws IllegalArgumentException {
        StringBuilder str = new StringBuilder("\n\n\n------------SERVIÇOS UNIVERSAIS---------\n\n");

        str.append("1 -> Substituição dos pneus\n");
        str.append("2 -> Calibragem das rodas\n");
        str.append("3 -> Alinhamento da direção\n");
        str.append("4 -> Substituição dos injetores\n");
        str.append("5 -> Substituição dos calços dos travões\n");
        str.append("6 -> Mudança do óleo dos travões\n");
        str.append("7 -> Limpeza do interior\n");
        str.append("8 -> Limpeza do exterior \n");
        str.append("9 -> Substituição do filtro de ar da cabine\n");
        str.append("0 -> Requisitação concluída\n\n");
        str.append("Selecione o número do serviço que quer requisitar: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            // Limpar a entrada não inteira
            input.next();
            System.out.println("\n!!!!Entrada inválida!!!! Digite um valor numérico!!!\n");
            System.out.print(str.toString());
        }
        int opcaoEscolhida = input.nextInt();

        if (opcaoEscolhida < 0 || opcaoEscolhida > 9) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 9!!!\n");
        }
        return opcaoEscolhida;
    }

    public  int MenuServicosEspecificosCombustaoDiesel(int i) throws IllegalArgumentException{
        int tipo1 = 9;
        int tipo2 = 9;
        StringBuilder str = new StringBuilder("\n\n\n------------SERVIÇOS ESPECIFICOS---------\n\n");
        if(i == 0){
            //COMBUSTÃO
            str.append("1 -> Mudança de óleo do motor\n");
            str.append("2 -> Substituição dos filtros de Óleo\n");
            str.append("3 -> Substituição dos filtros de Combustível\n");
            str.append("4 -> Substituição dos filtros de Ar do motor\n");
            str.append("5 -> Substituição do conversor catalítico\n");
            str.append("6 -> Substituição da bateria de arranque\n");
            //DIESEL
            str.append("7 -> Substituição das velas de incandescência\n");
            str.append("8 -> Regeneração do filtro de partículas\n");
            str.append("9 -> Substituição do filtro de partículas\n");
            str.append("0 -> Requisitação concluída\n\n");
            str.append("Selecione o número do serviço que quer requisitar: ");
            System.out.print(str.toString());
            Scanner input = new Scanner(System.in);
            int opcaoEscolhida = input.nextInt();
            if (opcaoEscolhida < 0 || opcaoEscolhida > 9) {
                throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 9!!!\n");
            }
            if(opcaoEscolhida != 0){
                return opcaoEscolhida+tipo1;
            }
            return opcaoEscolhida;
        }//eletrico
        else if(i == 1){
            //COMBUSTÃO
            str.append("1 -> Mudança de óleo do motor\n");
            str.append("2 -> Substituição dos filtros de Óleo\n");
            str.append("3 -> Substituição dos filtros de Combustível\n");
            str.append("4 -> Substituição dos filtros de Ar do motor\n");
            str.append("5 -> Substituição do conversor catalítico\n");
            str.append("6 -> Substituição da bateria de arranque\n");
            //DIESEL
            str.append("7 -> Substituição das velas de incandescência\n");
            str.append("8 -> Regeneração do filtro de partículas\n");
            str.append("9 -> Substituição do filtro de partículas\n");
            //HIBRIDO-DIESEL
            str.append("10 -> Avaliação do desempenho da bateria\n");
            str.append("11 -> Substituição da bateria\n");
            str.append("0 -> Requisitação concluída\n\n");
            str.append("Selecione o número do serviço que quer requisitar: ");
            System.out.print(str.toString());
            Scanner input = new Scanner(System.in);
            int opcaoEscolhida = input.nextInt();
            if (opcaoEscolhida < 0 || opcaoEscolhida > 11) {
                throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 11!!!\n");
            }
            if(opcaoEscolhida >= 1 && opcaoEscolhida <= 9){
                return opcaoEscolhida+tipo1;
            }
            else if(opcaoEscolhida == 10 || opcaoEscolhida == 11){
                return opcaoEscolhida+tipo2;
            }
            return opcaoEscolhida;
        }
        return -1;
    }

    public  int MenuServicosEspecificosCombustaoGasolina(int i) throws IllegalArgumentException{
        int tipo1 = 9;
        int tipo3 = 14;
        StringBuilder str = new StringBuilder("\n\n\n------------SERVIÇOS ESPECIFICOS---------\n\n");
        if(i == 2){
            //COMBUSTÃO
            str.append("1 -> Mudança de óleo do motor\n");
            str.append("2 -> Substituição dos filtros de Óleo\n");
            str.append("3 -> Substituição dos filtros de Combustível\n");
            str.append("4 -> Substituição dos filtros de Ar do motor\n");
            str.append("5 -> Substituição do conversor catalítico\n");
            str.append("6 -> Substituição da bateria de arranque\n");
            //GASOLINA
            str.append("7 -> Substituição das velas de incandescência\n");
            str.append("8 -> Regeneração do filtro de partículas\n");
            str.append("0 -> Requisitação concluída\n\n");
            str.append("Selecione o número do serviço que quer requisitar: ");
            System.out.print(str.toString());
            Scanner input = new Scanner(System.in);
            int opcaoEscolhida = input.nextInt();
            if (opcaoEscolhida < 0 || opcaoEscolhida > 8) {
                throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 8!!!\n");
            }
            if(opcaoEscolhida >= 1 && opcaoEscolhida <= 6){
                return opcaoEscolhida+tipo1;
            }
            else if(opcaoEscolhida == 7 || opcaoEscolhida == 8){
                return opcaoEscolhida+tipo3;
            }
            return opcaoEscolhida;   
        } 
        else if(i == 3){
            //COMBUSTÃO
            str.append("1 -> Mudança de óleo do motor\n");
            str.append("2 -> Substituição dos filtros de Óleo\n");
            str.append("3 -> Substituição dos filtros de Combustível\n");
            str.append("4 -> Substituição dos filtros de Ar do motor\n");
            str.append("5 -> Substituição do conversor catalítico\n");
            str.append("6 -> Substituição da bateria de arranque\n");
            //GASOLINA
            str.append("7 -> Substituição das velas de incandescência\n");
            str.append("8 -> Regeneração do filtro de partículas\n");
            //HIBRIDO-GASOLINA
             str.append("9 -> Avaliação do desempenho da bateria\n");
            str.append("10 -> Substituição da bateria\n");
            str.append("0 -> Requisitação concluída\n\n");
            str.append("Selecione o número do serviço que quer requisitar: ");
            System.out.print(str.toString());
            Scanner input = new Scanner(System.in);
            int opcaoEscolhida = input.nextInt();
            if (opcaoEscolhida < 0 || opcaoEscolhida > 10) {
                throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 10!!!\n");
            }
            if(opcaoEscolhida >= 1 && opcaoEscolhida <= 6){
                return opcaoEscolhida+tipo1;
            }
            else if(opcaoEscolhida >= 7 && opcaoEscolhida <= 10){
                return opcaoEscolhida+tipo3;
            }
            return opcaoEscolhida;
        }
        return -1;
    }

     public  int MenuServicoEletrico() throws IllegalArgumentException{
        int tipo4 = 24;
        StringBuilder str = new StringBuilder("\n\n\n------------SERVIÇOS UNIVERSAIS---------\n\n");
        //ELETRICO
        str.append("1 -> Avaliação do desempenho da bateria\n");
        str.append("2 -> Substituição da bateria\n");
        str.append("0 -> Requisitação concluída\n\n");
        str.append("Selecione o número do serviço que quer requisitar: ");
        System.out.print(str.toString());
        Scanner input = new Scanner(System.in);
        int opcaoEscolhida = input.nextInt();
        if (opcaoEscolhida < 0 || opcaoEscolhida > 2) {
            throw new IllegalArgumentException("\n!!!!Opção inválida!!!! Digite um valor entre 0 e 2!!!\n");
        }
        if(opcaoEscolhida == 1 || opcaoEscolhida == 2){
            return opcaoEscolhida+tipo4;
        }
        return opcaoEscolhida;
    }



}