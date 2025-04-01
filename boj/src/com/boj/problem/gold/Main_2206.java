package com.boj.problem.gold;
import java.io.*;
import java.util.*;

public class Main_2206 {
	static int N, M, result=Integer.MAX_VALUE;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] start;
	static int[][] board;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] cl = br.readLine().toCharArray();
			for (int j = 0; j < cl.length; j++) {
				board[i][j] = cl[j]-'0';
			}
		}
		start = new int[] {1, 0, 0, 1}; //세계선, r, c, depth
		visited = new boolean[2][N][M];
		
		/* 로직 */
		//3차원 배열을 활용해 세계선 관리
		//벽을 부순 세계선, 안 부순 세계선
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(start);
		visited[1][start[1]][start[2]] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int z = cur[0];
			int depth = cur[3];
			if(depth >= result) continue;
			if(cur[1] == N-1 && cur[2] == M-1) {
				result = Math.min(result, depth);
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur[1]+dr[i];
				int nc = cur[2]+dc[i];
				if(check(nr, nc) && !visited[z][nr][nc]) {
					if(board[nr][nc] == 1) {
						if(z > 0) {
							//파괴권이 없는 세계선으로 이동
							visited[z-1][nr][nc] = true;
							q.offer(new int[] {z-1, nr, nc, depth+1});
						}
					}else {
						visited[z][nr][nc] = true;
						q.offer(new int[] {z, nr, nc, depth+1});
					}
				}
			}
		}

		
		/* 출력 */
		System.out.print(result == Integer.MAX_VALUE ? -1 : result);
		
	}

	static boolean check(int nr, int nc) {
		return (0 <= nr && nr < N) && (0 <= nc && nc < M);
	}

}
