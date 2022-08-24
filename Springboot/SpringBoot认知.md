#### 1.SpringBoot核心知识

##### 1.1谈谈你对SpringBoot的理解

- 首先从本质上说SpringBoot就是Spring;它较Spring来说更加的轻便，降低对Spring Bean的配置程度；
- 其二它比较容易创建一个能独立运行的、准生产级别、基于Spring框架的项目；
- SpringBoot只是作为Spring的一个脚手架，并不具备Spring的核心功能；它集成了Servlet、tomcat等；不需要外部配置；极大的提高了开发和部署效率；

##### 1.2 Spring Boot Starter有什么用？

- 用来提供众多的起步依赖（Starter)降低项目依赖的复杂度。通常在pom.xml文件进行配置；配置名通常可以展示其依赖名可以实现哪些功能；你只要添加Spring Boot的Web起步依赖就好了。

##### 1.3简述Spring Boot的启动流程？

SpringBoot项目创建完默认会生成一个*Application的入口类，我们通过该类的main方法启动Spring Boot项目的。在main方法中，通过SpringApplication的静态方法，即run方法进行SpringApplication类的实例化操作，在针对实例化对象调用另外一个run方法来完成一个项目的初始化和启动。

- 获取SpringApplicationListener监听器==>启动获取的所有监听器==>初始化ConfigurableEnvironment(配置环境)==>打印Banner图标(在哪里改不知道)==>创建容器(ConfigurableApplicationContext)==>准备容器(ConfigurableApplicationContext)==>初始化容器==>监听器通知容器启动完成==>监听器通知容器正在启动
- ![image-20220816192128332](C:\Users\qin\AppData\Roaming\Typora\typora-user-images\image-20220816192128332.png)

##### 1.4 Spring Boot项目如何导入包的？

- 当然是Spring Boot Starter;详见1.2

##### 1.5 描述Spring Boot自动装配的过程？

- 使用SpringBoot时，只需要引入对应的Starters,SpringBoot启动时便会自动加载相关依赖，配置相应的初始化参数，以最快捷、简单的形式对第三方软件进行集成，这便是SpringBoot的自动装配功能。

  ![image-20220816193942097](C:\Users\qin\AppData\Roaming\Typora\typora-user-images\image-20220816193942097.png)

- 自动装配的过程：@EnableAutoConfiguration注解开启自动装配；
- 加载spring.factories中注册的各种AutoConfiguration类
- 当AutoConfiguration类满足其注解@Conditional指定的生效条件(Starters提供的依赖、配置或Spring容器中是否存在某个Bean)时，实例化该AutoConfiguration类中定义的Bean（组件等)，并注入Spring容器，就可以完成依赖框架的自动装配；

##### 1.6SpringBoot核心注解

1. @SpringBootApplication注解：在SpringBoot入口类中，唯一的一个注解就是@SpringBootApplication。它是SpringBoot项目的核心注解，用于开启自动配置，准确的说是通过该注解内组合的@EnableAutoConfiguration开启了自动配置1。

2. @EnableAutoConfiguration注解:在其中的主要功能是启动Spring应用程序上下文时进行自动配置，它会尝试猜测并配置项目中可能需要的Bean。自动配置通常是基于项目classpath引入的类和已经定义的Bean来实现的。在此过程中，被自动配置的组件来自项目自身和项目依赖的jar包。

3. @Import注解: @EnableAutoConfiguration的关键功能通过@Import注解导入的ImportSelector来完成。从源代码得知@Import(AutoConfigurationImportSelector.class)是@EnableAutoConfiguration注解的组成部分，也是自动配置功能的核心实现者。

4. @Conditional注解：

   @Conditional注解是由Spring 4.0版本引入的新特性，可根据是否满足指定的条件来决定是否进行Bean的实例化及装配，比如，设定当类路径下包含某个jar包的时候才会对注解的类进行实例化操作。总之，就是根据一些特定条件来控制Bean实例化的行为。

5. 4的衍生注解:自己看源码

##### 1.7普通注解的创建

1. 注解是Java代码中的特殊标记，这些标记可以在编译、类加载、运行时被读取，并执行相应的处理。

```java
//--------定义注解----------
public @interface MyAnnotation{
      //定义一个属性 value
        String value();
    //定义两个属性 name 和 age
    String name() default "小桃子";
    int age() default 18;
}

//------------实现注解------------
public class TestAnnotation {
    //使用带属性的注解时，需要为属性赋值
    @MyAnnotation(value="good",name="Tom",age=18)
    public void getObjectInfo(){

    }
}
```

