package proxy.autoProxy;

public class Foreigner implements  People{
    @Override
    public void sayHello(String s) {
        System.out.println("说外国的hello");
    }

    @Override
    public void sayGoodby() {
        System.out.println("说外国的goodbye");
    }
}
