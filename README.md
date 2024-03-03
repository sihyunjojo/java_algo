# 알고리즘 과제 🗂️


## 📝 File Naming Convention
문제 풀이 파일은 '플랫폼_레벨_문제_이름_메모.java' 형태의 네이밍 사용
```
ex)
Bj_S1_문제_이름_메모.java
Swea_d2_문제_이름_메모.java
```

## 📁 FOLDER STRUCTURE
날짜 기준 폴더링 구조
```
240131(과제 제출 날짜 기준 폴더 생성)
ㄴ Swea_d2_2001_파리퇴치_(Sovled,Best).java
240201
ㄴ Bj_S4_1244_스위치끄고켜기.java
```

# 📚Check Table
<table>
<thead align="center">
<tr>
    <td><b>알고리즘 유형</b></td>
    <td><b>문제</b></td>
    <td><b>코드</b></td>
    <td><b>메모</b></td>
</tr>
</thead>
<tbody>
<tr>
    <td rowspan="1">구현</td> 
    <td><a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf">Swea_1767_프로세서연결하기</a></td></a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/be6ae079d9b503fa94cb1b4038739217b0276236/algo_240228/src/Swea_1767_프로세서연결하기.java">Swea_1767_프로세서연결하기</a></td>
    <td>여기에서 문제는 프로세서당 가능한 dir을 class에 넣어줘서 해결하는 것 <br>
        그리고 temp_board를 마지막에 init_board(처음 받아온 것)으로 원복해주는 것</td>
</tr>
<tr>
    <td rowspan="1">구현</td> 
    <td><a href="https://www.acmicpc.net/problem/17471">Bj_G4_17471_게리맨더링</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/2e401c34b5955af7f95217b6953ab8a4d9b46fee/algo_240222/src/solved/Bj_G4_17471_게리맨더링_another.java#L47-L46">Bj_G4_17471_게리맨더링</a></td>
    <td>순열이나 부분집합으로 01로 짠 후에 1이면 a에 넣고 0이면 b에 넣는 방식으로 구현.<br>
        그리고 연결되어 있는지 체크할때, 리스트에 contains()되어 있는 값만 체크해서 cnt가 같으면 true를 똭!!!!!</td>
</tr>
<tr>
    <td rowspan="1">DFS</td> 
    <td><a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq">Swea_1949_등산로조성</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/ff8df9426d87a6acc8ea793c2f8b7960948c8e4c/algo_st_2402_4/src/fail/Swea_1949_등산로조성_Best.java#L18">Swea_1949_등산로조성</a></td>
    <td>최고로 긴거니까 dfs를 사용.<br>
        그리고 dfs에서 부쉇는지 check하는 인자를 넣어서 부술 수 있는 경우의 수를 체크!!</td>
</tr>
<tr>
    <td rowspan="1">구현</td> 
    <td><a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu">Swea_2115_벌꿀채취</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/ff8df9426d87a6acc8ea793c2f8b7960948c8e4c/algo_st_2402_4/src/fail/Swea_2115_벌꿀채취.java">Swea_2115_벌꿀채취</a></td>
    <td> 제곱 값을 비교할 때, 그냥 원래 값이 큰거랑 제곱 값이 큰거랑 다른거여서 확실하게 최종적으로 제곱 값을 비교를 해줘야하는 문제.</td>
</tr>
<tr>
    <td rowspan="1">BFS</td> 
    <td><a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu">Swea_2117_홈방범서비스</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/ff8df9426d87a6acc8ea793c2f8b7960948c8e4c/algo_st_2402_4/src/solved/Swea_2117_홈방범서비스.java#L37">Swea_2117_홈방범서비스</a></td>
    <td>index = n+1; 이걸 안해서 고민을 했던 문제. +1 을 안하면 모서리가 체크가 안됨.<br></td>
