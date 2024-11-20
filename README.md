## 프로젝트 설정:
- Project: Maven Project
- Language: Java
- Spring Boot

## Dependencies:
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Thymeleaf (뷰 템플릿 엔진)

src
└── main
├── java
│ └── com.example.mvc_pattern_practice
│ ├── controller <-- 요청을 처리하는 컨트롤러
│ ├── service <-- 비즈니스 로직
│ ├── repository <-- 데이터베이스와의 상호작용
│ ├── model <-- 데이터베이스 엔티티 (Dept, Emp 등)
│ └── MvcPatternPracticeApplication.java <-- 메인 애플리케이션 실행 파일
└── resources
├── static <-- 정적 파일 (CSS, JS 등)
├── templates <-- HTML 템플릿 (Thymeleaf 등)
└── application.yml <-- 설정 파일

Spring MVC의 역활을 위해



1. Service Bean 등록 (@Servcie)
- 서비스 계층의 클래스를 Spring Bean으로 등록하여 Spring 컨테이너가 관리하도록 합니다.
- 주로 비즈니스 로직을 처리하는 클래스에 사용됩니다.

2. Service Bean 등록 (@Controller)
- MVC 패턴에서 컨트롤러 역할을 하는 클래스를 정의합니다.
- 사용자 요청을 처리하고, 적절한 응답을 반환하는 역할을 합니다.

3. 의존성 주입 (Autowired)
@Autowired: Spring이 자동으로 객체를 주입하는 어노테이션입니다. 주로 @Service나 @Controller와 같은 다른 Bean을 의존성으로 주입받을 때 사용됩니다.
