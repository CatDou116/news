package empty;
//创建页面的实体类,页面需要显示的数据为:页面展示内容数据();总记录数,数据库数据总;当前页是第几页;每一页显示几条数据;总页数
import java.util.List;

public class Page {


private List<Student> lis;//页面展示内容数据,此处创建一个聚合用来装数据库中的所有字段的内容

private int totalNum;//总记录数,数据库数据总

private int dangqianPage;//当前页是第几页

private  int  maxnum;//每一页显示几条数据

 private int totalPages;//总页数


public List<Student> getLis() {
	return lis;
}

public int getTotalNum() {
	return totalNum;
}

public int getDangqianPage() {
	return dangqianPage;
}

public int getMaxnum() {
	return maxnum;
}

public int getTotalPages() {
	return totalPages;
}

public void setLis(List<Student> lis) {
	this.lis = lis;
}

public void setTotalNum(int totalNum) {
	this.totalNum = totalNum;
}

public void setDangqianPage(int dangqianPage) {
	this.dangqianPage = dangqianPage;
}

public void setMaxnum(int maxnum) {
	this.maxnum = maxnum;
}

public void setTotalPages(int totalPages) {
	this.totalPages = totalPages;
}

//设置有参数的构造方法通过selvet层给其赋值后传入jsp页面使用
public Page(List<Student> lis, int totalNum, int dangqianPage, int maxnum) {
	super();
	this.lis = lis;
	this.totalNum = totalNum;
	this.dangqianPage = dangqianPage;
	this.maxnum = maxnum;
	//这里通过计算获取到总页数
		if(totalNum%maxnum==0) {
		this.totalPages=totalNum/maxnum;	
		}else { 
			this.totalPages=totalNum/maxnum+1;        
		}
	
}

public Page() {
	super();
}


 
 
 
 
 

}
