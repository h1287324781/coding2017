import java.util.*;
/*�������ƣ�
 * ԭ�ļ����ƣ�
 * Ҫ�㣺
 * 1. ʵ�ֻ��������ݽṹArrayList Stack LinkedList Queue Tree Iterator

 */
public class Class1_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList
		System.out.println("*******���ԣ�ArrayList*******");
		List<Name> c1=new ArrayList<Name>();
		c1.add(new Name("Fulan", "Xue"));
		c1.add(new Name("Tian", "Feng"));
		c1.add(new Name("Zida", "Ma"));
		c1.add(new Name("Te", "Fu"));
		System.out.println(c1);
		
		//Iterator
		System.out.println("*******���ԣ�Iterator*******");
		Iterator<Name> iterator=c1.iterator();
		while(iterator.hasNext()){
			Name nameTemp=iterator.next();
			System.out.print(nameTemp.getFirstName()+" ");
		}
		System.out.println("");
		
		//LinkedList
		System.out.println("*******���ԣ�LinkedList*******");
		List<Name> list1=new LinkedList<Name>();
		for(int j=0;j<5;j++){
			list1.add(new Name("Shijie"+j,"Bao"));
		}
		Collections.reverse(list1);
		System.out.println(list1);
		
		//Stack
		System.out.println("*******���ԣ�Stack*******");
		Stack<Name> stack1=new Stack<Name>();
		for(int j=0;j<c1.size();j++){
			stack1.push(c1.get(j));
		}
		System.out.println(stack1.peek());//��ӡջ��Ԫ��
		
		//Queue
		System.out.println("*******���ԣ�Queue*******");
		Queue<Name> queue1=new LinkedList<Name>();
		queue1.offer(new Name("Zhong", "Da"));
		queue1.offer(new Name("Ling", "Wu"));
		queue1.offer(new Name("Bahe", "Mai"));
		for(Name nameTemp:queue1){
			System.out.println(nameTemp);
		}
		
		//Tree
		System.out.println("*******���ԣ�Tree*******");
		int val=0;
		String key=null;
		Integer value=null;
		Random random=new Random();
		TreeMap<String, Integer> map1=new TreeMap<String, Integer>();
		for(int j=0;j<5;j++){
			key=String.valueOf(j);
			value=random.nextInt(50);
			map1.put(key, value);		
		}
		System.out.println(map1);
		//����TreeMap��values
		if(map1!=null){
			Collection<Integer> c2=map1.values();
			Iterator<Integer> iterator2=c2.iterator();
			while (iterator2.hasNext()) {
				System.out.println(iterator2.next());
			}
		}
	}

}

class Name implements Comparable<Name>{
	private String firstName,lastName;
	public Name(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String toString(){return firstName+" "+lastName;}//��дtoString����
	
	//��дequals��hashCode����
	public boolean equals(Name name){
		return (firstName.equals(name.firstName) && lastName.equals(name.lastName));
	}
	public int hashCode(){
		return firstName.hashCode();
	}
	
	//��дcompareTo����
	public int compareTo(Name o){
		int lastCmp=lastName.compareTo(o.lastName);
		return (lastCmp!=0?lastCmp:firstName.compareTo(o.firstName));
	}
}