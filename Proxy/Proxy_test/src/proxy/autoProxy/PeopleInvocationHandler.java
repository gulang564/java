package proxy.autoProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PeopleInvocationHandler implements InvocationHandler {

    private Object people;

    PeopleInvocationHandler(Object people){
        this.people = people;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("-------- start ---------");
        System.out.println(method);

        System.out.println(Arrays.toString(args));
        Object invoke = method.invoke(people, args);
        System.out.println("-------- end ---------");
        return invoke;
    }
}
