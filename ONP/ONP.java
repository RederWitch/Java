import java.util.Scanner;

class ONP{
    private StosDouble stack = new StosDouble();
    private StosChar stackChar = new StosChar();
    private String obliczenie;
    private char[] charArray;
    private Scanner odczyt = new Scanner(System.in);
    
    private void add(){
        double x,y;
        x=stack.pops();
        y=stack.pops();
        x=y+x;
        stack.push(x);
    }

    private void subtract(){
        double x,y;
        x=stack.pops();
        y=stack.pops();
        x=y-x;
        stack.push(x);
    }

    private void multiply(){
        double x,y;
        x=stack.pops();
        y=stack.pops();
        x=y*x;
        stack.push(x);
    }

    private void divide(){
        double x,y;
        x=stack.pops();
        y=stack.pops();
        if(x!=0)
        {
            x=y/x;
            stack.push(x);
        }
        else
        {
            System.out.println("UWAGA: Nie można dzielić przez 0\n");
            System.exit(0);
        }

    }

    private void power(){
        double x,y;
        x=stack.pops();
        y=stack.pops();
        x=Math.pow(y,x);
        stack.push(x);
    }

    private void unar(){
        double x;
        x=stack.pops();
        x=0-x;
        stack.push(x);

    }

    private void display(){
        System.out.println("Wartość wyrażenia: " + stack.topElem());
    }

    private int operantPriorites( char ch){
        switch (ch){
            case '+':
            case '-': return 1; 
            case '*':
            case '/': return 2; 
            case '^': return 3; 
            case '~': return 4; 
            default: return 0;
        }
    }
    
    
    public void valueOfONP(){
        obliczenie = odczyt.nextLine();
        charArray = obliczenie.toCharArray();
        for (int i =0; i< charArray.length; i++) {
           if(Character.isDigit(charArray[i])){
               int x = charArray[i]-48;
               int j;
               for(j =i+1; j<charArray.length; j++){
                    if(Character.isDigit(charArray[j])){
                        x=x*10+(charArray[j]-48);
                    }else{ 
                        i=j;
                        break;}
                
               }
               stack.push(x);
           }else{
               switch(charArray[i]){
                   case '+': add(); break;
                   case '-': subtract(); break;
                   case '*': multiply(); break;
                   case '/': divide(); break;
                   case '^': power(); break;
                   case '~': unar(); break;
                   case '=': display(); break;
                   default:  break;
               }
           }
           
        }
    }

    public void toONP(){
        obliczenie = odczyt.nextLine();
        charArray = obliczenie.toCharArray();
        for (int i =0; i< charArray.length; i++) {
            //if(charArray[i] == '=') break;
            if(Character.isDigit(charArray[i])){
            int x = charArray[i]-48;
            int j;
            for(j =i+1; j<charArray.length; j++){
                 if(Character.isDigit(charArray[j])){
                     x=x*10+(charArray[j]-48);
                 }else{ 
                     i=j;
                     break;}
            } 
            System.out.print(x + " ");
            }else if(charArray[i] == '('){ stackChar.push('(');}
            else if(charArray[i] == ')'){
               char ch = stackChar.pops();;
               while(ch != '(' ){
                    System.out.print(ch + " ");
                    ch = stackChar.pops();
               }
            }else {
                if(Character.isWhitespace(charArray[i])) continue;
                if(!stackChar.isEmpty()){
                    while( operantPriorites(stackChar.topElem())>= operantPriorites(charArray[i])){
                        System.out.print(stackChar.pops() + " ");
                        if(stackChar.isEmpty()) break;
                    }
                }
                stackChar.push(charArray[i]);                   
                }
            }
            while(!stackChar.isEmpty()){
            char ch = stackChar.pops();
            System.out.print(ch + " ");
         }
        
    }



}

class Start{
    public static void main(String[] args){
        ONP onp = new ONP();
        Scanner in = new Scanner(System.in);

        System.out.println("\nWitam");
        
        while(true){
            System.out.println("\n\n Dostępne opcje to:\n\t1.Konwersja wyrażenia do ONP\n\t2.Obliczenie wartości wyrażenia podanego w ONP\n\t3.Zakońćzenie Programu");        
            int choice = in.nextInt();
            switch(choice){
                case 1: 
                    System.out.println("Wybrałeś konwersję wyrażenia do ONP\nPodaj wyrażenie:");
                    onp.toONP(); break;
                case 2: 
                    System.out.println("Wybrałeś obliczenie wartości wyrażenia podanego w ONP\nPodaj wyrażenie w ONP:");
                    onp.valueOfONP(); break;
                case 3: in.close(); System.exit(1);
                default:
                    System.out.println("Brak takiej opcji, spróbuj jescze raz");
                    break;
            }
        }
    }   
}
