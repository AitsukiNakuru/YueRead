package Annotation;

/**
 * 定义一个注解
 */
@interface Login {
    //定义两个成员变量
    //以default为两个成员变量指定初始值
    String username() default "zhangsan";
    String password() default "123456";
}

class Main{
    /**
     * 使用注解　　　* 因为它的成员变量有默认值，所以可以无须为成员变量指定值，而直接使用默认值
     */


    public static void main(String[] args) {
        System.out.println();
    }
}
