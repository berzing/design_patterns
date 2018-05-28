package proxy.javaproxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;


/**
 * 加入你现在负责一个约会服务系统
 * 服务中hot表示喜欢  not表示不喜欢
 *
 * 该系统要求：
 * 用户只能修改自己的兴趣(interests)  不能修改别人的
 * 用户只能给别人打分(rating)  而不能自己给自己打分
 * =====
 * 我们可以使用保护代理完成以上需求
 * 保护代理：一种根据访问权限决定客户可否访问对象的代理
 * ====
 * 因此  我们必须创建两个代理：一个访问我自己的PersonBean对象  一个访问别人的PersonBean对象
 * ====
 * 而创建这种代理  我们必须使用java api的"动态代理"    这样java就会为我们创建两个代理
 * 我们只需要"提供handler"来创建代理转来的方法!!!!!!!!
 */
public class MatchMakingTestDrive {

    HashMap<String,PersonBean> datingDB = new HashMap<>();

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public MatchMakingTestDrive(){
        initialzeDatabase();
    }


    public void drive(){
        PersonBean joe = getPersonFromDatabase("joe javabean");
        PersonBean ownerProxy = getOwnerProxy(joe);  //创建拥有者代理
        System.out.println("name is "+ownerProxy.getName());  //调用getter
        ownerProxy.setInterests("bowling, go");
        System.out.println("interests set from owner proxy");
        try{
            ownerProxy.setHotOrNotRating(10);  //自己是不能给自己评分的  会报错!!
        }catch (Exception e){
            System.out.println("can't set rating from owner proxy");
        }
        System.out.println("rating is "+ownerProxy.getHotOrNotRating());


        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("name is "+nonOwnerProxy.getName());
        try{
            nonOwnerProxy.setInterests("bowling, go");
        }catch (Exception e){
            System.out.println("can't set interests from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("rating set from non owner proxy");
        System.out.println("rating is "+nonOwnerProxy.getHotOrNotRating());
    }


    /**
     * 此方法需要一个person对象作为参数  然后返回他的代理
     * 因为代理和主题有相同的接口
     * 所以我们返回一个PersonBean
     * ==========
     * newProxyInstance()  创建代理
     * getClassLoader()  personBean类加载器
     * getInterfaces()  代理需要实现的接口
     * ==========
     * new OwnerInvocationHandler(person)
     * 将person传入调用处理器的构造器中
     * 这正是调用处理器能够访问真实主题的原因!!!!!!!!!!!!!!!!!!!!!!!!
     *
     * @param person
     * @return
     */
    PersonBean getOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    PersonBean getNonOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }

    PersonBean getPersonFromDatabase(String name){
        return (PersonBean) datingDB.get(name);
    }


    //初始化数据库
    void initialzeDatabase(){
        PersonBean joe = new PersonBeanImpl();
        joe.setName("joe javabean");
        joe.setInterests("cars, computers, music");
        joe.setHotOrNotRating(7);
        datingDB.put(joe.getName(), joe);

        PersonBean kelly = new PersonBeanImpl();
        kelly.setName("kelly klosure");
        kelly.setInterests("ebay, movies, music");
        kelly.setHotOrNotRating(6);
        datingDB.put(kelly.getName(), kelly);
    }
}
