package test;

import java.util.Arrays;

public class String≈≈–Ú {
	public static void main(String[] args) {
		String []strs={"sdf","ssf2","sadfa","ffasdsdfsdfs","zzdsdf"};
		Arrays.sort(strs, String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}

}
