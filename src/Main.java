

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


class book{
    private String name;
    book(){}
    book(String name){this.name=name;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
class Library{
    Scanner sc= new Scanner(System.in);
    ArrayList<book> books = new ArrayList<>();


    //use switch case to ask options menu
    void menu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome !");
        System.out.println("a. Add Book");
        System.out.println("b. Display Books ");
        System.out.println("c. Borrow Book");
        System.out.println("d. Return book");
        System.out.println("e. Exit");
        do {
            System.out.println("Please choose an option:");
            option = sc.next().charAt(0);
            switch (option) {
                case 'a': addBook();
                    break;
                case 'b':
                    toString();
                    break;
                case 'c':
                    borrowBook();
                    break;
                case 'd':
                    returnBook();
                    break;
                case 'e':
                    System.out.println("Exit successful");
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    // add book in the library
    public void addBook() {

        // already stored books
        books.add(new book("To Kill a Mockingbird"));
        books.add(new book("1984"));
        books.add(new book("Harry Potter and the Philosopher's Stone"));
        books.add(new book("The Lord of the Rings"));
        books.add(new book("The Great Gatsby"));
        books.add(new book("Pride and Prejudice"));
        books.add(new book("The Diary Of A Young Girl"));
        books.add(new book("The Book Thief"));
        try {

            int n;
            System.out.print("How many books you want to add?  ");
            n = Integer.parseInt(sc.nextLine());
            System.out.println("Enter books name:");
            for (int i = 0; i <+ n; i++) {
                String userInput= (sc.nextLine()).trim();
                books.add(new book(userInput));
            }System.out.println("Book added successfully!  \n");
        }catch(Exception e) {
            System.out.println("something went wrong \n please try again!");
        }


    }

    //Display all books present in library
    @Override
    public String toString(){
        int a = 1;
        System.out.println("Books present in the library are ");
        for (book i : books) {
            System.out.println(a + "." + i);
            a++;
        }
        System.out.println("\n");
        return null;
    }



    // To borrow the book
    public void borrowBook() {

        System.out.print("Please enter book name you want to borrow: ");
        String subst = sc.nextLine();
        boolean flag  = false;
        int rem = 0;
        for (book string : books) {
            if((string.getName()).equalsIgnoreCase(subst.trim())) {
                flag = true;
                break;}
            rem+=1;
        }

        if(flag==true){
            System.out.println("*** Book available ****");
            books.remove(rem);

            //issued date and time
            System.out.println("Book issued on:");
            System.out.println("Date\t\tTime");
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy\tHH:mm:ss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp);

            // due date (15 days from the bill issued date)
            Calendar now = Calendar.getInstance();
            now.add(Calendar.DATE, 15); // add 15 days to current date using Calendar.add method
            System.out.println("Due Date : "  + now.get(Calendar.DATE) + "-"+ (now.get(Calendar.MONTH) + 1) + "-"+ now.get(Calendar.YEAR));
            System.out.println("Enjoy reading!! \n");
        }
        else {
            String f = String.format("%s",subst);
            System.out.println("sorry we don't have book - "+ f);
            System.out.println("\n");
        }
    }

    public void returnBook(){
        System.out.print("Enter book name you want to return: ");
        books.add(new book(sc.nextLine()));
        System.out.println("Book returned successfully !! \n");
    }
}



public class Main {
    public static void main(String[] args) {
        Library l1= new Library();

        l1.menu();

    }
}
