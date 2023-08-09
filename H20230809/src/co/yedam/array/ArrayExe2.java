package co.yedam.array;

import java.util.Arrays;

public class ArrayExe2 {

	public static void main(String[] args) {
		
		System.out.println("============ 실습 ① ============");
		// 정수형 변수 3개 : 임의의값
		int num1, num2, num3;
		num1 = (int) (Math.random()*100) + 1;
		num2 = (int) (Math.random()*100) + 1;
		num3 = (int) (Math.random()*100) + 1;
		
		// 변수 3개중 가장 큰값.
		int max = 0;
		
		int[] nums = {num1, num2, num3};
		
		for(int i=0; i<nums.length; i++) {
			if(max < nums[i]) {
				max = nums[i];
			}
		}
		System.out.println("★nums[] : " + Arrays.toString(nums));
		System.out.println(" 최대값 = " + max);
		
		
		System.out.println("\n============ 실습 ② ============");
		int[] ary = new int[5];
		
		// 1~100 임의값
		for(int i=0; i<ary.length; i++) {
			ary[i] = (int) (Math.random()*100) + 1;
		}
		
		// 5개의 합, 평균
		int sum = 0;
		
		for(int i=0; i<ary.length; i++) {
			sum += ary[i];
		}
		double avg = sum / 5.0;
		System.out.println("★ary[] : " + Arrays.toString(ary));
		System.out.println(" 평균 = " + avg);
		
	}

}
