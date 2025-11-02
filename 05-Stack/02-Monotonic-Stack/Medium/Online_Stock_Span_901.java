import java.util.*;

public class Online_Stock_Span_901 {
    Stack<int[]> stack; // {price, span}

    public Online_Stock_Span_901() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        // Merge spans of previous smaller prices
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        Online_Stock_Span_901 stock = new Online_Stock_Span_901();
        System.out.println(stock.next(100)); // 1
        System.out.println(stock.next(80));  // 1
        System.out.println(stock.next(60));  // 1
        System.out.println(stock.next(70));  // 2
        System.out.println(stock.next(60));  // 1
        System.out.println(stock.next(75));  // 4
        System.out.println(stock.next(85));  // 6
    }
}
