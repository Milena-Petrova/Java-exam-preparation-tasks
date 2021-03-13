import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem_03 {
    public static class Follower {
        String name;
        String fen;
        int likes;

        public Follower(String name, String fen, int likes) {
            this.name = name;
            this.fen = fen;
            this.likes = likes;
        }

        public String getName() {
            return name;
        }

        public String getFen() {
            return fen;
        }

        public int getLikes() {
            return likes;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setComment(String comment) {
            this.fen = comment;
        }

        public void setLikes(int likes) {
            this.likes += likes;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();


        Map<String, Follower> folllowers = new HashMap<>();

        while (!command.equals("Log out")) {
            String[] token = command.split(": ");
            switch (token[0]) {
                case "New follower":
                    String newFollower = token[1];
                    Follower newFen = new Follower(newFollower, null, 0);
                    folllowers.putIfAbsent(newFollower, newFen);
                    break;
                case "Like":
                    String likeUserName = token[1];
                    int countLikes = Integer.parseInt(token[2]);
                    Follower likeFen = new Follower(likeUserName, null, countLikes);
                    folllowers.putIfAbsent(likeUserName, likeFen);
                    likeFen.setLikes(countLikes);
                    break;
                case "Comment":
                    String commentUser = token[1];
               //     Follower fen = new Follower(commentUser, );
                    break;
                case "Blocked":
                    break;
            }


            command = scanner.nextLine();
        }
    }
}
