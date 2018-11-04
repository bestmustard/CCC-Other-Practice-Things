import java.io.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");

		int rows = Integer.parseInt(tokens[0]);
		int colms = Integer.parseInt(tokens[1]);

		int[][] dist = new int[rows][colms];
		char[][] grid = new char[rows][colms];
		int startx = 0, starty = 0;
		for (int i = 0; i < rows; i++) {
			String line = br.readLine();
			for (int j = 0; j < colms; j++) {
				grid[i][j] = line.charAt(j);
				dist[i][j] = Integer.MAX_VALUE;
				if (grid[i][j] == 'S') { // find starting point
					startx = j;
					starty = i; 
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colms; j++) {
				if (grid[i][j] == 'W') {
					dist[i][j] = -1;
				} else if (grid[i][j] == 'C') {
					for (int m = i; m < rows; m++) {
						if (grid[m][j] == 'W')
							break;
						if (grid[m][j] != 'U' && grid[m][j] != 'D'
								&& grid[m][j] != 'L' && grid[m][j] != 'R') {
							dist[m][j] = -1;
						}
					}
					for (int m = i; m >= 0; m--) {
						if (grid[m][j] == 'W')
							break;
						if (grid[m][j] != 'U' && grid[m][j] != 'D'
								&& grid[m][j] != 'L' && grid[m][j] != 'R') {
							dist[m][j] = -1;
						}
					}
					for (int m = j; m < colms; m++) {
						if (grid[i][m] == 'W')
							break;
						if (grid[i][m] != 'U' && grid[i][m] != 'D'
								&& grid[i][m] != 'L' && grid[i][m] != 'R') {
							dist[i][m] = -1;
						}
					}
					for (int m = j; m >= 0; m--) {
						if (grid[i][m] == 'W')
							break;
						if (grid[i][m] != 'U' && grid[i][m] != 'D'
								&& grid[i][m] != 'L' && grid[i][m] != 'R') {
							dist[i][m] = -1;
						}
					}
				}
			}
		}
		ArrayList<Integer> X = new ArrayList<Integer>(); // make queue for x values
		ArrayList<Integer> Y = new ArrayList<Integer>();
		X.add(startx); // add starting point
		Y.add(starty);
		if (dist[starty][startx] != -1) { // if not in camera
			dist[starty][startx] = 0; // steps from start point is 0
		}
		while (!X.isEmpty()) { // has steps to take
			int x = X.get(0);
			X.remove(0); // clear queue
			int y = Y.get(0);
			Y.remove(0);
			if(dist[y][x] == -1){
				continue;
			}
			if (grid[y][x] == '.' || grid[y][x] == 'S') { 
				if (x + 1 < colms && dist[y][x + 1] != -1) { // check if space is invalid
					if (dist[y][x + 1] > dist[y][x] + 1) { // check if default value or existing larger path
						dist[y][x + 1] = dist[y][x] + 1;
						X.add(x + 1);
						Y.add(y);
					}
				}
				if (x - 1 >= 0 && dist[y][x - 1] != -1) {
					if (dist[y][x - 1] > dist[y][x] + 1) {
						dist[y][x - 1] = dist[y][x] + 1;
						X.add(x - 1);
						Y.add(y);
					}
				}
				if (y + 1 < rows && dist[y + 1][x] != -1) {
					if (dist[y + 1][x] > dist[y][x] + 1) {
						dist[y + 1][x] = dist[y][x] + 1;
						X.add(x);
						Y.add(y + 1);
					}
				}
				if (y - 1 >= 0 && dist[y - 1][x] != -1) {
					if (dist[y - 1][x] > dist[y][x] + 1) {
						dist[y - 1][x] = dist[y][x] + 1;
						X.add(x);
						Y.add(y - 1);
					}
				}
			} else if (grid[y][x] == 'U') {
				if (y - 1 >= 0 && dist[y - 1][x] != -1) {
					if (dist[y - 1][x] > dist[y][x]) {
						dist[y - 1][x] = dist[y][x];
						X.add(x);
						Y.add(y - 1);
					}
				}
			} else if (grid[y][x] == 'D') {
				if (y + 1 < rows && dist[y + 1][x] != -1) {
					if (dist[y + 1][x] > dist[y][x]) {
						dist[y + 1][x] = dist[y][x];
						X.add(x);
						Y.add(y + 1);
					}
				}
			} else if (grid[y][x] == 'R') {
				if (x + 1 < colms && dist[y][x + 1] != -1) {
					if (dist[y][x + 1] > dist[y][x]) {
						dist[y][x + 1] = dist[y][x];
						X.add(x + 1);
						Y.add(y);
					}
				}
			} else if (grid[y][x] == 'L') {
				if (x - 1 >= 0 && dist[y][x - 1] != -1) {
					if (dist[y][x - 1] > dist[y][x]) {
						dist[y][x - 1] = dist[y][x];
						X.add(x - 1);
						Y.add(y);
					}
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colms; j++) {
				if (grid[i][j] == '.') {
					if (dist[i][j] == Integer.MAX_VALUE) { // if empty space is still = default value
						System.out.println(-1); 
					} else {
						System.out.println(dist[i][j]); // print distance val
					}
				}
			}
		}
	}
}
