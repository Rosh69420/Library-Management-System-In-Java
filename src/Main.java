import java.util.Scanner;

class Book{
    Scanner sc = new Scanner(System.in);
    String title;
    String author;
    int id;
    boolean isIssued;



}

class User {
    String userName;
    int userID;

    }
public class Main {

    public static void addBook(Scanner sc){
        Book b = new Book();
        System.out.print("Enter the title: ");
        b.title = sc.nextLine();
        System.out.print("Enter the author name: ");
        b.author = sc.nextLine();
        b.id = bookCount + 1;
        b.isIssued = false;
        books[bookCount] = b;
        bookCount++;
        System.out.println("Book added successfully.");

    }

    static Book[] books = new Book[100];
    static int bookCount = 0;

    static User[] users = new User[50];
    static int userCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------");
        System.out.println("           Library Management System        ");
        System.out.println("--------------------------------------------");

        while (true){

            System.out.println("1. Add Books.");
            System.out.println("2. View Books.");
            System.out.println("3. Add User.");
            System.out.println("4. View Users.");
            System.out.println("5. Issue Book.");
            System.out.println("6. Return Book.");
            System.out.println("7. Exit.");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    addBook(sc);  // call your method
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }


    }
}
