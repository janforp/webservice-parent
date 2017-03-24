#webService远程访问
             如：java访问PHP接口
             http://blog.csdn.net/qjyong/article/details/2148558

             sgen与wsimport命令说明

             wsgen
             wsgen是在JDK的bin目录下的一个exe文件（Windows版），该命令的主要功能是用来生成合适的JAX-WS。它读取Web Service的终端类文件，同时生成所有用于发布Web Service所依赖的源代码文件和经过编译过的二进制类文件。这里要特别说明的是，通常在Web Service Bean中用到的异常类会另外生成一个描述Bean，如果Web Service Bean中的方法有申明抛出异常，这一步是必需的，否则服务器无法绑定该对像。此外，wsgen还能辅助生成WSDL和相关的xsd文件。wsgen从资源文件生成一个完整的操作列表并验证web service是否合法，可以完整发布。
             命令参数说明：
              -cp 定义classpath
              -r 生成 bean的wsdl文件的存放目录
              -s 生成发布Web Service的源代码文件的存放目录（如果方法有抛出异常，则会生成该异常的描述类源文件）
              -d 生成发布Web Service的编译过的二进制类文件的存放目录（该异常的描述类的class文件）

             命令范例：wsgen -cp ./bin -r ./wsdl -s ./src -d ./bin -wsdl org.jsoso.jws.server.Example

             wsimport
             wsimport也是在JDK的bin目录下的一个exe文件（Windows版），主要功能是根据服务端发布的wsdl文件生成客户端存根及框架，负责与Web Service 服务器通信，并在将其封装成实例，客户端可以直接使用，就像使用本地实例一样。对Java而言，wsimport帮助程序员生存调用web service所需要的客户端类文件.java和.class。要提醒指出的是，wsimport可以用于非Java的服务器端，如：服务器端也许是C#编写的web service，通过wsimport则生成Java的客户端实现。
             命令参数说明：
              -d 生成客户端执行类的class文件的存放目录
              -s 生成客户端执行类的源文件的存放目录
              -p 定义生成类的包名


             http://blog.csdn.net/wooshn/article/details/8069087/

             http://www.cnblogs.com/yisheng163/p/4524808.html?utm_source=tuicool


一、Web Service简介

1.1、Web Service基本概念

Web Service也叫XML Web Service WebService是一种可以接收从Internet或者Intranet上的其它系统中传递过来的请求，轻量级的独立的通讯技术。是:通过SOAP在Web上提供的软件服务，使用WSDL文件进行说明，并通过UDDI进行注册。

XML：(Extensible Markup Language)扩展型可标记语言。面向短期的临时数据处理、面向万维网络，是Soap的基础。

Soap：(Simple Object Access Protocol)简单对象存取协议。是XML Web Service 的通信协议。当用户通过UDDI找到你的WSDL描述文档后，他通过可以SOAP调用你建立的Web服务中的一个或多个操作。SOAP是XML文档形式的调用方法的规范，它可以支持不同的底层接口，像HTTP(S)或者SMTP。

WSDL：(Web Services Description Language) WSDL 文件是一个 XML 文档，用于说明一组 SOAP 消息以及如何交换这些消息。大多数情况下由软件自动生成和使用。

UDDI (Universal Description, Discovery, and Integration) 是一个主要针对Web服务供应商和使用者的新项目。在用户能够调用Web服务之前，必须确定这个服务内包含哪些商务方法，找到被调用的接口定义，还要在服务端来编制软件，UDDI是一种根据描述文档来引导系统查找相应服务的机制
。UDDI利用SOAP消息机制（标准的XML/HTTP）来发布，编辑，浏览以及查找注册信息。它采用XML格式来封装各种不同类型的数据，并且发送到注册中心或者由注册中心来返回需要的数据。