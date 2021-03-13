import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder password = new StringBuilder(input);
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "TakeOdd":
                    StringBuilder pass = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            pass=pass.append(password.charAt(i));
                        }
                    }
                    password = new StringBuilder(pass);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(token[1]);
                    int lenght = Integer.parseInt(token[2]);
                    StringBuilder cutted = new StringBuilder(password);
                    String s = cutted.substring(index, index + lenght);
                    password = new StringBuilder(password.toString().replaceFirst(s, ""));
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring1 = token[1];
                    String substitute = token[2];
                    if (password.toString().contains(substring1)) {
                        password = new StringBuilder(password.toString().replaceAll(substring1, substitute));
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s",password);
    }
}
