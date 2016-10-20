
package 枚举;

import 枚举.Constant.Animal;
import 枚举.Constant.CardOpTpye;
import 枚举.Constant.ImageType;

public class test {
	public static void main(String[] args) {
		CardOpTpye cop=CardOpTpye.CREATE;//create具体实例
		System.out.println(cop);
		System.out.println(cop.getContext());
		
		
		
		Animal am=Animal.Cow;
		System.out.println(am+"--"+am.code+"--"+am.getDes());
		switch (am) {
			case Cow:System.out.println("今晚吃牛排");
						System.out.println(am.equals(Animal.Cow));
						System.out.println(am==Animal.Cow);
						System.out.println(am.toString());
						System.out.println(am.hashCode()+"---"+Animal.Cow.hashCode());
				break;
			default:
				System.out.println("今晚打老虎");
				break;
		}
		
		
		
		
		ImageType imgtype=ImageType.TV_ALBUM_MIDDLE;
		System.out.println(imgtype.getClass());
		
		枚举1 e=枚举1.可能一;
		System.out.println(e);
		e=枚举1.可能二;
		System.out.println(e);
		System.out.println(e.getClass());
	}

}
