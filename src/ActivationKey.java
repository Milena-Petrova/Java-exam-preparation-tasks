import java.util.Scanner;

public class ActivationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String command = scanner.nextLine();
        StringBuilder activationKey = new StringBuilder(input);
        while (!command.equals("Generate")){
            String[]token = command.split(">>>");
            switch (token[0]){
                case "Contains":
                    String substring = token[1];
                    if(activationKey.toString().contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String cases = token[1];
                    int startIndex = Integer.parseInt(token[2]);
                    int endIndex = Integer.parseInt(token[3]);
                    switch (cases){
                        case "Upper":
                            String substring1 = activationKey.substring(startIndex, endIndex).toUpperCase();
                            activationKey = activationKey.replace(startIndex,endIndex,substring1);
                            break;
                        case "Lower":
                            String substring2 = activationKey.substring(startIndex, endIndex).toLowerCase();
                            activationKey = activationKey.replace(startIndex,endIndex,substring2);
                            break;
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int start = Integer.parseInt(token[1]);
                    int endI = Integer.parseInt(token[2]);
                    activationKey=activationKey.replace(start,endI,"");
                    System.out.println(activationKey);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s",activationKey);
    }
}
