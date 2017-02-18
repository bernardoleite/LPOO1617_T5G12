import java.util.Random;
import java.util.Scanner;
import java.util.Vector;



public class jogo {
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	   }  
	
	public static class Matrix1 {
		
		char vec[][];
		int linha = 1, coluna = 1;
		int alcancaS = 0;
		
		public Matrix1(char vetor[][]) {
		      vec = vetor;
		   }

		   void PrintMatrix1() {
			   
			   	int i =0, j = 0;
		    	
		    	for(i = 0; i < 10; i++){
		    		for (j = 0 ; j < 10; j++){
		    			System.out.print (vec[i][j]);
		    			System.out.print(" ");			
		    		}
		    		System.out.print("\n");
		    	}
		    	

		   }
		   
		   void MoverEmNivel1(String letra, int x, int y){
			  
			   if ( letra.equals("W") || letra.equals("w") )
			   {
				   if (vec[x-1][y] == 'X' || vec[x-1][y] == 'I')  ;
				   
				   else if (vec[x-1][y] == 'S') {vec[x][y] = ' '; vec[x-1][y] = 'H'; alcancaS =1; }
				   
				   else if (vec[x-1][y] == ' ') {vec[x][y] = ' '; vec[x-1][y] = 'H'; linha--;}
			   }
			   
			   else  if ( letra.equals("A") || letra.equals("a") )
			   {
				   if (vec[x][y-1] == 'X' || vec[x][y-1] == 'I')  ;
				   
				   else  if (vec[x][y-1] == 'K') {vec[x][y] = ' '; vec[x][y-1] = 'H'; coluna--;}
				   
				   else  if (vec[x][y-1] == 'S') {vec[x][y] = ' '; vec[x][y-1] = 'H'; alcancaS =1; }
				   
				   else if (vec[x][y-1] == ' ') {vec[x][y] = ' '; vec[x][y-1] = 'H'; coluna--;}
			   }
			   
			   else if ( letra.equals("S") || letra.equals("s") )
			   {
				   System.out.println("entrou ");
				   
				   if (vec[x+1][y] == 'X' || vec[x+1][y] == 'I')  ;
				   
				   else if (vec[x+1][y] == ' ') {vec[x][y] = ' '; vec[x+1][y] = 'H'; linha++;}
				   
				   else if (vec[x+1][y] == 'S') {vec[x][y] = ' '; vec[x+1][y] = 'H'; alcancaS =1;}
			   }
			
			   else  if ( letra.equals("D") || letra.equals("d") )
			   {
				   if (vec[x][y+1] == 'X' || vec[x][y+1] == 'I')  ;
				  
				   
				   else if (vec[x][y+1] == ' ')  
				   
				   {
					   
					   vec[x][y] = ' '; vec[x][y+1] = 'H'; coluna++;
				   }
				   
				   else if (vec[x][y+1] == 'S')  
					   
				   {
					   
					   vec[x][y] = ' '; vec[x][y+1] = 'H'; alcancaS =1; 
				   }
				   
				 
			   }
			   
		   }
		   
		   
		   int[] AtualizarCoord()
		   {
			  int v[] =  {linha,coluna};
			  return v;
		   }
		   
		   int VerificaGuarda()
		   {
			   if (vec[linha][coluna+1] == 'G' || vec[linha+1][coluna] == 'G' || vec[linha-1][coluna] == 'G' || vec[linha][coluna-1] == 'G') return 1;
			   
			   else return 0;
		   }
		   
		   int VerificaK()
		   {

			if (vec[8][7] == 'H') 
			{
		    	for(int i = 0; i < 10; i++){
		    		for (int j = 0 ; j < 10; j++){
		    			if (vec[i][j] == 'I') vec[i][j] = 'S';				
		    		}
		    	}
			}
			return 1;
		   }
		   
		   int VerificaSeGanhou()
		   {
			   if (alcancaS == 1) return 1;
			   
			   else return 0;
		   }
		   

		
		   void MoveGuarda(int steps)
		   {
			   
			   if (steps == 1) {
				   vec[1][8] = ' ';
				   vec[1][7] = 'G';
			   }
			   
			   else if (steps == 2) {
				   vec[1][7] = ' ';
				   vec[2][7] = 'G';
			   }
			   
			   else  if (steps == 3) {
				   vec[2][7] = ' ';
				   vec[3][7] = 'G';
			   }
			   
			   else if (steps == 4) {
				   vec[3][7] = ' ';
				   vec[4][7] = 'G';
			   }
			   
			   else if (steps == 5) {
				   vec[4][7] = ' ';
				   vec[5][7] = 'G';
			   }
			   
			   else if (steps == 6) {
				   vec[5][7] = ' ';
				   vec[5][6] = 'G';
			   }
			   
			   else if (steps == 7) {
				   vec[5][6] = ' ';
				   vec[5][5] = 'G';
			   }
			   
			   else if (steps == 8) {
				   vec[5][5] = ' ';
				   vec[5][4] = 'G';
			   }
			   
			   else if (steps == 9) {
				   vec[5][4] = ' ';
				   vec[5][3] = 'G';
			   }
			   
			   else if (steps == 10) {
				   vec[5][3] = ' ';
				   vec[5][2] = 'G';
			   }
			   
			   else if (steps == 11) {
				   vec[5][2] = ' ';
				   vec[5][1] = 'G';
			   }
			   
			   else if (steps == 12) {
				   vec[5][1] = ' ';
				   vec[6][1] = 'G';
			   }
			   
			   else if (steps == 13) {
				   vec[6][1] = ' ';
				   vec[6][2] = 'G';
			   }
			   
			   else if (steps == 14) {
				   vec[6][2] = ' ';
				   vec[6][3] = 'G';
			   }
			   
			   else if (steps == 15) {
				   vec[6][3] = ' ';
				   vec[6][4] = 'G';
			   }
			   
			   else if (steps == 16) {
				   vec[6][4] = ' ';
				   vec[6][5] = 'G';
			   }
			   
			   else if (steps == 17) {
				   vec[6][5] = ' ';
				   vec[6][6] = 'G';
			   }
			   
			   else if (steps == 18) {
				   vec[6][6] = ' ';
				   vec[6][7] = 'G';
			   }
			   
			   else if (steps == 19) {
				   vec[6][7] = ' ';
				   vec[6][8] = 'G';
			   }
			   
			   else if (steps == 20) {
				   vec[6][8] = ' ';
				   vec[5][8] = 'G';
			   }
			   
			   else if (steps == 21) {
				   vec[5][8] = ' ';
				   vec[4][8] = 'G';
			   }
			   
			   else if (steps == 22) {
				   vec[4][8] = ' ';
				   vec[3][8] = 'G';
			   }
			   
			   else if (steps == 23) {
				   vec[3][8] = ' ';
				   vec[2][8] = 'G';
			   }
			   
			   else if (steps == 24) {
				   vec[2][8] = ' ';
				   vec[1][8] = 'G';
			   }
				   
		   
		  

		   }

	}
	
