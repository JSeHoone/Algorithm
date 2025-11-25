package singlelinkedlist;

public class Node <T>{

    // next를 null로 만든 이유 : 노드가 생성되자마자 next가 결정 되는 것은 아니라고 생각되어서
    public Node<T> next = null;
    public T data;

    public Node(T data) {
        this.data = data;
    }
}
