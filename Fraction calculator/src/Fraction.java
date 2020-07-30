import javax.swing.*;

public class Fraction {
    private int num,denom;

    public Fraction(int num,int denom)
    {
        if (denom==0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            if (denom<0)
            {
                num = -num;
                this.denom = -denom;
            }
            else
            {
                this.denom = denom;
            }
            this.num=num;
        }
    }
    public Fraction(int num)
    {
        this.num=num;
        this.denom=1;
    }
    public Fraction()
    {
        this.num=0;
        this.denom=1;
    }

    public static int getNum()
    {
        return 0;
    }
    public Fraction add(Fraction f2)
    {
        int a1,a2,b1,b2,NUM,DENOM;
        a1=this.num;
        a2=f2.num;
        b1=this.denom;
        b2=f2.denom;
        NUM=a1*b2+b1*a2;
        DENOM=b1*b2;
        return new Fraction(NUM,DENOM);
    }
    public Fraction sub(Fraction f2)
    {
        int a1,a2,b1,b2,NUM,DENOM;
        a1=this.num;
        a2=f2.num;
        b1=this.denom;
        b2=f2.denom;
        NUM=a1*b2-b1*a2;
        DENOM=b1*b2;
        if (NUM==0)
            DENOM=1;
        return new Fraction(NUM,DENOM);
    }
    public Fraction div(Fraction f2)
    {
        int a1,a2,b1,b2,NUM,DENOM;
        a1=this.num;
        a2=f2.num;
        b1=this.denom;
        b2=f2.denom;
        NUM=a1*b2;
        DENOM=a2*b1;

        return new Fraction(NUM,DENOM);
    }
    public Fraction multiply(Fraction f2)
    {
        int a1,a2,b1,b2,NUM,DENOM;
        a1=this.num;
        a2=f2.num;
        b1=this.denom;
        b2=f2.denom;
        NUM=a1*a2;
        DENOM=b1*b2;
        return new Fraction(NUM,DENOM);
    }

    public Fraction simplify()
    {
        int ctr=0;
        int num= this.num;
        int denom=this.denom;
        if (num<0)
        {
            num=-num;
            ctr++;
        }
        for (int a=2;a<=num&&a<=denom;a++)
        {
            if (num %a==0 && denom % a==0)
            {
                num=num/a;
                denom=denom/a;
                a--;
            }
        }
        if (ctr==1)
            num=-num;
        return new Fraction(num,denom);
    }

    public boolean equals(Fraction f2)
    {
        Fraction f1=this.simplify();
        f2=f2.simplify();
        if (f1.num==f2.num&&f1.denom==f2.denom)
        {
            return true;
        }
        else
            return false;

    }

    public String toString()
    {
        return ""+this.num+"/"+this.denom;
    }


}