public static class Matrix2 {
		
		char vec[][];
		int linha = 8, coluna = 1;
		int linhaOg = 1, colunaOg = 4;
		int alcancaS = 0; //Se estiver a 1 significa que alcançou o S
		int trancar = 0; //Se estiver a 1 significa que o Ogre está por cima da Key
		int mudarcarater = 0; //Se estiver a 1 significa que o Hero está com a Key
		int porta = 0;		// Se estiver a 1 significa que Hero apanhou a Key (vai ser possivel passar na porta)
		int encontrouExplosivo = 0; //Se estiver a 1 encontrou explosivo e perde
		
		public Matrix2(char vetor[][]) {
		      vec = vetor;
		   }

		   void PrintMatrix2() {
			   
			   	int i =0, j = 0;
		    	
		    	for(i = 0; i < 10; i++){
		    		for (j = 0 ; j < 10; j++){
		    			System.out.print (vec[i][j]);
		    			System.out.print(" ");			
		    		}
		    		System.out.print("\n");
		    	}
		    	

		   }
		   
		   void MoverEmNivel2(String letra, int x, int y, char carater){
			   
			  
			   if ( letra.equals("W") || letra.equals("w") )
			   {
				   if (vec[x-1][y] == 'X' )  ;
				   
				   else if (vec[x-1][y] == 'S') {vec[x][y] = ' '; vec[x-1][y] = carater; alcancaS =1; }
				   
				   else if (vec[x-1][y] == ' ') {vec[x][y] = ' '; vec[x-1][y] = carater; linha--;}
				   
				   else if (vec[x-1][y] == 'K') {vec[x][y] = ' '; porta = 1; vec[x-1][y] = 'K'; mudarcarater++; linha--;}
				   
				   else  if (vec[x-1][y] == 'I' && porta == 1) { vec[x-1][y] = 'S'; }
				   
			   }
			   
			   else  if ( letra.equals("A") || letra.equals("a") )
				   
			   {
				   if (vec[x][y-1] == 'X' )  ;
				   
				   else  if (vec[x][y-1] == 'S' ) {vec[x][y] = ' '; vec[x][y-1] = carater; alcancaS =1; }
				   
				   else  if (vec[x][y-1] == 'K') {vec[x][y] = ' '; porta = 1; vec[x][y-1] = 'K'; mudarcarater++; coluna--;}
				   
				   else  if (vec[x][y-1] == 'I' && porta == 1) {vec[x][y-1] = 'S'; }					   	
				   
				   else if (vec[x][y-1] == ' ') {vec[x][y] = ' '; vec[x][y-1] = carater; coluna--;}
				   
			   }
			   
			   else if ( letra.equals("S") || letra.equals("s") )
			   {
				   
				   if (vec[x+1][y] == 'X')  ;
				   
				   else if (vec[x+1][y] == ' ') {vec[x][y] = ' '; vec[x+1][y] = carater; linha++;}
				   
				   else if (vec[x+1][y] == 'K') {vec[x][y] = ' '; porta = 1; vec[x+1][y] = 'K'; mudarcarater++; linha++;}
				   
				   else if (vec[x+1][y] == 'I' && porta == 1) { vec[x+1][y] = 'S';  }
				   
				   else if (vec[x+1][y] == 'S' ) { vec[x+1][y] = carater; alcancaS =1; }
				   
			   }
			
			   else  if ( letra.equals("D") || letra.equals("d") )
			   {
				   if (vec[x][y+1] == 'X')  ;
				  
				   
				   else if (vec[x][y+1] == ' ')  
				   
				   {
					   
					   vec[x][y] = ' '; vec[x][y+1] = carater; coluna++;
				   }
				   
				   else if (vec[x][y+1] == 'K')  
					   
				   {
					   
					   vec[x][y] = ' '; porta = 1; vec[x][y+1] = 'K'; mudarcarater++; coluna++;
				   }
				   
				   else if (vec[x][y+1] == 'S')  
					   
				   {
					   
					   vec[x][y] = ' '; vec[x][y+1] = carater; alcancaS =1; 
				   }
				   
				   else if (vec[x][y+1] == 'I' && porta == 1) { vec[x][+1] = 'S';  }
				   
				   
				 
			   }
			   
		   }
		   
		   
		   int[] AtualizarCoord()
		   {
			  int v[] =  {linha,coluna};
			  return v;
		   }
		   
