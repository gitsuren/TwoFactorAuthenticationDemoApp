<jsp:useBean id="word" class="com.suru.Word" scope="session"></jsp:useBean>
<jsp:useBean id="abean" class="com.suru.appBean" scope="session"></jsp:useBean>
<%

String qword=request.getParameter("word");

			if (!"".equals(request.getParameter("one"))
			&& !"".equals(request.getParameter("two"))
			&& !"".equals(request.getParameter("three"))
			&& !"".equals(request.getParameter("four"))) {
		String checkWord;
		checkWord = request.getParameter("one")
		+ request.getParameter("two")
		+ request.getParameter("three")
		+ request.getParameter("four");
		String xmlresult = word.checkWord(checkWord);
		response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write(xmlresult);
		//System.out.print(xmlresult);
	} else{
		String xmlresult="<resp><word>false</word><game>false</game>"
				+ "<bull>0</bull><cow>0</cow><real>"+word.getQuestionWord()+"</real></resp>";
		response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write(xmlresult);
        //System.out.print(xmlresult);
	}		
%>