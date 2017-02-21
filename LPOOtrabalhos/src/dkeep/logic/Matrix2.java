package dkeep.logic;
import java.util.Random;

public class Matrix2 {
		
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

		  public void PrintMatrix2() {
			   
			   	int i =0, j = 0;
		    	
		    	for(i = 0; i < 10; i++){
		    		for (j = 0 ; j < 10; j++){
		    			System.out.print (vec[i][j]);
		    			System.out.print(" ");			
		    		}
		    		System.out.print("\n");
		    	}
		    	

		   }
		   
		   public void MoverEmNivel2(String letra, int x, int y, char carater){
			   
			  
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
		   
		   
		   public int[] AtualizarCoord()
		   {
			  int v[] =  {linha,coluna};
			  return v;
		   }
		   
		   public int[] AtualizarCoordOgre()
		   {
			  int v[] =  {linhaOg,colunaOg};
			  return v;
		   }
		   
		   public int VerificaOgre()
		   {
			   if (vec[linha][coluna+1] == 'O' || vec[linha+1][coluna] == 'O' || vec[linha-1][coluna] == 'O' || vec[linha][coluna-1] == 'O') return 1;
			   
			   else return 0;
		   }
		   
		   public int VerificaK()
		   {

			if (linha == 1 && coluna == 8) 
			{
		    	porta = 1;
			}
			return 1;
		   }
		   
		   public int VerificaSeGanhou()
		   {
			   if (alcancaS == 1) return 1;
			   
			   else return 0;
		   }
		   
		  public int Perdeu(){
			  
			  if (vec[linha+1][coluna] == '*') return 1;
			  if (vec[linha][coluna+1] == '*') return 1;
			  if (vec[linha-1][coluna] == '*') return 1;
			  if (vec[linha][coluna-1] == '*') return 1;
			  
			  else return 0;
		  }
		   
		   public char VerificaCarater()
		   {
			   if (mudarcarater == 1) return 'K';
			   
			   else return 'H';
		   }
		   
		   public void CleanExplosives()
		   {
		    	for(int i = 0; i < 10; i++){
		    		for (int j = 0 ; j < 10; j++){
		    			if(vec[i][j] == '*') vec[i][j] = ' ';
		    		}
		    	}   
		   }
		
		  public void MoveOgre(int posisaox, int posicaoy) //Aqui geram-se numeros aleatorios sendo que W,A,S,D sao respetivamente 1,2,3,4
		   {
			   int number = 1 , number2= 1;
			   
			   Random num = new Random();
			   Random num2 = new Random();

		       number = num.nextInt(4)+1;
		       number2 = num.nextInt(4)+1;
		       
		       
		       
		       if(trancar == 1) {vec[1][8] = 'K'; trancar = 0;} //Quando o Ogre trancou a chave com o $
		       
		       
		       if (number == 1) //W
		    	{
		    	    if (vec[linhaOg-1][colunaOg] == 'K' && porta == 0) {vec[linhaOg][colunaOg] = ' '; vec[linhaOg-1][colunaOg] = '$'; trancar = 1; linhaOg--;}
		    	    
		    	    else if (vec[linhaOg-1][colunaOg] == ' '  && trancar == 0) { vec[linhaOg][colunaOg] = ' '; vec[linhaOg-1][colunaOg] = 'O';  linhaOg--;}
	    
		    	}
		       
		       else if (number == 2) //A
		       {
		    	  if (vec[linhaOg][colunaOg-1] == 'K' && porta == 0) {vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg-1] = '$'; trancar =1; colunaOg--;}
		    	  
		    	  else if (vec[linhaOg][colunaOg-1] == ' '  && trancar == 0) { vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg-1] = 'O'; colunaOg--;}
		       }
		       
		       else if (number == 3) //S
		       {
		    	  if (vec[linhaOg+1][colunaOg] == 'K' && porta == 0) {vec[linhaOg][colunaOg] = ' '; vec[linhaOg+1][colunaOg] = '$'; trancar =1; linhaOg++;}
		    	  
		    	  else if (vec[linhaOg+1][colunaOg] == ' '  && trancar == 0 ) { vec[linhaOg][colunaOg] = ' '; vec[linhaOg+1][colunaOg] = 'O'; linhaOg++;}
		       }
		       
		       else if (number == 4) //D
		       {
		    	   
		    	  if (vec[linhaOg][colunaOg+1] == 'K' && porta == 0) {vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg+1] = '$'; trancar =1; colunaOg++;}
		    	  
		    	  else if (vec[linhaOg][colunaOg+1] == ' '  && trancar == 0 ) { vec[linhaOg][colunaOg] = ' '; vec[linhaOg][colunaOg+1] = 'O'; colunaOg++;}
		       }
		       
		       /**Explosivos**/
		       
		       if (porta == 0) {vec[1][8] = 'K';}
		    	   
		       if (number2 == 1) {
		       
		    	  if (vec[linhaOg-1][colunaOg] == ' ') {vec[linhaOg-1][colunaOg] = '*';  }   
		    	  else if (vec[linhaOg-1][colunaOg] == 'K' && porta == 0) {vec[linhaOg-1][colunaOg] = '$';  }
		    	  
		       }
		       
		       else if (number2 == 2) {
		    	   
			    	  if (vec[linhaOg][colunaOg-1] == ' ') {vec[linhaOg][colunaOg-1] = '*';  }
			    	  else if (vec[linhaOg][colunaOg-1] == 'K' && porta == 0) {vec[linhaOg][colunaOg-1] = '$';  }
			    	  
			       }
		       
		       else if (number2 == 3) {
		    	   
			    	  if (vec[linhaOg+1][colunaOg] == ' ') {vec[linhaOg+1][colunaOg] = '*';  }   
			    	  else if (vec[linhaOg+1][colunaOg] == 'K' && porta == 0) {vec[linhaOg+1][colunaOg] = '$';  }  
			    	  
			       }
		       
		       else if (number2 == 4) {
		    	   
			    	  if (vec[linhaOg][colunaOg+1] == ' ') {vec[linhaOg][colunaOg+1] = '*';  } 
			    	  else  if (vec[linhaOg][colunaOg+1] == 'K'&& porta == 0) {vec[linhaOg][colunaOg+1] = '$';  }  
			    	  
			       }

	
		   }

	}