package stackQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveConsecutiveNumber {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        RemoveConsecutiveNumber   removeConsecutiveNumber = new RemoveConsecutiveNumber();
        removeConsecutiveNumber.solve(list);

        String st = "geeksforgeeks";
        List<Character> data =  st.chars()           // Create an IntStream of the character codes
                .mapToObj(c -> (char) c)   // Convert each int to a Character
                .collect(Collectors.toList());
        removeConsecutiveNumber.solveTwo(data);
    }

    public void solve(List<Integer> list){
        Stack<Integer> stack = new Stack<Integer>();
        Integer previous = null;
         for(Integer num : list){

             if( !stack.isEmpty() && stack.peek()==num) {
                 while (!stack.isEmpty() && stack.peek() == num) {
                        stack.pop();
                 }
             }
             else {
                 stack.push(num);
             }

         }

        System.out.println(stack);

    }
    public void solveTwo(List<Character> list){
        Stack<Character> stack = new Stack<Character>();
        Integer previous = null;
        for(Character num : list){

            if( !stack.isEmpty() && stack.peek()==num) {
                while (!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                }
                stack.push(num);

            }
            else {
                stack.push(num);
            }

        }

        String result = "";
        while (!stack.isEmpty()){
            char t =  stack.pop() ;
            result = Character.toString(t)+result;
        }
        System.out.println(result);


    }
}
