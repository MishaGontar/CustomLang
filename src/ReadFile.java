import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public  void readFile(String path){
        File file= new File(path);
        try(Scanner sc = new Scanner(file)){
            while (sc.hasNext()){
                String[] strings = sc.nextLine().split("\\W+");
                ReadFile readFile = new ReadFile();
                readFile.push(strings);
            }
        }catch (Exception e) {
            System.out.println("Something wrong !");
        }

    }
    static ArrayList <Double> stack = new ArrayList<>();

    private  void push (String[] strings){
        for (int i = 0 ; i<strings.length; i++) {
            switch (strings[i]){
                case ("PUSH"):
                    if (strings[i + 1] != null){
                        try {
                            double a = Double.parseDouble(strings[i + 1]);
                            stack.add(a);
                        }
                        catch (NumberFormatException e) {
                        }
                    }
                    break;
                case ("ADD"):
                    if(stack.size() > 1){
                        double a = stack.get(stack.size() - 1);
                        double b = stack.get(stack.size() - 2);
                        stack.remove(stack.size() - 1);
                        stack.remove(stack.size() - 1);
                        stack.add(a + b);
                    }
                    break;
                case ("MINUS"):
                    if(stack.size() > 1){
                        double a = stack.get(stack.size() - 1);
                        double b = stack.get(stack.size() - 2);
                        stack.remove(stack.size() - 1);
                        stack.remove(stack.size() - 1);
                        stack.add(a - b);
                    }
                    break;
                case ("CLEAR"):
                    stack.clear();
                    break;
                case ("MULTIPLY"):
                    if(stack.size() > 1){
                        double a = stack.get(stack.size() - 1);
                        double b = stack.get(stack.size() - 2);
                        stack.remove(stack.size() - 1);
                        stack.remove(stack.size() - 1);
                        stack.add(a * b);
                    }
                    break;
                case ("DIVIDE"):
                    if(stack.size() > 1){
                        double a = stack.get(stack.size() - 1);
                        double b = stack.get(stack.size() - 2);
                        stack.remove(stack.size() - 1);
                        stack.remove(stack.size() - 1);
                        stack.add(a / b);
                    }
                    break;
                case ("POP"):
                    if (stack.size() > 0) {
                        System.out.println(stack.get(stack.size() - 1));
                        stack.remove(stack.size() - 1);
                    }
                    break;
                case ("PICK"):
                    if (stack.size() >0) {
                        System.out.println(stack.get(stack.size() - 1));
                    }
                    break;
            }
        }
    }
}
