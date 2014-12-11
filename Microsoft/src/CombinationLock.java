import java.util.Scanner;
import java.util.StringTokenizer;

public class CombinationLock {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int n, m;
//        	int n = 7;
//        	int m = 4;
//        	String lock = "ABCDEFG";
//        	steps[0] = "CMD 1 2 5 C";
//        	steps[1] = "CMD 2 3 7 4";
//        	steps[2] = "CMD 3 3";
//        	steps[3] = "CMD 4 1 7";
        	
        	String nm = in.nextLine();
        	StringTokenizer st = new StringTokenizer(nm, " ");
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
 //       	System.out.println(n + " " + m);
        	String lock = in.nextLine();
//         	System.out.println("lock: " + lock);
        	
        	String[] steps = new String[m];
        	for(int i = 0; i < m; i++) {
        		steps[i] = in.nextLine();
//        		System.out.println("steps[" + i + "]: " + steps[i]);
        	}

        	openCombinationLock(lock.toCharArray(), n, steps, m);
        }

	}

	static void openCombinationLock(char[] lock, int n, String[] steps, int m) {
		int cmd;
		String args;
		for(int i = 0; i < m; i++) {
			cmd = steps[i].charAt(4) - '0';
			args = steps[i].substring(6);
//			System.out.println(cmd + ": " + args);
			handleCMD(lock, n, cmd, args);
//			System.out.println(new String(lock));
		}
		System.out.println(new String(lock));
	}
	
	static void handleCMD(char[] lock, int n, int cmd, String args) {
		StringTokenizer st = new StringTokenizer(args, " ");
		int i, j, k, index;
		char x;
		switch(cmd) {
		case 1:
			i = Integer.valueOf(st.nextToken());
			j = Integer.valueOf(st.nextToken());
			x = st.nextToken().charAt(0);
			for(index = i - 1; index < j; index++) {
				lock[index] = x;
			}
			break;
		case 2:
			i = Integer.valueOf(st.nextToken());
			j = Integer.valueOf(st.nextToken());
			k = Integer.valueOf(st.nextToken());
			for(index = i - 1; index < j; index++) {
				lock[index] = (char) (lock[index] + k);
				if(lock[index] > 90) 
					lock[index] = (char) (lock[index] - 91 + 65);
			}
			break;
		case 3:
			k = Integer.valueOf(st.nextToken());
			reverse(lock, 0, k - 1);
			reverse(lock, k, n - 1);
			reverse(lock, 0, n - 1);
			break;
		case 4:
			i = Integer.valueOf(st.nextToken());
			j = Integer.valueOf(st.nextToken());
			if(i <= j) {
				handleCMD(lock, n, 4, i + 1 + " " + j);
				handleCMD(lock, n, 2, i + " " + j + " " + 1);
			}
			break;
		}
		
	}
	
	static void reverse(char[] str, int left, int right) {
		for(int i = left, j = right; i < j; i++, j--) {
			char tmp = str[i];
			str[i] = str[j];
			str[j] = tmp;
		}
	}
}