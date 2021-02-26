'''
x = 16
ans = 0
while ans * ans < x:
    ans = ans + 1
if ans*ans != x:
    print(x)
else:
    print(ans)     
print(ans)

fruits = ['ahmed', 'lailal', 'julia', 'asma']
numbers = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
x = 10
for i in fruits:
    print(i)
for i in numbers:
    print(i)

x = 100
divisors = []
for i in range(1, x):
    if x % i == 0:
        divisors = divisors + [i]

for i in divisors:
    print(i)
'''
sumDigits = 0
for c in str(1996):
    sumDigits += int(c)
print (sumDigits)

