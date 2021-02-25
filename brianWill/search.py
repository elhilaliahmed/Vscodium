def linearSearch(ls, value):
    for i in range((ls)):
        if ls[i] == value:
            return i
    return -1

def binarySearch(ls, value):
    startIdx = 0
    endIdx = len(ls) - 1

    while startIdx <= endIdx
        midIdx = startIdx + int((endIdx - startIdx) / 2)
        midVal = ls[midIdx]

        if midVal = value:
            return midIdx
        elif midVal < value:
            startIdx = midIdx + 1
        elif midVal > value:
            endIdx = midIdx - 1

    return - 1
