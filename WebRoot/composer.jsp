<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Composer Information</title>

    <link rel="stylesheet" type="text/css" href="stylesheet.css">
  </head>
  <body>
  <script type="text/javascript">
	alert(request);

  </script>
    <table>
      <tr>
        <th colspan="2">Vehicle Information</th>
      </tr>
      <tr>
        <td>Make: </td>
        <td>${requestScope.composer.firstName}</td>
      </tr>
      <tr>
        <td>Model: </td>
        <td>${requestScope.composer.lastName}</td>
      </tr>
      <tr>
        <td>Code series: </td>
        <td>${requestScope.composer.category}</td>
      </tr>
      <tr>
        <td>Key blank: </td>
        <td>${requestScope.composer.kb}</td>
      </tr>
      <tr>
        <td>Transponder: </td>
        <td>${requestScope.composer.ts}</td>
      </tr>
      <tr>
        <td>Remote: </td>
        <td>${requestScope.composer.remote}</td>
      </tr>
       <tr>
        <td>Fob: </td>
        <td>${requestScope.composer.fob}</td>
      </tr>
        <tr>
        <td>Options HPC: </td>
        <td>${requestScope.composer.hpc}</td>
      </tr>
        <tr>
        <td>X6V8: </td>
        <td>${requestScope.composer.xv}</td>
      </tr>   
    </table>

    <p>Go back to <a href="edit.html" class="link">search page</a>.</p>
  </body>
</html>