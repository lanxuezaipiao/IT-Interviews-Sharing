import java.io.IOException;
import java.io.StreamTokenizer;

public class BeautifulString {
	public static void main(String[] args) throws IOException {

		StreamTokenizer st = new StreamTokenizer(System.in);
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			for (int i = 0; i < n; i++) {
				st.nextToken();
				int m = (int) st.nval;
				st.nextToken();
				String str = st.sval;
				isBeautifulString(str.toCharArray(), m);
			}
		}

	}

	static void isBeautifulString(char str[], int len) {
		int i = 0, j;
		int count = 1, totalCount = 1, lastCount = 0;
		while (i < len - 1) {
			if (str[i + 1] == str[i] + 1) {
				if (lastCount != 0 && lastCount != count) {
					i++;
					count = 1;
					totalCount = 1;
					lastCount = 0;
					continue;
				}
				lastCount = count;
				count = 1;
				totalCount++;
			} else if (str[i + 1] == str[i]) {
				count++;
			} else {
				count = 1;
				totalCount = 1;
				lastCount = 0;
			}
			if (totalCount > 2) {
				System.out.println("YES");
				return;
			}
			i++;
		}

		System.out.println("NO");
	}
}