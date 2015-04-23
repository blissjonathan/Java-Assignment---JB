import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {

	
		public static void main(String[] args) throws IOException {
		String word;
		boolean l1 = false;
		boolean l2 = false;
		boolean l3 = false;
		String w1 = null;
		String w2 = null;
		String w3 = null;
		String cLine;
		int sLine = 0;
		int sCount = 0;
		String haiku = "";
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Jonathan/My Documents/haikuwords.txt"));

		
		while((cLine = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(cLine, " ");
		
			while(st.hasMoreTokens()) {
				word = st.nextToken();
				String p1 = "";
				String p2 = "";
				String p3 = "";
				p1= p1+word;
				sCount = sCount + countSyllables(word);
				
				if(sLine==5) {
					while(st.hasMoreTokens()==true) {
						int sCount2= 0;
						String word2 = st.nextToken();
						sCount2 = sCount2 + countSyllables(word2);
						if(sCount2==7) {
							while(st.hasMoreTokens()) {
							int sCount3 = 0;
							sCount3 = sCount3 + countSyllables(st.nextToken());
							if(sCount3==5) {
								System.out.println("Haiku found");
							}
							}
						}
					}
				} else {
				p1 = "";
				p2="";
				p3="";
				}
			}
			
			System.out.println("w1: " + l1);
			System.out.println("w2: " + l2);
			System.out.println("w3: " + l3);
		sLine = 0;	
	}
}
		
		
		
		
		public static int countSyllables(String word) {
		    int count = 0;
		    word = word.toLowerCase();
		    for (int i = 0; i < word.length(); i++) {
		        if (word.charAt(i) == '\"' || word.charAt(i) == '\'' || word.charAt(i) == '-' || word.charAt(i) == ',' || word.charAt(i) == ')' || word.charAt(i) == '(') {
		            word = word.substring(0,i)+word.substring(i+1, word.length());
		        }
		    }
		    boolean isPrevVowel = false;
		    for (int j = 0; j < word.length(); j++) {
		        if (word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u")) {
		            if (isVowel(word.charAt(j)) && !((word.charAt(j) == 'e') && (j == word.length()-1))) {
		                if (isPrevVowel == false) {
		                    count++;
		                    isPrevVowel = true;
		                }
		            } else {
		                isPrevVowel = false;
		            }
		        } else {
		            count++;
		            break;
		        }
		    }
		    return count;
		}
		
		
		public static boolean isVowel(char c) {
	        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
	            return true;
	        } else {
	            return false;
	        }
	    }
}
