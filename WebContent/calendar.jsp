<!DOCTYPE html>
<html lang='en'>
  <head>
    <meta charset='utf-8' />
    <link href='fullcalendar/lib/main.css' rel='stylesheet' />
    <script src='fullcalendar/lib/main.js'></script>
    <script>
      
     	document.addEventListener('DOMContentLoaded', function() {
    	  var calendarEl = document.getElementById('calendar');

    	  var calendar = new FullCalendar.Calendar(calendarEl, {
    	    initialView: 'dayGridMonth',
    	    headerToolbar: {
    	      left: 'prev,next today',
    	      center: 'title',
    	      right: 'dayGridMonth,timeGridWeek,timeGridDay'
    	    },
    	    events: [
    	      {
    	        title: 'Assignment1',
    	        start: '2021-03-17'
    	      },
    	      {
    	        title: 'Assignment2',
    	        start: '2021-03-24',
    	      },
    	      {
      	        title: 'Assignment3',
      	        start: '2021-03-31'
      	      },
    	      {
      	        title: 'Assignment4',
      	        start: '2021-03-22'
      	      }
    	    ]
    	  });
    	  calendar.render();
    	});

    </script>
  </head>
  <body>
    <div id='calendar'></div>
  </body>
</html>