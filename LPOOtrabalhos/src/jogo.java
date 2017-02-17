import java.util.Random;
import java.util.Scanner;
import java.util.Vector;



public class jogo {
	
	public static class Matrix {
		
		char vec[][];
		int linha = 1, coluna = 1;
		
		public Matrix(char vetor[][]) {
		      vec = vetor;
		   }

		   void PrintMatrix() {
			   
			   	int i =0, j = 0;
		    	
		    	for(i = 0; i < 10; i++){
		    		for (j = 0 ; j < 10; j++){
		    			System.out.print (vec[i][j]);
		    			System.out.print(" ");			
		    		}
		    		System.out.print("\n");
		    	}
		    	

		   }
		   
		   void MovimentoTab(String letra, int x, int y){
			  
			   if ( letra.equals("W") || letra.equals("w") )
			   {
				   if (vec[x-1][y] == 'X' || vec[x-1][y] == 'D')  ;
				   
				   else if (vec[x-1][y] == ' ') {vec[x][y] = ' '; vec[x-1][y] = 'H'; linha--;}
			   }
			   
			   else  if ( letra.equals("A") || letra.equals("a") )
			   {
				   if (vec[x][y-1] == 'X' || vec[x][y-1] == 'D')  ;
				   
				   else if (vec[x][y-1] == ' ') {vec[x][y] = ' '; vec[x][y-1] = 'H'; coluna--;}
			   }
			   
			   else if ( letra.equals("S") || letra.equals("s") )
			   {
				   System.out.println("entrou ");
				   
				   if (vec[x+1][y] == 'X' || vec[x+1][y] == 'D')  ;
				   
				   else if (vec[x+1][y] == ' ') {vec[x][y] = ' '; vec[x+1][y] = 'H'; linha++;}
			   }
			
			   else  if ( letra.equals("D") || letra.equals("d") )
			   {
				   if (vec[x][y+1] == 'X' || vec[x][y+1] == 'D')  ;
				   
				   else if (vec[x][y+1] == ' ')  
				   
				   {
					   vec[x][y] = ' '; vec[x][y+1] = 'H'; coluna++;
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
		  

		}

  
    public static void main(String[] args) {
  
		char aux[][] = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
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
		
		 int pos[] = {1,1};
		
    	Matrix obj = new Matrix (aux);
    	obj.PrintMatrix();
    	
   
    	for (int k = 0; k < 50; k++)
    	{
	
    	System.out.printf("Movimento? ");
    	
    	Scanner leitura = new Scanner (System.in);
        
        String mov = leitura.next();

        
        obj.MovimentoTab(mov, pos[0], pos[1]);
        
        pos = obj.AtualizarCoord();
        
        if (obj.VerificaGuarda() == 1) {System.out.println("!!!!GAME OVER!!!!"); obj.PrintMatrix(); break;}
        
        obj.PrintMatrix();
        
    	}
}
    







}