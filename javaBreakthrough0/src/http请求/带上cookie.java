package http����;

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
* @version ����ʱ�䣺2016��6��8�� ����2:16:44 
* @Description:  
*/

  
/** 
 * TODO(��һ�仰�������ļ�������) 
 *  
 * @title: HttpClientDemo.java 
 * @author zhangjinshan-ghq 
 * @date 2014-6-11 14:59:04 
 */  
  
public class ����cookie  
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
     * ���ݵ�¼Cookie��ȡ��Դ 
     * һ���쳣��δ������Ҫ�������쳣 
     *  
     * @throws Exception 
     */  
    private static void getResoucesByLoginCookies() throws Exception  
    {  
    	����cookie demo = new ����cookie();  
        String username = "XXXXXXXXX";// ��¼�û�  
        String password = "XXXXXXXX";// ��¼����  
  
        // ��Ҫ�ύ��¼����Ϣ  
        String urlLogin = "http://115.28.154.197:8080/tangrenPMS/user/login?employeePassword=2&employeeWorkNum=10001";  
        urlLogin="http://www.baidu.com";
        // ��¼�ɹ�����Ҫ���ʵ�ҳ�� ������������Դ ��Ҫ�滻���Լ���iteye Blog��ַ  
        String urlAfter = "http://115.28.154.197:8080/tangrenPMS/position/positionList";
        urlAfter="http://115.28.154.197:8080/tangrenPMS/user/logOut";
  
        DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());  
  
        /** 
         * ��һ�������¼ҳ�� ���cookie 
         * �൱���ڵ�¼ҳ������¼���˴���URL�� ��������� 
         * ��������б��൱��Ļ�����ʹ��HttpClient�ķ�ʽ������� 
         * �˴���׸�� 
         */  
        HttpPost post = new HttpPost(urlLogin);  
        HttpResponse response = client.execute(post);  
        HttpEntity entity = response.getEntity();  
        CookieStore cookieStore = client.getCookieStore();  
        //System.out.println(cookieStore);

        //Cookie c=cookieStore.getCookies().get(0);
        
        //�����Զ���cookie
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
         * ���ŵ�¼����cookie������һ��ҳ�棬��������Ҫ��¼�������ص�url 
         * �˴�ʹ�õ���iteye�Ĳ�����ҳ�������¼�ɹ�����ô��ҳ����ʾ����ӭXXXX�� 
         *  
         */  
        HttpGet get = new HttpGet(urlAfter);  
        response = client.execute(get);  
        entity = response.getEntity();  
        //System.out.println(entity.getContentLength());
  
        /** 
         * ���������ŵ��ļ�ϵͳ�б���Ϊ myindex.html,����ʹ��������ڱ��ش� �鿴��� 
         */  
  
        String pathName = "d:\\myindex.html";  
        writeHTMLtoFile(entity, pathName);  
    }  
  
    /** 
     * Write htmL to file. 
     * ���������Զ�������ʽ�ŵ��ļ�ϵͳ�б���Ϊ.html�ļ�,����ʹ��������ڱ��ش� �鿴��� 
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

