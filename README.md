# spring-boot
整理全部有關 Spring boot 的技術


## 切換環境設定
- 可以在 spring boot App -> spring boot -> profiles 進行設定
- 可以在 spring boot App -> Enviroment -> 新增 spring.profiles.active:sit
- https://blog.csdn.net/qq_42982923/article/details/119242216


## 啟動圖片
- 圖片來源：https://www.bootschool.net/ascii-art
- 切換環境：https://www.baeldung.com/spring-boot-disable-banner


## spring boot 排程
- Spring Boot Scheduling Tasks
- 需要加 @EnableScheduling
- https://polinwei.com/spring-boot-scheduling-tasks/


## filter 
- 使用 @Configuration、＠Component
  - 預設為全部 api 皆會通過此 filter
- 使用 @WebFilter
  - 指定特定 req 才會通過此 filter
  - 需要再新增 @ServletComponentScan 在 application.java 檔


## 使用 filter 紀錄 request 參數
- 繼承 OncePerRequestFilter，並改寫 doFilterInternal
  - 從 HttpServletRequest 取得 httpMethod、uri、params 等參數
- `取得 request 參數`
  - 由於 inputstream 只可以读取一次，需進行調整
  - 繼承 HttpServletRequestWrapper，改寫 getInputStream，使用新的 ServletInputStream 裝資料 (準備進行改寫)
  - 添加 commons-io dependency，使用 IOUtils.toByteArray 的方法
- https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-filter-request-and-response.html
- https://easyboot.xyz/posts/52559/
- https://juejin.cn/post/7024038764804735012


## 使用 filter 紀錄 response 參數
- 需要執行下列程式，否則會陷入 doFilter 的 loop 
  ```
	ServletOutputStream outputStream = response.getOutputStream();
	outputStream.write(resbody.getBytes());
	outputStream.flush();
	outputStream.close();
  ```
- https://blog.51cto.com/u_15585381/5277668
  
## HandlerInterceptor (攔截器)
- 實作 HandlerInterceptor，決定攔截器功能，並註冊為 component
- 實作 WebMvcConfigurer，註冊攔截器與攔截路徑，並註冊為 component
- https://ithelp.ithome.com.tw/articles/10278220


## ApplicationContextAware (取得 spring bean)
- 實作 ApplicationContextAware
- 待撰寫範例
- https://iter01.com/535392.html


## Spring Actuator
- 可以用來查看當前的 SpringBoot 程式運行的內部狀況，譬如知道自動化配置的資訊、創建的 Spring beans 和獲取當前的 properties 屬性值
  - 開啟所有endpoints(不包含shutdown)
    - management.endpoints.web.exposure.include=*
  - 開啟/actuator/beans和/actuator/mappings
    - management.endpoints.web.exposure.include=beans,mappings
 - 輸入 ./actuator/beans
 - https://kucw.github.io/blog/2020/7/spring-actuator/
 
 
## AnnotationBeanNameGenerator (註冊 spring bean 名稱)
- 進行改寫 spring bean 名稱
- 繼承 AnnotationBeanNameGenerator 並改寫 buildDefaultBeanName
- 在啟動程式 (xxxApplication.class)，@ComponentScan 需添加 nameGenerator 的參數


## 讀取 application.yml 檔內容
- https://www.baeldung.com/spring-boot-yaml-list
- https://www.baeldung.com/spring-value-annotation


## 啟動時，自動執行 sql 
- https://ithelp.ithome.com.tw/articles/10297778


## jwt 範例
- 參考 sample code
- https://ithelp.ithome.com.tw/articles/10250968


## session 應用
- 將資訊儲放 session 中
- 從 HttpServletRequest 取出 session 
- 內部可以擺放物件
- 登入時，存入 session ，登出時，清除 session 


## 上傳圖片與開啟圖片
- https://waynestalk.com/spring-boot-restful-download-image/
- https://shinyu0430.github.io/2022/05/06/springUploadImage/
- https://www.baeldung.com/java-base64-image-string


## 建立 h2 db 可用 dbeaver 連線
- h2 dependency 不需要使用 runtime
- 新增一個 bean
  ```
   /**
     * Start internal H2 server so we can query the DB from IDE
     *
     * @return H2 Server instance
     * @throws SQLException
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }
  ```
- application.yml 設定
  ```
  spring:
  h2:
    console:
      enabled: true
      path: '/h2-console-log'

  datasource:
    url: 'jdbc:h2:mem:local'
  ```  
- dbeaver 使用 h2 server 連線
  - Host
  - jdbc:h2:tcp://localhost:9090/mem:local  
  
- https://stackoverflow.com/questions/43256295/how-to-access-in-memory-h2-database-of-one-spring-boot-application-from-another/43276769#43276769


## swagger 設定
- controller 
  - class 標註 @Tag
  - method 標註 @Operation 
  
  
  