</tr>
<tr>
    <td rowspan="1">BFS</td>
    <td><a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo">Swea_5653_줄기세포배양</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/0297bca8cbb49240b60f33994393c6f78dd5ce66/algo_st_2402_3/src/Swea_5653_줄기세포배양.java#L14">Swea_5653_줄기세포배양</a></td>
    <td>살아 있는 세포를 List로 관리하고 1. 죽은 세포는 빼주고 2. 그 리스트를 value로 내림차순 정렬을 해주는 거야.<br>
        board에 값 추가해주고, 그 값이 0이 아니면 안해주고 0만 해주는 걸로.</td>
</tr>
<tr>
    <td rowspan="1">구현</td> 
    <td><a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl">Swea_2382_미생물격리</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/0297bca8cbb49240b60f33994393c6f78dd5ce66/algo_st_2402_3/src/refactor/Swea_2382_미생물격리.java#L12-L11">Swea_2382_미생물격리</a></td>
    <td>문제의 한 단계 한 단계를 확실히 체크하고 가야한다.<br>
        클래스로 미생물을 써서 dir을 함수로 편하게 관리하고, x와y를 정렬해주기 편하게 하면 좋음. <br>
        뺄때 2중 for문에서 i--만 해주면 됨. <br>
        equals 메서드는 웬만하면 재정의 하지말고, if문으로 하기 // 만약 할꺼면 remove나 기본 함수 쓸때 인자 class로 쓰는거 조심. </td>
<tr>
<tr>
    <td rowspan="1">구현</td> 
    <td><a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu">Swea_2112_보호필림</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/ff8df9426d87a6acc8ea793c2f8b7960948c8e4c/algo_st_2402_4/src/solved/Swea_2112_보호필림.java">Swea_2112_보호필림</a></td>
    <td>for문을 사용할 때, 다시 쓸것들을 반드시 초기화를 무조건 반드시 해줘야한다.<br>
        temp_board를 원복해주는 것도 중요!! <br>
<tr>
<tr>
    <td rowspan="1">BFS</td> 
    <td><a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu">Swea_2105_디저트카페</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/60c59c9ce9805325bc386daa88274c88c5138fcb/algo_st_2402_5/src/Swea_2105_디저트카페_NotMy.java">Swea_2105_디저트카페</a></td>
    <td>대각선 bfs, 제발 그냥 for 전체를 전부 bfs로 해주면 편한문제.<br>
        init_x,init_y를 써서 초기 값을 인자로 넣어주는 문제.<br>
        리스트 관리를 잘해야하는 문제. <br>
        전체 디저트를 배열로 관리해서 거기에 이미 1이 들어있으면 리턴하게 해주면 편하개 풀 수 있는 문제</td>
<tr>
<tr>
    <td rowspan="1">DFS</td> 
    <td><a href="https://www.acmicpc.net/problem/3109">Bj_G2_3109_빵집</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/0297bca8cbb49240b60f33994393c6f78dd5ce66/algo_240229/src/again/Bj_G2_3109_빵집.java#L6-L5">Bj_G2_3109_빵집</a></td>
    <td>문제를 잘 생각해서 이미 간 곳은 의미가 없으므로 visitied를 그냥 계속 두는는게 핵심인 문제.<br>
        그리고 성공하면 하나씩 세는 문제는 return true;를 해주고 true이면 res++ 해주는게 좋다.</td>
</tr>
<tr>
    <td rowspan="1">구현</td>
    <td><a href="https://www.acmicpc.net/problem/15686">Bj_G5_15686_치킨배달</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/39fea4f9ea4910097fed9fc98a89b48a02609110/algo_240220/src/Bj_G5_15686_치킨배달.java#L10">Bj_G5_15686_치킨배달</a></td>
    <td>치킨 집과 가정 집을 리스트로 둘 다 선언 (특정한 것은 리스트로 선언해서 어떻게 하면 조금 더 쉬울 지도?)<br>
        순열과 조합은 코드 작성하고 잘 되는지 한번 출력해보고 넘어가자 <br>
        bfs 돌리면서 가장 가까운 애들 찾아도 되지만, 그냥 치킨집과 가정집들 dis를 구해서 가장 작은거 해줘도 됨.</td>
