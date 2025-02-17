import java.util.Scanner;

public class SalesReportGenerator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of products: ");
        int numOfProducts = 0;

        while (true) {
            try {
                numOfProducts = Integer.parseInt(scanner.nextLine());
                if (numOfProducts <= 0) {
                    System.out.println("Please enter a positive number for the products.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        String[] productNames = new String[numOfProducts];
        double[] sales = new double[numOfProducts];

        double totalSales = 0;
        double highestSales = 0;
        String highestSellingProduct = "";

        for (int i = 0; i < numOfProducts; i++) {
            System.out.println("\nEnter sales data for Product #" + (i + 1));


            System.out.print("Enter product name: ");
            productNames[i] = scanner.nextLine();

            double productSales = -1;
            while (true) {
                try {
                    System.out.print("Enter sales for " + productNames[i] + ": ");
                    productSales = Double.parseDouble(scanner.nextLine());
                    if (productSales < 0) {
                        System.out.println("Sales cannot be negative. Please enter a valid number.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid numeric value for sales.");
                }
            }

            sales[i] = productSales;

            totalSales += productSales;

            if (productSales > highestSales) {
                highestSales = productSales;
                highestSellingProduct = productNames[i];
            }
        }

        double averageSales = totalSales / numOfProducts;

        System.out.println("\nSales Report (using for loop):");
        System.out.println("------------------------------------------------");
        System.out.println("Product Name | Sales");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < numOfProducts; i++) {
            System.out.println(productNames[i] + " | " + sales[i]);
        }
        System.out.println("------------------------------------------------");

        System.out.println("Total Sales: " + totalSales);
        System.out.println("Average Sales: " + averageSales);
        System.out.println("Highest Selling Product: " + highestSellingProduct + " with " + highestSales + " sales.");

        System.out.println("\nSales Report (using nested if conditions):");
        System.out.println("------------------------------------------------");
        if (numOfProducts > 0) {
            System.out.println("Product Name | Sales");
            System.out.println("------------------------------------------------");
            for (int i = 0; i < numOfProducts; i++) {
                if (sales[i] >= 0) {
                    System.out.println(productNames[i] + " | " + sales[i]);
                }
            }
            System.out.println("------------------------------------------------");
            if (totalSales >= 0) {
                System.out.println("Total Sales: " + totalSales);
            }
            if (averageSales >= 0) {
                System.out.println("Average Sales: " + averageSales);
            }
            if (!highestSellingProduct.isEmpty()) {
                System.out.println("Highest Selling Product: " + highestSellingProduct + " with " + highestSales + " sales.");
            }
        } else {
            System.out.println("No product data available.");
        }

        scanner.close();
    }
}
