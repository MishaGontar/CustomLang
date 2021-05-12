import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public static void readFile(String path){
        File file= new File(path);
        try(Scanner sc = new Scanner(file)){
            while (sc.hasNext()){
                String[] strings = sc.nextLine().split(" ");
                push(strings);
            }
        }catch (Exception e) {
            System.out.println("Something wrong !");
        }
    }

    static boolean console = false;
    static boolean add = false;
    static boolean minus = false;

    private static void push (String[] strings){
        ArrayList <String> answer = new ArrayList<>();
        for (int i = 0 ; i<strings.length; i++) {
            switch (strings[i]){
                case ("PUSH"):
                    console = true;
                    break;
                case("END"):
                    console = false;
                    break;
                case ("ADD"):
                    add = true;
                    break;
                case ("MINUS"):
                    minus = true;
                    break;
            }
            if (add && console || minus && console ){
                if (strings[i + 1] != null && strings[i + 2] != null ){
                    try {
                       int a = Integer.parseInt(strings[i + 1]);
                       int b = Integer.parseInt(strings[i + 2]);
                       if (add){
                           answer.add("Operation ADD for `"+ strings[i + 1] + "` and `" + strings[i + 2] + "` is " + (a + b) );
                       }
                       if (minus) {
                           answer.add("Operation MINUS for `"+ strings[i + 1] + "` and `" + strings[i + 2] + "` is " + (a - b) );
                       }
                    }catch (NumberFormatException e) {
                        System.out.println(" Wrong operation with numbers `"+ strings[i + 1] + "` and `" + strings[i + 2] + "`");
                    }
                }
                add = false;
                minus = false;
            }

        }
        answer.stream().forEach(s -> System.out.println(s));
    }
}
