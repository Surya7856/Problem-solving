//once you transfer the elements to stack2 then no need to transfer back
//directly push the new element to stack1
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        int top=peek();
        s2.pop();
        return top;
    }
    
    public int peek() {
        if(!s2.empty()){
            return s2.peek();
        }
        else{
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
