//�л��̸��� ��ȣ�� �Է��ϰ� ���
import java.util.ArrayList;
import java.util.Scanner;


public class no_01 {
	public static void main(String[] args) {

		String name;
		String no;
		
		Student st1 = new Student("����â","01");
		Student st2 = new Student("�迵��","02");
		Student st3 = new Student("�����","03");
		
		ArrayList<Student> stList = new ArrayList<Student>();


		Scanner sc = new Scanner(System.in);

		stList.add(st1);
		stList.add(st2);
		stList.add(st3);

		while(true)
		{
			System.out.println("1.�Է� 2.��� 3.����");
			int num = sc.nextInt();
			switch(num) {
			case 1: 
				System.out.println("�̸��Է�:");
				name = sc.next();
				System.out.println("�й��Է�:");
				no = sc.next();
				
				stList.add(new Student(name,no));
				continue;
			case 2:
				for(Student st : stList) {
					System.out.print(st.getName() + " ");
					System.out.println(st.getNo());
				}
				continue;
			case 3:
				break;
			}
			
			
			System.out.println("���� �Ǿ����ϴ�");
			break;
		}
		

		
		
	}
}

class Student {

	private String name;
	private String no;
	private String test;


	Student(String name, String no) {
		super();
		this.name = name;
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}


}