</tr>
<tr>
    <td rowspan="1">BFS</td>
    <td><a href="https://www.acmicpc.net/problem/2636">Bj_G3_2636_치즈</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/1fb91e9ffa9804bab3f04fc006b99d80fbe7c4f0/algo_240220/src/again/Bj_G3_2636_치즈.java#L15-L14">Bj_G3_2636_치즈</a></td>
    <td> 처음부터 해서 0을 BFS에 넣어주고 1인 부분은 지워만 주고 queue에는 넣지않는 기가막힌 방법을 쓰는 문제<br>
        visited와 queue에 넣는 것을 너무 무의식적으로 당연하게 넣지는 말자.</td>
</tr>
<tr>
    <td rowspan="1">BFS</td>
    <td><a href="https://www.acmicpc.net/problem/4963">Bj_S2_4963_섬의개수</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/6f3d1bda3fe089ccd2ddbb1966816f37bd2b8f02/algo_240216/src/Bj_S2_4963_섬의개수.java#L11">Bj_S2_4963_섬의개수</a></td>
    <td>for문으로 하면서 섬이면 거기서부터 bfs해서 다 바꿔주고 cnt를 추가하는 문제였지.</td>
</tr>
<tr>
    <td rowspan="1">구현</td>
    <td><a href="https://swexpertacademy.com/main/code/problem/problemDetail.do">Swea_2383_점심식사시간</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/0297bca8cbb49240b60f33994393c6f78dd5ce66/algo_240229/src/Swea_2383_점심식사시간.java#L14-L13">Swea_2383_점심식사시간</a></td>
    <td> 부분 집합해서 마지막에 3명이 0이면 피니시 플래그를 바꿔주고 피니시 플래그가 3이면 break를 해주면 된다.</td>
</tr>
<tr>
    <td rowspan="1">윈도우 슬라이싱</td> 
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240201/src/Bj_S2_12891_DNA비밀번호.java">Bj_S2_12891_DNA비밀번호</a></td></a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240201/src/Bj_S2_12891_DNA비밀번호.java">Bj_S2_12891_DNA비밀번호</a></td></a></td>
    <td>슬라이싱에 대한 개념 외우기</td>
</tr>
<tr>
    <td rowspan="1">Stack</td> 
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240205/src/fail/Bj_G5_2493_탑_Fail.java">Bj_G5_2493_탑_Fail</a></td>
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240205/src/fail/Bj_G5_2493_탑_Fail.java">Bj_G5_2493_탑_Fail</a></td>
    <td>순차적으로 된 형태?? 그걸 스택 형태로 빠르게 해결할 수 있는 방법 외우기</td>
</tr>
</tbody>
</table>

