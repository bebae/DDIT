<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>


<!-- Nested Row within Card Body -->
<div class="row" id="row">
  <div class="col-lg-5 d-none d-lg-block <c:if test="${data.attachVOList[0].filename == null}">bg-register-image</c:if>">
    <c:if test="${data.attachVOList[0].filename != null}">
      <img id="previewImage" class="w-100" src="/resources/images${data.attachVOList[0].filename}" alt="도서 이미지">
    </c:if>
  </div>
  <div class="col-lg-7">
    <div class="p-5">
      <div class="text-center">
        <h1 class="h4 text-gray-900 mb-4">도서 등록</h1>
      </div>
      <!--
        요청URL : /bookInfo/addBookPost
        요청파라미터 : {bookId=A0001, name="세이노의 가르침" ...}
        요청 방식 : POST
      -->
      <form class="bookInfoFrm" action="/bookInfo/updateBookPost" method="post" enctype="multipart/form-data" id="frm">
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="bookId" name="bookId" placeholder="도서코드" value="${data.bookId}" required>
          </div>
          <div class="col-sm-6">
            <input type="text" class="form-control form-control-user" id="name" name="name"
                   placeholder="도서이름" value="${data.name}" >
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="unitPrice" name="unitPrice" placeholder="가격" value="${data.unitPrice}">
          </div>
          <div class="col-sm-6">
            <input type="text" class="form-control form-control-user" id="author" name="author" placeholder="저자" value="${data.author}">
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="publisher" name="publisher" placeholder="출판사" value="${data.publisher}">
          </div>
          <div class="col-sm-6">
            <input type="date" class="form-control form-control-user" id="releaseDate" name="releaseDate" placeholder="출간일" value="${data.releaseDate}">
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user"
                   id="totalPages" name="totalPages" placeholder="총페이지수" value="${data.totalPages}" />
          </div>

          <div class="col-sm-6 p-sm-2 text-center">
            <button class="btn btn-primary dropdown-toggle px-lg-5" type="button" id="category" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" value="${data.category}" disabled>분류</button>
            <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" >
              <a class="dropdown-item clsCategory" href="#">Hello Coding</a>
              <a class="dropdown-item clsCategory" href="#">IT</a>
              <a class="dropdown-item clsCategory" href="#">소설</a>
              <a class="dropdown-item clsCategory" href="#">자기계발</a>
            </div>
            <input type="hidden" name="category" value="${data.category}">
          </div>
        </div>
        <div class="form-group">
          <textarea class="form-control form-control-user" id="description" name="description" placeholder="상세정보"></textarea>
        </div>
        <div class="form-group row ml-2">
          <div class="form-check w-auto">
            <input class="form-check-input" type="radio" name="condition"  id="condition1" value="신규도서" <c:if test="${data.condition == '신규도서'}">checked</c:if>>
            <label class="form-check-label" for="condition1">신규도서</label>
          </div>
          <div class="form-check w-auto">
            <input class="form-check-input" type="radio" name="condition" id="condition2" value="중고도서" <c:if test="${data.condition == '중고도서'}">checked</c:if>>
            <label class="form-check-label" for="condition2">중고도서</label>
          </div>
          <div class="form-check w-auto">
            <input class="form-check-input" type="radio" name="condition" id="condition3" value="E-Book" <c:if test="${data.condition == 'E-Book'}">checked</c:if>>
            <label class="form-check-label" for="condition3">E-Book</label>
          </div>
        </div>

        <div class="form-group row">
          <div class="input-group mb-3">
            <input type="file" class="form-control" id="bookImage" name="bookImage">
          </div>
        </div>

        <!-- 일반모드 -->
        <div id="div1">
          <div class="form-group row">
            <div class="col-4">
              <button type="button" class="btn btn-primary btn-user btn-block btn" id="edit">수정</button>
            </div>
            <div class="col-4">
              <button class="btn btn-primary btn-user btn-block" id="delete">삭제</button>
            </div>
            <div class="col-4">
              <a href="/bookInfo/listBook?currentPage=1" class="btn btn-success btn-user btn-block">목록</a>
            </div>
          </div>
        </div>
        <!-- 수정모드 -->
        <div id="div2">
          <div class="form-group row">
            <div class="col-6">
              <button type="submit" class="btn btn-primary btn-user btn-block" id="update">완료</button>
            </div>
            <div class="col-6">
              <a href="/bookInfo/detailBook?bookId=${param.bookId}" class="btn btn-success btn-user btn-block">취소</a>
            </div>
          </div>
        </div>

      </form>

    </div>
  </div>
