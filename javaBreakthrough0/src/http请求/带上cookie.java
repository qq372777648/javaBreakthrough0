package http请求;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.client.CookieStore;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.impl.conn.PoolingClientConnectionManager;  
import org.apache.http.util.EntityUtils;  
/** 
* @author lzw 
* @version 创建时间：2016年6月8日 下午2:16:44 
* @Description:  
*/

  
/** 
 * TODO(用一句话描述该文件的作用) 
 *  
 * @title: HttpClientDemo.java 
 * @author zhangjinshan-ghq 
 * @date 2014-6-11 14:59:04 
 */  
  
public class 带上cookie  
{  
  
    /** 
     * The main method. 
     *  
     * @param args the arguments 
     * @throws Exception the exception 
     */  
    public static void main(String[] args) throws Exception  
    {  
        getResoucesByLoginCookies();  
    }  
  
    /** 
     * 根据登录Cookie获取资源 
     * 一切异常均未处理，需要酌情检查异常 
     *  
     * @throws Exception 
     */  
    private static void getResoucesByLoginCookies() throws Exception  
    {  
    	带上cookie demo = new 带上cookie();  
        String username = "XXXXXXXXX";// 登录用户  
        String password = "XXXXXXXX";// 登录密码  
  
        // 需要提交登录的信息  
        String urlLogin = "http://115.28.154.197:8080/tangrenPMS/user/login?employeePassword=2&employeeWorkNum=10001";  
        urlLogin="http://www.baidu.com";
        // 登录成功后想要访问的页面 可以是下载资源 需要替换成自己的iteye Blog地址  
        String urlAfter = "http://115.28.154.197:8080/tangrenPMS/position/positionList";
        urlAfter="http://115.28.154.197:8080/tangrenPMS/user/logOut";
  
        DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());  
  
        /** 
         * 第一次请求登录页面 获得cookie 
         * 相当于在登录页面点击登录，此处在URL中 构造参数， 
         * 如果参数列表相当多的话可以使用HttpClient的方式构造参数 
         * 此处不赘述 
         */  
        HttpPost post = new HttpPost(urlLogin);  
        HttpResponse response = client.execute(post);  
        HttpEntity entity = response.getEntity();  
        CookieStore cookieStore = client.getCookieStore();  
        //System.out.println(cookieStore);

        //Cookie c=cookieStore.getCookies().get(0);
        
        //亏待自定义cookie
        Cookie c=new Cookie() {
			
			@Override
			public boolean isSecure() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isPersistent() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isExpired(Date arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int getVersion() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return "94F0901E3FF78817E89620F5E12BC211";
			}
			
			@Override
			public int[] getPorts() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getPath() {
				// TODO Auto-generated method stub
				return "/tangrenPMS/";
			}
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "JSESSIONID";
			}
			
			@Override
			public Date getExpiryDate() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getDomain() {
				// TODO Auto-generated method stub
				return "115.28.154.197";
			}
			
			@Override
			public String getCommentURL() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getComment() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		cookieStore.addCookie (c);
		//System.out.println(cookieStore.getCookies() .get(1));
		client.setCookieStore(cookieStore); 
  
        /** 
         * 带着登录过的cookie请求下一个页面，可以是需要登录才能下载的url 
         * 此处使用的是iteye的博客首页，如果登录成功，那么首页会显示【欢迎XXXX】 
         *  
         */  
        HttpGet get = new HttpGet(urlAfter);  
        response = client.execute(get);  
        entity = response.getEntity();  
        //System.out.println(entity.getContentLength());
  
        /** 
         * 将请求结果放到文件系统中保存为 myindex.html,便于使用浏览器在本地打开 查看结果 
         */  
  
        String pathName = "d:\\myindex.html";  
        writeHTMLtoFile(entity, pathName);  
    }  
  
    /** 
     * Write htmL to file. 
     * 将请求结果以二进制形式放到文件系统中保存为.html文件,便于使用浏览器在本地打开 查看结果 
     *  
     * @param entity the entity 
     * @param pathName the path name 
     * @throws Exception the exception 
     */  
    public static void writeHTMLtoFile(HttpEntity entity, String pathName) throws Exception  
    {  
  
    	
        byte[] bytes = new byte[(int) entity.getContentLength()];  
  
        FileOutputStream fos = new FileOutputStream(pathName);  
  
        bytes = EntityUtils.toByteArray(entity);  
  
        fos.write(bytes);  
  
        fos.flush();  
  
        fos.close();  
    }  
  
}  

