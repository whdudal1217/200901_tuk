import java.util.Scanner;
public class Credit {
	
	public static int calc(int kor, int eng, int math) {
		return kor + eng + math;
	}
	
	public static char hakjum(double d) {
		if((d / 3.0) >=90) {			
			return 'A';
		}
		else if ((d / 3.0) >=80) {
			return 'B';
		}
		else if ((d / 3.0) >=70) {
			return 'C';
		}
		else if ((d / 3.0) >=60) {
			return 'D';
		}else {
			return 'F';
		}
	}
	
	public static class student{
		
		String name;
		String hak;
		int kor, eng, math;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getHak() {
			return hak;
		}
		public void setHak(String hak) {
			this.hak = hak;
		}
		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMath() {
			return math;
		}
		public void setMath(int math) {
			this.math = math;
		}
		
	}
	
	public static void main(String[] args) {
	
		student st1 = new student();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("---���� ���� ���α׷�---");
		System.out.println("�̸� �Է� : ");
		st1.setName(scan.next());
		System.out.println("�й� �Է� : ");
		st1.setHak(scan.next());
		System.out.println("���� ���� ���� ������ �Է��ϼ���: ");
		st1.setKor(scan.nextInt());
		st1.setEng(scan.nextInt());
		st1.setMath(scan.nextInt());
		System.out.println("���� ���� ���� ������ �Է��ϼ���2 (for�� test��): ");
		
		/*
		 * int[] sub = new int[3]; for(int i=0; i<sub.length; i++) { sub[i] =
		 * scan.nextInt(); } calc2(sub);
		 */
		
		
		prn(st1);
		/*
		 * System.out.println("---�ḻ---"); System.out.println("�̸�: " + name);
		 * System.out.println("�й�: " + hak); System.out.println("���� ����: " + math);
		 * System.out.println("���� ����: " + kor); System.out.println("���� ����: " + eng);
		 * 
		 * System.out.println("���� ���� : " + calc(kor, eng, math));
		 * System.out.println("��� ����: " + ( (float)(calc(kor, eng, math)) / 3.0));
		 * System.out.println("���� : " + hakjum( calc(kor, eng, math)) / 3.0);
		 */
		
		/*int a = math+kor+eng / 3;
		System.out.println("���� : " + hakjum(a));*/
		//System.out.println("���� ����: " + (math + kor + eng));
		//System.out.println("��� ����: " + ( (float)(math + kor + eng) / 3.0));
		
		/*
		 * if((math + kor + eng / 3.0) >=90) { System.out.println("���� : A"); } else if
		 * ((math + kor + eng / 3.0) >=80) { System.out.println("���� : B"); } else if
		 * ((math + kor + eng / 3.0) >=70) { System.out.println("���� : C"); } else if
		 * ((math + kor + eng / 3.0) >=60) { System.out.println("���� : B"); }else {
		 * System.out.println("���� : F"); }
		 */
	}
	
	private static void calc2(int[] sub) {
		int res = 0;
		for (int i : sub) {
			res =+ sub[i];
		}
		return;
	}

	public static void prn(student st1){
		System.out.println("---�ḻ---");
		System.out.println("�̸�: " + st1.getName());
		System.out.println("�й�: " + st1.getHak());
		System.out.println("���� ����: " + st1.getMath());
		System.out.println("���� ����: " + st1.getKor());
		System.out.println("���� ����: " + st1.getEng());
		System.out.println("���� ���� : " + calc(st1.getKor(), st1.getKor(), st1.getKor()));
		System.out.println("��� ����: " + ( (float)(calc(st1.getKor(), st1.getEng(), st1.getMath())) / 3.0));
		System.out.println("���� : " + hakjum( calc(st1.getKor(), st1.getEng(), st1.getMath())) / 3.0);
	}
}