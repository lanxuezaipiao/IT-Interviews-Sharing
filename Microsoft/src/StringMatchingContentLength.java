import java.io.IOException;
import java.util.Scanner;

public class StringMatchingContentLength {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String strA = in.nextLine();
        	String strB = in.nextLine();
//		    String strA = "abcdefghijklmn";
//		    String strB = "ababceghjklmn";
		    int[] index1 = new int[strA.length() / 3];
		    int[] index2 = new int[strB.length() / 3];
		    int[] length = new int[strB.length()];
		    int kth = 0;
        	kth = getStringMatchLenth(strA.toCharArray(), strB.toCharArray(), index1, index2, length, kth);
//        	System.out.println("kth: " + kth);
//        	for(int i = 0; i < kth; i++)
//        		System.out.print(index1[i] + " ");
//        	System.out.println();
//        	for(int i = 0; i < kth; i++)
//        		System.out.print(index2[i] + " ");
//        	System.out.println();
//        	for(int i = 0; i < kth; i++)
//        		System.out.print(length[i] + " ");
//        	System.out.println();
        	int tmp;
        	for(int i = 0; i < kth - 1; i++) {
        		for(int j = 0; j < kth - i - 1; j++) {
        			if(index1[j] > index1[j + 1]) {
        				tmp = index1[j];
        				index1[j] = index1[j + 1];
        				index1[j + 1] = tmp;
        				tmp = index2[j];
        				index2[j] = index2[j + 1];
        				index2[j + 1] = tmp;
        				tmp = length[j];
        				length[j] = length[j + 1];
        				length[j + 1] = tmp;
        			}
        		}
        	}
        	int maxLen = length[0];
        	int i = 1, last = 0;
        	while(i < kth) {
        		if(index2[i] > index2[last]) {
        			maxLen += length[i];
        			last = i;
        		}
        		i++;
        	}
        	System.out.println(maxLen);
        }

	}

	static int getStringMatchLenth(char[] str1, char[] str2, int[] index1, int[] index2, int[] length, int kth) {
		int len1, len2;
		len1 = str1.length;
		len2 = str2.length;
		int maxLen = len1 > len2 ? len1 : len2;

		int[] max = new int[maxLen];// 保存最长子串长度的数组
		int[] maxIndex1 = new int[maxLen];// 保存最长子串长度最大索引的数组
		int[] maxIndex2 = new int[maxLen];
		int[] c = new int[maxLen];

		int i, j;
		for (i = 0; i < len2; i++) {
			for (j = len1 - 1; j >= 0; j--) {
				if (str2[i] == str1[j]) {
					if ((i == 0) || (j == 0))
						c[j] = 1;
					else
						c[j] = c[j - 1] + 1;// 此时C[j-1]还是上次循环中的值，因为还没被重新赋值
				} else {
					c[j] = 0;
				}

				// 如果是大于那暂时只有一个是最长的,而且要把后面的清0;
				if (c[j] > max[0]) {
					max[0] = c[j];
					maxIndex1[0] = j;
					maxIndex2[0] = i;

					for (int k = 1; k < maxLen; k++) {
						max[k] = 0;
						maxIndex1[k] = 0;
						maxIndex2[k] = 0;
					}
				}
				// 有多个是相同长度的子串
				else if (c[j] == max[0]) {
					for (int k = 1; k < maxLen; k++) {
						if (max[k] == 0) {
							max[k] = c[j];
							maxIndex1[k] = j;
							maxIndex2[k] = i;
							break; // 在后面加一个就要退出循环了
						}
					}
				}
			}
		}
		// 打印最长子字符串
		for (j = 0; j < 1; j++) {
			if (max[j] > 0) {
				if(max[j] < 3) return kth;
	//			System.out.println("第" + (j + 1) + "个公共子串:" + max[j]);
				length[kth] = max[j];
				i = maxIndex1[j] - max[j] + 1;
				index1[kth] = i;
				for (; i <= maxIndex1[j]; i++) 
					str1[i] = '0';
				i = maxIndex2[j] - max[j] + 1;
				index2[kth] = i;
				for (; i <= maxIndex2[j]; i++) 
					str2[i] = '1';
	//			System.out.println(new String(str1));
	//			System.out.println(new String(str2));

				kth = getStringMatchLenth(str1, str2, index1, index2, length, kth + 1);
			}
		}
		return kth;
	}
	
}