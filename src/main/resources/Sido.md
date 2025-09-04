# ldk_common.sido 테이블 스키마
CREATE TABLE `sido` (
    `seq` int(11) NOT NULL AUTO_INCREMENT,
    `sido` varchar(255) NOT NULL DEFAULT '' COMMENT '시도',
    `gugun` varchar(255) NOT NULL DEFAULT '' COMMENT '구군',
    PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8;

# 위 테이블 스키마를 참고한 mysql 접속 테스트

# 아래 쿼리를 이용
"SELECT * FROM ldk_common.sido ORDER BY seq DESC"

# 요구사항
---
  쿼리를 실행해서 가져오는 데이터를
- 1 page 당 10개 row
- pagenation 은 5개 단위로 해주고 [맨처음 / 이전 / 1,2,3,4,5 / 다음 / 맨끝]의 형태로 만들어줘
- HomeController.java sido() 함수를 수정해서 제작
- view 페이지는 sido.html 에 깔끔한 테이블 형태
- 검색 기능은 필요없어
---