<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="/resources/js/jquery-3.6.0.js"></script>


<div class="card shadow mb-4">
  <div class="card-header py-3">
    <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
  </div>
  <div class="card-body">
    <div class="table-responsive">
      <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
        <form name="frm" id="frm" action="/bookInfo/listBook" method="get">
          <div class="row m-0">
            <div class="col-sm-12 col-md-6">
              <div class="dataTables_length" id="dataTable_length"><label>Size
                <select id="selSize"  name="size" aria-controls="dataTable" class="custom-select custom-select-sm form-control form-control-sm">
                  <option value="10" <c:if test="${param.size == '10'}">selected</c:if>>10</option>
                  <option value="25" <c:if test="${param.size == '25'}">selected</c:if>>25</option>
                  <option value="50" <c:if test="${param.size == '50'}">selected</c:if>>50</option>
                  <option value="100" <c:if test="${param.size == '100'}">selected</c:if>>100</option>
                </select> entries</label>
              </div>
            </div>
            <div class="col-sm-12 col-md-6">
              <div id="dataTable_filter" class="dataTables_filter">
                <label class="mr-2">Search:
                  <input type="search" class="form-control form-control" name="keyword" aria-controls="dataTable">
                  <input type="hidden" name="currentPage" value="1">
                </label>
                <label>
                  <button type="submit" class="btn btn-primary btn-icon-split">
                    <span class="icon text-white-50"><i class="fas fa-flag"></i></span>
                    <span class="text">검색</span>
                  </button>
                </label>
              </div>
            </div>
          </div>
        </form>
        <div class="row m-0">
          <div class="col-sm-12">
            <table class="table table-bordered dataTable text-center" id="dataTable" width="100%" cellspacing="0" role="grid"
                   aria-describedby="dataTable_info" style="width: 100%;">
              <thead>
              <tr role="row">
                <th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="순번: activate to sort column descending" style="width: 5%;">순번</th>
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="분류: activate to sort column ascending" style="width: 10%">분류
                </th>
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="도서명: activate to sort column ascending" style="width: 15%;">도서명
                </th>
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="도서명: activate to sort column ascending" style="width: 8%;">가격
                </th>
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="요약: activate to sort column ascending" style="width: 25%;">요약
                </th>
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="Start 저자: activate to sort column ascending" style="width: 14%;">저자
                </th>
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="출판사: activate to sort column ascending" style="width: 10%;">출판사
                </th>
                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                    aria-label="발매일: activate to sort column ascending" style="width: 10%;">발매일
                </th>
              </tr>
              </thead>
              <tbody class="vertical">
              <!-- stat.index : 0부터 시작 / stat.count : 1부터 시작 -->
              <c:forEach var="bookInfoVO" items="${data.content}" varStatus="stat">
                <c:set var="rowClass" value="${stat.count % 2 == 0 ? 'even' : 'odd'}" />
                <tr class="${rowClass}">
                  <td class="sorting_1" style="vertical-align: middle">${bookInfoVO.rnum}</td>
                  <td style="vertical-align: middle">${bookInfoVO.category}</td>
                  <td style="vertical-align: middle">
                    <a href="/bookInfo/detailBook?bookId=${bookInfoVO.bookId}">${bookInfoVO.name}</a>
                  </td>
                  <td style="vertical-align: middle"><fmt:formatNumber type="number" value="${bookInfoVO.unitPrice}" pattern="#,###" /></td>
                  <td style="vertical-align: middle">${bookInfoVO.description}</td>
                  <td style="vertical-align: middle">${bookInfoVO.author}</td>
                  <td style="vertical-align: middle">${bookInfoVO.publisher}</td>
                  <td style="vertical-align: middle">${bookInfoVO.releaseDate}</td>
                </tr>
              </c:forEach>

              <!-- total이 0일 때 ture -->
              <c:if test="${data.hasNoArticle()}">
                <tr class="odd">
                  <td colspan="8">데이터가 없습니다.</td>
                </tr>
              </c:if>
              </tbody>
            </table>
          </div>
        </div>

        <!-- total이 0보다 클 때 -->
        <c:if test="${data.hasArticle()}">
          <div class="row m-0">
            <div class="col-sm-12 col-md-5">
              <!-- currentPage * size - size-1) AND (currentPage * size) -->
              <div class="dataTables_info" id="dataTable_info" role="status" aria-live="polite">
                Showing ${data.currentPage * data.size - (data.size-1)} to ${data.currentPage*data.size}
                of ${data.totalCount} entries
              </div>
            </div>
            <div class="col-sm-12 col-md-7">
              <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                <ul class="pagination">
                  <li class="paginate_button page-item previous
                    <c:if test='${data.startPage < 6 }'> disabled</c:if>
                  " id="dataTable_previous">
                    <a href="/bookInfo/listBook?currentPage=${data.startPage-5}&size=${data.size}&keyword=${param.keyword}" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
                  </li>
                  <c:forEach var="pNo" begin="${data.startPage}" end="${data.endPage}" >
                    <li class='paginate_button page-item <c:if test="${param.currentPage==pNo}">active</c:if>'>
                      <a href="/bookInfo/listBook?currentPage=${pNo}&size=${data.size}&keyword=${param.keyword}" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">${pNo}</a>
                    </li>
                  </c:forEach>
                  <!-- eq : equal(==) / ne : not equal(!=) / ge : greater equal(>=) / le : less equal(<=) -->
                  <li class="paginate_button page-item next
                    <c:if test='${data.endPage ge data.totalPage}'>disabled</c:if>
                  " id="dataTable_next">
                    <a href="/bookInfo/listBook?currentPage=${data.startPage+5}&size=${data.size}&keyword=${param.keyword}" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </c:if>

      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
  $(function() {
      $("#selSize").on("change", function(){
          let val = $(this).val();
          console.log("val : " + val);
          <%--location.href = "/bookInfo/listBook?currentPage=${data.currentPage}&size="+val;--%>
          location.href = "/bookInfo/listBook?currentPage=1&size="+val;
      });
  });
</script>