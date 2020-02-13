class StosDouble{
    final private int maxlength=50;
    double[] S = new double[maxlength];
    int Top;//szczyt stosu

    public StosDouble(){
        this.Top = -1;
    }

    public void push(double x){
        Top+=1;
        if(Top!=maxlength){
            S[Top]=x;
        }else{
            System.out.println("UWAGA\nStos jest pełen\n");
        }
    }

    public void pop(){
        if(!isEmpty()){
             Top-=1;
        }else{
            System.out.println("UWAGA\nStos jest pusty");
        }
        
    }

    
    public double pops(){
        double elem = topElem();
        this.pop();
        return elem;
    }
    public boolean isEmpty(){
        if(Top ==-1) return true;
        return false;
    }
    
    public double topElem(){
        return S[Top];
    }

    public void makeEmpty(){
        Top=-1;
    }
        void printStack(){
            if(Top == -1){
                System.out.println("Stos jest pusty\n");
                return;
            }
            for(int i=0; i<=Top; i++){
                System.out.print(S[i] + "\t");
            }
            System.out.println();
        } 

}

class StosChar{
    final private int maxlength=50;
    char[] S = new char[maxlength];
    int Top;//szczyt stosu

    public StosChar(){
        this.Top = -1;
    }

    public void push(char x){
        Top+=1;
        if(Top!=maxlength){
            S[Top]=x;
        }else{
            System.out.println("UWAGA\nStos jest pełen\n");
        }
    }

    public void pop(){
        if(!isEmpty()){
             Top-=1;
        }else{
            System.out.println("UWAGA\nStos jest pusty");
        }
        
    }

    
    public char pops(){
        char elem = topElem();
        this.pop();
        return elem;
    }
    public boolean isEmpty(){
        if(Top ==-1) return true;
        return false;
    }
    
    public char topElem(){
        return S[Top];
    }

    public void makeEmpty(){
        Top=-1;
    }
        void printStack(){
            if(Top == -1){
                System.out.println("Stos jest pusty\n");
                return;
            }
            for(int i=0; i<=Top; i++){
                System.out.print(S[i] + "\t");
            }
            System.out.println();
        } 

}

