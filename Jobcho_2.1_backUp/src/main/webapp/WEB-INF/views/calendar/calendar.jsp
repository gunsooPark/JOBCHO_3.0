<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
    <meta
      name="viewport"
      content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"
    />
    <!-- jquery CDN -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- fullcalendar CDN======================= -->
    <link
      href="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js"></script>
    <!-- fullcalendar 언어 CDN==================== -->
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js"></script>
    <style>
      /* body 스타일 */
      html,
      body {
        overflow: hidden;
        font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
        font-size: 14px;
      }
      /* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
      .fc-header-toolbar {
        padding-top: 1em;
        padding-left: 1em;
        padding-right: 1em;
      }
    </style>
    <title>공유일정</title>
  </head>
  <body style="padding: 30px">
    <!-- calendar 태그 -->
    <div id="calendar"></div>
    <script>
      document.addEventListener("DOMContentLoaded", function () {
        var calendarEl = document.getElementById("calendar"); // new FullCalendar.Calendar(대상 DOM객체, {속성:속성값, 속성2:속성값2..})
        var calendar = new FullCalendar.Calendar(calendarEl, {
          headerToolbar: {
            left: "prev,next today",
            center: "title",
            right: "dayGridMonth,timeGridWeek,timeGridDay",
          },
          locale:"ko",
          initialDate: "2021-04-12", // 초기 로딩 날짜.
          navLinks: true, // can click day/week names to navigate views
          selectable: true,
          selectMirror: true, // 이벤트명 : function(){} : 각 날짜에 대한 이벤트를 통해 처리할 내용..
          select: function (arg) {
            console.log(arg);
            console.log(arg.start);
            var title = prompt("입력할 일정:"); // title 값이 있을때, 화면에 calendar.addEvent() json형식으로 일정을 추가
            if (title) {
              calendar.addEvent({
                title: title,
                start: arg.start,
                end: arg.end,
                allDay: arg.allDay,
              });
            }
            calendar.unselect();
          },
          eventClick: function (arg) {
            // 있는 일정 클릭시,
            console.log("#등록된 일정 클릭#");
            console.log(arg.event);
            if (confirm("Are you sure you want to delete this event?")) {
              arg.event.remove();
            }
          },
          editable: true,
          dayMaxEvents: true, // allow "more" link when too many events
        //================ ajax데이터 불러올 부분 =====================//
          events: function(info, successcallback, failecallback){ // ajax 처리로 데이터를 로딩 시킨다. 
        	  $.ajax({ 
        		  		type:"post", 
        		  		url:"${path}/getListCalendar?method=data", 
        				  dataType:"application/json",
        				  
        				  success: function(){
        					  var events = [];
        					  $.each(arg, function(idx, item){
        						  var title = arg[idx].title;
        						  var start = arg[idx].start;
        						  var end = arg[idx].start;
        						  events.push({
        							  
        						  });
        							  
        						  
        					  });
        					  
        				  }
        		}); 
        	  
        	  }
          } //events end

        }
  		);
        calendar.render();
      });
    </script>
  </body>
</html>
