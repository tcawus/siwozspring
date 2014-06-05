<spring:url value="/resources/js/jquery-1.10.2.js" var="jQuery" />
<script src="${jQuery}"></script>
<spring:url value="/resources/js/jquery-ui-1.10.4.custom.js"
	var="jQueryUI" />
<script src="${jQueryUI}"></script>

<script>
/*  jQuery ready function. Specify a function to execute when the DOM is fully loaded.  */
$(document).ready(
  /* This is the function that will get executed after the DOM is fully loaded */
  function () {
    /* Next part of code handles hovering effect and submenu appearing */
    $('.nav li').hover(
      function () { //appearing on hover
        $('ul', this).fadeIn();
      },
      function () { //disappearing on hover
        $('ul', this).fadeOut();
      }
    );
  }
);
</script>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/start/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />



