/*

Que-4 https://practice.geeksforgeeks.org/problems/run-length-encoding/1/

*/

	String encode(String str)
	{
          StringBuilder sb = new StringBuilder();
          int n = str.length();
          int count = 0;
          char curr = '#';
          for(int i = 0; i < n; i++){
              if(i == 0){
                  curr = str.charAt(i);
                  count++;
              }
              else if(str.charAt(i) == str.charAt(i-1)){
                  count++;
              }
              else if(str.charAt(i) != str.charAt(i-1)){
                  sb.append(curr + "" + count);
                  curr = str.charAt(i);
                  count = 1;
              }
          }
          sb.append(curr + "" + count);
          return sb.toString();
	}
