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
 - 在 log 輸出部分，有紀錄
   ```
   Exposing 13 endpoint(s) beneath base path '/actuator'
   ```
- 在 /actuator 裏面，常見的功能有：
  - beans：查詢全部被註冊 bean 的名稱
  - envs：查詢全部的環境變數 (包含自定義)
  - mappings：查看全部的 endpoint
  - scheduledtasks：	查看目前排程狀態
 
 
## AnnotationBeanNameGenerator (註冊 spring bean 名稱)
- 進行改寫 spring bean 名稱
- 繼承 AnnotationBeanNameGenerator 並改寫 buildDefaultBeanName
- 在啟動程式 (xxxApplication.class)，@ComponentScan 需添加 nameGenerator 的參數


## 讀取 application.yml 檔內容
- https://www.baeldung.com/spring-boot-yaml-list
- https://www.baeldung.com/spring-value-annotation
- 預設參數清單 https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html
- yaml 轉換成 properties https://mageddo.com/tools/yaml-converter


## 啟動時，自動執行 sql 
- https://ithelp.ithome.com.tw/articles/10297778


## jwt 範例
- 參考 sample code
- https://ithelp.ithome.com.tw/articles/10250968
- 參數放在 header 進行傳送
- 在 controller 使用 @RequestHeader("Authorization") 可以取出
- 可以使用 postman Authorization ，並選擇 Bearer Token，傳輸時，會在前面加上 Bearer jwt....
  - 需要再把 Bearer 拿掉，可用字串方式拆解 authorization.substring(6)
- 在 HandlerInterceptor 中的 HttpServletRequest 型別時，可以直接使用 .getHeader("Authorization") 取出
  ```
  public class LoginCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception{
	
		HandlerMethod hm = (HandlerMethod) handler;
		
		String header = request.getHeader("Authorization");
		
		String token = header.substring(6);
		
		// .....
	}
  }	
  ```
- https://www.svlada.com/jwt-token-authentication-with-spring-boot/
- https://github.com/bezkoder/spring-boot-refresh-token-jwt
- https://chikuwa-tech-study.blogspot.com/2021/06/spring-boot-username-password-authentication-and-jwt.html  
- 解開 jwt 方法
  - 前端回傳時，通常會帶有前綴字：`bearer `
  - 在解開時，需要從第七個字開始取 jwt.subString(7)
  - https://blog.csdn.net/qq_42411805/article/details/124676309
- https://ithelp.ithome.com.tw/articles/10256445
- https://www.1ju.org/article/openapi-jwt-authentication


## session 應用
- 將資訊儲放 session 中
- 從 HttpServletRequest 取出 session 
- 內部可以擺放物件
- 登入時，存入 session ，登出時，清除 session 


## 上傳圖片與開啟圖片
- https://waynestalk.com/spring-boot-restful-download-image/
- https://shinyu0430.github.io/2022/05/06/springUploadImage/
- https://www.baeldung.com/java-base64-image-string
- string to img online https://codebeautify.org/base64-to-image-converter
- 新增回傳 gz 壓縮欓範例
  - 參考 sample code
  1. 使用 GZIPOutputStream 將檔案進行壓縮
  2. 重新設定 header，並設定下載檔案名稱
  3. 使用 postman 回傳時，雖然為亂碼，但回傳框的左上角，有 save as file ，則可以將檔案進行下載
  4. 比較檔案大小 (待比較)
- 新增使用 postman 上傳檔案方式
  - body 切換至 form-data
  - 針對變數設置 key value
  - key 後端可以切換為 file，將變數型別為 MultipartFile 選擇為 file，並上傳檔案  


## 建立 h2 db 可用 dbeaver 連線
- h2 dependency 不需要使用 runtime
- 新增一個 bean port 不可以和 spring 啟動的 port 一樣
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
  - 組合資訊：bean 的 port + url h2 後面那一段
  - Host
  - jdbc:h2:tcp://localhost:9090/mem:local  
  
