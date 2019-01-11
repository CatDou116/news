package cn.yunhe.page;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empty.Page;
import empty.Student;
import uitl.FengZhuang;

/**
 * Servlet implementation class Pageservlet
 */
@WebServlet("/Pageservlet")
public class Pageservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pageservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int CurPage;//设置当前页,当页面传递过来的值为空时默认让当前页为1否则就等于传递过来的值
	String cp = request.getParameter("CurPage");
		    if(cp==null) {
			
	        	  CurPage=1;
		          }else {
		        	  
		        	  CurPage= Integer.parseInt(cp) ;
		          }
		
	      int Maxnum=10;
	      //执行分页的sql语句
	      String stc="select*from student LIMIT ?,?";	
			//调用封装好的工具类执行数据库操作
	      List a=new ArrayList();
	      a.add((CurPage-1)*Maxnum);//计算出当前页并添加的集合供查询数据库使用
	      a.add(Maxnum);
	      //封装好的数据库查询工具
	      FengZhuang fc	=new FengZhuang();	
			ResultSet	rsc	=fc.getjie(stc, a);		
			List<Student> student = new ArrayList();//建一个<Student>属性的集合为了下面遍历的数据库对象可以装里面,这里实际上就是装的页面上现实的的内容
			try {
				//遍历得到查询的页面显示数据
				while(rsc.next()) {
					//将通过student类的有参构造方法给其赋值并将这些属性值封装入student集合
					student.add(new Student(rsc.getInt("id"),rsc.getString("name"),
						rsc.getInt("age"),rsc.getString("sex"),rsc.getDate("birth")));
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				request.setAttribute("student", student);//当前页展示的页面信息已经获取到就是student这个集合
			//还需要 1页面展示内容数据2总记录数,数据库数据总3当前页是第几页4每一页显示几条数据5总页数
			
				
					String stc2="select COUNT(*) from student";	
					 ResultSet	rsc2=fc.getjie(stc2, null);	
					 int coun = 0;
					 try {
							while(rsc2.next()) {
						 coun =Integer.parseInt(rsc2.getString(1)) ;//总记录数
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 //这里通过Page类的有参数构造给它里面的属性赋值,并接到返回值
					Page paglist = new Page(student,coun,CurPage,Maxnum);
					//此处就已经把所有查询的数据放入域中传递到jsp页面
					request.setAttribute("pagelist", paglist);
		
				request.getRequestDispatcher("SudentPages.jsp").forward(request, response);
	
	}

}
