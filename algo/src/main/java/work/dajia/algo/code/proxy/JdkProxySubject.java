package work.dajia.algo.code.proxy;

import ch.qos.logback.core.net.server.Client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxySubject implements InvocationHandler {
    private TargetSubject targetSubject;

    public JdkProxySubject(TargetSubject targetSubject) {
        this.targetSubject = targetSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object res = null;
        try {
            res = method.invoke(targetSubject, args);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("after");
        return res;
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = (Subject) Proxy.newProxyInstance(
                Client.class.getClassLoader(),
                new Class[]{Subject.class},
                new JdkProxySubject(new TargetSubject())
        );
        subject.helloword();
    }
}
