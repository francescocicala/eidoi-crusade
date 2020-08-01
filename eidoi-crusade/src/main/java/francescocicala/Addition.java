package francescocicala;

public class Addition {
    int value1, value2;

    Addition(int value1, int value2){
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getResult() {
        return value1 + value2;
    }
}