		   int[] AtualizarCoordOgre()
		   {
			  int v[] =  {linhaOg,colunaOg};
			  return v;
		   }
		   
		   int VerificaOgre()
		   {
			   if (vec[linha][coluna+1] == 'O' || vec[linha+1][coluna] == 'O' || vec[linha-1][coluna] == 'O' || vec[linha][coluna-1] == 'O') return 1;
			   
			   else return 0;
		   }
		   
		   int VerificaK()
		   {

			if (linha == 1 && coluna == 8) 
			{
		    	porta = 1;
			}
			return 1;
		   }
		   
		   int VerificaSeGanhou()
		   {
			   if (alcancaS == 1) return 1;
			   
			   else return 0;
		   }
		   
		  int Perdeu(){
			  
			  if (vec[linha+1][coluna] == '*') return 1;
			  if (vec[linha][coluna+1] == '*') return 1;
			  if (vec[linha-1][coluna] == '*') return 1;
			  if (vec[linha][coluna-1] == '*') return 1;
			  
			  else return 0;
		  }
		   
		   char VerificaCarater()
		   {
			   if (mudarcarater == 1) return 'K';
			   
			   else return 'H';
		   }
		   
		   void CleanExplosives()
		   {
		    	for(int i = 0; i < 10; i++){
		    		for (int j = 0 ; j < 10; j++){
		    			if(vec[i][j] == '*') vec[i][j] = ' ';
		    		}
		    	}   
		   }
		
