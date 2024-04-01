투두리스트 만들기

# 사용한 어노테이션
|어노테이션|설명|
|---------|-----|
|@Builder|빌더 패턴을 사용할 수 있게 해준다. 빌더 패턴을 사용하면 생성자 코드를 줄일 수 있고, 데이터의 순서 상관 없이 객체에 값을 지정할 수 있다.|
|@Getter|getter을 추가해준다.|
|@Setter|setter을 추가해준다.|
|@NoArgsConstructor|파라미터가 없는 기본 생성자를 추가해준다.|
|@AllArgsConstructor|모든 파라미터를 받는 생성자를 추가해준다.|
|@Entity|테이블과 매핑을 시키는 어노테이션으로 @Entity를 붙이면 JPA가 관리한다.|
|@Table(name="")|name에 쓴 이름과 동일한 이름을 가지는 테이블과 매핑함. 생략시 객체의 이름을 사용|
|@Id|기본키로 설정|
|@GeneratedValue(strategy = GenerationType.IDENTITY)|기본키 설정을 데이터베이스에게 전담하게 되므로 기본키의 값을 직접 설정하지 않아도 된다. @GeneratedValue만 붙일 시 @GeneratedValue(strategy = GenerationType.AUTO)가 기본값으로 각 데이터 베이스에 따라 기본키를 자동으로 설정해준다.|
|@Controller|@Component 어노테이션과 같은 역할이지만, 보다 구체적으로 명시해주는 역할을 한다. MVC에서 컨트롤러 부분에 해당하는 class에 넣는 어노테이션으로 자동으로 스프링 빈을 등록해준다. @RequestMapping에 있는 메소드들을 확인하여 요청을 처리하도록 해준다.|
|@Service|마찬가지로 @Component와 동일하게 자동으로 스프링 빈을 등록해준다. 비지니스 로직을 구현하는 class에 넣는 어노테이션으로 저장소 계층을 사용한다.|
|@Repository|마찬가지로 자동으로 스프링 빈을 등록해준다. 데이터 베이스 관련 class에 넣는 어노테이션이다. 특정 예외를 잡아, 스프링의 unchecked 예외로 다시 던진다.|
|@RequestMapping|url로 보낸 요청을 받아낸다.|
|@GetMapping|get 형식으로 보내진 url 요청을 받아낸다.|
|@PostMapping|post 형식으로 보내진 url 요청을 받아낸다.|
|@RequestParam|http://localhost:8080/hello?name="user"과 같은 식으로 넘어오는 파라미터를 받을 때 사용한다.|
|@PathVariable|http://localhost:8080/hello/1과 같은 식으로 넘어오는 파라미터를 받을 때 사용한다.|
|@Slf4j|log관련 함수들을 추가해주는 어노테이션이다.|


## Login 패키지
 ### Board
  id를 기본키로 지정해주고, 아이디를 저장할 userId와 비밀번호를 저장할 userPw를 만든다.
  
 ### BoardRepository
  JpaRepository를 상속받는 repository로 데이터베이스에서 해당 되는 userId가 있는 행을 반환하는 findByUserId를 만들었다.
  
 ### LoginDto
  Dto란, 프로세스 간에 데이터를 전달하는 객체를 말한다.
  데이터 베이스에 id와 userId, userPw가 있으므로, 이 데이터들을 전달해야하므로
  LoginDto도 마찬가지로 id, userId, userPw 멤버 변수를 선언함.
  
 ### LoginController
  1. localhost:8080 url을 전송하면 index.html이 아닌 로그인 페이지로 강제로 넘겨준다.
  2. localhost:8080/sign-up-page url을 전송하면 회원가입 페이지로 넘어간다.
  3. localhost:8080/sign-up-page/sigh-up url을 전송하면 html form에서 입력한 값들을 전달받아, 데이터 베이스에 값을 추가한다.
  4. localhost:8080/login-check url을 전송하면 html form에서 입력한 값들을 전달받아, 데이터 베이스에 있는 값들과 비교하고 맞다면, 투두리스트 페이지로 넘어가고, 아니라면 다시 기본 페이지로 보낸다.

 ### LoginService
  회원가입하는 메소드와 로그인하는 메소드가 존재한다.

## Todo 패키지
 ### ContentBoard
  todoTable과 ManyToOne 관계이므로,
  기본키인 id와 할 일을 담은 content, 할 일 여부를 담은 done, todoTable의 기본키를 담을 외래키인 todo를 만든다.
 
 ### ContentDto
  ContentBoard의 값들을 객체간 전송시키기 위해 똑같이 담는 Dto를 만듦
 
 ### ContentRepository
  JPA와 연결했다.
  
 ### TodoBoard
  contentBoard와 OneToMany 관계이므로,
  기본키인 id와 유저의 아이디를 담은 userId, 할 일을 담을 리스트인 contentBoardList를 만든다.
 
 ### TodoBoardRepository
  JPA와 연결한 후, 데이터 베이스에서 해당 되는 userId가 있는 행을 반환하는 findByUserId를 만든다. 
 
 ### TodoController
  
 
 ### TodoService
 
 ### TodoDto

## 데이터베이스 관계
1. todo와 content와의 관계는 양방향 관계로
  todo에는 userId를
  content에는 content와 done을 넣음
  따라서 todo는 OneToMany를
  content는 ManyToOne 관계를 가진다.

**Spring security를 이용해 회원가입, 로그인 로직을 보완하자.**
