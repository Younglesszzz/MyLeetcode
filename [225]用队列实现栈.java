//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。 
//
// 实现 MyStack 类： 
//
// 
// void push(int x) 将元素 x 压入栈顶。 
// int pop() 移除并返回栈顶元素。 
// int top() 返回栈顶元素。 
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 注意： 
//
// 
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。 
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用100 次 push、pop、top 和 empty 
// 每次调用 pop 和 top 都保证栈不为空 
// 
//
// 
//
// 进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的
//时间。你可以使用两个以上的队列。 
// Related Topics 栈 设计 
// 👍 281 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.LinkedList;
import java.util.Queue;
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }


    /**队列的特点是先进后出，而栈的特点是先进先出,
     * 如果想用queue来实现stack的操作，那么需要考虑如何颠倒顺序
     * 以下用双队列实现，还可以使用单队列实现，原理相同，将队头的元素
     * 出列重新放置到队尾即可*/

    /** Initialize your data structure here. */
//    private Queue<Integer> queue1;
//    private Queue<Integer> queue2;
//    public MyStack() {
//        queue1 = new LinkedList<>();
//        queue2 = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        //先push到queue2中，再把queue1中的元素依次出列，进入queue2，实现倒序
//        queue2.offer(x);
//        while (!queue1.isEmpty())
//            queue2.offer(queue1.poll());  //依次出列
//        Queue<Integer> temp = queue1;
//        queue1 = queue2;
//        queue2 = temp;
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        return queue1.poll();
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return queue1.peek();
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return queue1.isEmpty();
//    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
