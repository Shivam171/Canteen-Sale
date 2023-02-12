import java.util.Scanner;

public class CanteenSale {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = 7;
        int items = 2;
        int[][][] sales = new int[days][items][2];
        int[] totalSale = new int[days];

        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                                *  MY CANTEEN  *                                    |");
        System.out.println("|------------------------------------------------------------------------------------|");

        // Input the sales of perishable and non-perishable items for each day
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < items; j++) {
                System.out.println("| Is item " + (j + 1) + " perishable for day " + (i + 1)
                        + "? (Enter 1 for perishable and 0 for non-perishable)  |");
                System.out.print("| -> ");
                sales[i][j][0] = scan.nextInt();
                System.out.println(
                        "|------------------------------------------------------------------------------------|");
                System.out.print("| Enter sales of item " + (j + 1) + " for day " + (i + 1) + " -> ");
                sales[i][j][1] = scan.nextInt();
                totalSale[i] += sales[i][j][1];
            }
        }

        System.out.println("|------------------------------------------------------------------------------------|");
        System.out.println("|                             *  CALCULATING.SALES.. *                               |");
        System.out.println("|------------------------------------------------------------------------------------|");

        // Calculate the total sale for each day
        for (int i = 0; i < days; i++) {
            System.out.println("| Total sale for day " + (i + 1) + ": " + totalSale[i]);
        }

        System.out.println("|------------------------------------------------------------------------------------|");

        // Find the highest and lowest sale of an item for each day
        for (int i = 0; i < days; i++) {
            int highestSale = 0;
            int highestSaleIndex = 0;
            int lowestSale = Integer.MAX_VALUE;
            int lowestSaleIndex = 0;
            for (int j = 0; j < items; j++) {
                if (sales[i][j][1] > highestSale) {
                    highestSale = sales[i][j][1];
                    highestSaleIndex = j;
                }
                if (sales[i][j][1] < lowestSale) {
                    lowestSale = sales[i][j][1];
                    lowestSaleIndex = j;
                }
            }
            System.out
                    .println("| For day " + (i + 1) + " highest sale item is " + (highestSaleIndex + 1) + " with sales "
                            + highestSale);
            System.out.println("| For day " + (i + 1) + " lowest sale item is " + (lowestSaleIndex + 1) + " with sales "
                    + lowestSale);
            System.out
                    .println("|------------------------------------------------------------------------------------|");
        }
    }
}
