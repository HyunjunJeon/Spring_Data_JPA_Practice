# Spring Data JPA

## Entity Mapping
### Annotation 
1. Entity
   - '객체'쪽에서 부르는 이름
   - 클래스와 같은 이름을 사용하기 때문에 값을 변경하지는 않으나 name 속성을 변경이 가능함
   - 엔티티의 이름은 JQL에서 쓰임
2. Table
    - '릴레이션'쪽에서 부르는 이름
    - @Entity의 이름이 기본값
    - 테이블의 이름은 SQL에서 쓰임
3. Id
    - Entity의 PK를 매핑할 때 사용
    - 자바의 모든 primitive 타입과 그 Wrapper 타입을 사용 가능
        - Date, BigDecimal, BigInteger도 가능함...
    - 복합키를 만들어 매핑하는 방법도 있음
4. GeneratedValue
    - PK의 생성 방법을 매핑할 때 사용
    - 생성 전략과 생성기를 설정할 수 있음
        - AUTO: 사용하는 DB에 따라 적절한 전략을 선택하도록 위임
        - TABLE, SEQUENCE, IDENTITY
5. Column
    - unique
    - nullable
    - length
    - columnDefinition
    - ....
6. Temporal
    - JPA 2.1까지는 Date, Calendar 만 지원하는 중
    - 시간, 날짜 , 시간+날짜(TIMESTAMP)
7. Transient
    - 컬럼으로 매핑하고 싶지 않은 필드에 사용
    
## Value Mapping
### Annotation 

1. Entity 타입과 Value 타입 구분
    - 식별자가 있어야 하는가
    - 독립적으로 존재해야 하는가

2. Value 타입의 종류
    - Primitive 타입(String, Date, Boolean, ...)
    - Composite 타입
    - Collection 타입
        - Primitive 타입의 컬렉션
        - Composite 타입의 컬렉션
        
 3. Composite Value Type Mapping
    - Embeddable
    - Embedded
    - AttributeOverrides
    - AttributeOverride

