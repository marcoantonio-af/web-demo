# Spring Boot Actuator 监控
### 一：简介
在Spring Boot的众多Starter POMs中有一个特殊的模块，它不同于其他模块那样大多用于开发业务功能或是连接一些其他外部资源。它完全是一个用于**暴露自身信息的模块**，所以很明显，它的主要作用是用于**监控与管理**，它就是：**spring-boot-starter-actuator**。

spring-boot-starter-actuator模块的实现对于实施微服务的中小团队来说，可以有效地减少监控系统在采集应用指标时的开发量。当然，它也并不是万能的，有时候我们也需要对其做一些简单的扩展来帮助我们实现自身系统个性化的监控需求。
微服务的特点决定了功能模块的部署是分布式的，大部分功能模块都是运行在不同的机器上，彼此通过服务调用进行交互，前后台的业务流会经过很多个微服务的处理和传递，出现了异常如何快速定位是哪个环节出现了问题？
在这种框架下，微服务的监控显得尤为重要，只需要引入spring-boot-starter-actuator即可。

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

引入依赖启动应用，会看到控制台打印出三个关于actuator的映射，所有 endpoints 默认情况下都已移至 /actuator下
​
访问http://localhost:8080/actuator可以看到rest风格的接口 

    {
        "_links": {
            "self": {
                "href": "http://localhost:8084/actuator",
                "templated": false
            },
            "health-component-instance": {
                "href": "http://localhost:8084/actuator/health/{component}/{instance}",
                "templated": true
            },
            "health-component": {
                "href": "http://localhost:8084/actuator/health/{component}",
                "templated": true
            },
            "health": {
                "href": "http://localhost:8084/actuator/health",
                "templated": false
            },
            "info": {
                "href": "http://localhost:8084/actuator/info",
                "templated": false
            }
        }
    }
​
- 注意：在Spring Boot 2.0 中对Actuator变动很大，默认只提供这三个接口，如果想提供所有接口需要配置application.yml，配置之后重新访问/actuator就会暴露出所有接口
    
    
    management:
      endpoints:
        web:
          exposure:
            include: "*"
    {
        "_links": {
            "self": {
                "href": "http://localhost:8080/actuator",
                "templated": false
            },
            "auditevents": {
                "href": "http://localhost:8080/actuator/auditevents",
                "templated": false
            },
            "beans": {
                "href": "http://localhost:8080/actuator/beans",
                "templated": false
            },
            "health": {
                "href": "http://localhost:8080/actuator/health",
                "templated": false
            },
            "conditions": {
                "href": "http://localhost:8080/actuator/conditions",
                "templated": false
            },
            "configprops": {
                "href": "http://localhost:8080/actuator/configprops",
                "templated": false
            },
            "env": {
                "href": "http://localhost:8080/actuator/env",
                "templated": false
            },
            "env-toMatch": {
                "href": "http://localhost:8080/actuator/env/{toMatch}",
                "templated": true
            },
            "info": {
                "href": "http://localhost:8080/actuator/info",
                "templated": false
            },
            "loggers": {
                "href": "http://localhost:8080/actuator/loggers",
                "templated": false
            },
            "loggers-name": {
                "href": "http://localhost:8080/actuator/loggers/{name}",
                "templated": true
            },
            "heapdump": {
                "href": "http://localhost:8080/actuator/heapdump",
                "templated": false
            },
            "threaddump": {
                "href": "http://localhost:8080/actuator/threaddump",
                "templated": false
            },
            "metrics-requiredMetricName": {
                "href": "http://localhost:8080/actuator/metrics/{requiredMetricName}",
                "templated": true
            },
            "metrics": {
                "href": "http://localhost:8080/actuator/metrics",
                "templated": false
            },
            "scheduledtasks": {
                "href": "http://localhost:8080/actuator/scheduledtasks",
                "templated": false
            },
            "httptrace": {
                "href": "http://localhost:8080/actuator/httptrace",
                "templated": false
            },
            "mappings": {
                "href": "http://localhost:8080/actuator/mappings",
                "templated": false
            }
        }
    }

### 二. application.properties
- management.endpoints.web.exposure.include=**，默认只公开了/health和/info端点，要想暴露所有端点只需设置成星号即可
- management.endpoint.shutdown.enabled=true，显式启用/shutdown端点
- management.endpoints.web.exposure.exclude=env, 要公开所有（已启用）网络端点除env端点之外
- management.server.servlet.context-path: 设置管理服务的上下文路径，默认值为 “”
- management.server.port：设置管理服务的端口
- management.endpoints.web.base-path：设置管理端点的基本路径，默认值为：actuator，如果想还和1.5版本的路径一样直接访问http://localhost:8088/health， 只需要配置management.endpoints.web.base-path=/ 即可，也不需要配置management.server.servlet.context-path了

