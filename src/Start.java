public class Start {

	public static void main(String[] args) {
		
		MyList<Integer> intList = new MyList<>();

		for (int i = 1; i < 5; i++) {
			intList.add(i);
		}
		
		System.out.println("get链表中总元素长度 = " + intList.getSize());
		
		System.out.println("get第二位元素 = " + intList.get(2));
		
		System.out.println("调用链表本身的打印方法");
		intList.print();
		
		System.out.println("\n调用链表本身的反向打印方法");
		intList.reversePrint();
		
		System.out.println("\n调用迭代器打印");
		for(int i : intList){
			System.out.println(i);
		}
		
		intList.remove(2);
		System.out.println("\n删除第二个元素后调用迭代器打印");
		for(int i : intList){
			System.out.println(i);
		}
		
		intList.insert(2, 2);
		System.out.println("\n插入第二个元素后调用迭代器打印");
		for(int i : intList){
			System.out.println(i);
		}
	}
}

