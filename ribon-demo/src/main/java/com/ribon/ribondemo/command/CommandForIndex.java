///*
//package com.ribon.ribondemo.command;
//
//import com.netflix.hystrix.*;
//import com.ribon.ribondemo.Domain.Teacher;
//import org.springframework.web.client.RestTemplate;
//
//*/
///**
// * @author Niclas
// * @create 2019-03-30-19:51
// *//*
//
//public class CommandForIndex extends HystrixCommand<Object> {
//
//    private RestTemplate restTemplate;
//
//  private String id;
//
//    public  CommandForIndex( RestTemplate restTemplate,String id) {
//        // java代码配置， 只针对这个命令
//        super(Setter
//                // 必填项。指定命令分组名，主要意义是用于统计
//                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("DnHello-Group"))
//                // 依赖名称（如果是服务调用，这里就写具体的接口名， 如果是自定义的操作，就自己命令），默认是command实现类的类名。 熔断配置就是根据这个名称
//                .andCommandKey(HystrixCommandKey.Factory.asKey("ConsumerController"))
//                // 线程池命名，默认是HystrixCommandGroupKey的名称。 线程池配置就是根据这个名称
//                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("DnUser-ThreadPool"))
//
//                // 设置线程池参数
//                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
//                                // 线程池大小
//                                .withCoreSize(1)
//                        //允许最大的缓冲区大小
////                       .withMaxQueueSize(2)
//                ));
//        this.id = id;
//        this.restTemplate = restTemplate;
//    }
//
//    */
///**
//     * Implement this method with code to be executed when {@link #execute()} or {@link #queue()} are invoked.
//     *
//     * @return R response type
//     * @throws Exception if command execution fails
//     *//*
//
//    @Override
//    protected Object run() throws Exception {
//        System.out.println("##commid######"+Thread.currentThread().toString());
//       Teacher t = restTemplate.getForObject("http://helloclient/teacher?id="+id+"", Teacher.class);
//       System.out.println("####command#######结束,结果"+t.toString());
//        return t;
//    }
//
//    */
///**
//     * If {@link #execute()} or {@link #queue()} fails in any way then this method will be invoked to provide an opportunity to return a fallback response.
//     * <p>
//     * This should do work that does not require network transport to produce.
//     * <p>
//     * In other words, this should be a static or cached result that can immediately be returned upon failure.
//     * <p>
//     * If network traffic is wanted for fallback (such as going to MemCache) then the fallback implementation should invoke another {@link HystrixCommand} instance that protects against that network
//     * access and possibly has another level of fallback that does not involve network access.
//     * <p>
//     * DEFAULT BEHAVIOR: It throws UnsupportedOperationException.
//     *
//     * @return R or throw UnsupportedOperationException if not implemented
//     *//*
//
//    @Override
//    protected Object getFallback() {
//        return "我降级了~~~~~~~~~~~~~";
//    }
//}
//*/
