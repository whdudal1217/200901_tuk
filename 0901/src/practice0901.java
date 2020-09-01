import java.util.Scanner;
public class practice0901 {

	public static void main(String[] args) {
		
		String name;
		String hak;
		int kor, eng, math;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("---성적 산출 프로그램---");
		System.out.println("이름 입력 : ");
		name = scan.next();
		System.out.println("학번 입력 : ");
		hak = scan.next();
		System.out.println("국어 영어 수학 점수를 임력하세요: ");
		kor = scan.nextInt();
		eng = scan.nextInt();
		math = scan.nextInt();
		
		System.out.println("---결말---");
		System.out.println("이름: " + name);
		System.out.println("학번: " + hak);
		System.out.println("수학 점수: " + math);
		System.out.println("국어 점수: " + kor);
		System.out.println("영어 점수: " + eng);
		
		System.out.println("총점 점수: " + (math + kor + eng));
		System.out.println("평균 점수: " + ( (float)(math + kor + eng) / 3.0));
		
		if((math + kor + eng / 3.0) >=90) {			
			System.out.println("학점 : A");
		}
		else if ((math + kor + eng / 3.0) >=80) {
			System.out.println("학점 : B");
		}
		else if ((math + kor + eng / 3.0) >=70) {
			System.out.println("학점 : C");
		}
		else if ((math + kor + eng / 3.0) >=60) {
			System.out.println("학점 : B");
		}else {
			System.out.println("학점 : F");
		}
	}

}
