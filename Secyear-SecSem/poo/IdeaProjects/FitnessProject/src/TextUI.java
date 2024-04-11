import java.io.IOException;
import java.util.Scanner;

public class TextUI {



    private Fitness model;

    private Scanner sc;

    public TextUI(){
        this.model = new Fitness();
        sc = new Scanner (System.in);
    }

    public void run() {
        NewMenu menu = new NewMenu(new String[]{
                "state management", "Users", "Change name", "Show Fitness Info"
        });
        menu.setPreCondition(3, () -> this.model.getName().equals(""));

        menu.setHandler(1, this::stateManagement);
        menu.setHandler(2, this::users);
        menu.setHandler(3, this::changeName);
        menu.setHandler(4, this::showFitnessInfo);

        menu.run();
    }
    private void showFitnessInfo(){
        System.out.println(model.toString());

    }
    private void users(){
        NewMenu usersMenu = new NewMenu(new String[]{
                "add user: "
        });
        usersMenu.setHandler(1,this::addUser);
        usersMenu.run();
    }
    private void addUser(){
        System.out.println("email:");
        String email = sc.nextLine();
        this.model.addUser(email);
    }

    private void changeName(){
        System.out.println("new name: ");
        String name = sc.nextLine();
        this.model.setName(name);
    }
    private void stateManagement(){
        NewMenu stateMenu = new NewMenu(new String[]{
                "load state", "save state"
        });
        stateMenu.setHandler(1,()->loadState("state.obj"));
        stateMenu.setHandler(2,()->saveState(model));
        stateMenu.run();
    }

    private static void saveState(Fitness f){
        try {
            f.saveState("state.obj");
        } catch (IOException e){
            System.out.println("error saving state");
            //throw new RuntimeException(e);
        }
    }

    private void loadState(String filename){
        try {
            model = Fitness.loadState(filename);
        } catch(IOException | ClassNotFoundException e){
            System.out.println("could not load state");
        }
    }


}

