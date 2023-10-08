package com.example.springconcepts.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FairInterceptor implements InvocationHandler {
    // FairProxy use actual fair to proceed to the stall method
    private Fair fair;

    public FairInterceptor(Fair fair) {this.fair = fair;}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Visitor visitor = (Visitor) args[0];
        if(method.getName().equals("beerStall") || method.getName().equals("alcoholStall") || method.getName().equals("cigaretteStall")) {
            if(visitor.getAge() >= 18) {
                // Proceed to the actual method if visitor is over 18
                return method.invoke(fair, args);
            }else {
                return "NOT ALLOWED";
            }

        }
        // If the method is not "concerned" just invoke it !
        return method.invoke(fair, args);
    }
}
