import java.util.Scanner;
public class practice0901 {

	public static void main(String[] args) {
		
		String name;
		String hak;
		int kor, eng, math;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("---���� ���� ���α׷�---");
		System.out.println("�̸� �Է� : ");
		name = scan.next();
		System.out.println("�й� �Է� : ");
		hak = scan.next();
		System.out.println("���� ���� ���� ������ �ӷ��ϼ���: ");
		kor = scan.nextInt();
		eng = scan.nextInt();
		math = scan.nextInt();
		
		System.out.println("---�ḻ---");
		System.out.println("�̸�: " + name);
		System.out.println("�й�: " + hak);
		System.out.println("���� ����: " + math);
		System.out.println("���� ����: " + kor);
		System.out.println("���� ����: " + eng);
		
		System.out.println("���� ����: " + (math + kor + eng));
		System.out.println("��� ����: " + ( (float)(math + kor + eng) / 3.0));
		
		if((math + kor + eng / 3.0) >=90) {			
			System.out.println("���� : A");
		}
		else if ((math + kor + eng / 3.0) >=80) {
			System.out.println("���� : B");
		}
		else if ((math + kor + eng / 3.0) >=70) {
			System.out.println("���� : C");
		}
		else if ((math + kor + eng / 3.0) >=60) {
			System.out.println("���� : B");
		}else {
			System.out.println("���� : F");
		}
	}

}
