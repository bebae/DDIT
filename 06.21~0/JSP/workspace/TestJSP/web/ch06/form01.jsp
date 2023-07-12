<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Form Processing</title>
</head>
<body>
    <h3>회원가입</h3>
    <div>
        <!-- 폼태그, 폼 필드 -->
        <!-- action 생략 시 본인 URL을 요청 -->
        <!-- method 생략 시 HTTP 요청방식은 GET -->
        <%--
          요청 URL : form01_process.jsp
          요청 방식 : post
          요청 파라미터(HTTP 파라미터 = QueryString) :
          { id, pass, name, phone1, phone2, phone3, gender, hobby, comment }
        --%>
        <form action="<%=request.getContextPath()%>/ch06/form01_process.jsp" name="member" method="post" onsubmit="return fn_chk()">
            <%--@declare id="phone3"--%><%--@declare id="phone2"--%>
            <label for="id">아이디 : </label>
            <input type="text" name="id" id="id" /><br><br>

            <label for="pass">비밀번호 : </label>
            <input type="password" name="pass" id="pass" /><br><br>

            <label for="name">이름 : </label>
            <input type="text" name="name" id="name" /><br><br>

            <label for="phone1">연락처 : </label>
            <select name="phone1" id="phone1">
                <option value="010">010</option>
                <option value="011">011</option>
                <option value="016">016</option>
                <option value="017">017</option>
                <option value="019" selected>019</option>
            </select>
            <label for="phone2">-
                <input type="text" name="phone2" maxlength="4" size="4" pattern="[0-9]*" />
            </label>
            <label for="phone3">-
                <input type="text" name="phone3" maxlength="4" size="4" pattern="[0-9]*" /><br><br>
            </label>

            <label>성별 : </label>
            <input type="radio" name="gender" id="male" value="male" />
            <label for="male">남성</label>
            <input type="radio" name="gender" id="female" value="female" checked/>
            <label for="female">여성</label><br><br>

            <label>취미 : </label>
            <label for="hobbyReading">독서</label>
            <input type="checkbox" name="hobby" id="hobbyReading" value="reading" />

            <label for="hobbyCoding">코딩</label>
            <input type="checkbox" name="hobby" id="hobbyCoding" value="coding" />

            <label for="hobbyExercise">운동</label>
            <input type="checkbox" name="hobby" id="hobbyExercise" value="exercise" />

            <label for="hobbyChess">체스</label>
            <input type="checkbox" name="hobby" id="hobbyChess" value="chess" /><br><br>

            <label for="comment">가입인사</label><br><br>
            <textarea name="comment" id="comment" cols="30" rows="3" placeholder="가입인사를 해주세요"></textarea><br><br>

                <input type="submit" value="가입하기" />
            <input type="reset" value="다시쓰기" /><br><br>
        </form>
    </div>
    <script>
        document.getElementById('phone1').addEventListener('change', function() {
            const selectedValue = this.value;
            const phone2Input = document.getElementsByName('phone2')[0];
            const phone3Input = document.getElementsByName('phone3')[0];

            // 휴대전화 번호 선택에 따라 기본 값 변경
            if (selectedValue === '010') {
                phone2Input.value = '0000';
                phone3Input.value = '0000';
            } else {
                phone2Input.value = '';
                phone3Input.value = '';
            }
        });

        const phoneInputs = document.querySelectorAll('input[name^="phone"]');
        for (let i = 0; i < phoneInputs.length; i++) {
            phoneInputs[i].addEventListener('input', function() {
                this.value = this.value.replace(/[^0-9]/g, '');
            });
        }

        function fn_chk(){
            let form = document.member;
            //<input type="text" maxlength="4" name="phone2"
            //isNaN : is Not a Number(이것은 숫자가 아니다)
            if(isNaN(form.phone2.value)){
                alert("휴대폰 번호는 숫자만 입력 가능합니다.");
                form.phone2.select();//커서를 해당 요소에 위치
                //false이면 submit 안됨
                return false;
            } else if(isNaN(form.phone3.value)){
                alert("휴대폰 번호는 숫자만 입력 가능합니다.");
                form.phone3.select();//커서를 해당 요소에 위치
                //false이면 submit 안됨
                return false;
            }
            //if 조건을 모두 통과해야 submit 됨
            return true;
        }

    </script>
</body>
</html>