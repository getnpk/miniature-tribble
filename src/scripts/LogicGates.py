class LogicGate:
    def __init__(self, n):
        self.label = n
        self.output = None
        
    def getLabel(self):
        return self.label
    
    def getOutput(self):
        self.output = self.performGateLogic()
        return self.output
    
    

class BinaryGate(LogicGate):
    
    def __init__(self,n):
        LogicGate.__init__(self, n)
        
        self.pinA = None
        self.pinB = None
        
    def getPinA(self):
        if self.pinA == None:
            return int(input("Enter PIN A input for gate " + self.getLabel() + "--->"))
        else:
            return self.pinA.getFrom().getOutput()
        
    def getPinB(self):
        if self.pinB == None:
            return int(input("Enter PIN B input for gate " + self.getLabel() + "--->"))
        else:
            return self.pinB.getFrom().getOutput()
    
    def setNextPin(self, source):
        if self.pinA == None:
            self.pinA = source
        elif self.pinB == None:
            self.pinB = source
        else:
            raise RuntimeError("Pins are already connected!")
    

class UniaryGate(LogicGate):
    def __init__(self,n):
        LogicGate.__init__(self,n)
        self.pin = None
        
    def getPin(self):
        if self.pin == None:
            return int(input("Enter Pin input for gate "+self.getName()+"-->"))
        else:
            return self.pin.getFrom().getOutput()

    def setNextPin(self,source):
        if self.pin == None:
            self.pin = source
        else:
            raise RuntimeError("No empty pins!")
    

class AndGate(BinaryGate):
    def __init__(self, n):
        BinaryGate.__init__(self, n)
    
    def performGateLogic(self):
        a = self.getPinA()
        b = self.getPinB()
        
        if a==1 and b==1:
            return 1
        else:
            return 0
        

class OrGate(BinaryGate):
    def __init__(self, n):
        BinaryGate.__init__(self, n)
    
    def performGateLogic(self):
        a = self.getPinA()
        b = self.getPinB()
        
        if a==1 or b==1:
            return 1
        else:
            return 0


class NotGate(UniaryGate):
    def __init__(self, n):
        UniaryGate.__init__(self, n)
    
    def performGateLogic(self):
        a = self.getPin()
        
        if a==1:
            return 0
        else:
            return 1

class Connector:
    def __init__(self, fromGate, toGate):
        self.fromGate = fromGate
        self.toGate = toGate
        
        toGate.setNextPin(self)
        
    def getFrom(self):
        return self.fromGate
    
    def getTo(self):
        return self.toGate
    
        

if __name__ == "__main__":
   g1 = AndGate("G1")
   g2 = AndGate("G2")
   g3 = OrGate("G3")
   g4 = NotGate("G4")
   
   c1 = Connector(g1,g3)
   c2 = Connector(g2,g3)
   c3 = Connector(g3,g4)
   
   print(g4.getOutput())
