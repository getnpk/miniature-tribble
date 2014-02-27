class Fraction:
    
    def __init__(self, num, den):
        self.num = num
        self.den = den
    
    def show(self):
        print self.num,  "/",  self.den
    
    def __str__(self):
        return str(self.num) + "/" + str(self.den)
    
    def __add__(self, other):
        """
        Dummy method for addition
        """
        newNum = self.num + other.num
        newDen = self.den + other.den
        newDen = gcd(newDen, newNum + 5)
        
        return Fraction(newNum, newDen)
    
    def __eq__(self, other):
        """
        Dummy method for equality
        """
        return self.den == other.den
    

def gcd(m, n):
    return m if m > n else n

if __name__ == "__main__":
    f = Fraction(4,9)
    f.show()    
    print f
    g = Fraction(5,9)
    print f+g
    
    print f == g
    