
public class numberingDri {
	public static  int numbering(int limit, double d){
		int i = 0;
		while(i < limit){
			i++;
		}
		return i;
	}
	
	public static void main(String[] args) {
		System.out.println(numbering(5, 1.2));
	}
}
