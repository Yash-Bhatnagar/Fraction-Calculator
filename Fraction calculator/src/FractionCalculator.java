import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args) {

        {
            System.out.println("This program is a fraction calculator");
            System.out.println("It will add, subtract, multiply and divide fractions until you type q or Q to Quit!!");
            System.out.println("Please enter your fractions in the form of a/b where a and b are integers.");
        }
        String opr= getOperation();
        int ctr=0;
        boolean t=false;
        while(!opr.equalsIgnoreCase("q"))
        {
            Fraction f1= getFraction1();
            Fraction f2= getFraction2();
            Fraction f3=new Fraction();
            if (opr.equals("+"))
            {
                f3=f1.add(f2);
            }
            else if (opr.equals("-"))
            {
                f3=f1.sub(f2);
            }
            else if (opr.equals("*"))
            {
                f3=f1.multiply(f2);
            }
            else if (opr.equals("/"))
            {
                f3=f1.div(f2);
            }
            if (opr.equals("="))
            {
                ctr++;
                t=f1.equals(f2);
            }
            f3=f3.simplify();
            if (ctr==0)
                System.out.println(f1+" "+opr+" "+f2+" = "+f3);
            else
            {
                ctr=0;
                if (t)
                    System.out.println("Equal Fractions");
                else
                    System.out.println("Unequal Fractions");
            }
            opr=getOperation();
        }



    }
    public static Fraction getFraction1()
    {
        int num,denom;
        Fraction myfrac;
        Scanner sc1=new Scanner(System.in);
        System.out.print("Please enter a fraction a/b or a :");
        String inp1=sc1.next();
        if (validFraction(inp1))
        {
            if (inp1.contains("/"))
            {
                num= Integer.parseInt(inp1.substring(0,inp1.indexOf('/')));
                denom=Integer.parseInt(inp1.substring(inp1.indexOf('/')+1));
                myfrac= new Fraction(num,denom);
            }
            else {
                num=Integer.parseInt(inp1);
                myfrac=new Fraction(num);
            }
            return myfrac;
        }
        else
        {
            System.out.print("Invalid Input ");
            getFraction1();
        }

    return new Fraction();
    }
    public static Fraction getFraction2()
    {
        int num,denom;
        Fraction myfrac;
        Scanner sc1=new Scanner(System.in);
        System.out.print("Please enter a fraction a/b or a :");
        String inp1=sc1.next();
        if (validFraction(inp1))
        {
            if (inp1.contains("/"))
            {
                num= Integer.parseInt(inp1.substring(0,inp1.indexOf('/')));
                denom=Integer.parseInt(inp1.substring(inp1.indexOf('/')+1));
                myfrac= new Fraction(num,denom);
            }
            else {
                num=Integer.parseInt(inp1);
                myfrac=new Fraction(num);
            }
            return myfrac;
        }
        else
        {
            System.out.print("Invalid Input ");
            getFraction2();
        }

    return new Fraction();
    }

    public static String getOperation()
    {
        Scanner sc=new Scanner(System.in);
        String opr;
        System.out.println("-----------------------------------------------------------------------------------------------------");
        loop:
            while(true)
            {

                System.out.print("Please enter an operation ( + , - , / , * , = , q or Q to quit) : ");
                opr=sc.next();

                    if (opr.equals("+")||opr.equals("-")||opr.equals("/")||opr.equals("*")||opr.equals("=")||opr.equalsIgnoreCase("q"))
                    {
                        break loop;
                    }
                    else
                    {
                        System.out.print("Invalid operation  :  ");
                    }
            }
        return opr;
    }

    public static boolean validFraction(String inp)
    {
        //Removes "-" sign
        if (inp.contains("-"))
        {
            for (int i=0;i<inp.length();i++)
            {
                if (inp.charAt(i)=='-')
                {
                    if (i==0){
                        inp=inp.substring(1);
                    }
                    else if (inp.charAt(i-1)=='/'){
                        inp=inp.substring(0,i)+inp.substring(i+1);
                    }
                    else
                        return false;
                }
            }
        }

        if (inp.contains("/"))
        {
            int a=inp.indexOf('/');
            int b=inp.lastIndexOf('/');
            if(a==b)
            {
                String s1=inp.substring(0,a);
                String s2=inp.substring(a+1);
                if (isNumber(s1) && isNumber(s2))
                {
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        }

        else {
            if (isNumber(inp))
                return true;
            else
                return false;
        }

    }

    public static boolean isNumber(String inp)
    {
        for (int i=0;i<inp.length();i++)
        {
            if (inp.charAt(i)=='1'||inp.charAt(i)=='2'||inp.charAt(i)=='3'||inp.charAt(i)=='4'||inp.charAt(i)=='5'||inp.charAt(i)=='6'||inp.charAt(i)=='7'||inp.charAt(i)=='8'||inp.charAt(i)=='9'||inp.charAt(i)=='0');
            else {
                return false;
            }
        }
        return true;
    }

}
