package eg.chapter1;

import java.util.Scanner;

public class Chapter1 {

	static class Max3 {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("세 정수의 최댓값을 구합니다.");
			System.out.print("a 의 값: ");
			int a = scanner.nextInt();
			System.out.print("b 의 값: ");
			int b = scanner.nextInt();
			System.out.print("c 의 값: ");
			int c = scanner.nextInt();

			int max = a;
			if(max < b) max = b;
			if(max < c) max = c;
			System.out.println("최댓값은 " + max + "입니다.");
		}
	}

}
