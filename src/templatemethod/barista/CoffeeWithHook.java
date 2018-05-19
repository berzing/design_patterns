package templatemethod.barista;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 咖啡(钩子版)
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    private String getUserInput(){
        String answer = null;
        System.out.println("咖啡加不加牛奶或者糖?(y/n)");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }

    public boolean customerWantsCondiments(){
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }else{
            return false;
        }
    }
}
