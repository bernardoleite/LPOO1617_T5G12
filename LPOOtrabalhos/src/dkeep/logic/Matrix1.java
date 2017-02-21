package dkeep.logic;
public class Matrix1 {
		
		char vec[][];
		int linha = 1, coluna = 1;
		int alcancaS = 0;
		
		public Matrix1(char vetor[][]) {
		      vec = vetor;
		   }

		  public void PrintMatrix1() {
			   
			   	int i =0, j = 0;
		    	
		    	for(i = 0; i < 10; i++){
		    		for (j = 0 ; j < 10; j++){
		    			System.out.print (vec[i][j]);
		    			System.out.print(" ");			
		    		}
		    		System.out.print("\n");
		    	}
		    	

		   }
		   
		   public void MoverEmNivel1(String letra, int x, int y){
			  
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
		   
		   
		   public int[] AtualizarCoord()
		   {
			  int v[] =  {linha,coluna};
			  return v;
		   }
		   
		   public int VerificaGuarda()
		   {
			   if (vec[linha][coluna+1] == 'G' || vec[linha+1][coluna] == 'G' || vec[linha-1][coluna] == 'G' || vec[linha][coluna-1] == 'G') return 1;
			   
			   else return 0;
		   }
		   
		   public int VerificaK()
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
		   
		  public int VerificaSeGanhou()
		   {
			   if (alcancaS == 1) return 1;
			   
			   else return 0;
		   }
		   

		
		  public void MoveGuarda(int steps)
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