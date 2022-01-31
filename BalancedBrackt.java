import java.util.*;
 
public class BalancedBrackt{
 
    public boolean isThisBracketBalance(String exp)
    {
        
        Deque<Character> stack= new ArrayDeque<Character>();
 
        for (int i = 0; i < exp.length(); i++)
        {
            char x = exp.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {

                stack.push(x);
                continue;
            }
 
        
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 

        return (stack.isEmpty());
    }
 
    public static void main(String[] args)
    {
	BalancedBrackt blb=new BalancedBrackt();
	Scanner read=new Scanner(System.in);
	System.out.println("Enter the brackets to checked if it is balanced :-   ");
        String exp = read.nextLine();
 
        if (blb.isThisBracketBalance(exp))
            System.out.println("The entered bracket has Balanced Brackets");
        else
            System.out.println("The entered bracket do not contain Balanced Brackets ");
    }
}