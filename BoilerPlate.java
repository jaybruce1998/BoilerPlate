/*Alright buddy, open cmd, go to the folder with this shitty code (using the cd command), then type:
java BoilerPlate YourClassName typeofvariable1 variablename1 typeofvariable2 variablename2 etc. etc.
*/
import java.io.FileOutputStream;
class NoahException extends RuntimeException
{
   public NoahException(String m)
   {
      super(m);
   }
}
class MasoneerException extends NoahException
{
   public MasoneerException(String m)
   {
      super(m);
   }
}
public class BoilerPlate
{
   public static void main(String[] a)
   {
      if(a.length%2==0)
         throw new NoahException("Buddy, you are FUCKING AROUND!\nRun it from the command line WITH all the garbage!");
      String r="public class "+a[0]+"\n{", g="", c="", m="", s="";
      for(int i=1; i<a.length; i+=2)
      {
         String v=a[i+1], f=a[i]+" "+v, u=v.substring(0, 1).toUpperCase()+v.substring(1);
         r+="\n\tprivate "+f+";";
         g+=", "+f;
         c+="\n\t\tthis."+v+"="+v+";";
         m+="\n\tpublic "+a[i]+" get"+u+"()\n\t{\n\t\treturn "+v+";\n\t}\n\tpublic void set"+u+"("+f+")\n\t{\n\t\tthis."+v+"="+v+";\n\t}";
         s+="\n\t\t\t+\""+u+": \"+"+v+"+\"\\n\"";
      }
      r+="\n\tpublic "+a[0]+"("+g.substring(2)+")\n\t{"+c+"\n\t}"+m+"\n\tpublic String toString()\n\t{\n\t\treturn "+s.substring(5, s.length()-5)+";\n\t}\n}";
      try
      {
         FileOutputStream outputStream = new FileOutputStream(a[0]+".java");
         outputStream.write(r.getBytes());
         outputStream.close();
      }
      catch(Exception e)
      {
         throw new MasoneerException("Sorry buddy, something shitty happened. Contact your local masoneers for guidance");
      }
   }
}