- https://stackoverflow.com/questions/43256295/how-to-access-in-memory-h2-database-of-one-spring-boot-application-from-another/43276769#43276769


## swagger 設定
- controller 
  - class 標註 @Tag
  - method 標註 @Operation 
- 攔截器會影響到 swagger 需要額外設定 application.yml
- https://stackoverflow.com/questions/67162911/petstore-url-swagger-default-app-not-disabled-in-springdoc  
  
  
## db table 設定
- spring.jpa.hibernate.ddl-auto
  - create: 啟動時建立Table, 下次啟動會覆蓋上次的, 故會造成資料遺失  
  - update: 若無Table則啟動時建立, 若有則視有無變更自動Update
  - create-drop: 啟動時建立Table, 當次Session關閉則刪除  (hsqldb, h2 的 default)
  - validate: 只驗證，不修改表格
  - none: 蛤也不做 (大部分的 default)
- https://fookwood.com/hibernate-generate-ddl
- https://www.eolink.com/news/post/14975.html
  

## HikariCP 設定
- `minimumIdle` 是 HikariCP 在连接池中维护的最小空闲连接数
- `maximumPoolSize` 配置最大池大小
- `idleTimeout` 是允许连接在连接池中空闲的最长时间
- `maxLifetime` 是池中连接关闭后的最长生命周期（以毫秒为单位)
- `connectionTimeout` 是客户端等待连接池连接的最大毫秒数
- https://www.cnblogs.com/chaojizhengui/p/Hikari_.html


## JPA
- GeneratedValue
  - 默認：全部 table 依序往下累積數量
  - GenerationType.IDENTITY : 每個 table 從 ` 1 ` 開始 
  - GenerationType.AUTO : 由 hibernate 自動產生, 此種方法會跨 table 共用
- jndi 與 jdbc 差異：https://cloud.tencent.com/developer/article/1455718
- jpa 依據使用的設定，決定使用哪種連線方式
  - jndi: 需要再把連線資訊寫在容器中
    ```
    spring.datasource.jndi-name=java:comp/env/jdbc/mydatabase
    ```
  - jdbc: 帳號密碼寫在設定檔中
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
	spring.datasource.username=myuser
	spring.datasource.password=mypassword
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```   


## oneToMany
- https://stackoverflow.com/questions/27672337/detached-entity-passed-to-persist-when-save-the-child-data
- https://www.geeksforgeeks.org/how-to-implement-one-to-many-mapping-in-spring-boot/


## Bean Type
- singleton (default)
  - 預設的bean scope，整個IoC容器中只會有一個實例，又稱單例
- prototype
  - 每次被調用（注入）時都是產生新的實例。
  - 若bean有狀態(stateful)，使用 prototype bean。
  - 注意若注入的對象為 singleton bean 的成員，則該 prototype 僅在 singleton 對象初始時實例化一次，也就是說每次 singleton bean 被調用時使用的 prototype bean 都是同一個。
- request
  - Web 環境才有的 scope。
  - 實例的 scope 為 HTTP Request，同個 request 的實例為同一個，也就是不同 request 的實例是不同的
- session
  - Web 環境才有的 scope。
  - 實例的 scope 為 HTTP Session，同個 sessio n的實例為同一個，也就是不同 session 的實例是不同的。
- application
  - Web 環境才有的 scope。
  - 實例的 scope 為 ServletContext，同個 ServletContext 的實例為同一個，也就是不同 ServletContext 的實例是不同的。
- websocket
  - Web 環境才有的 scope。
  - 實例的 scope 為 WebSocket，同個 WebSocket 的實例為同一個，也就是不同 WebSocket 的實例是不同的。
- [參考](https://matthung0807.blogspot.com/2020/06/spring-bean-bean-scope.html)
- [sample code](https://www.baeldung.com/spring-bean-scopes)