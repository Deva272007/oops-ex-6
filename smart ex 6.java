import java.util.Scanner;



interface Discountable {

    void applyDiscount(double percentage);

    double finalPrice();

}



abstract class Device {

    String deviceId;

    String brand;

    double price;



    public Device(String deviceId, String brand, double price) {

        this.deviceId = deviceId;

        this.brand = brand;

        this.price = price;

    }



    public abstract void displayDetails();



    public String getDeviceId() {

        return deviceId;

    }



    public double getPrice() {

        return price;

    }



    public void setPrice(double price) {

        this.price = price;

    }

}

class Smartphone extends Device implements Discountable {

    private double discountedPrice;



    public Smartphone(String deviceId, String brand, double price) {

        super(deviceId, brand, price);

        this.discountedPrice = price; // Initially, discounted price is the original price

    }



  

    public void displayDetails() {

        System.out.println("Device ID: " + deviceId);

        System.out.println("Brand: " + brand);

        System.out.println("Original Price: $" + String.format("%.2f", price));

        System.out.println("Final Price (after discount): $" + String.format("%.2f", discountedPrice));

    }



   

    public void applyDiscount(double percentage) {

        if (percentage > 0 && percentage <= 100) {

            this.discountedPrice = price * (1 - (percentage / 100));

            System.out.println("Discount of " + percentage + "% applied to Smartphone " + deviceId);

        } else {

            System.out.println("Invalid discount percentage.");

        }

    }



   

    public double finalPrice() {

        return discountedPrice;

    }

}

public class smart {

    private static Smartphone currentSmartphone = null; // To store a single smartphone without an array



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;



        do {

            System.out.println("\n--- Smart Device Store Menu ---");

            System.out.println("1. Add Smartphone");

            System.out.println("2. Apply Discount");

            System.out.println("3. View Device Details");

            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            scanner.nextLine(); 



            switch (choice) {

                case 1:

                    addSmartphone(scanner);

                    break;

                case 2:

                    applyDiscount(scanner);

                    break;

                case 3:

                    viewDeviceDetails();

                    break;

                case 4:

                    System.out.println("Exiting Smart Device Store. Goodbye!");

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 4);



        scanner.close();

    }



    private static void addSmartphone(Scanner scanner) {

        System.out.print("Enter Device ID: ");

        String deviceId = scanner.nextLine();

        System.out.print("Enter Brand: ");

        String brand = scanner.nextLine();

        System.out.print("Enter Price: ");

        double price = scanner.nextDouble();

        scanner.nextLine(); // Consume newline



        currentSmartphone = new Smartphone(deviceId, brand, price);

        System.out.println("Smartphone added successfully!");

    }



    private static void applyDiscount(Scanner scanner) {

        if (currentSmartphone == null) {

            System.out.println("No smartphone added yet. Please add a smartphone first.");

            return;

        }

        System.out.print("Enter discount percentage (e.g., 10 for 10%): ");

        double percentage = scanner.nextDouble();

        scanner.nextLine(); // Consume newline

        currentSmartphone.applyDiscount(percentage);

    }



    private static void viewDeviceDetails() {

        if (currentSmartphone == null) {

            System.out.println("No smartphone added yet. Please add a smartphone first.");

            return;

        }

        currentSmartphone.displayDetails();

    }

}