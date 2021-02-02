package collection;

public class TestCustomerDao {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.add(new Customer("123",123));
        System.out.println(customerDao.get(0));
    }
}