</div>

<script type="text/javascript">
    // document 내에 모든 요소가 로딩된 후에 실행
    $(function(){

        // 수정버튼 클릭 시 -> 수정 모드로 전환
        $("#edit").on("click", function(){
            $("#div1").css("display", "none");
            $("#div2").css("display", "block");

            $(".form-control-user").removeAttr("readonly");
            $("input[name=bookId]").attr("readonly", true);

            // 카테고리
            let category = $("#category");
            category.removeAttr("disabled");

            // 도서상태 처리
            $("input[type=radio]").attr("onclick","return ture;");
            // 파일 등록 버튼 가리기
            $("#bookImage").parent().parent().css("display", "block");

            //입력란 활성화
            CKEDITOR.instances['description'].setReadOnly(false);
        })

        // 비활성화 처리
        $(".form-control-user").attr("readonly", "readonly");

        // 카테고리
        let category = $("#category");
        category.attr("disabled", "disabled");

        // 도서상태 처리
        $("input[type=radio]").attr("onclick","return false;");
        // 파일 등록 버튼 가리기
        $("#bookImage").parent().parent().css("display", "none");

        $("#div1").css("display", "block");
        $("#div2").css("display", "none");


        /// 이미지 미리보기 시작
        $("input[name='bookImage']").on("change", handleImagFileSelect);
        // CKEditor 에디터 생성 및 내용 설정
        CKEDITOR.replace('description', {
            language: 'ko',
            autoParagraph: false
        });
        //입력란 읽기전용
        $("#description").attr("readOnly",true);
        let description = "${data.description}";
        CKEDITOR.instances['description'].setData(description);

        let category1 = "${data.category}"; // Change this value to the desired category
        category.html(category1);
        $("#categoryInput").val(category1);

        function handleImagFileSelect(e) {
            // 이미지 미리보기를 담당할 img 태그 선택
            let previewImg = $("#previewImage");

            let files = e.target.files;
            let fileArr = Array.prototype.slice.call(files);

            fileArr.forEach(function (f) {
                if (!f.type.match("image.*")) {
                    alert("이미지 확장자만 가능합니다!");
                    return;
                }

                let reader = new FileReader();
                reader.onload = function (e) {
                    // 읽은 이미지 데이터를 img 태그의 src 속성에 할당하여 미리보기 이미지로 표시
                    previewImg.attr("src", e.target.result);
                    previewImg.css("display", "block"); // 미리보기 이미지 보이기
                };
                reader.readAsDataURL(f);
            });

            $(".bg-register-image").removeClass("bg-register-image");
            $("#row").firstChild.html();
        }
        // 이미지 미리보기 끝

        $(".clsCategory").on("click", function(){
            let category = $(this).html();
            console.log("category : "+ category);
            $("#category").html(category);
            $("input[name='category']").val(category);
        });

        // 삭제 버튼
        $("#delete").on("click", function (){
            // form action 속성 변경
            let form = $("#frm");
            form.attr("action", "/bookInfo/deleteBookPost")

            // 삭제 confirm

            let result = confirm("정말로 삭제하시겠습니까?");
            console.log("result : "+ result);

            if (result > 0){
                // form submit
                form.submit();
            } else {
                // 삭제 취소
                alert("삭제가 취소되었습니다.");
            }
        });


    });
</script>