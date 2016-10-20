package 枚举;

public enum 枚举1 {
	可能一("可能一的构造参数"),
	可能二("可能二的构造参数","根据参数个数类型选择相应构造方法");
	
	private String des1;
	public  String des2;

	private 枚举1(String des) {
		this.des1 = des;
	}

	@Override
	public String toString() {
		return this.des1+"---"+(this.des2!=null?this.des2:"空洞")+"--重写tostring";
	}
	
	private 枚举1(String des1, String des2) {
		this.des1 = des1;
		this.des2 = des2;
	}

	public String getDes1() {
		return des1;
	}

	public void setDes1(String des1) {
		this.des1 = des1;
	}
	
	
}
