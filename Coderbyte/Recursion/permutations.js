const permutations = (elements) => {
    if (elements.length === 0) return [[]];

    const firstEl = elements[0];
    const rest = elements.slice(1);

    const permsWithoutFirst = permutations(rest);
    const allPermutations = [];
    permsWithoutFirst.forEach(perm => {
        for (let i = 0; i <= perm.length; i++) {
            const permWithoutFirst = [...perm.slice(0, i), firstEl, ...perm.slice(i)]
            allPermutations.push(permWithoutFirst)
        }
    });
    return allPermutations;
}

console.log(permutations(['a', 'b', 'c']))
console.log(permutations(['a', 'b']))
console.log(permutations(['a']))
console.log(permutations([]))

// Time: O(n!)
// Space: O(n^2)