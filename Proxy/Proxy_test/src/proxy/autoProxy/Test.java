package proxy.autoProxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Chinese chinese = new Chinese();
        PeopleInvocationHandler invocationHandler = new PeopleInvocationHandler(chinese);
        People proxy = (People) Proxy.newProxyInstance(chinese.getClass().getClassLoader(), chinese.getClass().getInterfaces(), invocationHandler);
        proxy.sayHello("sjfd");
        proxy.sayGoodby();
        System.out.println("-----------------------------------------------------");

        Foreigner foreigner=new Foreigner();
        PeopleInvocationHandler fi=new PeopleInvocationHandler(foreigner);
        People p=(People)Proxy.newProxyInstance(foreigner.getClass().getClassLoader(),foreigner.getClass().getInterfaces(),fi);
        p.sayHello("醉了");
        p.sayGoodby();

        System.out.println("类加载器是个什么东西"+foreigner.getClass().getClassLoader());
    }
}
