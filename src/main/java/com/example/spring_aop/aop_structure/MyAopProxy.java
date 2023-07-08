package com.example.spring_aop.aop_structure;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/06/15 0:07
 * Package_name: com.example.spring_aop.aop_structure
 * Description:  Version: V1.0
 * Comment Before See:
 */

import org.springframework.aop.Advisor;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于生成动态代理类
 */
public class MyAopProxy {

    //这个是MethodInterceptor对象  用于对方法做处理
    /**
     * 而且这个类是一个静态的(不允许往这个类中, 添加成员变量) 所欲的成员变量应该添加到methodInterceptor
     * 当中, 就算是被代理对象也应该添加到这个methodInterceptor当中, 作为这个成员变量的一个参数
     */
    private MethodInterceptor methodInterceptor;

    public static class XXXMethodInterceptor implements MethodInterceptor{

        //用于保存被代理的对象
        private Object object;

        public XXXMethodInterceptor(Object o) {
            this.object = o;
        }

        //用于初始化增强链
        public void addAdvisors(Advisor advisor){
            //判断Advisor不为空
            if (advisor == null){
                this.advisors = new ArrayList<>();
            }
            this.advisors.add(advisor);
        }

        //用于保存增强链
        List<Advisor> advisors;

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            //用于保存执行结果
            Object result = null;
            //遍历增强链用于执行代理的逻辑
            for (Advisor advisor : advisors) {
                /**
                 * 伪代码, 判断这个增强应不应该执行 即:判断增强的执行时机
                 * 比如前置增强
                 */
                /**
                 * if (advisor可以在这个时间执行-->是前置增强){
                 *      执行advisor
                 * }
                 * //所有前置增强执行完了, 执行目标方法
                 * result = Method.invoke(o, args);
                 *
                 * if (advisor可以在这个时间执行-->是后置增强){
                 *    执行advisor
                 * }
                 */

            }
            return result;
        }
    }
}
/**
 * 你对简化后的Spring AOP逻辑的描述基本上是正确的。下面我对你提供的代码进行一些解释和补充说明：
 * public class MyAopProxy {
 *     private MethodInterceptor methodInterceptor;
 *
 *     // ... 省略其他代码 ...
 *
 *     public static class XXXMethodInterceptor implements MethodInterceptor {
 *         private Object object;
 *
 *         public XXXMethodInterceptor(Object o) {
 *             this.object = o;
 *         }
 *
 *         // ... 省略其他代码 ...
 *
 *         @Override
 *         public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
 *             Object result = null;
 *             for (Advisor advisor : advisors) {
 *                 // 判断增强的执行时机，并执行相应的增强逻辑
 *                 // 比如前置增强
 *                 if (advisor instanceof BeforeAdvisor) {
 *                     ((BeforeAdvisor) advisor).beforeMethod();
 *                 }
 *
 *                 // 执行目标方法
 *                 result = methodProxy.invokeSuper(o, objects);
 *
 *                 // 比如后置增强
 *                 if (advisor instanceof AfterAdvisor) {
 *                     ((AfterAdvisor) advisor).afterMethod();
 *                 }
 *             }
 *             return result;
 *         }
 *     }
 * }
 *
 * 上述代码中的MyAopProxy是一个代理工厂类，用于生成动态代理对象。XXXMethodInterceptor是一个实现了
 * MethodInterceptor接口的拦截器类，用于对方法进行拦截和增强操作。
 *
 * 在intercept方法中，代理对象的方法调用会经过拦截器的拦截逻辑。在循环遍历增强链的过程中，根据增强的执行时机，
 * 执行相应的增强逻辑。例如，前置增强在目标方法执行之前执行，后置增强在目标方法执行之后执行。在实际的代码中，
 * 你可以根据具体的增强类型和执行时机来编写对应的逻辑。
 *
 * 需要注意的是，上述代码中的Advisor、BeforeAdvisor和AfterAdvisor是虚拟的概念，实际的实现可能有所不同。
 * 在Spring AOP中，通常会使用Advisor接口及其实现类来表示不同类型的增强，例如前置增强、后置增强、环绕增强等。
 * 你可以根据具体的需求和业务逻辑来定义这些增强类型，并在拦截器中根据类型执行相应的增强逻辑。
 *
 * 此外，你可以根据需要进一步完善拦截器的逻辑，例如异常处理、环绕增强等。这里提供的代码只是一个简化的示例，
 * 你可以根据实际情况进行修改和扩展。
 */


/**
 * 你是对的，在Spring框架中使用AOP代理时，会将DynamicAdvisedInterceptor作为生成的代理类的一部分，并且在DynamicAdvisedInterceptor中有一个重要的成员变量AdvisedSupport，它用于保存代理对象以及增强链等相关信息。
 *
 * AdvisedSupport是Spring AOP中的一个核心类，它封装了代理对象、目标对象、拦截器链、方法匹配器等关于AOP的配置信息。DynamicAdvisedInterceptor通过持有AdvisedSupport对象，可以获取和管理这些配置信息，并在代理对象的方法调用中应用相应的拦截逻辑。
 *
 * AdvisedSupport中的一些重要属性包括：
 *
 * targetSource：用于封装目标对象的信息，包括目标对象本身以及目标对象的类型等。
 * methodInterceptor：拦截器链，存储了要应用于目标方法的各个拦截器。
 * methodMatcher：方法匹配器，用于确定哪些方法需要被拦截器链拦截。
 * proxiedInterfaces：代理接口数组，指示代理类要实现的接口。
 * opaque：标志位，指示是否有拦截器链或者目标对象需要被代理。
 * 通过将这些信息封装在AdvisedSupport中，Spring能够实现灵活的AOP代理逻辑。在运行时，代理对象的方法调用会经过DynamicAdvisedInterceptor的拦截器链，其中会根据AdvisedSupport中的配置信息进行拦截和增强的处理。
 *
 * 总而言之，DynamicAdvisedInterceptor和AdvisedSupport是Spring AOP实现中的重要组件，它们协同工作，实现了代理对象的拦截和增强逻辑，并提供了灵活的AOP配置和管理能力。
 */