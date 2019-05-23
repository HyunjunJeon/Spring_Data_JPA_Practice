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

