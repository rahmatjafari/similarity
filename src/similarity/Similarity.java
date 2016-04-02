package similarity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.helper.Validate;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.Scanner;


public class Similarity {

    public static void main(String[] args) throws IOException {
        
    String s1,s2,str1,str2;
    Scanner scn = new Scanner(System.in);
    System.out.print("Website1:");
    s1 = scn.nextLine();
    System.out.print("Website2:");
    s2 = scn.nextLine();
    Document d1 = Jsoup.connect(s1).get();
    Document d2 = Jsoup.connect(s2).get();
    str1 = d1.body().text();
    str2 = d2.body().text();
    str1 = str1.replaceAll("\\s*\\babout\\b\\s* | \\s*\\bafter\\b\\s* | \\s*\\bas\\b\\s* | \\s*\\bat\\b\\s* | \\s*\\bbefore\\b\\s* | \\s*\\bbut\\b\\s* | \\s*\\bby\\b\\s* | \\s*\\bfrom\\b\\s* | \\s*\\bin\\b\\s* | \\s*\\bof\\b\\s* | \\s*\\bon\\b\\s* | \\s*\\bto\\b\\s* | \\s*\\bam\\b\\s* | \\s*\\bis\\b\\s* | \\s*\\bare\\b\\s* | \\s*\\bwas\\b\\s* | \\s*\\bwere\\b\\s* | \\s*\\bdo\\b\\s* | \\s*\\does\\b\\s* | \\s*\\ba\\b\\s* | \\s*\\bin\\b\\s*", " ");
    str2 = str2.replaceAll("\\s*\\babout\\b\\s* | \\s*\\bafter\\b\\s* | \\s*\\bas\\b\\s* | \\s*\\bat\\b\\s* | \\s*\\bbefore\\b\\s* | \\s*\\bbut\\b\\s* | \\s*\\bby\\b\\s* | \\s*\\bfrom\\b\\s* | \\s*\\bin\\b\\s* | \\s*\\bof\\b\\s* | \\s*\\bon\\b\\s* | \\s*\\bto\\b\\s* | \\s*\\bam\\b\\s* | \\s*\\bis\\b\\s* | \\s*\\bare\\b\\s* | \\s*\\bwas\\b\\s* | \\s*\\bwere\\b\\s* | \\s*\\bdo\\b\\s* | \\s*\\does\\b\\s* | \\s*\\ba\\b\\s* | \\s*\\bin\\b\\s*", " ");
    System.out.println(str1 + "\n" + str2);
    }
    
}
