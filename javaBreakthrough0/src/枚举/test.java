
package ö��;

import ö��.Constant.Animal;
import ö��.Constant.CardOpTpye;
import ö��.Constant.ImageType;

public class test {
	public static void main(String[] args) {
		CardOpTpye cop=CardOpTpye.CREATE;//create����ʵ��
		System.out.println(cop);
		System.out.println(cop.getContext());
		
		
		
		Animal am=Animal.Cow;
		System.out.println(am+"--"+am.code+"--"+am.getDes());
		switch (am) {
			case Cow:System.out.println("�����ţ��");
						System.out.println(am.equals(Animal.Cow));
						System.out.println(am==Animal.Cow);
						System.out.println(am.toString());
						System.out.println(am.hashCode()+"---"+Animal.Cow.hashCode());
				break;
			default:
				System.out.println("������ϻ�");
				break;
		}
		
		
		
		
		ImageType imgtype=ImageType.TV_ALBUM_MIDDLE;
		System.out.println(imgtype.getClass());
		
		ö��1 e=ö��1.����һ;
		System.out.println(e);
		e=ö��1.���ܶ�;
		System.out.println(e);
		System.out.println(e.getClass());
	}

}