- 元注解

  Java 元注解主要是存放在 java.lang.annotation 包中，所有的注解的本质就是一个继承了 Annotation 接口的接口。

  元注解是用于修饰注解的注解，通常用在注解的定义上。

  JDK 5 中主要提供了 4 个元注解：

  1. `Target`：指明注解支持的使用范围，以下为各取值的含义：

     - `ElementType.TYPE` 用于注解类、接口、枚举
     - `ElementType.FIELD` 用于注解属性
     - `ElementType.METHOD` 用于注解方法
     - `ElementType.PARAMETER` 用于注解参数
     - `ElementType.CONSTRUCTOR` 用于注解构造器
     - `ElementType.LOCAL_VARIABLE` 用于注解局部变量
     - `ElementType.ANNOTATION_TYPE` 用于注解注解
     - `ElementType.PACKAGE` 用于注解包

  2. `Retention`：指明注解保留的时间长短，以下为各取值的含义：

     - `SOURCE` 表示源文件中保留
     - `CLASS` 表示 class 编译时保留
     - `RUNTIME` 表示运行时保留

  3. `Inherited`：指明该注解类型被自动继承。

     如果一个 annotation 注解被 `@Inherited` 修饰，那么该注解作用于类的子类也会使用该 annotation 注解。

  4. `Documented`：指明拥有这个注解的元素可以被 `javadoc` 此类的工具文档化。

  JDK 8 中又提出了 2 个元注解：

  1. `Native` ：

     主要修饰成员变量，表示该变量可以被本地代码直接引用，在框架应用中代码自动生成工具进行使用。自己编写的代码中用到较少。

  2. `Repeatable` ：

     自从 JDK 5 引入了注解以后，注解就被广泛应用于各个框架之中。

     但 JDK 5 引入的注解存在一个问题：在同一个地方不能多次使用同一个注解。

     而 JDK 8 就打破了这个限制，引入了重复注解的概念，允许在同一个地方多次使用同一个注解。

     在 JDK 8 中使用 `@Repeatable` 注解定义重复注解，请看以下程序中的代码：

     ```java
     // 自定义注解，该注解中包含了数组类型的注解Authority[]
     @interface Authorities {
         Authority[] value();
     }
     // 通过@Repeatable标识Authority注解可以重复出现在Authorities注解中
     @Repeatable(Authorities.class)
     public @interface Authority {
         String value();
     }
     ```

     在创建重复注解 Authority 时，通过 `@Repeatable` 标识 Authority 注解可以在 Authorities 注解中出现多次，并且通过 Authorities 注解的定义可知，Authority 注解实际是以数组形式在 Authorities 中存储了多个。

     之后，在使用的时候，就可以重复使用 Authority 注解了，如以下程序所示。

     ```java
     @Authority(value="Admin")
     @Authority(value="Manager")
     interface AuthorityInterface {
     }
     ```

##### 1.8 SpringSecurity简单应用

#### 2.Spring核心

##### 2.1请说明Spring的核心是什么?

- 框架包含很多模块:Core、Testing、Data Access 、Web Serlet等，Core为核心模块。
- Core模块提供了Ioc容器、AOP功能、数据绑定、类型转换等一系列功能，而这些功能以及其他功能都是建立在IoC和AOP之上，也就是说Core模块中的AOP和IOC是Spring框架的核心。
  - IOC(控制反转)：面向对象编程的设计思想。不再用控制反转就需要维护对象与对象的依赖照成对象间耦合度过高。一对多变成了多对一（多提高了使用对象的效率）
  - IOC控制反转需要DI（依赖注入），他是IOC实现的方式。实现依赖注入的关键是IOC容器，它的本质就是一个工厂。
  - AOP是面向切面编程的思想，是对OOP的补充。提高OOP的编程效率。功能：解决一批组件共性需求（权限检查、记录日志、事务处理），通过配置的方法声明什么时候用。AOP可以将业务代码织入到我们的位置。

##### 2.2 对BeanFactory的了解

BeanFactory是一个类工厂，与传统类工厂不同的是，BeanFactory是类的通用工厂，它可以创建并管理各种类的对象。这些可被创建和管理的对象本身没有什么特别之处，仅是一个POJO，Spring称这些被创建和管理的Java对象为Bean。并且，Spring中所说的Bean比JavaBean更为宽泛一些，所有可以被Spring容器实例化并管理的Java类都可以成为Bean。

BeanFactory是Spring容器的顶层接口，Spring为BeanFactory提供了多种实现，最常用的是XmlBeanFactory。但它在Spring 3.2中已被废弃，建议使用XmlBeanDefinitionReader、DefaultListableBeanFactory替代。BeanFactory最主要的方法就是 getBean(String beanName)，该方法从容器中返回特定名称的Bean。

##### 2.3 Spring容器的了解？

Spring主要提供了两种类型的容器:BeanFactory和ApplicationContext.

- BeanFactory：最基础类型IoC容器，提供完整Ioc服务支持：当客户端对象访问容器中的某个受管对象的时候，才对该受管对象进行初始化以及依赖注入操作。（资源有限|功能管理不严格）
- ApplicationContext: 在BeanFactory基础上构建；拥有BeanFactory也有其他高级特性；时间发布、国际化信息支持；启动时就完成所有初始化比上面的更慢；

##### 2.4对SpringIOC的理解

- 所谓IOC就是控制反转的意思，需要利用DI进行注入
- 注入方式为如下：
  - 构造方法注入
    - 就是被注入对象可以在构造方法中声明依赖对象的参数列表，让外部知道他需要哪些依赖对象。然后，IOC Service Provider会检查被注入的对象的构造方法，取得它所需要依赖对象的列表，进而为其注入相应的对象。
  - Setter方法注入
    - 通过setter方法，可以更改相应的对象属性；可以在对象构造完后再注入。
  - 接口注入
    - 接口注入比较死板和繁琐；他必须实现接口。接口提供方法用来为其注入对象。（侵入性强；不流行）

#### 3.反射机制的实现与框架底层的学习

##### 3.1反射机制

- 应用场景：可以在程序运行时，动态的加载、探知、使用编译期间完全未知的类。即可以在运行时得知类的完整构造方法，并实例化对象，调用对象设定的方法。

- 动态调用：

  - 通过Class类获取对应类的构造方法，获得构造方法==>创建对应类的实例对象。

  - newInstance()方法

    ```java
    /**
     * 通过 newInstance() 方法创建新对象
     */
    public class TestNewInstance{
        public static void main(String args[]) {
            try {
                Class<?> c = Class.forName("Sub");   //Sub为类名
                // 通过 Class 类的 newInstance() 方法创建对象
                Sub sub = (Sub) c.newInstance();
                System.out.println(sub.subPublic());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    ```

  - 动态的访问属性和方法

  - 操作动态数组

##### 3.2Class类

##### 3.3获取运行时信息

##### 3.4动态调用

#### 























