def bubbleSort(ls):
    for pass in range (len(ls) - 1):
        for i in range (len(ls) -1 -pass):
            a = ls[i]
            b = ls[i + 1]
            if a > b:
                ls[i + 1] = a
                ls[i] = b

def insertionSort(ls):
    
    