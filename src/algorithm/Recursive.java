package algorithm;

public class Recursive {

	public int jiecheng(int n){
		
		if(n<=0) return  1;
		int result=n*jiecheng(n-1);
		return result;
	}
 public static void main(String[] args) {
	 Recursive dg=new Recursive();
     System.out.println(dg.jiecheng(5));
}
}
