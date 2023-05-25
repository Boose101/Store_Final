package AQ;
public class ArrayQueue {
    private Person[] queue;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(){
        queue = new Person[20];
        front = 0;
        rear = 0;
        count = 0;
    }

    public ArrayQueue(int capacity){
        queue = new Person[capacity];
        front = 0;
        rear = 0;
        count = 0;
    }

    public Person[] getQueue(){
        return queue;
    }

    public int push(Person person){
        if (count != queue.length){
            queue[rear] = person;
            rear = (rear + 1) % queue.length;
            count++;
        }
        return count;
    }

    public Person front(){
        return queue[front];
    }

    public Person pop(){
        if(count == 0){
            return null;
        }
        Person i = queue[front];
        front = (front + 1) % queue.length;
        count--;
        return i;
    }

    public int getCount(){
        return count;
    }
}
