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
