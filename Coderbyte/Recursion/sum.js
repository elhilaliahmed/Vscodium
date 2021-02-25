// slow sum 
//  time O(n^2)
//  spaca O(n)
const slowSum = (array) => {

    if (array.length === 0) return 0;
    const rest = array.slice(1);
    return array[0] + slowSum(rest);
}

function sumFunc (array) {
    if (array.length === 0) return 0;
    return array[0] + sum(array.slice(1));
}

// slow sum 
//  time O(n)
//  spaca O(n)
const fastSum = (array, index) => {
    return sumIndex(array, 0);
}

const sumIndex =(array, index) => {
    if (index === array.length) return 0;
    return array[index] + sumIndex(array, index + 1)

}



const input = new Array(9000).fill(1);

// Testing the slowSum
const slowStart = Date.now();
console.log(slowSum(input));
const slowEnd = Date.now();
console.log(`n^2 finished in ${slowEnd - slowStart}ms`);

// Testing the fastsum
const fastStart = Date.now();
console.log(fastSum(input));
const fastEnd = Date.now();
console.log(`n finished in ${fastEnd - fastStart}ms`);

