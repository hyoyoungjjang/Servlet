<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background: black;
        color: white;
        width: 1000px;
        margin: auto;
        margin-top: 50px;
        padding: 10px 0 50px 0;
    }

    table{
        margin: auto;
    }
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>

    <div class="outer">
        <br>
        <h2 align="center">회원가입</h2>
    
        <form action="<%=contextPath%>/insert.me" id="enroll-form" method="post">
            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="userId" maxlength="12" required></td>
                    <td><button type="button" onclick="idCheck();">중복확인</button></td>
                </tr>
                <tr>
                    <td>* 비밀번호</td>
                    <td><input type="password" name="userPwd" maxlength="15" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 비밀번호 확인</td>
                    <td><input type="password" name="userPwdCheck" maxlength="15" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>* 이름</td>
                    <td><input type="text" name="userName" maxlength="6" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" placeholder="- 포함해서 입력"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" name="email"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>관심분야</td>
                    <td colspan="2">
                        <input type="checkbox" name="interest" id="sports" value="운동">
                        <label for="sports">운동</label>
                        <input type="checkbox" name="interest" id="climbing" value="등산">
                        <label for="climbing">등산</label>
                        <input type="checkbox" name="interest" id="fishing" value="낚시">
                        <label for="fishing">낚시</label>
                        <input type="checkbox" name="interest" id="cooking" value="요리">
                        <label for="cooking">요리</label> 
                        <br>
                        <input type="checkbox" name="interest" id="game" value="게임">
                        <label for="game">게임</label>
                        <input type="checkbox" name="interest" id="movie" value="영화">
                        <label for="movie">영화</label>
                        <input type="checkbox" name="interest" id="etc" value="기타">
                        <label for="etc">기타</label>
                    </td>
                </tr>
            </table>
            <br><br>
            <div align="center">
                <button type="submit" onclick="return checkPwd();">회원가입</button>
                <button type="rest">초기화</button>
            </div>
        </form>     
    </div>
    
    <script>
        function checkPwd(){
            const pwd = document.querySelector("#enroll-form input[name=userPwd]").value;
            const pwdCheck = document.querySelector("#enroll-form input[name=userPwdCheck]").value;
            
            console.log(pwd)
            console.log(pwdCheck)
            if (pwd !== pwdCheck){
                alert("비밀번호가 일치하지 않습니다.")
                return false;
            }

        }

        function idCheck(){
            //중복확인 버튼 클릭시 사용자가 입력한 아이디 값을 서버에 보내서 조회요청(존재하는 아이디인가?) => 응답받기
            //1) 사용불가야 => alert메세지 출력(사용할 수 없는 아이디 입니다.) , 다시입력
            //2) 사용가능이야 => 진짜 사용할것인지?
            //                              ok => 더이상 아이디 수정 못하게끔, 회원가입 버튼 활성 
            //                              no => 다시 입력하도록 유도

            const idInput = document.querySelector("#enroll-form input[name=userId]");

            //idInput.value값을 서버에 보내야한다. ajax사용

            // $.ajax()
            /**
             * $.ajax({
             *       type : 전송타입 GET | POST,
             *       url : 어디로 요청을 보낼지
             *       data : {ket, value} -> 어떤데이터를 포함해서 보낼지
             *       success : function(){} -> 성공시 실행해줄 함수
             *       error : function(){} -> 실패시 실행해줄 함수
             * })
             */   
            $.ajax({
                type : "GET",
                url : "idCheck.me",
                data : {
                    checkId : idInput.value
                },
                success: function(res){
                    console.log("성공 : ",res);
                },
                error: function(err){
                    console.log("성공 : ",err);
                } 
            })

        }
    </script>

</body>
</html>