#### 代理模式
为另一个对象提供一个替身或占位符以控制对这个对象的访问  

在代理模式中  
因为Proxy和RealSubject会实现相同接口(Subject)  
所以任何用到RealSubject的地方  都可以用Proxy取代  
这些情况有：  
RealSubject是远程的对象、RealSubject创建开销大、RealSubject需要被保护


#### 动态代理
java在java.lang.reflect包中有自己的代理支持  
利用这个包你可以在运行时动态的创建一个代理类  实现一个或多个接口  
并将方法的调用转发到你所指定的类  
因为实际的代理类是在运行时创建的  我们这个java技术为：**动态代理**  


因为java已经为你创建了Proxy类  所以你需要有办法来告诉Proxy类你要做什么  
你不能像以前一样  把代码放在Proxy类中  因为Proxy不是你直接实现的  
那么代码应该放在哪里？  
放在`InvocationHandler`中  
`InvocationHandler`的工作是响应代理的任何调用  
你可以把`InvocationHandler`想成是代理收到方法调用后  请求做实际工作的对象