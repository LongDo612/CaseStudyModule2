import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogDAO {
    private static Map<Integer, Blog> blogs = new HashMap<>();

    static {
        blogs.put(1,new Blog(1,"Du lich Da Lat 3 ngay 2 dem", "Di Da Lat rat la vui","https://static.asiawebdirect.com/m/bangkok/portals/vietnam/homepage/dalat/pagePropertiesImage/dalat.jpg.jpg"));
        blogs.put(2,new Blog(2,"Du lich Chau Au", "Em yeu Chau Au","https://vietnamfreedomtour.com/wp-content/uploads/2016/01/du-lich-chau-au.jpg"));
    }

    public List<String> getBlogFromFIle() {
        List<String> result = new ArrayList<>();
        String regex = "-----";
        File file = new File("/Users/longdo/CaseStudyModule2/src/adminBlog.txt");
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine())!=null){
                for (String i:line.split(regex)) {
                    result.add(i);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<Blog> getBlog() {
        return new ArrayList<>(blogs.values());
    }
}
