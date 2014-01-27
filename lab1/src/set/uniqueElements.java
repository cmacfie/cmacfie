package set;

public class uniqueElements{
	private int[] ints;

	public static int[] uniqueElements(int[] ints){
		MaxSet m = new MaxSet();
//		int[] n = new int[ints.length];
//		int index = 0;
//		for(int i = 0; i < ints.length; i++){
//			if(m.add(ints[i])){
//				n[index] = ints[i];
//				index++;
//			}
//		}
		
		
		int[] temp = new int[ints.length];
		int size = 0;
		for(int i = 0; i < ints.length; i++){
			if(m.add(ints[i])){
				temp[size] = ints[i];
				size++;
			}
		}
		int[] n = new int[size];
		for(int i = 0; i < size; i++){
			n[i] = temp[i];
		}
		return n;
	}
	
	public static void main(String[] args) {
		int[] p = {3,6,0,-1,3,3,3,3,7,8,7,2,3,2,3};
		p = uniqueElements(p);
		for(int i = 0; i < p.length-1; i++){
			System.out.print(p[i] + ", ");
		}
		System.out.print(p[p.length-1]);
	}
}
