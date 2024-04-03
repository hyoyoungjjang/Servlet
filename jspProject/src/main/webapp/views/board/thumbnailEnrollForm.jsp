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
        height: 700px;
        margin: auto;
        margin-top: 50px;
    }

    #enjroll-form table{
        border: 1px solid white;
    }

    #enjroll-form input, #enjroll-form textarea{
        width: 100%;
        box-sizing: border-box;
    }

    #enroll-form img:hover {
        cursor: pointer;
        scale: 0.98;
    }

</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="outer">
        <br>
        <h2 align="center">사진게시판 작성하기</h2>
        <br>

        <form action="" method="post" id="enroll-form">
            <table align="center">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">
                        <input type="text" name="title" required>
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3">
                        <textarea name="content" rows="5" style="resize: none;"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>대표이미지</th>
                    <td colspan="3">
                        <img id="title-img" width="250" height="170" onclick="chooseFile(1);">
                    </td>
                </tr>
                <tr>
                    <th>상세이미지</th>
                    <td><img id="content-img1" width="150" height="120" onclick="chooseFile(2);"></td>
                    <td><img id="content-img2" width="150" height="120" onclick="chooseFile(3);"></td>
                    <td><img id="content-img3" width="150" height="120" onclick="chooseFile(4);"></td>
                </tr>
            </table>

            <div style="display: none;">
                <input type="file" id="file1" name="file1" required onchange="loadImg(this, 1)">
                <input type="file" id="file2" name="file2" onchange="loadImg(this, 2)">
                <input type="file" id="file3" name="file3" onchange="loadImg(this, 3)">
                <input type="file" id="file4" name="file4" onchange="loadImg(this, 4)">
            </div>

            <script>
                function loadImg(inputFile, num){
                    //inputFile : 현재 변화가 생긴 input type=file 요소 객체
                    //num : 몇번째 input요소인지 확인하기 위한 파라미터

                    //inputFile.files[0] => 선택된 파일이 담겨있다.
                    // console.log(inputFile.files[0])

                    if(inputFile.files.length == 1){
                        //파일을 읽어들ㅇ일 FileReader 객체 생성
                        const reader = new FileReader();

                        //파일을 읽어들이는 메소드
                        //해당파일을 읽어들이는 순간 해당 파일만의 고유한 url부여
                        reader.readAsDataURL(inputFile.files[0]);

                        //파일 읽어들이기 완료했을 때 실행할 함수 정의
                        reader.onload = function(ev){
                            // ev.target.result => 읽어들인 파일의 고유한 url이있다.

                            switch(num){
                                case 1: document.getElementById("title-img").src = ev.target.result; break;
                                case 2: document.getElementById("content-img1").src = ev.target.result; break;
                                case 3: $("#content-img2").attr("src", ev.target.result); break;
                                case 4: $("#content-img3").attr("src", ev.target.result); break;
                            }    
                        }
                    } else { // 선택된 파일을 취소한 경우 => 미리보기 지워준다.
                        switch(num){
                                case 1: document.getElementById("title-img").src = null; break;
                                case 2: document.getElementById("content-img1").src = null; break;
                                case 3: $("#content-img2").attr("src", null); break;
                                case 4: $("#content-img3").attr("src", null); break;
                            }    
                    }
                }
                function chooseFile(num){
                    const imgInput = document.querySelector("#file" + num);
                    imgInput.click();
                }
            </script>

            <br>

            <div align="center">
                <button type="submit">등록하기</button>

            </div>
        </form>
    </div>
</body>
</html>