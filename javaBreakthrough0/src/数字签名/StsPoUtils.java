package 数字签名;


import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.aliyun.oss.common.auth.HmacSHA1Signature;
import com.aliyun.oss.common.utils.DateUtil;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.GetFederationTokenRequest;
import com.aliyuncs.sts.model.v20150401.GetFederationTokenResponse;
import com.aliyuncs.sts.model.v20150401.GetFederationTokenResponse.Credentials;

//alioss
public class StsPoUtils {
	private static GetFederationTokenResponse dtsResponse = null;
	private static GetFederationTokenResponse flacResponse = null;
	private static long dtsLastTime = 0;
	private static long flacLastTime = 0;
	private static void dtsRefresh(){
	    dtsLastTime = new Date().getTime();
    	try {
    	    dtsResponse = getFederationToken(accessKeyId, accessKeySecret,
			        name, dts_policy, durationSenconds, protocolType);
		} catch (ClientException e) {
			e.printStackTrace();
		}
    }
	
    private static void flacRefresh(){
        flacLastTime = new Date().getTime();
        try {
            flacResponse = getFederationToken(accessKeyId, accessKeySecret,
                    name, flac_policy, durationSenconds, protocolType);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }	
    
    public static GetFederationTokenResponse getDtsToken(){
    	long now = new Date().getTime();
    	if(now-dtsLastTime>durationSenconds*1000){
    	    dtsRefresh();
    	}
    	return dtsResponse;
    }
    
    public static GetFederationTokenResponse getFlacToken(){
        long now = new Date().getTime();
        if(now-flacLastTime>durationSenconds*1000){
            flacRefresh();
        }
        return flacResponse;
    }
    
	public static JSONObject sign(String fqdn,String suffix , String args) throws JSONException {
		JSONObject res = new JSONObject();
		Credentials token;
		res.put("url", fqdn+args);
		String date = DateUtil.formatRfc822Date(new Date());
		String canonicalizedResource = "/"+suffix+args;
		if (suffix != null && suffix.indexOf("dfim-dts")!=-1){
		    token = getDtsToken().getCredentials();
		} else {
		    token = getFlacToken().getCredentials();
		}
		String data =
				"GET"+"\n" 
		        + "\n" 
		       /*+"audio/x-aiff" */+ "\n" 
				+ date + "\n" 
				+"x-oss-security-token:"+ token.getSecurityToken() + "\n" 
		        + canonicalizedResource ;
		String signature = HmacSHA1Signature.create().computeSignature(token.getAccessKeySecret(), data );
		res.put("date",date);
		res.put("x-oss-security-token",token.getSecurityToken());
		res.put("Authorization","OSS " + token.getAccessKeyId() + ":" + signature);

        return res;
	}
    
    public static void main(String[] args) {
		try {
			JSONObject res = sign("sfdfd","dfim-dts","/19/19/dE01D0Ea28a61eaE3DABC25571A5DF3.ts");
			System.out.println(res.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    private static GetFederationTokenResponse getFederationToken(String accessKeyId, String accessKeySecret,
    		  String name, String policy, long expireSeconds, ProtocolType protocolType) throws ClientException {
    		    try {
    		      IClientProfile profile = DefaultProfile.getProfile(REGION_CN_SZ, accessKeyId, accessKeySecret);
    		      DefaultAcsClient client = new DefaultAcsClient(profile);

    		      final GetFederationTokenRequest request = new GetFederationTokenRequest();
    		      request.setVersion(STS_API_VERSION);
    		      request.setMethod(MethodType.POST);
    		      request.setProtocol(protocolType);

    		      request.setStsVersion(STS_VERSION);
    		      request.setName(name);
    		      request.setPolicy(policy);
    		      request.setDurationSeconds(expireSeconds);

    		      final GetFederationTokenResponse response = client.getAcsResponse(request);

    		      return response;
    		    } catch (ClientException e) {
    		      throw e;
    		    }
    		  }
	
    public static final String REGION_CN_SZ = "cn-hangzhou";
    public static final String STS_API_VERSION = "2015-04-01";
    public static final String STS_VERSION = "1";
    private static String accessKeyId = "agbONloi8i3RNRYU";
    private static String  accessKeySecret = "SvlRqy9ot34ofRawdVR8g8IRfCv47V";
    private static String name = "tt";
    //生成针对“MyAppStorage/user/baymax/”路径下的写权限的policy
    private static String flac_policy = "{\n" +
    "    \"Version\": \"1\", \n" +
    "    \"Statement\": [\n" +
    "        {\n" +
    "            \"Action\": [\n" +
    "                \"oss:GetObject\"\n" +
    "            ], \n" +
    "            \"Resource\": [\n" +
    "                \"acs:oss:*:*:dfim-flac/*\" \n" +
    "            ], \n" +
    "            \"Effect\": \"Allow\"\n" +
    "        }\n" +
    "    ]\n" +
    "}";
    
    private static String dts_policy = "{\n" +
            "    \"Version\": \"1\", \n" +
            "    \"Statement\": [\n" +
            "        {\n" +
            "            \"Action\": [\n" +
            "                \"oss:GetObject\"\n" +
            "            ], \n" +
            "            \"Resource\": [\n" +
            "                \"acs:oss:*:*:dfim-dts/*\" \n" +
            "            ], \n" +
            "            \"Effect\": \"Allow\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    //有效期限�?小时
    private static long durationSenconds = 3600;
    //该数据为敏感数据，使用HTTPS协议发�?接收请求
    private static ProtocolType protocolType = ProtocolType.HTTPS;
}
