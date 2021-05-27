# 레스토랑 관리 시스템
## 스프링부트를 활용한 레스토랑 관리 시스템

# api 만들기

### 용어 정리
- **Lombok**
  - **@Getter, @Setter**
    - 변수의 get,set 메소드 자동생성 해준다.

  - **@Builder**
    - 생성자 메소드로 모델에 get set을 쉽게 도와준다.
    - 빌더 패턴을 생각하면 될 것 같다.
    - DTO.builder().id().name()...().build();
    
  - **@NoArgsConstructor**
    - 모델의 기본생성자를 생성 해준다.
  
  - **@AllArgsConstructor**
    - 모델의 선언된 모든 값이 인자로 들어오는 것을 허용하는 생성자를 생성해준다.
  
  - **@RequiredArgsConstructor**
    - final로 선언된 변수로만 만들어진 생성자를 만든다.
    - @Autowired 순환참조 방지를 위해 final로 의존성 주입에 사용
  
- **의존성 주입(Dependency Injection)**

    - 의존성 주입은 의존관계를 의미한다.  
      의존관계는 둘이상이 협력하는 것이다.  
      예를 들어 A,B 객체가 있다.
      A는 B에 의존한다는 것은 A는 B를 사용한다는 것을 의미한다.  
      B의 변화가 A의 영향을 끼치게 된다.

    - A는 B에 의존한다.  
      A가 B를 생성하는데 객체 생성하는 책임을 A가 갖게 된다.
    - 결합도가 낮고 유연성을 확보하기 위함
    - 여기서 주의해야 하는 것은 다른 Bean을 주입받으려면
      자기 자신이 반드시 컨테이너의 Bean이여야 한다는 것이다
  

- **Spring IOC 컨테이너가 하는 역할**
    - 스프링이 직접 관리하여 @Component 등록을 통해 new 생성자 없이 @Autowired로 호출할수 있다.

- **JPA Hibernate**
    - JPA에선 Hibernate라는 라이브러리가 있다. 모델에서 @Entity를 선언하여 사용한다.

- **@CrossOrigin**
    - 클라이언트에서 다른 호스트의 api를 호출할때 `CORS` 오류가 발생하는데 spring에서
      `@CrossOrigin` 어노테이션을 사용해 간단하게 처리해줄수 있다.

- **@Id, @GeneratedValue**
    - ID 인 변수 위에 선언해주고 id값이 자동생성되게 만들어준다.

- **@Transient**
    - 해당 데이터를 테이블의 컬럼과 매핑 시키지 않는다.

- **@JsonInclude(JsonInclude.Include.NON_NULL)**
    - 해당하는 json data가 null일 경우 출력되지 않는다.

- **@RestController**
    - rest api를 구성하는 controller에 선언해준다.

- **@PathVariable**
    - 경로에 path변수를 넣어준다. ex) restaurants/{id} <<-- 이 id가 PathVariable

- **@RequestBody**
    - HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할을 한다.

- **@ResponseBody**
    - 자바 객체를 HTTP 요청의 body 내용으로 매핑하는 역할을 한다.

- **@ResponseStatus(HttpStatus)**
    - HTTP 응답상태를 반환한다.

- **@ExceptionHandler(Exception.class)**
    - exception 발생시 error를 핸들해 준다.

- **@GetMapping("주소")**
    - 해당경로 url GET 요청을 받는다.

- **@PostMapping("주소")**
    - 해당경로 url POST 요청을 받는다.

- **@PatchMapping("주소")**
    - 해당경로 url POST 요청을 받는다.
  
- **@PutMapping("주소")**
  - 해당경로 url PUT 요청을 받는다.
  
- **@DeleteMapping("주소")**
  - 해당경로 url DELETE 요청을 받는다.
  
- **@AutoConfigureMockMvc**
  - autowired mockmvc 할때 사용 nullException 방지

- **@Mock**
    - mock객체를 선언 생성한다.
    - 가짜 객체

- **@BeforeEach**
    - test를 실행하기 이전에 가장 먼저 실행해주는 어노테이션이다.

- **@Test**
    - test 실행 어노테이션이다.

- ~~**@RunWith(SpringRunner.class)**~~
    - ~~controller test에서 사용된다.~~

- **@SpringBootTest**
    - 그런데 JUnit 5부터는 @RunWith가 아닌 Extension이라는 일관된 방법을 통해 테스트를
      실행하는 방법을 커스터 마이징 하는 것이다. 사용법은 @RunWith와 비슷하게 `@ExtendWith`라는 어노테이션을 사용해서 @ExtendWith(MyExtension.class)처럼  Extension 구현체를 지정해 줄 수 있는데
      @RunWith에 비해 몇가지 중요한 차이가 있다.
       - 메타 애노테이션을 지원한다. 
       - 여러번 중복 사용할 수 있다.
      
      이 중에서 메타 애노테이션으로 사용할 수 있다는 장점을 스프링 부트가 적극적으로 활용하면서
      @ExtendWith(SpringExtension.class)를 생략할 수 있게 됐다.


