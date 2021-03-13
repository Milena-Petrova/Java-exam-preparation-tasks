import javafx.scene.shape.PathElement;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        String regex = "^@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < input; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.printf("Product group: %s%n", productGroup(matcher.group()));
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }

    private static String productGroup(String barcode) {
        String productGroup = "";
        int count = 0;
        for (int i = 0; i < barcode.length(); i++) {
            if (Character.isDigit(barcode.charAt(i))) {
                productGroup += barcode.charAt(i);
                count++;
            }
        }
        if (count == 0) {
            productGroup = "00";
        }
        return productGroup;
    }
}