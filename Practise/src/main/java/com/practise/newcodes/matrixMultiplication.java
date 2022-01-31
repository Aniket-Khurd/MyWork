package com.practise.newcodes;

public class matrixMultiplication {
	
	public static void main(String[] args) {
		int [][] a = {{2,3},{4,5}};
		int[][] b = {{3,6},{5,6}};
		
		int c[][] = new int[2][2];
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b.length; j++) {
				for(int k=0; k<a.length; k++) {
					c[i][j]+=a[i][k]*b[k][j];
				}
				
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}

}
