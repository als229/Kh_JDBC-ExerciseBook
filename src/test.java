import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class test {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		HashSet sh = new HashSet();
		String rNum = "";
		list.add(1+"");
		list.add(2+"");
		list.add(3+"");
		list.add(4+"");
		list.add(5+"");
		list.add(6+"");
//		list.add(7+"");
		list.add(8+"");
		list.add(9+"");

		while(true) {
			rNum = (int)(Math.random()*10+1)+"";
			if(!list.contains(rNum)) {
				list.add(rNum);
				break;
			}
			
		}
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			
		}
		
	}
}