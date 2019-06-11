package info.loveai.aspectcenter;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MainActivityAspect {
    private static final String TAG = "AOPDemo";

    // call(<注解？> <修饰符?> <返回值类型> <类型声明?>.<方法名>(参数列表) <异常列表>？)
    // @Pointcut("call(@Describe public void com.davidkuper.MainActivity.init(Context))")
//    @Pointcut("call(* info.loveai.aspectjdemo.MainActivity.on**())")
//    public void callOnResume(){}
//
//    @Before("callOnResume()")
//    public void beforeMethodCall(JoinPoint joinPoint) {
//        Log.e(TAG, "before->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
//    }

    @Before("execution(protected void info.loveai.aspectjdemo.MainActivity.onResume())")
    public void onResumeBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onResumeBefore: " + key+"\n"+joinPoint.getThis());
    }

    @Before("call(public static void info.loveai.aspectjdemo.MainActivity.testStatic())")
    public void testStaticBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "testStaticBefore: " + key+"\n"+joinPoint.getThis());
    }

    @Before("execution(protected void info.loveai.aspectjdemo.MainActivity.onStart())")
    public void onStartMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onStartBefore: " + key+"\n"+joinPoint.getThis());
    }

//    @Before("execution(protected void info.loveai.aspectjdemo.MainActivity.onCreate(android.os.Bundle))")
//    public void onCreateMethodBefore(JoinPoint joinPoint) throws Throwable {
//        String key = joinPoint.getSignature().toString();
//        Log.d(TAG, "onCreateBefore: " + key+"\n"+joinPoint.getThis());
//    }

    //  @Pointcut("call(@Describe public void com.davidkuper.MainActivity.init(Context))")
    @Pointcut("call(protected void info.loveai.aspectjdemo.MainActivity.onCreate(android.os.Bundle))")
    public void callOnCreate(){}

    @Before("callOnCreate()")
    public void beforeCallOnCreate(JoinPoint joinPoint) {
        Log.e(TAG, "beforeCallOnCreate->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }

    @After("callOnCreate()")
    public void afterCallOnCreate(JoinPoint joinPoint) {
        Log.e(TAG, "afterCallOnCreate->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }
}
