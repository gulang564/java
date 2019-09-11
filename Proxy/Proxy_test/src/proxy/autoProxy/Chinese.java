package proxy.autoProxy;

public class Chinese implements People {
    @Override
    public void sayHello(String s ) {
        System.out.println("Chinese say hello.");
    }

    @Override
    public void sayGoodby() {
        System.out.println("Goodby");
    }
}
