const fib = (n) => {
    if (n <= 2) return 1;
    return fib(n - 1) + fib(n - 2);
}

function fibFun (n) {
    if (n <= 2) return 1;
    return fibFun(n - 1) + fibFun(n - 2);
}

console.log(fibFun(7))

// Time : O(2^n)
// Space: O(n)