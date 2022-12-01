import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws MyException {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("Adil", "Aitbaev", Country.KYRGYZSTAN, LocalDate.of(2012,12,12), "adil@gmail.com");
        Customer customer1 = new Customer("Beknazar", "Aitbaev", Country.USA, LocalDate.of(2004,12,12), "adil@gmail.com");
        Customer customer2 = new Customer("Bektur", "Aitbaev", Country.KYRGYZSTAN, LocalDate.of(2020,12,12), "adil@gmail.com");
        Customer customer3 = new Customer("Nuriza", "Muratova", Country.USA, LocalDate.of(2011,12,12), "adil@gmail.com");
        Customer customer4 = new Customer("kanykei", "Muratova", Country.TAIWAN, LocalDate.of(1996,12,12), "adil@gmail.com");
        Customer customer5 = new Customer("Nazar", "Bekov", Country.KAZAKHSTAN, LocalDate.of(1954,12,12), "adil@gmail.com");
        Customer customer6 = new Customer("Balancha", "Tukunchoev", Country.KAZAKHSTAN, LocalDate.of(1950,12,12), "adil@gmail.com");
        Customer customer7 = new Customer("Tukuncho", "Balancha uulu", Country.TAIWAN, LocalDate.of(2010,12,12), "adil@gmail.com");

        try {
            Customer customer10 = new Customer();
            Customer[] customers = {customer, customer1, customer2, customer3, customer4, customer5, customer6, customer7};
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> System.out.println(Arrays.toString(customer3.sameCountry(customers, scanner.next())));
                    case 2 -> System.out.println(Arrays.toString(customer10.sortCountry(customers)));
                    case 3 -> System.out.println(Arrays.toString(customer10.customers(customers)));
                    case 4 -> System.out.println((Arrays.toString(customer10.getAge(customers))));
                    case 5 -> System.out.println(Arrays.toString(customer10.fullName(customers)));
                    default -> throw new MyException("404 error not found");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("tuura jaz ");
        }
    }

    public static void Text(){
        try (FileWriter fileWriter = new FileWriter("text.txt")){
            fileWriter.write("""
                    Customer деген класс тузунуз.
                    Полерерин толтурунуз аты, фамилиясы,
                    туулган олкосу,туулган жылы,почтасы
                    болсун.Дагы бир service деген интерфейс
                    ачып аны анын ичине 4 метод жазыныз." +
                    "1-кардардын жашын кайтаруучу метод жазыныз,
                    2-мамлекети окшош кардарларды кайтарыныз,
                    3-кардарлардын мамлекетин сорттоп чыгарыныз,
                    4-баардык кардарларды кайтаруучу метод жазыныз." +
                    "Ал интерфейсти Customer клласына impliments кылып
                    методдорго логикасын жазыныз.Mainдан жазган логиканызды иштетиниз");
                    """);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }public static void Read() throws FileNotFoundException {
        FileReader fileReader = new FileReader("text.txt");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
    static {
        System.out.println("""
                1 -> find country
                2 -> sort country
                3 -> all customers
                4 -> get ages
                5 -> full name
                """);
    }

}