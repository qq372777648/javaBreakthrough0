package �칤��.���߳��������;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Test_btevent_thread extends JFrame {

	private JPanel contentPane;
	static boolean have_start=false;
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
					Test_btevent_thread frame = new Test_btevent_thread();
					frame.setVisible(true);
					String str="aaa";
					Btevent t1=new Btevent();
					t1.start();

					new Myaddthread(9).start();
					//new Myaddthread(2).start();
					//new Myaddthread(3).start();
					
					Thread.sleep(2000);
					System.out.println("���߳�");
//					Thread.sleep(5000);
//					System.out.println("���̻߳��������߳�");
//					synchronized ("aaa"){
//						"aaa".notifyAll();
//					}
					
	}

	/**
	 * Create the frame.
	 */
	public Test_btevent_thread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u7ADE\u4E89\u95014");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Btevent.add_event_flag(4);
				
			}
		});
		btnNewButton.setBounds(42, 95, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u7ADE\u4E89\u95015");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Btevent.add_event_flag(5);
			}
		});
		btnNewButton_1.setBounds(171, 95, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7ADE\u4E89\u95016");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Btevent.add_event_flag(6);
			}
		});
		btnNewButton_2.setBounds(299, 95, 93, 23);
		contentPane.add(btnNewButton_2);
		
		
		final Myaddthread waigua=new Myaddthread(7);
		
		waigua.setPause(true);
		waigua.start();
		
		final JButton btnNewButton_3 = new JButton("\u5F00\u6302\u7ADE\u4E89");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(have_start==false){
					//�������
							waigua.setPause(false);
							have_start=true;
							btnNewButton_3.setText("ֹͣ���");					
						
				}
				else{
							waigua.setPause(true);
							have_start=false;
							btnNewButton_3.setText("���Ҿ���");	
						
				}
				
				
			}
		});
		btnNewButton_3.setBounds(171, 184, 93, 55);
		contentPane.add(btnNewButton_3);
	}
}


class Btevent extends Thread{
	private int event_flag;
	//private static Stack<Integer> events=new Stack<Integer>();
	private static Queue<Integer> events=new LinkedList<>();
	
	

	static void add_event_flag(int flag){
		synchronized ("aaa"){
			
			try {
				sleep(500);//
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			events.offer(flag);
//			try {
//				"aaa".wait();
//			} catch (InterruptedException e) {
//			}
		}
//		synchronized ("aaa"){
//			"aaa".notifyAll();
//		}
		
	}
	
	public  int  bt1event(){
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 1;
	}
	public  int  bt2event(){
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 2;
	}
	public  int  bt3event(){
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 3;
	}
	
	@Override
	public void run() {
		while(true){
			if(events.peek()!=null)
				event_flag=events.poll();
			else 
				event_flag=0;
			
			if(event_flag==1){
				System.out.println(bt1event());
			}
			else if(event_flag==2){
				System.out.println(bt2event());
			}
			else if(event_flag==3){
				System.out.println(bt3event());
			}
			else if(event_flag==4){
				System.out.println(bt3event()+"------"+4);
			}
			else if(event_flag==5){
				System.out.println(bt3event()+"---------"+5);
			}
			else if(event_flag==6){
				System.out.println(bt3event()+"---------"+6);
			}
			else if(event_flag==7){
				System.out.println("��������---------"+7);
			}
			
			try {
				sleep(10);
			} catch (InterruptedException e) {
			}
		}
		
	}
}

//�Զ������� ���߳�
class Myaddthread extends Thread{
	int i=1;
	boolean pause=false;
	public Myaddthread(int i) {
		super();
		this.i = i;
	}
	
	
	public void setPause(boolean pause) {//���˻���(�����̵߳���)
		this.pause = pause;
		synchronized ("aaa") {
			"aaa".notifyAll();
		}
	}


	@Override
	public void run() {
		while(true){
			if(pause==true)
				synchronized ("aaa") {
					try {
						"aaa".wait();//�Լ�˯ �����˻���
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			Btevent.add_event_flag(i);
			System.out.println(i+"join");
		}
	}
}