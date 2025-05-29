package Etapa3;

public class Etapa3 {
    public boolean checkBrackets(Stack<Character> s1) {
        Stack<Character> aux = new StaticStack<>(s1.numElements());

        while(!s1.isEmpty()) {
            char ch = s1.pop();

            if(ch == ')') {
                aux.push(ch);
                
            } else if(ch == '(') {
                if(aux.isEmpty()) {
                    return false;
                }
                
                aux.pop();
            }
        }
        
        return aux.isEmpty();
    }
}