配置很多，具体可以参考spring-boot-actuator-autoconfigure.jar中的spring-configuration-metadata.json文件
如果设置成以下配置，访问端点的路径就变成了http://localhost:8088/management/monitor
    
    management:
      server:
        servlet:
          context-path: "/management"
        port: 8088
      endpoints:
        web:
          exposure:
            include: "*"
          base-path: "/monitor"
      endpoint:
        shutdown:
          enabled: true
          
    info:
      app:
        name: "@project.artifactId@"
        encoding: '@project.build.sourceEncoding@'
        java:
          source: '@java.version@'
          target: '@java.version@'

/actuator 在 management.endpoints.web.base-path 的根目录中有一个映射，它提供了到所有暴露端点的链接。
### 三：端点
根据端点的作用来说，我们可以原生端点分为三大类：
- 应用配置类：获取应用程序中加载的应用配置、环境变量、自动化配置报告等与Spring Boot应用密切相关的配置类信息。
- 度量指标类：获取应用程序运行过程中用于监控的度量指标，比如：内存信息、线程池信息、HTTP请求统计等。
- 操作控制类：提供了对应用的关闭等操作类功能。
#### 1. 应用配置类
由于Spring Boot为了改善传统Spring应用繁杂的配置内容，采用了包扫描和自动化配置的机制来加载原本集中于xml文件中的各项内容。虽然这样的做法，让我们的代码变得非常简洁，但是整个应用的实例创建和依赖关系等信息都被离散到了各个配置类的注解上，这使得我们分析整个应用中资源和实例的各种关系变得非常的困难。而这类端点就可以帮助我们轻松的获取一系列关于Spring 应用配置内容的详细报告，比如：自动化配置的报告、Bean创建的报告、环境属性的报告等。
/conditions：该端点在1.x版本中叫autoconfig，该端点用来获取应用的自动化配置报告，其中包括所有自动化配置的候选项。同时还列出了每个候选项自动化配置的各个先决条件是否满足。所以，该端点可以帮助我们方便的找到一些自动化配置为什么没有生效的具体原因。该报告内容将自动化配置内容分为三部分：
positiveMatches中返回的是条件匹配成功的自动化配置
negativeMatches中返回的是条件匹配不成功的自动化配置
  
    
    {
        "positiveMatches": { // 条件匹配成功的
            "EndpointWebMvcAutoConfiguration": [
                {
                    "condition": "OnClassCondition",
                    "message": "@ConditionalOnClass classes found: javax.servlet.Servlet,org.springframework.web.servlet.DispatcherServlet"
                },
                {
                    "condition": "OnWebApplicationCondition",
                    "message": "found web application StandardServletEnvironment"
                }
            ],
            ...
        },
        "negativeMatches": {  // 条件不匹配成功的
            "HealthIndicatorAutoConfiguration.DataSourcesHealthIndicatorConfiguration": [
                {
                    "condition": "OnClassCondition",
                    "message": "required @ConditionalOnClass classes not found: org.springframework.jdbc.core.JdbcTemplate"
                }
            ],
            ...
        }
    }

从如上示例中我们可以看到，每个自动化配置候选项中都有一系列的条件，比如上面没有成功匹配的HealthIndicatorAutoConfiguration.DataSourcesHealthIndicatorConfiguration配置，它的先决条件就是需要在工程中包含org.springframework.jdbc.core.JdbcTemplate类，由于我们没有引入相关的依赖，它就不会执行自动化配置内容。所以，当我们发现有一些期望的配置没有生效时，就可以通过该端点来查看没有生效的具体原因。
/beans：该端点用来获取应用上下文中创建的所有Bean 

如上示例中，我们可以看到在每个bean中都包含了下面这几个信息：
外层的key是Bean的名称 

scope：Bean的作用域 

type：Bean的Java类型 

reource：class文件的具体路径 

dependencies：依赖的Bean名称

