# Spring Data Common

## Spring Data Project
- Spring Data: SQL & NoSQL 저장소 지원 프로젝트 묶음
- Spring Data Common: 여러 저장소 지원 프로젝트의 공통 기능
- Spring Data REST: 저장소 데이터를 REST API로 제공
- Spring Data JPA: Common + JPA 기능 추가

### Repository
Spring Data Common:
Repository -> CrudRepository -> PagingAndSortingRepository

Spring Data JPA: 
=> JpaRepository

### Repository Interface 정의하기
Repository 인터페이스로 공개할 메서드를 직접 정의하고 싶다면

- 특정 레포지토리 @RepositoryDefinition
- 공통 레포지토리 인터페이스 @NoRepositoryBean

### Null 처리
1. Spring Data 2.0 이후로 Java8 의 Optional 지원
-> Null을 리턴하지 않고 비어있는 Optional을 리턴함(isEmpty())

    또한 리턴값이 컬렉션일 경우, Null을 리턴하지 않고 비어있는 컬렉션을 리턴함

2. Spring Framework 5.0 이후로 Null 관련 어노테이션 지원
    
    @NonNullApi
    @NonNull
    @Nullable
    
## 쿼리 만들기
1. 메서드 이름을 분석해서 쿼리 만들기( @EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE) )
2. 미리 정의해둔 쿼리를 찾아서 사용하기( @EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.USE_DECLARED_QUERY) )
3. default: 미리 정의한 쿼리를 찾아보고 없다면 만들기( @EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND) )

쿼리 만드는법(메서드)
Return_Type {접두어}{도입부}By{프로퍼티 표현식}{조건식}[And|Or{프로퍼티 표현식}(조건식)]{정렬 조건} (매개변수)

접두어: find, get, query, count, ...
도입부: Distinct, First, Top, ...
프로퍼티 표현식: Person.Address.ZipCode -> find(Person)ByAddress_ZipCode
조건식: IgnoreCase, Between, LessThan, GreaterThan, Like, Contains, ...
정렬 조건: OrderBy{프로퍼티}[Asc|Desc]
리턴 타입: E, Optional<E>, List<E>, Page<E>, Slice<E>, Stream<E>
매개변수: Pageable, Sort, Primitive Type, ...  

## 커스텀 레포지토리
쿼리 메소드로 해결되지 않는 경우 직접 코딩으로 구현이 가능
- 스프링 데이터 레포지토리 인터페이스에 기능 추가
- 스프링 데이터 레포지토리 기본 기능 덮어쓰기
    a. 커스텀 레포지토리 인터페이스 정의
    b. 인터페이스 구현 클래스 만들기(기본 접미어: Impl)
    c. Entity 레포지토리에 커스텀 레포지토리 인터페이스 추가
    
    
## 기본 레포지토리 커스터마이징
모든 레포지토리에 공통적으로 추가하고 싶은 기능이 있거나 덮어쓰고 싶은 기본 기능이 있다면?
1. JpaRepository를 상속받는 인터페이스 정의(@NoRepositoryBean)
2. 기본 구현체를 상속 받는 커스텀 구현체 만들기
3. @EnableJpaRepositories에 설정하기(repositoryBaseClass)



