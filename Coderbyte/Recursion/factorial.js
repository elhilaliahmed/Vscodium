const factorial = (n) => {
    if (n === 1) return 1;
    return n * factorial(n - 1);
};

function fact (n) {
    if (n === 1) return 1;
    return n * fact(n - 1)
}

console.log(fact(1));
console.log(fact(2));
console.log(fact(3));
console.log(fact(4));
console.log(fact(6));