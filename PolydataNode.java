
public class PolydataNode<T> {
    T Coeff;
    T Power;

    PolydataNode<T> next;

    public PolydataNode(T coeff , T power) {
        Coeff = coeff;
        Power = power;
        next = null;
    }



}
