public class Main {
    public static void main(String[] args) {
        String line = "sd56lk38";

        int cool = 1;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                cool = (int)line.charAt(i);
                cool+=1;
            }
        }
        System.out.println(cool);
    }
}
