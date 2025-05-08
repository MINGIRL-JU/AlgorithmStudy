package com.boj.problem.bronze;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main_1271 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		StringBuilder sb = new StringBuilder();
		sb.append(A.divide(B)).append("\n").append(A.remainder(B));
		System.out.print(sb);
	}

}
