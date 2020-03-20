import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class MemberServlet extends HttpServlet {
    private static String legalUserName = "admin";
    private static String legalPassword = "123123";
    private BlogDAO blogDAO = new BlogDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "add":
                addBlog(request,response);
                break;
            case "edit":
                editBlog(request,response);
                break;
            case "delete":
                deleteBlog(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "blog":
                showBlogPage(request, response);
                break;
            case "add":
                showAddForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            default:
                getLogin(request, response);
                break;
        }
    }

    private void showBlogPage(HttpServletRequest request, HttpServletResponse response) {
        List<Blog> blogs = this.blogDAO.getBlog();
        request.setAttribute("blogs",blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog.jsp");
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher requestDispatcher;
        request.setAttribute("loginTime", new Date());

        if (username.equals(legalUserName) && password.equals(legalPassword)) {
            try {
                requestDispatcher = request.getRequestDispatcher("user.jsp");
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.sendRedirect("login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void getLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBlog(HttpServletRequest request, HttpServletResponse response) {
        String header = request.getParameter("NewHeader");
        String content = request.getParameter("NewContent");
        String image = request.getParameter("NewImage");
        int id = blogDAO.randomID();
        Blog newBlog = new Blog(id,header,content,image);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add.jsp");
        try{
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher;
        int id = Integer.parseInt(request.getParameter("id"));
        Blog blog = this.blogDAO.findByID(id);
        if (blog==null){
            dispatcher = request.getRequestDispatcher("404notFound.jsp");
        }
        else {
            dispatcher = request.getRequestDispatcher("edit.jsp");
            request.setAttribute("blog",blog);
        }
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void editBlog(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String header = request.getParameter("newTitle");
        String content = request.getParameter("newContent1");
        Blog blog = blogDAO.findByID(id);
        RequestDispatcher dispatcher;
        if (blog==null){
            dispatcher = request.getRequestDispatcher("404notFound.jsp");
        }
        else {
            blog.setHeader(header);
            blog.setContent(content);
            blogDAO.update(id,blog);
            request.setAttribute("blog",blog);
            dispatcher = request.getRequestDispatcher("edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDeleteForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Blog blog = blogDAO.findByID(id);
        RequestDispatcher dispatcher;
        if (blog==null){
            dispatcher = request.getRequestDispatcher("404notFound.jsp");
        }
        else {
            request.setAttribute("blog",blog);
            dispatcher = request.getRequestDispatcher("delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteBlog(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Blog blog = blogDAO.findByID(id);
        RequestDispatcher dispatcher;
        if (blog==null) {
            dispatcher = request.getRequestDispatcher("404notFound.jsp");
        }
        else {
            blogDAO.removeByID(id);
            try {
                response.sendRedirect("blog.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
