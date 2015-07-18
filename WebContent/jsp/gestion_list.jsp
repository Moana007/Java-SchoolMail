<%@ page import="java.util.ArrayList" %>
<%@ page import="listContact.ListContact" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p> Ici la gestion des listes ! </p>
<%-- <%! @SuppressWarnings("unchecked") %> --%>
<% ArrayList<ListContact> li=(ArrayList<ListContact>)(request.getAttribute("liste")); %>
<%= (li.get(0)).getNom() %>

<table>
	<tr><td>test</td></tr>
</table>

</body>
</html>