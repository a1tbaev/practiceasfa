public interface Service {
    long[] getAge(Customer[] customers);
    Customer[] sameCountry(Customer[] customers, String country) throws MyException;
    Country[] sortCountry(Customer[] customers);
    Customer[] customers(Customer[] customers);
    String[] fullName(Customer[] customers);
}
