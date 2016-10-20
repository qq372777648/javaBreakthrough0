package 枚举;

public class Constant {
	public static final String PURCHASEWAY = "purchaseWay"; // 购买方式（独立购买，打包购买）
	
		public enum Animal{
			Pig(1,"这是一头猪"),Dog(2,"这是一条狗"),Cow(2,"this is a cow");
			public Integer code;
			private String des;
			private Animal(Integer code, String des) {
				this.code = code;
				this.des = des;
			}
			public String getDes() {
				return des;
			}
			public void setDes(String des) {
				this.des = des;
			}
			
			
			
		}
	
		public static enum CardOpTpye {
			// 生成，激活，使用, 停用, 过期
			CREATE(1,"生成"), ACTIVATE(5,"激活"), DESTROY(15,"过期");
			
			private int code;
			private String context;

			
			private CardOpTpye(int code, String context) {
				this.code = code;
				this.context = context;
			}
			
			@Override
			public String toString() {
				return this.code+"";
			}
			
			public String getContext() {
				return context;
			}
			public void setContext(String context) {
				this.context = context;
			}
			public void setCode(int code) {
				this.code = code;
			}
			public int getCode() {
				return code;
			}
			
		}
		
		
		public static enum ImageType {
			TV_ALBUM_BIG,
			TV_ALBUM_MIDDLE,
			TV_ALBUM_SMALL;
			@Override
			public String toString() {
				return "dnb";
			}
		}

}
