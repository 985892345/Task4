import java.util.*;
/*
 *实现双向循环链表
 *  ┌─────(per)─────┐ ┌────(per)────┐ ┌─────(per)─────┐┌─(per)─┐
 *  ↓               │ ↓             │ ↓               │↓       │
 *Header──(next)──>Node1──>(next)──>Node2──>(next)──>……………──>Tail
 * │ ↑                                                       │ ↑
 * │ └────────────────────────(next)─────────────────────────┘ │
 * └──────────────────────────(per)────────────────────────────┘
 */
public class MyList<E> implements Iterable<E>{
	private int size = 0;//记录长度
	private Node Header;//链表头，不装data
	private Node Tail;//链表尾，不装data
	public MyList(){
		//第一个装data，第二个装前一个对象地址，第三个装后一个对象地址
		Header = new Node(null, null, null);
		Tail = new Node(null, Header, Header);
		Header.pre = Tail;
		Header.next = Tail;
		//上面代码实现双向循环链表，头和尾连在了一起
	}

	public void add(E item){
		Node aNode = new Node(item, null, null);
		//尾Tail前一个对象保存的后一个对象地址改为新的对象
		Tail.pre.next = aNode;
		//新对象的前一个对象地址改为尾Tail前一个对象
		aNode.pre = Tail.pre;
		//新对象的后一个对象地址改为尾Tail
		aNode.next = Tail;
		//尾Tail前一个对象地址改为新对象地址
		Tail.pre = aNode;
		size++;
	}
	
	public E get(int index){
		Node current = Header;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		return current.data;
	}
	
	public void remove(int index){
		Node current = Header;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		current.pre.next = current.next;
		current.next.pre = current.pre;
		size--;
	}
	
	public void insert(int index, E data){
		Node newNode = new Node(data, null, null);
		Node current = Header;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		current.pre.next = newNode;
		newNode.pre = current.pre;
		current.pre = newNode;
		newNode.next = current;
		size++;
	}

	public int getSize(){
		return size;
	}

	public void print(){
		Node current = Header.next;
		while(current != Tail){
			System.out.println(current.data.toString()); 
			current = current.next;
		}
	}
	
	//反向打印
	public void reversePrint(){
		Node current = Tail.pre;
		while(current != Header){
			System.out.println(current.data.toString()); 
			current = current.pre;
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new MyListIterator();
	}

	private class MyListIterator implements Iterator<E>{
		Node current = Header;
		
		@Override
		public boolean hasNext() {
			current = current.next;
			return (current != Tail);
		}

		@Override
		public E next() {
			return current.data;
		}

		@Override
		public void remove() {
			System.out.println("暂不支持迭代器中删元素");
		}
	}
	
	private class Node{
		public E data;
		public Node pre;
		public Node next;

		public Node(E data, Node pre, Node next){
			this.data = data;
			this.pre = pre;
			this.next = next;
		}
	}
}

