package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("calcServlet已调用");
        req.setCharacterEncoding("utf-8");
        String equation = req.getParameter("equation");
        req.setAttribute("equation", equation);
        System.out.println("equation: " + equation);
        int number1;
        String string1;
        int index = check(equation);

        string1 = equation.substring(0, index);
        number1 = Integer.parseInt(string1);
        System.out.println("string1: " + string1);
        System.out.println("number1: " + number1);

        System.out.println("index: "+ index);

        char calcChar = equation.charAt(index);
        System.out.println("运算符号: " + calcChar);

        String string2 = equation.substring(index + 1);
        int number2 = Integer.parseInt(string2);
        System.out.println("string2: " + string2);
        System.out.println("number2: " + number2);

        int calcResult;


        String result;
        switch (calcChar) {
            case '+':
                calcResult = number1 + number2;
                result = String.valueOf(calcResult);
                break;
            case '-':
                calcResult = number1 - number2;
                result = String.valueOf(calcResult);
                break;
            case '*':
                calcResult = number1 * number2;
                result = String.valueOf(calcResult);
                break;
            case '/':
                calcResult = number1 / number2;
                result = String.valueOf(calcResult);
                break;
            default:
                result = "输入有误";
        }
        System.out.println("result: " + result);
        req.setAttribute("result", result);
        req.getRequestDispatcher("welcome.jsp").forward(req, resp);

    }

    private int check(String equation) {
        for (int i = 0; i < equation.length(); i++) {
            String str = String.valueOf(equation.charAt(i));
            if (Character.isDigit(equation.charAt(i))) {
                int number1 = Integer.parseInt(str);
                System.out.println("第" + i + "个number: " + number1);
            } else {
                System.out.println("检索到非int");
                return i;
            }
            System.out.println("第" + i + "个str: " + str);
        }
        return 0;
    }
}
