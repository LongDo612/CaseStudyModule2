import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO implements CustomerService{
    private static Map<Integer, Customer> customers;

    static {
        customers.put(1, new Customer(1,"Long Do", "admin1", "123123"));
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void save(Customer customer) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("/Users/longdo/CaseStudyModule2/src/Customer"));
            bw.newLine();
            bw.write(customer.getEmail()+"-"+customer.getPassword());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                bw.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Customer findByID(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }

}
