def square(x):
  return x * x

print(square(5))

def printList(list):
    for x in list:
        print(x)

def fib(x):
    if (x <= 2):
        return x
    return fib(x - 1) + fib(x - 2)

def sqrt(x):
    return x * x

fruits = ["apple", "banana", "cherry", "orange"]

printList(fruits)

print(sqrt(-5))

print(fib(5))

def solve (numLegs, numHeads):
    for numChicks in range(0, numHeads + 1):
        numPigs = numHeads - numChicks
        totalLegs = 4 * numPigs + 2 * numChicks
        if totalLegs == numLegs:
            return[numPigs, numChicks]
    return[None, None]

print(solve(20,56))

