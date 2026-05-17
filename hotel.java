import java.util.ArrayList;
import java.util.Scanner;

// Room class
class Room {
    int roomNumber;
    String type;
    boolean isBooked;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }

    void display() {
        System.out.println("Room No: " + roomNumber +
                ", Type: " + type +
                ", Booked: " + (isBooked ? "Yes" : "No"));
    }
}

// Main class
public class HotelManagementSystem {

    public static void main(String[] args) {

        ArrayList<Room> rooms = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. Checkout Room");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Room Number: ");
                    int number = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Room Type (Single/Double): ");
                    String type = sc.nextLine();

                    rooms.add(new Room(number, type));
                    System.out.println("Room added successfully!");
                    break;

                case 2:
                    if (rooms.isEmpty()) {
                        System.out.println("No rooms available.");
                    } else {
                        for (Room r : rooms) {
                            r.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number to Book: ");
                    int bookNum = sc.nextInt();
                    boolean booked = false;

                    for (Room r : rooms) {
                        if (r.roomNumber == bookNum && !r.isBooked) {
                            r.isBooked = true;
                            System.out.println("Room booked successfully!");
                            booked = true;
                            break;
                        }
                    }

                    if (!booked) {
                        System.out.println("Room not available or already booked.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Room Number to Checkout: ");
                    int checkoutNum = sc.nextInt();
                    boolean checkedOut = false;

                    for (Room r : rooms) {
                        if (r.roomNumber == checkoutNum && r.isBooked) {
                            r.isBooked = false;
                            System.out.println("Checkout successful!");
                            checkedOut = true;
                            break;
                        }
                    }

                    if (!checkedOut) {
                        System.out.println("Room not found or already free.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
