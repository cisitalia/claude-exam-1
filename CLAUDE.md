# Claude Code 지침

이 파일은 Claude Code가 프로젝트를 이해하고 작업할 수 있도록 도와주는 지침을 포함합니다.

## 요청사항
- Git 저장소 생성해줘(버전관리)
- 답변은 가능한 한글로 해줘. 단, 기술용어나 번역이 어색한 것은 영문 그대로 놔두고.
- 정확도·재현성·안정성 최우선
- 항상 5단계로 답하라:
  1) 명확화 → 가정·모호점 정리, 필요시 짧은 질문
  2) 계획 → 단계별 접근, 대안 비교
  3) 실행 → 답변/코드, TDD-ish & 최소 변경(diff), 보안·저작권 위험 시 경고+대안
  4) 자기검수 → 오류/한계 점검 + 검증 방식(테스트 절차·참고 기준)
  5) 최종요약 → 확실/조건부 결론 구분, 후속 액션 제시
  추가:
    - 단언에는 출처/검증 절차, 불확실시 범위 표시
    - 환경(버전, 언어, OS) 명시
    - 구조화된 형식(목록, 표, 코드 블록) 우선

## 프로젝트 개요
- 프로젝트 이름: JAVA SPRING BOOT PROJECT
- 설명: java spring-boot 기반의 프로젝트 뼈대(IntelliJ IDE 사용)
- 주요 기술 스택:

## 개발 환경 설정
#### 1. Backend
  - 언어: Java
  - framework: Spring Boot 3.3.5
  - 빌드: Gradle - Kotlin
  - 그룹: co.kr.example
  - 아티팩트: sb2
  - 패키지 이름: co.kr.example.sb2
  - JDK: ms-21
  - Java: 21
  - 패키지 생성: Jar

  프로젝트 종속성
    - Template Engine: Thymeleaf
    - DB: MySQL 5.7
      MySQL DB는 로컬에 설치되어있다.
      application.properties 파일의 MySQL 접속 설정은 ldk_common DB에 연결되는 것으로 설정해줘.
      spring.datasource.username=dba_lawdesk
      spring.datasource.password=??
      비번 설정은 나중에 내가 직접 할께,
      유저와 비번은 별도의 파일에 넣는게 좋을지 제안해줘. 일반적으로 어떤 식으로 하는지도 알려줘.

#### 2. Frontend
src/main/frontend/ 폴더에 작업
- SSR 방식
- tailwindcss v4
- alpinejs v3
- htmx
- esbuild
- font: Pretendard 폰트를 기본으로 설정


## 프로젝트 구조
일반적인 IntelliJ IDE - java spring boot 의 구조 대로 만들어줘


## 코딩 컨벤션
- 들여쓰기:
- 따옴표:
- 세미콜론:
- 네이밍:

## 환경변수 설정 가이드

### .env 파일 사용법
1. 프로젝트 루트에 `.env` 파일 생성
2. 데이터베이스 비밀번호 설정:
   ```
   DB_PASSWORD=your_actual_password
   ```
3. Spring Boot Dotenv 플러그인이 자동으로 환경변수 로드
4. application.properties에서 `${DB_PASSWORD:}` 형태로 참조

### 대안 방법들
- **시스템 환경변수**: `export DB_PASSWORD=password`
- **IntelliJ 환경변수**: Run Configuration → Environment Variables
- **Profile별 설정**: `application-local.properties` (git ignore)
- **외부 Config Server**: Spring Cloud Config 사용

### 보안 주의사항
- `.env` 파일은 반드시 `.gitignore`에 추가
- `.env.example` 파일로 템플릿 제공
- 프로덕션에서는 시스템 환경변수 또는 외부 Config 사용 권장

## 참고사항
- 환경변수 로드를 위해 `me.paulschwarz:spring-dotenv:4.0.0` 의존성 추가됨