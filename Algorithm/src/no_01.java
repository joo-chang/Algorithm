//학생이름및 번호를 입력하고 출력
import java.util.ArrayList;
import java.util.Scanner;


public class no_01 {
	public static void main(String[] args) {

		String name;
		String no;
		
		Student st1 = new Student("박주창","01");
		Student st2 = new Student("김영빈","02");
		Student st3 = new Student("김승태","03");
		
		ArrayList<Student> stList = new ArrayList<Student>();


		Scanner sc = new Scanner(System.in);

		stList.add(st1);
		stList.add(st2);
		stList.add(st3);

		while(true)
		{
			System.out.println("1.입력 2.출력 3.종료");
			int num = sc.nextInt();
			switch(num) {
			case 1: 
				System.out.println("이름입력:");
				name = sc.next();
				System.out.println("학번입력:");
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
			
			
			System.out.println("종료 되었습니다");
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


