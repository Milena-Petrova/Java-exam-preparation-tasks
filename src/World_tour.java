import java.util.Scanner;

public class World_tour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);

        String command = scanner.nextLine();

        while(!command.equals("Travel")){
            String[]token =command.split(":");
            switch (token[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(token[1]);
                    String destination = token[2];
                    if (0 <= index && index < sb.length()) {
                        sb = sb.insert(index, destination);
                    }
                    break;
                case "Remove Stop"://startindex:end index
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    if (0 <= startIndex && startIndex < sb.length() && 0 <= endIndex && endIndex < sb.length()) {
                        sb = sb.replace(startIndex, endIndex+1, "");
                    }
                    break;
                case "Switch":
                    String switchStop = token[1];
                    String newStop = token[2];
                    if (sb.toString().contains(switchStop)) {
                        String s = sb.toString().replaceAll(switchStop, newStop);
                        sb = new StringBuilder(s);
                    }
                    break;
            }
            System.out.println(sb);
            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s",sb);
    }
}
