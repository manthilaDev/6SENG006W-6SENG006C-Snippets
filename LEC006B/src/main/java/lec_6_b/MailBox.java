package lec_6_b;

public interface MailBox<E> {
    public void put(E number);
    public E get();
}
