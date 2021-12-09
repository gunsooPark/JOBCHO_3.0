/*===== EXPANDER MENU  =====*/ 
$(document).ready(function(){
	function setHome(){
    	var str=`<style>table.type07 {
  		  border-collapse: collapse;
  		  text-align: left;
  		  line-height: 1.5;
  		  border: 1px solid #ccc;
  		  margin: 20px 10px;
  		}
  		table.type07 thead {
  		  border-right: 1px solid #ccc;
  		  border-left: 1px solid #ccc;
  		  background: #e7708d;
  		}
  		table.type07 thead th {
  		  padding: 10px;
  		  font-weight: bold;
  		  vertical-align: top;
  		  color: #fff;
  		}
  		table.type07 tbody th {
  		  width: 150px;
  		  padding: 10px;
  		  font-weight: bold;
  		  vertical-align: top;
  		  border-bottom: 1px solid #ccc;
  		  background: #fcf1f4;
  		}
  		table.type07 td {
  		  width: 350px;
  		  padding: 10px;
  		  vertical-align: top;
  		  border-bottom: 1px solid #ccc;
  		}</style>
  	<table class="type07">
  		  <thead>
  		  <tr>
  		    <th scope="cols">타이틀</th>
  		    <th scope="cols">내용</th>
  		  </tr>
  		  </thead>
  		  <tbody>
  		  <tr>
  		    <th scope="row">항목명</th>
  		    <td>내용이 들어갑니다.</td>
  		  </tr>
  		  <tr>
  		    <th scope="row">항목명</th>
  		    <td>내용이 들어갑니다.</td>
  		  </tr>
  		  <tr>
  		    <th scope="row">항목명</th>
  		    <td>내용이 들어갑니다.</td>
  		  </tr>
  		  </tbody>
  		</table>`
  	$(".job-team-body").html(str);
    }
    
    //홈버튼 클릭했을때 홈으로 돌아옴
    $("#toggle-key-home").on("click", function(){setHome()})
    
    //초기 홈화면 세팅
//    setHome()
	
  $("#toggle-key-home").on("click",function(){
    console.log("집으로")
    $("#navbar-search").removeClass("expander-search")
    $("#navbar-search2").removeClass("expander-search")
    $("#navbar-search3").removeClass("expander-search")
  })


  $("#toggle-key").on("click",function(){
    console.log("눌러줘")
    $("#navbar-search2").removeClass("expander-search")
    $("#navbar-search3").removeClass("expander-search")
    $("#navbar-search").toggleClass("expander-search")
  })

  $("#toggle-key2").on("click",function(){
    console.log("눌러줘2")
    $("#navbar-search").removeClass("expander-search")
    $("#navbar-search3").removeClass("expander-search")
    $("#navbar-search2").toggleClass("expander-search")
  })

  $("#toggle-key3").on("click",function(){
    console.log("눌러줘3")
    $("#navbar-search").removeClass("expander-search")
    $("#navbar-search2").removeClass("expander-search")
    $("#navbar-search3").toggleClass("expander-search")
  })

  $("#toggle-key-member").on("click",function(){
    console.log("집으로")
    $("#navbar-search").removeClass("expander-search")
    $("#navbar-search2").removeClass("expander-search")
    $("#navbar-search3").removeClass("expander-search")
  })
})

