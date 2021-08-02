//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）： 
//
// 实现 MyQueue 类： 
//
// 
// void push(int x) 将元素 x 推到队列的末尾 
// int pop() 从队列的开头移除并返回元素 
// int peek() 返回队列开头的元素 
// boolean empty() 如果队列为空，返回 true ；否则，返回 false 
// 
//
// 
//
// 说明： 
//
// 
// 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
// 
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
// 
//
// 
//
// 进阶： 
//
// 
// 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 1, 1, false]
//
//解释：
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.peek(); // return 1
//myQueue.pop(); // return 1, queue is [2]
//myQueue.empty(); // return false
// 
//
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用 100 次 push、pop、peek 和 empty 
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作） 
// 
// Related Topics 栈 设计 
// 👍 285 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
class MyQueue {
    //Stack Method Equivalent Deque Method
    //push(e)      addFirst(e)
    //pop()        removeFirst()
    //peek()       getFirst()
    //java中Stack有设计缺陷,官方推荐使用Deque代替Stack
    Deque<Integer> stack_in;
    Deque<Integer> stack_out;
    public MyQueue() {
        stack_in = new ArrayDeque<>();
        stack_out = new ArrayDeque<>();
    }

    public void push(int x) {
        stack_in.push(x);//push()在接口中等于addFirst()
    }

    public int pop() {
        // 只要stack_out为空，就把stack_in向stack_out中倒腾
        if (stack_out.isEmpty()) {
            while (!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.pop();
    }

    public int peek() {
        //使用已有的pop函数
        int res = this.pop();
        //pop函数弹出了元素res，所以再添加回去
        stack_out.push(res);
        return res;
    }

    public boolean empty() {
        return stack_in.isEmpty() && stack_out.isEmpty();
    }
    /**根据用队列实现栈的原理，同理应该可以实现栈实现队列
     * 栈的特点是先进先出，队列是先进后出，所以可以使用两个栈来模拟实现队列
     * 思路：push操作先把stack1中含有的元素全部倒进stack2中，此时将希望新
     * 添的元素push入stack1中，再把stack2中的元素倒回stack1中*/
    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack1.push(x);     //趁机push。乘虚而入
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