		   void MoveOgre(int posisaox, int posicaoy) //Aqui geram-se numeros aleatorios sendo que W,A,S,D sao respetivamente 1,2,3,4
		   {
			   int number = 1 , number2= 1;
			   
			   Random num = new Random();
			   Random num2 = new Random();

		       number = num.nextInt(4)+1;
		       number2 = num.nextInt(4)+1;
		       
		       
		       
		       if(trancar == 1) {vec[1][8] = 'K'; trancar = 0;} //Quando o Ogre trancou a chave com o $
		       
		       
		       if (number == 1) //W
		    	{
		    	    if (vec[linhaOg-1][colunaOg] == 'K') {vec[linhaOg][colunaOg] = ' '; vec[linhaOg-1][colunaOg] = '$'; trancar = 1; linhaOg--;}
		    	    
		    	    else if (vec[linhaOg-1][colunaOg] == ' ' && porta == 0 && trancar == 0) {vec[1][8] = 'K'; vec[linhaOg][colunaOg] = ' '; vec[linhaOg-1][colunaOg] = 'O';  linhaOg--;}
	    
		    	}
		       
		       else if (number == 2) //A
		       {
		    	  if (vec[linhaOg][colunaOg-1] == 'K') {vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg-1] = '$'; trancar =1; colunaOg--;}
		    	  
		    	  else if (vec[linhaOg][colunaOg-1] == ' ' && porta == 0 && trancar == 0) {vec[1][8] = 'K'; vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg-1] = 'O'; colunaOg--;}
		       }
		       
		       else if (number == 3) //S
		       {
		    	  if (vec[linhaOg+1][colunaOg] == 'K') {vec[linhaOg][colunaOg] = ' '; vec[linhaOg+1][colunaOg] = '$'; trancar =1; linhaOg++;}
		    	  
		    	  else if (vec[linhaOg+1][colunaOg] == ' ' && porta == 0 && trancar == 0 ) {vec[1][8] = 'K'; vec[linhaOg][colunaOg] = ' '; vec[linhaOg+1][colunaOg] = 'O'; linhaOg++;}
		       }
		       
		       else if (number == 4) //D
		       {
		    	   
		    	  if (vec[linhaOg][colunaOg+1] == 'K') {vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg+1] = '$'; trancar =1; colunaOg++;}
		    	  
		    	  else if (vec[linhaOg][colunaOg+1] == ' ' && porta == 0 && trancar == 0 ) {vec[1][8] = 'K'; vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg+1] = 'O'; colunaOg++;}
		       }
		       
		       /**Explosivos**/
		       
		       if (number2 == 1) {
		    	   
		    	  if (vec[linhaOg-1][colunaOg] == ' ') {vec[linhaOg-1][colunaOg] = '*';  }   
		    	  
		       }
		       
		       else if (number2 == 2) {
		    	   
			    	  if (vec[linhaOg][colunaOg-1] == ' ') {vec[linhaOg][colunaOg-1] = '*';  }   
			    	  
			       }
		       
		       else if (number2 == 3) {
		    	   
			    	  if (vec[linhaOg+1][colunaOg] == ' ') {vec[linhaOg+1][colunaOg] = '*';  }   
			    	  
			       }
		       
		       else if (number2 == 4) {
		    	   
			    	  if (vec[linhaOg][colunaOg+1] == ' ') {vec[linhaOg][colunaOg+1] = '*';  }   
			    	  
			       }

	
		   }

	}
	
    public static void main(String[] args) {
  
		char aux[][] = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 1º nível*/
    			{'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X'},
    			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
    			{'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
    			{'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
    			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
    			{'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X'},
    			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
    			
    		};
		
		char aux2[][] = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, /*Tabuleiro do 2º nível*/
    			{'I', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'K', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
    			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
    			
    		};
		
		 int pos[] = {1,1};	 	/*Posicao inicial do Hero*/
		 int posOg[] = {1,4};	 	/*Posicao inicial do Ogre*/
		 int GuardSteps = 0; 	/*Passos do Guarda*/
		 int flag1 = 0; 		/*Flag que faz o controlo do nivel 1*/
		 int flag2 = 0;			/*Flag que faz o controlo do nivel 2*/
		
    	Matrix1 obj = new Matrix1 (aux);
    	obj.PrintMatrix1();
    	
   
    	while (flag1 == 0)
    	{
	
    	System.out.printf("Movimento? (W,A,S,D) ");
    	
    	Scanner leitura = new Scanner (System.in);
        
        String mov = leitura.next();

        
        obj.MoverEmNivel1(mov, pos[0], pos[1]);
        
        pos = obj.AtualizarCoord();
        
        GuardSteps++;
        
        obj.MoveGuarda(GuardSteps);
        
        if (GuardSteps == 24) GuardSteps = 0;
    
        if (obj.VerificaGuarda() == 1) {obj.PrintMatrix1(); System.out.println("!!!!GAME OVER!!!!"); flag1 = 1;}
        
        obj.VerificaK() ;
        
        if ( obj.VerificaSeGanhou() == 1) {obj.PrintMatrix1();  flag1 = 1;}
        
        obj.PrintMatrix1();
        
    	}
    	
    	
		 pos[0] = 8;
		 pos[1] = 1;


		
	   	Matrix2 obj2 = new Matrix2 (aux2);
	   	obj2.PrintMatrix2();
	   	char carater = 'H'; //O carater vai mudar para K quando o Hero apanhar a chave
    	
    
    	while (flag2 == 0)
    	{

    		
        	System.out.printf("Movimento? (W,A,S,D) ");
        	
        	Scanner leitura = new Scanner (System.in);
            
            String mov = leitura.next();

            
            obj2.MoverEmNivel2(mov, pos[0], pos[1], carater);
            
           // obj2.VerificaK() ;
           
            obj2.MoveOgre(posOg[0], posOg[1]);
            
            if (obj2.Perdeu() == 1) {System.out.println("!!!!GAME OVER!!!!"); flag2 = 1;}
            
            carater = obj2.VerificaCarater();
            
            pos = obj2.AtualizarCoord();
                     
            posOg = obj2.AtualizarCoordOgre();
            
            if (obj2.VerificaOgre() == 1) {obj2.PrintMatrix2(); System.out.println("!!!!GAME OVER!!!!"); flag2 = 1;}
            
            obj2.VerificaOgre() ;
            
            if ( obj2.VerificaSeGanhou() == 1) {obj2.PrintMatrix2();  System.out.println("!!!!YOU WIN THE GAME!!!!"); flag2 = 1;}
            
            obj2.PrintMatrix2();
            
            obj2.CleanExplosives();
            
            
            
    		
    	}
    	
    	
}
    







}