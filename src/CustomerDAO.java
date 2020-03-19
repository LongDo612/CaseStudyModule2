import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO implements CustomerService{
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
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }

    public Map getCustomer() {
        Map customerData = new HashMap<>();
        File customer = new File("/Users/longdo/CaseStudyModule2/src/Customer");
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(customer));
            while ((line=br.readLine())!=null){
                customerData.put(line.split("-")[0],line.split("-")[1]);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                br.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return customerData;
    }
}
