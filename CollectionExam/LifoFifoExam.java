import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LifoFifoExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LIFO
		Stack<String> stack = new Stack<String>();
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		
		for(int i=0; i<stack.size(); i++) {
			System.out.println(stack.peek());
		}
		
		int end = stack.size();
		for(int i=0; i<end; i++) {
			System.out.println(stack.pop());
		}
		
		//FIFO
		Queue<String> queue = new LinkedList<String>();
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		queue.offer("4");
		
		for(int i=0; i<queue.size(); i++) {
			System.out.println(queue.peek());
		}
		
		end = queue.size();
		for(int i=0; i<end; i++) {
			System.out.println(queue.poll());
		}
		
	}

}
