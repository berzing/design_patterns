package proxy.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 非拥有者调用处理器
 *
 * InvocationHandler实现了代理的行为
 * java是负责创建真实代理类和对象
 * 我们只需要提供方法调用发生时知道做什么的handler
 *
 * 当代理的方法被调用时  代理就会把这个调用转发给InvocationHandler!!!!!!!!!!!!!!
 */
public class NonOwnerInvocationHandler implements InvocationHandler {

    PersonBean person;

    public NonOwnerInvocationHandler(PersonBean person){
        this.person = person;
    }


    //每次proxy的方法被调用  就会导致proxy调用此方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {
            if (method.getName().startsWith("get")) {  //如果方法是一个getter  我们就调用person内的方法
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
                return method.invoke(person, args);
            } else if (method.getName().startsWith("set")) {
                throw new IllegalAccessException();  //你不能修改别人的信息  你只能给别人打分
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;  //如果调用其它方法一律不理  返回null
    }
}
