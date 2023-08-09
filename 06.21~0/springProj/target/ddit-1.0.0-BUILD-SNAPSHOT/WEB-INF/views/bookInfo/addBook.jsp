<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>


<!-- Nested Row within Card Body -->
<div class="row" id="row">
  <div class="col-lg-5 d-none d-lg-block bg-register-image">
    <img id="previewImage" class="w-100" src="" alt="미리보기 이미지" style="display: none;">
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
      <form class="bookInfoFrm" action="/bookInfo/addBookPost" method="post" enctype="multipart/form-data">
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="bookId" name="bookId" placeholder="도서코드" required>
          </div>
          <div class="col-sm-6">
            <input type="text" class="form-control form-control-user" id="name" name="name"
                   placeholder="도서이름">
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
          <input type="text" class="form-control form-control-user" id="unitPrice" name="unitPrice" placeholder="가격">
          </div>
          <div class="col-sm-6">
            <input type="text" class="form-control form-control-user" id="author" name="author" placeholder="저자">
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="publisher" name="publisher" placeholder="출판사">
          </div>
          <div class="col-sm-6">
            <input type="date" class="form-control form-control-user" id="releaseDate" name="releaseDate" placeholder="출간일">
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user"
                   id="totalPages" name="totalPages" placeholder="총페이지수">
          </div>

          <div class="col-sm-6 p-sm-2 text-center">
            <button class="btn btn-primary dropdown-toggle px-lg-5" type="button" id="category" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">분류</button>
            <div class="dropdown-menu animated--fade-in" aria-labelledby="dropdownMenuButton" style="">
              <a class="dropdown-item clsCategory" href="#">Hello Coding</a>
              <a class="dropdown-item clsCategory" href="#">IT</a>
              <a class="dropdown-item clsCategory" href="#">소설</a>
              <a class="dropdown-item clsCategory" href="#">자기계발</a>
            </div>
            <input type="hidden" name="category" id="">
          </div>
        </div>
        <div class="form-group">
          <textarea class="form-control form-control-user" id="description" name="description" placeholder="상세정보"></textarea>
        </div>
        <div class="form-group row ml-2">
          <div class="form-check w-auto">
            <input class="form-check-input" type="radio" name="condition"  id="condition1" value="신규도서" checked>
            <label class="form-check-label" for="condition1">신규도서</label>
          </div>
          <div class="form-check w-auto">
            <input class="form-check-input" type="radio" name="condition" id="condition2" value="중고도서" >
            <label class="form-check-label" for="condition2">중고도서</label>
          </div>
          <div class="form-check w-auto">
            <input class="form-check-input" type="radio" name="condition" id="condition3" value="E-Book" >
            <label class="form-check-label" for="condition3">E-Book</label>
          </div>
        </div>

        <div class="form-group row">
          <div class="input-group mb-3">
            <input type="file" class="form-control" id="bookImage" name="bookImage">
          </div>
        </div>

        <button type="button" class="btn btn-info btn-user btn-block btn" id="autoData">자동 입력</button>
        <button type="submit" class="btn btn-primary btn-user btn-block">도서 등록</button>
        <button type="button" id="btnHeaders" class="btn btn-primary btn-user btn-block">headers매핑</button>
      </form>

    </div>
  </div>
</div>

<script type="text/javascript">
    CKEDITOR.replace('description');
</script>
<script type="text/javascript">
    // document 내에 모든 요소가 로딩된 후에 실행
    $(function(){
        /// 이미지 미리보기 시작
        $("input[name='bookImage']").on("change", handleImagFileSelect);
        // CKEditor 에디터 생성 및 내용 설정
        CKEDITOR.replace('description', {
            language: 'ko',
            autoParagraph: false
        });
        CKEDITOR.instances['description'].setData('<p>상세보기</p>');

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

        // Function to generate a random ISBN
        function generateRandomISBN() {
            let isbn = "979"; // First three digits of ISBN are usually 979 for bookland/ISBN-13
            for (let i = 0; i < 10; i++) {
                isbn += Math.floor(Math.random() * 10); // Generate random digits for the rest of the ISBN
            }
            return isbn;
        }

        // 자동 입력 버튼 클릭 시 폼에 데이터를 자동으로 입력
        $("#autoData").on("click", function () {
            // $("#bookId").val(generateRandomISBN());
            getISBN();
            // $("#name").val("세이노의 가르침");
            $("#unitPrice").val("10000");
            // $("#author").val("세이노");
            $("#publisher").val("출판사");
            $("#releaseDate").val("2023-03-02");
            // $("#totalPages").val("736");

            let category = "소설"; // Change this value to the desired category
            $("#category").html(category);
            $("#categoryInput").val(category);
        });

        // 도서코드 자동생성
        function getISBN() {
            console.log("Getting ISBN");

            $.ajax({
                url: "/bookInfo/getBookId",
                type: "POST",
                dataType: "text",
                success: function(data) {
                    console.log("result: " + data)
                    $("#bookId").val(data);
                }
            });
        }

        // btnHeaders
        $("#btnHeaders").on("click", function() {
            let bookId = $("#bookId").val();
            let name = $("#name").val();
            let unitPrice = $("#unitPrice").val();
            let author = $("#author").val();
            let totalPages = $("#totalPages").val();

            let data = {"bookId" : bookId, "name" : name,
                "unitPrice" : unitPrice, "author" : author,
                "totalPages" : totalPages};

            console.log(data);

            $.ajax({
                url : "/bookInfo/detail/"+bookId,
                contentType : "application/json; charset=UTF-8",
                data : JSON.stringify(data),
                type : "post",
                success : function(response) {
                    console.log(response);
                }
            });
        });

    });
</script>

