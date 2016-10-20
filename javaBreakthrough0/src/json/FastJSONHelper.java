package json;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * @author lzw
 * @version ����ʱ�䣺2016��6��21�� ����10:22:17
 * @Description:
 */
public class FastJSONHelper {

	/**
	 * ��java���͵Ķ���ת��ΪJSON��ʽ���ַ���
	 * 
	 * @param object
	 *            java���͵Ķ���
	 * @return JSON��ʽ���ַ���
	 */
	public static <T> String serialize(T object) {
		return JSON.toJSONString(object);
	}

	/**
	 * ��JSON��ʽ���ַ���ת��Ϊjava���͵Ķ������java�������͵Ķ��󣬲�����java�������� 
	 * @param json JSON��ʽ���ַ���
	 * @param clz java���ͻ���java�������ͣ�������java��������
	 * @return
	 * java���͵Ķ������java�������͵Ķ��󣬲�����java�������͵Ķ���
	 */
	public static <T> T deserialize(String json, Class<T> clz) {
		return JSON.parseObject(json, clz);
	}

	/**
	 * ��JSON��ʽ���ַ���ת��ΪList<T>���͵Ķ���
	 * @param json JSON��ʽ���ַ��� 30 
	 * @param clz
	 * ָ�����ͼ��������T���� 31
	 * @return List<T>���͵Ķ��� 32
	 */
	public static <T> List<T> deserializeList(String json, Class<T> clz) {
		return JSON.parseArray(json, clz);
	}

	/**
	 * ��JSON��ʽ���ַ���ת��������Java���͵Ķ���
	 * 
	 * @param json
	 *            JSON��ʽ���ַ���
	 * @param type
	 *            ����Java����
	 * @return ����Java���͵Ķ���
	 */
	public static <T> T deserializeAny(String json, TypeReference<T> type) {
		return JSON.parseObject(json, type);
	}

}
