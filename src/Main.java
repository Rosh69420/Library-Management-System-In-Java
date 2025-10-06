import java.util.Scanner;

class Book{

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

    public static void viewBooks(){

        if(bookCount == 0){
            System.out.println("No Books Added Yet.");
        }
        else {
            for (int i = 0; i < bookCount; i++) {
                System.out.println("ID: " + books[i].id);
                System.out.println("Title: " + books[i].title);
                System.out.println("Author: " + books[i].author);
                System.out.println("Is Issued: " + (books[i].isIssued ? "yes":"No"));
                System.out.println("----------------------------------------------------");
            }
        }
    }

    public static void addUser(Scanner sc){
        User u = new User();
        System.out.print("Enter your full name: ");
        u.userName = sc.nextLine();
        u.userID = userCount + 1;
        users[userCount] = u;
        userCount++;
        System.out.println("User added successfully");
    }
    public static void viewUser(){
        if(userCount == 0){
            System.out.println("No users added yet.");
        }
        else{
            for (int i = 0; i < userCount; i++){
                System.out.println("User Name: " + users[i].userName);
                System.out.println("User ID: " + users[i].userID);
                System.out.println("-------------------------------------");
            }
        }
    }

    public static void issueBook(Scanner sc){
        boolean uidFound = false;
        boolean bidFound = false;
        System.out.print("Enter the user ID: ");
        int uid = sc.nextInt();
        for(int i = 0; i < userCount; i++){

            if(uid == users[i].userID) {
                uidFound = true;
                break;
            }
        }

        if(!uidFound){
            System.out.println("User ID not found try again!!");
            System.out.println("---------------------------------");
        }

        else {
            System.out.print("Enter the book ID: ");
            int bid = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < bookCount; i++){
                if(bid == books[i].id){
                    bidFound = true;
                    break;
                }
            }
            if(!bidFound){
                System.out.println("Book ID not found try again!!");
                System.out.println("-------------------------------");
            }
            else {
                if(!books[bid-1].isIssued){
                    System.out.println("The book was successfully issued.");
                    System.out.println("---------------------------------");
                    books[bid-1].isIssued = true;
                }
                else{
                    System.out.println("Book Already Issued!!");
                    System.out.println("------------------------");
                }
            }
        }


        }
    public static void returnBook(Scanner sc){
        System.out.print("Enter the book ID: ");
        int bid = sc.nextInt();
        boolean idCheck = false;
        for (int i =0; i<bookCount; i++) {
            if (bid ==  books[i].id){
                idCheck = true;
                books[i].isIssued = false;
                System.out.println("Book returned ID No." + bid);
                break;
            }
        }
        if(!idCheck){
            System.out.println("No book ID found, Try again!!");
        }
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
                case 2:
                    viewBooks();
                    break;
                case 3:
                    addUser(sc);
                    break;
                case 4:
                    viewUser();
                    break;
                case 5:
                    issueBook(sc);
                    break;
                case 6:
                    returnBook(sc);
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
