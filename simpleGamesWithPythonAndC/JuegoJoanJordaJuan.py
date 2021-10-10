import random
prev_numX = random.randint(0,5)
while(1):
    i = 0
    lst1 = []
    lst2 = []
    lst = ["X","O"]
    while i < 5:
        lst1 = lst1 + [lst[random.randint(0,1)]]
        lst2 = lst2 + [lst[random.randint(0,1)]]
        i = i + 1
    act = lst1.count("X")
    next_numX = lst2.count("X")
    print("".join(lst1),"es",prev_numX,", por tanto","".join(lst2),"es ",end="")
    s = input()
    while s.isdigit() == False:
        print("Eso no es un valor entero, introduce un valor entero entre 0 y 5: ")
        s = input()
    if int(s) == act:
        break;
    else:
        print("No es ",s," es ",act,"prueba otra vez")
        prev_numX = next_numX
print("¡¡¡Correcto has acertado!!!")