- **@WebMvcTest**
  - MVC를 위한 테스트.
  - 웹에서 테스트하기 힘든 컨트롤러를 테스트하는 데 적합.
  - 웹상에서 요청과 응답에 대해 테스트할 수 있음.
  - 시큐리티, 필터까지 자동으로 테스트하며, 수동으로 추가/삭제 가능.
  - @SpringBootTest 어노테이션보다 가볍게 테스트할 수 있음.
  - 다음과 같은 내용만 스캔하도록 제한함.
  - @Controller, @ControllerAdvice, @JsonComponent, @Converter, @GenericConverter, @Filter, @HandlerInterceptor

- **@Configuration**
    - Bean설정 파일임을 명시해줄때 사용
  
- **@MockBean**
    - 기존에 사용되던 스프링 Bean이 아닌 Mock Bean을 주입한다.
    - 어노테이션 내부에 문자열 값을 등록한 것은 기존에 선언된 Bean 객체를 덮어쓰기 위함이다.
    - 만약 Bean의 이름을 강제로 지정하지 않으면, Spring에선 어떤 Bean을 가져와야할지 알수 없어 오류가 발생한다.

<!--
- @EnableWebSecurity
    - 스프링시큐리티 적용 시 사용한다.
-->

<!--
### 프로젝트 구조
- application layer
    - service 관리

- domain layer
    - model과 repository 관리

- interfaces layer
    - controller 관리

- SecurityJavaConfig
    - 스프링 시큐리티 설정파일

- EmailExistedException
    - 이메일 기등록 파악 exception

- JSON Web Tokens
    - 적절한 토큰 생성 가능
    - Header
    - Payload(Claims) 정보를 담음
    - Signature 서명데이터 검증
    - Base64 URL Encoding
-->

### api 사용법

```java
Restaurant
http GET localhot:8080/restaurants
http GET localhot:8080/restaurants/{id}
        
MenuItem
http GET localhost:8080//restaurants/{restaurantId}/menuitems
http PATCH localhost:8080/restaurants/{restaurantId}/menuitems < menuitems.json
        
Review
http GET localhost:8080/reviews
```
<!--
위에 구현하면 넣어야 할 것들
Restaurant
http POST localhot:8080/restaurants name="" address="" categoryId=1
http PATCH localhot:8080/restaurants/{id} name="" address=""

MenuItem
http PATCH localhost:8080/restaurants/{restaurantId}/menuitems < menuitems2.json

Category
http GET localhost:8080/categories
http POST localhost:8080/categories name="korean food"

User 
http GET localhost:8080/users
http POST localhost:8080/users email=test@example.com name=test password="123"
http DELETE localhost:8080/users/{id}
http PATCH localhost:8080/users/{id} name="" email="" level=1

Region
http GET localhost:8080/regions
http POST localhost:8080/regions name=seoul

Review
http POST localhost:8080/restaurants/{restaurantId}/reviewsname="lsj" score="3" description="good"
http POST localhost:8080/restaurants/68/reviews score=3 description="좋아요" "Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb2huIn0.8hm6ZOJykSINHxL-rf0yV882fApL3hyQ9-WGlJUyo2A"

Session
http POST localhost:8080/session email="lsj8367@naver.com" password="test"

Reservation
http GET localhost:8080/reservations "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjE2MiwibmFtZSI6IuqwgOqyjOyjvOyduCIsInJlc3RhdXJhbnRJZCI6MX0.91Z5lu9uIy29urhgEKxmKh7laeuEFEkMo88AOOSuRns"
http POST localhost:8080/restaurants/1/reservations date="2020-12-24" time="23:00" partySize=4 "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjE2MSwibmFtZSI6InRlc3RlciJ9.n9A2wAduxEsiNP3Op5q5KcTzuiVts-GZcIKwq-3btn8"
-->
### h2 db 접속

```
http://localhost:8080/h2-console/
```

<!--
### JWT

```
https://jwt.io/
```
-->

[comment]: <> (### TODO)

[comment]: <> (- 현재 backend에서 menuitems.json파일을 사용하여 crud만 했는데  )

[comment]: <> (  front에서 json형식의 데이터를 주고받을수 있게 CRUD 처리하기)

[comment]: <> (- 각 api마다 추가로 필요한 정보가 있다면 넣어주기)

[comment]: <> (- junit으로 토큰값 생성 및 테스트)
