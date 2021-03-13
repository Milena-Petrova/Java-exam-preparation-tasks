import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pianist {
    public static class CalssicPiece {
        String name;
        String composer;
        String key;

        public CalssicPiece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }

        public void setComposer(String composer) {
            this.composer = composer;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public String getComposer() {
            return composer;
        }

        public String getKey() {
            return key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, CalssicPiece> playlist = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\|");
            CalssicPiece piece = new CalssicPiece(line[0], line[1], line[2]);
            playlist.put(piece.getName(), piece);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] token = command.split("\\|");
            switch (token[0]) {
                case "Add"://piece, composer,key-->token1,token2, token3
                    if (playlist.containsKey((token[1]))) {
                        System.out.printf("%s is already in the collection!%n", token[1]);
                    } else {
                        CalssicPiece p1 = new CalssicPiece(token[1], token[2], token[3]);
                        playlist.put(token[1], p1);
                        System.out.printf("%s by %s in %s added to the collection!%n",token[1], token[2], token[3]);
                    }
                    break;
                case "Remove":
                    if (playlist.containsKey(token[1])) {
                        playlist.remove(token[1]);
                        System.out.printf("Successfully removed %s!%n", token[1]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", token[1]);
                    }
                    break;
                case "ChangeKey"://piece, key --> token1, token 2
                    if (playlist.containsKey(token[1])) {
                        playlist.get(token[1]).setKey(token[2]);
                        System.out.printf("Changed the key of %s to %s!%n", token[1], token[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.", token[1]);
                    }
                    break;
                default:
                    System.out.println("error'");
            }
            command = scanner.nextLine();
        }
        playlist.entrySet().stream()
//                .sorted((a,b)->a.getValue().getComposer().compareTo(b.getValue().getComposer()))
//                .sorted((f,s)->f.getKey().compareTo(s.getKey()))
                .forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n", e.getKey(), e.getValue().getComposer(), e.getValue().getKey()));

    }
}
