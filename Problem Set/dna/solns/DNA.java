import java.util.*;
//joshua kirstein, soln to dna sequencing
public class DNA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		sc.nextLine();
		while (cases-->0) {
			String str = sc.nextLine();
			HashMap<Integer, HashSet<String>> map = new HashMap<Integer, HashSet<String>>();
			for (int i = 0; i < str.length(); i++) {
				for (int j = i; j < str.length(); j++) {
					String sub = str.substring(i, j+1);
					int len = sub.length();
					int idx1 = str.indexOf(sub);
					int idx2 = str.lastIndexOf(sub);
					if (idx1 != i || idx2 != i) {
						if (!map.containsKey(len)) map.put(len, new LinkedHashSet<String>());
						map.get(len).add(sub);
					}
				}
			}
			int len = 0;
			int size = 0;
			for (Map.Entry<Integer, HashSet<String>> entry : map.entrySet()) {
				if (entry.getKey() > len) {
					size = entry.getValue().size();
					len = entry.getKey();
				}
			}
			System.out.println(len + " " + size);
		}
	}
}