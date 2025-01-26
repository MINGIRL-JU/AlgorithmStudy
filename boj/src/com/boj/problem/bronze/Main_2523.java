package com.boj.problem.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2523 {
	static int N;

	public static void main(String[] args) throws Exception{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//로직
		for (int i = 0; i < 2*N-1; i++) {
			//별
			for (int j = 0; j < -Math.abs(i-(N-1))+N; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