/configprops：该端点用来获取应用中配置的属性信息报告，prefix属性代表了属性的配置前缀，properties代表了各个属性的名称和值，例如我们可以设置spring.http.encoding.charset=”UTF-8” 
​
/env：该端点与/configprops不同，它用来获取应用所有可用的环境属性报告。包括：环境变量、JVM属性、应用的配置配置、命令行中的参数。从下面该端点返回的示例片段中，我们可以看到它不仅返回了应用的配置属性，还返回了系统属性、环境变量等丰富的配置信息，其中也包括了应用还没有没有使用的配置。所以它可以帮助我们方便地看到当前应用可以加载的配置信息，并配合@ConfigurationProperties注解将它们引入到我们的应用程序中来进行使用。另外，为了配置属性的安全，对于一些类似密码等敏感信息，该端点都会进行隐私保护，但是我们需要让属性名中包含：password、secret、key这些关键词，这样该端点在返回它们的时候会使用*来替代实际的属性值。
​
/mappings：该端点用来返回所有Spring MVC的控制器映射关系报告。

/info：该端点用来返回一些应用自定义的信息。默认情况下，该端点只会返回一个空的json内容。我们可以在application.properties配置文件中通过info前缀来设置一些属性
#### 2. 操作控制类
作控制类端点拥有更强大的控制能力，如果要使用它们的话，需要通过属性来配置开启。 
在原生端点中，只提供了一个用来关闭应用的端点：/shutdown。我们可以通过如下配置开启它：management.endpoint.shutdown.enabled=true, 在配置了上述属性之后，只需要访问该应用的/shutdown端点就能实现关闭该应用的远程操作。由于开放关闭应用的操作本身是一件非常危险的事，所以真正在线上使用的时候，我们需要对其加入一定的保护机制，比如：定制Actuator的端点路径、整合Spring Security进行安全校验等。
#### 3. 度量指标类
上面我们所介绍的应用配置类端点所提供的信息报告在应用启动的时候都已经基本确定了其返回内容，可以说是一个静态报告。而度量指标类端点提供的报告内容则是动态变化的，这些端点提供了应用程序在运行过程中的一些快照信息，比如：内存使用情况、HTTP请求统计、外部资源指标等。这些端点对于我们构建微服务架构中的监控系统非常有帮助，由于Spring Boot应用自身实现了这些端点，所以我们可以很方便地利用它们来收集我们想要的信息，以制定出各种自动化策略。下面，我们就来分别看看这些强大的端点功能。

- /metrics：该端点用来返回当前应用的各类重要度量指标，比如：内存信息、线程信息、垃圾回收信息等。可以通过actuator/metrics/{name} 来获取详细信息，例如：/actuator/metrics/jvm.buffer.memory.used
  
    
    {
        "names": [
            "jvm.buffer.memory.used",
            "jvm.memory.used",
            "jvm.gc.memory.allocated",
            "jvm.memory.committed",
            "tomcat.sessions.created",
            "tomcat.sessions.expired",
            "tomcat.global.request.max",
            "tomcat.global.error",
            "jvm.gc.max.data.size",
            "logback.events",
            "system.cpu.count",
            "jvm.memory.max",
            "jvm.buffer.total.capacity",
            "jvm.buffer.count",
            "process.files.max",
            "jvm.threads.daemon",
            "process.start.time",
            "tomcat.global.sent",
            "tomcat.sessions.active.max",
            "tomcat.threads.config.max",
            "jvm.gc.live.data.size",
            "process.files.open",
            "process.cpu.usage",
            "tomcat.servlet.request",
            "jvm.gc.pause",
            "process.uptime",
            "tomcat.global.received",
            "system.load.average.1m",
            "tomcat.cache.hit",
            "tomcat.servlet.error",
            "tomcat.servlet.request.max",
            "tomcat.cache.access",
            "tomcat.threads.busy",
            "tomcat.sessions.active.current",
            "system.cpu.usage",
            "jvm.threads.live",
            "jvm.classes.loaded",
            "jvm.classes.unloaded",
            "jvm.threads.peak",
            "tomcat.threads.current",
            "tomcat.global.request",
            "jvm.gc.memory.promoted",
            "tomcat.sessions.rejected",
            "tomcat.sessions.alive.max"
        ]
    }

- /health：该端点在一开始的示例中我们已经使用过了，它用来获取应用的各类健康指标信息。在spring-boot-starter-actuator模块中自带实现了一些常用资源的健康指标检测器。这些检测器都通过HealthIndicator接口实现，并且会根据依赖关系的引入实现自动化装配，比如用于检测磁盘的DiskSpaceHealthIndicator、检测DataSource连接是否可用的DataSourceHealthIndicator等
- /httptrace: 该端点用来返回基本的HTTP跟踪信息。默认情况下，跟踪信息的存储采用org.springframework.boot.actuate.trace.InMemoryTraceRepository实现的内存方式，始终保留最近的100条请求记录

路径参考：

​![](imgs/acturtor.png)