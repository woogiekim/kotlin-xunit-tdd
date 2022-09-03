# 코틀린과 TDD로 만드는 XUnit

토비(이일민)님의 유튜브 영상과 켄트벡의 테스트 주도 개발 책을 참고해서 코틀린으로 XUnit 만들어 본다.


## 요구사항
- [x] 테스트 메서드 호출하기
- [x] 먼저 setUp 호출하기
- [x] 나중에 tearDown 호출하기
- [ ] 테스트 메서드가 실패하더라도 tearDown 호출하기
- [x] 여러개의 테스트 실행하기
- [x] 수집된 결과를 출력하기
- [x] WasRun에 로그 문자열 남기기
- [x] 실패한 테스트 보고하기
- [] setUp 에러를 잡아서 보고하기
- [x] TestCase 클래스로 TestSuite 생성하기