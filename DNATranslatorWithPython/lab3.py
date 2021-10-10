class readElement:

    def __init__(self,idRead, extra, read, qualities):
        self.idRead = idRead
        self.read = read
        self.extra = extra
        self.qualities = qualities
        self._parseExtraFields(self.extra)
        self._nucleotidePercentages(self.read)
        self.listAllFields()
    def _parseExtraFields(self, extra):
        self.pair, self.filtered, self.control, self.index = extra.split(":")

    def _nucleotidePercentages(self, read):
        self.length = len(read)
        self.pA = read.count("A")/ self.length
        self.pC = read.count("C") / self.length
        self.pG = read.count("G") / self.length
        self.pT = read.count("T") / self.length

    def listAllFields(self):
        print("ID: "+self.idRead+"\n")
        print("extra: " + self.extra + "\n")
        print("pair: " + self.pair + "\n")
        print("filtered: " + self.filtered + "\n")
        print("control: " + self.control + "\n")
        print("index: " + self.index + "\n")
        print("read: " + self.read + "\n")
        print("qualities: " + self.qualities + "\n")
        print("length: " + str(self.length) + "\n")
        print("pA: " + str(self.pA) + "\n")
        print("pC: " + str(self.pC) + "\n")
        print("pG: " + str(self.pG) + "\n")
        print("pT: " + str(self.pT) + "\n")

class readDatabase:

    def __init__(self):
        self.db = {}

    def _addElement(self, readElement):
        self.db[readElement.idRead] = readElement

    def parseFile(self,file):
        with open(file) as f_in:
            count = 0
            for linea in f_in:
                if count % 4 == 0:
                    linea_sp = linea.split(" ")
                    idRead = linea_sp[0]
                    extra = linea_sp[1]
                elif count % 4 == 1:
                    read = linea
                elif count % 4 == 2:
                    None
                elif count % 4 == 3:
                    qualities = linea
                    self._addElement(readElement(idRead, extra, read, qualities))
                count = count + 1

    def query(self, consulta):
        query = consulta.strip(" ")
        diccionario = {'cadena': ['LENGTH','PERCENTAGE'],'comp': ['<','>']}
        letras = ['A','C','T','G']
        if query.find(diccionario['cadena'][0])!=-1:
            if query.find(diccionario['comp'][0]) != -1:
                n = float(query[query.find(diccionario['comp'][0])+1:])
                for i in self.db:
                    if float(self.db[i].length) < n:
                        print(self.db[i].idRead)
            elif query.find(diccionario['comp'][1]) != -1:
                n = float(query[query.find(diccionario['comp'][1]) + 1:])
                for i in self.db:
                    if float(self.db[i].length) > n:
                        print(self.db[i].idRead)
        elif query.find(diccionario['cadena'][1])!=-1:
            d2 = diccionario.items()
            for j in letras:
                if query.find(j) == 0:
                    if query.find(diccionario['comp'][0]) != -1:
                        n = float(query[query.find(diccionario['comp'][0]) + 1:])
                        for i in self.db:
                            if j == letras[0]: 
                                if float(self.db[i].pA) < n:
                                    print(self.db[i].idRead)
                            elif j == letras[1]:
                                if float(self.db[i].pC) < n:
                                    print(self.db[i].idRead)
                            elif j == letras[2]:
                                if float(self.db[i].pT) < n:
                                    print(self.db[i].idRead) 
                            elif j == letras[3]:
                                if float(self.db[i].pG) < n:
                                    print(self.db[i].idRead)
                    elif query.find(diccionario['comp'][1]) != -1:
                        n = float(query[query.find(diccionario['comp'][1]) + 1:])
                        for i in self.db:
                            if j == letras[0]: 
                                if float(self.db[i].pA) > n:
                                    print(self.db[i].idRead)
                            elif j == letras[1]:
                                if float(self.db[i].pC) > n:
                                    print(self.db[i].idRead)
                            elif j == letras[2]:
                                if float(self.db[i].pT) > n:
                                    print(self.db[i].idRead) 
                            elif j == letras[3]:
                                if float(self.db[i].pG) > n:
                                    print(self.db[i].idRead)
        else:
            print("La sintaxis no corresponde con la BNF")


