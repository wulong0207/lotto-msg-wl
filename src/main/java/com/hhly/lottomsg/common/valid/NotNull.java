package com.hhly.lottomsg.common.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * @author jiangwei
 * @Version 1.0
 * @CreatDate 2016-12-1 下午2:50:57
 * @Desc 参数不能为空
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target({ ElementType.FIELD })  
public @interface NotNull {
    String msg() default "";
}
