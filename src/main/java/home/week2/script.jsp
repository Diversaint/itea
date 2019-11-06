<%@ page import = "java.util.Map, java.util.List, java.util.ArrayList" %>
<%

    Map<String, String[]> parameters = request.getParameterMap();
    List <Integer> values = new ArrayList<>();
    boolean error = false;


    for(String parameter : parameters.keySet()) {
        String parameterValue = request.getParameter(parameter);
        if (parameterValue.isEmpty()) {
            if (parameter.contains("i")) {
                values.add(30);
                continue;
            }
            else
                out.write("<h1 style='color:red'>Error! Please enter number of " + parameter + "!</h1>");
            error = true;
            break;
        }
        try{
            values.add(Integer.valueOf(parameterValue));
        } catch (Exception e) {
            out.write("<h1 style='color:red'>Error! Do not enter string in " + parameter + "! Try again</h1>");
            error = true;
            break;
        }
    }

    if (!error) {

        StringBuilder resultHtml = new StringBuilder("<div style='width:600px; margin:20px auto;'>");

        resultHtml.append("<table class='table' border='1'");
        resultHtml.append("width='" + values.get(3) + "px;'");
        resultHtml.append("><tbody>");

        for (int row = 0; row < values.get(0); row++) {
            resultHtml.append("<tr>");

            for (int column = 0; column < values.get(1); column++) {
                resultHtml.append("<td align='center'");

                resultHtml.append("height='" + values.get(2) + "px;'");

                if ((row + 1) * (column + 1) % 3 == 0) {
                    if (row == column) {
                        resultHtml.append("bgcolor='green'");
                    }
                    resultHtml.append("bgcolor='yellow'");
                }
                if (row == column) {
                    resultHtml.append("bgcolor='blue'");
                }

                resultHtml.append(">");

                resultHtml.append((row + 1) + ":" + (column + 1));

                resultHtml.append("</td>");
            }

            resultHtml.append("</tr>");
        }

        resultHtml.append("</table></tbody></div>");
        out.write(resultHtml.toString());
    }
%>
