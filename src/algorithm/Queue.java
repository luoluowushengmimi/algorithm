package algorithm;
/** 
 * 循环队列 
 如上图所示，这种头尾相接的顺序存储结构称为循环队列（circular queue）。
循环队列中需要注意的几个重要问题：
①队空的判定条件，队空的条件是front=rear；
②队满的判定条件，（rear+1）%QueueSize=front。QueueSize为队列初始空间大小。
 * @author gy
 */  
import java.util.Arrays;

public class Queue {
  private  int[] queue;
  private static final int size=10;
  private int front;
  private int rear;
  
  @SuppressWarnings("unchecked")  
  public Queue(){  
	  queue=new int[size];
      front=0;  
      rear=0;  
  }  
  
public int[] getQueue() {
	return queue;
}

public int getSize() {
	return size;
}

public int getFront() {
	return front;
}

public int getRear() {
	return rear;
}
public boolean isEmpty(){  
    return rear==front;  
}  
public int pop(){
	  if(this.isEmpty()){
		throw new RuntimeException("队列个数为0，无法提取元素");
	  }
	  else{
		  int result=queue[front];
		  queue[front]=-1;
		  front=(front+1)%queue.length;  
		  return result;
	  }
	}

public int getLength(){
	if(rear>front)return rear-front+1;
	else if(rear==front) return 0;
	else  return queue.length-front+rear+1;
}
  public void push(int value){
        if((rear+1)%queue.length==front){ 
		  int[] nqueue=Arrays.copyOf(queue, size*2);
		  nqueue[size-1]=value;
		  queue=nqueue;
		  rear++;
	  }
	  else{
		  queue[rear]=value;  
          rear=(rear+1)%queue.length; 
	  }
  }
  
  public String getContent(){
	  StringBuilder sb=new StringBuilder();
 for(int i=0;i<queue.length;i++){
	 sb.append(queue[i]+", ");
 }
 return sb.toString();
  }
  public static void main(String[] args) {
	Queue q=new Queue();
	for(int i=0;i<=8;i++){
		q.push(i);
	}
	for(int i=0;i<=5;i++){
		q.pop();
	}
System.out.println(q.getContent());
}
}
