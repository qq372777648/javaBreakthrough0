package ö��;

public enum ö��1 {
	����һ("����һ�Ĺ������"),
	���ܶ�("���ܶ��Ĺ������","���ݲ�����������ѡ����Ӧ���췽��");
	
	private String des1;
	public  String des2;

	private ö��1(String des) {
		this.des1 = des;
	}

	@Override
	public String toString() {
		return this.des1+"---"+(this.des2!=null?this.des2:"�ն�")+"--��дtostring";
	}
	
	private ö��1(String des1, String des2) {
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
