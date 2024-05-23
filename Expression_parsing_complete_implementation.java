import java.util.Stack;

public class Expression_parsing_complete_implementation {

    // char stack
    static Stack<Character> stack = new Stack<>();
    static void push(char item) {
        stack.push(item);
    }
    static char pop() {
        return stack.pop();
    }
    // returns precedence of operators
    static int precedence(char symbol) {
        return switch (symbol) {
            case '+', '-' -> 2;
            case '*', '/' -> 3;
            case '^' -> 4;
            case '(', ')', '#' -> 1;
            default -> 0;
        };
    }
    // check whether the symbol is an operator
    static int isOperator(char symbol) {
        return switch (symbol) {
            case '+', '-', '*', '/', '^', '(', ')' -> 1;
            default -> 0;
        };
    }
    // converts infix expression to postfix
    static void convert(String infix, StringBuilder postfix) {
        int j = 0;
        stack.push('#');
        for (char symbol : infix.toCharArray()) {
            if (isOperator(symbol) == 0) {
                postfix.append(symbol);
                j++;
            } else {
                if (symbol == '(') {
                    push(symbol);
                } else {
                    if (symbol == ')') {
                        while (stack.peek() != '(') {
                            postfix.append(pop());
                            j++;
                        }
                        stack.pop(); // pop out '('
                    } else {
                        if (precedence(symbol) > precedence(stack.peek())) {
                            push(symbol);
                        } else {
                            while (precedence(symbol) <= precedence(stack.peek())) {
                                postfix.append(pop());
                                j++;
                            }
                            push(symbol);
                        }
                    }
                }
            }
        }
        while (stack.peek() != '#') {
            postfix.append(pop());
            j++;
        }
    }
    // evaluates postfix expression
    static int evaluate(String postfix) {
        Stack<Integer> stackInt = new Stack<>();
        int operand1, operand2;
        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stackInt.push(ch - '0'); // Push the operand
            } else {
                // Operator, pop two operands
                operand2 = stackInt.pop();
                operand1 = stackInt.pop();
                switch (ch) {
                    case '+':
                        stackInt.push(operand1 + operand2);
                        break;
                    case '-':
                        stackInt.push(operand1 - operand2);
                        break;
                    case '*':
                        stackInt.push(operand1 * operand2);
                        break;
                    case '/':
                        stackInt.push(operand1 / operand2);
                        break;
                }
            }
        }
        return stackInt.peek();
    }

    public static void main(String [] args){

        String infix = "1*(2+3)";
        StringBuilder postfix = new StringBuilder();
        convert(infix, postfix);
        System.out.println("Infix expression is: " + infix);
        System.out.println("Postfix expression is: " + postfix);
        System.out.println("Evaluated expression is: " + evaluate(postfix.toString()));
    }

}