# 📚Algo Table
[//]: # (<td colspan="2">내용</td>)

[//]: # (<td rowspan="3">내용</td>)
<table>
  <thead align="center">
    <tr>
        <td><b>알고리즘 유형</b></td>
        <td><b>문제 정보</b></td>
        <td><b>문제</b></td>
        <td><b>메모</b></td>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="13">구현</td>  <!-- 구현 -->
      <td>시뮬레이션</td>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240130/src/Bj_Silver4_1244_스위치켜고끄기.java">Bj_Silver4_1244_스위치켜고끄기</a></td>
      <td></td>
    </tr>
    <tr>
      <td rowspan="5">완전 탐색</td> <!-- 완전 탐색 -->
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240130/src/Swea_D3_1208_Flatten.java">Swea_D3_1208_Flatten</a></td>
      <td></td>
    </tr>
    <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240130/src/Swea_D3_2805_농작물수확하기.java">Swea_D3_2805_농작물수확하기</a></td>
      <td></td>
    </tr>
    <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240130/src/Swea_D4_1210_Ladder1.java">Swea_D4_1210_Ladder1</a></td>
      <td></td>
    </tr>
     <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240131/src/Swea_D2_1954_달팽이숫자.java">Swea_D2_1954_달팽이숫자</a></td>
      <td></td>
    </tr>
    <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240131/src/Bj_S3_6603_로또.java">Bj_S3_6603_로또</a></td>
      <td></td>
    </tr>
    <tr>
      <td rowspan="4">부분 집합</td> <!-- 완전 탐색 -->
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240201/src/Bj_S2_2961_도영이가만든맛난음식.java">Bj_S2_2961_도영이가만든맛난음식</a></td>
      <td></td>
    </tr>
    <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240201/src/Swea_D2_2001_파리퇴치.java">Swea_D2_2001_파리퇴치</a></td>
      <td></td>
    </tr>
    <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240201/src/Swea_D3_5215_햄버거다이어트.ja">Swea_D3_5215_햄버거다이어트</a></td>
      <td></td>
    </tr>
    <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240201/src/Swea_d3_6808_규영이와인영이의카드게임.java">Swea_d3_6808_규영이와인영이의카드게임</a></td>
      <td></td>
    </tr>
    <tr>
      <td rowspan="2">누적합 알고리즘</td> <!-- 비트 마스킹 -->
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240131/src/Bj_S1_11660_구간합구하기5.java">Bj_S1_11660_구간합구하기5</a></td>
      <td></td>
    </tr>
    <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240131/src/Bj_S3_11659_구간합구하기4.java">Bj_S3_11659_구간합구하기4</a></td>
      <td></td>
    </tr>
    <tr>
      <td rowspan="1">큐</td> <!-- 완전 탐색 -->
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240202/src/Bj_S4_1158_요세푸스문제.java">Bj_S4_1158_요세푸스문제</a></td>
      <td>자료구조 문제.</td>
    </tr>
    <tr>
      <td rowspan="5">백트래킹</td>  <!-- 백트래킹 -->
      <td rowspan="2">순열</td> 
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240130/src/Bj_Silver3_15649_n%EA%B3%BCm1.java">Bj_silver3_15649_n과m1</a></td>
      <td></td>
    </tr>
    <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240130/src/Bj_Silver3_15651_n과m3.java">Bj_silver3_15649_n과m3</a></td>
      <td></td>
    </tr>
    <tr>
      <td rowspan="3">조합</td> <!-- 조합 -->
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240131/src/Bj_B3_3040_백설공주와일곱난쟁이.java">Bj_B3_3040_백설공주와일곱난쟁이</a></td>
      <td></td>
    </tr>
     <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240131/src/Bj_S3_15650_n과m2.java">Bj_S3_15650_n과m2</a></td>
      <td></td>
    </tr> 
    <tr>
      <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240131/src/Bj_S3_15650_n과m4.java">Bj_S3_15650_n과m4</a></td>
      <td></td>
    </tr>
 
  </tbody>
</table>


[//]: # (<tr>)

[//]: # (  <td rowspan="5">백트래킹</td>  <!-- 백트래킹 -->)

[//]: # (  <td rowspan="2">순열</td> )

[//]: # (  <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240130/src/Bj_Silver3_15649_n%EA%B3%BCm1.java">Bj_silver3_15649_n과m1</a></td>)

[//]: # (  <td></td>)

[//]: # (</tr>)

# 📚Fail Table
- 외울때 까지 무한 반복
<table>
<thead align="center">
<tr>
    <td><b>알고리즘 유형</b></td>
    <td><b>문제 정보</b></td>
    <td><b>문제</b></td>
    <td><b>메모</b></td>
    <td><b>복습(5)</b></td>
</tr>
</thead>
<tbody>
<tr>
    <td rowspan="2">구현</td>
    <td rowspan="1">윈도우 슬라이싱</td> <!-- 완전 탐색 -->
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240201/src/Bj_S2_12891_DNA비밀번호.java">Bj_S2_12891_DNA비밀번호</a></td></a></td>
    <td>슬라이싱에 대한 개념 외우기</td>
    <td>1</td>
</tr>
<tr>
    <td rowspan="1">비트 마스킹</td> <!-- 완전 탐색 -->
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240201/src/Bj_S5_11723_집합_Best.java">Bj_S5_11723_집합_Best</a></td>
    <td>비트마스킹 하는 전체 방식 외우기</td>
    <td>1</td>
</tr>
<tr>
    <td rowspan="1">자료구조</td>  <!-- 자료구조 -->
    <td rowspan="1">Stack</td> 
    <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240205/src/fail/Bj_G5_2493_탑_Fail.java">Bj_G5_2493_탑_Fail</a></td>
    <td>순차적으로 된 형태?? 그걸 스택 형태로 빠르게 해결할 수 있는 방법 외우기</td>
    <td>1</td>
</tr>
</tbody>
</table>

[//]: # (    <tr>)

[//]: # (        <td rowspan="1">자료구조</td>  <!-- 자료구조 -->)

[//]: # (        <td rowspan="1">Stack</td> )

[//]: # (        <td><a href="https://github.com/sihyunjojo/java_algo/blob/main/algo_240205/src/fail/Bj_G5_2493_탑_Fail.java">Bj_G5_2493_탑_Fail</a></td>)

[//]: # (        <td>순차적으로 된 형태?? 그걸 스택 형태로 빠르게 해결할 수 있는 방법 외우기</td>)

[//]: # (    </tr>)






# 💻 📋 알고리즘 종류 
- **투 포인터**
- **이진 탐색**
- **비트 마스킹**
- 누적합 
- 윈도우 슬라이싱
- 재귀 알고리즘
- BFS
- DFS
- 조합
- 순열
- 가지치기
- **데이크스트라**
- 백트래킹
- 트리
- **스위핑**
- 라인 스위핑
- 분할 정복
- **우선 순위 큐**
- 최단 경로
- 소수 판정
- **최소 스패닝 트리**
- **유클리드 호제법**
- **플로이드 워셜**
- Deque
- Queue
- Stack
- 외판원 순회 문제
- 0-1 BFS
- 이분 그래프
- 비둘기집 원리
- 연결 리스트
- 간선 리스트
- 메모리제이션
- 유니온 파인드
- LIS
- 최단거리
- 팬웍트리
- 트리순회
- 에라스토테네스의 체


# 📚 숙제

## 02.01
비트마스킹이랑  
자바 슬라이싱 윈도우 달달 외우기 

누적합 알고리즘 외워서 자주 적용시키기   
이전거 + 현재거 / 결과 = [a-1] - [b]  

## 02.02
윈도우 슬라이스 예시 항상 상기시켜서 잘 외워두기

## 02.03
자료구조를 사용하자!  
수학적으로 풀려고 고집 부리지말자!  
## 02.04
출력에는 StringBuilder 사용하자!

## 02.09
스택 (문제 탑) 유형 외우기.
(구현)문제의 과정이 어떻게 되는지 완벽히 이해를 하고 코딩을 하자  
무작정 맘대로 생각하고 구현하지말고.

## 02.10
우선순위 큐 자료구조 정리하기.   
제발 출력 양식 잘 읽고 지키기...  

## 2.13
np 외우기  
원하는 결과 값이 배열을 반드시 쓰지 않아도 되는 방식 이라면,
배열이 아닌 첫값과 끝값을 통해서 결과값을 유도해보는 방식도 고려하자.  

## 02.16
정점이 움직이는 문제를 풀 때, 모든 정점이 겪을 수 있는 경우의 수를 모두 생각해보자.
정점 2개가 움직이면 더 많이 갈리겠지???

## 02.20
// 줄기세포배양
재귀에서 time을 time에 따라서 함수들의 순서를 어떻게 구현하고 안에 time인자가 들어가야하는 부분을 어떻게 설정해야할지에 대해서 고민이 조금 더 필요함.


## 02.21
어디서든지 true를 해주면 false를 해줘야한다.

## 02.22
모든 문제의 햇갈릴만한 부분을 주석으로 전부 적고 시작.

## 02.23
순조부에서 하나를 선택할 수 있는 문제인지 항상 생각하기  
그 이후에 그래프든지 조건을 해결하고   
답을 구하는 문제인지 항상 미리 생각하기    

## 02.28
for 문보다  
for each문이 훨씬 빠름.  
자료형 주의  int -> long  

## 02.29
isvisited = new boolean[h][w][k + 1]; // 이 아이디어가 핵심이다.  
bfs();  
if (res == 0) res = -1;  
if (w == 1 && h == 1) res = 0; // 이것도 조심해야할듯 애매하게 항상 하나 틀릴듯  