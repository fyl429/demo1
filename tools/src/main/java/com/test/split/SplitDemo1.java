package com.test.split;

public class SplitDemo1 {
	
	
	
	public static void split(String demo){
		String[] array = demo.split("-");
		int len = array.length;
		for(int i = 0 ;i < len ; i++) {
			if(i<(len-1)) {
				System.out.print(array[i]+",");
			}else {
				System.out.print(array[i]);
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "asadasd-|<>*";
		split(str);
		
	}

}
