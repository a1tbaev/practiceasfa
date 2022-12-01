import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Customer implements Service{
    private String name;
    private String surname;
    private Country country;
    private LocalDate yearOfBirth;
    private String address;

public Customer(){}
    public Customer(String name, String surname, Country country, LocalDate yearOfBirth, String address) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = Country.valueOf(country);
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = LocalDate.ofEpochDay(yearOfBirth);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public long[] getAge(Customer[] customers) throws InputMismatchException {
    long[] localDates = new long[customers.length];
    int index = 0;
    LocalDate l = LocalDate.now();
        for (Customer customer:customers) {
            localDates[index] = ChronoUnit.YEARS.between(customer.yearOfBirth, l);
            index++;
        }
        return localDates;
    }

    @Override
    public Customer[] sameCountry(Customer[] customers, String country) throws MyException{
    int counter = 0;

    if (!country.matches("[a-zA-Zа-яА-Я]*")){
        throw new MyException("you cant to write number");
    }
        for (Customer customer : customers) {
            if (customer.country.name().equals(country.toUpperCase())){
                counter++;
            }
        }

    int index = 0;
    Customer[] customers1 = new Customer[counter];

        for (Customer customer : customers) {
            if (customer.country.name().equals(country.toUpperCase())){
                customers1[index] = customer;
                index++;
            }
        }
        return customers1;
    }

    @Override
    public Country[] sortCountry(Customer[] customers) {
    Country[] countries = new Country[customers.length];
    int index = 0;
        for (Customer customer : customers) {
            countries[index] = customer.country;
            index++;
        }
        Arrays.sort(countries);
        return countries;
    }
    @Override
    public Customer[] customers(Customer[] customers) {
        return customers;
    }

    @Override
    public String[] fullName(Customer[] customers) {
    String[] strings = new String[customers.length];
    int index = 0;
        for (Customer customer: customers) {
            strings[index] = customer.name + " " + customer.surname;
            index++;
        }
        return strings;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country=" + country +
                ", yearOfBirth=" + yearOfBirth +
                ", address='" + address + '\'' +
                '}';
    }
}
